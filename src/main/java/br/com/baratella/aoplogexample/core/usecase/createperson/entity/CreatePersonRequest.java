package br.com.baratella.aoplogexample.core.usecase.createperson.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CreatePersonRequest {

  private String name;
  private String lastName;
  private String cpf;
  private Date birthDate;
}
