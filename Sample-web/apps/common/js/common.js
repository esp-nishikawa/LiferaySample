(function(){
  var common = window.common || (window.common = {});

  // 初期動作
  $(function($) {
  });

  // イベントハンドラー
  $(document).on('keydown', keydownDialog); // キーボードダウン
  
  $.extend(common, {

    moveViewTop: function(){
      $('body',parent.document).scrollTop(0);
    },

    /**
     * 連想配列をkey値でソート
     */
    sortAssociativeArray: function(list, key, order) {
      if(list == null || typeof list === "undefined" || (list instanceof Object && !(list instanceof Array))){
        return list;
      }
      if(order == 'asc'){
        list.sort(function(a, b){
          a = a[key].toString().toLowerCase();
          b = b[key].toString().toLowerCase();
          if(a < b) return -1;
          if(a > b) return 1;
          return 0;
        });  
      }else if(order == 'desc'){
        list.sort(function(a, b){
          a = a[key].toString().toLowerCase();
          b = b[key].toString().toLowerCase();
          if(a > b) return -1;
          if(a < b) return 1;
          return 0;
        });   
      }
      return list;
    },

    /**
     * サニタイジング対策（エスケープ）
     */
    toEscapeStr: function(str) {
      var i = 0;
      
      if ($.isEmptyObject(str)) {
        return str;
      }
      
      if (Array.isArray(str)) {
        for (i = 0; i < str.length; i++) {
          str[i] = this.toEscapeStr(str[i]);
        }
        
        return str;
      } else {
        return String(str).replace(/&/g, "&amp;")
        .replace(/"/g, "&quot;")
        .replace(/</g, "&lt;")
        .replace(/>/g, "&gt;")
        .replace(/'/g, "&#39;");
      }
    },

    /**
     * サニタイジング対策（元の文字に戻す）
     */
    escapeToStr: function(str) {
      var i = 0;
      
      if ($.isEmptyObject(str)) {
        return str;
      }
      
      if (Array.isArray(str)) {
        for (i = 0; i < str.length; i++) {
          str[i] = this.esccapeToStr(str[i]);
        }
        
        return str;
      } else {
        return String(str).replace(/&lt;/g, '<')
                          .replace(/&gt;/g, '>')
                          .replace(/&quot;/g, '"')
                          .replace(/&#39;/g, '\'')
                          .replace(/&amp;/g, '&');
      }
    },

    /**
     * 文字列のバイト数を取得する
     */
    countLength: function(str) { 
      var r = 0; 
      for (var i = 0; i < str.length; i++) { 
        var c = str.charCodeAt(i); 
        // Shift_JIS: 0x0 ～ 0x80, 0xa0 , 0xa1 ～ 0xdf , 0xfd ～ 0xff
        // Unicode : 0x0 ～ 0x80, 0xf8f0, 0xff61 ～ 0xff9f, 0xf8f1 ～ 0xf8f3
        if ( (c >= 0x0 && c < 0x81) || (c == 0xf8f0) || (c >= 0xff61 && c < 0xffa0) || (c >= 0xf8f1 && c < 0xf8f4)) { 
          r += 1; 
        } else { 
          r += 2; 
        } 
      } 
      return r; 
    },

    /**
     * 文字列に含まれる空白を取り除く
     */
    removeBlank: function(val) {
      return String(val).replace( /\s+/g, '' );
    },

    /**
     * 文字列に含まれる-(ハイフン)を取り除く
     */
    removeHyphen: function(val) {
      return String(val).replace( /[-‐－―ー]/g, '' );
    },

    /**
     * 文字列に含まれるカンマを取り除く
     */
    removeComma: function(val) {
      return String(val).replace(/,/g,'');
    },

    /**
     * 数値チェック
     */
    isNumber: function(str) {
      if (str.match( /[^0-9]+/ ) ) {
        return false;
      }
      return true;
    },

    /**
     * 半角数値チェック
     */
    isHalfNumber: function(str) {
      if (str.match( /[^0-9]+$/ ) ) {
        return false;
      }
      return true;
    },

    /**
     * 全角チェック
     */
    isZenkaku: function(str) {
      if(str.match(/^[^ -~｡-ﾟ]*$/)){
        return true;
      }
      return false;
    },

    /**
     * 禁則文字チェック
     */
    containsInvalidCharacter: function(str) {
      if (!str) {
        return true;
      }
      if(str.match('.*[￠£¦¬―№℡ⅠⅡⅢⅣⅤⅥⅦⅧⅨⅩⅰⅱⅲⅳⅴⅵⅶⅷⅸⅹ∑∟∥∮⊿①②③④⑤⑥⑦⑧⑨⑩⑪⑫⑬⑭⑮⑯⑰⑱⑲⑳〝〟㈱㈲㈹㊤㊥㊦㊧㊨㌃㌍㌔㌘㌢㌣㌦㌧㌫㌶㌻㍉㍊㍍㍑㍗㍻㍼㍽㍾㎎㎏㎜㎝㎞㎡㏄㏍丨仡仼伀伃伹佖侊侒侔侚俉俍俠俿倞倢偀偂偆偰傔僘僴兊兤冝冾凬刕剝劜劦劯勀勛匀匇匤卲厓厲叝咊咜咩哿啞喆嚙囊坙坥垬埇埈塡增墲夋奓奛奝奣妤妺孖寀寘寬尞屛屢岦岺峵崧嵂嵓嵭嶸嶹巐弡弴彅彧德忞恝悅悊惕惞惲愑愠愰愷憘戓抦揵搔摑摠撝擎攢敎昀昉昕昞昤昮昱昻晗晙晥晳暙暠暲暿曺曻朎杦枻柀栁栅桄桒梎棈棏楨榘槢樰橆橫橳橾櫢櫤毖氿汜汯沆泚洄浯涇涖涬淏淲淸淼渧渹渼湜溿潑澈澵濵瀅瀆瀇瀨炅炫炻焄焏焰煆煇煜燁燾犱犾猤獷玽珉珒珖珣珵琇琦琩琪琮瑢璉璟甁甯畯瘦皂皛皜皞皦睆砡硎硤硺礰禔禛禱竑竧竫箞簞絈絜綠綷緖繈繒繡繫纊罇羡腁茁荆荢荿菇菶萊葈蒴蓜蔣蕓蕙蕫薰蟬蠇蠟裵褜訒訷詹誧誾諟諶譓譿賰賴贒赶軀軏遧郞鄕鄧醬醱釗釚釞釤釥釭釮鈆鈊鈐鈹鈺鈼鉀鉎鉑鉙鉧鉷鉸銈銧鋐鋓鋕鋗鋙鋠鋧鋹鋻鋿錂錝錞錡錥鍈鍗鍰鎤鏆鏞鏸鐱鑅鑈閒隝隯霳霻靃靍靏靑靕頰頹顗顚顥餧馞驎驒髙髜魲魵鮏鮱鮻鰀鵫鵰鷗鸙麴麵黑齼朗隆﨎﨏塚﨑晴﨓﨔凞猪益礼神祥福靖精羽﨟蘒﨡諸﨣﨤逸都﨧﨨﨩飯飼館鶴＂＇￠￡￢￤�].*')){
        return false;
      }
      return true;
    },

    /**
     * alertDialogの表示
     */
    showAlertDialog: function(title, message, onClick) {
      $('body').append(createAlertDialog());
      if (title) $('.alertDialog .commonModal-title').text(title);
      if (message) $('.alertDialog .commonModal-body').html(common.toEscapeStr(message).replace(/\n/g,'<br>'));
      $('.alertDialog .commonBtn-ok').text('OK');
      $('.alertDialog .commonBtn-ok').on('click', closeAlertDialog);
      if (onClick) $('.alertDialog .commonBtn-ok').on('click', onClick);
      $('.alertDialog').show();
      $('.alertDialog .commonBtn-ok').focus();
      $('.alertDialog .commonModal-dialog').css('top', dialogPositionY($('.alertDialog')) + 'px');
    },

  });

  /**
   * キーボードダウン時の処理
   */
  function keydownDialog(e) {
    var key = 'which' in e ? e.which : e.keyCode;

    if ($('.alertDialog').length) {
      // Escボタンがキーダウンされた場合、ダイアログを閉じる
      if (key == 27) {
        $('.alertDialog .commonBtn-ok').trigger('click');
      }
      // Enter、Spaceボタンがキーダウンされた場合、ダイアログ以外の操作を無効にする
      if (key == 13 || key == 32) {
        if ($('.alertDialog .commonBtn-ok').is(':focus')) {
          $('.alertDialog .commonBtn-ok').trigger('click');
        }
        return false;
      }
    }
  }

  /**
   * alertDialogを閉じる
   */
  function closeAlertDialog() {
    $('.alertDialog').hide();
    $('.alertDialog').remove();
    $('.commonModal-overlay').remove();
  }

  /**
   * alertDialogの生成
   */
  function createAlertDialog() {
    var tags = '<div class="alertDialog" tabindex="-1" aria-hidden="true">' +
      '<div class="commonModal-dialog">' +
        '<div class="commonModal-content">' +
          '<div class="commonModal-header">' +
            '<div class="commonModal-title">' +
            '</div>' +
          '</div>' +
          '<div class="commonModal-body">' +
          '</div>' +
          '<div class="commonModal-footer">' +
            '<button type="button" class="commonBtn commonBtn-primary commonBtn-ok">' +
            '</button>' +
          '</div>' +
        '</div>' +
      '</div>' +
    '</div>' +
    '<div class="commonModal-overlay"></div>';

    return tags;
  }

  /**
   * ダイアログの表示位置Y軸を計算
   */
  function dialogPositionY(element){
    var result = 0;
    var dialog = $(element).find('.commonModal-dialog');
    if (dialog.length) {
      // スクロール量を取得
      var scrollY = $('body',parent.window).prevObject.get(0).pageYOffset;
      // 表示領域のサイズを取得
      var elementY = $(element).innerHeight();
      // ダイアログのサイズを取得
      var dialogY = dialog.outerHeight(true);
      // 最大値を取得
      var max = elementY - dialogY;
      if (max < 0) {
        max = 0;
      }

      // 表示位置を計算
      if (max > scrollY) {
        result = scrollY;
      } else {
        result = max;
      }
    }

    return result;
  }

})();
