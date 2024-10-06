package net.edgar.microservicearticles.config.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.edgar.microservicearticles.utility.TraceabilityUtils;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;


import java.util.Objects;

import static net.edgar.microservicearticles.constant.MicroserviceArticlesConstant.ResponseConstant.SPAN_ID_KEY;
import static net.edgar.microservicearticles.constant.MicroserviceArticlesConstant.ResponseConstant.TRACE_ID_KEY;

public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        String traceIdHeader = request.getHeader("Trace-Id");

        String traceIdSpanId = Objects.nonNull(traceIdHeader) ? traceIdHeader : TraceabilityUtils.generateTraceIdSpanId();

        MDC.put(TRACE_ID_KEY, traceIdSpanId);
        MDC.put(SPAN_ID_KEY, traceIdSpanId);

        return true;
    }

}