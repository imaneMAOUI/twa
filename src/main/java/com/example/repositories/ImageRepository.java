package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.persistence.Image;
@Repository
public interface ImageRepository extends CrudRepository<Image,Long>{

}
