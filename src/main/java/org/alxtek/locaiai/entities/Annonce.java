package org.alxtek.locaiai.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.alxtek.locaiai.enums.Disponibilite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Builder @Getter @Setter
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;
    private Double prix;
    @Enumerated(EnumType.STRING)
    private Disponibilite disponibilite;
    private double promotion;
    private LocalDate debutAnnonce;
    private LocalDate finAnnonce;
    @ManyToOne
    @JoinColumn(name = "hote_id")
    @JsonManagedReference
    private Utilisateur hote;
    @JsonManagedReference
    @OneToMany(mappedBy = "annonce", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "logement_id")
    @JsonBackReference
    private Logement logement;
    @JsonManagedReference
    @OneToMany(mappedBy = "annonce", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Evaluation> evaluations = new ArrayList<>();
}