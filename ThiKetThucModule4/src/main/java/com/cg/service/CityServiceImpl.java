package com.cg.service;

import com.cg.model.City;
import com.cg.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public City getById(Long id) {
        return null;
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void remove(Long id) {
    }

    @Override
    public void deleteCity(Long id) {
        cityRepository.deleteCity(id);
    }

    @Override
    public List<City> findAllNotDeleted() {
        return cityRepository.findAllNotDeleted();
    }
}
