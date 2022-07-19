package com.tulingxueyuan.mall.common.config;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yangsx
 * @create: 2022-07-19 17:09
 **/
@Slf4j
public class AppContext {
    private static final ThreadLocal<Map<String, Object>> THREAD_LOCAL = ThreadLocal.withInitial(HashMap::new);

    private AppContext() {
    }

    /**
     * 获取key对应value
     *
     * @param key
     * @param <T>
     * @return
     */
    public static <T> T get(String key) {
        Map map = THREAD_LOCAL.get();
        return (T) map.get(key);
    }

    /**
     * 放入key-value
     *
     * @param key
     * @param value
     */
    public static void set(String key, Object value) {
        Map<String, Object> map = THREAD_LOCAL.get();
        map.put(key, value);
    }

    /**
     * 清空全部
     */
    public static void remove() {
        THREAD_LOCAL.remove();
    }

    /**
     * 清空指定key-value
     *
     * @param key
     * @param <T>
     * @return
     */
    public static <T> T remove(String key) {
        Map map = THREAD_LOCAL.get();
        return (T) map.remove(key);
    }

}
