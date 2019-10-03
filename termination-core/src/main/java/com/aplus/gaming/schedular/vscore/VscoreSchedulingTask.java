package com.aplus.gaming.schedular.vscore;

import com.aplus.gaming.core.webservice.server.WSProtocolServer;
import com.aplus.gaming.schedular.constant.FeiJingUrlConstant;
import com.aplus.gaming.schedular.utils.utils.httprequest.HttpRequestUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

/**
 * 比分定时同步接口
 * @author Jarvis
 * @version V1.0
 * @date 2019/9/17 0017
 **/
@Configuration
public class VscoreSchedulingTask {

    @Scheduled(cron = "0/1 * * * * ?")
    public void runTask() throws IOException {

        Map params = new HashMap<String,String>();
        params.put("offset","0");
        params.put("limit","10");
        params.put("version","2");
        System.out.println(Thread.currentThread().getName()+"  "+LocalDateTime.now(ZoneId.systemDefault()));
        String result = HttpRequestUtil.httpRequest(FeiJingUrlConstant.domian,FeiJingUrlConstant.yxlmUrl,"GET",params,"");
        WSProtocolServer.sendInfo(result,"1");

    }
}
