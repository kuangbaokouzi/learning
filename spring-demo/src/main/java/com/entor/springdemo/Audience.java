package com.entor.springdemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audience {

	/**
	 * 切点
	 */
	@Pointcut("execution(* com.entor.springdemo.Performer.perform(..))")
	public void audiencePointcut() {

	}

	@Pointcut("execution(* com.entor.springdemo.Performer.perform(..)) && args(args))")
	public void audiencePointcut(String args) {

	}

	/**
	 * 前置通知
	 */
	@Before("audiencePointcut(args)")
	public void takeSeat(String args) {
		System.out.println("观众就坐..." + args);
	}

	/**
	 * 返回通知
	 */
	public void clap(String args, String args2) {
		System.out.println("表演完美落幕，观众鼓掌...");
	}

	/**
	 * 异常通知
	 */
	public void shock() {
		System.out.println("表演发生意外，观众们惊呼不断...");
	}

	/**
	 * 返回通知
	 */
	public void leave() {
		System.out.println("表演结束...");
	}

	/**
	 * 环绕通知
	 * 
	 * @param pjp
	 * @return
	 */
	@Around("audiencePointcut(args)")
	public Object around(ProceedingJoinPoint pjp, String args) throws Throwable {
		Object obj = null;
		System.out.println("观众渐渐平息，开始期待接下来的表演..." + args);
		System.out.println(pjp);
		obj = pjp.proceed();// 执行接入点
		System.out.println("观众聚精会神，意犹未尽..." + args);
		return obj;
	}
}
