function loadLevelInfoAdditionPage() {
    $("#container").load("pages/initData/levelInfo/addition.html", null, function() {
        levelAddMenu();
    })
}

function loadLevelInfoAdditionModifyPage(rankId,rankName,remark) {
    $("#container").load("pages/initData/levelInfo/addition.html", null, function() {
        $("#form_box > h4").html("初始化数据-修改等级信息");
        $("#levelName").val(rankName);
        $("#rankDesc").val(remark);
        levelUpdateMenu();
    })
}

function levelAddMenu(){
    var submenu = document.getElementById("submenu").children;
    $('#saveBtn').click(function(){
        //验证
        if($("#levelName").val() === "") {
            $("#levelName").siblings(".error").html("");
            $("#levelName").after('<span class="error">等级名称不能为空</span>');
            $("#levelName").one("focus",function () {
                $("#levelName").siblings(".error").html("");
            })
            return;
        }

        $("#form_box").mask("稍等，正在保存数据...");
        updateOrSaveRankValue();
        setTimeout(' $("#container").load("pages/initData/levelInfo/index.html", null, function() {getRankList()})',1000);

    });
    $('.returnBtn').click(function () {
        $("#container").load("pages/initData/levelInfo/index.html", null, function() {getRankList()})
    });
    $('#saveAddNew').click(function(){
        updateOrSaveRankValue();
        setTimeout(' $("#container").load("pages/initData/levelInfo/addition.html", null, function() {levelAddMenu()})',1000);
    });
};

function levelUpdateMenu(id) {
    var submenu = document.getElementById("submenu").children;
    $('#saveBtn').click(function(){
        //验证
        if($("#levelName").val() === "") {
            $("#levelName").siblings(".error").html("");
            $("#levelName").after('<span class="error">等级名称不能为空</span>');
            $("#levelName").one("focus",function () {
                $("#levelName").siblings(".error").html("");
            })
            return;
        }

        $("#form_box").mask("稍等，正在保存数据...");
        UpdateRankList(id);
        setTimeout(' $("#container").load("pages/initData/levelInfo/index.html", null, function() {getRankList()})',1000);

    });
    $('.returnBtn').click(function () {
        $("#container").load("pages/initData/levelInfo/index.html", null, function() {getRankList()})
    });
    $('#saveAddNew').click(function(){
        UpdateRankList(id);
        setTimeout(' $("#container").load("pages/initData/levelInfo/addition.html", null, function() {levelAddMenu()})',1000);
    });
}

function getRankList() {
    var pageNum = 1;
    var pageSize = 10000;
    var status = 1;
    var tableData = [];
    $.ajax({
        type:"GET",
        url: "/rank/get_rank_list",
        dataType:"json",
        data:{pageNum:pageNum,pageSize:pageSize,status:status},
        async: false,
        success: function (data) {
            tableData = data;
            var tableRow = tableData.data.list;

            $.each(tableRow , function (index, optiondata) {
                var remark = (optiondata.remark===undefined) ? "" : optiondata.remark;

                var tableHtml =
                    '<tr>'
                    + '<td>'+optiondata.rankId+'</td>'
                    + '<td>'+optiondata.rankName+'</td>'
                    + '<td>'+remark+'</td>'
                    + '<td>'
                    + "<a class='btn btn-default ldelBtn' onclick='deletedRankList(&quot;"+optiondata.rankId+"&quot,&quot;"+optiondata.rankName +"&quot;)' role='button'>删除</a>"
                    + "<a class='btn btn-default btn-default2' onclick='loadLevelInfoAdditionModifyPage(&quot;"+optiondata.rankId+"&quot,&quot;"+optiondata.rankName +"&quot;,&quot;"+remark +"&quot;)' >查看修改</a>"
                    + '</td></tr>';
                $("#rankTableRow").append(tableHtml);
            });
        }
    })
    
}


function updateOrSaveRankValue() {
    var title = $("#levelName").val();
    var remark= $("#rankDesc").val();
    var status = 1;
    $.ajax({
        type:"POST",
        url: "/rank/addOrUpdate",
        dataType:"json",
        data:{title:title,remark:remark,status:status},
        success: function (data) {
            $("#form_box").mask("数据保存完成.");
        }
    })
}

function UpdateRankList(id) {
    var title = $("#levelName").val();
    var remark= $("#rankDesc").val();
    var status = 1;
    $.ajax({
        type:"POST",
        url: "/rank/addOrUpdate",
        dataType:"json",
        data:{title:title,remark:remark,id:id,status:status},
        success: function (data) {
            $("#form_box").mask("数据保存完成.");
        }
    })
}



function deletedRankList(id,title) {
    jConfirm('你确认要删除数据吗?', '系统提示', function(r) {
        if(r){
            var status = 0;
            $.ajax({
                type:"POST",
                url: "/rank/addOrUpdate",
                dataType:"json",
                data:{id:id,status:status,title:title},
                success: function () {
                    // console.log("delete");
                    $("#container").load("pages/initData/kilnInfo/index.html", null, function() {getRankList()});
                    $("#form_box").mask("数据保存完成.");
                }
            })
        }
    });
}