package com.sorteioapp.sorteioapp.repository;

import com.sorteioapp.sorteioapp.models.Sorteio;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SorteioRepository extends CrudRepository<Sorteio, String> {

    List<Sorteio> findByuser_id(Long id);


}
