package ma.fpl.etudiant.Service;

import ma.fpl.etudiant.Dto.FiliereDTO;
import ma.fpl.etudiant.Entity.Etudiant;
import ma.fpl.etudiant.Repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public EtudiantService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    public Etudiant getEtudiantById(int id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    public Etudiant saveEtudiant(Etudiant etudiant) {
        FiliereDTO filiere = getFiliereById(etudiant.getFiliere());
        if (filiere == null) {
            throw new IllegalArgumentException("Filiere with ID " + etudiant.getFiliere() + " does not exist.");
        }

        return etudiantRepository.save(etudiant);
    }

    public void deleteEtudiant(int id) {
        etudiantRepository.deleteById(id);
    }

    public FiliereDTO getFiliereById(int filiereId) {
        String filiereServiceUrl = "http://localhost:8080/filieres/" + filiereId;
        return restTemplate.getForObject(filiereServiceUrl, FiliereDTO.class);
    }
}
