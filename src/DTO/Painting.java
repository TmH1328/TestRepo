
package DTO;

import java.util.Scanner;

public class Painting extends Item {
    int height;
    int width;
    boolean isWatercolour;
    boolean isFramed;

    public Painting() {
        super();
    }

    public Painting(int height, int width, boolean isWatercolour, boolean isFramed, int value, String creator) {
        super(value, creator);
        this.height = height;
        this.width = width;
        this.isWatercolour = isWatercolour;
        this.isFramed = isFramed;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean isIsWatercolour() {
        return isWatercolour;
    }

    public boolean isIsFramed() {
        return isFramed;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setIsWatercolour(boolean isWatercolour) {
        this.isWatercolour = isWatercolour;
    }

    public void setIsFramed(boolean isFramed) {
        this.isFramed = isFramed;
    }
    public void outputPainting(){
        output();
        System.out.println("Height : "+height);
        System.out.println("Width : "+width);
        System.out.println("Is it Watercolour : "+isWatercolour);
        System.out.println("Is it Framed : "+isFramed);
    }
    public void inputPainting(){
        input();
        Scanner sc=new Scanner(System.in);
        System.out.println("Input a height : ");
        height=sc.nextInt();
        width=sc.nextInt();
        isWatercolour=sc.nextBoolean();
        isFramed=sc.nextBoolean();
    }
}
