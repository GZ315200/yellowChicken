function loadQualityIssuesInfoAdditionPage() {
    $("#container").load("pages/initData/qualityIssues/addition.html", null, function() {
        qualityIssuesAddMenu();
    })
}

function loadQualityIssuesInfoAdditionModifyPage() {
    $("#container").load("pages/initData/qualityIssues/addition.html", null, function() {
        $("#form_box > h4").html("初始化数据-修改质量信息");
        qualityIssuesAddMenu();

    })
}

function qualityIssuesAddMenu(){
    var submenu = document.getElementById("submenu").children;
    $('#saveBtn').click(function(){
        //验证
        if($("#questionName").val() === "" || $("#chargeAmount").val() === "") {
            if($("#questionName").val() === "" ) {
                $("#questionName").siblings(".error").html("");
                $("#questionName").after('<span class="error">问题名称不能为空</span>');
                $("#questionName").one("focus",function () {
                    $("#questionName").siblings(".error").html("");
                })
            }
            if($("#chargeAmount").val() === "") {
                $("#chargeAmount").siblings(".error").html("");
                $("#chargeAmount").after('<span class="error">扣款金额不能为空</span>');
                $("#chargeAmount").one("focus",function () {
                    $("#chargeAmount").siblings(".error").html("");
                })
            }
            return;
        }
        $("#form_box").mask("稍等，正在保存数据...");
        setTimeout('$("#form_box").mask("数据保存完成.");',2000);
        setTimeout(' $("#container").load("pages/initData/qualityIssues/index.html", null, function() {console.log("窑炉信息页面添加");})',3000);
    });
    $('.returnBtn').click(function () {
        var submenu = document.getElementById("submenu").children;
        submenu[2].click();
    });
    $('#saveAddNew').click(function(){
        loadQualityIssuesInfoAdditionPage();
    });
};


function tobecontinuwe() {


    
    
}