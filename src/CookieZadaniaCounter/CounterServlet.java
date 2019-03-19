package CookieZadaniaCounter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/counter")
public class CounterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        int counter = 1;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("counter")){
                counter = Integer.parseInt(cookie.getValue());
                counter++;
            }
        }
        Cookie cookie = new Cookie("counter", String.valueOf(counter));
        resp.addCookie(cookie);
    }
}