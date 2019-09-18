package com.aplus.gaming.schedular.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * 多线程定时任务配置初始化
 * @author Jarvis
 * @version V1.0
 * @date 2019/9/17 0017
 **/
@Configuration
public class MultiThreadingScheduleConfigurer  implements SchedulingConfigurer {
    /**
     * 并行任务
     * @param registrar
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar registrar) {
        TaskScheduler taskScheduler = taskScheduler();
        registrar.setTaskScheduler(taskScheduler);
    }

    /**
     * 多线程配置
     * @return
     */
    @Bean(destroyMethod = "shutdown")
    public ThreadPoolTaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(Runtime.getRuntime().availableProcessors()*2);
        // 设置线程名前缀
        scheduler.setThreadNamePrefix("scheduling-task-");
        // 线程内容执行完后60秒停在
        scheduler.setAwaitTerminationSeconds(60);
        // 等待所有线程执行完
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        return scheduler;
    }
}
