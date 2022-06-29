package net.idrok.talababackend.controller;

import net.idrok.talababackend.entity.Guruh;
import net.idrok.talababackend.entity.Yutuq;
import net.idrok.talababackend.service.GuruhService;
import net.idrok.talababackend.service.YutuqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/api/guruh")
@CrossOrigin(maxAge = 3600)
public class GuruhController {
    @Autowired
    GuruhService grs;
    @GetMapping()
    public ResponseEntity<Page<Guruh>> getAll(@RequestParam(name = "key",required = false) String key ,
                                              Long id, @PageableDefault(size = 10000) Pageable pageable){
        if(key==null) key="";
        return ResponseEntity.ok(grs.getAll(key ,id,pageable));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Guruh>> getAllList(Pageable pageable) throws Exception {
        List<Guruh> maydon = grs.getAllList(pageable).getContent();
        return ResponseEntity.ok(maydon);
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
