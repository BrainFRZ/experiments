package experiments.wordwrap;

public class WordWrap {
    private static String wordWrap(String text, int width, String delim) {
        StringBuilder out = new StringBuilder();
        String[] words;
        int currentWidth = 0;

        //Parse out tabs and new lines
        text = text.replaceAll("[\t\n]", " ");
        words = text.split(delim);

        //Rewrap to new width
        for (String word : words) {
            if (word.length() >= width) {
                //If it's not the first word, put it on a new line
                if (out.length() == 0) {
                    out.append('\n');
                }
                out.append(word).append(' ');
                currentWidth = word.length();
            }
            else if ((currentWidth + word.length()) <= width) {
                out.append(word).append(' ');
                currentWidth += word.length() + 1;
            } else {
                out.delete(out.length() - 1, out.length());
                out.append('\n').append(word).append(' ');
                currentWidth = word.length() + 1;
            }
        }

        return out.substring(0, out.length() - 1);
    }

    public static String wordWrap(String text, int width) {
        return wordWrap(text, width, " ");
    }

    public static String drawBox(String text, int width) {
        StringBuilder out = new StringBuilder();
        String[] lines;

        StringBuilder border = new StringBuilder(" ");
        for (int i = 0; i < (width - 2); i++) {
            border.append("-");
        }
        border.append(" \n");

        out.append(border);

        if (width < 5) {
            width = 5;
        }
        width -= 4;
        lines = wordWrap(text, width).split("\n");
        for (String line : lines) {
            out.append(String.format("| %-" + width + "s |\n", line));
        }

        out.append(border);

        return out.toString();
    }

    public static String drawBoxes(String[] messages, int width) {
        StringBuilder out = new StringBuilder();
        String[] boxes = new String[messages.length];
        String[][] lines;   //String[box's full string][array of box's string split at new line]
        int maxBoxLines = 0;

        if (messages.length == 1) {
            out.append(drawBox(messages[0], width));
        }
        else {
            width = width / messages.length - 1;

            for (int i = 0; i < messages.length; i++) {
                boxes[i] = drawBox(messages[i], width);
            }

            for (String box : boxes) {
                int boxLines = box.split("\n").length;
                if (boxLines > maxBoxLines) {
                    maxBoxLines = boxLines;
                }
            }
            lines = new String[boxes.length][maxBoxLines];

            for (int b = 0; b < boxes.length; b++) {
                lines[b] = boxes[b].split("\n");
            }

            for (int l = 0; l < maxBoxLines; l++) {
                StringBuilder currentLine = new StringBuilder();
                for (int b = 0; b < boxes.length; b++) {
                    if (l >= lines[b].length) {
                        currentLine.append(String.format("%" + width + "s ", ""));
                    }
                    else {
                        currentLine.append(lines[b][l]).append(" ");
                    }
                }
                out.append(currentLine.substring(0, currentLine.length() - 1)).append("\n");
            }
        }

        return out.toString();
    }

    public static String drawBoxes(String[] messages, int width, int boxesWide) {
        StringBuilder out = new StringBuilder();

        if (messages.length <= boxesWide) {
            out.append(WordWrap.drawBoxes(messages, width));
        }
        else {
            int currentBox = 0;
            String[] currentMessages;

            while (currentBox < messages.length) {
                if (boxesWide > messages.length - currentBox) {
                    boxesWide = messages.length - currentBox;
                }

                currentMessages = new String[boxesWide];

                for (int i = 0; i < boxesWide; i++) {
                    currentMessages[i] = messages[currentBox];
                    currentBox++;
                }

                out.append(WordWrap.drawBoxes(currentMessages, width)).append("\n");
            }
        }

        return out.substring(0, out.length() - 1);
    }
}