package com.example.demo.advice;

import com.example.demo.bean.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut(value = "execution(* com.example.demo.*.*.*(..))")
    public void logPointcut() {

    }

    @Around("logPointcut()")
    public Object apiLogger(ProceedingJoinPoint pjp) {
        Object obj = null;
        ObjectMapper mapper = new ObjectMapper();
        String resp = null;
        try {
            String methodName = pjp.getSignature().getName();
            Object[] args = pjp.getArgs();
            String className = pjp.getTarget().getClass().toString();
            logger.info(methodName + " method call start");
            logger.info("==================================");
            logger.info("method invoked : " + className + " " + methodName + "()  argument :"
                    + mapper.writeValueAsString(args));
            obj = pjp.proceed();
            resp = mapper.writeValueAsString(obj);
            logger.info("After Execution method returns " + resp);
            logger.info(methodName + " method call end");
            logger.info("==================================");
        } catch (Throwable e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return obj;
    }


}
