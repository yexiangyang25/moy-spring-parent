package org.moy.spring.test.example.beans;

import com.github.pagehelper.PageInfo;
import org.moy.spring.test.example.common.BeanHelper;

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

    public static <E, T> PageResultBean<List<T>> copyPageResultToCustomPageResult(PageResultBean<List<E>> sourcePageResultBean, Class<T> clazz) {
        List<E> data = sourcePageResultBean.getData();
        List<T> copyList = BeanHelper.copyList(data, clazz);
        return buildDTOPageResult(sourcePageResultBean, copyList);
    }

    public static <E, T> PageResultBean<List<T>> copyPageListToCustomPageResult(List<E> sourcePageList, Class<T> clazz) {
        PageResultBean<List<E>> listPageResultBean = PageResultBean.buildPageListToPageResult(sourcePageList);
        return copyPageResultToCustomPageResult(listPageResultBean, clazz);
    }

    public static <E> PageResultBean<List<E>> buildPageListToPageResult(List<E> sourcePageList) {
        PageInfo<E> sourcePageInfo = PageInfo.of(sourcePageList);
        PageResultBean<List<E>> pageResultBean = new PageResultBean<>();
        pageResultBean.setCode(SUCCESS_CODE);
        pageResultBean.setMsg(SUCCESS_MESSAGE);
        pageResultBean.setSuccess(true);
        pageResultBean.setPageNum(sourcePageInfo.getPageNum());
        pageResultBean.setPageSize(sourcePageInfo.getPageSize());
        pageResultBean.setPages(sourcePageInfo.getPages());
        pageResultBean.setTotal(sourcePageInfo.getTotal());
        pageResultBean.setData(sourcePageInfo.getList());
        return pageResultBean;
    }

    private static <E, T> PageResultBean<List<E>> buildDTOPageResult(PageResultBean<List<T>> sourcePage, List<E> list) {
        PageResultBean<List<E>> pageResultBean = new PageResultBean<>();
        pageResultBean.setCode(SUCCESS_CODE);
        pageResultBean.setMsg(SUCCESS_MESSAGE);
        pageResultBean.setSuccess(true);
        pageResultBean.setPageNum(sourcePage.getPageNum());
        pageResultBean.setPageSize(sourcePage.getPageSize());
        pageResultBean.setPages(sourcePage.getPages());
        pageResultBean.setTotal(sourcePage.getTotal());
        pageResultBean.setData(list);
        return pageResultBean;
    }

    public static <E> PageResultBean<E> fail() {
        return fail(FAIL_MESSAGE);
    }

    public static <E> PageResultBean<E> newFriendPageResult() {
        String message = "系统开小差了，请稍候再试";
        return PageResultBean.fail(message);
    }

    public static <E> PageResultBean<E> fail(String message) {
        return fail(FAIL_CODE, message);
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

    @Override
    public String toString() {
        return "PageResultBean{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", pages=" + pages +
                ", total=" + total +
                ", success=" + success +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
