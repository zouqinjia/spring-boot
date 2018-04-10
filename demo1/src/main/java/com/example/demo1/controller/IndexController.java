package com.example.demo1.controller;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Author: zouqinjia
 * Description:
 * Date:2017/10/10 13:39
 **/
@RestController
public class IndexController {




    public static final String SRC = "C:\\Users\\Administrator\\Desktop\\demo.pdf";
    public static final String DEST = "C:\\Users\\Administrator\\Desktop\\demo1.pdf";
    String waterMark ="上海旺达  ZHANANANK11111";


    /**
     * 文件上传
     * @param file 文件对象
     * @throws IOException
     */
    @RequestMapping(value = "/fileUpload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        FTPClient ftpClient = new FTPClient();
//        ftpClient.makeDirectory()
        // 文件名
        String fileName = file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();
        // 目标目录
        String dest = "C:\\Users\\Administrator\\Desktop\\temp\\";
        File temp = new File(dest);
        // 目标目录是否存在
        Boolean bool = temp.exists();
        if(!bool){// 不存在就创建文件夹
            temp.mkdirs();
        }
        // 将上传的文件保存至目标目录
        FileUtils.copyInputStreamToFile(inputStream,new File(dest+fileName));
    }

    /**
     *
     * @param httpServletResponse
     * @return
     * @throws Exception
     */
    @RequestMapping("/index")
    public String toIndex(HttpServletResponse httpServletResponse) throws Exception {

//        httpServletResponse.setHeader("Content-disposition","attachment;filename=helloWorld.pdf");
//        OutputStream outputStream =  httpServletResponse.getOutputStream();
//        // 1、从FTP获取文件输出流
//        FileInputStream inputStream = new FileInputStream(SRC);
//        // 2、将文件输出转成文件输入流
//        // 3、使用itext加载PDF输出流
//        // 4、获取登录的用户、和所属经销商
//        // 5、添加水印
//        // 6、将加好水印的文件放到一个临时目录
//        manipulatePdf2(inputStream,outputStream,waterMark);
        // 7、将临时文件响应到下载输出流
        // 8、将临时文件删除掉
        return "index";
    }

    public String parse_String(InputStream in) throws Exception
    {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        int ch;
        while ((ch = in.read()) != -1) {
            swapStream.write(ch);
        }
        return swapStream.toString();
    }

    /**
     * 操作PDF文件.加水印
     * @param inputStream 需要添加水印的PDF文件
     * @param outputStream
     * @throws IOException
     * @throws DocumentException
     */
    public  void manipulatePdf2(InputStream inputStream, OutputStream outputStream,String waterMarkTe) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(inputStream);
        int n = reader.getNumberOfPages();

        PdfStamper stamper = new PdfStamper(reader, outputStream);
        // text watermark
        BaseFont base = BaseFont.createFont("C:/WINDOWS/Fonts/SIMSUN.TTC,1", "Identity-H", true);
        Font f = new Font(base, 20);
        Phrase p = new Phrase(waterMarkTe, f);
        // image watermark
        // transparency
        PdfGState gs1 = new PdfGState();
        gs1.setFillOpacity(0.2f);
        // properties
        PdfContentByte over;
        Rectangle pagesize;
        float x, y;
        // loop over every page
        for (int i = 1; i <= n; i++) {
            pagesize = reader.getPageSizeWithRotation(i);
            x = (pagesize.getLeft() + pagesize.getRight()) / 2;
            y = (pagesize.getTop() + pagesize.getBottom()) / 2;
            over = stamper.getOverContent(i);
            over.saveState();
            over.setFontAndSize(base, 50);
            over.setGState(gs1);
            ColumnText.showTextAligned(over, Element.ALIGN_CENTER, p, x, y, 0);
            over.restoreState();
        }
        stamper.close();
        reader.close();
    }
}
