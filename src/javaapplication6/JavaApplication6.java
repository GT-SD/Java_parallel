/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;


/*14.�������� �������� � ����������� �������� �������:
N=10
������ ����� - ���������� � ����� 100000 ��������� ����� �� ��������� �� 0 �� 2. 
������ ����� - ��������� ������������ � ������ ����� �� �������� ��-����� ���������� � ����������, ������� ���������� ��������� �� ����� � ������� �����.
*/
public class JavaApplication6 {          
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Synch synch=new Synch();//�������� ������� ������ �������������
        Thread1 thread1 = new Thread1(synch); //�������� ������� ������ ����� 1
        Thread2 thread2 = new Thread2(synch); //�������� ������� ������ ����� 2
        new Thread(thread1).start();//�������� � ������ ������ 1
        new Thread(thread2).start();//�������� � ������ ������ 2
    }
}
