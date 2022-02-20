package com.example.chalennge.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.chalennge.models.Person;
import com.example.chalennge.repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    
    public ArrayList<Person> listarPersonas(){
        return (ArrayList<Person>) personRepository.findAll();
    }

    public Person guardarPersona(Person persona){
        return personRepository.save(persona);
    }

    public Optional<Person> buscarPersonaPorNombre(String nombre){
        return personRepository.findByNombre(nombre);
    }

    public Optional<Person> buscarPersonaPorApellido(String apellido){
        Optional<Person> personasEncontradas = null;
        if(apellido.length()>=3){
            personasEncontradas = personRepository.findByLetrasApellido(apellido);
        }
        return personasEncontradas;
    }

    public Optional<Person> buscarPersonaPorDNI(String dni){
        return personRepository.findByDni(dni);
    }

}
