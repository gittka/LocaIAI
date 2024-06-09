package org.alxtek.locaiai.web;

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
public class UtilsService {

    public UtilsService(AnnonceRepository annonceRepository,
                        EvaluationRepository evaluationRepository,
                        UtilisateurRepository utilisateurRepository,
                        LogementRepository logementRepository,
                        ReservationRepository reservationRepository) {
        this.annonceRepository = annonceRepository;
        this.evaluationRepository = evaluationRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.logementRepository = logementRepository;
        this.reservationRepository = reservationRepository;
    }

    private final AnnonceRepository annonceRepository;

    private final EvaluationRepository evaluationRepository;

    private final UtilisateurRepository utilisateurRepository;

    private final LogementRepository logementRepository;

    private final ReservationRepository reservationRepository;

    private static final Random random = new Random();


    List<Disponibilite> disponibilites = List.of(Disponibilite.values());

    List<StatutReservation> statutReservations = List.of(StatutReservation.values());


    private static final Map<String, Class<?>> CLASS_MAP = Map.of(
            "Annonces", Annonce.class,
            "Réservations", Reservation.class,
            "Utilisateurs", Utilisateur.class,
            "Evaluations", Evaluation.class,
            "Logements", Logement.class
    );

    private static final List<String> villes = List.of("Libreville", "Port-Gentil", "Franceville", "Oyem", "Moanda", "Mouila", "Lambaréné", "Tchibanga", "Koulamoutou", "Makokou", "Bitam", "Gamba", "Mbigou", "Mitzic", "Lastoursville", "Okondja", "Ndjolé", "Booué", "Mimongo", "Mékambo", "Cocobeach", "Bifoun", "Mandji", "Omboué", "Moussoro", "Moussaoua");

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
            s = s.concat(nombres.get(random.nextInt(nombres.size())).toString());
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
        List<Logement> logements = logementRepository.findAll();
        for (int i = 0; i < rowCount; i++) {
            Annonce annonce = new Annonce();


            annonce.setDebutAnnonce(LocalDate.of(random.nextInt(2010, 2023), random.nextInt(1, 12), random.nextInt(1, 28)));
            annonce.setPrix(random.nextDouble(10, 100) * 1000);
            annonce.setPromotion(random.nextDouble(0, 0.03));
            annonce.setDisponibilite(Disponibilite.DISPONIBLE);
            Logement logement = logements.get(random.nextInt(logements.size()));
            annonce.setLogement(logement);
            annonce.setHote(logement.getProprietaire());
            Annonce annonce1 = annonceRepository.save(annonce);
            annonce1.setDescription("Description de l'annonce " + annonce1.getId());
            annonce1.setTitre("Titre de l'annonce " + annonce1.getId());

            logement.getAnnonces().add(annonceRepository.save(annonce1));
            logementRepository.save(logement);
        }
    }

    private void generateReservations(int rowCount) {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        Annonce annonce = new Annonce();
        List<StatutReservation> list = new ArrayList<>(List.of(StatutReservation.values()));
        list.remove(StatutReservation.ACCEPTED);
        List<Annonce> annoncess = annonceRepository.findAll();
        for (int i = 0; i < rowCount; i++) {
            Reservation reservation = new Reservation();
            reservation.setStatut(statutReservations.get(random.nextInt(statutReservations.size())));
            reservation.setNombrePersonnes(random.nextInt(1, 7));
            if (!annoncess.isEmpty()) {
                annonce = annoncess.get(random.nextInt(annoncess.size()));
            }
            Utilisateur utilisateur = utilisateurs.get(random.nextInt(utilisateurs.size()));
            while (utilisateur.getId().equals(annonce.getHote().getId())) {
                utilisateur = utilisateurs.get(random.nextInt(utilisateurs.size()));
            }
            reservation.setClient(utilisateur);
            reservation.setDateReservation(annonce.getDebutAnnonce().plusDays(random.nextInt(1, 500)));
            List<Reservation> reservations =annonce.getReservations();
            if (reservations.isEmpty()){
                reservation.setAnnonce(annonce);
            } else {
                for (Reservation reservation1 : reservations) {
                    if (reservation1.getStatut().equals(StatutReservation.ACCEPTED)){
                        annonce.setDisponibilite(Disponibilite.INDISPONIBLE);
                        reservation.setStatut(list.get(random.nextInt(list.size())));
                        break;
                    }
                }
                reservation.setAnnonce(annonce);
            }

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
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        for (int i = 0; i < rowCount; i++) {
            Logement logement = new Logement();
            List<TypeLogement> types = List.of(TypeLogement.values());
            int randomIndex = random.nextInt(TypeLogement.values().length);
            logement.setAdresse(UUID.randomUUID().toString().substring(0, 8));
            logement.setImage("assets/images/house/" + random.nextInt(1, 40) + ".jpg");
            logement.setVille(villes.get(random.nextInt(villes.size())));
            logement.setCodePostal(this.getRandomInt());
            Utilisateur utilisateur = utilisateurs.get(random.nextInt(utilisateurs.size()));
            logement.setProprietaire(utilisateur);
            logement.setTypeLogement(types.get(randomIndex));
            utilisateur.getLogements().add(logementRepository.save(logement));
            utilisateurRepository.save(utilisateur);
        }
    }

    private void generateEvaluations(int rowCount) {
        List<Annonce> annonces = annonceRepository.findAll();
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
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
