package org.alxtek.locaiai.controller;

import lombok.AllArgsConstructor;
import org.alxtek.locaiai.repository.LogementRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LogementController {
    private final LogementRepository logementRepository;
}
