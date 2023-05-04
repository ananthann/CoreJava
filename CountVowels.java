import java.io.*;
import java.util.*;

public class CountVowels {
    int count=0;
    String sentence;
        public String readTextFile() throws IOException {
            try {
                String filename = "/home/xminds/Documents/Fix/src/Sentence.txt";
                File myObj = null;
                if (filename.endsWith(".txt"))
                {
                    myObj = new File(filename);
                }
                else {
                    System.out.println("Not a text file");
                }

                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    sentence += myReader.nextLine();
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
                e.printStackTrace();
            }
            sentence=sentence.substring(4);
            System.out.println(sentence);
            System.out.println("data length="+sentence.length());
            return sentence;
        }


    List<Character> charaList=new ArrayList<>();
    List<Character> vowels=new ArrayList<>();
    Map<Integer,Character>characterMap=new HashMap<Integer,Character>();

    public void printAllVowels(String sentenc) {
        char sent[] = new char[sentence.length()];
        sent = sentenc.toCharArray();
        System.out.println("The vowels present are : ");
        for(int i=0;i<sentenc.length();i++)
        {
            charaList.add(sent[i]);
        }
        if (charaList.contains('a')) System.out.print("a,");
        if (charaList.contains('e')) System.out.print(" e,");
        if (charaList.contains('i')) System.out.print(" i,");
        if (charaList.contains('o')) System.out.print(" o,");
        if (charaList.contains('u')) System.out.print(" u");
    }
    public void countOccurenceOfVowels(String sentence){
        System.out.println();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.forEach(vowel->{
            count=0;
        charaList.forEach(element->{
           if (element.equals(vowel)) count++;
        });
            System.out.println("No: of "+vowel+" is "+count);
        });
    }
    public void countOccuranceOfLetters(String sentence){
        TreeSet<Character> characterTreeSet=new TreeSet<>();
        charaList.forEach(leter->{characterTreeSet.add(leter);});
        characterTreeSet.forEach(letter->{
            count=0;
            charaList.forEach(element->{
                if (element.equals(letter)) count++;
            });
            if (letter.equals(' ')) System.out.println("No: of spaces is "+count);
            else System.out.println("No: of "+letter+" is "+count);
        });
    }
    public void printPositionOfAllVowels(String sentence){
        count=0;
        charaList.forEach(leter->{characterMap.put(count,leter);
        count++;});
        vowels.forEach(vowel->{
            System.out.print("The positions of "+vowel+" is ");
            characterMap.forEach((key,value)->{
                if (value.equals(vowel)) System.out.print(key+",");
            });
            System.out.println();
        });
    }
    public void lettersBetweenEachTwoVowel(String sentence){
        List<Integer> posiions=new ArrayList<Integer>();
        System.out.println("The letters between each vowel is ");
         characterMap.forEach((key,value)->{
             if (value.equals('a')||value.equals('e')||value.equals('i')
             ||value.equals('o')||value.equals('u'))
                 posiions.add(key);
         });
         for(int i=0;i<posiions.size();i++){
           if(i+1<89)  System.out.print((posiions.get(i+1)- posiions.get(i)-1)+", ");
         }
    }


    public static void main(String args[]) throws IOException {
       CountVowels cv1=new CountVowels();
        String sentence=cv1.readTextFile();
//       cv1.printAllVowels(sentence);
//       cv1.countOccurenceOfVowels(sentence);
//       cv1.countOccuranceOfLetters(sentence);
//       cv1.printPositionOfAllVowels(sentence);
//       cv1.lettersBetweenEachTwoVowel(sentence);
    }
}
