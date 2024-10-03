package ma.fpl.filiere.Controller;

import ma.fpl.filiere.Entity.Filiere;
import ma.fpl.filiere.Service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filieres")
public class FiliereController {
    @Autowired
    private FiliereService filiereService;

    @GetMapping
    public List<Filiere> getAllFilieres() {
        return filiereService.getAllFilieres();
    }

    @GetMapping("/{id}")
    public Filiere getFiliereById(@PathVariable int id) {
        return filiereService.getFiliereById(id);
    }

    @PostMapping
    public Filiere createFiliere(@RequestBody Filiere filiere) {
        return filiereService.saveFiliere(filiere);
    }

    @PutMapping("/{id}")
    public Filiere updateFiliere(@PathVariable int id, @RequestBody Filiere filiere) {
        filiere.setIdFiliere(id);
        return filiereService.saveFiliere(filiere);
    }

    @DeleteMapping("/{id}")
    public void deleteFiliere(@PathVariable int id) {
        filiereService.deleteFiliere(id);
    }
}
