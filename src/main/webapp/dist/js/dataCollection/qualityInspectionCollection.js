function loadqualityInspectionCollectionAdditionPage(collectId,formWorkerName) {
    $("#container").load("pages/dataCollection/qualityInspectionCollection/addition.html", null, function() {
        qualityInspectionCollectionAddMenu(collectId);
        initQualityCollectForm(collectId,formWorkerName);
    })
}


function qualityInspectionCollectionAddMenu(collectId){
    var submenu = document.getElementById("submenu").children;
    $('#saveBtn').click(function(){
        submitQualityCollectionQuestion1(collectId);
        // $("#form_box").mask("稍等，正在保存数据...");
        // setTimeout('$("#form_box").mask("数据保存完成.");',2000);
        // setTimeout(' $("#container").load("pages/dataCollection/qualityInspectionCollection/index.html", null, function() {console.log("窑炉信息页面添加");})',3000);
    });
    $('.returnBtn').click(function () {
        var submenu = document.getElementById("submenu").children;
        submenu[0].click();
    });
    $('#saveAddNew').click(function(){
        loadKilnInfoAdditionPage();
    });
};



function getQualityCollectInfo() {
    var workerId;
    var workerCode = $("#qualityWorkerCode").val();
    if(workerCode==="") {
        workerCode="empty";
    }
    $.ajax({
        type:"GET",
        url: "/quality/collect/get_quality_collect_info",
        dataType:"json",
        data:{workerCode:workerCode,workerId:workerId},
        success: function (data) {
            $("#qualityCollectTableRow").html("");
            console.log(data);
            var tableRow = data.data;
            $.each(tableRow , function (index, optiondata) {
                var tableHtml = "<tr>"
                    +"<td>"+optiondata.formWorkerNum+"</td>"
                    +"<td>"+optiondata.formWorkerName+"</td>"
                    +"<td><span class='btn btn-default ldelBtn'>"+optiondata.count+"次</span></td>"
                    +"<td><a class='btn btn-default ldelBtn' onclick='loadqualityInspectionCollectionAdditionPage(&quot;"+optiondata.collectId+"&quot,&quot;"+optiondata.formWorkerName +"&quot;)'>添加数据</a>"
                    +"<a class='btn btn-default btn-default2' onclick='loadqualityInspectionCollectionAdditionPage()'>查看修改</a></td></tr>";
                $("#qualityCollectTableRow").append(tableHtml);
            });
        }
    })
}

function initQualityCollectForm(collectId,formWorkerName) {
    var workerId=1;
    var returnData=[];
    $.ajax({
        type:"GET",
        url: "/quality/collect/get_product_code",
        dataType:"json",
        success: function (data) {
            console.log("productDetail");
            console.log(data);
            returnData =data.data;
            console.log(returnData);
            // workerId = data.data.workerId;
            $.each(data.data, function(index, optiondata) {
                $("#productNameSel").append('<option>' + optiondata.productDetail + '</option>')
            });
        }
    })
    workerId = returnData.workerId;
    $("#collectWorkerName").val(formWorkerName);
    collectKilnNameSel();
    collectLevelNameSel();
    get_quality_category_questionType1();
    get_quality_question_list_collectType1(workerId);
    get_user_category();

    // submitQualityCollectionQuestion1();
}

function collectKilnNameSel() {
    $.ajax({
        type:"GET",
        url: "/quality/collect/get_kilnName_list",
        dataType:"json",
        async: false,
        success: function (data) {
            $("#kilinNameSel").attr("disabled", false);
            $.each(data.data, function(index, optiondata) {
                $("#kilinNameSel").append('<option value=' + optiondata.id + '>' + optiondata.kilnName + '</option>')
            });
        }
    })
}

function collectLevelNameSel() {
    $.ajax({
        type:"GET",
        url: "/quality/collect/get_rank_title",
        dataType:"json",
        async: false,
        success: function (data) {
            $("#levelNameSel").attr("disabled", false);
            $.each(data.data, function(index, optiondata) {
                $("#levelNameSel").append('<option>' + optiondata.rankIdName + '</option>')
            });
        }
    })
}

//获取问题信息
function get_quality_question_list_collectType1(workerId) {
    var collectType = 1;
    $.ajax({
        type:"GET",
        url: "/quality/collect/get_quality_question_list",
        dataType:"json",
        async: false,
        data:{collectType:collectType,workerId:workerId},
        success: function (data) {
            //如果扣款问题则隐藏系数列
            console.log("get_quality_question_list_collectType1");
            console.log(data);
            // if(data.data.collectType===1) {
            //     $(".coefx").hide();
            // }
        }
    })
}






//问题详情
function get_quality_category_questionType1() {
    var questionCollectType = 1;
    console.log("get_quality_category");
    $.ajax({
        type:"GET",
        url: "/quality/collect/get_quality_category",
        dataType:"json",
        async: false,
        data:{questionCollectType:questionCollectType},
        success: function (data) {
            console.log("get_quality_category_questionType1");
            console.log(data);
            $("#questionType1").html("");
            $.each(data.data, function(index, optiondata) {
                // if(optiondata.)
                var questionHtml ='<tr>'
                    +'<td id="questionType1-'+optiondata.qualityId+'">'+optiondata.qualityIdName+'</td>'
                    +'<td>'
                    +'<input type="text" class="form-control">'
                    +'</td>'
                    +'<td class="coefx">'
                    +'<input type="text" class="form-control">'
                    +'</td>'
                    +'</tr>';
                $("#questionType1").append(questionHtml);
            });
        }
    })
}

//员工信息
function get_user_category(category) {
    console.log("get_user_category");
    $.ajax({
        type:"GET",
        url: "/quality/collect/get_user_category",
        dataType:"json",
        async: false,
        data:{category:category},
        success: function (data) {
            console.log(data);
        }
    })
}

function submitQualityCollectionQuestion1() {
    var qeustionType = $("#questionType1 > tr");
    // console.log(qeustionType);
    for(var i = 0; i < qeustionType.length; i++) {
        var qualityId = $(qeustionType[i].children[0]).attr("id").split("-")[1];
        var questionName = $(qeustionType[i].children[0]).text();
        var quantity = $(qeustionType[i].children[1].children).val();
        var coefficient = $(qeustionType[i].children[1].children);
        if(coefficient.css("display")==='none' )
        {
            console.log(coefficient.css("display"));
            console.log("hide");
        } else {
            console.log(coefficient.css("display"));
            console.log("show");
        }
        console.log(quantity);
    }

}