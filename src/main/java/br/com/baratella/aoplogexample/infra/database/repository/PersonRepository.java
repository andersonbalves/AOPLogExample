package br.com.baratella.aoplogexample.infra.database.repository;

import br.com.baratella.aoplogexample.infra.database.entity.PersonEntity;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

  PersonEntity findByCpf(String cpf);

}
