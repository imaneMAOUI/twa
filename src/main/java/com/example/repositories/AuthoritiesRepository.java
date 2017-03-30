package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.persistence.Authorities;
import com.example.persistence.User;

@Repository
public interface AuthoritiesRepository extends CrudRepository<Authorities,Long>{

}
