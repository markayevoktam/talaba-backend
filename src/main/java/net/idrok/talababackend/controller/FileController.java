package net.idrok.talababackend.controller;

import net.idrok.talababackend.entity.Fayl;
import net.idrok.talababackend.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/file")
public class FileController {
    private  String ROOT_DIRECTORY= "files";
    private Logger logger = LoggerFactory.getLogger(FileController.class.getName());

    private final FileService fileService;
    @Value("${system.root-directory}")
    private void setDirectory(String url){
        this.ROOT_DIRECTORY = url;
    }

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping()
    public ResponseEntity<List<Fayl>> getAll(@RequestParam(name = "key",required = false) String key , HttpServletRequest req, HttpServletResponse res){
        if(key==null) key="";
        return ResponseEntity.ok(fileService.getAll(key));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(fileService.getById(id));
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<?> downloadFile(@PathVariable Long id) {
        Fayl f = fileService.getById(id);

        File file = new File(ROOT_DIRECTORY + "/" + f.getId() + "_" + f.getNom());
        if (file.exists()) {

            try {
                InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
                HttpHeaders headers = new HttpHeaders();
                headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
                headers.add("Pragma", "no-cache");
                headers.add("Expires", "0");

                MediaType mediaType = MediaType.APPLICATION_OCTET_STREAM;
                if(f.getTur() != null){
                    mediaType = MediaType.parseMediaType(f.getTur());
                }

                return ResponseEntity.ok()
                        .headers(headers)
                        .contentLength(file.length())
                        .contentType(mediaType)
                        .body(resource);
            } catch (Exception ex) {
                logger.error(ex.getMessage());
            }
        }


        return ResponseEntity.notFound().build();
    }

    @PostMapping("/upload")
    public ResponseEntity<Fayl> create(@RequestParam("file")MultipartFile file){
        Fayl f = new Fayl();
        f.setNom(file.getOriginalFilename());
        f.setTur(file.getContentType());
        f = fileService.create(f);
        try {
            File saqlashFayl = new File(ROOT_DIRECTORY);
            if (!saqlashFayl.exists()) saqlashFayl.mkdirs();

            saqlashFayl = new File(ROOT_DIRECTORY + "/" + f.getId() + "_" + f.getNom());

            saqlashFayl.createNewFile();

            FileOutputStream fos = new FileOutputStream(saqlashFayl);
            fos.write(file.getBytes());
            fos.close();
            return ResponseEntity.ok(f);

        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        fileService.delete(f);

        return ResponseEntity.badRequest().build();
    }


    @PutMapping()
    public ResponseEntity<Fayl> update(@RequestBody Fayl file){
        return ResponseEntity.ok(fileService.update(file));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        fileService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
