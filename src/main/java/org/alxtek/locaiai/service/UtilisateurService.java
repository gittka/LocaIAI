package org.alxtek.locaiai.service;

import org.alxtek.locaiai.dto.UtilisateurDto;
import org.alxtek.locaiai.entities.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface UtilisateurService {
    List<Utilisateur> findAllUtilisateurs();
    Utilisateur saveUtilisateur(Utilisateur utilisateur);
    Optional<Utilisateur> findUtilisateur(Long id);
    Utilisateur updateUtilisateur(Utilisateur utilisateur);
    void deleteUtilisateur(Long id);
}
