/**
 * Created by Administrator on 2017/6/24.
 */
(function () {
    //初始化数据模块
    $("#container").load("pages/dataCollection/qualityInspectionCollection/index.html", null, function() {
        console.log("质量检验采集");
    })
    //获取所有页面节点
    var submenu = document.getElementById("submenu").children;
    //窑炉信息页面添加
    function loadQualityInspectionCollectionPage() {
        for(var x = 0;x < submenu.length; x++) {
            submenu[x].setAttribute("class","");
        }
        this.setAttribute("class","cur");
        $("#container").load("pages/dataCollection/qualityInspectionCollection/index.html", null, function() {
            console.log("窑炉信息页面添加");
        })
    }
    //绑定添加页面
    submenu[0].onclick = loadQualityInspectionCollectionPage;
})()



