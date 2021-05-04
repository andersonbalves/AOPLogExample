package br.com.baratella.aoplogexample.infra.log.entity;

import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class LoggerDTO {

  private String className;
  private String method;
  private Map<String, Object> params;

}
