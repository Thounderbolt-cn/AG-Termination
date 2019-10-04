package com.aplus.gaming.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.aplus.gaming.web.constant.FeiJingUrlConstant;
import com.aplus.gaming.web.server.WSProtocolServer;
import com.aplus.gaming.web.utils.StringUtil;
import com.aplus.gaming.web.utils.httprequest.HttpRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.client.WebSocketClient;

import java.net.URISyntaxException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jarvis
 * @version V1.0
 * @date 2019/9/16 0016
 **/
@Controller
@RequestMapping("/checkcenter")
public class PortalController {

    @Autowired
    private WSProtocolServer wsProtocolServer;

    public static WebSocketClient client;




    /**
     * 页面请求
     * @param cid
     * @return
     */
    @GetMapping(value ="/lolData/{cid}",produces="application/json;charset=UTF-8")
    @ResponseBody
    public JSONObject getLolData( @PathVariable String cid) throws URISyntaxException,IOException {
        if (cid.equals("lolLeaguaList")){
            return (JSONObject) JSONObject.parse(StringUtil.replaceFeiJingUrl(getLeagueListInfo()));
        }
        if (cid.equals("lolRecentlyLeagua")){
            return JSONObject.parseObject(StringUtil.replaceFeiJingUrl(getRecentlyLeaguaInfo()));
        }
        if (cid.equals("lolMatchRecently")){
            return JSONObject.parseObject(StringUtil.replaceFeiJingUrl(getLolMatchRecentLyInfo()));
        }
        if (cid.equals("lolMatchFinalScore")){
            return JSONObject.parseObject(StringUtil.replaceFeiJingUrl(getLolMatchFinalScoreInfo()));
        }
        if (cid.equals("lolMatchFinalScore")){
            return JSONObject.parseObject(StringUtil.replaceFeiJingUrl(getLolMatchFinalScoreInfo()));
        }

        return JSONObject.parseObject("");
    }


    @GetMapping(value ="/lolLiveData",produces="application/json;charset=UTF-8")
    @ResponseBody
    public JSONObject getlolMatchInfo(String matchId) throws URISyntaxException,IOException {

        return JSONObject.parseObject(StringUtil.replaceFeiJingUrl(getlolMatchBetInfo(matchId)));
    }

    @GetMapping(value ="/lolMatchLiveScore",produces="application/json;charset=UTF-8")
    @ResponseBody
    public JSONObject lolMatchLiveScore(String matchId) throws URISyntaxException,IOException {
            return JSONObject.parseObject(StringUtil.replaceFeiJingUrl(getLolMatchLiveScoreInfo()));
    }


    @GetMapping(value ="/lolMatchLiveBattle",produces="application/json;charset=UTF-8")
    @ResponseBody
    public JSONObject getLiveData(String battleId) throws URISyntaxException,IOException {
        return JSONObject.parseObject(StringUtil.replaceFeiJingUrl(getlolMatchLiveBattleInfo(battleId)));
    }

    /**
     * 获取联赛信息
     * @throws IOException
     */
    private String getLeagueListInfo() throws IOException {
        //获取联赛信息
        Map params = new HashMap<String,String>();
        params.put("offset","0");
        params.put("limit","10");
        params.put("version","2");
        System.out.println(Thread.currentThread().getName()+"  "+ LocalDateTime.now(ZoneId.systemDefault()));
        //获取赛事信息
        return HttpRequestUtil.httpRequest(FeiJingUrlConstant.domian, FeiJingUrlConstant.leagueListUrl,"GET",params,"");

    }

    /**
     * 获取最近联赛列表
     * @throws IOException
     */
    private String getRecentlyLeaguaInfo() throws IOException {
        //获取联赛信息
        Map params = new HashMap<String,String>();
        params.put("version","2");
        System.out.println(Thread.currentThread().getName()+"  "+ LocalDateTime.now(ZoneId.systemDefault()));
        //获取赛事信息
        return HttpRequestUtil.httpRequest(FeiJingUrlConstant.domian,FeiJingUrlConstant.recentlyLeaguaUrl,"GET",params,"");

    }
    /**
     * 获取最近赛事情况
     * @throws IOException
     */
    private String getLolMatchRecentLyInfo() throws IOException {
        //获取联赛信息
        Map params = new HashMap<String,String>();
        params.put("offset","0");
        params.put("limit","10");
        params.put("version","2");
        System.out.println(Thread.currentThread().getName()+"  "+ LocalDateTime.now(ZoneId.systemDefault()));
        //获取赛事信息
        return HttpRequestUtil.httpRequest(FeiJingUrlConstant.domian,FeiJingUrlConstant.lolMatchRecentLyUrl,"GET",params,"");

    }

    /**
     * 获取赛事完场比分
     * @throws IOException
     */
    private String getLolMatchFinalScoreInfo() throws IOException {
        //获取联赛信息
        Map params = new HashMap<String,String>();

        params.put("offset","0");
        params.put("limit","10");
        params.put("version","2");
        System.out.println(Thread.currentThread().getName()+"  "+ LocalDateTime.now(ZoneId.systemDefault()));
        //获取赛事信息
        return HttpRequestUtil.httpRequest(FeiJingUrlConstant.domian,FeiJingUrlConstant.lolMatchFinalScoreUrl,"GET",params,"");
    }

    /**
     * 获取直播比赛分数
     * @throws IOException
     */
    private String getLolMatchLiveScoreInfo() throws IOException {

        Map params = new HashMap<String,String>();
        params.put("version","2");
        System.out.println(Thread.currentThread().getName()+"  "+ LocalDateTime.now(ZoneId.systemDefault()));
        //获取赛事信息
        return HttpRequestUtil.httpRequest(FeiJingUrlConstant.domian,FeiJingUrlConstant.lolMatchLiveScoreUrl,"GET",params,"");

    }

    /**
     * 比赛赔率信息
     * @throws IOException
     */
    private String getlolMatchBetInfo(String matchId) throws IOException {

        Map params = new HashMap<String,String>();
        params.put("version","2");
        params.put("match_id",matchId);
        System.out.println(Thread.currentThread().getName()+"  "+ LocalDateTime.now(ZoneId.systemDefault()));
        //获取赛事信息
        return  HttpRequestUtil.httpRequest(FeiJingUrlConstant.domian,FeiJingUrlConstant.lolMatchBetInfoUrl,"GET",params,"");

    }


    /**
     * 比赛实时比分情况
     * @throws IOException
     */
    private String getlolMatchLiveBattleInfo(String battleId) throws IOException {

        Map params = new HashMap<String,String>();
        params.put("version","2");
        params.put("battle_id",battleId);
        System.out.println(Thread.currentThread().getName()+"  "+ LocalDateTime.now(ZoneId.systemDefault()));
        //获取赛事信息
        return HttpRequestUtil.httpRequest(FeiJingUrlConstant.domian,FeiJingUrlConstant.lolMatchLiveBattleUrl,"GET",params,"");

    }
        /**
         * 页面请求
         * @param cid
         * @return
         */
    @GetMapping("/socket/{cid}")
    public String socket(@PathVariable String cid) throws URISyntaxException {
        ModelAndView mav=new ModelAndView("/socket");
        String result = null;

//        client = new WebSocketClient(new URI("ws://121.40.165.18:8800"),new Draft_6455()) {
//            @Override
//            public ListenableFuture<WebSocketSession> doHandshake(WebSocketHandler webSocketHandler, String s, Object... objects) {
//                return null;
//            }
//
//            @Override
//            public ListenableFuture<WebSocketSession> doHandshake(WebSocketHandler webSocketHandler, WebSocketHttpHeaders webSocketHttpHeaders, URI uri) {
//                return null;
//            }
//
//            @Override
//            public void onOpen(ServerHandshake serverHandshake) {
//                logger.info("握手成功");
//            }
//
//            @Override
//            public void onMessage(String msg) {
//                logger.info("收到消息=========="+msg);
//                if(msg.equals("over")){
//                    client.close();
//                }
//            }
//
//            @Override
//            public void onClose(int i, String s, boolean b) {
//                logger.info("链接已关闭");
//            }
//
//            @Override
//            public void onError(Exception e){
//                e.printStackTrace();
//                logger.info("发生错误已关闭");
//            }
//        };
        return result;

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
            wsProtocolServer.sendInfo(message,cid);
        } catch (IOException e) {
            e.printStackTrace();
            return new Object();
        }
        return null;
    }
}
