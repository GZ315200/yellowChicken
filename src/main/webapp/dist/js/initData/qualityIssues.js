function loadQualityIssuesInfoAdditionPage() {
    $("#container").load("pages/initData/qualityIssues/addition.html", null, function() {
        qualityIssuesAddMenu();
    })
}

function loadQualityIssuesInfoAdditionModifyPage(id,title,questionType,money,userId,remark) {
    $("#container").load("pages/initData/qualityIssues/addition.html", null, function() {
        $("#form_box > h4").html("初始化数据-修改质量信息");
        $("#questionName").val(title);
        $('#userTypeAdd').val(userId);
        console.log(questionType);
        $('#questionType').val(questionType);
        $("#chargeAmount").val(money);
        $("#qualityDesc").val(remark);
        qualityIssuesUpdateMenu(id);

    })
}

function qualityIssuesAddMenu(){
    var submenu = document.getElementById("submenu").children;

    questionTypeSelControl();
    $('#saveBtn').click(function(){
        //验证
        var display =$('#chargeAmountGroup').css('display');

        if($("#questionName").val() === "" || ($("#chargeAmount").val() === "" &&  display==="block")) {
            if($("#questionName").val() === "" ) {
                $("#questionName").siblings(".error").html("");
                $("#questionName").after('<span class="error">问题名称不能为空</span>');
                $("#questionName").one("focus",function () {
                    $("#questionName").siblings(".error").html("");
                })
            }
            if($("#chargeAmount").val() === "" &&  display==="block") {
                console.log(display);
                $("#chargeAmount").siblings(".error").html("");
                $("#chargeAmount").after('<span class="error">扣款金额不能为空</span>');
                $("#chargeAmount").one("focus",function () {
                    $("#chargeAmount").siblings(".error").html("");
                })
            }
            return;
        }
        $("#form_box").mask("稍等，正在保存数据...");
        updateOrAddQuality();
        setTimeout(' $("#container").load("pages/initData/qualityIssues/index.html", null, function() {getQualityList()})',1000);
    });
    $('.returnBtn').click(function () {
        $("#container").load("pages/initData/qualityIssues/index.html", null, function() {getQualityList()})
    });
    $('#saveAddNew').click(function(){
        updateOrAddQuality();
        setTimeout(' $("#container").load("pages/initData/qualityIssues/addition.html", null, function() {qualityIssuesAddMenu()})',1000);
    });
};

function qualityIssuesUpdateMenu(id){
    var submenu = document.getElementById("submenu").children;

    questionTypeSelControl();
    $('#saveBtn').click(function(){
        //验证
        var display =$('#chargeAmountGroup').css('display');

        if($("#questionName").val() === "" || ($("#chargeAmount").val() === "" &&  display==="block")) {
            if($("#questionName").val() === "" ) {
                $("#questionName").siblings(".error").html("");
                $("#questionName").after('<span class="error">问题名称不能为空</span>');
                $("#questionName").one("focus",function () {
                    $("#questionName").siblings(".error").html("");
                })
            }
            if($("#chargeAmount").val() === "" &&  display==="block") {
                console.log(display);
                $("#chargeAmount").siblings(".error").html("");
                $("#chargeAmount").after('<span class="error">扣款金额不能为空</span>');
                $("#chargeAmount").one("focus",function () {
                    $("#chargeAmount").siblings(".error").html("");
                })
            }
            return;
        }
        $("#form_box").mask("稍等，正在保存数据...");
        updateQualityList(id);
        setTimeout(' $("#container").load("pages/initData/qualityIssues/index.html", null, function() {getQualityList()})',1000);
    });
    $('.returnBtn').click(function () {
        $("#container").load("pages/initData/qualityIssues/index.html", null, function() {getQualityList()})
    });
    $('#saveAddNew').click(function(){
        updateQualityList(id);
        setTimeout(' $("#container").load("pages/initData/qualityIssues/addition.html", null, function() {qualityIssuesAddMenu()})',1000);
    });
};


function getQualityList() {
    var pageNum = 1;
    var pageSize = 10000;
    var status = 1;
    var tableData = [];
    $.ajax({
        type:"GET",
        url: "/quality/get_info_list",
        dataType:"json",
        data:{pageNum:pageNum,pageSize:pageSize,status:status},
        async: false,
        success: function (data) {
            tableData = data;
            var tableRow = tableData.data.list;
            console.log(tableRow);
            $.each(tableRow , function (index, optiondata) {
                var description = (optiondata.description===undefined) ? "" :  optiondata.description;
                var amount = (optiondata.amount===undefined) ? "" : optiondata.amount;
                var questionType = "";
                // 1.扣款，2扣系数
                if(optiondata.collectType===1) {
                    questionType = "扣款问题";
                } else if (optiondata.collectType===2) {
                    questionType = "扣系数问题";
                }
                //工种
                switch(optiondata.workerType)
                {
                    case 1:
                        var workerTyp="成型工";
                        break;
                    case 3:
                        var workerTyp="修坯工";
                        break;
                    case 4:
                        var workerTyp="施釉工";
                        break;
                    case 5:
                        var workerTyp="登窑工";
                        break;
                    case 6:
                        var workerTyp="烧窑工";
                        break;
                    case 8:
                        var workerTyp="包装工";
                        break;
                    case 10:
                        var workerTyp="管理人员";
                        break;
                }
                var tableHtml =
                    '<tr>'
                    + '<td>'+optiondata.qualityId+'</td>'
                    + '<td>'+optiondata.qualityName+'</td>'
                    + '<td>'+questionType+'</td>'
                    + '<td>'+amount+'</td>'
                    + '<td>'+workerTyp+'</td>'
                    + '<td>'+description+'</td>'
                    + '<td>'
                    + "<a class='btn btn-default ldelBtn' onclick='deleteQualityList(&quot;"+optiondata.qualityId+"&quot,&quot;"+optiondata.qualityName +"&quot;)' role='button'>删除</a>"
                    + "<a class='btn btn-default btn-default2' onclick='loadQualityIssuesInfoAdditionModifyPage(&quot;"+optiondata.qualityId+"&quot,&quot;"+optiondata.qualityName +"&quot;,&quot;"+optiondata.collectType +"&quot;,&quot;"+amount +"&quot;,&quot;"+optiondata.workerType +"&quot;,&quot;"+description +"&quot;)' >查看修改</a>"
                    + '</td></tr>';
                $("#qualityTableRow").append(tableHtml);
            });
        }
    })

}

function getQualityListByWorkerType() {
    var pageNum = 1;
    var pageSize = 10000;
    var status = 1;
    var tableData = [];
    var userType = $('#qualityListUserTypeSel').children('option:selected').val();
    console.log("userType："+userType);
        $.ajax({
        type:"GET",
        url: "/quality/get_info_list",
        dataType:"json",
        data:{pageNum:pageNum,pageSize:pageSize,status:status,userType:userType},
        async: false,
        success: function (data) {
            $("#qualityTableRow").html("");
            tableData = data;
            var tableRow = tableData.data.list;
            console.log(tableRow);
            $.each(tableRow , function (index, optiondata) {
                var description = (optiondata.description===undefined) ? "" :  optiondata.description;
                var amount = (optiondata.amount===undefined) ? "" : optiondata.amount;
                var questionType = "";
                // 1.扣款，2扣系数
                if(optiondata.collectType===1) {
                    questionType = "扣款问题";
                } else if (optiondata.collectType===2) {
                    questionType = "扣系数问题";
                }
                //工种
                switch(optiondata.workerType)
                {
                    case 1:
                        var workerTyp="成型工";
                        break;
                    case 3:
                        var workerTyp="修坯工";
                        break;
                    case 4:
                        var workerTyp="施釉工";
                        break;
                    case 5:
                        var workerTyp="登窑工";
                        break;
                    case 6:
                        var workerTyp="烧窑工";
                        break;
                    case 8:
                        var workerTyp="包装工";
                        break;
                    case 10:
                        var workerTyp="管理人员";
                        break;
                }
                var tableHtml =
                    '<tr>'
                    + '<td>'+optiondata.qualityId+'</td>'
                    + '<td>'+optiondata.qualityName+'</td>'
                    + '<td>'+questionType+'</td>'
                    + '<td>'+amount+'</td>'
                    + '<td>'+workerTyp+'</td>'
                    + '<td>'+description+'</td>'
                    + '<td>'
                    + "<a class='btn btn-default ldelBtn' onclick='deleteQualityList(&quot;"+optiondata.qualityId+"&quot,&quot;"+optiondata.qualityName +"&quot;)' role='button'>删除</a>"
                    + "<a class='btn btn-default btn-default2' onclick='loadQualityIssuesInfoAdditionModifyPage(&quot;"+optiondata.qualityId+"&quot,&quot;"+optiondata.qualityName +"&quot;,&quot;"+optiondata.collectType +"&quot;,&quot;"+amount +"&quot;,&quot;"+optiondata.workerType +"&quot;,&quot;"+description +"&quot;)' >查看修改</a>"
                    + '</td></tr>';
                $("#qualityTableRow").append(tableHtml);
            });
        }
    })


}

function questionTypeSelControl() {
    var questionType = $('#questionType').children('option:selected').text();
    var chargeAmount = $("#chargeAmountGroup");
    if(questionType === "扣款问题") {
        chargeAmount.show();
    } else {
        chargeAmount.hide();

    }
}



function updateOrAddQuality() {
    var title = $("#questionName").val();
    var userId = $('#userTypeAdd').children('option:selected').val();
    var questionType = $('#questionType').children('option:selected').val();
    var money = $("#chargeAmount").val();
    var remark = $("#qualityDesc").val();
    var status = 1;
    $.ajax({
        type:"POST",
        url: "/quality/addOrUpdate",
        dataType:"json",
        data:{title:title,userId:userId,questionType:questionType,money:money,remark:remark,status:status},
        success: function (data) {
            console.log(data);
            if(data.status===0) {
                $("#form_box").mask("数据保存完成.");
            } else if(data.status===1) {
                $("#form_box").mask("该信息已存在.");
            }
        }
    })
}


function updateQualityList(id) {
    var title = $("#questionName").val();
    var userId = $('#userTypeAdd').children('option:selected').val();
    var questionType = $('#questionType').children('option:selected').val();
    var money = $("#chargeAmount").val();
    var remark = $("#qualityDesc").val();
    var status = 1;
    $.ajax({
        type:"POST",
        url: "/quality/addOrUpdate",
        dataType:"json",
        data:{id:id,title:title,userId:userId,questionType:questionType,money:money,remark:remark,status:status},
        success: function (data) {
            $("#form_box").mask("数据保存完成.");
        }
    })
}

function deleteQualityList(id,title) {
    jConfirm('你确认要删除数据吗?', '系统提示', function(r) {
        if(r){
            var status = 0;
            $.ajax({
                type:"POST",
                url: "/quality/update_status",
                dataType:"json",
                data:{qualityId:id,status:status},
                success: function () {
                    // console.log("delete");
                    $("#container").load("pages/initData/qualityIssues/index.html", null, function() {getQualityList()});
                    $("#form_box").mask("数据保存完成.");
                }
            })
        }
    });
    
}