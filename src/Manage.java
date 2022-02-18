
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Random;
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
public class Manage {

    private static ResourceBundle bundle;

    public static ArrayList<Accounts> mockAccount() {
        String accNum1 = "0123456789";
        String pass1 = "123456ab";
        Accounts account1 = new Accounts(accNum1, pass1);
        String accNum2 = "1212121212";
        String pass2 = "234567abcd";
        Accounts account2 = new Accounts(accNum2, pass2);
        String accNum3 = "1231231234";
        String pass3 = "abcde123456";
        Accounts account3 = new Accounts(accNum3, pass3);
        ArrayList<Accounts> accounts = new ArrayList<>();
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        return accounts;
    }

    public static void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle("Language/language", locale);
    }

    public static void displayMenu() {
        System.out.println("Login function of Ebank system includes:");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
    }

    public static void login(Locale locale) throws IOException {
        setLocale(locale);
        ArrayList<Accounts> accounts = mockAccount();
        String account = Input.getAccount(bundle.getString("account"), bundle.getString("ac.inputError"), bundle.getString("ac.empty"));
        String password = Input.getPassword(bundle.getString("password"), bundle.getString("ps.inputError"), bundle.getString("ps.empty"));
        if (!checkAccNumExist(accounts, account)) {
            System.out.println(bundle.getString("ac.notexist"));
            System.out.println(bundle.getString("login.fail"));
            System.out.println("");
            return;
        }
        if (checkLogin(accounts, account, password)) {
            while (true) {
                String captcha = generateCaptcha();
                System.out.println("Captcha: " + captcha);
                String inputCaptcha = Input.getCaptcha(bundle.getString("captcha"), bundle.getString("captcha.empty"));
                if (inputCaptcha.equals(captcha)) {
                    System.out.println(bundle.getString("login.done"));
                    System.out.println("");
                    break;
                } else {
                    System.out.println(bundle.getString("captcha.wrong"));
                }
            }
        } else {
            System.out.println(bundle.getString("login.fail"));
            System.out.println("");
        }
    }

    public static String generateCaptcha() {
        String symbolsInCaptcha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "1234567890" + "abcdefghijklmnopqrstuvwxyz";
        Random rand = new Random();

        while (true) {
            StringBuilder capcha = new StringBuilder(5);
            //loop 5 times to get 5 character from symbolsInCaptcha
            for (int i = 0; i < 5; i++) {
                int index = rand.nextInt(symbolsInCaptcha.length());
                capcha.append(symbolsInCaptcha.charAt(index));
            }
            String finalCaptcha = capcha.toString();
            //every character from a-z A-Z
            Pattern patternChar = Pattern.compile("[a-z]");
            //every character from A-Z
            Pattern patternCap = Pattern.compile("[A-Z]");
            //every character from 0-9
            Pattern patternNum = Pattern.compile("[0-9]");
            Matcher matcherChar = patternChar.matcher(finalCaptcha);
            Matcher matcherCap = patternCap.matcher(finalCaptcha);
            Matcher matcherNum = patternNum.matcher(finalCaptcha);
            boolean checkPatternChar = matcherChar.find();
            boolean checkPatternCap = matcherCap.find();
            boolean checkPatternNum = matcherNum.find();
            if (checkPatternChar && checkPatternCap && checkPatternNum) {
                return finalCaptcha;
            }
        }
    }

    public static boolean checkLogin(ArrayList<Accounts> acc, String accNum, String pass) {
        //loop through each element in acc arraylist 
        for (int i = 0; i < acc.size(); i++) {
            Accounts curAcc = acc.get(i);
            String curAccNum = curAcc.getAccountNumber();
            String curAccPass = curAcc.getPassword();
            if (curAccNum.equals(accNum)) {
                if (curAccPass.equals(pass)) {
                    return true;
                } else {
                    System.out.println(bundle.getString("login.error"));
                    return false;
                }
            }
        }
        System.out.println(bundle.getString("login.error"));
        return false;
    }

    public static boolean checkAccNumExist(ArrayList<Accounts> acc, String accNum) {
        //loop through each element in acc arraylist 
        for (int i = 0; i < acc.size(); i++) {
            Accounts curAcc = acc.get(i);
            String curAccNum = curAcc.getAccountNumber();
            if (curAccNum.equals(accNum)) {
                return true;
            }
        }
        return false;
    }
}
