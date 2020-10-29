function flooranimate(){
    var _wrapone = $("#wrap01");
    var _wraptwo = $("#wrap02");
    var _wrapthree = $("#wrap03");
    var _wrapfour = $("#wrap04");
    var _wrapfive = $("#wrap05");
    var _wrapsix = $("#wrap06");
    var _wrapseven = $("#wrap07");
    var _wrapeight = $("#wrap08");
    var _wrapnine = $("#wrap09");
    var _wrapten = $("#wrap10");
    var _menu = $("#menu");
    var _li = _menu.find("li");
    $(window).scrollTop(178);
    return {
        start:function(){
            var _this = this;
            this.menu();
            this.onescreen();
            this.i = 0;
            this.j = 0;
            this.timer = null;
            this.timer2 = null;

            var _wrap = $(".beauty-wrap");
            var wh = $(window).height();
            if(wh<750){
                wh=760
            };
            var hf_wh = wh/2;
            _menu.css({"top":hf_wh-162})
            _wrap.height(wh);
            var ie = !!window.ActiveXObject;
            if(ie){
                _wrap.find("*").not(".info").not(".girl-h").show().css({"opacity":1});
                _wrap.find(".line").width(1200);
                $(window).scroll(function(){
                    var top = $(this).scrollTop();
                    if(top<hf_wh){
                        _menu.attr("class","gray");
                        _li.eq(0).addClass("active").siblings().removeClass("active");
                    };
                    if(top>hf_wh){
                        _menu.attr("class","white");
                        _li.eq(1).addClass("active").siblings().removeClass("active");
                    };
                    if(top>wh+hf_wh){
                        _menu.attr("class","gray");
                        _li.eq(2).addClass("active").siblings().removeClass("active");
                    };
                    if(top>2*wh+hf_wh){
                        _this.fourscreen();
                        _menu.attr("class","white");
                        _li.eq(3).addClass("active").siblings().removeClass("active");
                    };
                    if(top>3*wh+hf_wh){
                        _menu.attr("class","gray");
                        _li.eq(4).addClass("active").siblings().removeClass("active");
                    };
                    if(top>4*wh+hf_wh){
                        _menu.attr("class","white");
                    };
                    if(top>5*wh+hf_wh){
                        _menu.attr("class","gray");
                        _li.eq(5).addClass("active").siblings().removeClass("active");
                    };
                    if(top>6*wh+hf_wh){
                        _menu.attr("class","white");
                        _li.eq(6).addClass("active").siblings().removeClass("active");
                    };
                    if(top>7*wh+hf_wh){
                        _menu.attr("class","gray");
                        _li.eq(7).addClass("active").siblings().removeClass("active");
                    };
                    if(top>8*wh+hf_wh){
                        _menu.attr("class","white");
                        _li.eq(8).addClass("active").siblings().removeClass("active");
                    };
                })
                //_wrap.find("a").show().css({"opacity":1});
                return false;
            }
            $(window).scroll(function(){
                var top = $(this).scrollTop();
                if(top<hf_wh){
                    _menu.attr("class","gray");
                    _li.eq(0).addClass("active").siblings().removeClass("active");
                };
                if(top>hf_wh){
                    _this.twoscreen();
                    _menu.attr("class","white");
                    _li.eq(1).addClass("active").siblings().removeClass("active");
                };
                if(top>wh+hf_wh){
                    _this.threescreen();
                    _menu.attr("class","gray");
                    _li.eq(2).addClass("active").siblings().removeClass("active");
                };
                if(top>2*wh+hf_wh){
                    _this.fourscreen();
                    _menu.attr("class","white");
                    _li.eq(3).addClass("active").siblings().removeClass("active");
                };
                if(top>3*wh+hf_wh){
                    _this.fivescreen();
                    _menu.attr("class","gray");
                    _li.eq(4).addClass("active").siblings().removeClass("active");
                };
                if(top>4*wh+hf_wh){
                    _this.sixscreen();
                    _menu.attr("class","white");
                };
                if(top>5*wh+hf_wh){
                    _this.sevenscreen();
                    _menu.attr("class","gray");
                    _li.eq(5).addClass("active").siblings().removeClass("active");
                };
                if(top>6*wh+hf_wh){
                    _this.eightscreen();
                    _menu.attr("class","white");
                    _li.eq(6).addClass("active").siblings().removeClass("active");
                };
                if(top>7*wh+hf_wh){
                    _this.ninescreen();
                    _menu.attr("class","gray");
                    _li.eq(7).addClass("active").siblings().removeClass("active");
                };
                if(top>8*wh+hf_wh){
                    _this.tenscreen();
                    _menu.attr("class","white");
                    _li.eq(8).addClass("active").siblings().removeClass("active");
                };
            })
        },
        menu:function(){
            _li.click(function(){
                $(this).addClass("active").siblings().removeClass("active");
            });
        },
        onescreen:function(){
            var _gx_1 = _wrapone.find(".gx01");
            var _gx_2 = _wrapone.find(".gx02");
            var _zi = _wrapone.find(".zi01");
            var _qs_1 = _zi.find(".qs01");
            var _qs_2 = _zi.find(".qs02");
            var _girl = _wrapone.find(".girl01");
            var _star = _wrapone.find(".star");
            this.one_an = {
                fn_2:[function(){
                    _gx_1.show().addClass("rotate01");
                    _gx_2.show().addClass("rotate02");
                    _star.show();
                },1000]
            };
            _zi.show().addClass("fadeIn-fast");
            _qs_1.addClass("qs01-an");
            _qs_2.addClass("qs02-an");
            _girl.addClass("girl-an");
            this.setT(this.one_an);
        },
        twoscreen:function(){
            var _line = _wraptwo.find(".line");
            var _xmn = _wraptwo.find(".xmn");
            var _xnr = _wraptwo.find(".xnr");
            var _ban = _wraptwo.find(".ban01");
            var _hzs = _wraptwo.find(".hzs");
            var _add = _wraptwo.find(".add");
            var _ry = _wraptwo.find(".ry");
            var _star = _wraptwo.find(".star");
            var _jt = _wraptwo.find(".jt01").find(".sjt");
            var _jtz = _wraptwo.find(".jt01").find("p");
            var _zi = _wraptwo.find(".zi02");
            var _pd = _wraptwo.find(".pd");
            var _wt = _wraptwo.find(".wt");
            this.two_an = {
                fn_1:[function(){
                    _xmn.addClass("scaleIn");
                },340],
                fn_2:[function(){
                    _xnr.show().addClass("fadeIn-fast");
                    _wt.show().addClass("wt")
                },800],
                fn_3:[function(){
                    _ban.css({opacity:1}).addClass("fz");
                },1000],
                fn_4:[function(){
                    _hzs.show().addClass("fadeIn");
                },1200],
                fn_5:[function(){
                    _add.show().addClass("fadeIn");
                },1400],
                fn_6:[function(){
                    _ry.show().addClass("fadeIn");
                },1600],
                fn_7:[function(){
                    _jt.show().addClass("fadeIn");
                },1800],
                fn_9:[function(){
                    _jtz.show();
                },2000],
                fn_10:[function(){
                    _star.show();
                    _pd.fadeIn();
                },2500]
            }

            _line.addClass("line-an");
            _zi.show().addClass("fadeIn-fast");
            this.setT(this.two_an);
        },
        threescreen:function(){
            var _line = _wrapthree.find(".line");
            var _table = _wrapthree.find(".table");
            var _girl = _wrapthree.find(".girl");
            var _cyc = _wrapthree.find(".circle");
            var _pd = _wrapthree.find(".pd");
            var _ban = _wrapthree.find(".t2");
            var _face01 = _wrapthree.find(".face1");
            var _t1 = _wrapthree.find(".t1");
            var _facet1 = _wrapthree.find(".face1-t1");
            var _face2 = _wrapthree.find(".face2");
            var _face2t1 = _wrapthree.find(".face2-t1");
            var _face2t2 = _wrapthree.find(".face2-t2");
            var _arrw = _wrapthree.find(".arrow");
            var _this = this;
            this.three_an = {
                fn_1:[function(){
                    _table.show().addClass("fadeIn-fast");
                    _girl.eq(0).addClass("girl1-an");
                },200],
                fn_2:[function(){
                    _pd.fadeIn();
                },700],
                fn_3:[function(){
                    clearInterval(_this.timer2);
                    _cyc.eq(0).show().addClass("fadeIn-fast");
                    _this.timer2 = setInterval(function(){
                        _this.i++;
                        if(_this.i>5){
                            return false;
                        }else{
                            _cyc.eq(_this.i).show().addClass("fadeIn-fast");
                            _girl.eq(_this.i).show().siblings(".girl").hide();
                        }
                    },200);
                },900],
                fn_7:[function(){
                    _ban.css({opacity:1}).addClass("t2-an");
                },1200],
                fn_8:[function(){
                    _face01.show().addClass("fadeIn");
                    _facet1.show().addClass("fadeIn");
                },1400],
                fn_9:[function(){
                    _arrw.show().addClass("fadeIn");
                },1600],
                fn_10:[function(){
                    _face2.show().addClass("fadeIn");
                },1800],
                fn_11:[function(){
                    _face2t1.show().addClass("fadeIn");
                    _face2t2.show().addClass("fadeIn");
                },2000]
            };
            _cyc.each(function(a){
                $(this).mouseover(function(){
                    _girl.eq(a).show().siblings(".girl").hide();
                })
            });
            _line.addClass("line-an");
            _t1.show().addClass("fadeIn-fast");
            this.setT(this.three_an)
        },
        fourscreen:function(){
            var _table = _wrapfour.find(".table");
            var _line = _wrapfour.find(".line");
            var _t1 = _wrapfour.find(".t1");
            var _arw = _wrapfour.find(".table-arrow");
            var _tat = _wrapfour.find(".table-arrow-t");
            var _win = _wrapfour.find(".window");
            var _eye = _wrapfour.find(".eye");
            var _eyea1 = _wrapfour.find(".eye-arrow1");
            var _eyea2 = _wrapfour.find(".eye-arrow2");
            var _eyeat = _wrapfour.find(".eye-arrow2-t");
            this.four_an = {
                fn_1:[function(){
                    _table.addClass("table-an");
                },200],
                fn_2:[function(){
                    _arw.show().addClass("fadeIn-fast");
                },400],
                fn_3:[function(){
                    _tat.show().addClass("fadeIn-fast");
                },600],
                fn_4:[function(){
                    _win.addClass("win-an");
                },1000],
                fn_5:[function(){
                    _eye.addClass("eye-an");
                },1500],
                fn_6:[function(){
                    _eyea2.show().addClass("fadeIn");
                },2500],
                fn_7:[function(){
                    _eyeat.show().addClass("fadeIn");
                },2700],
                fn_8:[function(){
                    _eyea1.show().addClass("fadeIn");
                },2900]
            }
            _t1.show().addClass("fadeIn-fast");
            _line.addClass("line-an");
            this.setT(this.four_an)
        },
        fivescreen:function(){
            var _line = _wrapfive.find(".line");
            var _draw = _wrapfive.find(".drawing");
            var _t2 = _wrapfive.find(".t2");
            var _t1 = _wrapfive.find(".t1");
            var _ban = _wrapfive.find(".board");
            var _face = _wrapfive.find(".face");
            var _facet = _wrapfive.find(".face-t");
            var _arw = _wrapfive.find(".arrow");
            var _arwt = _wrapfive.find(".arrow-t");
            var _t3 = _wrapfive.find(".t3");
            var _eyeb2 = _wrapfive.find(".eyebrow-2");
            var _eyeb = _wrapfive.find(".eyebrow");
            var _eyeb3 = _wrapfive.find(".eyebrow-3");
            this.five_an = {
                fn_1:[function(){
                    _draw.addClass("drawing-an");
                    _t2.show().addClass("fadeIn-fast");
                },200],
                fn_2:[function(){
                    _ban.css({opacity:1}).addClass("board-an");
                },1000],
                fn_3:[function(){
                    _t3.show().addClass("fadeIn");
                    _eyeb3.addClass("eyebrow-an");
                },1500],
                fn_4:[function(){
                    _arwt.show().addClass("fadeIn");
                },2000],
                fn_5:[function(){
                    _arw.show().addClass("fadeIn-fast");
                },2200],
                fn_6:[function(){
                    _face.show().addClass("fadeIn");
                },2700],
                fn_7:[function(){
                    _facet.show().addClass("fadeIn");
                },3200]
            }
            _line.addClass("line-an");
            _t1.show().addClass("fadeIn-fast");
            this.setT(this.five_an)
        },
        sixscreen:function(){
            var _line = _wrapsix.find(".line");
            var _fly = _wrapsix.find(".fly");
            var _arw = _wrapsix.find(".arrow");
            var _arwt = _wrapsix.find(".arrow-t");
            var _girl = _wrapsix.find(".girl");
            var _t1 = _wrapsix.find(".t1");
            var _girlt1 = _wrapsix.find(".girl-t");
            var _girlt2 = _wrapsix.find(".girl-t2");
            var _eyet2 = _wrapsix.find(".eye-t2");
            var _eyet1 = _wrapsix.find(".eye-t1");
            var _ban = _wrapsix.find(".board");
            var _eye = _wrapsix.find(".eye");
            var _star = _wrapsix.find(".star");
            var _pd = _wrapsix.find(".pd");
            var _this = this;
            this.six_an = {
                fn_1:[function(){
                    _arw.addClass("arrow-an");
                },3900],
                fn_2:[function(){
                    _arwt.show().addClass("fadeIn-fast");
                },4000],
                fn_3:[function(){
                    _girl.addClass("girl-an");
                },250],
                fn_4:[function(){
                    _girlt1.show().addClass("fadeIn-fast");
                },550],
                fn_5:[function(){
                    _girlt2.show().addClass("fadeIn-fast");
                },750],
                fn_6:[function(){
                    _eyet2.show().addClass("fadeIn");
                },1500],
                fn_7:[function(){
                    _eyet1.show().addClass("fadeIn");
                },2000],
                fn_8:[function(){
                    _ban.show().addClass("fadeIn-fast");
                },2500],
                fn_12:[function(){
                    _fly.addClass("s4-2-fly");
                    clearInterval(_this.timer);
                    _this.timer = setInterval(function(){
                        _this.j++;
                        if(_this.j>2){
                            _star.show();
                        }
                        if(_this.j>3){
                            _this.j = 0;
                            _star.hide();
                        }
                        _eye.eq(_this.j).fadeIn().siblings().fadeOut();
                    },1000);
                    _pd.fadeIn();
                },3000]
            }
            _line.addClass("line-an");
            //_fly.addClass("s4-2-fly");
            _t1.show().addClass("fadeIn-fast");
            this.setT(this.six_an)
        },
        sevenscreen:function(){
            var _line = _wrapseven.find(".line");
            var _t1 = _wrapseven.find(".t1");
            var _t2 = _wrapseven.find(".t2");
            var _mirror = _wrapseven.find(".mirror");
            var eyeb1 = _wrapseven.find(".eyebrow1");
            var eyeb2 = _wrapseven.find(".eyebrow2");
            var eyea1 = _wrapseven.find(".eyebrow1-arrow");
            var eyea2 = _wrapseven.find(".eyebrow2-arrow");
            var _pd = _wrapseven.find(".pd");
            var _f1 = _wrapseven.find(".finger1");
            var _f2 = _wrapseven.find(".finger2");
            this.seven_an={
                fn_1:[function(){
                    _mirror.show().addClass("scan");
                },200],
                fn_2:[function(){
                    _t2.show().addClass("fadeIn-fast");
                },500],
                fn_3:[function(){
                    eyeb1.show().addClass("scan-slow");
                },1000],
                fn_4:[function(){
                    eyea1.show().addClass("fadeIn-fast");
                },1200],
                fn_5:[function(){
                    eyeb2.show().addClass("scan-slow");
                },1500],
                fn_6:[function(){
                    eyea2.show().addClass("fadeIn-fast");
                },1700],
                fn_7:[function(){
                    _pd.fadeIn();
                },2000],
                fn_8:[function(){
                    _f1.addClass("arrow-right-finger1");
                },2500],
                fn_9:[function(){
                    _f2.addClass("arrow-right-finger2");
                },3500]
            };
            eyeb1.hover(function(){
                _f1.addClass("arrow-right-finger1-hover");
            },function(){
                _f1.removeClass("arrow-right-finger1-hover")
            })
            eyeb2.hover(function(){
                _f2.addClass("arrow-right-finger2-hover");
            },function(){
                _f2.removeClass("arrow-right-finger2-hover")
            })
            _t1.show().addClass("fadeIn-fast");
            _line.addClass("line-an");
            this.setT(this.seven_an);
        },
        eightscreen:function(){
            var _line = _wrapeight.find(".line");
            var _table = _wrapeight.find(".table");
            var _girl = _wrapeight.find(".girl");
            var _t2 = _wrapeight.find(".t2");
            var _t1 = _wrapeight.find(".t1");
            var _girlaw = _wrapeight.find(".girl-arrow");
            var _t3 = _wrapeight.find(".t3");
            var _baw = _wrapeight.find(".brush-arrow");
            var _bsh = _wrapeight.find(".brush");
            var _girlc = _wrapeight.find(".girl-circle");
            var _t4 = _wrapeight.find(".t4");
            var _faw = _wrapeight.find(".face-arrow");
            var _face = _wrapeight.find(".face");
            var _board = _wrapeight.find(".board");
            var _star = _wrapeight.find(".star");
            this.eight_an = {
                fn_1:[function(){
                    _table.fadeIn();
                    _girl.addClass("girl-an");
                    _t2.show().addClass("fadeIn-fast");
                },200],
                fn_4:[function(){
                    _t2.show().addClass("fadeIn-fast");
                },400],
                fn_5:[function(){
                    _girlaw.show().addClass("fadeIn-fast");
                },600],
                fn_6:[function(){
                    _t3.show().addClass("fadeIn-fast");
                },800],
                fn_7:[function(){
                    _baw.show().addClass("fadeIn-fast");
                },1000],
                fn_8:[function(){
                    _girlc.show().addClass("fadeIn-fast");
                },1200],
                fn_9:[function(){
                    _bsh.show().addClass("fadeIn-fast");
                },1400],
                fn_10:[function(){
                    _t4.show().addClass("fadeIn-fast");
                },1600],
                fn_11:[function(){
                    _faw.show().addClass("fadeIn-fast");
                },1800],
                fn_12:[function(){
                    _face.show().addClass("fadeIn");
                },2000],
                fn_13:[function(){
                    _board.fadeIn().addClass("rotate03");
                },3000],
                fn_14:[function(){
                    _star.show();
                },3500]
            }
            _line.addClass("line-an");
            _t1.show().addClass("fadeIn-fast");
            this.setT(this.eight_an)
        },
        ninescreen:function(){
            var _line = _wrapnine.find(".line");
            var _t1 = _wrapnine.find(".t1");
            var _t2 = _wrapnine.find(".t2");
            var _t4 = _wrapnine.find(".t4");
            var _t5 = _wrapnine.find(".t5");
            var _girl = _wrapnine.find(".girl");
            var _girl_bg = _wrapnine.find(".girl-bg-2");
            var _mou21 = _wrapnine.find(".mouth2-1");
            var _mou22 = _wrapnine.find(".mouth2-2");
            var _m2arw = _wrapnine.find(".mouth2-arrow");
            var _mouth12 = _wrapnine.find(".mouth1-2");
            var _t3 = _wrapnine.find(".t3");
            var _mouaw = _wrapnine.find(".mouth3-arrow");
            var _mouth3 = _wrapnine.find(".mouth3");
            var _star = _wrapnine.find(".star");
            var _pd = _wrapnine.find(".pd");
            this.nine_an = {
                fn_1:[function(){
                    _t4.show().addClass("fadeIn-fast");
                },200],
                fn_2:[function(){
                    _t5.show().addClass("fadeIn-fast");
                },300],
                fn_3:[function(){
                    _girl.show().addClass("fadeIn-fast");
                },400],
                fn_4:[function(){
                    _girl_bg.show().addClass("fog");
                },600],
                fn_5:[function(){
                    _mouth12.show().addClass("fadeIn");
                    _mou21.show().addClass("fadeIn");
                    _t3.show().addClass("fadeIn-fast");
                },800],
                fn_6:[function(){
                    _t2.show().addClass("fadeIn-fast");
                },1000],
                fn_7:[function(){
                    _m2arw.show();
                },1200],
                fn_9:[function(){
                    _mou22.fadeIn();
                    _mouaw.show().addClass("fadeIn-fast");
                },1600],
                fn_10:[function(){
                    _mouth3.show().addClass("fadeIn");
                },1800],
                fn_11:[function(){
                    _mouaw.show().addClass("fadeIn-fast");
                },2000],
                fn_12:[function(){
                    _pd.fadeIn();
                },2200],
                fn_13:[function(){
                    _star.show();
                },3000]

            };
            _t1.show().addClass("fadeIn-fast");
            _line.addClass("line-an");
            this.setT(this.nine_an)
        },
        tenscreen:function(){
            var _girl = _wrapten.find(".girl");
            var _light = _wrapten.find(".light");
            var _star = _wrapten.find(".star");
            var _finish = _wrapten.find(".finish");
            var _t = _wrapten.find(".t");
            var _go = _wrapten.find(".go");
            var _top = _wrapten.find(".top");
            var _email = _wrapten.find(".email");
            this.ten_an = {
                fn_1:[function(){
                    _light.fadeIn(500);
                },500],
                fn_2:[function(){
                    _star.show();
                },1000],
                fn_3:[function(){
                    _finish.show().addClass("fadeIn-fast");
                },1200],
                fn_4:[function(){
                    _finish.show().addClass("fadeIn-fast");
                },1200],
                fn_5:[function(){
                    _t.show().addClass("fadeIn-fast");
                },1400],
                fn_6:[function(){
                    _go.show().addClass("fadeIn-fast");
                },1600],
                fn_7:[function(){
                    _email.addClass("email-an");
                },2200],
                fn_8:[function(){
                    _top.css({"display":"block"}).addClass("go-top");
                },2700]
            }
            _girl.show().addClass("fadeIn-fast");
            this.setT(this.ten_an)
        },
        setT:function(an_que){
            $.each(an_que,function(a,arr){
                setTimeout(arr[0],arr[1]);
            });
        }
    }
}
$(function(){
    //图片预加载
    var _all = $("#all").find("*"),_arr = [],t_img,isLoad = true,rg = new RegExp("url"),
        fn = function(){ $("#load").remove();$("#all").show();flooranimate().start();};
    _all.each(function(){
        if(rg.test($(this).css("backgroundImage"))){
            var _url = $(this).css("backgroundImage");
            var _img = new Image();
            _url = _url.replace(/url\(|\)/g,"");
            _url = _url.replace(/\"/g,"");
            _img.src=_url;
            _arr.push(_img);
        }
    });
    function isImgLoad(callback){
        $(_arr).each(function(){
            if(this.width === 0){
                isLoad = false;
                return false;
            }
        });
        if(isLoad){
            clearTimeout(t_img);
            callback();
        }else{
            isLoad = true;
            t_img = setTimeout(function(){
                isImgLoad(callback);
            },500);
        }
    }
    isImgLoad(fn);
});