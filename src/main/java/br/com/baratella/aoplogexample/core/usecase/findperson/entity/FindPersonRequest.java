package br.com.baratella.aoplogexample.core.usecase.findperson.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class FindPersonRequest {

  private String cpf;
}
