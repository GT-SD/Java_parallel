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
 * @author �������������
 */
public class Synch {
    public static int N = 10;//������������ �������� ������
    public static boolean flag = true;//������������� 
    public static ArrayList<Integer> buffer = new ArrayList<Integer>();//������������ ������ ����� 
    
    
    public synchronized void gen() {
        Random rand = new Random();
        while (!flag) {
            try {
                wait();
                System.out.println("����� 1 ���");
            } catch (InterruptedException ex) {
            }
        }
        System.out.println("����� 1 ��������");
        for (int k=0; k<N; k++){//���� ���������� ������� ���������� ������� �� 0 �� 2
        buffer.add(rand.nextInt(3)); //��������� � ����� ��������� �����
        System.out.print(buffer.get(k));//������� �� ������ �� ����� ����������� �����
        }
        System.out.println();
        flag = false;
        notify();
        System.out.println("����� 1 ���������");
    }
    
    public synchronized void outDel() {
        String ternary = "";//���������� ��� ����� ��������� ����� �� ������
        while (flag) {
            try {
                wait();
                System.out.println("����� 2 ���");
            } catch (InterruptedException ex) {
            }
        }
        System.out.println("����� 2 ��������");
        for (int y=0; y<N; y++){
            ternary = ternary + Integer.toString(buffer.get(y));  //��������� �� ������ ����� � �����         
        }
        for (int q=N-1; q>=0; q--)
        {buffer.remove(q);}//�������� �����
        System.out.println(Integer.parseInt(ternary, 3));//��������� �� �������� ������� ��������� � ���������� � ������� �� �����
        flag = true;      
        notify();
        System.out.println("����� 2 ���������");
    }
}
