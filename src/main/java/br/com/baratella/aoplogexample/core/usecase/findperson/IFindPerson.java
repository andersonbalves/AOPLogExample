package br.com.baratella.aoplogexample.core.usecase.findperson;

import br.com.baratella.aoplogexample.core.usecase.findperson.entity.FindPersonRequest;
import br.com.baratella.aoplogexample.core.usecase.findperson.entity.FindPersonResponse;

public interface IFindPerson {

  FindPersonResponse execute(FindPersonRequest request);
}
