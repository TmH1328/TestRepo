
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bi
 */
public class Input {

    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int getOption() throws IOException {
        //loop until correct
        while (true) {
            try {
                int option = Integer.parseInt(br.readLine().trim());
                if (option < 1 || option > 3) {
                    System.err.println("Option must be in range of 1 to 3");
                    System.out.print("Enter again: ");

                } else if (option > 0 && option < 4) {
                    return option;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.err.println("Option must be integer");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String getAccount(String account,String msg, String empty) throws IOException {
        //loop until correct
        while (true) {
            System.out.print(account);
            String acc = br.readLine().trim();
            //every character different from 0-9
            Pattern pattern = Pattern.compile("[^0-9]");
            Matcher matcher = pattern.matcher(acc);
            boolean checkPattern = matcher.find();
            if (acc.isEmpty()) {
                System.err.println(empty);
            } else if (checkPattern) {
                System.err.println(msg);
            } else if (acc.length() != 10) {
                System.err.println(msg);
            } else {
                return acc;
            }
        }
    }

    public static String getPassword(String password, String msg, String empty) throws IOException {
        //loop until correct
        while (true) {
            System.out.print(password);
            String pass = br.readLine().trim();
            //every character from a-z A-Z
            Pattern patternChar = Pattern.compile("[a-zA-Z]");
            //every character from 0-9
            Pattern patternNum = Pattern.compile("[0-9]");
            Matcher matcherChar = patternChar.matcher(pass);
            Matcher matcherNum = patternNum.matcher(pass);
            boolean checkPatternChar = matcherChar.find();
            boolean checkPatternNum = matcherNum.find();
            if (pass.isEmpty()) {
                System.err.println(empty);
            } else if (!checkPatternChar || !checkPatternNum) {
                System.err.println(msg);
            } else if (pass.length()<8||password.length()>31) {
                System.err.println(msg);
            } else {
                return pass;
            }
        }
    }
    
     public static String getCaptcha(String capcha, String empty) throws IOException {
        // loop until if condition is met
        while (true) {
                System.out.print(capcha);
                String str = br.readLine();
                if (str.isEmpty()) {
                    System.out.println(empty);
                } else {
                    return str;
                }           
        }
    }
}
