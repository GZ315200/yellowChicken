package org.igeek.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.igeek.common.ResponseCode;
import org.igeek.common.ServerResponse;
import org.igeek.dao.KilnMapper;
import org.igeek.pojo.Kiln;
import org.igeek.service.IKilnService;
import org.igeek.vo.KilnVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Gyges on 2017/6/27.
 */
@Service(value = "iKilnService")
public class KilnServiceImpl implements IKilnService {

    @Autowired
    private KilnMapper kilnMapper;


    /**
     * 增加或更新窑炉信息
     *
     * @param kiln
     * @return
     */
    public ServerResponse<String> updateOrSaveKilnValue(Kiln kiln) {
        if (Objects.equal(kiln, null)) {
            return ServerResponse.createByErrorMsg("请输入完整窑炉信息");
        }
        if (kiln.getId() != null) {
            int rowCount = kilnMapper.updateByPrimaryKeySelective(kiln);
            if (rowCount > 0) {
                return ServerResponse.createBySuccess("窑炉信息更新成功");
            }
            return ServerResponse.createByErrorMsg("窑炉信息更新失败");
        } else {
//            插入时先判断该窑炉信息是否存在
            int resultCount = kilnMapper.selectBykilnName(kiln.getTitle());
            if (resultCount > 0) {
                return ServerResponse.createByErrorMsg("该窑炉名称已经存在");
            }
            int returnCount = kilnMapper.insert(kiln);
            if (returnCount > 0) {
                return ServerResponse.createBySuccess("窑炉信息插入成功");
            }
            return ServerResponse.createByErrorMsg("窑炉信息插入失败");
        }
    }


    /**
     * 分页列出所有窑炉信息
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public ServerResponse<PageInfo> listAllKiln(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Kiln> kilnList = kilnMapper.selectAllList();
        List<KilnVo> kilnVoList = Lists.newArrayList();
        for (Kiln kilnItem : kilnList) {
            KilnVo kilnVo = assembleKilnList(kilnItem);
            kilnVoList.add(kilnVo);
        }
        PageInfo<KilnVo> pageInfo = new PageInfo<>(kilnVoList);
        pageInfo.setList(kilnVoList);
        return ServerResponse.createBySuccess(pageInfo);
    }


    /**
     * 组装返回信息
     *
     * @param kiln
     * @return
     */
    private KilnVo assembleKilnList(Kiln kiln) {
        KilnVo kilnVo = new KilnVo();
        kilnVo.setId(kiln.getId());
        kilnVo.setKilnName(kiln.getTitle());
        kilnVo.setDescription(kiln.getremark());
        return kilnVo;
    }


    /**
     * 更新窑炉信息状态
     * @param kilnId
     * @param status
     * @return
     */
    public ServerResponse<String> updateStatus(Integer kilnId, String status) {
        if (kilnId == null && StringUtils.isBlank(status)) {
            return ServerResponse.createByErrorCodeAndMsg(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getCodeDesc());
        }
        int rowCount = kilnMapper.updateStatusById(status,kilnId);
        if (rowCount > 0){
            return ServerResponse.createBySuccess("更新状态值成功");
        }
        return ServerResponse.createByErrorMsg("更新状态值失败");
    }


}
