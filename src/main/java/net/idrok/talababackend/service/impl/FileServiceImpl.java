package net.idrok.talababackend.service.impl;

import net.idrok.talababackend.entity.Fayl;
import net.idrok.talababackend.repository.FileRepository;
import net.idrok.talababackend.service.FileService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FileServiceImpl implements FileService {



    private  final FileRepository fileRepository;

    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }


    @Override
    public List<Fayl> getAll(String key) {
        return fileRepository.findAll();
    }

    @Override
    public Fayl getById(Long id) {
        return fileRepository.findById(id).orElseThrow(()->new RuntimeException("Not found"));
    }

    @Override
    public Fayl create(Fayl entity) {
        if(entity.getId()==null)
            return fileRepository.save(entity);
        throw new RuntimeException("Id must be null");
    }

    @Override
    public Fayl update(Fayl entity) {
        if(entity.getId()!=null)
            return null;
        throw new RuntimeException("Id must not be null");
    }

    @Override
    public void delete(Fayl entity) {
            fileRepository.delete(entity);
    }

    @Override
    public void deleteById(Long dataId) {
        fileRepository.deleteById(dataId);
    }
}
