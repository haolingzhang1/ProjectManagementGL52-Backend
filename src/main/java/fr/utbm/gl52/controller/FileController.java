package fr.utbm.gl52.controller;

import fr.utbm.gl52.entity.DocumentEntity;
import fr.utbm.gl52.entity.ResultEntity;
import fr.utbm.gl52.repository.DocumentRepository;
import fr.utbm.gl52.repository.ProjectRepository;
import fr.utbm.gl52.services.DocumentService;
import fr.utbm.gl52.utils.BaseResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/file")
public class FileController {


    @Autowired
    DocumentRepository documentRepository;


    @Autowired
    DocumentService documentService;

    @RequestMapping("/upload")
    public ResultEntity upload(@RequestParam("file") MultipartFile file, HttpServletRequest request,
                         @RequestParam("projectId") Long projectId) throws IOException {
        if(file.isEmpty()){
            return null;
        }

        //根据时间戳产生新的文件名
        String fileName = System.currentTimeMillis()+file.getOriginalFilename();

        byte[] b=file.getBytes();

        DocumentEntity document=new DocumentEntity(fileName,b,projectId);

        String path=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/images/download/"+fileName;
        documentRepository.save(document);
        return BaseResultUtil.resSuccess("successfully upload the file",path);
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@RequestParam("projectId")Long projectId) {
        List<DocumentEntity> document = documentService.getDocumentByProject(projectId);
        //return ResponseEntity.ok().contentType(MediaType.MULTIPART_FORM_DATA).body(document.getDocumentContent());
        return null;
    }

}
