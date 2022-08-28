package com.luv2code.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.internal.util.beans.BeanInfoHelper.ReturningBeanInfoDelegate;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class CRMLoggingAspect {

	
	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// setup pointcut declarations, starting for controller
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))") // POINTCUT MAPIRAN NA SVE KLASE I METODE BILO KOG POVRATNOG TIPA KOJE SU UNUTAR CONTROLLERA
	private void forControllerPackage() {}
	
	// setup pointcut for service
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))") // POINTCUT MAPIRAN NA SVE KLASE I METODE BILO KOG POVRATNOG TIPA KOJE SU UNUTAR SERVICEA
	private void forServicePackage() {}
	
	// setup pointcut for DAO
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))") // POINTCUT MAPIRAN NA SVE KLASE I METODE BILO KOG POVRATNOG TIPA KOJE SU UNUTAR DAO
	private void forDaoPackage() {}
	
	// setup poincut that will be alligned for either forControllerPackage() || forServicePackage() || forDaoPackage()
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()") // POINTCUT MAPIRAN NA SVE POINTCUTE IZNAD COMBINED
	private void forAppFlow() {}
	
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		// display method we are calling
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("CRMLoggingAspect =================>>> in @Before: calling method: " +method);
		
		// display the arguments to the method
		
			// get the arguments
			Object[] args = theJoinPoint.getArgs();
			
			
			// loop thru and display args
			for(Object o: args) {
				
				myLogger.info("==============> argument: " +o);
				
			}
			
	}
	
	// add @AfterReturning advice
	@AfterReturning(
			pointcut = "forAppFlow()",
			returning = "theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		// display method we are returning from
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("CRMLoggingAspect ===============>>> in @AfterReturning: calling method: " +method);
		
		// display data returned
		myLogger.info("theResult data ==========>>> result: " +theResult);
	}
	
}
