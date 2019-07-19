package com.whut.mall.common.framework.util;

import com.whut.mall.common.framework.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ServiceExceptionUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceExceptionUtil.class);

    /**
     * 错误码提示模板
     */
    private static ConcurrentMap<Integer, String> messages = new ConcurrentHashMap<>();

    /**
     * 创建指定编号的 ServiceException 的异常
     *
     * @param code 编号
     * @return 异常
     */
    public static ServiceException exception(Integer code) {
        return new ServiceException(code, messages.get(code));
    }
}
