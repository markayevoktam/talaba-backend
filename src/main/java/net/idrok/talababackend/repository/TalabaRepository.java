package net.idrok.talababackend.repository;

import net.idrok.talababackend.entity.Talaba;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface
TalabaRepository extends JpaRepository<Talaba, Long> {


    Page<Talaba> findAllByFamilyaContainsIgnoreCaseOrIsmContainsIgnoreCaseOrSharifContainsIgnoreCaseOrHududContainsIgnoreCaseOrId(String key1,String key2,String key3,String key4, Long id, Pageable pageable);
}
