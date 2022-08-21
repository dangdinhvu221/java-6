package poly.edu.com.demo.rest.comtroller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import poly.edu.com.demo.service.UploadService;

import java.io.File;

@CrossOrigin("*")
@RestController
public class UploadRestController {

    @Autowired
    UploadService uploadService;

    @PostMapping("/rest/upload/{image}")
    public JsonNode upload(@PathVariable("file")MultipartFile file){

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("name", uploadService.save(file));
//        node.put("size", saveFile.length());
        return node;
    }

}
