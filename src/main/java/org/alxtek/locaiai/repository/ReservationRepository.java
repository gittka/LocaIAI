package org.alxtek.locaiai.repository;

import org.alxtek.locaiai.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT r.id FROM Reservation r")
    List<Long> getAllIds();
}
