package org.alxtek.locaiai.entities;

import jakarta.persistence.*;
import lombok.*;
import org.alxtek.locaiai.enums.TypeLogement;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Builder
@Getter @Setter
public class Logement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String adresse;
    private String ville;
    private String codePostal;
    @Enumerated(EnumType.STRING)
    private TypeLogement typeLogement;
    @ManyToOne
    @JoinColumn(name = "proprietaire_id")
    private Utilisateur proprietaire;
    @OneToMany(mappedBy = "logement", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Annonce> annonces = new ArrayList<>();
}