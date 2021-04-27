package br.com.baratella.aoplogexample.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Person {

  private String name;
  private String lastName;
  private String cpf;

}
