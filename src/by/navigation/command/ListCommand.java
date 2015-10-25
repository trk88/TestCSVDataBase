package by.navigation.command;

import by.database.dao.EntityDAO;
import by.database.dao.EntityDAOImpl;
import by.entity.Entity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class ListCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        EntityDAO entityDAO = new EntityDAOImpl();
        List<Entity> entities = entityDAO.showEntities("name");
        List<Entity> subEntities = entities.subList(0,10);
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
