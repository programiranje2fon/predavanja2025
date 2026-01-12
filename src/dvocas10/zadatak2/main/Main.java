package dvocas10.zadatak2.main;

import dvocas10.zadatak2.Imenik;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Imenik im = new Imenik();
        Scanner sc = new Scanner(System.in);

        while(true) {
            try {
                ispisiMeni();
                int opcija = sc.nextInt();
                //sc.nextLine();

                switch (opcija) {
                    case 1:
                        im.ucitajOsobu();
                        break;
                    case 2:
                        im.pronadjiOsobu();
                        break;
                    case 3:
                        im.ispisi();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Morate uneti broj od 1 do 4");
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void ispisiMeni(){
        System.out.println("-----------------------------");
        System.out.println("Dobrodosli u imenik");
        System.out.println("-----------------------------");
        System.out.println("Ponudjene opcije:");
        System.out.println("1 - Unos osobe u imenik");
        System.out.println("2 - Pretraga imenika");
        System.out.println("3 - Ispis celog imenika");
        System.out.println("4 - Izlaz iz programa");
        System.out.println("-----------------------------");
        System.out.print("Unesite opciju: ");
    }
}
