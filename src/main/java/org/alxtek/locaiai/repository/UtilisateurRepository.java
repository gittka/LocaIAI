package org.alxtek.locaiai.repository;

import org.alxtek.locaiai.entities.Utilisateur;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UtilisateurRepository extends PagingAndSortingRepository<Utilisateur, Long> {
}