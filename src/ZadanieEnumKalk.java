import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/math")
public class ZadanieEnumKalk extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();


        Integer number1 = Integer.valueOf(req.getParameter("n1"));
        Integer number2 = Integer.valueOf(req.getParameter("n2"));

        String operation = req.getParameter("operation");
        MathOperation mathOperation = MathOperation.getMathOperation(operation);
        switch (mathOperation) {
            case ADD:
                printWriter.println("Dodawanie! " + number1 + " + " +number2 + " to: " + (number1 + number2));
                break;
            case DIV:
                printWriter.println("Dzielenie! " + number1 + " / " +number2 + " to: " +  (number1/number2));
                break;
            case MULTI:
                printWriter.println("Mnozenie! " + number1 + " * " +number2 + " to: " +  (number1*number2));
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

