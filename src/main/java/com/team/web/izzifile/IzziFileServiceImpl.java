package com.team.web.izzifile;
/*

import com.team.web.StorageConfigure;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

import com.team.web.common.GenericService;
        import com.team.web.common.StorageException;
        import com.team.web.common.StorageFileNotFoundException;
        import org.springframework.beans.factory.annotation.Autowired;


interface IIzziFileservice extends GenericService<IzziFile>{
    void save(IzziFile file);
}

@Service
public class IzziFileServiceImpl  implements IIzziFileservice{
    private final Path rootLocation;
    private final IzziFileRepository izziFileRepository;

    public IzziFileServiceImpl(StorageConfigure properties, IzziFileRepository izziFileRepository) {
        this.rootLocation = Paths.get(properties.getLocation());
        this.izziFileRepository = izziFileRepository;
    }




    public void store(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + file.getOriginalFilename());
            }
            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            throw new StorageException("Failed to store file " + file.getOriginalFilename(), e);
        }
    }

    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(path -> this.rootLocation.relativize(path));
        } catch (Exception e) {
            throw new StorageException("Failed to read stored files", e);
        }

    }

    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageFileNotFoundException("Could not read file: " + filename);

            }
        } catch (Exception e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    public void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (Exception e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }

    @Override
    public Optional<IzziFile> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Iterable<IzziFile> findAll() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public boolean exists(String id) {
        return false;
    }


    @Override
    public void save(IzziFile file) {
        izziFileRepository.save(file);
    }
}
*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.team.web.izzifile.IzziFileDB;
import com.team.web.izzifile.IzziFileRepository;
import java.io.IOException;
import java.util.stream.Stream;

@Service
public class IzziFileServiceImpl {

    @Autowired
    private IzziFileRepository fileRepository;

    public IzziFileDB store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        IzziFileDB FileDB = new IzziFileDB(fileName, file.getContentType(), file.getBytes());

        return fileRepository.save(FileDB);
    }

    public IzziFileDB getFile(String id) {
        return fileRepository.findById(id).get();
    }

    public Stream<IzziFileDB> getAllFiles() {
        return fileRepository.findAll().stream();
    }
}