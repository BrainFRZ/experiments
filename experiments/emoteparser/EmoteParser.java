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
        StringBuilder ret = new StringBuilder();
        int quote1Location = emote.indexOf('"');
        int quote2Location;
        int currentIndex = 0;

        if (quote1Location == -1) {
            ret.append(emote);
        }
        else {
            boolean found = true;
            do {
                quote2Location = emote.indexOf('"', quote1Location + 1);
                if (quote2Location == -1 || quote2Location < currentIndex) {
                    ret.append(emote.substring(currentIndex));
                    found = false;
                }
                else {
                    ret.append(emote.substring(currentIndex, quote1Location + 1));
                    ret.append(LanguageJumbler.jumble(emote.substring(quote1Location + 1,
                                                                    quote2Location)));
                    currentIndex = quote2Location;

                    quote1Location = emote.indexOf('"', currentIndex + 1);
                }
            } while (found);
        }

        return ret.toString();
    }
}
