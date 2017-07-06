//package org.igeek.controller.collect;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import org.igeek.common.JsonMapper;
//import org.igeek.common.ServerResponse;
//import org.igeek.pojo.QualityCollection;
//import org.igeek.pojo.QualityQuestion;
//import org.igeek.service.IQualityCollectService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.io.IOException;
//
///**
// * Created by Gyges on 2017/7/5.
// */
//@Controller
//@RequestMapping("/submit/")
//public class SubmitAddOrUpdateController {
//
//    public static final Logger logger = LoggerFactory.getLogger(SubmitAddOrUpdateController.class);
//
//    @Autowired
//    private QualityCollectController collectController;
//
//    @Autowired
//    private IQualityCollectService iQualityCollectService;
//
//    @Autowired
//    private JsonMapper jsonMapper;
//
//
//    /**
//     * 提交需要保存的质量采集信息
//     * @param qualityCollection
//     * @param qualityQuestion
//     * @return
//     */
//    @RequestMapping("save_info")
//    @ResponseBody
//    public ServerResponse<String> submitSaveInfo(QualityCollection qualityCollection, QualityQuestion qualityQuestion){
//        ServerResponse<String> serverResponse = null;
//        try {
//          serverResponse =  submitInfoService(qualityCollection, qualityQuestion);
//        } catch (IOException e) {
//            logger.error("保存信息异常",e);
//            e.printStackTrace();
//        }
//        return serverResponse;
//    }
//
//    /**
//     * 1.判断采集信息的数据是否成功
//     * 2.查询采集信息id
//     * 3.set 进 质量问题表id
//     * 4.根据质量问题的id，插入质量问题的信息
//     * 5.判断质量问题插入信息是否响应成功
//     * 6。将质量问题的id赋予更新count的值
//     */
//
//    private ServerResponse<String> submitInfoService(QualityCollection qualityCollection, QualityQuestion qualityQuestion) throws IOException {
//
//        ServerResponse<String> response = collectController.addOrUpdateInfo(qualityCollection);
//        if(response.isSuccess()){
//            ServerResponse collectResponse = iQualityCollectService.searchAllCollectList();
//            if(collectResponse.isSuccess()){
//                String json = jsonMapper.writeValueAsString(collectResponse);
//                JsonNode jsonNode = jsonMapper.readTree(json);
//
//            }
//        }
//        return null;
//    }
//
//
//}
