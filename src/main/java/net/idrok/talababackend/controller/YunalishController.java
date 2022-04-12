package net.idrok.talababackend.controller;

import net.idrok.talababackend.entity.Yunalish;
import net.idrok.talababackend.entity.Yutuq;
import net.idrok.talababackend.service.YunalishService;
import net.idrok.talababackend.service.YutuqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/yunalish")
@CrossOrigin(maxAge = 3600)
public class YunalishController {
    @Autowired
    YunalishService yls;
    @GetMapping()
    public ResponseEntity<Page<Yunalish>> getAll(@RequestParam(name = "key",required = false) String key , Long id, Pageable pageable){
        if(key==null) key="";
        return ResponseEntity.ok(yls.getAll(key ,id,pageable));
    }


    @PostMapping()
    public ResponseEntity<Yunalish> create(@RequestBody Yunalish yunalish){
        return ResponseEntity.ok(yls.create(yunalish));
    }
    @PutMapping()
    public ResponseEntity<Yunalish> update(@RequestBody Yunalish yunalish){
        return ResponseEntity.ok(yls.update(yunalish));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        yls.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
