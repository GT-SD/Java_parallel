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
public class Thread2 implements Runnable{   
    Synch synch;
    Thread2(Synch synch){
       this.synch=synch; 
    }
    @Override
    public void run() {
        System.out.println("����� 2 �������");
        for (int i=0; i<100000/Synch.N; i++){
        synch.outDel();
        }
        System.out.println("����� 2 ��������");
    }
}
