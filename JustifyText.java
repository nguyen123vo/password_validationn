import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class JustifyText {
    static List<String> words = new ArrayList<>();
    static List<String> wordsAfterJustifying = new ArrayList<>();
    static int lengthLine = 20;
    public static void main(String[] args) {
        words.add("ssd");
        words.add("sdasgffd");
        words.add("sdaersd");
        words.add("sd");
        words.add("sdaghfgsd");
        words.add("sdsd");
        words.add("sdadsfssdimnc");
        words.add("sdadssd");
        words.add("asd");
        words.add("sdahgsd");
        result(0);
        String[] array = wordsAfterJustifying.toArray(new String[0]);
        System.out.println(Arrays.toString(array));
    }
    public static void result(int start) {
        List<String> currentWords = new ArrayList<>();
        int currentLengthWithoutSpaces = 0;
        int numSpacesOfEachSpace = 0;
        int extraSpaces = 0;
        int totalSpaces = 0;
        String justifiedLine;
        for (String word : words) {
            if (currentLengthWithoutSpaces + currentWords.size() + word.length() > lengthLine) {
                justifiedLine = "";
                totalSpaces = lengthLine - currentLengthWithoutSpaces;
                if (currentWords.size() == 1) {
                    justifiedLine = justifiedLine + currentWords.get(0) + numRemainingSpaces(totalSpaces);
                    wordsAfterJustifying.add(justifiedLine);
                    currentWords.clear();
                    currentLengthWithoutSpaces = 0;
                } else {
                    numSpacesOfEachSpace = totalSpaces / (currentWords.size() - 1);
                    extraSpaces = totalSpaces % (currentWords.size() - 1);
                    for (int i = 0; i < extraSpaces; i++) {
                        justifiedLine = justifiedLine + currentWords.get(i) + numRemainingSpaces(numSpacesOfEachSpace + 1);
                    } for (int i = extraSpaces; i < currentWords.size() - 1; i++) {
                        justifiedLine = justifiedLine + currentWords.get(i) + numRemainingSpaces(numSpacesOfEachSpace);
                    } justifiedLine = justifiedLine + currentWords.get(currentWords.size() - 1);
                    wordsAfterJustifying.add(justifiedLine);
                    currentWords.clear();
                    currentLengthWithoutSpaces = 0;
                }

            } currentWords.add(word);
            currentLengthWithoutSpaces += word.length();



        } if (!currentWords.isEmpty()) {
            justifiedLine = "";
            totalSpaces = lengthLine - currentLengthWithoutSpaces;
            if (currentWords.size() == 1) {
                justifiedLine = justifiedLine + currentWords.get(0) + numRemainingSpaces(totalSpaces);
                wordsAfterJustifying.add(justifiedLine);
            } else {
                numSpacesOfEachSpace = totalSpaces / (currentWords.size() - 1);
                extraSpaces = totalSpaces % (currentWords.size() - 1);
                for (int i = 0; i < extraSpaces; i++) {
                    justifiedLine = justifiedLine + currentWords.get(i) + numRemainingSpaces(numSpacesOfEachSpace + 1);
                } for (int i = extraSpaces; i < currentWords.size() - 1; i++) {
                    justifiedLine = justifiedLine + currentWords.get(i) + numRemainingSpaces(numSpacesOfEachSpace);
                } justifiedLine = justifiedLine + currentWords.get(currentWords.size() - 1);
                wordsAfterJustifying.add(justifiedLine);
            }
        }



    }
    public static String numRemainingSpaces(int num) {
        String numSpace = "";
        for (int i = 0; i < num; i++) {
            numSpace = numSpace + " ";
        }
        return numSpace;
    }

}
