package by.navigation.command;


import javax.servlet.http.HttpServletRequest;

public class ImportCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "WEB-INF/pages/importPage.jsp";
    }
}
