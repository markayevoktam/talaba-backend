package net.idrok.talababackend.service;

import net.idrok.talababackend.entity.Talaba;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Talabatimp extends GeneralService<Talaba ,Number> {
    Page<Talaba> findAllByFamilyaContainsIgnoreCaseOrIsmContainsIgnoreCaseOrSharifContainsIgnoreCaseOrHududContainsIgnoreCaseOrId(String key1,  Pageable pageable);

}
