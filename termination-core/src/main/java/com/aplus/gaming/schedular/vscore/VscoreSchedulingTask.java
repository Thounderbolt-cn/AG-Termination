package com.aplus.gaming.schedular.vscore;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * 比分定时同步接口
 * @author Jarvis
 * @version V1.0
 * @date 2019/9/17 0017
 **/
@Configuration
public class VscoreSchedulingTask {

    @Scheduled(cron = "0/5 * * * * ?")
    public void runTask(){
        System.out.println(Thread.currentThread().getName()+"  "+LocalDateTime.now(ZoneId.systemDefault()));
    }
}
