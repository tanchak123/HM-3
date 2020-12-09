package com.ithillel.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class HeaderDownLoad extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String realPath = getServletContext().getRealPath("");
            String imagesBase = realPath.substring(0, realPath.indexOf("target")) + "src\\main\\resources\\images\\";
            String parameter = req.getParameter("id");
            File file = new File(imagesBase + "header.gif");
            resp.setContentType("image/gif");
            resp.setContentLength((int) file.length());
            if (parameter != null) {
                String headerKey = "Content-Disposition";
                String headerValue = String.format("attachment; filename=\"%s\"", file.getName());
                resp.setHeader(headerKey, headerValue);
            }
            FileInputStream inputStream = new FileInputStream(
                    file.getAbsoluteFile());
            OutputStream outputStream = resp.getOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            inputStream.close();
            outputStream.close();
        }

}
