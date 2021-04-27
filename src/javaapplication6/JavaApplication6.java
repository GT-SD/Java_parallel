/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;


/*14.Значения констант и реализуемые потоками функции:
N=10
Первый поток - генерирует в буфер 100000 случайных чисел из интервала от 0 до 2. 
Второй поток - переводит получившееся в буфере число из троичной си-стемы исчисления в десятичную, выводит полученный результат на экран и очищает буфер.
*/
public class JavaApplication6 {          
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Synch synch=new Synch();//создание объекта класса синхронизации
        Thread1 thread1 = new Thread1(synch); //создание объекта класса поток 1
        Thread2 thread2 = new Thread2(synch); //создание объекта класса поток 2
        new Thread(thread1).start();//создание и запуск потока 1
        new Thread(thread2).start();//создание и запуск потока 2
    }
}
