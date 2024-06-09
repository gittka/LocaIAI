package org.alxtek.locaiai.service;

import org.alxtek.locaiai.entities.Annonce;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface AnnonceService {

    List<Annonce> findAllAnnonces();
    Page<Annonce> getAllAnnonces(int page, int size);
    Optional<Annonce> findAnnonceById(Long id);
    Annonce updateAnnonce(Long id);
}
