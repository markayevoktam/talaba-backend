package net.idrok.talababackend.controller;

import net.idrok.talababackend.entity.Guruh;
import net.idrok.talababackend.entity.Talaba;
import net.idrok.talababackend.service.GuruhService;
import net.idrok.talababackend.service.TalabaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/public")
public class PublicController {

    @Autowired
    private TalabaService talabaService;

    @GetMapping("talaba")
    public Page<Talaba> getTalaba(@RequestParam(value = "key", required = false, defaultValue = "") String key, Pageable pageable){
        return talabaService.findAllByFamilyaContainsIgnoreCaseOrIsmContainsIgnoreCaseOrSharifContainsIgnoreCaseOrHududContainsIgnoreCaseOrId(key, pageable);
    }
    @GetMapping("talaba/{id}")
    public ResponseEntity<Talaba> getTalabaById(@PathVariable Long id){
        Talaba t =  talabaService.getById(id);
        if(t != null){
            return  ResponseEntity.ok(t);
        }
        return ResponseEntity.notFound().build();
    }


}