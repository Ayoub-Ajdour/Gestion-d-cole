package ma.fpl.filiere.Service;

import ma.fpl.filiere.Entity.Filiere;
import ma.fpl.filiere.Repository.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiliereService {
    @Autowired
    private FiliereRepository filiereRepository;

    public List<Filiere> getAllFilieres() {
        return filiereRepository.findAll();
    }

    public Filiere getFiliereById(int id) {
        return filiereRepository.findById(id).orElse(null);
    }

    public Filiere saveFiliere(Filiere filiere) {
        return filiereRepository.save(filiere);
    }

    public void deleteFiliere(int id) {
        filiereRepository.deleteById(id);
    }
}
