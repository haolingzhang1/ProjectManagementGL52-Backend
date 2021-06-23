package fr.utbm.gl52.controller;

import com.alibaba.fastjson.JSONObject;
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
import org.springframework.http.HttpHeaders;
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
            return BaseResultUtil.resFailed("Empty files not accepted",null);
        }

        // Generate a new file name based on the timestamp
        String fileName = String.valueOf(System.currentTimeMillis()) + "_" + file.getOriginalFilename();
        byte[] b = file.getBytes();
        DocumentEntity document = new DocumentEntity(fileName, b, projectId);

        String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/images/download/"+fileName;
        documentRepository.save(document);
        return BaseResultUtil.resSuccess("successfully upload the file",path);
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@RequestParam("documentId") Long documentId) {
        DocumentEntity document = documentService.getDocument(documentId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + document.getDocumentTitle())
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(document.getDocumentContent());
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public ResultEntity removeDocument(@RequestBody String documentParam) {
        try {
            JSONObject jsonParams = JSONObject.parseObject(documentParam);
            Long documentId = jsonParams.getLong("documentId");

            documentRepository.deleteById(documentId);
            return BaseResultUtil.resSuccess("Successfully deleted the document.", documentId);
        } catch (Exception e) {
            return BaseResultUtil.resFailed("failed to delete the document!", e.getMessage());
        }
    }

}
