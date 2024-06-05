package org.alxtek.locaiai.controller;

import lombok.AllArgsConstructor;
import org.alxtek.locaiai.repository.AnnonceRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AnnonceContrtoller {
    private final AnnonceRepository annonceRepository;
}
