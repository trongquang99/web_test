package study.com.webtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class MainBaseJava {
    public static void main(String[] args) {
//        Integer a = 5;
//        Integer b = 10;
//        Double kq = Double.parseDouble(String.valueOf(a*b));
//        System.out.println(kq);
////        String a = String.valueOf()
//
//        int e = 15;
//        byte f = (byte) e;
//        System.out.println(e);
//        System.out.println(f);

//        int number = 25;
//
//        if (number > 0) {
//            if (number % 2 == 0) {
//                System.out.println("Số dương chẵn");
//            } else {
//                System.out.println("Số dương lẻ");
//            }
//        } else {
//            System.out.println("Số không phải là số dương");
//        }
 // vòng lặp for
//        for(int i = 0; i < 11; i++){
//            System.out.println(i);
//        }
//
//        int [][][][][] arr = new int[5][5][5][5][9];
//        HashMap<String, String> hashMap1 = new HashMap<>();
//        HashMap<Integer, String> hashMap2 = new HashMap<>();
//
//        // put: insert dữ liệu => trùng key update value
//        hashMap1.put("quang", "hello you");
//        hashMap1.put("linh", "hello you");
//        hashMap1.put("hello ae", "okok");
//        hashMap2.put(1, "mmmm");
//        hashMap2.put(2, "jjjj");
//        System.out.println(hashMap1);
//
//        // get
//        String tmp = hashMap1.get(null);
//        System.out.println(tmp);
//
//        // remove
//        String value = hashMap1.remove("quang");
//        System.out.println(hashMap1);
//
//        Boolean bo = hashMap1.remove("quang", "okok");
//        System.out.println(bo);
//        // contains key
//        System.out.println(hashMap1.containsKey("qu"));
//        // contains value
//        System.out.println(hashMap1.containsValue("okok"));
//
//        //isEmpty
//        System.out.println(hashMap1.isEmpty());
//        //size
//        System.out.println(hashMap1.size());

        ArrayList<String> animal1 = new ArrayList<>();
        animal1.add("dog");
        animal1.add("cat");
        animal1.add("cat2");
//        System.out.println(animal1);

        ArrayList<String> animal2 = new ArrayList<>();
        animal2.add("Crocodile");
        animal2.addAll(animal1);

//        String str = animal2.get(2);
//        System.out.println(str);
//
//        animal2.set(2, "chuot");
//        System.out.println(animal2);

//        String dongvat = animal2.remove(2);
////        System.out.println(dongvat);
//        System.out.println(animal2);

//        System.out.println(animal1.size());
//        for(int i = 0; i<=animal1.size(); i += 2 ){ //= > 0 2
//            System.out.println("okoko");
//            System.out.println("pha tu thu "+ i);
//            System.out.println(animal1.get(i));
//        }

        for(int i = 0; i<=animal1.size(); i += 2 ){ //= > 0 2
            System.out.println("okoko");
            System.out.println("pha tu thu "+ i);
            System.out.println(animal1.get(i));
        }




        ArrayList<Integer> listNumber = new ArrayList<>();

        listNumber.add(9);
        listNumber.add(6);
        listNumber.add(1);
        listNumber.add(4);
        listNumber.add(5);
        listNumber.add(8);
        listNumber.add(7);
        listNumber.add(3);
        listNumber.add(11);
        listNumber.add(10);
        listNumber.add(10);
        listNumber.add(2);
        int tong = 0;
        ArrayList<Integer> danhsachLe = new ArrayList<>();
        for(int i = 0; i< listNumber.size(); i++){
            if (listNumber.get(i)%2 != 0){
//                System.out.println(listNumber.get(i));
                tong = tong + listNumber.get(i);
                danhsachLe.add(listNumber.get(i));
            }

        }
//        System.out.println(tong);
        int tongLe = 0;
        for (int i = 0; i < danhsachLe.size(); i++){
            tongLe = tongLe + danhsachLe.get(i);
        }
        System.out.println(tongLe);

        int x = 3;
        while (x <= 10){
            x = x + 2;
            System.out.println("x = "+x);
        }


        int a = 1;
        int tong1 = 0;
        do {
            tong1 = tong1 + a;
            a++;
        }
        while (a<=5);
        System.out.println("tong = "+tong1);


    }
}
