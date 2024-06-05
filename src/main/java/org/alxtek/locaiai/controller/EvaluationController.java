package org.alxtek.locaiai.controller;

import lombok.AllArgsConstructor;
import org.alxtek.locaiai.repository.EvaluationRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EvaluationController {
    private final EvaluationRepository evaluationRepository;
}
