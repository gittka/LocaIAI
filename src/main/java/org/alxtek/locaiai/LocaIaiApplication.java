package org.alxtek.locaiai;

import org.alxtek.locaiai.entities.Utilisateur;
import org.alxtek.locaiai.web.UtilisateurServiveImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.filter.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class LocaIaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocaIaiApplication.class, args);

    }
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedOrigin("http://localhost:4200");
        corsConfiguration.addAllowedHeader(String.valueOf(Arrays.asList("Origin", "Access-Control-Allow-Origin" ,"Accept", "X-Requested-With", "Content-Type",
                "Access-Control-Request-Method","Access-Control-Request-Headers", "Authorization", "Origin, Accept")));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type", "Accept", "Authorization", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
    @Bean
    CommandLineRunner commandLineRunner(UtilisateurServiveImpl utilisateurServive) {
        return args -> {
            utilisateurServive.saveUtilisateur(Utilisateur.builder().nom("John Doe").email("9dMfS@example.com").motDePasse("123456").build());
            utilisateurServive.saveUtilisateur(Utilisateur.builder().nom("Jane Doe").email("9dMfS@example.com").motDePasse("123456").build());
            utilisateurServive.saveUtilisateur(Utilisateur.builder().nom("Alice Doe").email("9dMfS@example.com").motDePasse("123456").build());
        };
    }

}
