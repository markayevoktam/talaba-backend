package net.idrok.talababackend.service;

import net.idrok.talababackend.entity.Yutuq;
import net.idrok.talababackend.repository.YutuqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class YutuqService {
    @Autowired
    YutuqRepository ytqr;
    public Page<Yutuq> getAll(String key,Long id, Pageable pageable){
        return ytqr.findAllByNomContainsIgnoreCaseOrId(key,id,pageable);
    }
    public Yutuq getById(Long id){
        return ytqr.findById(id).get();
    }
    public Yutuq create(Yutuq yutuq){
        if(yutuq.getId() == null){
            return ytqr.save(yutuq);
        }
        throw new RuntimeException("Id Null bo'lishi shart");
    }
    public Yutuq update(Yutuq yutuq){
        if(yutuq.getId() != null){
            return ytqr.save(yutuq);
        }
        throw new RuntimeException("Id  bo'lishi shart");
    }
    public void delete(Yutuq yutuq){
        ytqr.delete(yutuq);
    }
    public void deleteById(Long id){
        ytqr.deleteById(id);
    }
}
