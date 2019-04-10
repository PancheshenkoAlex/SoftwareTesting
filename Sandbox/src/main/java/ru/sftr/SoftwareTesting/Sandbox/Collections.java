package ru.sftr.SoftwareTesting.Sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
    public static void main(String[] args) {


        String[] langs1 = {"Java", "C#", "Python", "PHP"};
        List<String> langs2 = new ArrayList<String>();
        langs2.add("Java");
        langs2.add("C#");
        langs2.add("Puthon");
        List<String> langs3 = Arrays.asList("Java", "C#", "Python", "PHP");

        for (String l : langs1) {
            System.out.println("Я хочу выучить " + l);
        }

        for (String l : langs2) {
            System.out.println("Я хочу выучить " + l);
        }

        for (String l : langs3) {
            System.out.println("Я хочу выучить " + l);
        }
    }
}
