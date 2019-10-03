package com.aplus.gaming.schedular.utils.utils.httpresponse;


import com.alibaba.fastjson.JSON;

import java.io.Serializable;


public class Msg implements Serializable
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -5378462032531924586L;

    public static final String INFO = "info";

    public static final String WARN = "warn";

    public static final String ERROR = "error";

    public static final String FATAL = "fatal";

    private String code;

    private String type;

    private String content;

    public Msg(){

    }

    public Msg(String type, String content)
    {
        this.type = type;
        this.content = content;
    }

    public Msg(String type, String content, String code)
    {
        this.type = type;
        this.content = content;
        this.code = code;
    }

    public static Msg info(String content)
    {
        return new Msg(INFO, content);
    }

    public static Msg info(String content, String code) {

        return new Msg(INFO, content, code);
    }

    public static Msg warn(String content)
    {
        return warn(content, null);
    }

    public static Msg warn(String content, String code)
    {
        return new Msg(WARN, content, code);
    }

    public static Msg error(String content)
    {
        return error(content, null);
    }

    public static Msg error(String content, String code)
    {
        return new Msg(ERROR, content, code);
    }

    public static Msg fatal(String content)
    {
        return fatal(content, null);
    }

    public static Msg fatal(String content, String code)
    {
        return new Msg(FATAL, content, code);
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String toString()
    {
        return JSON.toJSONString(this);
    }

}
