package com.example.aop;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Component
@Aspect
public class LogAspect {
	Logger logger = LoggerFactory.getLogger(LogAspect.class);
		
		@Around("execution(* com.example.controller.*Controller.*(..)) "
			+ "or execution(* com.example.mapper.*Mapper.*(..)) ")
		public Object printLog(ProceedingJoinPoint joinPoint) throws Throwable{
		String type = joinPoint.getSignature().getDeclaringTypeName();
		String name = joinPoint.getSignature().getName();
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		logger.info("ServletPath: "+request.getServletPath());
		logger.info("QueryString: "+request.getQueryString());
		
		Map<String, String[]> paramMap = request.getParameterMap();
		for(String key:paramMap.keySet()) {
			String[] param = paramMap.get(key);
			for( int i=0;i<param.length;i++) {
				logger.info(String.format("%s, %s", key, param[i]));
			}
		}
		HttpSession httpsession = request.getSession();
		httpsession.setAttribute("AOP", "AOP세션");
		logger.info(type + "," + name);
		return joinPoint.proceed();
	}
	
}
