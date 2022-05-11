package com.cg.repository;

import com.cg.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Modifying
    @Query("UPDATE City c SET c.deleted = true WHERE c.id= :id")
    void deleteCity(@Param("id") Long id);


    @Query("SELECT c FROM City c WHERE c.deleted = false ")
    List<City> findAllNotDeleted();

}
