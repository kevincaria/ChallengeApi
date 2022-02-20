package com.example.chalennge.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.chalennge.models.Person;
import com.example.chalennge.services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
public class PersonController {
    @Autowired 
    private PersonService personService;
    
    @GetMapping
    public ArrayList<Person> listarPersonas(){
        return personService.listarPersonas();
    }

    @PostMapping
    public Person guardarPersona(@RequestBody Person persona){
        return personService.guardarPersona(persona);
    }

    @GetMapping("/queryNombre")
    public Optional<Person> buscarPersonaPorNombre(@RequestParam("nombre") String nombre){
        return personService.buscarPersonaPorNombre(nombre);
    }

    @GetMapping("/queryApellido")
    public Optional<Person> buscarPersonaPorApellido(@RequestParam("apellido") String apellido){
        return personService.buscarPersonaPorApellido(apellido);
    }

    @GetMapping("/queryDni")
    public Optional<Person> buscarPersonaPorDNI(@RequestParam("dni") String dni){
        return personService.buscarPersonaPorDNI(dni);
    }

    @PutMapping("/actualizar")
    public Person actualizarPersona(@RequestBody Person persona){
        return personService.guardarPersona(persona);
    }
}
