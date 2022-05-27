package net.idrok.talababackend.controller;

import net.idrok.talababackend.entity.Talaba;
import net.idrok.talababackend.service.TalabaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/talaba")
@CrossOrigin(maxAge = 3600)
public class TalabaController {
    @Autowired
    TalabaService tls;
    @GetMapping()
    public ResponseEntity<Page<Talaba>> getAll(@RequestParam(name = "key",required = false) String key, Pageable pageable){
        if(key==null) key="";
        return ResponseEntity.ok(tls.getAll(key, pageable));
    }

    @PostMapping()
    public ResponseEntity<Talaba> create(@RequestBody Talaba talaba){
        return ResponseEntity.ok(tls.create(talaba));
    }
    @PutMapping()
    public ResponseEntity<Talaba> update(@RequestBody Talaba talaba){
        return ResponseEntity.ok(tls.update(talaba));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        tls.deleteById(id);
        return ResponseEntity.noContent().build();
    }
// talaba add talented
    @GetMapping("/talented")
    public ResponseEntity<Page<Talaba>> getAllTalanted(Pageable pageable) {
        return  ResponseEntity.ok(tls.getAllByTalented(true, pageable));
    }

}
