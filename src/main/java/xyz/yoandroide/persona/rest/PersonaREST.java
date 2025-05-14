package xyz.yoandroide.persona.rest;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.yoandroide.persona.model.Persona;
import xyz.yoandroide.persona.service.PersonaService;

import java.util.List;

@RestController
@RequestMapping ("/persona/")
public class PersonaREST {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    private ResponseEntity<List<Persona>> getAllPersonas(){
        return ResponseEntity.ok(personaService.findAll());
    }

    @PostMapping
    private ResponseEntity<Persona> savePersona (@RequestBody Persona persona){

        Persona personaGuardada = personaService.save(persona);
        return ResponseEntity.created(new URI("/persona/"+personaGuardada.getId())).body(personaGuardada);
    }
}
