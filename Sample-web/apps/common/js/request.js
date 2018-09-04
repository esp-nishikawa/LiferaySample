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
      var fileName = decodeURI(contentDisposition);
      var blob = this.response;

      if (window.navigator.msSaveBlob) { // for IE
        window.navigator.msSaveBlob(blob, fileName);
      } else {
        var blobUrl = window.URL.createObjectURL(blob);
        var link = document.createElement('a');
        link.href = blobUrl;
        link.setAttribute('download', fileName);
        document.body.appendChild(link);
        link.click();
        document.body.removeChild(link);
        window.URL.revokeObjectURL(blobUrl);
      }
    } else {
      common.showAlertDialog(null, 'ダウンロードに失敗しました');
    }
  }

})();
