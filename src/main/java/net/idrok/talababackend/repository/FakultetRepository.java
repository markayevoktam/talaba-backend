package net.idrok.talababackend.repository;

import net.idrok.talababackend.entity.Fakultet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FakultetRepository extends JpaRepository<Fakultet , Long> {
    Page<Fakultet> findAllByNomContainsIgnoreCaseOrId(String key , Long id , Pageable pageable);
}
