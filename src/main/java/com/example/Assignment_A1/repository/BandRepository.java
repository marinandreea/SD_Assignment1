package com.example.Assignment_A1.repository;

import com.example.Assignment_A1.model.Band;
import com.example.Assignment_A1.model.Concert;
import org.springframework.data.repository.CrudRepository;

public interface BandRepository extends CrudRepository<Band, Integer> {


}
