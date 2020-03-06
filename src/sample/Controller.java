package sample;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import java.security.SecureRandom;

public class Controller {

    public Label wwoord;
    public ChoiceBox<Integer> keuze;
    public ChoiceBox<String> wwkeuze;
    private static final String LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "&#_$-+*%!?@<>,;().";

    public void wmaken() {
        String wachtwoord;
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();
        wachtwoord=maakww(keuze.getValue());
        wwoord.setText(wachtwoord);
        content.putString(wachtwoord);
        clipboard.setContent(content);
    }

    private String maakww(int lengte) {
        String str="";
        String wwString="";
        if ("Letters".equals(wwkeuze.getValue())) {
            wwString = LETTERS;
        }
        if ("Letters en Cijfers".equals(wwkeuze.getValue())) {
            wwString = LETTERS+DIGITS;
        }
        if ("Letters, Cijfers en specials".equals(wwkeuze.getValue())) {
            wwString = LETTERS+DIGITS+SPECIAL;
        }
        SecureRandom random = new SecureRandom();

        for (int teller=0;teller<lengte;teller++) {
            str+=wwString.charAt(random.nextInt(wwString.length()-1));
        }
        return str;
    }

    public void initialize() {
        keuze.getItems().addAll(8,10,12,16,20,25,30);
        keuze.setValue(12);
        wwkeuze.getItems().addAll("Letters","Letters en Cijfers","Letters, Cijfers en specials");
        wwkeuze.setValue("Letters");
    }
}