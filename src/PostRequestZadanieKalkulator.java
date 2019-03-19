import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/kalk")
public class PostRequestZadanieKalkulator extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        Integer wartosc1 = Integer.valueOf(req.getParameter("wartosc1"));
        Integer wartosc2 = Integer.valueOf(req.getParameter("wartosc2"));
//        printWriter.println("Wynik dzialania: " + wartosc1 + " " + wartosc2 + "to: " + (wartosc1 + wartosc2));
//        printWriter.println("Wczytywanie 2 parametrow ");
//        printWriter.println(req.getParameter("wartosc1"));
//        printWriter.println(req.getParameter("wartosc2"));

        String operation = req.getParameter("operation");
        MathOperation mathOperation = MathOperation.getMathOperation(operation);
        switch (mathOperation) {
            case ADD:
                printWriter.println("Dodawanie! " + wartosc1 + " + " + wartosc2 + " to: " + (wartosc1 + wartosc2));
                break;
            case DIV:
                printWriter.println("Dzielenie! " + wartosc1 + " / " + wartosc2 + " to: " + (wartosc1 / wartosc2));
                break;
            case MULTI:
                printWriter.println("Mnozenie! " + wartosc1 + " * " + wartosc2 + " to: " + (wartosc1 * wartosc2));
                break;
            default:
                printWriter.println("Nie zdefiniowane! ");
        }
    }

    enum MathOperation {
        ADD("add"),
        DIV("div"),
        MULTI("multi"),
        UNKNOWN("unknown");
        private String operation;

        MathOperation(String operation) {
            this.operation = operation;
        }

        public static MathOperation getMathOperation(String operation) {
            for (MathOperation mathOperation : values()) {
                if (mathOperation.operation.equals(operation)) {
                    return mathOperation;
                }
            }
            return UNKNOWN;

        }
    }
}
