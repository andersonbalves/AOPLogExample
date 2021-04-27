package br.com.baratella.aoplogexample.core.repository;

import br.com.baratella.aoplogexample.core.usecase.createperson.entity.CreatePersonRequest;
import br.com.baratella.aoplogexample.core.usecase.findperson.entity.FindPersonRequest;
import br.com.baratella.aoplogexample.core.usecase.findperson.entity.FindPersonResponse;

public interface IPersonRepository {

  void savePerson(CreatePersonRequest request);

  FindPersonResponse findPerson(FindPersonRequest request);
}
