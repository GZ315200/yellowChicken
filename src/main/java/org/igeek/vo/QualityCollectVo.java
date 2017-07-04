package org.igeek.vo;

import java.util.List;

/**
 * Created by Gyges on 2017/7/2.
 */
public class QualityCollectVo {

    private String workerName;//工人名称

    private String kilnName;//窑炉名称

    private String productName;//产品名称

    private String level;//等级

    private Integer totalNum; //数量

    private List<QualityTypeVo> formingProblems = null; //成型问题

    private List<QualityTypeVo> repairBillet = null; // 修坯问题

    private List<QualityTypeVo> sprayGlaze = null; // 喷釉问题

    private List<QualityTypeVo> climbingProcess = null; //登窑

    private List<QualityTypeVo> burnKiln = null; //烧窑




}
