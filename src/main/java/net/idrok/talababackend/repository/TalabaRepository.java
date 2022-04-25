package net.idrok.talababackend.repository;

import net.idrok.talababackend.entity.Talaba;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface
TalabaRepository extends JpaRepository<Talaba, Long> {


    Page<Talaba> findAllByFamilyaContainsIgnoreCaseOrIsmContainsIgnoreCaseOrSharifContainsIgnoreCaseOrHududContainsIgnoreCaseOrId(String key1,String key2,String key3,String key4, Long id, Pageable pageable);

    @Query("FROM Talaba t WHERE upper(t.ism) like concat('%',:key,'%') OR upper(t.familya) like concat('%',:key,'%') OR upper(t.sharif) like concat('%',:key,'%')  OR  upper(t.xarakter.nom) like concat('%',:key,'%') OR  upper(t.hudud) like concat('%',:key,'%')   ")
    Page<Talaba> findByOnlyKey(@Param("key") String key, Pageable pageable);

    @Query("FROM Talaba t WHERE ( upper(t.ism) like concat('%',:key,'%') OR upper(t.familya) like concat('%',:key,'%') OR upper(t.sharif) like concat('%',:key,'%')  OR  upper(t.xarakter.nom) like concat('%',:key,'%') OR  upper(t.hudud) like concat('%',:key,'%')  ) AND t.guruh.yunalish.fakultet.id = :fakultetId ")
    Page<Talaba> findByFakultetAndKey(@Param("key") String key, @Param("fakultetId") Long fakultetId, Pageable pageable);


    @Query("FROM Talaba t WHERE ( upper(t.ism) like concat('%',:key,'%') OR upper(t.familya) like concat('%',:key,'%') OR upper(t.sharif) like concat('%',:key,'%')  OR  upper(t.xarakter.nom) like concat('%',:key,'%') OR  upper(t.hudud) like concat('%',:key,'%')  ) AND t.guruh.yunalish.fakultet.id = :yunalishId ")
    Page<Talaba> findByYunalishAndKey(@Param("key") String key, @Param("yunalishId") Long yunalishId, Pageable pageable);

    @Query("FROM Talaba t WHERE ( upper(t.ism) like concat('%',:key,'%') OR upper(t.familya) like concat('%',:key,'%') OR upper(t.sharif) like concat('%',:key,'%')  OR  upper(t.xarakter.nom) like concat('%',:key,'%')  OR  upper(t.hudud) like concat('%',:key,'%')  ) AND t.guruh.yunalish.fakultet.id = :guruhId ")
    Page<Talaba> findByGuruhAndKey(@Param("key") String key, @Param("guruhId") Long guruhId, Pageable pageable);


}
