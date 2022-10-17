package Java_1017;

import java.util.Scanner;

public class Star {
    String icon = "*";

    Star() {

    }

    Star(String icon) {
        this.icon = icon;
    }

    public void StarN(int N) {


        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(this.icon);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
/*        Scanner sc = new Scanner(System.in);
        Star star = new Star();

        System.out.println("별의 층을 적으시오 >>");
        int N = sc.nextInt();*/
/*        for (int i = 0; i <= 3; i++) {
            for (int j = 3 - i; j >= 0; j--) {
                System.out.print(" ");

            }
            for (int z = 0; z <= 2 * i; z++) {
                System.out.print("*");
            }
            System.out.println();


        }*/
    }

}
