package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.persistence.Commande;
@Repository
public interface CommandeRepository extends CrudRepository<Commande,Long> {

}
