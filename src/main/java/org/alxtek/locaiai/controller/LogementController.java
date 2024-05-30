package org.alxtek.locaiai.controller;

import lombok.AllArgsConstructor;
import org.alxtek.locaiai.repository.LogementRepository;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class LogementController {
    private final LogementRepository logementRepository;
}
