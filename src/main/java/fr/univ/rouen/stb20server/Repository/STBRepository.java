package fr.univ.rouen.stb20server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import fr.univ.rouen.stb20server.model.STB;

/**
 * Repository pour STB
 * @author Yeser GOUMIDI
 */
// JpaRepository  CrudRepository
public interface STBRepository extends JpaRepository<STB, Long> {
    List<STB> findAll();
}



