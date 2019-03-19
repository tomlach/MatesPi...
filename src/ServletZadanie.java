import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.parser.Parser;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/twoParameters")
public class ServletZadanie extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        Integer number1 = Integer.valueOf(req.getParameter("n1"));
        Integer number2 = Integer.valueOf(req.getParameter("n2"));
        String sign = req.getParameter("sign");

        Integer suma = number1 + number2;
        Integer roznica = number1 - number2;
        Integer mnozenie = number1 * number2;
        Integer dzielenie = number1 / number2;

       if (sign.equals("-")) {
            printWriter.println("Roznica dwóch parametrów: " + roznica);
        } else if (sign.equals("*")) {
            printWriter.println("Mnozenie dwóch parametrów: " + mnozenie);
        } else if (sign.equals("/")) {
            printWriter.println("Dzielenie dwóch parametrów: " + dzielenie);
        }
       else {
           printWriter.println("Dodawanie: " + suma);
       }
    }
}
