package net.idrok.talababackend.service;

import net.idrok.talababackend.entity.Fakultet;
import net.idrok.talababackend.entity.Yunalish;
import net.idrok.talababackend.repository.FakultetRepository;
import net.idrok.talababackend.repository.YunalishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FakultetService {
    @Autowired
    FakultetRepository fkr;
    public Page<Fakultet> getAll(String key , Long id, Pageable pageable){
        return fkr.findAllByNomContainsIgnoreCaseOrId(key,id,pageable);
    }
    public Fakultet getById(Long id){
        return fkr.findById(id).get();
    }
    public Fakultet create(Fakultet fakultet){
        if(fakultet.getId() == null){
            return fkr.save(fakultet);
        }
        throw new RuntimeException("Id Null bo'lishi shart");
    }
    public Fakultet update(Fakultet fakultet){
        if(fakultet.getId() != null){
            return fkr.save(fakultet);
        }
        throw new RuntimeException("Id  bo'lishi shart");
    }
    public void delete(Fakultet fakultet){
        fkr.delete(fakultet);
    }
    public void deleteById(Long id){
        fkr.deleteById(id);
    }
}
