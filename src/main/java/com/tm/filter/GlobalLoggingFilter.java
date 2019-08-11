package com.tm.filter;

import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.github.isrsal.logging.RequestWrapper;
import com.github.isrsal.logging.ResponseWrapper;
import com.tm.config.AppLogger;
import com.tm.consts.AppConst;
import com.tm.consts.log.LogCode;
import com.tm.util.ObjectUtil;


/**
 * 共通ログ出力フィルター
 */
@Component
public class GlobalLoggingFilter extends OncePerRequestFilter {

    private AtomicLong id = new AtomicLong(1);
    StackTraceElement[] elm = new Throwable().getStackTrace();

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {

        RequestWrapper wrappedRequest = new RequestWrapper(id.incrementAndGet(), (HttpServletRequest) request);
        ResponseWrapper wrappedResponse = new ResponseWrapper(id.incrementAndGet(), (HttpServletResponse) response);

        try{
            filterChain.doFilter(request, response);
        }catch (Exception e){
            AppLogger.trace(LogCode.TMFWCM00022, null, elm[0].getClassName(), elm[0].getMethodName().toString(), null);
        }finally {
            // リクエストのロギング
            if(!ObjectUtil.isNullOrEmpty(wrappedRequest)){
                logRequest(wrappedRequest);
            }

            if(!ObjectUtil.isNullOrEmpty(wrappedResponse)){
                logResponse(wrappedResponse);
            }
        }
    }

    /**
     * リクエスト情報をログ出力します。
     * @param req ラップされたHttpServletRequestインスタンス
     */
    private void logRequest(RequestWrapper req) {
        StringBuilder msg = new StringBuilder();

        // リクエストID
        msg.append("id=").append(req.getId()).append(AppConst.STR_SEMI_COLON + AppConst.STR_SPACE);
        // HTTPメソッド
        msg.append("method=").append(req.getMethod()).append(AppConst.STR_SEMI_COLON + AppConst.STR_SPACE);
        // URI
        msg.append("uri=").append(req.getRequestURI());
        if(ObjectUtil.isNullOrEmpty(req.getQueryString())){
            msg.append('?').append(req.getQueryString());
        }

        AppLogger.traceTelegram(LogCode.TMFWCM80005, elm[0].getClassName(), elm[0].getMethodName().toString(), msg.toString());
    }

    /**
     * レスポンス情報をログ出力します。
     * @param res ラップされたHttpServletResponseインスタンス
     */
    private void logResponse(ResponseWrapper res) {
        StringBuilder msg = new StringBuilder();

        // リクエストID
        msg.append("id=").append(res.getId()).append(AppConst.STR_SEMI_COLON + AppConst.STR_SPACE);

        AppLogger.traceTelegram(LogCode.TMFWCM80006, elm[0].getClassName(), elm[0].getMethodName().toString(), msg.toString());
    }
}

