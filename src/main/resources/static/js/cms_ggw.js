/**
 * static.cms - v1.0.0  License By 
 * WEB小组 
 */
function setCookie(e,t,a){var i=new Date;i.setTime(i.getTime()+a),document.cookie=e+"="+escape(t)+(";expires="+i.toGMTString())}function getCookie(e){return document.cookie.length>0&&(c_start=document.cookie.indexOf(e+"="),c_start!=-1)?(c_start=c_start+e.length+1,c_end=document.cookie.indexOf(";",c_start),c_end==-1&&(c_end=document.cookie.length),unescape(document.cookie.substring(c_start,c_end))):""}function isHasImg(e){var t=new Image;t.src=e,t.onload=function(){t.width>1e3&&t.height>0||($("#topimg").css("height",0),$("#topimg").find("img").css("height",0))}}var randData=function(e,t,a,i){var o="";if(a=1==a.switch_type?a:a.data[0],2==t){var s;if(s=""==getCookie(i)?"":getCookie(i),a.data.length>1){for(var n=a.data.length,c=[],_=0;_<n;_++)a.data[_].ad_id!=s&&c.push(a.data[_]);n=parseInt(Math.random()*c.length),o=c[n]}else o=a.data[0];s=o.ad_id,setCookie(i,s,1e16)}else o=a.data[0];return o};$(document).ready(function(e){var t=0,a=$("#content").data("ggwurl");$.ajax({type:"POST",url:a,data:{aa:"c"},dataType:"json",success:function(e){if(0==e.status&&e.data.length>0){if(e.data[0].cms_web_index&&e.data[0].cms_web_index.data.length>0){var t=e.data[0].cms_web_index,a=1==t.close_btn?'<span class="ggw_fm_close"></span>':"",i=1==t.close_after?"ggw_cok":"",o=randData(t.switch_type,t.content_source,t,"cms_web_sort_index"),s=1==o.open_type?"_blank":"_self",n='<div class="ggw_fm '+i+'" data-cok="cms_web_index"><div class="img_size"><img src="'+o.img_url+'"></div><div class="ggw_fm_main cms_ggw"><a href="'+o.href+'" target="'+s+'"></a></div>'+a+"</div>";1==t.close_after?0==getCookie("cms_web_index")&&""!=getCookie("cms_web_index")||$("body").append(n):(setCookie("cms_web_index","0",1),$("body").append(n))}if(e.data[0].cms_web_right&&e.data[0].cms_web_right.data.length>0){var c=e.data[0].cms_web_right,i=1==c.close_after?"ggw_cok ggw_clo":2==c.close_after?"ggw_clo":"",a=1==c.close_btn&&3!=c.close_after?'<span class="ggw_fm_close"></span>':"",o=randData(c.switch_type,c.content_source,c,"cms_web_sort_right"),s=1==o.open_type?"_blank":"_self",_='<div class="ggw_fr '+i+'" data-cok="cms_web_right"><div class="ggw_fr_main"><a href="'+o.href+'" target="'+s+'" ><img src="'+o.img_url+'" alt=""></a>'+a+"</div></div>";1==c.close_after?0==getCookie("cms_web_right")&&""!=getCookie("cms_web_right")||$("body").append(_):(setCookie("cms_web_right","0",1),$("body").append(_))}if(e.data[0].cms_web_top&&e.data[0].cms_web_top.data.length>0){var g=e.data[0].cms_web_top,a=1==g.close_btn&&3!=g.close_after?'<span class="ggw_fm_close"></span>':"",i=1==g.close_after?"ggw_cok ggw_clo":2==g.close_after?"ggw_clo":"",o=randData(g.switch_type,g.content_source,g,"cms_web_sort_top"),s=1==o.open_type?"_blank":"_self",_='<div id="topimg" class="'+i+'" data-cok="cms_web_top"><div class="ggw_fr_main"><a href="'+o.href+'" target="'+s+'" ><img  style="width:100%;min-width:1200px;max-height:80px" src="'+o.img_url+'" alt=""></a>'+a+"</div></div>";1==g.close_after?0==getCookie("cms_web_top")&&""!=getCookie("cms_web_top")||(isHasImg(o.img_url),$("#testTop").append(_)):(setCookie("cms_web_top","0",1),$("#testTop").append(_))}try{isHasImg(o.img_url)}catch(r){}}}}).then(function(){i();var e=$(".banner_con").width()+$(".banner_con").offset().left+20+"px";$(".ggw_fr").css({left:e,visibility:"visible"}),$(window).resize(function(){var e=$(".banner_con").width()+$(".banner_con").offset().left+20+"px";$(".ggw_fr").css({left:e,visibility:"visible"})});var t=new Date;t.setHours("23"),t.setMinutes("59"),t.setSeconds("60"),$(".ggw_cok a").click(function(){document.cookie=$(this).parents(".ggw_cok").data("cok")+"="+escape(0)+(";expires="+t.toGMTString())}),$(".ggw_cok .ggw_fm_close").click(function(){document.cookie=$(this).parents(".ggw_cok").data("cok")+"="+escape(0)+(";expires="+t.toGMTString())}),$(".ggw_fm_close").on("click",function(){0!=$(this).parents(".layui-layer").length?layer.closeAll():$(this).parent().parent().remove()}),$(".ggw_fm_main a").on("click",function(e){var t=$(this).attr("href"),a="_blank"==$(this).attr("target")?1:0;layer.closeAll(),e.preventDefault(),setTimeout(function(){a?window.open(t):window.location.href=t},10)}),$(".ggw_clo .ggw_fr_main a").on("click",function(e){var t=$(this).attr("href"),a="_blank"==$(this).attr("target")?1:0;$(".ggw_clo").remove(),e.preventDefault(),setTimeout(function(){a?window.open(t):window.location.href=t},10)})});var i=function(){if(t++,t<200)if(0==$(".img_size img").width())setTimeout(arguments.callee,10);else{var e=$(".img_size img").width(),a=$(".img_size img").height();if(e=e>600?600:e+1,a=a>600?600:a+1,e+="px",a+="px",$(".ggw_fm_main a").append('<img src="'+$(".img_size img").attr("src")+'" />'),$(".img_size").remove(),$(".ggw_fm img").length>0){var i=0;$(".cms_ggw").parents(".layui-layer").css({background:"none","box-shadow":"none"}),layer.open({type:1,title:"",closeBtn:0,shade:.7,skin:"layui-layer-molv",area:[e,a],content:$(".ggw_fm"),end:function(){$("body").css("overflow",""),i=1}}),$(document).on("mousewheel",function(){if(1!=i)return!1})}}}});