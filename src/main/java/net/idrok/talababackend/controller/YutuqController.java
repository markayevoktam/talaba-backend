package net.idrok.talababackend.controller;

import net.idrok.talababackend.entity.Yutuq;
import net.idrok.talababackend.service.YutuqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/yutuq")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)

public class YutuqController {
    @Autowired
    YutuqService yts;
    @GetMapping()
    public ResponseEntity<Page<Yutuq>> getAll(@RequestParam(name = "key",required = false) String key ,Long id, Pageable pageable){
        if(key==null) key="";
        return ResponseEntity.ok(yts.getAll(key ,id,pageable));
    }


    @PostMapping()
    public ResponseEntity<Yutuq> create(@RequestBody Yutuq yutuq){
        return ResponseEntity.ok(yts.create(yutuq));
    }
    @PutMapping()
    public ResponseEntity<Yutuq> update(@RequestBody Yutuq yutuq){
        return ResponseEntity.ok(yts.update(yutuq));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        yts.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
