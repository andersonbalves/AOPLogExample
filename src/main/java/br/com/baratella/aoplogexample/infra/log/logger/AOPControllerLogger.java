package br.com.baratella.aoplogexample.infra.log.logger;

import br.com.baratella.aoplogexample.infra.log.entity.LoggerDTO;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.ObjectMessage;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class AOPControllerLogger {

  @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
  private void restControllerPointcut() {
  }

  @Around("restControllerPointcut()")
  public Object logController(ProceedingJoinPoint joinPoint) throws Throwable {
    LoggerDTO dto = new LoggerDTO(joinPoint);

    log.info("-> Método " + dto.getMethod() + " iniciado com as seguintes informações:\n"
        + new ObjectMessage(dto).getFormattedMessage());

    long startTime = new Date().getTime();
    Object result = joinPoint.proceed(joinPoint.getArgs());
    long endTime = new Date().getTime();

    log.info("<- O método " + dto.getMethod() + " levou " +
        (endTime - startTime) + "ms e retornou:\n" + new ObjectMessage(result)
        .getFormattedMessage());

    return result;
  }

}
