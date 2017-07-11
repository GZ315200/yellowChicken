/**
 * Created by Administrator on 2017/6/24.
 */
(function () {

    //初始化数据模块
    $("#container").load("pages/initData/kilnInfo/index.html", null, function() {
        console.log("窑炉信息页面添加1");
        getKilnList();
    })

    var userInfo=getCookie("userInfo");
    $("#userInfo").html(userInfo);
    //获取cookie值
    function getCookie(name)
    {
        var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");

        if(arr=document.cookie.match(reg))

            return unescape(arr[2]);
        else
            return null;
    }
    //获取所有页面节点
    var submenu = document.getElementById("submenu").children;
    //窑炉信息页面添加
    function loadKilnInfoPage() {
        for(var x = 0;x < submenu.length; x++) {
            submenu[x].setAttribute("class","");
        }
        this.setAttribute("class","cur");
        $("#container").load("pages/initData/kilnInfo/index.html", null, function() {
            console.log("窑炉信息页面添加");
            getKilnList();
        })
    }
    //等级信息页面添加
    function loadLevelInfoPage() {
        for(var x = 0;x < submenu.length; x++) {
            submenu[x].setAttribute("class","");
        }
        this.setAttribute("class","cur");
        $("#container").load("pages/initData/levelInfo/index.html", null, function() {
            console.log("等级信息页面添加");
            getRankList();
        })
    }
    //质量问题页面添加
    function loadQualityIssuesInfoPage() {
        for(var x = 0;x < submenu.length; x++) {
            submenu[x].setAttribute("class","");
        }
        this.setAttribute("class","cur");
        $("#container").load("pages/initData/qualityIssues/index.html", null, function() {
            console.log("质量问题页面添加");
            getQualityList();
        })
    }
    //绑定添加页面
    submenu[0].onclick = loadKilnInfoPage;
    submenu[1].onclick = loadLevelInfoPage;
    submenu[2].onclick = loadQualityIssuesInfoPage;

})()



