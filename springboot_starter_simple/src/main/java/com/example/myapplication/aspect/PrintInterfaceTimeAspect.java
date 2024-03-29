package com.example.myapplication.aspect;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Slf4j
@Aspect
@Component
public class PrintInterfaceTimeAspect {

    @Value("${time-cost-monitor.enabled}")
    private String properties;

//    public PrintInterfaceTimeAspect() {
//    }

    //路径就自己定义咯

    /**
     * 注意：可以通过
     * public private 等访问限制符限制切点的访问权限
     *
     * 方式一：直接以类以及其类下方法为切点（好处是不用洗注解，坏处不好扩展）
     * @Pointcut("execution(public * com.example.myapplication.controller.FeignClientController.*(..))")
     * 包下所有类为切点
     * @Pointcut("execution(public * com.example.myapplication.controller..*.*(..))")
     *
     * 方式二：使用自定义注解（好处是可以任意统计，坏处处增加类的个数）
     * @Pointcut("@annotation(com.example.myapplication.aspect.TimeCostMonitorAnnotation)")
     *
     * 方法三：&& || 的组合使用 原理同逻辑运算符
     */
    @Pointcut("@annotation(com.example.myapplication.aspect.TimeCostMonitorAnnotation)")
    public void printInterfacePointCut() {
    }

    @Around(value = "printInterfacePointCut()")
    public Object aroundFeignInterfaceMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        if (!Boolean.parseBoolean(properties.trim())) {
            return joinPoint.proceed();
        }
        long start = System.currentTimeMillis();
        Object obj = null;
        Object[] args = null;
        try {
            // 获取方法参数
            args = joinPoint.getArgs();
            // 获取方法结果
            obj = joinPoint.proceed();
        }
        finally {
            log.info("调用关联方的方法及耗时class name={}, time cost={}, [ method={}, request={}, result={} ]",
                    joinPoint.getSignature().getDeclaringTypeName(),System.currentTimeMillis() - start, joinPoint.getSignature().getName(), JSONUtil.toJsonStr(args), JSONUtil.toJsonStr(obj));
        }
        return obj;
    }
}