/*
 *This program is similar to the tv show countdown, there are two players and they can only enter Java keywords.
 *the player chooses how many rounds he wants to play, in each turn the player chooses how many vowels and consonants  
 * between 9 letters and both need to form a word, the one who assembles the largest word wins.
 */

/**
 * KeywordCountdown.java
 * @author Fernando Sequineli
 * 22th April 2020
 */

public class KeywordCountdownApp {
    
    public static void main(String[] args) {
    
        KeywordCountdown app = new KeywordCountdown();
        
               app.calcGame();

    }
    
}
