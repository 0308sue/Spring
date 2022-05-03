package com.board.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Log
@Aspect
@Component
public class LogAdvice {

	@Before("execution(* com.board.model.BoardService*.*(..))")
	public void logBefore() {
		log.info("=============");
	}
	
	@Around("execution(* com.board.model.BoardService*.*(..))")
	public Object logTime(ProceedingJoinPoint pip) {
		long start = System.currentTimeMillis();
		log.info("Target:"+pip.getTarget());
		log.info("Param:"+Arrays.toString(pip.getArgs()));
		Object result = null;
		
		try {
			result = pip.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("start:"+start);
		log.info("end:"+end);
		log.info("Time:"+(end-start));
		System.out.println("Time:"+(end-start));
		return result;
		
	}
}
