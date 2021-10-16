package dvdlibrary.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO{

    Scanner input = new Scanner(System.in);

    public void print(String message){
        System.out.println(message);
    }

    public String readString(String prompt){
        Scanner userInput = new Scanner(System.in);
        System.out.println(prompt);
        String response = userInput.nextLine();
        return response;
    }

    public LocalDate readDate(String prompt) {
        System.out.println(prompt);
        LocalDate date = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return date;
    }

    public int readInt(String prompt){
        System.out.println(prompt);
        return input.nextInt();
    }

    public int readInt(String prompt, int min, int max){
        int num = 0;
        Boolean valid = false;
        while (!valid){
            System.out.println(prompt);
            num = input.nextInt();
            if (num<min || num >max){
                System.out.println("Number out of range! Try again.");
            } else{
                valid = true;
            }
        }
        return num;

    }

    public double readDouble(String prompt) {
        System.out.println(prompt);
        return input.nextDouble();
    }

    public double readDouble(String prompt, double min, double max) {
        double num = 0;
        Boolean valid = false;
        while (!valid){
            System.out.println(prompt);
            num = input.nextDouble();
            if (num<min || num >max){
                System.out.println("Number out of range! Try again.");
            } else{
                valid = true;
            }
        }
        return num;
    }

    public float readFloat(String prompt) {
        System.out.println(prompt);
        return input.nextFloat();
    }

    public float readFloat(String prompt, float min, float max) {
        float num = 0;
        Boolean valid = false;
        while (!valid){
            System.out.println(prompt);
            num = input.nextFloat();
            if (num<min || num >max){
                System.out.println("Number out of range! Try again.");
            } else{
                valid = true;
            }
        }
        return num;
    }

    public long readLong(String prompt) {
        System.out.println(prompt);
        return input.nextLong();
    }

    public long readLong(String prompt, long min, long max) {
        long num = 0;
        Boolean valid = false;
        while (!valid){
            System.out.println(prompt);
            num = input.nextLong();
            if (num<min || num >max){
                System.out.println("Number out of range! Try again.");
            } else{
                valid = true;
            }
        }
        return num;
    }

}
