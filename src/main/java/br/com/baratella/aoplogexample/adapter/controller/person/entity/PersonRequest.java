package br.com.baratella.aoplogexample.adapter.controller.person.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonRequest {

  private String name;
  private String lastName;
  private String cpf;
  private Date birthDate;
}
