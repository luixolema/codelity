import solutions.Lesson1;
import solutions.Lesson2;
import solutions.Lesson3;
import solutions.Lesson4;

public class Main {

    public static void main(String[] args) {
        Solutions solutions = new Solutions();
        Lesson1 lesson1 = new Lesson1();
        Lesson2 lesson2 = new Lesson2();
        Lesson3 lesson3 = new Lesson3();
        Lesson4 lesson4 = new Lesson4();

        int[] a = {3,4,4,6,1,4,4};
        int[] b = {};

        System.out.println(lesson4.MaxCounters(5, a));
    }
}
