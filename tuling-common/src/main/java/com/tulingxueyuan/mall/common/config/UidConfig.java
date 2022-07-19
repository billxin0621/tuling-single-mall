package com.tulingxueyuan.mall.common.config;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: yangsx
 * @create: 2022-07-19 17:09
 **/
@Slf4j
public class UidConfig extends ClassicConverter {
    @Override
    public String convert(ILoggingEvent event) {
        return StringUtils.isBlank(AppContext.get("LOG_UID")) ? "" : AppContext.get("LOG_UID");
    }
}
