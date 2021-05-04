package br.com.baratella.aoplogexample.infra.log.logger;

import br.com.baratella.aoplogexample.infra.log.entity.LoggerDTO;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.ObjectMessage;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class AOPServiceLogger {

  @Pointcut("@within(org.springframework.stereotype.Service)")
  private void servicePointcut() {
  }

  @Before("servicePointcut()")
  public void logBefore(JoinPoint joinPoint) throws Throwable {
    LoggerDTO dto = LoggerDTO.builder()
        .className(joinPoint.getClass().getName())
        .method(joinPoint.getSignature().getName())
        .params(buildParamsMap(joinPoint))
        .build();

    log.info("-> Método " + dto.getMethod() + " iniciado com as seguintes informações:\n"
        + new ObjectMessage(dto).getFormattedMessage());
  }
  @AfterReturning(pointcut = "servicePointcut()", returning = "retVal")
  public void logAfter(JoinPoint joinPoint, Object retVal) {
    log.info("<- O método " + joinPoint.getSignature().getName() + " foi executado e retornou:\n"
        + new ObjectMessage(retVal).getFormattedMessage());
  }


  private Map<String, Object> buildParamsMap(JoinPoint joinPoint) {
    String[] argNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
    Object[] values = joinPoint.getArgs();
    Map<String, Object> params = new HashMap<>();
    if (argNames.length != 0) {
      for (int i = 0; i < argNames.length; i++) {
        params.put(argNames[i], values[i]);
      }
    }
    return params;
  }

}
