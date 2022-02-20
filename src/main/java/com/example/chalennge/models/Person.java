package com.example.chalennge.models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.*;
import java.util.Date;

//Se utilizan las anotaciones de Lombok para la creacion de los getters y setters necesarios
//Se utilizan las anotacions de validation para la validacion para atributos vacios y tamaño
@Getter
@Setter
@Entity
@Table (name = "personas")
public class Person {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona", unique = true, nullable = false)
    private Integer id;

    @NotEmpty(message = "El nombre no puede estar vacio")
    @Size(min = 3, max = 100, message = "El nombre tiene que tener minimo 3 caracteres")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    
    @NotEmpty(message = "El apellido no puede estar vacio")
    @Size(min = 3, max = 100, message = "El apellido tiene que tener minimo 3 caracteres")
    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;
    
    @NotEmpty(message = "El sexo no puede estar vacio")
    @Column(name = "sexo", nullable = false, length = 20)
    private String sexo;

    @NotEmpty(message = "El DNI no puede estar vacio")
    @Size(min = 7, max = 50, message = "El apellido tiene que tener minimo 3 caracteres")
    @Column(name = "dni", unique = true, nullable = false, length = 50)
    private String dni;



}
