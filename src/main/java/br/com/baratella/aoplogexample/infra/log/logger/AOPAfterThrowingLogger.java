package br.com.baratella.aoplogexample.infra.log.logger;

import br.com.baratella.aoplogexample.infra.log.entity.LoggerDTO;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.ObjectMessage;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class AOPAfterThrowingLogger {

  @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
  private void restControllerPointcut() {
  }

  @Pointcut("execution(@br.com.baratella.aoplogexample.infra.log.annotation.Log * *(..))")
  private void annotatedMethodPointcut() {
  }
  @Pointcut("@within(org.springframework.stereotype.Service)")
  private void servicePointcut() {
  }

  @AfterThrowing(pointcut = "restControllerPointcut() || annotatedMethodPointcut() || servicePointcut()", throwing = "ex")
  public void logAfter(JoinPoint joinPoint, Exception ex) {
    log.error("Ocorreu uma exceção execudanto o método " + joinPoint.getSignature().getName(), ex);
  }
}
