package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
// В качестве сувениров на соревновании по программированию было решено вручить футболки.
// Всего в типографии были напечатаны футболки шести размеров: S, M, L, XL, XXL, XXXL (размеры перечислены в порядке возрастания).
// Для каждого размера от S до XXXL вам известно количество футболок такого размера.
//
// Во время регистрации организаторы попросили каждого из n участников указать размер футболки.
// Если участник колебался между двумя размерами, то он мог указать два соседних — это означает, что ему подойдет футболка любого из двух размеров.
//
//Напишите программу, которая определит, возможно ли из напечатанных в типографии футболок сделать подарок каждому участнику соревнования.
// Конечно, каждому участнику должна достаться футболка его размера:
//
//требуемого размера, если указан один размер;
//любого из двух размеров, если указаны два соседних размера.
//В случае положительного ответа программа должна найти любой из вариантов раздачи футболок.
        Scanner in = new Scanner(System.in);
        Map<String, Integer> sizes = new HashMap<>();
        sizes.put("S", in.nextInt());
        sizes.put("M", in.nextInt());
        sizes.put("L", in.nextInt());
        sizes.put("XL", in.nextInt());
        sizes.put("XXL", in.nextInt());
        sizes.put("XXXL", in.nextInt());
        System.out.println("Количество футболок поразмерно: " + sizes);
//         1.Раздать футболки с указанием одного размера
//         2.Раздать футболки с указанием двух размеров
        int numbersPeople = in.nextInt();
        in.nextLine();
        String[][] peopleAndTheirSizes = new String[numbersPeople][];
        for (int i = 0; i < numbersPeople; i++) {
            peopleAndTheirSizes[i] = in.nextLine().split(",");
        }
        for (int i = 0; i < numbersPeople; i++) {
            System.out.println(Arrays.toString(peopleAndTheirSizes[i]));
        }
        boolean[] result = new boolean[numbersPeople];
        for (int i = 0; i < peopleAndTheirSizes.length; i++) {
            if (peopleAndTheirSizes[i].length == 1) {
                int amount = sizes.get(peopleAndTheirSizes[i][0]);
                if (amount > 0) {
                    result[i] = true;
                    sizes.put(peopleAndTheirSizes[i][0], amount - 1);
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        for (int i = 0; i < peopleAndTheirSizes.length; i++) {
            if (peopleAndTheirSizes[i].length == 2) {
                int amount = sizes.get(peopleAndTheirSizes[i][0]);
                if (amount > 0) {
                    result[i] = true;
                    sizes.put(peopleAndTheirSizes[i][0], amount - 1);
                } else {
                    amount = sizes.get(peopleAndTheirSizes[i][1]);
                    if (amount > 0) {
                        result[i] = true;
                        sizes.put(peopleAndTheirSizes[i][1], amount - 1);
                    } else {
                        System.out.println("NO");
                        return;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(result));


//        for (int i = 0; i < peopleAndTheirSizes.length; i++) {
//            for (int j = 0; j < peopleAndTheirSizes[i].length; j++) {
//                if (sizes.containsKey("S") == peopleAndTheirSizes[i][j])
//
//            }

    }

}