package net.idrok.talababackend.service;

import net.idrok.talababackend.entity.Xarakter;
import net.idrok.talababackend.entity.Yutuq;
import net.idrok.talababackend.repository.XarakterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class XarakterService {
    @Autowired
    XarakterRepository xrt;
    public Page<Xarakter> getAll(String key , Long id, Pageable pageable){
        return xrt.findAllByNomContainsIgnoreCaseOrId(key,id,pageable);
    }
    public Xarakter getById(Long id){
        return xrt.findById(id).get();
    }
    public Xarakter create(Xarakter xarakter){
        if(xarakter.getId() == null){
            return xrt.save(xarakter);
        }
        throw new RuntimeException("Id Null bo'lishi shart");
    }
    public Xarakter update(Xarakter xarakter){
        if(xarakter.getId() != null){
            return xrt.save(xarakter);
        }
        throw new RuntimeException("Id  bo'lishi shart");
    }
    public void delete(Xarakter xarakter){
        xrt.delete(xarakter);
    }
    public void deleteById(Long id){
        xrt.deleteById(id);
    }
}
