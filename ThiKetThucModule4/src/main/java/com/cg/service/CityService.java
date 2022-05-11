package com.cg.service;

import com.cg.model.City;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityService extends IGeneralService<City> {
    void deleteCity(@Param("id") Long id);

    List<City> findAllNotDeleted();
}
