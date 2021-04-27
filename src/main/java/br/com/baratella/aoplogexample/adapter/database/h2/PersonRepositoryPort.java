package br.com.baratella.aoplogexample.adapter.database.h2;

import br.com.baratella.aoplogexample.core.repository.IPersonRepository;
import br.com.baratella.aoplogexample.core.usecase.createperson.entity.CreatePersonRequest;
import br.com.baratella.aoplogexample.core.usecase.findperson.entity.FindPersonRequest;
import br.com.baratella.aoplogexample.core.usecase.findperson.entity.FindPersonResponse;
import br.com.baratella.aoplogexample.infra.database.entity.PersonEntity;
import br.com.baratella.aoplogexample.infra.database.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PersonRepositoryPort implements IPersonRepository {

  private final PersonRepository personRepository;

  public void savePerson(CreatePersonRequest request) {
    PersonEntity person = PersonEntity.builder()
        .name(request.getName())
        .lastName(request.getLastName())
        .cpf(request.getCpf())
        .build();
    personRepository.saveAndFlush(person);
  }

  @Override
  public FindPersonResponse findPerson(FindPersonRequest request) {
    PersonEntity person = personRepository.findByCpf(request.getCpf());
    return FindPersonResponse.builder()
        .name(person.getName())
        .lastName(person.getLastName())
        .cpf(person.getCpf())
        .build();
  }

}
