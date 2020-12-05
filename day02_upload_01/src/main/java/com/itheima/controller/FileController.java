package com.itheima.controller;

import com.itheima.utils.UploadUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * 包名:com.itheima.controller
 * @author Leevi
 * 日期2020-08-15  08:46
 * 1. 获取客户端传入的文件描述信息
 * 2. 获取客户端上传的文件，存放到file文件夹中
 *    2.1 获取客户端上传的文件   MultipartFile upload
 *    2.2 创建一个file文件夹
 *    2.3 使用输出流将客户端上传的文件，输出到file文件夹中
 */
@RestController
@RequestMapping("/file")
public class FileController {
    @PostMapping("/upload")
    public String upload(String pdesc, MultipartFile upload, HttpServletRequest request){
        System.out.println("文件描述是:" + pdesc);

        //1. 获取存放文件的目录路径
        String realPath = request.getSession().getServletContext().getRealPath("file/"+ UploadUtils.getDir());
        File file = new File(realPath);
        //判断file对应的文件夹是否真实存在于硬盘中
        if (!file.exists()) {
            //不存在，则将其在硬盘中创建出来
            file.mkdirs();
        }

        //2. 将客户端上传的文件，写入到file文件夹中
        //2.1 获取客户端上传的那个文件的文件名
        String filename = upload.getOriginalFilename();
        //将文件名，进行重命名，重命名成唯一的文件名--->UUID
        String uuidName = UploadUtils.getUUIDName(filename);
        try {
            //2.2 将客户端上传的文件写入到文件夹中
            upload.transferTo(new File(file,uuidName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
