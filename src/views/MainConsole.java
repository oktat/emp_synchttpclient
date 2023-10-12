package views;

import java.util.Scanner;

public class MainConsole {
    Scanner sc;
    public MainConsole() {
        sc = new Scanner(System.in);
    }
    
    public String selectMenu() {        
        showMenu();
        System.out.print("Választott: ");
        return sc.nextLine();
    }

    public void showMenu() {
        String[] menu = {
            "1) Lekérdezés",
            "2) Hozzáadás",
            "3) Szerkesztés",
            "4) Törlés",
            "Vége bármimás"
        };
        System.out.println("---------------------");
        for(String item : menu) {
            System.out.println(item);
        }
        System.out.println("---------------------");
    }
}
