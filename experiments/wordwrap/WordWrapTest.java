package experiments.wordwrap;

import static experiments.wordwrap.WordWrap.drawBox;
import static experiments.wordwrap.WordWrap.drawBoxes;
import static experiments.wordwrap.WordWrap.wordWrap;

public class WordWrapTest {
    public static void main(String[] args) {
        final int WIDTH = 100;

        final String sample = "Once Jerry and 16 midgets set off on a journey. They were looking "
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
                + "turned\npurple and floated into outer space, doomed to wander the universe.";
        final String sample2 = "Blah blah blah blah blah\n";

        System.out.println("Raw Sample:\n" + sample + "\n");

        System.out.println("Wrapped sample:\n" + wordWrap(sample, WIDTH) + "\n");

        System.out.println("Boxed sample:\n" + drawBox(sample, WIDTH));

        String[] samples = { sample2, sample };
        System.out.println("Boxed samples:\n" + drawBoxes(samples, WIDTH));

        String[] samples2 = { sample, sample2, sample };
        System.out.println("Boxed samples3:\n" + drawBoxes(samples2, WIDTH));

        String[] samples3 = { sample, sample2, sample2, sample };
        System.out.println("Boxed samples3:\n" + drawBoxes(samples3, WIDTH));

        String[] samples4 = { sample, sample2, sample, sample2, sample, };
        System.out.println("Boxed samples4:\n" + drawBoxes(samples4, WIDTH, 3));
    }
}
