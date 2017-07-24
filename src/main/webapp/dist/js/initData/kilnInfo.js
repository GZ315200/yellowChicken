function loadKilnInfoAdditionPage() {
    $("#container").load("pages/initData/kilnInfo/addition.html", null, function() {
        kilnAddMenu();
    })
}

function loadKilnInfoAdditionModifyPage(id,kilnName,description) {
    $("#container").load("pages/initData/kilnInfo/addition.html", null, function() {
        $("#form_box > h4").html("初始化数据-修改窑炉信息");
        $("#kilnName").val(kilnName);
        $("#kiLnDesc").val(description);
        kilnUpdateMenu(kilnName,description,id)
    })
}

function kilnAddMenu(){
    var submenu = document.getElementById("submenu").children;
    $('#saveBtn').click(function(){
        //验证
        if($("#kilnName").val() === "") {
            $("#kilnName").siblings(".error").html("");
            $("#kilnName").after('<span class="error">窑炉名称不能为空</span>');
            $("#kilnName").one("focus",function () {
                $("#kilnName").siblings(".error").html("");
            })
            return;
        }
        $("#form_box").mask("稍等，正在保存数据...");
        addOrUpdateKilnList();
        setTimeout(' $("#container").load("pages/initData/kilnInfo/index.html", null, function() {getKilnList()})',1000);
    });
    $('.returnBtn').click(function () {
        $("#container").load("pages/initData/kilnInfo/index.html", null, function() {getKilnList()})
    });
    $('#saveAddNew').click(function(){
        addOrUpdateKilnList();
        setTimeout(' $("#container").load("pages/initData/kilnInfo/addition.html", null, function() {kilnAddMenu()})',1000);
    });
};



function kilnUpdateMenu(title,remark,id){
    var submenu = document.getElementById("submenu").children;
    $('#saveBtn').click(function(){
        //验证
        if($("#kilnName").val() === "") {
            $("#kilnName").siblings(".error").html("");
            $("#kilnName").after('<span class="error">窑炉名称不能为空</span>');
            $("#kilnName").one("focus",function () {
                $("#kilnName").siblings(".error").html("");
            })
            return;
        }
        $("#form_box").mask("稍等，正在保存数据...");
        UpdateKilnList(id);
        setTimeout(' $("#container").load("pages/initData/kilnInfo/index.html", null, function() {getKilnList()})',1000);
    });
    $('.returnBtn').click(function () {
        $("#container").load("pages/initData/kilnInfo/index.html", null, function() {getKilnList()})
    });
    $('#saveAddNew').click(function(){
        UpdateKilnList(id);
        setTimeout(' $("#container").load("pages/initData/kilnInfo/addition.html", null, function() {kilnAddMenu()})',1000);
    });
};



function getKilnList() {
    var pageNum = 1;
    var pageSize = 10000;
    var status = 1;
    var tableData = [];
    $.ajax({
        type:"GET",
        url: "/kiln/get_list",
        dataType:"json",
        data:{pageNum:pageNum,pageSize:pageSize,status:status},
        async: false,
        success: function (data) {
            tableData = data;
            var tableRow = tableData.data.list;
            // console.log(tableRow);
            $.each(tableRow , function (index, optiondata) {
                var description = (optiondata.description===undefined) ? "" :  optiondata.description;
                var tableHtml =
                    '<tr>'
                    + '<td>'+optiondata.id+'</td>'
                    + '<td>'+optiondata.kilnName+'</td>'
                    + '<td>'+description+'</td>'
                    + '<td>'
                    + "<a class='btn btn-default ldelBtn' onclick='deleteKilnList(&quot;"+optiondata.id+"&quot,&quot;"+optiondata.kilnName +"&quot;)' role='button'>删除</a>"
                    + "<a class='btn btn-default btn-default2' onclick='loadKilnInfoAdditionModifyPage(&quot;"+optiondata.id+"&quot,&quot;"+optiondata.kilnName +"&quot;,&quot;"+description +"&quot;)' >查看修改</a>"
                    + '</td></tr>';
                $("#qilinTableRow").append(tableHtml);
            });
        }
    })
    
}


function addOrUpdateKilnList() {
    var title = $("#kilnName").val();
    var remark= $("#kiLnDesc").val();
    var status = 1;
    $.ajax({
        type:"POST",
        url: "/kiln/addOrUpdate",
        dataType:"json",
        data:{title:title,remark:remark,status:status},
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


function UpdateKilnList(id) {
    var title = $("#kilnName").val();
    var remark= $("#kiLnDesc").val();
    var status = 1;
    $.ajax({
        type:"POST",
        url: "/kiln/addOrUpdate",
        dataType:"json",
        data:{title:title,remark:remark,id:id,status:status},
        success: function (data) {
            $("#form_box").mask("数据保存完成.");
        }
    })
}

function deleteKilnList(id,title) {
    jConfirm('你确认要删除数据吗?', '系统提示', function(r) {
        if(r){
            var status = 0;
            $.ajax({
                type:"POST",
                url: "/kiln/addOrUpdate",
                dataType:"json",
                data:{id:id,status:status,title:title},
                success: function () {
                    // console.log("delete");
                    $("#container").load("pages/initData/kilnInfo/index.html", null, function() {getKilnList()});
                    $("#form_box").mask("数据保存完成.");
                }
            })
        }
    });

}