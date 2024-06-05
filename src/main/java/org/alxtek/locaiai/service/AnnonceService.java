package org.alxtek.locaiai.service;

import org.alxtek.locaiai.entities.Annonce;

import java.util.List;
import java.util.Optional;

public interface AnnonceService {

    List<Annonce> findAllAnnonces();
    Optional<Annonce> findAnnonceById(Long id);
    Annonce updateAnnonce(Long id);
}
