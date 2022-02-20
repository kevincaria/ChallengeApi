package com.example.chalennge.repositories;

import java.util.Optional;

import com.example.chalennge.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{
    public Optional<Person> findByNombre(String nombre);
    public Optional<Person> findByDni(String dni);

    @Query("SELECT p FROM Person p WHERE p.apellido LIKE :apellido%")
    public Optional<Person> findByLetrasApellido(@Param("apellido") String apellido);

}
