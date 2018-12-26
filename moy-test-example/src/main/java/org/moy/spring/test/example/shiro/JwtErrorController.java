package org.moy.spring.test.example.shiro;

import org.moy.spring.test.example.beans.ResultBean;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Description: [自定义 401 404 500 页面]</p>
 * Created on 2018/12/20
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Controller
public class JwtErrorController implements ErrorController {


    @ResponseBody
    @RequestMapping("/error")
    public ResultBean handleError(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        return ResultBean.fail(statusCode, "SERVER ERROR");
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
