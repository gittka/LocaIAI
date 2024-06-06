package org.alxtek.locaiai.controller;

import lombok.AllArgsConstructor;
import org.alxtek.locaiai.entities.Utilisateur;
import org.alxtek.locaiai.web.UtilisateurServiveImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UtilisateurController {
    private final UtilisateurServiveImpl utilisateurServive;

    @GetMapping("/utilisateurs")
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs(){
        return new ResponseEntity<>(utilisateurServive.findAllUtilisateurs(), HttpStatus.OK);
    }
    @GetMapping("/utilisateur/{id}")
    public ResponseEntity<Utilisateur> getUtilisateur(@PathVariable("id") Long id){
        return new ResponseEntity<>(utilisateurServive.findUtilisateur(id).get(), HttpStatus.OK);
    }
    @PostMapping("/addUtilisateur")
    public ResponseEntity<Utilisateur> addUtilisateur(@RequestBody Utilisateur utilisateur){
        return new ResponseEntity<>(utilisateurServive.saveUtilisateur(utilisateur), HttpStatus.CREATED);
    }
    @PutMapping("/updateUtilisateur")
    public ResponseEntity<Utilisateur> updateUtilisateur(@RequestBody Utilisateur utilisateur){
        return new ResponseEntity<>(utilisateurServive.updateUtilisateur(utilisateur), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUtilisateur(@PathVariable("id") Long id){
        utilisateurServive.deleteUtilisateur(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
