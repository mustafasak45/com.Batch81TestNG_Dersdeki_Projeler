package tests.SerbestCalisma;

import java.io.Serializable;
import java.util.Scanner;

public class deneme {
    public static void main(String[] args) {

//        System.out.println("lutfen bir harf giriniz");
//        char harf = scan.next().charAt(0);
//        String sonuc = harf >= 'a' && harf <= 'z' ? "Kucuk Harf" : (harf >= 'A' && harf <= 'Z' ? "Buyuk harf" : "Gecersiz karakter");
//        System.out.println(sonuc);
        Scanner scan = new Scanner(System.in);
        Character harf2=scan.next().charAt(0);
        String temp=String.valueOf(harf2);
        String sonuc2=harf2>='a' && harf2<='z' ? temp.toUpperCase() :(harf2 >= 'A' && harf2 <= 'Z' ?  temp : "Hatalı Girdi");
        System.out.println(sonuc2);
    }
}
