package org.alxtek.locaiai.controller;

import lombok.AllArgsConstructor;
import org.alxtek.locaiai.repository.ReservationRepository;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class ReservationController {
    private final ReservationRepository reservationRepository;
}
