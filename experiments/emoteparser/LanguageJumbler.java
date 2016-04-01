package experiments.emoteparser;

import java.util.Random;

public class LanguageJumbler {
    public static void main(String[] args) {
        final String text = "Once Jerry and 16 midgets set off on a journey. They were looking "
                + "for the great treasure of Ecrapolis. On their way\nthey got lost and camped "
                + "inside a giant elephant. they awoke the next morning to find that the elephant "
                + "had walked\nthem to Los Angeles. Being from an underground secret city, Jerry "
                + "and the midgets had no idea what to think of this.\nThey all went out exploring "
                + "the city, and got into all sorts of crazy-asss trouble. Jerry tried surfing and "
                + "was thrown off\nhis board into the sand, mouth-first. He proceeded to munch the "
                + "sand down, saying it as the best food he'd had in\nages. Suddenly while digging "
                + "through this delectable muck, he hit something hard. IT WAS A TREASURE CHEST!\n"
                + "He opened it slowly as the 16 midgets crowded around him. Unable to fathom what "
                + "was inside he tore it open. Inside\nwas a note, \"Ha Ha! There's no real "
                + "treasure You retarded egg goblin!!\" With that note, Jerry and the midgets "
                + "turned\npurple and floated into outer space, doomed to wander the universe.12345";
        final String text2 = "pizza";

        System.out.println("Original text: " + text2);
        System.out.println("\nJumbled text:  " + jumble(text2));
    }

    public static String jumble(String text) {
        String jumble = "";
        Random generator = new Random();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                if (Character.isUpperCase(ch)) {
                    jumble += (char)('A' + generator.nextInt(26));
                }
                else {
                    jumble += (char)('a' + generator.nextInt(26));
                }
            }
            else if (Character.isDigit(ch)) {
                jumble += (char)('0' + generator.nextInt(10));
            }
            else {
                jumble += text.charAt(i);
            }
        }

        return jumble;
    }
}
