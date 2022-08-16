package poly.edu.com.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import poly.edu.com.demo.service.UploadService;

import javax.servlet.ServletContext;
import java.io.File;

@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    ServletContext servletContext;
    @Override
    public File save(MultipartFile file, String folder) {
        File dir = new File(servletContext.getRealPath("resources/assets/" + folder));
        if(!dir.exists()){
            dir.mkdirs();
        }
        String s = System.currentTimeMillis() + file.getOriginalFilename();
        String name = Integer.toHexString(s.hashCode()) + s.substring(s.lastIndexOf("."));
        try {
            File saveFile = new File(dir, name);
            file.transferTo(saveFile);
            System.out.println(saveFile.getAbsolutePath());
            return saveFile;
        }catch (Exception e){
            throw  new RuntimeException();
        }
    }
}
