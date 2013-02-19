/*
 *******************************************************************************
 * All rights Reserved, Copyright (C) https://github.com/redstarofsleep 2013
 * FileName: CommonLog.java
 * Modify record:
 * NO. |     Date       |    Version      |    Name         |      Content
 * 1   | 2013-2-20      |      1.0        | LHC)LuHaosheng | original version
 *******************************************************************************
 */
package lhc.webim.common.log;

import lhc.webim.common.constant.StateDefine;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Class name:CommonLog
 * Description: 共通日志
 * @author LuHaosheng
 */
@Aspect
public class CommonLog {

	private static final Logger sysLogger = Logger.getLogger(StateDefine.SYS_LOG);
	private static final Logger infoLogger = Logger.getLogger(StateDefine.INFO_LOG);
	
	@Pointcut("execution(* lhc.webim.web..*Controller.* (..))")
	public void action(){};
	
	@Pointcut("execution(* lhc.webim.web..*Service*.* (..))")
	public void service(){};
	
	/**
	 * Description: Service方法抛异常时自动记日志
	 * @param ex
	 */
	@AfterThrowing(pointcut="service()", throwing="ex")
	public void exceptionOfMethod(Exception ex) {
		infoLogger.error(LogUtil.getExceptions(ex));
		sysLogger.error("*** Error occurred: ", ex);
	}
	
	/**
	 * Description: Action方法抛异常时自动记日志
	 * @param ex
	 */
	@AfterThrowing(pointcut="action()", throwing="ex")
	public void exceptionOfAction(Exception ex) {
		infoLogger.error(LogUtil.getExceptions(ex));
		sysLogger.error("*** Error occurred: ", ex);
	}
	
	/**
	 * Description: Controller/Action开始前自动记日志
	 * @param joinPoint
	 */
	@Before(value="action()")
	public void beforeAction(JoinPoint joinPoint) {
		sysLogger.info("*** Start action: " + LogUtil.getInformation(joinPoint));
	}
	
	/**
	 * Description: Controller/Action结束时自动记日志
	 * @param joinPoint
	 * @param retVal
	 */
	@AfterReturning(pointcut="action()", returning="retVal")
	public void afterAction(JoinPoint joinPoint, Object retVal) {
		sysLogger.info("--action return: " + retVal);
		sysLogger.info("*** End action: " + LogUtil.getInformation(joinPoint));
	}
	
	/**
	 * Description: Service开始前自动记日志
	 * @param joinPoint
	 */
	@Before(value="service()")
	public void beforeService(JoinPoint joinPoint) {
		sysLogger.info("*** Start service: " + LogUtil.getInformation(joinPoint));
	}
	
	/**
	 * Description: Service结束时自动记日志
	 * @param joinPoint
	 */
	@After(value="service()")
	public void afterService(JoinPoint joinPoint) {
		sysLogger.info("*** End service: " + LogUtil.getInformation(joinPoint));
	}
}
