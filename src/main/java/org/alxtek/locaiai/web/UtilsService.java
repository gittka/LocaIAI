package org.alxtek.locaiai.web;

import lombok.AllArgsConstructor;
import org.alxtek.locaiai.entities.*;
import org.alxtek.locaiai.enums.Disponibilite;
import org.alxtek.locaiai.enums.StatutReservation;
import org.alxtek.locaiai.enums.TypeLogement;
import org.alxtek.locaiai.enums.TypeUtilisateur;
import org.alxtek.locaiai.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UtilsService {
    private final AnnonceRepository annonceRepository;

    private final EvaluationRepository evaluationRepository;

    private final UtilisateurRepository utilisateurRepository;

    private final LogementRepository logementRepository;

    private final ReservationRepository reservationRepository;

    private static final Random random = new Random();

    List<Utilisateur> utilisateurs = utilisateurRepository.findAll();

    List<Disponibilite> disponibilites = List.of(Disponibilite.values());

    List<StatutReservation> statutReservations = List.of(StatutReservation.values());

    List<Logement> logements = logementRepository.findAll();

    List<Annonce> annonces = annonceRepository.findAll();

    private static final Map<String, Class<?>> CLASS_MAP = Map.of(
            "Annonces", Annonce.class,
            "Réservations", Reservation.class,
            "Utilisateurs", Utilisateur.class,
            "Evaluations", Evaluation.class,
            "Logements", Logement.class
    );

    public Class<?> getClassByName(String name) {
        return CLASS_MAP.get(name);
    }

    public List<String> getClasses() {
        return new ArrayList<>(CLASS_MAP.keySet());
    }

    public String getRandomInt() {
        List<Integer> nombres = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        String s = "";
        for (int i = 0; i < 4; i++) {
            s.concat(nombres.get(random.nextInt(nombres.size())).toString());
        }
        return s;
    }

    public void generateData(String className, int rowCount) throws IllegalAccessException, InstantiationException {
        Class<?> clazz;
        switch (className) {
            case "Annonces":
                clazz = Annonce.class;
                generateAnnonces(rowCount);
                break;
            case "Réservations":
                clazz = Reservation.class;
                generateReservations(rowCount);
                break;
            case "Utilisateurs":
                clazz = Utilisateur.class;
                generateUtilisateurs(rowCount);
                break;
            case "Logements":
                clazz = Logement.class;
                generateLogements(rowCount);
                break;
            case "Evaluations":
                clazz = Evaluation.class;
                generateEvaluations(rowCount);
                break;
            default:
                throw new IllegalArgumentException("Classe non reconnue : " + className);
        }
    }

    private void generateAnnonces(int rowCount) {
        for (int i = 0; i < rowCount; i++) {
            Annonce annonce = new Annonce();
            annonce.setDescription("Description de l'annonce " + i);
            annonce.setTitre("Titre de l'annonce " + i);
            if (!utilisateurs.isEmpty()) {
                Utilisateur randomUtilisateur = utilisateurs.get(random.nextInt(utilisateurs.size()));
                annonce.setHote(randomUtilisateur);
            }
            annonce.setDebutAnnonce(LocalDate.of(random.nextInt(2010, 2023), random.nextInt(1, 12), random.nextInt(1, 28)));
            annonce.setPrix(random.nextDouble(10, 100) * 1000);
            annonce.setPromotion(random.nextDouble(0, 0.03));
            annonce.setDisponibilite(disponibilites.get(random.nextInt(disponibilites.size())));
            Logement logement = logements.get(random.nextInt(logements.size()));
            annonce.setLogement(logement);
            annonce.setHote(utilisateurs.get(random.nextInt(utilisateurs.size())));
            logement.getAnnonces().add(annonceRepository.save(annonce));
            logementRepository.save(logement);
        }
    }

    private void generateReservations(int rowCount) {
        Annonce annonce = new Annonce();
        List<Annonce> annoncess = annonceRepository.findAllByDisponibilite(Disponibilite.DISPONIBLE);
        for (int i = 0; i < rowCount; i++) {
            Reservation reservation = new Reservation();
            reservation.setStatut(statutReservations.get(random.nextInt(statutReservations.size())));
            reservation.setNombrePersonnes(random.nextInt(1, 7));
            if (!annoncess.isEmpty()) {
                annonce = annoncess.get(random.nextInt(annoncess.size()));
            }
            reservation.setStatut(statutReservations.get(random.nextInt(statutReservations.size())));
            Utilisateur utilisateur = utilisateurs.get(random.nextInt(utilisateurs.size()));
            reservation.setClient(utilisateur);
            reservation.setDateReservation(annonce.getDebutAnnonce().plusDays(random.nextInt(1, 500)));
            reservation.setAnnonce(annonce);
            reservation.setPrixTotal(annonce.getPrix() * annonce.getPromotion());
            Reservation reservation1 = reservationRepository.save(reservation);
            annonce.getReservations().add(reservation1);
            utilisateur.getReservations().add(reservation1);
            utilisateurRepository.save(utilisateur);
            annonceRepository.save(annonce);
        }
    }

    private void generateUtilisateurs(int rowCount) {
        for (int i = 0; i < rowCount; i++) {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setNom(UUID.randomUUID().toString().substring(0, 8));
            utilisateur.setPrenom(UUID.randomUUID().toString().substring(0, 8));
            utilisateur.setEmail(UUID.randomUUID().toString().substring(0, 8) + "@example.com");
            utilisateur.setType(random.nextBoolean() ? TypeUtilisateur.HOTE : TypeUtilisateur.CLIENT);
            utilisateurRepository.save(utilisateur);
        }
    }

    private void generateLogements(int rowCount) {
        for (int i = 0; i < rowCount; i++) {
            Logement logement = new Logement();
            List<TypeLogement> types = List.of(TypeLogement.values());
            int randomIndex = random.nextInt(TypeLogement.values().length);
            logement.setAdresse(UUID.randomUUID().toString().substring(0, 8));
            logement.setVille(UUID.randomUUID().toString().substring(0, 8));
            logement.setCodePostal(getRandomInt());
            logement.setTypeLogement(types.get(randomIndex));
            logementRepository.save(logement);
        }
    }

    private void generateEvaluations(int rowCount) {
        for (int i = 0; i < rowCount; i++) {
            Evaluation evaluation = new Evaluation();
            evaluation.setComment("Commentaire de l'évaluation " + i);
            evaluation.setNote(random.nextInt(1, 5));
            Annonce annonce = annonces.get(random.nextInt(annonces.size()));
            evaluation.setDate(annonce.getDebutAnnonce().plusDays(random.nextInt(1, 500)));
            Utilisateur utilisateur = utilisateurs.get(random.nextInt(utilisateurs.size()));
            evaluation.setAnnonce(annonce);
            evaluation.setUtilisateur(utilisateur);
            Evaluation evaluation1 = evaluationRepository.save(evaluation);
            annonce.getEvaluations().add(evaluation1);
            utilisateur.getEvaluations().add(evaluation1);
            annonceRepository.save(annonce);
            utilisateurRepository.save(utilisateur);
        }
    }
}
