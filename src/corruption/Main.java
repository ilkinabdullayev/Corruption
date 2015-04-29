/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corruption;

import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Ilkin Abdullayev
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int percent = scanner.nextInt();

        Queue<Double> listAccount = new PriorityQueue<Double>();
        for (int i = 0; i < count; i++) {
            listAccount.add(scanner.nextDouble());
        }
        /////////////////////////////////////////////////////////      
        while (listAccount.size() != 1) {
            double a1 = listAccount.poll();
            double a2 = listAccount.poll();

            double result = (a1 + a2) * (100 - percent) / 100;
            result = Double.parseDouble(String.format(Locale.US, "%.2f\n", result));
            listAccount.add(result);
        }

        System.out.printf(Locale.US, "%.2f\n", listAccount.poll());
    }

}
