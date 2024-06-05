package org.alxtek.locaiai;

public class Test {
    public static void main(String[] args) {
        String c = "a";
        int roc  = 0;
        if (c == "a"  && roc == 0) {
            System.out.println("No action");
        } else if ((c == "a" || c == "b") && roc < 4) {
            System.out.println("Low action priority");
        } else if (c == "d" || c == "e" || roc >= 7) {
            System.out.println("Urgent action");
        }  else {
            System.out.println("Higher action priority");
        }
    }
}
