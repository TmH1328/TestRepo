
package FPTManagment;

import java.util.Scanner;

interface Person{
    void inputPerson();
    void displayPerson();
}
interface Student{
    void inputInfo();
    void outputInfo();
    void find();
}
class Managent implements Person,Student{
    int age;
    int id;
    String name;
    @Override
    public void inputPerson(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Input a student's name:");
        name=sc.next();
        System.out.println("Input a student's age:");
        age=sc.nextInt();
    }
    @Override
    public void inputInfo(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Input a student's id");
        id=sc.nextInt();
    }
    @Override
    public void find(){
        
    }
}
public class StudentManagment {
    
}
