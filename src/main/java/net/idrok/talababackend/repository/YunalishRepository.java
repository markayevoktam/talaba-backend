package net.idrok.talababackend.repository;

import net.idrok.talababackend.entity.Talaba;
import net.idrok.talababackend.entity.Yunalish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YunalishRepository extends JpaRepository<Yunalish ,Long> {
    Page<Yunalish> findAllByNomContainsOrIdIgnoreCase(String key,Long id, Pageable pageable);

}
