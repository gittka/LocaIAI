package org.alxtek.locaiai.controller;

import lombok.AllArgsConstructor;
import org.alxtek.locaiai.repository.UtilisateurRepository;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class UtilisateurController {
    private final UtilisateurRepository utilisateurRepository;
}
