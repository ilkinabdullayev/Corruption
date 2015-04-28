/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corruption;

import java.text.DecimalFormat;
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
            listAccount.add((double) scanner.nextDouble());
        }
        
        Collections.sort(listAccount);
        /////////////////////////////////////////////////////////
        Main main=new Main();
        main.rekur(listAccount, percent);
    
        System.out.printf(Locale.US, "%.2f\n",listAccount.get(0));
    }

    public void rekur(List<Double> listAccount, int percent) {
        if (listAccount.size() == 1) {
            return;
        }
        
        double result = (listAccount.get(0) + listAccount.get(1)) * (100 - percent) / 100;
        listAccount.set(0, result);
        listAccount.remove(1);

        Collections.sort(listAccount);

        rekur(listAccount, percent);
    }

}
