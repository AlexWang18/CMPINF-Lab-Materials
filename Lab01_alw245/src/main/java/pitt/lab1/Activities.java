/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pitt.lab1;

import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 *
 * @author alexw
 */
public class Activities {
    public static void main(String[] args) {
        /*
         *
         * ACTIVITY 1
         *
         */
        int ASCII_code = 113; // code for the letter "q"
        char q = 113;
        double fraction = .75; // aka 3/4
        String firstName = "Alex";
        boolean isEmpty = true; // whether a data structure has any elements in it
        Object[] variables = { ASCII_code, q, fraction, firstName, isEmpty, }; // autoboxing the primitives
        for (Object var : variables) {
            System.out.println(var);
        }

        int radius = 5;
        System.out.println(getVolumeSphere(radius));

        /*
         *
         * ACTIVITY 4
         *
         */
        int age = 22;
        if (age == 21)
            System.out.println("the age is equal to 21");
        else
            System.out.println("the age is NOT equal to 21");

        /*
         *
         * ACTIVITY 5
         *
         */
        double dub = 10.0;
        if (dub >= 9.95 && dub <= 10.05)
            System.out.println("the double is equal to 10.0");
        else
            System.out.println("the double is NOT equal to 10.0");

        /*
         *
         * ACTIVITY 7
         *
         */
        /*
         * for (double angle = -180; angle <= 180; angle++) { System.out.println(angle +
         * "    " + Math.sin(angle * Math.PI / 180)); }
         */

        /*
         *
         * ACTIVITY 8
         *
         */
        String[] names = { "Charlie", "Bill", "Jim", "Jeffrey", "Charzard" };
        for (String string : names) {
            System.out.println(string);
        }

        System.out.println("Enter a num btw 10 and 20");
        try (Scanner sc = new Scanner(System.in)) {
            int input = Integer.parseInt(sc.nextLine());
            while (!(input >= 10 && input <= 20)) {
                System.out.println("Bad input, enter number between 10 and 20");
                input = Integer.parseInt(sc.nextLine());
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        /*
         *
         * ACTIVITY 9
         *
         */

        radius = Integer.parseInt(JOptionPane.showInputDialog("What is the radius of the sphere?"));
        JOptionPane.showMessageDialog(null, String.valueOf(getVolumeSphere(radius)));

        /*
         *
         * ACTIVITY 10
         *
         */
        try(Scanner sc = new Scanner(System.in)) {
            String str = sc.nextLine();
            int tempInF = Integer.parseInt(str);
            if (tempInF < 40) 
                System.out.println("Its brick out here");
            else if (tempInF <= 60)
                System.out.println("It is ok");
            else
                System.out.println("it is hot"); 
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /*
     *
     * ACTIVITY 3
     *
     */
    public static double getVolumeSphere(int radius) {
        return 4 * Math.PI * Math.pow(radius, 3) / 3;
    }

    /*
     *
     * ACTIVITY 2
     *
     */
    public static Time convertSeconds(int elapsed) {
        int hours = elapsed / 3600;
        elapsed = elapsed - (hours * 3600);
        int minutes = elapsed / 60;
        int seconds = elapsed - (minutes * 60);
        return new Time(hours, minutes, seconds);
    }

    private static class Time {
        int hours;
        int minutes;
        int seconds;

        Time(int h, int m, int s) {
            this.hours = h;
            this.minutes = m;
            this.seconds = s;
        }
    }
}
