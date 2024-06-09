package org.alxtek.locaiai.controller;

import lombok.AllArgsConstructor;
import org.alxtek.locaiai.entities.Annonce;
import org.alxtek.locaiai.web.AnnonceServiveImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class AnnonceContrtoller {

    private final AnnonceServiveImpl annonceServive;

    /*@GetMapping("/annonces")
    public Page<Annonce> getAnnonces(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "6") int size) {
        return annonceServive.getAllAnnonces(page, size);
    }*/

    /*@GetMapping("/annonces")
    public Page<Annonce> getAnnonces(Pageable pageable) {
        return  annonceServive.getAllAnnonces(pageable);
    }*/

    @GetMapping("/annonces")
    public ResponseEntity<Page<Annonce>> getAnnonces(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5 ") int size){
    Pageable pageable = PageRequest.of(page, size);
    Page<Annonce> annonces = annonceServive.getAllAnnonces(pageable);
    return ResponseEntity.ok(annonces);
    }
}
