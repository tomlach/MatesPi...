package ZadanieKoszykSklepowy;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/koszykPost")
public class KoszykDoPost extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        String name = req.getParameter("name");
        HttpSession httpSession = req.getSession(true);
        ArrayList<Koszyk> koszyk = (ArrayList<Koszyk>) httpSession.getAttribute("products");
        if (koszyk == null) {
            koszyk = new ArrayList<Koszyk>();
            koszyk.add(new Koszyk(name));
            koszyk.add(new Koszyk(name));
            koszyk.add(new Koszyk(name));
        }

        httpSession.setAttribute("products", koszyk);
    }
}
