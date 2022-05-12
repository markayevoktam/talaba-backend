package net.idrok.talababackend.repository;

import net.idrok.talababackend.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query("FROM Student t WHERE upper(t.ism) like concat('%',:key,'%') OR upper(t.familya) like concat('%',:key,'%') OR upper(t.sharif) like concat('%',:key,'%')   OR  upper(t.hudud) like concat('%',:key,'%')   ")
    Page<Student> findByOnlyKey(@Param("key") String key, Pageable pageable);

}
