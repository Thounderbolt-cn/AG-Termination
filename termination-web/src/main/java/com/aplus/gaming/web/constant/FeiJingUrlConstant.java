package com.aplus.gaming.web.constant;

public interface FeiJingUrlConstant {

        String domian =  "http://esportsapi.feijing88.com";

        //联赛信息
        String leagueListUrl ="/data-service/lol/league/list";

        //近期联赛信息
        String recentlyLeaguaUrl = "/data-service/lol/league/recently";

        //近期赛事信息
        String  lolMatchRecentLyUrl = "/data-service/lol/match/recently";

        //赛事最终比分
        String  lolMatchFinalScoreUrl = "/data-service/lol/match/final_score";


        //选手基本信息
        String  playerBasicInfoUrl = "/data-service/lol/player/basic_info";

        //对局即时比分
        String lolMatchLiveScoreUrl =  "/data-service/lol/match/live_score";

        //比赛赔率信息
        String lolMatchBetInfoUrl = "/data-service/lol/match/bet_info";

        //比赛实时比分情况
        String lolMatchLiveBattleUrl =  "/data-service/lol/match/live_battle";



}
