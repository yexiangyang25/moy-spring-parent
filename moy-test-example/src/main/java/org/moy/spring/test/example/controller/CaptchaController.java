package org.moy.spring.test.example.controller;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * <p>Description: [验证码]</p>
 * Created on 2019/7/25
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Controller
public class CaptchaController {

    @Autowired
    private CaptchaComponent captchaComponent;
    @Autowired
    private Producer captchaProducer;

    @RequestMapping(value = "/captcha/image", method = RequestMethod.GET)
    public void image(@RequestParam String uid, HttpServletResponse rsp) throws IOException {
        ServletOutputStream out = rsp.getOutputStream();
        rsp.setDateHeader("Expires", 0);
        rsp.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        rsp.addHeader("Cache-Control", "post-check=0, pre-check=0");
        rsp.setHeader("Pragma", "no-cache");
        rsp.setContentType("image/jpeg");
        String capText = captchaProducer.createText();
        BufferedImage image = captchaProducer.createImage(capText);
        captchaComponent.saveCaptcha(uid, capText);
        ImageIO.write(image, "jpg", out);
        out.flush();
        out.close();
    }
}
