package com.aplus.gaming.web.controller;

import com.aplus.gaming.core.webservice.server.WSProtocolServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * @author Jarvis
 * @version V1.0
 * @date 2019/9/16 0016
 **/
@Controller
@RequestMapping("/checkcenter")
public class PortalController {

    @Autowired
    private WSProtocolServer WSProtocolServer;

    /**
     * 页面请求
     * @param cid
     * @return
     */
    @GetMapping("/socket/{cid}")
    public ModelAndView socket(@PathVariable String cid) {
        ModelAndView mav=new ModelAndView("/socket");
        mav.addObject("cid", cid);
        return mav;
    }

    /**
     * 推送数据接口
     * @param cid
     * @param message
     * @return
     */
    @ResponseBody
    @RequestMapping("/socket/push/{cid}")
    public Object pushToWeb(@PathVariable String cid,String message) {
        try {
            WSProtocolServer.sendInfo(message,cid);
        } catch (IOException e) {
            e.printStackTrace();
            return new Object();
        }
        return null;
    }
}
