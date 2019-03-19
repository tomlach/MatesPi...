import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/nettobrutto")
public class zadanieDom extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        Integer wartosc1 = Integer.valueOf(req.getParameter("wartosc1"));

        String operation = req.getParameter("operation");
        MathOperation mathOperation = MathOperation.getMathOperation(operation);
        switch (mathOperation) {
            case OSIEMNETTO:
                printWriter.println("Netto na brutto (8%) dla liczby " + wartosc1 +  " to: " + (wartosc1 * 1.08));
                break;
            case PIETNASCIENETTO:
                printWriter.println("Netto na brutto (15%) dla liczby " + wartosc1 +  " to: " + (wartosc1 * 1.15));
                break;
            case DWADZIESCIATRZYNETTO:
                printWriter.println("Netto na brutto (23%) dla liczby " + wartosc1 +  " to: " + (wartosc1 * 1.23));
                break;
            case OSIEMBRUTTO:
                printWriter.println("Brutto na Netto (8%) dla liczby " + wartosc1 +  " to: " + (wartosc1 / 1.08));
                break;
            case PIETNASCIEBRUTTO:
                printWriter.println("Brutto na Netto (15%) dla liczby " + wartosc1 +  " to: " + (wartosc1 / 1.15));
                break;
            case DWADZIESCIATRZYBRUTTO:
                printWriter.println("Brutto na Netto (23%) dla liczby " + wartosc1 +  " to: " + (wartosc1 / 1.23));
                break;
            default:
                printWriter.println("Nie zdefiniowane! ");
        }
    }

    enum MathOperation {
        OSIEMNETTO("8%"),
        PIETNASCIENETTO("15%"),
        DWADZIESCIATRZYNETTO("23%"),
        OSIEMBRUTTO("8%B"),
        PIETNASCIEBRUTTO("15%B"),
        DWADZIESCIATRZYBRUTTO("23%B"),
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