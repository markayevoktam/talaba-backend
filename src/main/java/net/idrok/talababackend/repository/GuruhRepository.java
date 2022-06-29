package net.idrok.talababackend.repository;

import net.idrok.talababackend.entity.Guruh;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface GuruhRepository  extends JpaRepository<Guruh ,Long> {

    Page<Guruh> findAllByNomContainsIgnoreCaseOrId(String key, Long id , Pageable pageable);
}
