/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Администратор
 */
public class Synch {
    public static int N = 10;//максимальное значение буфера
    public static boolean flag = true;//переключатель 
    public static ArrayList<Integer> buffer = new ArrayList<Integer>();//динамический массив буфер 
    
    
    public synchronized void gen() {
        Random rand = new Random();
        while (!flag) {
            try {
                wait();
                System.out.println("Поток 1 ждёт");
            } catch (InterruptedException ex) {
            }
        }
        System.out.println("Поток 1 пробуждён");
        for (int k=0; k<N; k++){//цикл заполнения массива случайными числами от 0 до 2
        buffer.add(rand.nextInt(3)); //добавляем в буфер случайное число
        System.out.print(buffer.get(k));//выводим из буфера на экран добавленное число
        }
        System.out.println();
        flag = false;
        notify();
        System.out.println("Поток 1 отработал");
    }
    
    public synchronized void outDel() {
        String ternary = "";//переменная для сбора троичного числа из буфера
        while (flag) {
            try {
                wait();
                System.out.println("Поток 2 ждёт");
            } catch (InterruptedException ex) {
            }
        }
        System.out.println("Поток 2 пробуждён");
        for (int y=0; y<N; y++){
            ternary = ternary + Integer.toString(buffer.get(y));  //добавляем из буфера цифру в число         
        }
        for (int q=N-1; q>=0; q--)
        {buffer.remove(q);}//отчищаем буфер
        System.out.println(Integer.parseInt(ternary, 3));//переводим из троичной системы счисления в десятичную и выводим на экран
        flag = true;      
        notify();
        System.out.println("Поток 2 отработал");
    }
}
