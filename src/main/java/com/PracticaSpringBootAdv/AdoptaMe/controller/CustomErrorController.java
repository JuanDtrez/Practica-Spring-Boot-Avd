package com.PracticaSpringBootAdv.AdoptaMe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@Controller
public class CustomErrorController implements ErrorController {

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping("/error")
    public String handleError(Model model, WebRequest webRequest) {
        Map<String, Object> errorMap = errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.of(ErrorAttributeOptions.Include.STACK_TRACE));
        model.addAttribute("msg", errorMap.get("message"));
        model.addAttribute("stackTrace", errorMap.get("trace"));
        log.error("Ha ocurrido una Excepcion!!!! " + errorMap);
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
