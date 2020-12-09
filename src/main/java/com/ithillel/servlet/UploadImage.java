package com.ithillel.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;

@WebServlet(value = "/upload")
public class UploadImage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String realPath = getServletContext().getRealPath("");
        String link = req.getParameter("url");
        URL url = new URL(link);
        InputStream inputStream = url.openStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        File file = new File(realPath.substring(0, realPath.indexOf("target")) + "src\\main\\resources\\uploads", link.substring(link.length()/2
                , link.length()/2 + 5)
                + link.substring(link.lastIndexOf('.')));
        System.out.println(file.getAbsolutePath());
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        OutputStream outputStream = new FileOutputStream(file);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        int c;
        while ((c = bufferedInputStream.read()) != - 1) {
            bufferedOutputStream.write(c);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
        inputStream.close();
        outputStream.close();
        resp.sendRedirect(req.getContextPath() + "/");
    }
}
