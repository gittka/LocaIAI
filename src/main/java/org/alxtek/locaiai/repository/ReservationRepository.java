package org.alxtek.locaiai.repository;

import org.alxtek.locaiai.entities.Reservation;
import org.alxtek.locaiai.enums.StatutReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT r.id FROM Reservation r")
    List<Long> getAllIds();

    List<Reservation> findAllByStatutNot(StatutReservation reservation);
    List<Reservation> findAllByStatut(StatutReservation reservation);
}
