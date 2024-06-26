package org.alxtek.locaiai.web;

import lombok.AllArgsConstructor;
import org.alxtek.locaiai.entities.Annonce;
import org.alxtek.locaiai.repository.AnnonceRepository;
import org.alxtek.locaiai.service.AnnonceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class AnnonceServiveImpl implements AnnonceService {

    private final AnnonceRepository annonceRepository;

    @Override
    public List<Annonce> findAllAnnonces() {
        return annonceRepository.findAll();
    }

    @Override
    public Page<Annonce> getAllAnnonces(int page, int size) {
        return annonceRepository.findAll(PageRequest.of(page, size));
    }

    public Page <Annonce> getAllAnnonces(Pageable pageable) {
        return annonceRepository.findAll(pageable);
    }

    @Override
    public Optional<Annonce> findAnnonceById(Long id) {
        return Optional.empty();
    }

    @Override
    public Annonce updateAnnonce(Long id) {
        return null;
    }
}
