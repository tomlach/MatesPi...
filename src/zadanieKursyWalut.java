import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static javax.swing.text.html.FormSubmitEvent.MethodType.GET;

@WebServlet("/kursywalut")
public class zadanieKursyWalut extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        Integer wartosc1 = Integer.valueOf(req.getParameter("wartosc1"));
        String from_operation = req.getParameter("from_operation");
        String into_operation = req.getParameter("into_operation");

        double usdpln = wartosc1 * 3.79;
        double plnusd = wartosc1 * 0.26;
        double eurpln = wartosc1 * 4.31;
        double plneur = wartosc1 * 0.23;
        double usdeur = wartosc1 * 0.88;
        double eurusd = wartosc1 * 1.13;


        if (from_operation.equals("frompln")) {
                if (into_operation.equals("intousd")) {
                    printWriter.println("Kurs PLN -> USD kwoty: " + wartosc1 + " to: " + plnusd);
                } else if (into_operation.equals("intoeur")) {
                    printWriter.println("Kurs PLN -> EUR kwoty: " + wartosc1 + " to: " + plneur);
                } else if (into_operation.equals("intopln")) {
                    printWriter.println(wartosc1);
                } else {
                    printWriter.println("YYYYY");
                }
            } else if (from_operation.equals("fromusd")) {
                if (into_operation.equals("intopln")) {
                    printWriter.println("Kurs USD -> PLN kwoty: " + wartosc1 + " to: " + usdpln);
                } else if (into_operation.equals("intoeur")) {
                    printWriter.println("Kurs USD -> eur kwoty: " + wartosc1 + " to: " + usdeur);
                } else if (into_operation.equals("intousd")) {
                    printWriter.println(wartosc1);
                } else {
                    printWriter.println("YYYYYY");
                }
            } else if (from_operation.equals("fromeur")) {
                if (into_operation.equals("intopln")) {
                    printWriter.println("Kurs EUR -> PLN kwoty: " + wartosc1 + " to: " + eurpln);
                } else if (into_operation.equals("intousd")) {
                    printWriter.println("Kurs EUR = USD kwoty: " + wartosc1 + " to: " + eurusd);
                } else if (into_operation.equals("intoeur")) {
                    printWriter.println(wartosc1);
                } else {
                    printWriter.println("YYYYYYY");
                }
            } else {
                printWriter.println("Jakis blad...");
            }

        }


//        switch (mathOperation) {
//            case PLNUSD:
//                printWriter.println("PLN -> USD dla kwoty: " + wartosc1 + " to: " + (wartosc1 * plnusd));
//                break;
//            case USDPLN:
//                printWriter.println("USD -> PLN dla kwoty: " + wartosc1 + " to: " + (wartosc1 * usdpln));
//                break;
//            case PLNEUR:
//                printWriter.println("PLN -> EUR dla kwoty: " + wartosc1 + " to: " + (wartosc1 * plneur));
//                break;
//            case EURPLN:
//                printWriter.println("EUR -> PLN dla kwoty: " + wartosc1 + " to: " + (wartosc1 * eurpln));
//                break;
//                default:
//            printWriter.println("Nie zdefiniowane...! ");
//        }
//    }
//
//    enum MathOperation1 {
//        PLNUSD("plnusd"),
//        USDPLN("usdpln"),
//        PLNEUR("plneur"),
//        EURPLN("eurpln"),
//        UNKNOWN("unknown");
//        private String operation;
//
//        MathOperation1(String operation) {
//            this.operation = operation;
//        }
//
//        public static MathOperation1 getMathOperation1 (String operation){
//            for (MathOperation1 mathOperation1 : values() ){
//                if (mathOperation1.operation.equals(operation)){
//                    return mathOperation1;
//                }
//            }
//            return UNKNOWN;
//        }
//    }
    }

