package org.alxtek.locaiai.repository;

import org.alxtek.locaiai.entities.Annonce;
import org.alxtek.locaiai.enums.Disponibilite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {

    @Query("SELECT a.id FROM Annonce a")
    List<Long> getAllIds();

    List<Annonce> findAllByDisponibilite (Disponibilite disponibilite);

    @Query("SELECT a FROM Annonce a WHERE a.disponibilite = :disponibilite" )
    List<Annonce> findAllByDisponibilites (@Param("disponibilite") Disponibilite disponibilite);
}
