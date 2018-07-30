(function() {
  var home = window.home || (window.home = {});

  // 初期動作
  $(function($) {
    initialize();
  });

  // イベントハンドラー
  $(document).on('click', '.btnDownload', clickDownloadBtn);

  /**
   * 初期処理
   */
  function initialize() {
    // お知らせ情報を取得
    var info = {
      'key' : 'value'
    }
    request.home.getHomeInfo(info, createInfoTable);
  }

  /**
   * お知らせ情報のテーブルを作成
   */
  function createInfoTable(result) {
    var infoList = result.data.informationList;
    if (infoList && infoList.length > 0) {
      for (var i = 0; i < infoList.length; i++) {
        var infoTags = '<tr><td class="informationDate"></td><td class="information"></td></tr>';
        $('.informationList').append(infoTags);
        $('.informationList>tr').eq(i).find('.informationDate').text(infoList[i].fromdate);
        var infoTitle = $('.informationList>tr').eq(i).find('.information');
        infoTitle.html(infoList[i].title);
        // infoLevelからマーキングを行う
        var infoLevel = infoList[i].informationlevel;
        if (infoLevel == "1") {
          infoTitle.addClass('warning');
        } else if (infoLevel == "2") {
          infoTitle.addClass('danger');
        }
      }
    } else {
      var infoNullTags = '<td colspan="2"><span class="nullInfoList">お知らせがありません</span></td>';
      $('.informationList').append(infoNullTags);
    }
  }

  /**
   * 「ダウンロード」ボタンクリック処理
   */
  function clickDownloadBtn(){
    var paramObj = {
      'attribute1' : 'パラメータ1',
      'attribute2' : 'パラメータ2',
      'attribute3' : 'パラメータ3'
    };

    request.servlet.download('/delegate/csv-dl', paramObj);
  }

})();
