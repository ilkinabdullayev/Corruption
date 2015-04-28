/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corruption;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Corruption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String enteringLine1 = scanner.nextLine();

        int count = Integer.parseInt(enteringLine1.split(" ")[0]);
        int percent = Integer.parseInt(enteringLine1.split(" ")[1]);

        String enteringLine2 = scanner.nextLine();

        List<Double> listAccount = new ArrayList<Double>();

        String nums[] = enteringLine2.split(" ");
        for (int index = 0; index < nums.length; index++) {
            listAccount.add(Double.parseDouble(nums[index]));
        }

        rekur(listAccount, percent);

        System.out.println(listAccount.get(0));

        //100000
//        Random r = new Random();
//     
//        for (int i = 0; i < 1000; i++) {
//            int randomInt = r.nextInt(1000) + 1;
//           // System.out.println(i);
//           // System.out.println(randomInt);
//            System.out.println(randomInt);
//
//        }

      

    }

    public static void rekur(List<Double> listAccount, int percent) {
        if (listAccount.size() == 1) {
            return;
        }
        double e=(double)((100 - percent) / 100);
        System.out.println((double)e);
        double result = (listAccount.get(0) + listAccount.get(1)) * (100 - percent) / 100;
        listAccount.set(0, result);
        listAccount.remove(1);

        Collections.sort(listAccount);

        rekur(listAccount, percent);
    }

}
