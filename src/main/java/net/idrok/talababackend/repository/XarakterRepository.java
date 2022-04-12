package net.idrok.talababackend.repository;

import net.idrok.talababackend.entity.Xarakter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XarakterRepository extends JpaRepository<Xarakter,Long>
{
   Page<Xarakter> findAllByNomContainsIgnoreCaseOrId(String key, Long id, Pageable pageable);
}
