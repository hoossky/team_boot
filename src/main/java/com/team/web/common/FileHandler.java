package com.team.web.common;
import java.io.File;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Data;
@Component @Data class Image{private String imageCode, imageName, imageExtension, imageOwner;}
@Component @Data class GenericFile<T> {

    private File file;

    public File makeFile(T t1, String t2) {
        HashMap<String, T> o = new HashMap<>();
        o.put("T", t1);

        if(o.get("T") instanceof String) {
            file = new File((String)o.get("T"),t2);
        }else  if(o.get("T") instanceof File){
            System.out.println(">>> "+(File)o.get("T"));
            file = new File((File)o.get("T"),t2);
        }
        return file;
    }
}
@Component @Data public class FileHandler extends Proxy{
    private static final Logger logger = LoggerFactory.getLogger(FileHandler.class);
    private Image image;
    public void uploadImageFile(MultipartFile mfile, String uploadFolder) {
        File uploadPath = makeDir(uploadFolder, getFolder());
        List<String> names= new ArrayList<String>();
        if(uploadPath.exists() == false) {
            uploadPath.mkdirs();
        }
        final String folderName = getFolder();
        String fname = mfile.getOriginalFilename();
        String extension = fname.substring(fname.lastIndexOf(".")+1);
        fname = fname.substring(fname.lastIndexOf("\\")+1, fname.lastIndexOf("."));
        File savedFile = makeFile(uploadPath, fname+"-"+UUID.randomUUID().toString()+"."+extension);
        names.add(fname+"-"+UUID.randomUUID().toString());
        try {
            mfile.transferTo(savedFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void uploadByFileItemFactory(String customerID) {
        // 파일아이템 이용한 업로드....미완성
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(1024 * 1024 * 40); // 40 MB
        upload.setSizeMax(1024 * 1024 * 50); // 50 MB
        List<FileItem> items = null;
        try {
            File file = null;
            // items = upload.parseRequest((RequestContext) new ServletRequestContext(request));
            Iterator<FileItem> it = items.iterator();
            while(it.hasNext()) {
                FileItem item = it.next();
                if(!item.isFormField()) {
                    String fileName = item.getName();
                    file = new File(""+fileName);
                    item.write(file);
                    image.setImageName(fileName.substring(0,fileName.indexOf(".")));
                    image.setImageExtension(fileName.substring(fileName.indexOf(".")+1));
                    image.setImageOwner(customerID);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<String> uploadImageFiles(MultipartFile[] uploadFiles, String uploadFolder) {
        // 여러개의 파일 일괄 업로드....미완성
        logger.info("uploadFiles.length = "+uploadFiles.length);
        String folderName = uploadFolder;
        File uploadPath = makeDir(uploadFolder, getFolder());
        List<String> names= new ArrayList<String>();
        if(uploadPath.exists() == false) {
            uploadPath.mkdirs();
        }

        for(MultipartFile m : uploadFiles) {
            String fname = m.getOriginalFilename();
            String extension = fname.substring(fname.lastIndexOf(".")+1);
            fname = fname.substring(fname.lastIndexOf("\\")+1, fname.lastIndexOf("."));
            File savedFile = makeFile(uploadPath, fname+"-"+UUID.randomUUID().toString()+"."+extension);
            names.add(fname+"-"+UUID.randomUUID().toString());
            try {
                m.transferTo(savedFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return names;
    }
    public String getFolder() {
        return "izzifileFolder";
    }
    public File makeDir(String t, String u) {
        BiFunction<String,String, File> f = File::new;
        return f.apply(t, u);
    }
    public File makeFile(File t, String u) {
        BiFunction<File,String, File> f = File::new;
        return f.apply(t, u);
    }
}
