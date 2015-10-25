package by.navigation.command;


import by.database.dao.EntityDAO;
import by.database.dao.EntityDAOImpl;
import by.entity.Entity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class PagingCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) throws IOException, ServletException {
       Integer number = Integer.valueOf(request.getParameter("numOP"));
        EntityDAO entityDAO = new EntityDAOImpl();
        List<Entity> entities = entityDAO.showEntities("name");

        int to = (number)*10;
        if(to>entities.size()){
            to=entities.size();
        }

        List<Entity> subEntities = entities.subList((number-1)*10,to);
        request.setAttribute("subentities",subEntities);
        int numberOfPage=0;
        int total = entities.size();
        if(total%10==0){
            numberOfPage = total/10;
        }else numberOfPage = total/10+1;
        Integer[] nOP = new Integer[numberOfPage];
        for(int i=0;i<nOP.length;i++){
            nOP[i]=i+1;
        }
        request.setAttribute("numOP",nOP);

        return "WEB-INF/pages/listPage.jsp";
    }
}
