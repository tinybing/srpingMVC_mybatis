package com.ww.controller;

import com.ww.common.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

/**
 * Created by wurp on 16/12/22.
 */
@Controller
@RequestMapping("/fileUploadController")
public class FileUploadController {

    private static Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    //通过Spring的autowired注解获取spring默认配置的request
    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "uploadFile")
    public void uploadLogImage(HttpServletRequest request, HttpServletResponse response, String fileName, @RequestParam("file") MultipartFile excelFile) {
        Map resultmap = new HashMap();
        System.out.println(excelFile.isEmpty());
        if (!excelFile.isEmpty()) {
            String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
            try {
                logger.debug(" ----->filePath:  "+filePath);
                logger.debug(" ----->fileName:  "+excelFile.getOriginalFilename());
                byte[] bytes = excelFile.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(filePath+excelFile.getOriginalFilename()));
                stream.write(bytes);
                stream.close();
                resultmap.put("return_code", 1);
                resultmap.put("return_message", "文件上传成功");
                resultmap.put("fileName",filePath+excelFile.getOriginalFilename());
            } catch (Exception e) {
                e.printStackTrace();
                resultmap.put("return_code", 0);
                resultmap.put("return_message", "文件上传失败ssss");
            }

          /*  //删除上传的文件
            File file = new File(filePath+excelFile.getOriginalFilename());
            // 路径为文件且不为空则进行删除
            if (file.isFile() && file.exists()) {
                file.delete();
            }*/

        } else {
            resultmap.put("return_code", 0);
            resultmap.put("return_message", "未上传任何文件");
        }

        ResponseService.WriteResponse(response, resultmap);
    }



}
