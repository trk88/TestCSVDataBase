package by.navigation.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by NotePad.by on 20.10.2015.
 */
public interface Command {
    public String execute(HttpServletRequest request) throws IOException, ServletException;
}
