package org.lhh.demo.aspect;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javax.servlet.http.HttpServletRequest;

import java.lang.Object;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Created by raysely on 17/8/13.
 */
@Aspect
@Component
public class HttpAspect {

        private final static Logger log = LoggerFactory.getLogger(HttpAspect.class);

//    @Before("execution(public * org.lhh.demo.controller.MemberController.memberList(..))")
//    public void log() {
//        System.out.println("111111");
//    }
//
//    @After("execution(public * org.lhh.demo.controller.MemberController.memberList(..))")
//    public void doAfter() {
//        System.out.println("2222222");
//    }

    @Pointcut("execution(public * org.lhh.*.controller.MemberController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(final JoinPoint joinPoint) {
        final ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        final HttpServletRequest request = attrs.getRequest();

        //url
        log.info("url={}", request.getRequestURL());

        //method
        log.info("method={}", request.getMethod());

        //ip
        log.info("ip={}", request.getRemoteAddr());

        //类方法
        log.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        log.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        log.info("22222222");
    }

    @AfterReturning(returning = "obj", pointcut = "log()")
    public void doAfterReturning(Object obj) {
        log.info("response={}", obj);
    }
}
