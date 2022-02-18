package DTO;

import java.util.Scanner;

public class Item {

    protected int value;
    protected String creator;

    public Item() {
    }

    public Item(int value, String creator) {
        this.value = value;
        this.creator = creator;
    }

    public int getValue() {
        return value;
    }

    public String getCreator() {
        return creator;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void output() {
        System.out.println("Value : " + value);
        System.out.println("Creator : " + creator);
    }

    public void input() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input a value :");
        value = sc.nextInt();
        sc = new Scanner(System.in);
        System.out.println("Input the creator :");
        creator = sc.nextLine();
    }

}
