/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corruption;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Ilkin Abdullayev
 */
public class MainArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int percent = scanner.nextInt();

        double[] listAccount = new double[count];
        for (int i = 0; i < count; i++) {
            listAccount[i] = scanner.nextDouble();
        }

        Arrays.sort(listAccount);
        /////////////////////////////////////////////////////////       
        boolean loop = true;
        while (loop) {
            double result = (listAccount[0] + listAccount[1]) * (100 - percent) / 100;
            result = Double.parseDouble(String.format(Locale.US, "%.2f\n", result));

            double d[] = new double[1];
            d[0] = result;

            listAccount = Arrays.copyOfRange(listAccount, 2, listAccount.length);
            listAccount = combine(d, listAccount);

            Arrays.sort(listAccount);
            
            if (listAccount.length == 1) {
                loop = false;
            }
        }

        System.out.printf(Locale.US, "%.2f\n", listAccount[0]);
    }

    public static double[] combine(double[] a, double[] b) {
        int length = a.length + b.length;
        double[] result = new double[length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

}
