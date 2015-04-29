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
public class Main {

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

        Collections.sort(listAccount);
        /////////////////////////////////////////////////////////
        int listSize = listAccount.size();
        for (int i = 0; i < listSize; i++) {
            if(listSize==1)break;
            double result = (listAccount.get(0) + listAccount.get(1)) * (100 - percent) / 100;          
            result = Double.parseDouble(String.format(Locale.US, "%.2f\n", result));
            listAccount.set(0, result);
            listAccount.remove(1);
            i=-1;
            listSize=listAccount.size();
            Collections.sort(listAccount);
        }

        System.out.printf(Locale.US, "%.2f\n", listAccount.get(0));
    }

}
