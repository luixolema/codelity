import solutions.*;

public class Main {

    public static void main(String[] args) {
        Solutions solutions = new Solutions();
        Lesson1 lesson1 = new Lesson1();
        Lesson2 lesson2 = new Lesson2();
        Lesson3 lesson3 = new Lesson3();
        Lesson4 lesson4 = new Lesson4();
        Lesson5 lesson5 = new Lesson5();

        int[] a = {1, 1, 8, 1, 8, 1};
        int[] b = {4, 5, 6};


        System.out.println(lesson5.MinAvgTwoSlice(a));
    }
}
