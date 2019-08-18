package org.moy.jwt.shiro;

import org.moy.spring.common.ResultBean;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Description: [自定义 401 404 500 页面]</p>
 * Created on 2018/12/20
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public abstract class AbstractJwtErrorController implements ErrorController {


    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = JwtConst.ERROR_URI, method = {RequestMethod.POST, RequestMethod.GET})
    public ResultBean handleError(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute(WebUtils.ERROR_STATUS_CODE_ATTRIBUTE);
        Object errorMessage = request.getAttribute(WebUtils.ERROR_MESSAGE_ATTRIBUTE);
        return ResultBean.fail(statusCode, errorMessage.toString());
    }

    @ResponseBody
    @RequestMapping(value = JwtConst.UN_AUTH_URI, method = {RequestMethod.POST, RequestMethod.GET})
    public ResultBean<String> unAuth() {
        return ResultBean.newNotLoginResult();
    }

    @Override
    public String getErrorPath() {
        return JwtConst.ERROR_URI;
    }
}
