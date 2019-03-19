package Cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addcookie")
public class AddCookieServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cookieName = req.getParameter("name");
        String cookieValue = req.getParameter("value");
        Cookie cookie = new Cookie(cookieName, cookieValue);
        resp.addCookie(cookie);
    }
}