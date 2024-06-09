package org.alxtek.locaiai.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.alxtek.locaiai.entities.Utilisateur;
import org.alxtek.locaiai.enums.TypeUtilisateur;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class UtilisateurDto {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private TypeUtilisateur utilisateur;

    UtilisateurDto mapToDto(Utilisateur utilisateur){
       return UtilisateurDto.builder()
               .id(utilisateur.getId())
               .nom(utilisateur.getNom())
               .prenom(utilisateur.getPrenom())
               .email(utilisateur.getEmail())
               .motDePasse(utilisateur.getMotDePasse())
               .build();
    }
    
    Utilisateur mapToModel(UtilisateurDto utilisateurDto){
        return Utilisateur.builder()
                .id(utilisateurDto.getId())
                .nom(utilisateurDto.getNom())
                .prenom(utilisateurDto.getPrenom())
                .email(utilisateurDto.getEmail())
                .motDePasse(utilisateurDto.getMotDePasse())
                .build();
    }

}
