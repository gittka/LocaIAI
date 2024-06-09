package org.alxtek.locaiai.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity @Builder
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int note;
    private String comment;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    @JsonBackReference
    private Utilisateur utilisateur;
    @ManyToOne
    @JoinColumn(name = "annonce_id")
    @JsonBackReference
    private Annonce annonce;
}
