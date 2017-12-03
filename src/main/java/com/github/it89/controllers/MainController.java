package com.github.it89.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @RequestMapping(value = "text", method = RequestMethod.GET)
    @ResponseBody
    public String check(@RequestParam(value = "param", required = false) String param) {
        String result = "index";
        if (!StringUtils.isEmpty(param))
            result += " (" + param + ")";
        return result;
    }
}
