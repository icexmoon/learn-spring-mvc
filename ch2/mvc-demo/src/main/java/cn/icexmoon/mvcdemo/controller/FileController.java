package cn.icexmoon.mvcdemo.controller;

import lombok.Cleanup;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 魔芋红茶
 * @version : 1.0
 * @Project : mvc-demo
 * @Package : cn.icexmoon.mvcdemo.controller
 * @ClassName : .java
 * @createTime : 2023/9/21 17:46
 * @Email : icexmoon@qq.com
 * @Website : https://icexmoon.cn
 * @Description :
 */
@Controller
@RequestMapping("/file")
public class FileController {
    private static final String PROJECT_HOME = System.getProperty("user.dir");
    private static final String UPLOAD_DIR = PROJECT_HOME+"/upload";
    static {
        File dir = new File(UPLOAD_DIR);
        if(!dir.exists()){
            dir.mkdir();
        }
    }

    @PostMapping("/upload")
    public String upload(@RequestBody MultipartFile userUploadFile) throws IOException {
        @Cleanup InputStream inputStream = userUploadFile.getInputStream();
        String originalFilename = userUploadFile.getOriginalFilename();
        @Cleanup OutputStream outputStream = new FileOutputStream(UPLOAD_DIR+"/"+originalFilename);
        IOUtils.copy(inputStream, outputStream);
        return "redirect:/file/upload.jsp";
    }
}
