package com.aplus.gaming.schedular.utils.utils.httprequest;

import com.alibaba.fastjson.JSONObject;
import com.aplus.gaming.schedular.constant.Constant;
import com.aplus.gaming.schedular.constant.FeiJingUrlConstant;
import com.aplus.gaming.schedular.utils.utils.MD5;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.DigestUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpRequestUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpRequestUtil.class);

    public static void main(String[] args) {
        Map params = new HashMap<String,String>();
        params.put("offset","0");
        params.put("limit","10");
        params.put("version","2");


//        httpRequest(FeiJingUrlConstant.domian,FeiJingUrlConstant.yxlmUrl,"GET",params,"");
    }

    /**
     * 接口调用通用适配器
     *
     * @param url 请求地址路径
     * @param method 请求方式，现只支持GET和POST
     * @param params 请求参数
     * @param isEntity POST方式是否是RequestBody 0-不是 1-是
     * @return 接口返回的字符串数据
     */
    public static String httpRequest(String domain ,String url, String method, Map<String, Object> params, String isEntity) {
        logger.info("准备开始调用飞鲸接口，domain：{},url:{},参数:{}",domain, url, params);
        RestTemplate restTemplate = new RestTemplate();
        String requestUrl = "";
        String urlParams ="";
        for (String key:params.keySet()){
            urlParams = urlParams + key +"=" +params.get(key)+"&";
        }
        urlParams =urlParams.substring(0,urlParams.length()-1);
        requestUrl =domain + url + "?"+urlParams;
        String result = null;
        try {
            if (RequestMethod.GET.toString().equals(method)) {

                HttpHeaders httpHeaders = new HttpHeaders();
                Long timeStamp = System.currentTimeMillis();
                MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
                String apiSign = MD5.toMD5(Constant.secret_key+"|"+timeStamp+"|"+ url).toUpperCase();

                httpHeaders.setContentType(type);
                httpHeaders.add("Accept-ApiAccess", Constant.access_key);
                httpHeaders.add("Accept-ApiSign",apiSign);
                httpHeaders.add("Accept-ClientTime",String.valueOf(timeStamp));
                HttpEntity<MultiValueMap> requestEntity = new HttpEntity<MultiValueMap>( httpHeaders);
                ResponseEntity<String> responseEntity =restTemplate.exchange(requestUrl,HttpMethod.GET,requestEntity,String.class);
                result = responseEntity.getBody();
                System.out.println(result);;
            } else if (RequestMethod.POST.toString().equals(method)) {
                MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
                if ("1".equals(isEntity)) {
                    HttpHeaders requestHeaders = new HttpHeaders();
                    requestHeaders.setContentType(type);
                    HttpEntity<String> httpEntity = new HttpEntity<>(new JSONObject(params).toJSONString(), requestHeaders);
                    ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, httpEntity, String.class);
                    if (responseEntity != null) {
                        result = responseEntity.getBody();
                    }
                } else {
                    //解决http请求乱码
                    List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
                    messageConverters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
                    MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
                    jsonConverter.setObjectMapper(new ObjectMapper());
                    messageConverters.add(jsonConverter);
                    messageConverters.add(new ResourceHttpMessageConverter());
                    restTemplate.setMessageConverters(messageConverters);
                    MultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<String, String>();
                    for (String key : params.keySet()) {
                        if (params.get(key) != null) {
                            paramsMap.add(key, String.valueOf(params.get(key)));
                        } else {
                            paramsMap.add(key, "");
                        }
                    }
                    result = restTemplate.postForObject(url, paramsMap, String.class);
                }
            }
            logger.info("调用飞鲸接口返回信息，url:{},返回信息：{}", url, result);
        } catch (Exception e) {
            logger.error("调用飞鲸接口异常，url：{}，异常信息：{}", url, e.getMessage());
        }
        return result;
    }

    public static String postForObject(String url, Map<String, String> headParams) {
        RestTemplate restTemplate = new RestTemplate();

        //获取header信息
        HttpHeaders requestHeaders = new HttpHeaders();

        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        requestHeaders.setContentType(type);
        for (String key : headParams.keySet()) {
            requestHeaders.add(key, headParams.get(key));
        }
        HttpEntity<String> requestEntity = new HttpEntity<>(null, requestHeaders);
        ResponseEntity<String> rss = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        return rss.getBody();
    }



}
