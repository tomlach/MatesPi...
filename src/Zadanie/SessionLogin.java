package Zadanie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class SessionLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("user/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Stan sesji</h1>");
        String imie = req.getParameter("imie");
        String nazwisko = req.getParameter("nazwisko");
        String email = req.getParameter("email");
        String haslo = req.getParameter("haslo");
        User user = new User(imie, nazwisko, email, haslo);
        HttpSession mySes = req.getSession(true);
        mySes.setAttribute("name", user);
    }
}
