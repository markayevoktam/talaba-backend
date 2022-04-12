package net.idrok.talababackend.repository;

import net.idrok.talababackend.entity.Yutuq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YutuqRepository extends JpaRepository<Yutuq, Long> {
    Page<Yutuq> findAllByNomContainsIgnoreCaseOrId(String key, Long id, Pageable pageable);
}
