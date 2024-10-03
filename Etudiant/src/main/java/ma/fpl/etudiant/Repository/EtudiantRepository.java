package ma.fpl.etudiant.Repository;

import ma.fpl.etudiant.Entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {}
