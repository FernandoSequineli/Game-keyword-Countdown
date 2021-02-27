

//all imported class in the program
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.swing.JOptionPane;

public class KeywordCountdown {
    
    Random random = new Random(); 
    
    private int rounds; // keep the amount rounds
    private final String allVowels = "AEIOU"; // this var contains all vowels 
    private final String allConsonants = "BCDFGHJKLMNPQRSTVXYWZ"; // this var contains all consonants 
    private String vowels = ""; //keep the random vowels
    private String consonants = ""; //keep the random consonants
    private int inputVow; // keep the input of vowels 
    private int lenVow; // length of vowels
    private int lenCon; // length of consonants
    private String randomLetters; // keep the value of vowels and consonants 
    private String wordP1;// keep the word from player 1
    private String wordP2;
    private int scoreP1; // keep the score 
    private int scoreP2;   
    private int calcLongWord1; // used to keep value of longest word 
    private int calcLongWord2;
    private boolean val; // this var is used to validation of the users word 
    private String[] words = {"abstract", "assert","boolean", "break","byte", 
    "case","catch", "char","class", "continue","default", "do","double", "else",
    "enum", "extends","final", "finally","float","for", "if","implements", "import",
    "instanceof","int", "interface","long", "native","new","package", "private",
    "protected", "public","return","short", "static","strictfp", "super","switch",
    "synchronized","this", "throw","throws", "transient","try","void","volatile",
    "while"}; // database of words 

    // Constructor
    public KeywordCountdown() {
        this.rounds = 0;
        this.inputVow = 0;
        this.lenVow = 0;
        this.lenCon = 0;
        this.randomLetters = "";
        this.wordP1 = "";
        this.wordP2 = "";
        this.scoreP1 = 0;
        this.scoreP2 = 0;
        
        
    }
    // this method is used to get / validate the amount of rounds 
    public void inputRoundsValidation(){
        
        for (int i = 0; i < 1; i++){ //this loop will run until the user enter a valid number
            try{   //try and catch are used in case the user enter something diferent of a integer
                this.rounds = Integer.parseInt(JOptionPane.showInputDialog(null, "<html><strong><h2><center>Welcome</center></h2></strong> <strong><center> Java Keyword Countdown Game!</center></strong><br>"
                        + "How many rounds would you like to play?</html>"));
                if(this.rounds <= 99) {
                    
                                       }
                else if ((this.rounds != 0) || (this.rounds != 1) || (this.rounds != 2) 
                || (this.rounds != 3) || (this.rounds != 4) || (this.rounds != 5) 
                || (this.rounds != 6) || (this.rounds != 7) || (this.rounds != 8) 
                || (this.rounds != 9)){
                    i--;
                                      }
                
            }catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "<html><strong>Please,</strong> enter a valid number!</html>");
                i--;
            }     
        }
    }
    // this method is used to get / validate the amount of vowels and calculate the lengths of vowels/consonants
    public void inputVowValidation(){
       
       for(int i =0; i< 1; i++){
            try{
        this.inputVow = Integer.parseInt(JOptionPane.showInputDialog(null,"<html> How many <strong>vowels</strong> would you like between 9 letters?</html>"));        
        if(this.inputVow <= 9) {
        this.lenCon = 9 - this.inputVow;
        this.lenVow = 9 - this.lenCon;
           
                         } 
        else if ((this.inputVow != 0) || (this.inputVow != 1) || (this.inputVow != 2) 
        || (this.inputVow != 3) || (this.inputVow != 4) 
        || (this.inputVow != 5) || (this.inputVow != 6) || (this.inputVow != 7) || (this.inputVow != 8) || (this.inputVow != 9) 
        || (this.inputVow > 9)) {
        i--;
                                } 
              }
        catch(NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "<html><strong>Please,</strong> enter a valid number!</html>");
        i--;
       }
          
       }
     
    } 
    //this method is used to generate the random vowels/consonants and returns the value to the var *randomLetters
    public void random(){
        
        char[] randomVow = new char[this.lenVow]; //this Array has a length of the vowels  
        /*
        this loop is used to run all vowels and randomly pick up the amount of vowels
        according to the size of the var *lenVow
        */       

        for (int i = 0; i < this.lenVow; i++){ 
            randomVow[i] = this.allVowels.charAt(random.nextInt(allVowels.length()));
                                             }
        
        for(int i = 0; i <randomVow.length; i++){
            this.vowels += randomVow[i]; 
                                                }
        
            
        char[] randomCon = new char[this.lenCon];
       
        for (int i = 0; i < this.lenCon; i ++){
           randomCon[i] = this.allConsonants.charAt(random.nextInt(allConsonants.length()));
                                              }
        
        for (int i = 0; i < randomCon.length; i++){
           this.consonants += randomCon[i];
                                                  }
        this.setRandomLetters(this.vowels + this.consonants);
        
        } 
    //this method is used to validate the word from user
    public void inputWordValidation(){
        
        char[] chRand = this.randomLetters.toCharArray();
        char[] ch1Input = this.wordP1.toUpperCase().toCharArray();
        char[] ch2Input = this.wordP2.toUpperCase().toCharArray();
        Set<Character> setchRand = new HashSet<Character>();
        Set<Character> setchInput = new HashSet<Character>();
        
        for (char x: chRand){
            setchRand.add(x);
        }
        for (char y:ch1Input){
            setchInput.add(y);
        }
        for (char z: ch2Input){
            setchInput.add(z);
        }
        
        setchRand.retainAll(setchInput);
        if(setchRand.containsAll(setchInput)){
            this.val = true;
        }else {
            this.val = false;
        }
        
    }
    //this method is used to check if the word from user is valid and is in the database 
    public void checkAns(){
        
        List<String> list = Arrays.asList(words);
        for(int i = 0; i<1; i++){
            if((list.contains(this.wordP1)) || (list.contains(this.wordP2)) && this.val == true){
                JOptionPane.showMessageDialog(null, "valid word");
            if (this.wordP1.length() > this.wordP2.length()){
            this.scoreP1++;
            this.calcLongWord1++;
            
        }   else {
            this.scoreP2++;
            this.calcLongWord2++;
            
        }   
            }else{
                JOptionPane.showMessageDialog(null, "word is not valid or does not match the database");
             
            }
        
        }   
      
    }
    //this method is used to calculate and show to players who has the longest word in each turn
    public void longestWord(){
         if (this.calcLongWord1 > this.calcLongWord2){
            JOptionPane.showMessageDialog(null, "Player 1 has the longest word!"); 
         }
         else if (this.calcLongWord1 < this.calcLongWord2){
            JOptionPane.showMessageDialog(null, "Player 2 has the longest word!"); 
         }else {
             
         }
        this.setCalcLongWord1(0);
        this.setCalcLongWord2(0);
    }
    //this method is used to apply the rules and move forward in the order of events
    public void calcGame(){
        
         this.inputRoundsValidation();
        do { 
        for (int i = 0; i<1; i++){
            // Player 1 turn to choose how many vowels will be player in that turn 
            JOptionPane.showMessageDialog(null, "<html><strong>Player 1</strong> it's your turn!</html>");
            this.inputVowValidation();
            this.random();
            this.wordP1 = JOptionPane.showInputDialog(null, "<html>The letters are:  " +this.randomLetters+  "<br><br><strong>Player 1</strong> enter a word</html>").toLowerCase();
            this.inputWordValidation();
            this.checkAns();
            this.setWordP1("");
            this.wordP2 = JOptionPane.showInputDialog(null, "<html>The letters are:  " +this.randomLetters+  "<br><br><strong>Player 2</strong> enter a word</html>").toLowerCase();
            this.inputWordValidation();
            this.checkAns();
            this.longestWord();
            this.setWordP2("");
            this.setConsonants("");
            this.setVowels("");
            
            // Player 2 turn to choose how many vowels will be player in that turn 
            JOptionPane.showMessageDialog(null, "<html><strong>Player 2</strong> it's your turn!</html>");
            this.inputVowValidation();
            this.random();
            this.wordP1 = JOptionPane.showInputDialog(null, "<html>The letters are:  " +this.randomLetters+  "<br><br><strong>Player 1</strong> enter a word</html>").toLowerCase();
            this.inputWordValidation();
            this.checkAns();
            this.setWordP1("");
            this.wordP2 = JOptionPane.showInputDialog(null, "<html>The letters are:  " +this.randomLetters+  "<br><br><strong>Player 2</strong> enter a word</html>").toLowerCase();
            this.inputWordValidation();
            this.checkAns();
            this.longestWord();
            this.setWordP2("");
            this.setConsonants("");
            this.setVowels("");
            
            
            this.rounds--;
            if(this.rounds >=1){
            JOptionPane.showMessageDialog(null, "Remaining rounds: " +this.rounds + "\nReady for the next round?");
            }
           
            
        }  
        }while(this.rounds >=1);
        if(this.scoreP1 > this.scoreP2){    // calculate and show to user the results of game
            JOptionPane.showMessageDialog(null, "the results: " + "\nPlayer 1 points: "+this.scoreP1 + "\nPlayer 2 points: "+this.scoreP2 +"\n\nPlayer 1 wins!!! Congratulations!");
            }else if (this.scoreP2 > this.scoreP1){
            JOptionPane.showMessageDialog(null, "the results: " + "\nPlayer 1 points: "+this.scoreP1 + "\nPlayer 2 points: "+this.scoreP2 +"\n\nPlayer 2 wins!!! Congratulations!"); 
            }else {
            JOptionPane.showMessageDialog(null, "the results: " + "\nPlayer 1 points: "+this.scoreP1 + "\nPlayer 2 points: "+this.scoreP2 +"\n\nDraw!!!");
           
            }
    } 
    
    //getters and setters methods
    public int getCalcLongWord1() {
        return calcLongWord1;
    }

    public void setCalcLongWord1(int calcLongWord1) {
        this.calcLongWord1 = calcLongWord1;
    }

    public int getCalcLongWord2() {
        return calcLongWord2;
    }

    public void setCalcLongWord2(int calcLongWord2) {    
        this.calcLongWord2 = calcLongWord2;
    }

    public boolean isVal() {
        return val;
    }

    public void setVal(boolean val) {
        this.val = val;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public String getVowels() {
        return vowels;
    }

    public void setVowels(String vowels) {
        this.vowels = vowels;
    }

    public String getConsonants() {
        return consonants;
    }

    public void setConsonants(String consonants) {
        this.consonants = consonants;
    }

    public int getInputVow() {
        return inputVow;
    }

    public void setInputVow(int inputVow) {
        this.inputVow = inputVow;
    }

    public int getLenVow() {
        return lenVow;
    }

    public void setLenVow(int lenVow) {
        this.lenVow = lenVow;
    }

    public int getLenCon() {
        return lenCon;
    }

    public void setLenCon(int lenCon) {
        this.lenCon = lenCon;
    }

    public String getRandomLetters() {
        return randomLetters;
    }

    public void setRandomLetters(String randomLetters) {
        this.randomLetters = randomLetters;
    }

    public String getWordP1() {
        return wordP1;
    }

    public void setWordP1(String wordP1) {
        this.wordP1 = wordP1;
    }

    public String getWordP2() {
        return wordP2;
    }

    public void setWordP2(String wordP2) {
        this.wordP2 = wordP2;
    }

    public int getScoreP1() {
        return scoreP1;
    }

    public void setScoreP1(int scoreP1) {
        this.scoreP1 = scoreP1;
    }

    public int getScoreP2() {
        return scoreP2;
    }

    public void setScoreP2(int scoreP2) {
        this.scoreP2 = scoreP2;
    }

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }
  
}
