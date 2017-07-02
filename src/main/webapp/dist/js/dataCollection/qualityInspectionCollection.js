function loadqualityInspectionCollectionAdditionPage() {
    $("#container").load("pages/dataCollection/qualityInspectionCollection/addition.html", null, function() {
        qualityInspectionCollectionAddMenu();
    })
}


function qualityInspectionCollectionAddMenu(){
    var submenu = document.getElementById("submenu").children;
    $('#saveBtn').click(function(){
        $("#form_box").mask("稍等，正在保存数据...");
        setTimeout('$("#form_box").mask("数据保存完成.");',2000);
        setTimeout(' $("#container").load("pages/dataCollection/qualityInspectionCollection/index.html", null, function() {console.log("窑炉信息页面添加");})',3000);
    });
    $('.returnBtn').click(function () {
        var submenu = document.getElementById("submenu").children;
        submenu[0].click();
    });
    $('#saveAddNew').click(function(){
        loadKilnInfoAdditionPage();
    });
};


function getQualityCollectlist() {


}