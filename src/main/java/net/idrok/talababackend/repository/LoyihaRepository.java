package net.idrok.talababackend.repository;

import net.idrok.talababackend.entity.Loyiha;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoyihaRepository extends JpaRepository<Loyiha,Long> {
    Page<Loyiha> findAllByNomContainsIgnoreCaseOrId(String key, Long id, Pageable pageable);
}
