package net.idrok.talababackend.controller;

import net.idrok.talababackend.entity.Loyiha;
import net.idrok.talababackend.entity.Yutuq;
import net.idrok.talababackend.service.LoyihaService;
import net.idrok.talababackend.service.YutuqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loyiha")
@CrossOrigin(maxAge = 3600)
public class LoyihaController {
    @Autowired
    LoyihaService lys;
    @GetMapping()
    public ResponseEntity<Page<Loyiha>> getAll(@RequestParam(name = "key",required = false) String key , Long id, Pageable pageable){
        if(key==null) key="";
        return ResponseEntity.ok(lys.getAll(key ,id,pageable));
    }


    @PostMapping()
    public ResponseEntity<Loyiha> create(@RequestBody Loyiha loyiha){
        return ResponseEntity.ok(lys.create(loyiha));
    }
    @PutMapping()
    public ResponseEntity<Loyiha> update(@RequestBody Loyiha loyiha){
        return ResponseEntity.ok(lys.update(loyiha));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        lys.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
