

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Characters class
 * [a-z] -> only small alphabets
 * [A-Z] -> only capital alphabets
 * [0-9] -> only numbers
 * [^abc] -> not a,b,c (it will include numbers, space and other letters
 * ----
 * Predefined Character class
 * "\\D" -> \D = [A-Z] and [a-z] also special characters
 * "\\d" -> \d = [0-9] only numbers
 * "\\w" -> \w = alphanumeric without special character
 * "\\W" -> \W = only special character
 * "\\s" -> \s = only space
 * "\\S" -> \S = anything other that space
 * ----
 * Quantifier - (min,max),(min),?,*,+
 * "\\w{min,max}" -> "\\w{4,10}" - matches should have minimum 4 to maximum 10 alphanumeric value
 * "\\w{min}" ->"\\w{4}" - matches should have minimum 4 to maximum anything alphanumeric value
 * "\\w?" -> matching every index value | 0 or 1 time , for special char it return index with empty value
 * "\\w*" -> matching whole alphanumeric section as one set at a time, for special char it return index with empty value
 * "\\w+" -> matching 1 or more time alphanumeric, not special char allowed, not space
 * ----
 * Anchors - ^,$,\b,\B
 * String s= "word world my word";
 * "^word" -> staring for the string index will be return 0
 * "word$" -> ending of the string index will be return 14
 * "\\bword" -> return start index of the word which is present in start or end of the string , 0
 * "\\Bword" -> return starting index of the non boundary words in the string
 * ----
 * Group and capturing - ()
 * Alternation - |
 * Lookahead - positive (=), negative(!)
 * Lookbehind - positive (=), negative(!)
 */

public class Demo5 {
    public static void main(String[] arg){
        //Pattern - regular expression
        String text = "apple banana carrot";
        String reg_ex = "[abc]"; // bca/cab,acb

        Pattern pattern = Pattern.compile(reg_ex); // to compile the regular expression
        Matcher matcher = pattern.matcher(text); // checking the compiled regular expression with given string

        while (matcher.find()){
            System.out.println("Found : "+matcher.group() + " at position "+matcher.start());
        }
//        Found : a at position 0
//        Found : b at position 6
//        Found : a at position 7
//        Found : a at position 9
//        Found : a at position 11
//        Found : c at position 13
//        Found : a at position 14

        System.out.println("-----------------");

        String s= "word world my word";
        String reg_ex1 = "word$";

        Pattern pattern1 = Pattern.compile(reg_ex1); // to compile the regular expression
        Matcher matcher1 = pattern1.matcher(s); // checking the compiled regular expression with given string

        while (matcher1.find()){
            System.out.println("Found : "+matcher1.group() + " at position "+matcher1.start()); //14
        }

        System.out.println("-----------------");

        String name = "sangeetha murugan, sasi murugan";
        String re = "(\\w+) (\\w+)";

        Pattern p=Pattern.compile(re);
        Matcher matcher2 = p.matcher(name);

        while (matcher2.find()){
            System.out.println("found: "+matcher2.group()+" at position "+matcher2.start());
            System.out.println("first name: "+matcher2.group(1)+" at position "+matcher2.start());
            System.out.println("Last name: "+matcher2.group(2)+" at position "+matcher2.start());
        }

        System.out.println("-----------------");

        String unit = "10px 20em 12px 30rem";
       // String re1 = "\\dpx"; // found: 0px at position 1, found: 2px at position 11
       // String re1 = "\\d{2}px"; // found: 10px at position 1, found: 12px at position 11
        String re1 = "\\d{2}(?=px)"; // lookahead: found: 10 at position 0 , found: 12 at position 10
        Pattern p1=Pattern.compile(re1);
        Matcher matcher3 = p1.matcher(unit);

        while (matcher3.find()){
            System.out.println("found: "+matcher3.group()+" at position "+matcher3.start());
        }

        System.out.println("-----------------");

        String email = "sangeetha.murugan@gmail.com";
        String regexp = "^([A-Za-z0-9.%_+-]{3,})@([A-Za-z]{3,})\\.([A-Za-z]{2,})$"; // ^[A_Za-z0-9.%_+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$

        Pattern ep = Pattern.compile(regexp);
        Matcher em = ep.matcher(email);

        while (em.find()){
            System.out.println("Found at : "+ em.group()+" at position "+em.start());
        }
    }
}
