package net.idrok.talababackend.controller;

import net.idrok.talababackend.entity.Guruh;
import net.idrok.talababackend.repository.PageableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pageguruh")
public class PageGuruhController {
    @Autowired
    PageableRepository pageableRepository;
//    @GetMapping()
//    public ResponseEntity<List<Guruh>> getAll(@RequestParam(name = "key",required = false) String key , Long id){
//        if(key==null) key="";
//        return ResponseEntity.ok(pageableRepository.findAll());
//    }

}
