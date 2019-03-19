package ZadanieDaty;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/dataPost")
public class DataDoPost extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dzien = req.getParameter("dzien");
        String miesiac = req.getParameter("miesiac");
        String rok = req.getParameter("rok");

        HttpSession mySes = req.getSession(true);
        Data data = new Data(dzien, miesiac, rok);
        mySes.setAttribute("data", data);
    }
}
