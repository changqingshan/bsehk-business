package com.bsehk.business.web.controller;

import com.bsehk.business.biz.feign.FileService;
import com.bsehk.common.response.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by 24398 on 2018/10/24.
 */

@Slf4j
@Controller
public class FileController {
    @Resource
    private FileService fileService;

    @RequestMapping("/file/download")
    @ResponseBody
    public void download(String filePath, HttpServletResponse response) {
        log.info("==========================");
        ResultData<byte[]> resultData = this.fileService.download(filePath);
        if(resultData.isResult()){
            byte[] bytes = resultData.getData();
            OutputStream outputStream = null;
            try {
                outputStream = response.getOutputStream();
                outputStream.write(bytes);
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(outputStream != null){
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

        }else{
            log.info(resultData.toString());
            log.info("*****************************");
        }



    }


}
