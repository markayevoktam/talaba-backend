package net.idrok.talababackend.controller;

import net.idrok.talababackend.entity.Loyiha;
import net.idrok.talababackend.entity.Student;
import net.idrok.talababackend.service.LoyihaService;
import net.idrok.talababackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(maxAge = 3600)
public class StudentController {
    @Autowired
    StudentService sts;

    @GetMapping()
    public ResponseEntity<Page<Student>> getAll(@RequestParam(name = "key",required = false) String key , Long id, Pageable pageable){
        if(key==null) key="";
        return ResponseEntity.ok(sts.getAll(key ,id,pageable));
    }


    @PostMapping()
    public ResponseEntity<Student> create(@RequestBody Student student){
        return ResponseEntity.ok(sts.create(student));
    }

    @PutMapping()
    public ResponseEntity<Student> update(@RequestBody Student student){
        return ResponseEntity.ok(sts.update(student));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        sts.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
