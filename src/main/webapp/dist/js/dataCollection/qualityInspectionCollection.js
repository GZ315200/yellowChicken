function loadqualityInspectionCollectionAdditionPage(workerId,workerCode,count,workerName) {
    $("#container").load("pages/dataCollection/qualityInspectionCollection/addition.html", null, function() {
        $("#collectWorkerName").val(workerName);
        qualityInspectionCollectionAddMenu(workerId,workerCode,count);
        initQualityCollectForm(workerId,workerCode)
    })
}

function updateQualityInspectionCollectionAdditionPage(workerId,workerCode,collectId,id) {
    $("#container").load("pages/dataCollection/qualityInspectionCollection/addition.html", null, function() {
        updateQualityInspectionCollectionAddMenu(workerId,workerCode,collectId,id);
        initQualityCollectForm(workerId,workerCode);
        updateCollection(workerId,collectId);
    })
}

function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var month = date.getMonth() + 1;
    var strDate = date.getDate()+1;
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
    return currentdate;
}
function get7DayFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var month = date.getMonth() + 1;
    var strDate = date.getDate()-7;
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
    return currentdate;
}
function loadUpdatePageRecord(workerId,workName) {
    $("#container").load("pages/dataCollection/qualityInspectionCollection/update.html", null, function() {
        $('#workName').html(workName);
        var stime =get7DayFormatDate();
        var etime =getNowFormatDate();
        $('#stime').val(stime);
        $('#etime').val(etime);
        $('#selectAbtn').click(function () {
            getUpatePageData(workerId)

        })
        $('#resetBtn').click(function () {
            $('#stime').val(stime);
            $('#etime').val(etime);
            getUpatePageData(workerId)

        })
        getUpatePageData(workerId)
    })
}
function getxTime(nS) {
    nS = nS.toString().substring(0,10);
    return new Date(parseInt(nS) * 1000).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
}
function getUpatePageData(workerId) {
    var startTime =$('#stime').val();
    var endTime = $('#etime').val();
    $(".dataLog").remove();
    $.ajax({
        type:"GET",
        url: "/quality/collect/get_collect_edit_infoList/"+workerId+"/"+startTime+"/"+endTime,
        dataType:"json",
        success: function (data) {
            console.log(data);
            $.each(data.data , function (index, optiondata) {
                var xtime = optiondata.createTime > optiondata.updateTime ? optiondata.createTime : optiondata.updateTime;
                // console.log(xtime);
                var  quantity= optiondata.quantity===null ? "":optiondata.quantity;
                var realtime = getxTime(xtime);
                var xhtml ='<tr class="dataLog"><td rowspan="2"></td><td colspan="2">'
                    +'<span class="time">采集时间'+realtime+'</span>'
                    +"<a class='pull-right btn btn-default2 doeditBtn' onclick='updateQualityInspectionCollectionAdditionPage(&quot;"+workerId+"&quot,&quot;"+optiondata.userCode+"&quot,&quot;"+optiondata.collectId+"&quot,&quot;"+optiondata.id +"&quot;)'>编辑修改</a>"
                    +"<a class='pull-right btn btn-default dodelBtn'  onclick='deleteQualityInfo(&quot;"+workerId+"&quot,&quot;"+optiondata.userCode+"&quot,&quot;"+optiondata.collectId+"&quot,&quot;"+optiondata.id +"&quot;)'>删除</a></td></tr><tr class='dataLog'>"
                    +'<td colspan="3"><table class="table itable" ><tr><td width="90px">窑炉</td><td style="text-align: left">产品</td>'
                    +'<td width="90px">等级</td><td width="90px">数量</td></tr><tr class="dataLog">'
                    +'<td>'+optiondata.yaoluName+'</td><td style="text-align: left">'+optiondata.productName+'</td><td>'+optiondata.rankName+'</td>'
                    +'<td>'+quantity+'</td></tr></table></td></tr>';
                $("#updateTabeLog").append(xhtml);
            });
        }
    })
}

function deleteQualityInfo(workerId,workerCode,collectId,id) {
    jConfirm('你确认要删除数据吗?', '系统提示', function(r) {
        if(r){
            $.ajax({
                type:"DELETE",
                url: "/quality/collect/delete_collect_single_info/"+workerId+"/"+collectId,
                dataType:"json",
                success: function () {
                    $("#container").load("pages/dataCollection/qualityInspectionCollection/update.html", null, function() {
                        $('#workName').html(workName);
                        var stime =get7DayFormatDate();
                        var etime =getNowFormatDate();
                        $('#stime').val(stime);
                        $('#etime').val(etime);
                        $('#selectAbtn').click(function () {
                            getUpatePageData(workerId)

                        })
                        $('#resetBtn').click(function () {
                            $('#stime').val(stime);
                            $('#etime').val(etime);
                            getUpatePageData(workerId)
                        })
                        getUpatePageData(workerId)
                    })
                }
            })
        }
    });

}

function qualityInspectionCollectionAddMenu(workerId,workerCode,count){
    var submenu = document.getElementById("submenu").children;
    $('#saveBtn').click(function(){
        $("#form_box").mask("稍等，正在保存数据...");
        var collectId = getCollectId(workerId,workerCode);
        submitQualityCollectionQuestion1(collectId);
        submitQualityCollectionQuestion2(collectId);
        submitQualityCollectionQuestion3(collectId);
        submitQualityCollectionQuestion4(collectId);
        submitQualityCollectionQuestion5(collectId);
        addOrUpdateUserInfo(workerId,collectId);
        setTimeout('$("#form_box").mask("数据保存完成.");',1000);
        setTimeout(' $("#container").load("pages/dataCollection/qualityInspectionCollection/index.html", null, function() {getQualityCollectInfo();})',1001);
        // return updateCollectCount(workerId,count,collectId);        // updateCollection();
        // setTimeout('$("#form_box").mask("数据保存完成.");',2000);
        // setTimeout(' $("#container").load("pages/dataCollection/qualityInspectionCollection/index.html", null, function() {console.log("窑炉信息页面添加");})',3000);
    });
    $('.returnBtn').click(function () {
        $("#container").load("pages/dataCollection/qualityInspectionCollection/index.html", null, function() {getQualityCollectInfo()})
    });
    $('#saveAddNew').click(function(){
        $("#container").load("pages/dataCollection/qualityInspectionCollection/addition.html", null, function() {
            qualityInspectionCollectionAddMenu(workerId,workerCode,count);
            initQualityCollectForm(workerId,workerCode)
        })
    });
};

function updateQualityInspectionCollectionAddMenu(workerId,workerCode,collectId,id){
    var submenu = document.getElementById("submenu").children;
    $('#saveBtn').click(function(){
        $("#form_box").mask("稍等，正在保存数据...");
        // var id = updateGetId(workerId);
        var workName = $("#collectWorkerName").val();
        var collectId = getCollectId(workerId,workerCode);
        updatesubmitQualityCollectionQuestion1(collectId);
        updatesubmitQualityCollectionQuestion2(collectId);
        updatesubmitQualityCollectionQuestion3(collectId);
        updatesubmitQualityCollectionQuestion4(collectId);
        updatesubmitQualityCollectionQuestion5(collectId);
        updateAddOrUpdateUserInfo(id,workerId,collectId);
        setTimeout(loadUpdatePageRecord(workerId,workName),2500);
    });
    $('.returnBtn').click(function () {
        var workName = $("#collectWorkerName").val();
        loadUpdatePageRecord(workerId,workName)
    });
    $('#saveAddNew').remove();
};

function getQualityCollectInfo() {
    $.ajax({
        type:"GET",
        url: "/quality/collect/get_collect_userList/1",
        dataType:"json",
        success: function (data) {
            $("#qualityCollectTableRow").html("");
            console.log(data);
            var tableRow = data.data;
            $.each(tableRow , function (index, optiondata) {
                var count = 0;
                count =optiondata.collectCount;
                if(optiondata.productCode!=="") {
                    var tableHtml = "<tr>"
                        +"<td>"+optiondata.workerCode+"</td>"
                        +"<td>"+optiondata.workerName+"</td>"
                        +"<td><span class='btn btn-default ldelBtn'>"+count+"次</span></td>"
                        +"<td><a class='btn btn-default ldelBtn' onclick='loadqualityInspectionCollectionAdditionPage(&quot;"+optiondata.workerCode+"&quot,&quot;"+optiondata.workerId+"&quot,&quot;"+count +"&quot,&quot;"+optiondata.workerName +"&quot;)'>添加数据</a>"
                        // +"<a class='btn btn-default btn-default2' onclick='updateQualityInspectionCollectionAdditionPage(&quot;"+optiondata.workerCode+"&quot,&quot;"+optiondata.workerId+"&quot,&quot;"+count +"&quot;)'>查看修改</a></td></tr>";
                        +"<a class='btn btn-default btn-default2' onclick='loadUpdatePageRecord(&quot;"+optiondata.workerId+"&quot,&quot;"+optiondata.workerName+"&quot;)'>查看修改</a></td></tr>";
                    $("#qualityCollectTableRow").append(tableHtml);
                } else {
                    var tableHtml = "<tr>"
                        +"<td>"+optiondata.workerCode+"</td>"
                        +"<td>"+optiondata.workerName+"</td>"
                        +"<td><span class='btn btn-default ldelBtn '>"+count+"次</span></td>"
                        +"<td><a class='btn btn-default ldelBtn disabled' onclick='loadqualityInspectionCollectionAdditionPage(&quot;"+optiondata.workerCode+"&quot,&quot;"+optiondata.workerId+"&quot,&quot;"+count +"&quot,&quot;"+optiondata.workerName +"&quot;)'>添加数据</a>"
                        // +"<a class='btn btn-default btn-default2' onclick='updateQualityInspectionCollectionAdditionPage(&quot;"+optiondata.workerCode+"&quot,&quot;"+optiondata.workerId+"&quot,&quot;"+count +"&quot;)'>查看修改</a></td></tr>";
                        +"<a class='btn btn-default btn-default2 disabled' onclick='loadUpdatePageRecord(&quot;"+optiondata.workerId+"&quot,&quot;"+optiondata.workerName+"&quot;)'>查看修改</a></td></tr>";
                    $("#qualityCollectTableRow").append(tableHtml);
                }
            });
        }
    })
}

function getQualityCollectSelectInfo() {
    var workerCode = $("#qualityWorkerCode").val();
    if(workerCode==="") {
        workerCode="empty";
    }
    $.ajax({
        type:"GET",
        url: "/quality/collect/get_collect_homepage_info/",
        dataType:"json",
        data:{workerCode:workerCode},
        success: function (data) {
            $("#qualityCollectTableRow").html("");
            console.log(data);
            var tableRow = data.data;
            $.each(tableRow , function (index, optiondata) {
                var count = 0;
                count =optiondata.collectCount;
                if(optiondata.productCode!=="") {
                    var tableHtml = "<tr>"
                        +"<td>"+optiondata.workerCode+"</td>"
                        +"<td>"+optiondata.workerName+"</td>"
                        +"<td><span class='btn btn-default ldelBtn'>"+count+"次</span></td>"
                        +"<td><a class='btn btn-default ldelBtn' onclick='loadqualityInspectionCollectionAdditionPage(&quot;"+optiondata.workerCode+"&quot,&quot;"+optiondata.workerId+"&quot,&quot;"+count +"&quot,&quot;"+optiondata.workerName +"&quot;)'>添加数据</a>"
                        // +"<a class='btn btn-default btn-default2' onclick='updateQualityInspectionCollectionAdditionPage(&quot;"+optiondata.workerCode+"&quot,&quot;"+optiondata.workerId+"&quot,&quot;"+count +"&quot;)'>查看修改</a></td></tr>";
                        +"<a class='btn btn-default btn-default2' onclick='loadUpdatePageRecord(&quot;"+optiondata.workerId+"&quot,&quot;"+optiondata.workerName+"&quot;)'>查看修改</a></td></tr>";
                    $("#qualityCollectTableRow").append(tableHtml);
                } else {
                    var tableHtml = "<tr>"
                        +"<td>"+optiondata.workerCode+"</td>"
                        +"<td>"+optiondata.workerName+"</td>"
                        +"<td><span class='btn btn-default ldelBtn '>"+count+"次</span></td>"
                        +"<td><a class='btn btn-default ldelBtn disabled' disabled='disabled' onclick='loadqualityInspectionCollectionAdditionPage(&quot;"+optiondata.workerCode+"&quot,&quot;"+optiondata.workerId+"&quot,&quot;"+count +"&quot,&quot;"+optiondata.workerName +"&quot;)'>添加数据</a>"
                        // +"<a class='btn btn-default btn-default2' onclick='updateQualityInspectionCollectionAdditionPage(&quot;"+optiondata.workerCode+"&quot,&quot;"+optiondata.workerId+"&quot,&quot;"+count +"&quot;)'>查看修改</a></td></tr>";
                        +"<a class='btn btn-default btn-default2 disabled' disabled='disabled' onclick='loadUpdatePageRecord(&quot;"+optiondata.workerId+"&quot,&quot;"+optiondata.workerName+"&quot;)'>查看修改</a></td></tr>";
                    $("#qualityCollectTableRow").append(tableHtml);
                }
            });
        }
    })
}



function initQualityCollectForm(workerId,workerCode) {
    var returnData=[];
    $.ajax({
        type:"POST",
        url: "/quality/collect/get_worker_productCode",
        dataType:"json",
        data:{workerCode:workerCode,workerId:workerId},
        success: function (data) {
            returnData = data.data;
            $.each(data.data, function(index, optiondata) {
                $("#collectWorkerName").val(optiondata.workerName);
                $("#productNameSel").append('<option value="'+optiondata.productId+'">' + optiondata.productDetail + '</option>')
            });
        }
    })
    collectKilnNameSel();
    collectLevelNameSel();
    get_quality_category_questionType1();
    get_quality_category_questionType2();
    get_quality_category_questionType3();
    get_quality_category_questionType4();
    get_quality_category_questionType5();

    // submitQualityCollectionQuestion1();
}

function collectKilnNameSel() {
    $.ajax({
        type:"POST",
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
        type:"POST",
        url: "/quality/collect/get_rank_title",
        dataType:"json",
        async: false,
        success: function (data) {
            $("#levelNameSel").attr("disabled", false);
            // console.log(data);
            $.each(data.data, function(index, optiondata) {
                $("#levelNameSel").append('<option value="'+optiondata.rankId+'">' + optiondata.rankIdName + '</option>')
            });
        }
    })
}
//问题详情
function get_quality_category_questionType1() {
    var questionCollectType = 1;
    $.ajax({
        type:"POST",
        url: "/quality/collect/get_quality_category",
        dataType:"json",
        async: false,
        data:{questionCollectType:questionCollectType},
        success: function (data) {
            $("#questionType1").html("");
            $.each(data.data, function(index, optiondata) {
                var coefxHtml = '';
                if(optiondata.collectType===1) {
                    coefxHtml = '<td class="coefficient-1">'
                        +'</td>';
                } else if(optiondata.collectType===2) {
                    coefxHtml = '<td class="coefficient-2">'
                        +'<input type="text" class="form-control">'
                        +'</td>';
                } else {
                    coefxHtml = '<td class="coefficient-1">'
                        +'</td>';
                }
                var questionHtml ='<tr>'
                    +'<td id="questionType1-'+optiondata.qualityId+'-'+optiondata.workerId+'">'+optiondata.qualityIdName+'</td>'
                    +'<td>'
                    +'<input type="text" class="form-control">'
                    +'</td>'
                    +coefxHtml
                    +'</tr>';
                $("#questionType1").append(questionHtml);
            });
        }
    })
}

function get_quality_category_questionType2() {
    var questionCollectType = 2;
    $.ajax({
        type:"POST",
        url: "/quality/collect/get_quality_category",
        dataType:"json",
        async: false,
        data:{questionCollectType:questionCollectType},
        success: function (data) {
            console.log(data);
            $("#questionType2").html("");
            $.each(data.data, function(index, optiondata) {
                var coefxHtml = '';
                if(optiondata.collectType===1) {
                    coefxHtml = '<td class="coefficient-1">'
                        +'</td>';
                } else if(optiondata.collectType===2) {
                    coefxHtml = '<td class="coefficient-2">'
                        +'<input type="text" class="form-control">'
                        +'</td>';
                } else {
                    coefxHtml = '<td class="coefficient-1">'
                        +'</td>';
                }
                var questionHtml ='<tr>'
                    +'<td id="questionType2-'+optiondata.qualityId+'-'+optiondata.workerId+'">'+optiondata.qualityIdName+'</td>'
                    +'<td>'
                    +'<input type="text" class="form-control">'
                    +'</td>'
                    +coefxHtml
                    +'</tr>';
                $("#questionType2").append(questionHtml);
            });
        }
    })
    var workerSel = get_user_category(2);
    $.each(workerSel, function(index, optiondata) {
        $("#collectQuestionWorkerSel2").append('<option>' + optiondata.userNameCode + '</option>')
    });
}

function get_quality_category_questionType3() {
    var questionCollectType = 3;
    $.ajax({
        type:"POST",
        url: "/quality/collect/get_quality_category",
        dataType:"json",
        async: false,
        data:{questionCollectType:questionCollectType},
        success: function (data) {
            // console.log("get_quality_category_questionType3");
            // console.log(data);
            $("#questionType3").html("");
            $.each(data.data, function(index, optiondata) {
                var coefxHtml = '';
                if(optiondata.collectType===1) {
                    coefxHtml = '<td class="coefficient-1">'
                        +'</td>';
                } else if(optiondata.collectType===2) {
                    coefxHtml = '<td class="coefficient-2">'
                        +'<input type="text" class="form-control">'
                        +'</td>';
                }else{
                    coefxHtml = '<td class="coefficient-1">'
                        +'</td>';
                }
                var questionHtml ='<tr>'
                    +'<td id="questionType3-'+optiondata.qualityId+'-'+optiondata.workerId+'">'+optiondata.qualityIdName+'</td>'
                    +'<td>'
                    +'<input type="text" class="form-control">'
                    +'</td>'
                    +coefxHtml
                    +'</tr>';
                $("#questionType3").append(questionHtml);
            });
        }
    })
    var workerSel = get_user_category(3);
    $.each(workerSel, function(index, optiondata) {
        $("#collectQuestionWorkerSel3").append('<option>' + optiondata.userNameCode + '</option>')
    });
}

function get_quality_category_questionType4() {
    var questionCollectType = 4;
    $.ajax({
        type:"POST",
        url: "/quality/collect/get_quality_category",
        dataType:"json",
        async: false,
        data:{questionCollectType:questionCollectType},
        success: function (data) {
            $("#questionType4").html("");
            $.each(data.data, function(index, optiondata) {
                var coefxHtml = '';
                if(optiondata.collectType===1) {
                    coefxHtml = '<td class="coefficient-1">'
                        +'</td>';
                } else if(optiondata.collectType===2) {
                    coefxHtml = '<td class="coefficient-2">'
                        +'<input type="text" class="form-control">'
                        +'</td>';
                } else {
                    coefxHtml = '<td class="coefficient-1">'
                        +'</td>';
                }
                var questionHtml ='<tr>'
                    +'<td id="questionType4-'+optiondata.qualityId+'-'+optiondata.workerId+'">'+optiondata.qualityIdName+'</td>'
                    +'<td>'
                    +'<input type="text" class="form-control">'
                    +'</td>'
                    +coefxHtml
                    +'</tr>';
                $("#questionType4").append(questionHtml);
            });
        }
    })
    var workerSel = get_user_category(4);
    $.each(workerSel, function(index, optiondata) {
        $("#collectQuestionWorkerSel4").append('<option>' + optiondata.userNameCode + '</option>')
    });
}

function get_quality_category_questionType5() {
    var questionCollectType = 5;
    $.ajax({
        type:"POST",
        url: "/quality/collect/get_quality_category",
        dataType:"json",
        async: false,
        data:{questionCollectType:questionCollectType},
        success: function (data) {
            $("#questionType5").html("");
            $.each(data.data, function(index, optiondata) {
                var coefxHtml = '';
                if(optiondata.collectType===1) {
                    coefxHtml = '<td class="coefficient-1">'
                        +'</td>';
                } else if(optiondata.collectType===2) {
                    coefxHtml = '<td class="coefficient-2">'
                        +'<input type="text" class="form-control">'
                        +'</td>';
                }else {
                    coefxHtml = '<td class="coefficient-1">'
                        +'</td>';
                }
                var questionHtml ='<tr>'
                    +'<td id="questionType5-'+optiondata.qualityId+'-'+optiondata.workerId+'">'+optiondata.qualityIdName+'</td>'
                    +'<td>'
                    +'<input type="text" class="form-control">'
                    +'</td>'
                    +coefxHtml
                    +'</tr>';
                $("#questionType5").append(questionHtml);
            });
        }
    })
    var workerSel = get_user_category(4);
    $.each(workerSel, function(index, optiondata) {
        $("#collectQuestionWorkerSel4").append('<option>' + optiondata.userNameCode + '</option>')
    });
}

//提交
function submitQualityCollectionQuestion1(collectId) {
    var qeustionType = $("#questionType1 > tr");
    // console.log(qeustionType);
    for(var i = 0; i < qeustionType.length; i++) {
        var infoTh = $(qeustionType[i].children[0]).attr("id").split("-");
        //需要输入的信息
        var questionType = 1;
        var userId =  infoTh[2];
        var collectType = $(qeustionType[i].children[2]).attr("class").split("-")[1];
        var questionId = infoTh[1];
        var questionName = $(qeustionType[i].children[0]).text();
        var quantity = $(qeustionType[i].children[1].children).val();
        var coefficient = $(qeustionType[i].children[2].children).val();
        $.ajax({
            type:"POST",
            url: "/quality/collect/addOrUpdate_question",
            dataType:"json",
            async: false,
            data:{collectId:collectId,questionType:questionType,userId:userId,collectType:collectType,questionId:questionId,questionName:questionName,quantity:quantity,coefficient:coefficient},
            success:function (data) {
                // console.log(data.msg);
            }
        })
    }
}

function submitQualityCollectionQuestion2(collectId) {
    var qeustionType = $("#questionType2 > tr");
    // console.log(qeustionType);
    for(var i = 0; i < qeustionType.length; i++) {
        var infoTh = $(qeustionType[i].children[0]).attr("id").split("-");
        //需要输入的信息
        var questionType = 2;
        var userId =  infoTh[2];
        var collectType = $(qeustionType[i].children[2]).attr("class").split("-")[1];
        var questionId = infoTh[1];
        var questionName = $(qeustionType[i].children[0]).text();
        var quantity = $(qeustionType[i].children[1].children).val();
        var coefficient = $(qeustionType[i].children[2].children).val();
        var workName = $('#collectQuestionWorkerSel2').children('option:selected').text();
        $.ajax({
            type:"POST",
            url: "/quality/collect/addOrUpdate_question",
            dataType:"json",
            async: false,
            data:{collectId:collectId,workName:workName,questionType:questionType,userId:userId,collectType:collectType,questionId:questionId,questionName:questionName,quantity:quantity,coefficient:coefficient},
            success:function (data) {
                // console.log(data.msg);
            }
        })
    }
}

function submitQualityCollectionQuestion3(collectId) {
    var qeustionType = $("#questionType3 > tr");
    // console.log(qeustionType);
    for(var i = 0; i < qeustionType.length; i++) {
        var infoTh = $(qeustionType[i].children[0]).attr("id").split("-");
        //需要输入的信息
        var questionType = 3;
        var userId =  infoTh[2];
        var collectType = $(qeustionType[i].children[2]).attr("class").split("-")[1];
        var questionId = infoTh[1];
        var questionName = $(qeustionType[i].children[0]).text();
        var quantity = $(qeustionType[i].children[1].children).val();
        var coefficient = $(qeustionType[i].children[2].children).val();
        var workName = $('#collectQuestionWorkerSel3').children('option:selected').text();
        $.ajax({
            type:"POST",
            url: "/quality/collect/addOrUpdate_question",
            dataType:"json",
            async: false,
            data:{collectId:collectId,workName:workName,questionType:questionType,userId:userId,collectType:collectType,questionId:questionId,questionName:questionName,quantity:quantity,coefficient:coefficient},
            success:function (data) {
                // console.log(data.msg);
            }
        })
    }
}

function submitQualityCollectionQuestion4(collectId) {
    var qeustionType = $("#questionType4 > tr");
    // console.log(qeustionType);
    for(var i = 0; i < qeustionType.length; i++) {
        var infoTh = $(qeustionType[i].children[0]).attr("id").split("-");
        //需要输入的信息
        var questionType = 4;
        var userId =  infoTh[2];
        var collectType = $(qeustionType[i].children[2]).attr("class").split("-")[1];
        var questionId = infoTh[1];
        var questionName = $(qeustionType[i].children[0]).text();
        var quantity = $(qeustionType[i].children[1].children).val();
        var coefficient = $(qeustionType[i].children[2].children).val();
        var workName = $('#collectQuestionWorkerSel4').children('option:selected').text();
        $.ajax({
            type:"POST",
            url: "/quality/collect/addOrUpdate_question",
            dataType:"json",
            async: false,
            data:{collectId:collectId,workName:workName,questionType:questionType,userId:userId,collectType:collectType,questionId:questionId,questionName:questionName,quantity:quantity,coefficient:coefficient},
            success:function (data) {
                // console.log(data.msg);
            }
        })
    }
}

function submitQualityCollectionQuestion5(collectId) {
    var qeustionType = $("#questionType5 > tr");
    // console.log(qeustionType);
    for(var i = 0; i < qeustionType.length; i++) {
        var infoTh = $(qeustionType[i].children[0]).attr("id").split("-");
        //需要输入的信息
        var questionType = 5;
        var userId =  infoTh[2];
        var collectType = $(qeustionType[i].children[2]).attr("class").split("-")[1];
        var questionId = infoTh[1];
        var questionName = $(qeustionType[i].children[0]).text();
        var quantity = $(qeustionType[i].children[1].children).val();
        var coefficient = $(qeustionType[i].children[2].children).val();
        var workName = $('#collectQuestionWorkerSel5').children('option:selected').text();
        // console.log(workName);
        $.ajax({
            type:"POST",
            url: "/quality/collect/addOrUpdate_question",
            dataType:"json",
            async: false,
            data:{collectId:collectId,workName:workName,questionType:questionType,userId:userId,collectType:collectType,questionId:questionId,questionName:questionName,quantity:quantity,coefficient:coefficient},
            success:function (data) {
                // console.log(data.msg);
            }
        })
    }
}

function addOrUpdateUserInfo(userId,collectId) {
    var yaoluId = $('#kilinNameSel').children('option:selected').val();
    var productId=$('#productNameSel').children('option:selected').val();
    var rankId = $('#levelNameSel').children('option:selected').val();
    var quantity = $("#userQuantityInp").val();
    console.log("collectId：==>"+collectId);
    $.ajax({
        type:"POST",
        url: "/quality/collect/addOrUpdate",
        dataType:"json",
        async: false,
        data:{collectId:collectId,userId:userId,yaoluId:yaoluId,productId:productId,rankId:rankId,quantity:quantity},
        success:function (data) {
            // console.log("addOrUpdateUserInfo is successful")
            // console.log(data);
        }
    })
    
}

function updateAddOrUpdateUserInfo(id,userId,collectId) {
    var yaoluId = $('#kilinNameSel').children('option:selected').val();
    var productId=$('#productNameSel').children('option:selected').val();
    var rankId = $('#levelNameSel').children('option:selected').val();
    var quantity = $("#userQuantityInp").val();
    // console.log("collectId：==>"+collectId);
    $.ajax({
        type:"POST",
        url: "/quality/collect/addOrUpdate",
        dataType:"json",
        async: false,
        data:{id:id,collectId:collectId,userId:userId,yaoluId:yaoluId,productId:productId,rankId:rankId,quantity:quantity},
        success:function (data) {
            // console.log("addOrUpdateUserInfo is successful")
            // console.log(data);
        }
    })

}

// function updateCollectCount(workerId,count,collectId) {
//     // console.log("count:"+count);
//     $.ajax({
//         type:"POST",
//         url: "/quality/collect/update_collect_count",
//         dataType:"json",
//         async: false,
//         data:{workerId:workerId,count:count,collectId:collectId},
//         success:function () {
//             setTimeout('$("#form_box").mask("数据保存完成.");',1000);
//             setTimeout(' $("#container").load("pages/dataCollection/qualityInspectionCollection/index.html", null, function() {getQualityCollectInfo();})',1001);
//         }
//     })
// }
//获取Collect
function getCollectId(workerId,workerCode) {
    var s = [];
    var hexDigits = "0123456789abcdef";
    for (var i = 0; i < 36; i++) {
        s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
    }
    s[14] = "4";  // bits 12-15 of the time_hi_and_version field to 0010
    s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1);  // bits 6-7 of the clock_seq_hi_and_reserved to 01
    s[8] = s[13] = s[18] = s[23] = "-";
    var uuid = s.join("");
    return uuid;
}
//员工信息
function get_user_category(category) {
    var rData = [];
    $.ajax({
        type:"POST",
        url: "/quality/collect/get_user_category",
        dataType:"json",
        async: false,
        data:{category:category},
        success: function (data) {
            rData = data.data;
        }
    })
    return rData;
}

// function updateGetId(workerId) {
//     var rData = [];
//     $.ajax({
//         type:"GET",
//         url: "/quality/collect/get_quality_collect_detail",
//         dataType:"json",
//         async: false,
//         data:{workerId:workerId},
//         success: function (data) {
//             console.log(data);
//             rData = data.data;
//         }
//     })
//     return rData.id;
// }

function updateCollection(workerId,collectId) {
    // console.log("updateCollection");
    // console.log(typeof (workerId));
    var rData = [];
    $.ajax({
        type:"GET",
        url: "/quality/collect/get_quality_collect_detail/"+workerId+"/"+collectId,
        dataType:"json",
        async: false,
        success: function (data) {
            console.log(data);
            rData = data.data;
        }
    })
    $("#kilinNameSel option:contains("+rData.kilnName+")").attr("selected", true);
    $("#productNameSel option:contains("+rData.productCode+")").attr("selected", true);
    $("#levelNameSel option:contains("+rData.rankName+")").attr("selected", true);
    $("#userQuantityInp").val(rData.quantity);
    var questionData = rData.qualityTypeVoList;
    for(var i=0; i < questionData.length; i++) {
        var questionID= "questionType"+questionData[i].questionType+"-"+questionData[i].questionId+"-"+questionData[i].workerId;
        console.log(questionData[i].workerId);
        console.log(questionID);
        // console.log($("#"+questionID+"").next().next().children());
        $("#"+questionID+"").next().children().val(questionData[i].questionQuantity);
        $("#"+questionID+"").next().next().children().val(questionData[i].coefficient);
        var newQID = questionID+"-"+questionData[i].id;
        $("#"+questionID+"").attr('id',newQID);
        $("#collectQuestionWorkerSel"+questionData[i].questionType+" option:contains("+rData.questionWorkerName+")").attr("selected", true);
    }
}

function updatesubmitQualityCollectionQuestion1(collectId) {
    var qeustionType = $("#questionType1 > tr");
    // console.log(qeustionType);
    for(var i = 0; i < qeustionType.length; i++) {
        var infoTh = $(qeustionType[i].children[0]).attr("id").split("-");
        //需要输入的信息
        var questionType = 1;
        var userId =  infoTh[2];
        var id = infoTh[3];
        var collectType = $(qeustionType[i].children[2]).attr("class").split("-")[1];
        var questionId = infoTh[1];
        var questionName = $(qeustionType[i].children[0]).text();
        var quantity = $(qeustionType[i].children[1].children).val();
        var coefficient = $(qeustionType[i].children[2].children).val();
        $.ajax({
            type:"POST",
            url: "/quality/collect/addOrUpdate_question",
            dataType:"json",
            async: false,
            data:{id:id,collectId:collectId,questionType:questionType,userId:userId,collectType:collectType,questionId:questionId,questionName:questionName,quantity:quantity,coefficient:coefficient},
            success:function (data) {
                // console.log(data.msg);
            }
        })
    }
}

function updatesubmitQualityCollectionQuestion2(collectId) {
    var qeustionType = $("#questionType2 > tr");
    // console.log(qeustionType);
    for(var i = 0; i < qeustionType.length; i++) {
        var infoTh = $(qeustionType[i].children[0]).attr("id").split("-");
        //需要输入的信息
        var questionType = 2;
        var userId =  infoTh[2];
        var id = infoTh[3];
        var collectType = $(qeustionType[i].children[2]).attr("class").split("-")[1];
        var questionId = infoTh[1];
        var questionName = $(qeustionType[i].children[0]).text();
        var quantity = $(qeustionType[i].children[1].children).val();
        var coefficient = $(qeustionType[i].children[2].children).val();
        var workName = $('#collectQuestionWorkerSel2').children('option:selected').text();
        $.ajax({
            type:"POST",
            url: "/quality/collect/addOrUpdate_question",
            dataType:"json",
            async: false,
            data:{id:id,collectId:collectId,workName:workName,questionType:questionType,userId:userId,collectType:collectType,questionId:questionId,questionName:questionName,quantity:quantity,coefficient:coefficient},
            success:function (data) {
                // console.log(data.msg);
            }
        })
    }
}

function updatesubmitQualityCollectionQuestion3(collectId) {
    var qeustionType = $("#questionType3 > tr");
    // console.log(qeustionType);
    for(var i = 0; i < qeustionType.length; i++) {
        var infoTh = $(qeustionType[i].children[0]).attr("id").split("-");
        //需要输入的信息
        var questionType = 3;
        var userId =  infoTh[2];
        var id = infoTh[3];
        var collectType = $(qeustionType[i].children[2]).attr("class").split("-")[1];
        var questionId = infoTh[1];
        var questionName = $(qeustionType[i].children[0]).text();
        var quantity = $(qeustionType[i].children[1].children).val();
        var coefficient = $(qeustionType[i].children[2].children).val();
        var workName = $('#collectQuestionWorkerSel3').children('option:selected').text();
        $.ajax({
            type:"POST",
            url: "/quality/collect/addOrUpdate_question",
            dataType:"json",
            async: false,
            data:{id:id,collectId:collectId,workName:workName,questionType:questionType,userId:userId,collectType:collectType,questionId:questionId,questionName:questionName,quantity:quantity,coefficient:coefficient},
            success:function (data) {
                // console.log(data.msg);
            }
        })
    }
}

function updatesubmitQualityCollectionQuestion4(collectId) {
    var qeustionType = $("#questionType4 > tr");
    // console.log(qeustionType);
    for(var i = 0; i < qeustionType.length; i++) {
        var infoTh = $(qeustionType[i].children[0]).attr("id").split("-");
        //需要输入的信息
        var questionType = 4;
        var userId =  infoTh[2];
        var id = infoTh[3];
        var collectType = $(qeustionType[i].children[2]).attr("class").split("-")[1];
        var questionId = infoTh[1];
        var questionName = $(qeustionType[i].children[0]).text();
        var quantity = $(qeustionType[i].children[1].children).val();
        var coefficient = $(qeustionType[i].children[2].children).val();
        var workName = $('#collectQuestionWorkerSel4').children('option:selected').text();
        $.ajax({
            type:"POST",
            url: "/quality/collect/addOrUpdate_question",
            dataType:"json",
            async: false,
            data:{id:id,collectId:collectId,workName:workName,questionType:questionType,userId:userId,collectType:collectType,questionId:questionId,questionName:questionName,quantity:quantity,coefficient:coefficient},
            success:function (data) {
                // console.log(data.msg);
            }
        })
    }
}

function updatesubmitQualityCollectionQuestion5(collectId) {
    var qeustionType = $("#questionType5 > tr");
    // console.log(qeustionType);
    for(var i = 0; i < qeustionType.length; i++) {
        var infoTh = $(qeustionType[i].children[0]).attr("id").split("-");
        //需要输入的信息
        var questionType = 5;
        var userId =  infoTh[2];
        var id = infoTh[3];
        var collectType = $(qeustionType[i].children[2]).attr("class").split("-")[1];
        var questionId = infoTh[1];
        var questionName = $(qeustionType[i].children[0]).text();
        var quantity = $(qeustionType[i].children[1].children).val();
        var coefficient = $(qeustionType[i].children[2].children).val();
        var workName = $('#collectQuestionWorkerSel5').children('option:selected').text();
        // console.log(workName);
        $.ajax({
            type:"POST",
            url: "/quality/collect/addOrUpdate_question",
            dataType:"json",
            async: false,
            data:{id:id,collectId:collectId,workName:workName,questionType:questionType,userId:userId,collectType:collectType,questionId:questionId,questionName:questionName,quantity:quantity,coefficient:coefficient},
            success:function (data) {
                // console.log(data.msg);
            }
        })
    }
}