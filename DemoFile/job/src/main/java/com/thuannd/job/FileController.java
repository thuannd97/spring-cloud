package com.thuannd.job;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class FileController {

    final String UPLOAD_DIR = "/home/hopeeee/working/spring-cloud/DemoFile/job/src/main/resources/";

    static String fileToImport;

    @PostMapping("/file/single-file")
    public void uploadSingleFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        if(!multipartFile.isEmpty()){
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get(UPLOAD_DIR + multipartFile.getOriginalFilename());
            fileToImport = multipartFile.getOriginalFilename();
            Files.write(path, bytes);
            System.out.println("uploaded success!!!");
        }
    }

    @PostMapping("/file/multiple-file")
    public void uploadMultipleFile(@RequestParam("files") MultipartFile[] files) throws IOException {
        for(int i = 0; i < files.length; i++){
            if(!files[i].isEmpty()){
                byte[] bytes = files[i].getBytes();
                Path path = Paths.get(UPLOAD_DIR + files[i].getOriginalFilename());
                Files.write(path, bytes);
                System.out.println("uploaded success!!!");
            }
        }
    }

    @PostMapping("/file/sh-file")
    public void uploadShFile(@RequestParam("shFile") MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
            Files.write(path, bytes);
            try{
                Runtime.getRuntime().exec(new String[]{"bash", path.toString()});
            }catch(Exception ex){
                System.out.println("cannot exec command!!!");
                ex.printStackTrace();
            }
            System.out.println("end exec--------------");
        }
    }

}