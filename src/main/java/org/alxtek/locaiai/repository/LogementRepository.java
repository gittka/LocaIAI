package org.alxtek.locaiai.repository;

import org.alxtek.locaiai.entities.Logement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LogementRepository extends JpaRepository<Logement, Long> {
    @Query("SELECT l.id FROM Logement l")
    List<Long> getAllIds();
}
