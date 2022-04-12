package net.idrok.talababackend.service;

import net.idrok.talababackend.entity.Loyiha;
import net.idrok.talababackend.entity.Xarakter;
import net.idrok.talababackend.repository.LoyihaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LoyihaService {
    @Autowired
    LoyihaRepository lyr;
    public Page<Loyiha> getAll(String key , Long id, Pageable pageable){
        return lyr.findAllByNomContainsIgnoreCaseOrId(key,id,pageable);
    }
    public Loyiha getById(Long id){
        return lyr.findById(id).get();
    }
    public Loyiha create(Loyiha loyiha){
        if(loyiha.getId() == null){
            return lyr.save(loyiha);
        }
        throw new RuntimeException("Id Null bo'lishi shart");
    }
    public Loyiha update(Loyiha loyiha){
        if(loyiha.getId() != null){
            return lyr.save(loyiha);
        }
        throw new RuntimeException("Id  bo'lishi shart");
    }
    public void delete(Loyiha loyiha){
        lyr.delete(loyiha);
    }
    public void deleteById(Long id){
        lyr.deleteById(id);
    }
}
