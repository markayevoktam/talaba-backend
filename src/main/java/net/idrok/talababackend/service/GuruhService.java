package net.idrok.talababackend.service;

import lombok.RequiredArgsConstructor;
import net.idrok.talababackend.entity.Guruh;
import net.idrok.talababackend.entity.Yunalish;
import net.idrok.talababackend.repository.GuruhRepository;
import net.idrok.talababackend.repository.YunalishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuruhService {
   @Autowired
   GuruhRepository grr;
    public Page<Guruh> getAll(String key , Long id, Pageable pageable){
        return grr.findAllByNomContainsIgnoreCaseOrId(key,id,pageable);
    }




    public Guruh getById(Long id){
        return grr.findById(id).get();
    }
    public Guruh create(Guruh guruh){
        if(guruh.getId() == null){
            return grr.save(guruh);
        }
        throw new RuntimeException("Id Null bo'lishi shart");
    }
    public Guruh update(Guruh guruh){
        if(guruh.getId() != null){
            return grr.save(guruh);
        }
        throw new RuntimeException("Id  bo'lishi shart");
    }
    public void delete(Guruh guruh){
        grr.delete(guruh);
    }
    public void deleteById(Long id){
        grr.deleteById(id);
    }


    public Page<Guruh> getAllList(Pageable pageable){
        return grr.findAll(pageable);
    }
}
