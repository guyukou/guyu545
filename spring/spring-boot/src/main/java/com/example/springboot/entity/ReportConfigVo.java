package com.example.springboot.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author renq
 */
@Data
public class ReportConfigVo {

    private Long id;
    private Integer sysType;
    @NotNull
    @Size(min = 3, max = 50)
    private String reportName;
    private Integer reportMode;
    private Integer ownTabType;
    @Size(min = 1)
    private Map<Integer, List<Integer>> ownTabTypes;
    @NotNull
    @Size(min = 1)
    private List<Integer> exportMode = new ArrayList<>();
    @NotNull
    @Size(min = 1)
    private List<Integer> exportNameType = new ArrayList<>();

    @NotNull
    @Size(min = 1)
    private List<Integer> deptLevel = new ArrayList<>();
    private List<Integer> calDate = new ArrayList<>();
    private List<Integer> siteId = new ArrayList<>();
    private List<Integer> bizType = new ArrayList<>();
    private List<Integer> customType = new ArrayList<>();


    private Integer sortType;
    private Boolean selected;

    private Long accountId;
    private String tips;

    private Boolean primeSelect;

    /**
     * 管理方式：：1部门，2团队
     */
    private Integer managementStyle;

    /**
     * 图表
     */
    private Boolean chartAble;
    /**
     * 图型
     */
    private List<Integer> chartType;

}
