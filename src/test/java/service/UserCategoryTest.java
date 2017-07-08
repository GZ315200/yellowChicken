package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.igeek.dao.QualityMapper;
import org.igeek.dao.QualityQuestionMapper;
import org.igeek.dao.UserCategoryMapper;
import org.igeek.dao.UserMapper;
import org.igeek.service.IKilnService;
import org.igeek.service.IQualityCollectService;
import org.igeek.service.IQualityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Gyges on 2017/6/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class UserCategoryTest {

    @Resource
    private UserCategoryMapper userCategoryMapper;
    @Resource
    private QualityMapper qualityMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private QualityQuestionMapper qualityQuestionMapper;

    @Resource
    private IQualityCollectService iQualityCollectService;

    @Resource
    private IQualityService iQualityService;

    @Resource
    private IKilnService iKilnService;

//    @Resource
//    private IQualityCollectService iQualityCollectService;

    @Test
    public void getResult() throws JsonProcessingException {
//        System.out.println(userCategoryMapper.getUserList(1));
        ObjectMapper objectMapper = new ObjectMapper();
//        String result = objectMapper.(iKilnService.searchKilnNameList(1));
//        System.out.println(result);writeValueAsString
    }

    @Test
    public void getRes() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(userCategoryMapper.getUserList(1));
        System.out.println(result);
    }


    @Test
    public void getResultList() {
//        List<QualityQuestion> qualityQuestionList = Lists.newArrayList();
//        QualityQuestion qualityQuestion = new QualityQuestion();
//        qualityQuestion.setCoefficient(12.99);
//        qualityQuestion.setQuality(2);
//        qualityQuestionList.add(qualityQuestion);
//        QualityQuestion qualityQuestion1 = new QualityQuestion();
//        qualityQuestion1.setCoefficient(3.30);
//        qualityQuestion1.setQuality(2);
//        qualityQuestionList.add(qualityQuestion1);
////        qualityQuestionMapper.insertQuestionBatch(qualityQuestionList);


    }


}
