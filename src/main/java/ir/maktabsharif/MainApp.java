package ir.maktabsharif;

import ir.maktabsharif.enums.FrequencyStatus;
import ir.maktabsharif.model.Book;
import ir.maktabsharif.model.Magazine;
import ir.maktabsharif.model.Manuscript;

public class MainApp {
    public static void main(String[] args) {
        Book book = new Book("sage velgard", 1370, 30, "978-964-05-0", "Sadegh Hedayat", 20);
        Magazine magazine = new Magazine("develober", 1405, 20, 42, "aa", FrequencyStatus.MONTHLY);
        Manuscript manuscript = new Manuscript("aa", 1400, 50, "iran", 500, true);
    }
}
