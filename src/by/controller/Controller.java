package by.controller;

import by.navigation.CommandFactory;
import by.navigation.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Controller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        performAction(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        performAction(request,response);
    }

    protected void performAction(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String page = request.getParameter("page");
        if( page != null){
            Command command = CommandFactory.getCommand(page.toUpperCase());
            String nextPage = command.execute(request);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
            requestDispatcher.forward(request,response);
        }
        else {
            throw new IllegalArgumentException("Param page is not specified");
        }


    }
}
