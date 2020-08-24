package com.team.web.izzifile;
/*
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.function.Consumer;
import com.team.web.common.FileHandler;
 import com.team.web.common.Path;
import org.springframework.web.bind.annotation.*;
 import org.springframework.web.multipart.MultipartFile;
import java.util.function.Consumer;

@AllArgsConstructor
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/izzifile")
public class IzziFileController {
    private static final Logger logger = LoggerFactory.getLogger(IzziFileController.class);
    @Autowired
    FileHandler fileHandler;
    @Autowired IzziFileServiceImpl izziFileServiceImpl;
   @Autowired IzziFile file;
    private final IzziFileRepository izziFileRepository;

    @PostMapping("/imageUpload/{uploadId}")
    public String uploadedImageFiles(@RequestParam("file") MultipartFile mfile, @RequestBody String uploadId) {
        logger.info("이미지 업로드 접속 성공 :: "+ uploadId);
        IzziFile file = new IzziFile();
        file.setUploadId(uploadId);
        String uploadFolder = Path.UPLOAD_PATH.toString();
        fileHandler.uploadImageFile(mfile, uploadFolder);
        Consumer<IzziFile> c = t->izziFileServiceImpl.save(file);
        c.accept(file);
        return "파일 업로드 성공 !!";
    }
}*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/izzifile")
public class IzziFileController {

    @Autowired
    private IzziFileServiceImpl storageService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            storageService.store(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<ResponseFile>> getListFiles() {
        List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(dbFile.getId())
                    .toUriString();

            return new ResponseFile(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        IzziFileDB IzziFile = storageService.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + IzziFile.getName() + "\"")
                .body(IzziFile.getData());
    }
}