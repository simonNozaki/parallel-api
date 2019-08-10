package com.tm.filter;

import com.github.isrsal.logging.ResponseWrapper;
import com.github.isrsal.logging.RequestWrapper;
import com.tm.config.AppLogger;
import com.tm.consts.AppConst;
import com.tm.consts.log.LogCode;
import com.tm.util.ObjectUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.atomic.AtomicLong;


/**
 * 共通ログ出力フィルター
 */
@Component
public class GlobalLoggingFilter extends OncePerRequestFilter {

    private AtomicLong id = new AtomicLong(1);

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {

        RequestWrapper wrappedRequest = new RequestWrapper(id.incrementAndGet(), request);
        ResponseWrapper wrappedResponse = new ResponseWrapper(id.incrementAndGet(), response);

        try{
            filterChain.doFilter(request, response);
        }catch (Exception e){
            AppLogger.trace(LogCode.TMFWCM00022, null, new Object().getClass().getCanonicalName(), new Object().getClass().getEnclosingMethod().getName(), null);
        }finally {
            // リクエストのロギング
            if(ObjectUtil.isNullOrEmpty(wrappedRequest)){
                logRequest(wrappedRequest);
            }

            if(ObjectUtil.isNullOrEmpty(wrappedResponse)){
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
        // Payload
        msg.append(AppConst.STR_SEMI_COLON + AppConst.STR_SPACE)
                .append("payload=").append(req.toByteArray());

        AppLogger.traceTelegram(LogCode.TMFWCM80005, new Object().getClass().getCanonicalName(), new Object().getClass().getEnclosingMethod().getName(), msg.toString());
    }

    /**
     * レスポンス情報をログ出力します。
     * @param res ラップされたHttpServletResponseインスタンス
     */
    private void logResponse(ResponseWrapper res) {
        StringBuilder msg = new StringBuilder();

        // リクエストID
        msg.append("id=").append(res.getId()).append(AppConst.STR_SEMI_COLON + AppConst.STR_SPACE);
        // Payload
        msg.append("payload=").append(res.toByteArray());

        AppLogger.traceTelegram(LogCode.TMFWCM80006, new Object().getClass().getCanonicalName(), new Object().getClass().getEnclosingMethod().getName(), msg.toString());
    }
}

