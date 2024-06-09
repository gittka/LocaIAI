package org.alxtek.locaiai.controller;

import lombok.AllArgsConstructor;
import org.alxtek.locaiai.enums.TypeUtilisateur;
import org.alxtek.locaiai.web.UtilsService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class UtilController {

    private final UtilsService utilService;

    @GetMapping("/classes")
    public List<String> getClasses() {
        return utilService.getClasses();
    }

    @GetMapping("/generate-data")
    public void generateData (@RequestParam String className, @RequestParam int rowCount) throws IllegalAccessException, InstantiationException {
       utilService.generateData(className, rowCount);
    }

    @GetMapping("/types")
    public TypeUtilisateur[] getTypes() {
        return TypeUtilisateur.values();
    }
}