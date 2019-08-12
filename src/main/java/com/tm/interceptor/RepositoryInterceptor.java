package com.tm.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

import com.tm.config.AppLogger;
import com.tm.consts.log.LogCode;

/**
 * リポジトリインターセプター
 */
@Component
public class RepositoryInterceptor implements MethodInterceptor {

    /**
     * リポジトリクラス実行時にトレースログを出力します。
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        AppLogger.trace(LogCode.TMFWCM00031, null, invocation.getThis().getClass(), invocation.getMethod().getName(), null);
        Object response = invocation.proceed();
        AppLogger.trace(LogCode.TMFWCM00032, null, invocation.getThis().getClass(), invocation.getMethod().getName(), null);
        return response;
    }

}
