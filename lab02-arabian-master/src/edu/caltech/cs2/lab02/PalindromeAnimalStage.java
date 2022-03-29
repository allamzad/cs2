package edu.caltech.cs2.lab02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PalindromeAnimalStage implements AdventureStage {

    private final Scanner sc;
    private final Map<String, AdventureStage> responses;

    /**
     * Constructor for PalindromeAnimalStage.
     * Sets responses and scanner.
     *
     * @param sc scanner used by whole game.
     */
    public PalindromeAnimalStage(Scanner sc) {
        this.sc = sc;
        this.responses = new HashMap<>();
        this.responses.put("go", new FillerStage("Look over there! There are some neat seniors! Let's go chase them!"));
    }

    /**
     * returns prompt
     *
     * @return prompt for next stage selection.
     */
    @Override
    public String riddlePrompt() {
        return "Looks like we've gotten to the end of our neat journey through the neature. Let's go back to the Olive Walk!";
    }

    /**
     * Plays stage.
     * Repeats prompt until palindromic name is given.
     */
    @Override
    public void playStage() {
        System.out.println("You've spotted a neat animal. Its front and back look identical! " +
                "Let's give it a neat new name that reflects how neat it is! (make it a palindrome)");
        while (true) {
            String name = this.sc.nextLine();
            String reversed = reverseString(name);
            if (name.equals(reversed)) {
                System.out.println("That's a pretty neat name!!eman taen ytterp a s'tahT");
                break;
            }

            System.out.println("That's not a palindrome! Try again.");
        }
    }

    /**
     * Gets hashmap of responses
     *
     * @return hashmap of responses generated by constructor.
     */
    @Override
    public Map<String, AdventureStage> getResponses() {
        return this.responses;
    }

    /**
     * Reverses given string and returns result.
     *
     * @param str String to be reversed
     * @return new reversed string.
     */
    public static String reverseString(String str) {
        char[] reverse = new char[str.length()];
        for (int i = str.length(); i > 0; i--) {
            reverse[str.length() - i] = str.charAt(i - 1);
        }
        return new String(reverse);
    }

}