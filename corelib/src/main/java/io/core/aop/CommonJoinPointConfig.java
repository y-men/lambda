package io.core.aop;

import org.aspectj.lang.annotation.Pointcut;


public class CommonJoinPointConfig {
    @Pointcut("execution(* io.core.*.*(..))")
    public void dataLayerExecution(){}

    @Pointcut("execution(* io.core.*.*(..))")
    public void businessLayerExecution(){}

    @Pointcut("execution(* io.core..*.*+.*(..))")
    public void applicationPackagePointcut() {
    }

}
