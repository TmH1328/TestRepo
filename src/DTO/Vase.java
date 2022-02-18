package DTO;

import java.util.Scanner;

public class Vase extends Item {

    int height;
    String material;

    public Vase() {
        super();
    }

    public Vase(int height, String material, int value, String creator) {
        super(value, creator);
        this.height = height;
        this.material = material;
    }

    public int getHeight() {
        return height;
    }

    public String getMaterial() {
        return material;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void outputVase() {
        output();
        System.out.println("Height : " + height);
        System.out.println("Material : " + material);
    }

    public void inputVase() {
        Scanner sc = new Scanner(System.in);
        input();
        System.out.println("Input a height : ");
        height = sc.nextInt();
        sc = new Scanner(System.in);
        System.out.println("Input a material : ");
        material = sc.nextLine();
    }

}
