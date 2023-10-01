/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.oop;

/**
 *
 * @author LENOVO
 */
import java.util.Scanner;

public class DuckSimulator {
    
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Pilih jenis bebek (1 untuk Mallard, 2 untuk Rubber Duck, 3 untuk Decoy, 4 untuk Model, 0 untuk keluar): ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Terima kasih telah menggunakan DuckSimulator. Selamat tinggal!");
                break;
            }

            Duck duck = createDuck(choice);

            if (duck != null) {
                System.out.println("Anda memilih " + duck.getClass().getSimpleName());
                duck.display();
                duck.performQuack();
                duck.performFly();
            } else {
                System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        }
        
        scanner.close();
    }

    private static Duck createDuck(int choice) {
        switch (choice) {
            case 1:
                return new MallardDuck();
            case 2:
                FlyBehavior cantFly = () -> System.out.println("I Can't fly");
                QuackBehavior squeak = () -> System.out.println("Squeak");
                return new RubberDuck(cantFly, squeak);
            case 3:
                return new DecoyDuck();
            case 4:
                Duck model = new ModelDuck();
                System.out.println("Model Duck awal:");
                model.display();
                return model;
            default:
                return null;
        }
    }
}