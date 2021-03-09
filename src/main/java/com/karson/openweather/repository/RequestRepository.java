package com.karson.openweather.repository;

import com.karson.openweather.model.Request;
import org.springframework.data.repository.CrudRepository;

public interface RequestRepository extends CrudRepository<Request, Long> {

}
