package net.idrok.talababackend.repository;

import net.idrok.talababackend.entity.Guruh;
import net.idrok.talababackend.entity.Talaba;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PageableRepository  extends JpaRepository<Guruh,Long> {
     default List<Talaba> findAll(String key) {
        return null;
    }

}
