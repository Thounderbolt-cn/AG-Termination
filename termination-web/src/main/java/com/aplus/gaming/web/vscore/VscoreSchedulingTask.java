package com.aplus.gaming.web.vscore;

import com.aplus.gaming.web.constant.FeiJingUrlConstant;
import com.aplus.gaming.web.server.WSProtocolServer;
import com.aplus.gaming.web.utils.httprequest.HttpRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private WSProtocolServer wsProtocolServer;

    @Scheduled(cron = "0/15 * * * * ?")
    public void runTask() throws IOException {
        //获取联赛信息
        getLeagueListInfo();


        return;
    }

    /**
     * 获取联赛信息
     * @throws IOException
     */
    private void getLeagueListInfo() throws IOException {
        //获取联赛信息
        Map params = new HashMap<String,String>();
        params.put("offset","0");
        params.put("limit","10");
        params.put("version","2");
        System.out.println(Thread.currentThread().getName()+"  "+ LocalDateTime.now(ZoneId.systemDefault()));
        //获取赛事信息
        String result = HttpRequestUtil.httpRequest(FeiJingUrlConstant.domian, FeiJingUrlConstant.leagueListUrl,"GET",params,"");
        wsProtocolServer.sendInfo(result,"lolLeaguaList");
    }

    /**
     * 获取最近联赛列表
     * @throws IOException
     */
    private void getRecentlyLeaguaInfo() throws IOException {
        //获取联赛信息
        Map params = new HashMap<String,String>();
        params.put("offset","0");
        params.put("limit","100");
        params.put("version","2");
        System.out.println(Thread.currentThread().getName()+"  "+ LocalDateTime.now(ZoneId.systemDefault()));
        //获取赛事信息
        String result = HttpRequestUtil.httpRequest(FeiJingUrlConstant.domian,FeiJingUrlConstant.recentlyLeaguaUrl,"GET",params,"");
        wsProtocolServer.sendInfo(result,"lolRecentlyLeagua");
    }
    /**
     * 获取最近赛事情况
     * @throws IOException
     */
    private void getLolMatchRecentLyInfo() throws IOException {
        //获取联赛信息
        Map params = new HashMap<String,String>();
        System.out.println(Thread.currentThread().getName()+"  "+ LocalDateTime.now(ZoneId.systemDefault()));
        //获取赛事信息
        String result = HttpRequestUtil.httpRequest(FeiJingUrlConstant.domian,FeiJingUrlConstant.lolMatchRecentLyUrl,"GET",params,"");
        wsProtocolServer.sendInfo(result,"lolMatchRecently");
    }

    /**
     * 获取赛事完场比分
     * @throws IOException
     */
    private void getLolMatchFinalScoreInfo() throws IOException {
        //获取联赛信息
        Map params = new HashMap<String,String>();
        System.out.println(Thread.currentThread().getName()+"  "+ LocalDateTime.now(ZoneId.systemDefault()));
        //获取赛事信息
        String result = HttpRequestUtil.httpRequest(FeiJingUrlConstant.domian,FeiJingUrlConstant.lolMatchFinalScoreUrl,"GET",params,"");
        wsProtocolServer.sendInfo(result,"lolMatchFinalScore");
    }
    /**
     * 获取直播比赛分数
     * @throws IOException
     */
    private void getLolMatchLiveScoreInfo() throws IOException {

        Map params = new HashMap<String,String>();
        System.out.println(Thread.currentThread().getName()+"  "+ LocalDateTime.now(ZoneId.systemDefault()));
        //获取赛事信息
        String result = HttpRequestUtil.httpRequest(FeiJingUrlConstant.domian,FeiJingUrlConstant.lolMatchLiveScoreUrl,"GET",params,"");
        wsProtocolServer.sendInfo(result,"lolMatchLiveScore");
    }

    /**
     * 比赛赔率信息
     * @throws IOException
     */
    private void getlolMatchBetInfo() throws IOException {

        Map params = new HashMap<String,String>();
        System.out.println(Thread.currentThread().getName()+"  "+ LocalDateTime.now(ZoneId.systemDefault()));
        //获取赛事信息
        String result = HttpRequestUtil.httpRequest(FeiJingUrlConstant.domian,FeiJingUrlConstant.lolMatchBetInfoUrl,"GET",params,"");
        wsProtocolServer.sendInfo(result,"lolMatchLiveScore");
    }


    /**
     * 比赛实时比分情况
     * @throws IOException
     */
    private void getlolMatchLiveBattleInfo() throws IOException {

        Map params = new HashMap<String,String>();
        System.out.println(Thread.currentThread().getName()+"  "+ LocalDateTime.now(ZoneId.systemDefault()));
        //获取赛事信息
        String result = HttpRequestUtil.httpRequest(FeiJingUrlConstant.domian,FeiJingUrlConstant.lolMatchLiveBattleUrl,"GET",params,"");
        wsProtocolServer.sendInfo(result,"lolMatchLiveBattle");
    }

}
