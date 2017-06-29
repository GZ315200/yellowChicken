package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.igeek.dao.QualityMapper;
import org.igeek.dao.UserCategoryMapper;
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

    @Test
    public void getResult(){
        System.out.println(userCategoryMapper.getUserList(1));
    }

    @Test
    public void getRes() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
       String result = objectMapper.writeValueAsString(userCategoryMapper.getUserList(1));
        System.out.println(result);
    }
}
