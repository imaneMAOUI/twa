package com.example.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.persistence.Plat;

@Repository
public interface PlatRepository extends CrudRepository<Plat,Long>{
	List<Plat> findAll();
}
