/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bi
 */
public class Accounts {
    private String accountNumber;
    private String password;

    public Accounts() {
    }

    public Accounts(String accountNumber, String password) {
        this.accountNumber = accountNumber;
        this.password = password;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
