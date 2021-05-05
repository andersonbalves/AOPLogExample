package br.com.baratella.aoplogexample.adapter.controller.person;

import br.com.baratella.aoplogexample.adapter.controller.person.entity.PersonRequest;
import br.com.baratella.aoplogexample.adapter.controller.person.entity.PersonResponse;
import br.com.baratella.aoplogexample.core.usecase.createperson.ICreatePerson;
import br.com.baratella.aoplogexample.core.usecase.createperson.entity.CreatePersonRequest;
import br.com.baratella.aoplogexample.core.usecase.findperson.IFindPerson;
import br.com.baratella.aoplogexample.core.usecase.findperson.entity.FindPersonRequest;
import br.com.baratella.aoplogexample.core.usecase.findperson.entity.FindPersonResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class PersonController {

  private final ICreatePerson createPerson;

  private final IFindPerson findPerson;

  @RequestMapping(value = "/person", method = RequestMethod.PUT)
  public ResponseEntity savePerson(@RequestBody PersonRequest request) {
    CreatePersonRequest createRequest = CreatePersonRequest.builder()
        .name(request.getName())
        .lastName(request.getLastName())
        .cpf(request.getCpf())
        .birthDate(request.getBirthDate())
        .build();
    createPerson.execute(createRequest);
    return new ResponseEntity("Person was saved", HttpStatus.OK);
  }

  @RequestMapping(value = "/person", method = RequestMethod.GET)
  public ResponseEntity<PersonResponse> findPersonByCPF(@RequestParam("cpf") String cpf) {
    FindPersonRequest request = FindPersonRequest.builder()
        .cpf(cpf)
        .build();
    FindPersonResponse findResponse = findPerson.execute(request);
    PersonResponse response = PersonResponse.builder()
        .name(findResponse.getName())
        .lastName(findResponse.getLastName())
        .cpf(findResponse.getCpf())
        .build();
    return new ResponseEntity(response, HttpStatus.OK);
  }


}
