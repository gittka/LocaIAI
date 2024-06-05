package org.alxtek.locaiai.repository;

import org.alxtek.locaiai.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    @Query("SELECT u.id FROM Utilisateur u")
    List<Long> getAllIds();

}