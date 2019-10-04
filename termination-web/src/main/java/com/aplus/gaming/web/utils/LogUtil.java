/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.aplus.gaming.web.utils;

import org.slf4j.Logger;


/**
 * add by lengxw at 2018-04-25
 * @author lengxiangwu
 */
public class LogUtil {

    public static void debug(Logger logger, String format, Object... args) {
        if (logger.isDebugEnabled()) {
            logger.debug(format, args);
        }
    }

    public static void debug(Logger logger, String format, Throwable throwable) {
        if (logger.isDebugEnabled()) {
            logger.debug(format, throwable);
        }
    }

    public static void info(Logger logger, String format, Object... args) {
        if (logger.isInfoEnabled()) {
            logger.info(format, args);
        }
    }

    public static void info(Logger logger, String format, Throwable throwable) {
        if (logger.isInfoEnabled()) {
            logger.info(format, throwable);
        }
    }

    public static void error(Logger logger, String format, Object... args) {
        if (logger.isErrorEnabled()) {
            logger.error(format, args);
        }
    }

    public static void error(Logger logger, String format, Throwable throwable) {
        if (logger.isErrorEnabled()) {
            logger.error(format, throwable);
        }
    }

    public static void warn(Logger logger, String format, Object... args) {
        if (logger.isWarnEnabled()) {
            logger.warn(format, args);
        }
    }

    public static void warn(Logger logger, String format, Throwable throwable) {
        if (logger.isWarnEnabled()) {
            logger.warn(format, throwable);
        }
    }

    public static void trace(Logger logger, String format, Object... args) {
//        if (logger.isWarnEnabled()) {
//            logger.trace(format, args);
//        }
        info(logger,format,args);
    }

    public static void trace(Logger logger, String format, Throwable throwable) {
//        if (logger.isWarnEnabled()) {
//            logger.trace(format, throwable);
//        }
        info(logger,format,throwable);
    }

}
