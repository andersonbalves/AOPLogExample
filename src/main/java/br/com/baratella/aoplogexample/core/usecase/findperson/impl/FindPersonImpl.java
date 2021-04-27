package br.com.baratella.aoplogexample.core.usecase.findperson.impl;

import br.com.baratella.aoplogexample.core.repository.IPersonRepository;
import br.com.baratella.aoplogexample.core.usecase.findperson.IFindPerson;
import br.com.baratella.aoplogexample.core.usecase.findperson.entity.FindPersonRequest;
import br.com.baratella.aoplogexample.core.usecase.findperson.entity.FindPersonResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FindPersonImpl implements IFindPerson {

  private final IPersonRepository repository;

  @Override
  public FindPersonResponse execute(FindPersonRequest request) {
    return repository.findPerson(request);
  }

}
