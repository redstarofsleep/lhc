/*
 *******************************************************************************
 * All rights Reserved, Copyright (C) https://github.com/redstarofsleep 2013
 * FileName: LogUtil.java
 * Modify record:
 * NO. |     Date       |    Version      |    Name         |      Content
 * 1   | 2013-2-20      |      1.0        | LHC)LuHaosheng  | original version
 *******************************************************************************
 */
package lhc.webim.common.log;

import org.aspectj.lang.JoinPoint;

/**
 * Class name:LogUtil
 * Description: 写日志的工具类
 * @author LuHaosheng
 */
public class LogUtil {

	/**
	 * Description: 获得类,方法信息
	 * @param joinPoint
	 * @return
	 */
	public static String getInformation(JoinPoint joinPoint) {
		StringBuilder messageBuilder = new StringBuilder("--Class: ");
		String name = joinPoint.getSignature().getName();
		Object targetClass = joinPoint.getTarget();
		messageBuilder.append(targetClass.getClass().getSimpleName())
			.append("  --Method: ")
			.append(name);
		return messageBuilder.toString();
	}
	
	/**
	 * Description: 获得异常信息
	 * @param ex
	 * @return
	 */
	public static String getExceptions(Exception ex) {
		String message = null;
		StackTraceElement[] trace = ex.getStackTrace();
		for (StackTraceElement s : trace) {
			if (s.getClassName().startsWith("com.gmsz.dpsp")) {
				message = ("*** Exception happened"
					+ " --Class: " + s.getClassName()
					+ " --Method: " + s.getMethodName()
					+ " --Line: " + s.getLineNumber()
					+ " --Type: " + ex.toString());
			}
		}
		return message;
	}
}
