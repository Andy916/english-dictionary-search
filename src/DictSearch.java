// This program searches for a word in a dictionary file and prints all occurrences of that word.
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class DictSearch {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a word to search for (or 'exit' to quit): ");
        String word = input.next();
        Pattern pattern = Pattern.compile("[\\w-']*" + word + "[\\w-']*\\b", Pattern.CASE_INSENSITIVE);
        BufferedReader reader = new BufferedReader(new FileReader("words.txt"));
        System.out.println("Searching for words containing: " + word);
        String line;
        int wordCount = 0;
        while ((line = reader.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                System.out.println(matcher.group());
                wordCount++;
            }
        }
        reader.close();
        input.close();
        System.out.println("Total words found: " + wordCount);
    }
}
