package com.aplus.gaming.schedular.utils.utils.httpresponse;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;


public class AjaxResult<T> implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 6564457566699517560L;

    private T result;

    private List<Msg> msgs = new ArrayList<>();

    private Boolean success;

    private List<String> scripts = new ArrayList<>(8);

    private String cause;

    //错误码
    private String errorCode;

    //错误信息
    private String errorMsg;

    public AjaxResult() {
        super();
    }

    public AjaxResult(T result) {
        this.result = result;
        this.success = true;
    }

    public AjaxResult(Msg msg, Boolean success) {
        this.msgs.add(msg);
        this.success = success;
    }

    public AjaxResult(Msg msg) {
        this.msgs.add(msg);
    }

    public AjaxResult<T> result(T result) {
        this.result = result;
        return this;
    }

    public AjaxResult<T> success() {
        this.success = true;
        return this;
    }

    public AjaxResult<T> fail() {
        this.success = false;
        return this;
    }

    public AjaxResult<T> fail(String errorCode) {
        this.success = false;
        this.errorCode = errorCode;
        return this;
    }

    public AjaxResult<T> fail(String errorCode, String errorMsg) {
        this.success = false;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        return this;
    }

    public AjaxResult<T> msg(Msg msg) {
        return addMsg(msg);
    }

    private AjaxResult<T> addMsg(Msg msg) {
        this.msgs.add(msg);
        return this;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public List<Msg> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<Msg> msgs) {
        this.msgs = msgs;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<String> getScripts() {
        return scripts;
    }

    public void setScripts(List<String> scripts) {
        this.scripts = scripts;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

//    @Override
//    public String toString() {
//        return JSON.toJSONString(this);
//    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
