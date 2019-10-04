package com.aplus.gaming.web.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hiram on 2017/3/6.
 */
public class ExecTimeRecorder {
    private ThreadLocal<Map<String, Long>> threadLocal = new ThreadLocal<Map<String, Long>>();
    private static final String GLOBAL_KEY = "__global__";
    private static final String PARTIAL_KEY = "__partial__";

    public Long start() {
        threadLocal.set(new HashMap<String, Long>());
        Long currentTime = System.currentTimeMillis();
        threadLocal.get().put(GLOBAL_KEY, currentTime);
        threadLocal.get().put(PARTIAL_KEY, currentTime);
        return currentTime;
    }

    public Long getExecTime() {
        Long lastTime = threadLocal.get().get(PARTIAL_KEY);
        Long currentTime = System.currentTimeMillis();
        threadLocal.get().put(PARTIAL_KEY, currentTime);
        return currentTime - lastTime;
    }

    public Long getGlobalTime() {
        Long lastTime = threadLocal.get().get(GLOBAL_KEY);
        Long currentTime = System.currentTimeMillis();
        return currentTime - lastTime;
    }
}
