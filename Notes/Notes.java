/*
COMMANDS:
Run input file and output to custom file:
    java javaFile < inputFile > outputFile
    ex. java Assignment1 < input1.txt > myout1.txt
    * outputFile is created upon command

Compare two files:
    diff file1 file2
    ex. diff myout1.txt output1.txt
    * if there is no message, the files are identical
*/

public class Notes {
  public static void main(String[] args) {
    String line = "http:/www.zak/photography";
    line.split("/"); //splits array up at delimeter (/) and returns the values in an array
    //["http:", "www.zak", "photography"];
    
    // primitive data types hold the actual value, object references store the address to the value
    // two or more references that refer to the same object are called aliases
    
    //JFX
    // label is like a CLI prompt, whenever you have a button, include a label
    
    // System.out.println("a".compareTo("b"));
  }
}