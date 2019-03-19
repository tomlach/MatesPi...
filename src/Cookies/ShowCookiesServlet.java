package Cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/showcookie")
public class ShowCookiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            printWriter.println("Ciasteczko: ");
            printWriter.println(cookie.getName());
            printWriter.println(cookie.getValue());
            printWriter.println(cookie.getMaxAge());
        }
    }
}