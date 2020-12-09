package com.ithillel.servlet;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DisplayImage extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String realPath = getServletContext().getRealPath("");
        String imagesBase = realPath.substring(0, realPath.indexOf("target")) + "src\\main\\resources\\images\\";
        String URLAfterWebDomain = request.getRequestURI();
        //Only accept mappings as src="/images/whatever.jpg", even if web.xml has other mappings to this servlet.
        if (URLAfterWebDomain.startsWith("/images/") == false)
            return;
        String relativeImagePath = URLAfterWebDomain.substring("/images/".length());

        System.out.println("\nFetching image from " + imagesBase + relativeImagePath);
        String prefix = URLAfterWebDomain.substring(URLAfterWebDomain.lastIndexOf('.') + 1);
            response.setContentType("image/" + prefix);

        ServletOutputStream outStream;
        outStream = response.getOutputStream();
        FileInputStream fin = new FileInputStream(imagesBase + relativeImagePath);

        BufferedInputStream bin = new BufferedInputStream(fin);
        BufferedOutputStream bout = new BufferedOutputStream(outStream);
        int ch;
        while ((ch = bin.read()) != -1)
            bout.write(ch);
        bin.close();
        bout.close();
    }
}
  