package com.garry.mybatisbaomidou;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {
    /**
     * 结果集
     */
    private List<T> list;
    /**
     * 总条数
     */
    private Long total;
    /**
     * 页码
     */
    private Integer pageNum;
    /**
     * 页面大小
     */
    private Integer pageSize;
    /**
     * 总页数
     */
    private Integer pages;

}