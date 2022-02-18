/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestResourceBundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Bi
 */
public class Test {

    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle bundle;
    public static void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle("Language/language", locale);
    }

    public static void main(String[] args) throws IOException {
        
        Locale localeEn = new Locale("en", "US");
        setLocale(localeEn);
        
        System.out.println(bundle.getString("hello"));

    }
}
