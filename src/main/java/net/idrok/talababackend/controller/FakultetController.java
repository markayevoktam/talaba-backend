package net.idrok.talababackend.controller;

import net.idrok.talababackend.entity.Fakultet;
import net.idrok.talababackend.entity.Yutuq;
import net.idrok.talababackend.service.FakultetService;
import net.idrok.talababackend.service.YutuqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fakultet")
@CrossOrigin(maxAge = 3600)
public class FakultetController {
    @Autowired
    FakultetService fks;
    @GetMapping()
    public ResponseEntity<Page<Fakultet>> getAll(@RequestParam(name = "key",required = false) String key , Long id, Pageable pageable){
        if(key==null) key="";
        return ResponseEntity.ok(fks.getAll(key ,id,pageable));
    }


    @PostMapping()
    public ResponseEntity<Fakultet> create(@RequestBody Fakultet fakultet){
        return ResponseEntity.ok(fks.create(fakultet));
    }
    @PutMapping()
    public ResponseEntity<Fakultet> update(@RequestBody Fakultet fakultet){
        return ResponseEntity.ok(fks.update(fakultet));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        fks.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
