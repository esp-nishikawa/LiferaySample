(function() {
  var request = window.request || (window.request = {});

  // 初期動作
  $(function($) {
  });

  // リクエスト多重制御フラグ（0:未処理、1：処理中）
  var processFlag = 0;

  $.extend(request, {

    home : {
      /**
       * お知らせ情報を取得
       */
      getHomeInfo : function(info, callback) {
        requestService('/Sample-portlet.home/get-home-info', {info : info}, callback);
      }
    },

    servlet : {
      /**
       * ダウンロード
       */
      download : function(url, paramObj) {
        if (processFlag != 0) {
          return;
        }
        processFlag = 1;

        var xhr = new XMLHttpRequest();
        xhr.open('POST', url, true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
        xhr.responseType = 'blob';
        xhr.onload = onloadDownload;
        if (paramObj) {
          xhr.send($.param(paramObj));
        } else {
          xhr.send();
        }
      }
    }
  });

  /**
   * Serviceの実行
   */
  function requestService(cmd, paramObj, callback) {
    if (processFlag != 0) {
      return;
    }
    processFlag = 1;

    try {
      window.parent.Liferay.Service(cmd, paramObj, function(result) {
        processFlag = 0;

        if (result.status == "true") {
          callback(result);
        } else {
          handleException(result.exceptionInfo);
        }
      }, function(exception) {
        processFlag = 0;
        handleException(exception);
      });
    } catch (e) {
      window.location.reload();
    }
  };

  /**
   * 例外のハンドリング
   */
  function handleException(exception) {
    if (exception === "java.lang.SecurityException") {
      common.showAlertDialog(null, 'セッションが切断されました。',
        function() { parent.location.href = '/c/portal/logout'; } );
    } else {
      common.showAlertDialog(null, 'エラーが発生しました。');
    }
  };

  /**
   * ダウンロード完了時の処理
   */
  function onloadDownload(e) {
    processFlag = 0;

    if (this.status === 200) {
      var contentDisposition = this.getResponseHeader('Content-Disposition');
      var blob = this.response;
      var userAgent = window.navigator.userAgent.toLowerCase();

      if (userAgent.indexOf('msie') != -1 || userAgent.indexOf('trident/7') != -1 || userAgent.indexOf('edge') != -1) {
        ieFileDownload(contentDisposition, blob);
      } else if (userAgent.indexOf('safari') != -1 && userAgent.indexOf('chrome') == -1 && userAgent.indexOf('android') == -1) {
        iosFileDownload(contentDisposition, blob);
      } else if (userAgent.indexOf('chrome') != -1 && userAgent.indexOf('android') != -1 && userAgent.substr(userAgent.indexOf('android'), 9) >= 'android 7') {
        androidFileDownload(contentDisposition, blob);
      } else {
        chromeFileDownload(contentDisposition, blob);
      }
    } else {
      common.showAlertDialog(null, 'ダウンロードに失敗しました');
    }
  }

  /**
   * Chrome用ファイルダウンロード
   */
  function chromeFileDownload(contentDisposition, blob) {
    var a = document.createElement('a');
    a.download = decodeURI(contentDisposition);
    var blobUrl = window.URL.createObjectURL(blob);
    a.href = blobUrl;
    a.click();
    window.URL.revokeObjectURL(blobUrl);
  }

  /**
   * android用ファイルダウンロード
   */
  function androidFileDownload(contentDisposition, blob) {
    var reader = new FileReader();
    reader.onload = function(e) {
      var a = document.createElement('a');
      a.download = decodeURI(contentDisposition);
      a.href = reader.result;
      a.target = '_top';
      a.click();
    }
    reader.readAsDataURL(blob);
  }

  /**
   * iOS用ファイルダウンロード
   */
  function iosFileDownload(contentDisposition, blob) {
    var reader = new FileReader();
    reader.onload = function(e) {
      var a = document.createElement('a');
      a.href = reader.result;
      a.target = '_top';
      a.click();
    }
    reader.readAsDataURL(blob);
  }

  /**
   * IE用ファイルダウンロード
   */
  function ieFileDownload(contentDisposition, blob) {
    window.navigator.msSaveBlob(blob, decodeURI(contentDisposition));
  }

})();
