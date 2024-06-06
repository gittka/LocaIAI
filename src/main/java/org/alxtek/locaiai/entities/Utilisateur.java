package org.alxtek.locaiai.entities;

import jakarta.persistence.*;
import lombok.*;
import org.alxtek.locaiai.enums.TypeUtilisateur;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Setter @Getter @Builder
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    @Enumerated(EnumType.STRING)
    private TypeUtilisateur type;
    @OneToMany(mappedBy = "hote", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Annonce> annonces = new ArrayList<>();
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();
    @OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Evaluation> evaluations = new ArrayList<>();
    @OneToMany(mappedBy = "proprietaire", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Logement> logements = new ArrayList<>();
}
