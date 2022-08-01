import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Homework4 {

    public static String askForInput() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String input = reader.nextLine();
        reader.close();
        return input;
    }

    public static TrieTree getDictionary(String path) {
        TrieTree dictionary = new TrieTree();
        File file = new File(path);
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String word = sc.nextLine();
                dictionary.insert(word);
            }
            sc.close();
            return dictionary;

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            return null;
        }
    }

    private static String[] split(String input) {
        String input2 = input.replaceAll("\\p{Punct}", "");
        String input3 = input2.toLowerCase();
        String[] words = input3.split(" ");
        return words;
    }

    public static void printCorrect(String input, TrieTree dictionary) {
        ArrayList<String> wrong = new ArrayList<>();

        String[] words = split(input);

        for (int i = 0; i < words.length; i++) {
            if (!dictionary.search(words[i])) {
                wrong = dictionary.wordListForPrefix(words[i].substring(0, words[i].length() - 1));
                ArrayList<String> correct = new ArrayList<>();
                for (int j = 0; j < wrong.size(); j++) {
                    if (wrong.get(j).length() == words[i].length()) {
                        correct.add(wrong.get(j));
                    }
                }
                System.out.print(correct + " ");
            } else {
                System.out.print(words[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        TrieTree dictionary = getDictionary("fullDictionary.txt");
        String input = askForInput();
        printCorrect(input, dictionary);
    }
}