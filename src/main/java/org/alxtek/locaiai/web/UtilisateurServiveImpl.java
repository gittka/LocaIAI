package org.alxtek.locaiai.web;

import lombok.AllArgsConstructor;
import org.alxtek.locaiai.entities.Utilisateur;
import org.alxtek.locaiai.repository.UtilisateurRepository;
import org.alxtek.locaiai.service.UtilisateurService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UtilisateurServiveImpl implements UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    @Override
    public List<Utilisateur> findAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Optional<Utilisateur> findUtilisateur(Long id) {
        return utilisateurRepository.findById(id);
    }

    @Override
    public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
        Utilisateur u = new Utilisateur();
        if (utilisateurRepository.findById(utilisateur.getId()).isPresent()) {
            u = utilisateurRepository.findById(utilisateur.getId()).get();
            u.setNom(utilisateur.getNom());
            u.setEmail(utilisateur.getEmail());
            u.setPrenom(utilisateur.getPrenom());
            u.setMotDePasse(utilisateur.getMotDePasse());
            u.setType(utilisateur.getType());
            utilisateurRepository.save(u);
        }
        return u;
    }

    @Override
    public void deleteUtilisateur(Long id) {
        if (utilisateurRepository.findById(id).isPresent()){
            utilisateurRepository.deleteById(id);
        }
    }
}