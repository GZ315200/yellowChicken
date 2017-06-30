package org.igeek.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Gyges on 2017/6/28.
 * 等级信息vo
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RankVo {

    private Integer rankId;
    private String rankName;
    private String remark;
    private String rankIdName;

    public RankVo() {
    }

    public RankVo(Integer rankId, String rankName, String remark) {
        this.rankId = rankId;
        this.rankName = rankName;
        this.remark = remark;
    }

    public String getRankIdName() {
        return rankIdName;
    }

    public void setRankIdName(String rankIdName) {
        this.rankIdName = rankIdName;
    }

    public Integer getRankId() {
        return rankId;
    }

    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
