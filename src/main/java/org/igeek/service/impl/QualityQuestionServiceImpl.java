package org.igeek.service.impl;

import org.igeek.common.ResponseCode;
import org.igeek.common.ServerResponse;
import org.igeek.dao.QualityMapper;
import org.igeek.dao.QualityQuestionMapper;
import org.igeek.dao.UserMapper;
import org.igeek.pojo.Quality;
import org.igeek.pojo.QualityQuestion;
import org.igeek.pojo.User;
import org.igeek.service.IQualityQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Gyges on 2017/7/4.
 */
@Service(value = "iQualityQuestionService")
public class QualityQuestionServiceImpl implements IQualityQuestionService {

    @Autowired
    private QualityMapper qualityMapper;
    @Autowired
    private QualityQuestionMapper qualityQuestionMapper;
    @Autowired
    private UserMapper userMapper;




    @Override
    public ServerResponse<String> addOrUpdateQuestion(QualityQuestion qualityQuestion) {
        if (Objects.nonNull(qualityQuestion.getCoefficient()) && Objects.nonNull(qualityQuestion.getCollectType())) {
            List<Quality> qualityList = qualityMapper.selectAllQualityQuestion(1, qualityQuestion.getCollectType());
            if (qualityList.size() > 0) {
                for(Quality quality : qualityList){
                    qualityQuestion = assembleQualityQuestion(quality);
//                    如果输入的不是成型问题
                    if(qualityQuestion.getId() == null){
                        List<User> userList = null;
                        switch (qualityQuestion.getCollectType()){
                            case 2:
                                userList = userMapper.getUserCategoryList(2);
                                for(User user : userList){
                                    qualityQuestion.setUserId(user.getId());
                                }
                                break;
                            case 3:
                                userList = userMapper.getUserCategoryList(3);
                                for(User user:userList){
                                    qualityQuestion.setUserId(user.getId());
                                }
                                break;
                            case 4:
                                userList = userMapper.getUserCategoryList(4);
                                for(User user:userList){
                                    qualityQuestion.setUserId(user.getId());
                                }
                                break;
                            case 5:
                                userList = userMapper.getUserCategoryList(5);
                                for(User user:userList){
                                    qualityQuestion.setUserId(user.getId());
                                }
                                break;
                            default:
                                break;
                        }
                        int rowCount = qualityQuestionMapper.insert(qualityQuestion);
                        if(rowCount > 0){
                            return ServerResponse.createBySuccess("插入质量问题信息成功");
                        }
                        return ServerResponse.createByErrorMsg("插入质量问题信息失败");
                    }else{
                        int resultCount = qualityQuestionMapper.updateByPrimaryKey(qualityQuestion);
                        if(resultCount > 0){
                            return ServerResponse.createBySuccess("更新质量问题信息成功");
                        }
                        return ServerResponse.createByErrorMsg("更新质量问题信息失败");
                    }

                }
            }
            return ServerResponse.createByErrorMsg("无此类问题信息");
        }
        return ServerResponse.createByErrorCodeAndMsg(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getCodeDesc());
    }


    /**
     * 重新封装数据
     * @param quality
     * @return
     */
    private QualityQuestion assembleQualityQuestion(Quality quality){
        QualityQuestion qualityQuestion = new QualityQuestion();
        qualityQuestion.setCollectType(quality.getQuestionType());
        qualityQuestion.setQuestionId(quality.getId());
        qualityQuestion.setQuestionName(quality.getTitle());
        return qualityQuestion;
    }


    public ServerResponse<QualityQuestion> getQualityQuestionList(Integer collectType){
        if(Objects.nonNull(collectType)){
            QualityQuestion qualityQuestion = qualityQuestionMapper.getQualityQuestionList(collectType);
            if(Objects.nonNull(qualityQuestion)){
                return ServerResponse.createBySuccess(qualityQuestion);
            }
            return ServerResponse.createByErrorMsg("获取质量问题信息失败");
        }
        return ServerResponse.createByErrorCodeAndMsg(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getCodeDesc());
    }





}
