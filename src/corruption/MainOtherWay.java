/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corruption;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Ilkin Abdullayev
 */
public class MainOtherWay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int percent = scanner.nextInt();

        List<Double> listAccount = new ArrayList<Double>();
        for (int i = 0; i < count; i++) {
            listAccount.add(scanner.nextDouble());
        }
        /////////////////////////////////////////////////////////       
        boolean loop = true;
        while (loop) {
            double a1 = Collections.min(listAccount);
            listAccount.remove(a1);
            double a2 = Collections.min(listAccount);
            listAccount.remove(a2);
            double result = (a1 + a2) * (100 - percent) / 100;
            result = Double.parseDouble(String.format(Locale.US, "%.2f\n", result));            
            listAccount.add(result);          

            if (listAccount.size() == 1) {
                loop = false;
            }
        }

        System.out.printf(Locale.US, "%.2f\n", listAccount.get(0));
    }

}
