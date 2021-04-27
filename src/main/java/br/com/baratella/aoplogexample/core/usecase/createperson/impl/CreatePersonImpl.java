package br.com.baratella.aoplogexample.core.usecase.createperson.impl;

import br.com.baratella.aoplogexample.core.repository.IPersonRepository;
import br.com.baratella.aoplogexample.core.usecase.createperson.ICreatePerson;
import br.com.baratella.aoplogexample.core.usecase.createperson.entity.CreatePersonRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CreatePersonImpl implements ICreatePerson {

  private final IPersonRepository repository;

  @Override
  public void execute(CreatePersonRequest request) {
    repository.savePerson(request);
  }

}
