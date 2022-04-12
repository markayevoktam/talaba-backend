package net.idrok.talababackend.controller;

import net.idrok.talababackend.entity.Xarakter;
import net.idrok.talababackend.entity.Yutuq;
import net.idrok.talababackend.service.XarakterService;
import net.idrok.talababackend.service.YutuqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/xarakter")
@CrossOrigin(maxAge = 3600)
public class XarakterController {
    @Autowired
    XarakterService xrs;
    @GetMapping()
    public ResponseEntity<Page<Xarakter>> getAll(@RequestParam(name = "key",required = false) String key , Long id, Pageable pageable){
        if(key==null) key="";
        return ResponseEntity.ok(xrs.getAll(key ,id,pageable));
    }


    @PostMapping()
    public ResponseEntity<Xarakter> create(@RequestBody Xarakter xarakter){
        return ResponseEntity.ok(xrs.create(xarakter));
    }
    @PutMapping()
    public ResponseEntity<Xarakter> update(@RequestBody Xarakter xarakter){
        return ResponseEntity.ok(xrs.update(xarakter));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        xrs.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
