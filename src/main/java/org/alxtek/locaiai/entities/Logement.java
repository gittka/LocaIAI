package org.alxtek.locaiai.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private String image;
    private String codePostal;
    @Enumerated(EnumType.STRING)
    private TypeLogement typeLogement;
    @ManyToOne
    @JoinColumn(name = "proprietaire_id")
    @JsonBackReference
    private Utilisateur proprietaire;
    @OneToMany(mappedBy = "logement", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Annonce> annonces = new ArrayList<>();
}