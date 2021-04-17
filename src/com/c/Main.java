package com.c;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Mazhey Polina
 */
public class Main {
   public static Circle[] circles;
   public static int[] types;
   public static int n;
   public static void AreaOfACircle(){
        for(int i = 0; i < n; i++){
            System.out.println(circles[i].toString());
            circles[i].S = (3.14) *circles[i].getR()*circles[i].getR();
            System.out.println("Площадь круга: " + circles[i].S);
        }
    }
    public static void PerimeterOfACircle(){
        for(int i = 0; i < n; i++){
            System.out.println(circles[i].toString());
            circles[i].P = 2*3.14*circles[i].getR();
            System.out.println("Периметр круга: " + circles[i].P);
        }
    }
    public static void max_min(Scanner in){
        double max = circles[0].R;
        int maxi = 0;
        for(int i = 1; i < n; i++) {
            if (circles[i].R > max) {
                max = circles[i].R;
                maxi = i;
            }
        }
        System.out.println("Наибольший периметр и площадь: " + circles[maxi].toString());

        double min = 0;
        int mini = 0;
        for(int i = 0; i < n; i++) {
            if (circles[i].R < min) {
                min = circles[i].R;
                mini = i;
            }
        }
        System.out.println("Наименьший периметр и площадь: " + circles[mini].toString() );


    }
    public static void GroupOfCircle(){
        // System.out.println("группы");
        double X, Y;
        for (int i = 0; i < n - 2; i++){
            for (int j = i + 1 ; j < n - 1; j++){
                System.out.println("Центры данных окружностей лежат на одной прямой:");
                System.out.println(circles[i].toString());
                System.out.println(circles[j].toString());
                for (int k = j + 1; k < n; k++){
                    X = (circles[k].getX() - circles[i].getX())*(circles[j].getY() - circles[i].getY());
                    Y = (circles[k].getY() - circles[i].getY())*(circles[j].getX() - circles[i].getX());
                    if (X == Y){
                        System.out.println(circles[k].toString());
                    }

                }
            }
            if (n != 3){
                System.out.println("Центры данных окружностей лежат на одной прямой:");
                System.out.println(circles[i].toString());
                System.out.println(circles[i+2].toString());
            }
        }
        if(n == 3){
            System.out.println("Центры данных окружностей лежат на одной прямой:");
            System.out.println(circles[0].toString());
            System.out.println(circles[2].toString());
        }


    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        System.out.println("Введите количество окружностей: ");
        n = in.nextInt();
        circles = new Circle[n];
        types = new int[n];
        System.out.println("Введите координаты центра окружности и ее радиус");
        for (int i = 0; i < n; i++){
            circles[i] = new Circle();
            types[i] = i;
            System.out.println(i + 1 +" окружность:");
            System.out.print("x = ");
            circles[i].setX(in.nextInt());
            System.out.print("y = ");
            circles[i].setY(in.nextInt());
            System.out.print("R = ");
            circles[i].setR(in.nextInt());
        }
        boolean flag = true;
        int choice;
        while(flag){
            System.out.println("""
                    0.Выход
                    1.Площадь
                    2.Периметр
                    3.Наибольший и наименьший по площади объект
                    4.Группы окружностей, центры которых лежат на одной прямой
                    """);
            choice =in.nextInt();
            switch (choice){
                case 0 -> flag = false;
                case 1 -> AreaOfACircle();
                case 2 -> PerimeterOfACircle();
                case 3 -> max_min(in);
                case 4 -> GroupOfCircle();
            }
        }
    }
}
