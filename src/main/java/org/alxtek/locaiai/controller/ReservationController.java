package org.alxtek.locaiai.controller;

import lombok.AllArgsConstructor;
import org.alxtek.locaiai.entities.Reservation;
import org.alxtek.locaiai.repository.ReservationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReservationController {
    private final ReservationRepository reservationRepository;

    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> getAllReservations(){
        List<Reservation> reservations = reservationRepository.findAll();
        return  ResponseEntity.ok(reservations);
    }
    @GetMapping("/reservation")
    public ResponseEntity<Page<Reservation>> getReservations(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5 ") int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Reservation> reservations = reservationRepository.findAll(pageable);
        return ResponseEntity.ok(reservations);
    }
}