package org.alxtek.locaiai.controller;

import lombok.AllArgsConstructor;
import org.alxtek.locaiai.repository.AnnoceRepository;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class AnnonceContrtoller {
    private final AnnoceRepository annoceRepository;
}
