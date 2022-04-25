package net.idrok.talababackend.service;

import net.idrok.talababackend.entity.Talaba;
import net.idrok.talababackend.repository.TalabaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TalabaService implements Talabatimp {


    @Autowired
    TalabaRepository tsr;

    public Page<Talaba> getAll(Pageable pageable) {
        return tsr.findAll(pageable);
    }

    public Talaba getById(Long id) {
        return tsr.findById(id).get();
    }

    public Talaba create(Talaba talaba) {
        if (talaba.getId() == null) {
            return tsr.save(talaba);
        }
        throw new RuntimeException("Id Null bo'lishi shart");
    }

    public Talaba update(Talaba talaba) {
        if (talaba.getId() != null) {
            return tsr.save(talaba);
        }
        throw new RuntimeException("Id  bo'lishi shart");
    }

    public void delete(Talaba talaba) {
        tsr.delete(talaba);

    }

    public void deleteById(Long id) {
        tsr.deleteById(id);
    }


    @Override
    public Page<Talaba> findAllByFamilyaContainsIgnoreCaseOrIsmContainsIgnoreCaseOrSharifContainsIgnoreCaseOrHududContainsIgnoreCaseOrId(String key1, Pageable pageable) {
        try {
            Long n = Long.parseLong(key1);
            int i = Integer.parseInt(key1);
            return tsr.findAllByFamilyaContainsIgnoreCaseOrIsmContainsIgnoreCaseOrSharifContainsIgnoreCaseOrHududContainsIgnoreCaseOrId(key1, key1, key1, key1, n, pageable);
        } catch (Exception b) {
            return tsr.findAllByFamilyaContainsIgnoreCaseOrIsmContainsIgnoreCaseOrSharifContainsIgnoreCaseOrHududContainsIgnoreCaseOrId(key1, key1, key1, key1, (long) -1, pageable);


        }
    }

    public Page<Talaba> getAllByFilter(String key, Long fakultetId, Long yunalishId, Long guruhId, Pageable pageable) {
        if (guruhId != null) {
            // guruh va key
            return tsr.findByGuruhAndKey(key,guruhId,pageable);
        } else if (yunalishId != null) {
            // yunalish
            return  tsr.findByYunalishAndKey(key,yunalishId,pageable);
        } else if (fakultetId != null) {
            // fakultet bo'yicha
            return tsr.findByFakultetAndKey(key, fakultetId, pageable);
        } else {
            return tsr.findByOnlyKey(key.toUpperCase(), pageable);
        }
    }
}
