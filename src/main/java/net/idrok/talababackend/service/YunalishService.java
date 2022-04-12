package net.idrok.talababackend.service;

import net.idrok.talababackend.entity.Loyiha;
import net.idrok.talababackend.entity.Yunalish;
import net.idrok.talababackend.repository.LoyihaRepository;
import net.idrok.talababackend.repository.YunalishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class YunalishService {
    @Autowired
    YunalishRepository lsr;
    public Page<Yunalish> getAll(String key , Long id, Pageable pageable){
        return lsr.findAllByNomContainsOrIdIgnoreCase(key,id,pageable);
    }
    public Yunalish getById(Long id){
        return lsr.findById(id).get();
    }
    public Yunalish create(Yunalish yunalish){
        if(yunalish.getId() == null){
            return lsr.save(yunalish);
        }
        throw new RuntimeException("Id Null bo'lishi shart");
    }
    public Yunalish update(Yunalish yunalish){
        if(yunalish.getId() != null){
            return lsr.save(yunalish);
        }
        throw new RuntimeException("Id  bo'lishi shart");
    }
    public void delete(Yunalish yunalish){
        lsr.delete(yunalish);
    }
    public void deleteById(Long id){
        lsr.deleteById(id);
    }
}
