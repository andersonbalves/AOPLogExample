package br.com.baratella.aoplogexample.adapter.controller.person.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PersonResponse {

  private String name;
  private String lastName;
  private String cpf;
}
