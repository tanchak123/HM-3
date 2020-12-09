package com.ithillel.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EnterData extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(
                "<html>" +
                        "<head>" +
                        "   <meta charset=\"utf-8\">" +
                        "   <title>Введите данные</title>" +
                        " </head>" +
                        "<body>" +
                        "   <h1>Home Servlet<p>Введите айди картинки которую хотите посмотреть</p></h1>" +
                        "<form action=\"http://localhost:8080/download\">" +
                        "  <p><input name=\"id\"></p>" +
                        "  <p><input type=\"submit\"></p>" +
                        "   <h1>Home Servlet<p>Введите url картинки которую хотите закачать в resources</p></h1>" +
                        "</form>" +
                        "<form action=\"http://localhost:8080/upload\">" +
                        "  <p><input name=\"url\"></p>" +
                        "  <p><input type=\"submit\"></p>" +
                        "  <h1>Хотите посмотреть реализацию через хедеры?(она не очень :) )</h1>" +
                        "  <p><a href=\"http://localhost:8080/header\">Не забудьте ввести '?id=что-то' чтобы скачать файл</a></p>" +
                        "</form>" +
                        "</body>" +
                        "</html>");
    }
}
