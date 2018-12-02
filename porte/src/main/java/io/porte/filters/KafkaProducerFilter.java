package io.porte.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KafkaProducerFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 6;
    }

    /**
     * Check if needs to produce this.
     * Varify that there is a potential to usefull information in this message
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        return requestContext != null;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        log.debug(" KafkaProducerFilter::run()");
        RequestContext requestContext = RequestContext.getCurrentContext();
        // todo Extract information and write to kafka
        return null;
    }
}
