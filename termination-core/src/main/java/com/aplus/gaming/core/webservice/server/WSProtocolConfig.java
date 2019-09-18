package com.aplus.gaming.core.webservice.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * w-socket服务导出类注册
 * @author Jarvis
 * @version V1.0
 * @date 2019/9/15 0015
 **/
@Configuration
@Component
public class WSProtocolConfig {

    @Bean
    public ServerEndpointExporter initServerEndpoint() {
        return new ServerEndpointExporter();
    }
}
