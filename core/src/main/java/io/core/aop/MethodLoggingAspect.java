package io.core.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class MethodLoggingAspect {

    @Around("@annotation(io.core.annotations.TraceExecutionTime)")
    public Object executionTimeAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = joinPoint.proceed();

        if (log.isDebugEnabled()) {
            long start = System.currentTimeMillis();
            long executionTime = System.currentTimeMillis() - start;
            log.debug(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        }
        return proceed;
    }


    @Around("@annotation(io.core.annotations.TraceMethod)")
    public Object traceMethodAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        if (log.isDebugEnabled()) {
            log.debug("Enter {}() with argument[s]: {}", joinPoint.getSignature().getName(),
                    Arrays.toString(joinPoint.getArgs()));
        }
        try {

            //todo Create a formatted log for tabular output
            Object result = joinPoint.proceed();
            if (log.isDebugEnabled()) {
                log.debug("Exit {}() with result: {}", joinPoint.getSignature().getName(), result);
            }
            return result;

        } catch (IllegalArgumentException e) {
            log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
                    joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName());
            throw e;
        }
    }


}

