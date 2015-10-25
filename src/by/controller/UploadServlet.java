package by.controller;

import by.database.dao.EntityDAO;
import by.database.dao.EntityDAOImpl;
import by.entity.Entity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Calendar;

@WebServlet("/upload")
 @MultipartConfig
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityDAO entityDAO = new EntityDAOImpl();
        String description = request.getParameter("description");
        Part filePart = request.getPart("file");
        String calendar = Integer.toString(Calendar.DATE)+"-"+Integer.toString(Calendar.HOUR_OF_DAY)+"-"+Integer.toString(Calendar.MINUTE)+
                "-"+Integer.toString(Calendar.SECOND);
        InputStream fileContent = filePart.getInputStream();

        OutputStream os = new FileOutputStream(calendar+".txt");

        byte [] buffer = new byte[1024];
        int  byteRead;
        while((byteRead = fileContent.read(buffer))!=-1){
            os.write(buffer,0,byteRead);
        } if(os!= null){
            os.close();
        }

        String csvFile = "D:\\apache-tomcat-7.0.55\\bin\\"+calendar+".txt";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            System.out.print(csvFile);
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] ent = line.split(cvsSplitBy);
                Entity entity = new Entity();
                entity.setName(ent[0]);
                entity.setSurname(ent[1]);
                entity.setLogin(ent[2]);
                entity.setEmail(ent[3]);
                entity.setPhonenumber(Integer.valueOf(ent[4]));
                entityDAO.addEntity(entity);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/pages/importPage.jsp");
        requestDispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
