/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;



/**
 *
 * @author �������������
 */
public class Thread1 implements Runnable{
    Synch synch;
    Thread1(Synch synch){
       this.synch=synch; 
    }
    @Override
    public void run() {
        System.out.println("����� 1 �������");
        for (int i=0; i<100000/Synch.N; i++){
        synch.gen();
        }
        System.out.println("����� 1 ��������");
    }
}
