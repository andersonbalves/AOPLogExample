package br.com.baratella.aoplogexample.core.usecase.createperson;

import br.com.baratella.aoplogexample.core.usecase.createperson.entity.CreatePersonRequest;

public interface ICreatePerson {

  void execute(CreatePersonRequest request);
}
