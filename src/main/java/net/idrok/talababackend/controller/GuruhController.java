package net.idrok.talababackend.controller;

import net.idrok.talababackend.entity.Guruh;
import net.idrok.talababackend.entity.Yutuq;
import net.idrok.talababackend.service.GuruhService;
import net.idrok.talababackend.service.YutuqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/guruh")
@CrossOrigin(maxAge = 3600)
public class GuruhController {
    @Autowired
    GuruhService grs;
    @GetMapping()
    public ResponseEntity<Page<Guruh>> getAll(@RequestParam(name = "key",required = false) String key , Long id, Pageable pageable){
        if(key==null) key="";
        return ResponseEntity.ok(grs.getAll(key ,id,pageable));
    }


    @PostMapping()
    public ResponseEntity<Guruh> create(@RequestBody Guruh guruh){
        return ResponseEntity.ok(grs.create(guruh));
    }
    @PutMapping()
    public ResponseEntity<Guruh> update(@RequestBody Guruh guruh){
        return ResponseEntity.ok(grs.update(guruh));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        grs.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
