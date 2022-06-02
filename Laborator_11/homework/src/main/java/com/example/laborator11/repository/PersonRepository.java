package com.example.laborator11.repository;

import com.example.laborator11.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Query("SELECT p FROM Person p WHERE p.username = ?1")
    Person findPersonByUsername(String username);
    @Query("SELECT p FROM Person p WHERE p.id = ?1")
    Person findPersonById(int id);
}