package org.alxtek.locaiai.controller;

import lombok.AllArgsConstructor;
import org.alxtek.locaiai.entities.Utilisateur;
import org.alxtek.locaiai.web.UtilisateurServiveImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class UtilisateurController {
    private final UtilisateurServiveImpl utilisateurServive;

    @GetMapping("/utilisateurs")
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs(){
        List<Utilisateur> utilisateurs = utilisateurServive.findAllUtilisateurs();
        return  ResponseEntity.ok(utilisateurs);
    }
    @GetMapping("/utilisateur/{id}")
    public ResponseEntity<Utilisateur> getUtilisateur(@PathVariable("id") Long id){
        return new ResponseEntity<>(utilisateurServive.findUtilisateur(id).get(), HttpStatus.OK);
    }
    @PostMapping("/addUtilisateur")
    public ResponseEntity<Utilisateur> addUtilisateur(@RequestBody Utilisateur utilisateur){
        return new ResponseEntity<>(utilisateurServive.saveUtilisateur(utilisateur), HttpStatus.CREATED);
    }
    @PutMapping(value = "/updateUtilisateur", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Utilisateur updateUtilisateur(@RequestBody() Utilisateur utilisateur){
        return  utilisateurServive.updateUtilisateur(utilisateur);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUtilisateur(@PathVariable("id") Long id){
        utilisateurServive.deleteUtilisateur(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
