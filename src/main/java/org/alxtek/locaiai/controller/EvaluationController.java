package org.alxtek.locaiai.controller;

import lombok.AllArgsConstructor;
import org.alxtek.locaiai.repository.EvaluationRepository;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class EvaluationController {
    private final EvaluationRepository evaluationRepository;
}
