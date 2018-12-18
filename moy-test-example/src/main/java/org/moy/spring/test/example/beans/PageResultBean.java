package org.moy.spring.test.example.beans;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description: [统一 返回分页结果]</p>
 * Created on 2018/12/18
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class PageResultBean<T> extends ResultBean<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 当前页码
     */
    protected Integer pageNum;
    /**
     * 每页的数量
     */
    protected Integer pageSize;
    /**
     * 总页数
     */
    protected Integer pages;
    /**
     * 总记录数
     */
    protected Long total;

    public PageResultBean() {
        super();
    }

    public static <E> PageResultBean<List<E>> build(PageInfo<E> sourcePageInfo) {
        PageResultBean<List<E>> pageResultBean = new PageResultBean<>();
        pageResultBean.setCode(SUCCESS_CODE);
        pageResultBean.setMsg(SUCCESS_MESSAGE);
        pageResultBean.setPageNum(sourcePageInfo.getPageNum());
        pageResultBean.setPageSize(sourcePageInfo.getPageSize());
        pageResultBean.setPages(sourcePageInfo.getPages());
        pageResultBean.setTotal(sourcePageInfo.getTotal());
        pageResultBean.setData(sourcePageInfo.getList());
        return pageResultBean;
    }

    public static <E, T> PageResultBean<List<E>> buildDTOPage(PageResultBean<List<T>> sourcePage, List<E> list) {
        PageResultBean<List<E>> pageResultBean = new PageResultBean<>();
        pageResultBean.setCode(SUCCESS_CODE);
        pageResultBean.setMsg(SUCCESS_MESSAGE);
        pageResultBean.setPageNum(sourcePage.getPageNum());
        pageResultBean.setPageSize(sourcePage.getPageSize());
        pageResultBean.setPages(sourcePage.getPages());
        pageResultBean.setTotal(sourcePage.getTotal());
        pageResultBean.setData(list);
        return pageResultBean;
    }

    public static <E> PageResultBean<E> fail() {
        return fail(FAIL_CODE, FAIL_MESSAGE);
    }

    public static <E> PageResultBean<E> fail(Integer code, String message) {
        PageResultBean<E> pageResultBean = new PageResultBean<>();
        pageResultBean.setCode(code);
        pageResultBean.setMsg(message);
        pageResultBean.setSuccess(false);
        pageResultBean.setPageNum(0);
        pageResultBean.setPageSize(0);
        pageResultBean.setPages(0);
        pageResultBean.setTotal(0L);
        return pageResultBean;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
