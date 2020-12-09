package com.ithillel.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DisplayImageDownLoad extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println(id);
//        if (!Character.isDigit(id.charAt(1))) {
//            return;
//        }
        String imageAddress;
        if (id == null) {
            resp.sendRedirect(req.getContextPath() + "/enter");
            return;
        }
            switch (id) {
                case "1":
                    imageAddress = "\"images/header.gif\"";
                    break;
                case "2":
                    imageAddress = "\"images/img.jpg\";";
                    break;
                case "3":
                    imageAddress = "\"images/gif.gif\";";
                    break;
                default:
                    imageAddress = "\"images/pudge.png\";";

            }
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println(
                "<html>" +
                "<head>" +
                "   <meta charset=\"utf-8\">\n" +
                "   <title>Тег META, атрибут charset</title>\n" +
                " </head>" +
                "<body>" +
                "   <h1>Home Servlet<p>Файл с id '" + id + "' получен.</p></h1>" +
                "   <a href=" + imageAddress + " download>Скачать файл</a>" +
                    "<br>" +
                "   <a href=" + imageAddress + ">Посмотреть файл</a>" +
                "</body>" +
                "</html>");
    }
}
