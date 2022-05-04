package net.idrok.talababackend.repository;

import net.idrok.talababackend.entity.Fayl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<Fayl, Long> {

}
