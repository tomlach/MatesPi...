package ZadanieDaty;

public class Data {
    String dzien;
    String miesiac;
    String rok;

    public Data(String dzien, String miesiac, String rok) {
        this.dzien = dzien;
        this.miesiac = miesiac;
        this.rok = rok;
    }

    @Override
    public String toString() {
        return "Data{" +
                "dzien='" + dzien + '\'' +
                ", miesiac='" + miesiac + '\'' +
                ", rok='" + rok + '\'' +
                '}';
    }
}
