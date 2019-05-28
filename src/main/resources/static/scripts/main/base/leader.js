$(function(){
    var nav=$("#nav"), //得到导航对象
        win=$(window), //得到窗口对象
        doc=$(document);//得到document文档对象。
    //防止页面滚动到60px以下F5刷新后导航不显示　　　
    if(doc.scrollTop()>=60){
/*        $('#nav').addClass('fixnav');*/
        $('#menu1').addClass('fixmenu');
    }else{
/*        $('#nav').removeClass('fixnav');*/
        $('#menu1').removeClass('fixmenu');
    }
    //滚动到60px以下导航显示
    doc.scroll(function(){
        if(doc.scrollTop()>=60){//判断滚动的高度
/*            $("#nav").addClass('fixnav');//固定导航样式类名*/
            $('#menu1').addClass('fixmenu');
        }else{
/*            $("#nav").removeClass('fixnav');*/
            $('#menu1').removeClass('fixmenu');
        }
    })
})