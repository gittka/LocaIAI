package org.alxtek.locaiai.repository;

import org.alxtek.locaiai.entities.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
    @Query("SELECT e.id FROM Evaluation e")
    List<Long> getAllIds();
}
