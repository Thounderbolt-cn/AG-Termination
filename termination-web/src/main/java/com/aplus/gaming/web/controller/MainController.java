package com.aplus.gaming.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jarvis
 * @version V1.0
 * @@desc: TODO
 * @date 2019/9/22 0022
 **/
@RestController
@RequestMapping("server")
public class MainController {

    @GetMapping("/checkStatus")
    public String checkStatus(){
        return "SUCCESS";
    }
}
