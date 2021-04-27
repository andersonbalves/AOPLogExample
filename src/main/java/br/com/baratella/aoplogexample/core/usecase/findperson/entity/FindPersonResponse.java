package br.com.baratella.aoplogexample.core.usecase.findperson.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class FindPersonResponse {

  private String name;
  private String lastName;
  private String cpf;
  private Date birthDate;
}
