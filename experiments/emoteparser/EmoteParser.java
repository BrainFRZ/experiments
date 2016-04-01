package experiments.emoteparser;

import experiments.wordwrap.WordWrap;
import java.util.Scanner;

public class EmoteParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an emote: ");
        String emote = scanner.nextLine();

        System.out.println("Original emote:\n" + emote);
        System.out.println("\nParsed emote:\n" + parseEmote(emote));
        System.out.println("\nWrapped emote:\n" + WordWrap.wordWrap(parseEmote(emote), 100));
    }

    public static String parseEmote(String emote) {
        String ret = "";
        int quote1Location = emote.indexOf('"');
        int quote2Location;
        int currentIndex = 0;

        if (quote1Location == -1) {
            ret = emote;
        }
        else {
            boolean found = true;
            do {
                quote2Location = emote.indexOf('"', quote1Location + 1);
                if (quote2Location == -1) {
                    if (quote2Location != emote.length() - 2) {
                        ret += emote.substring(currentIndex);
                    }
                    found = false;
                }
                else {
                    ret += emote.substring(currentIndex, quote1Location + 1);
                    ret += LanguageJumbler.jumble(emote.substring(quote1Location + 1,
                                                                    quote2Location));
                    currentIndex = quote2Location;

                    quote1Location = emote.indexOf('"', currentIndex + 1);
                    if (quote1Location == -1) {
                        ret += emote.substring(currentIndex);
                        found = false;
                    }
                }
            } while (found);
        }

        return ret;
    }
}
