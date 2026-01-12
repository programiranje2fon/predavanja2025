package dvocas10.zadatak2;

import dvocas10.zadatak1.Osoba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Imenik {

    private List<Osoba> osobe = new ArrayList<Osoba>();

    public void ucitajOsobu() {
        Scanner sc = new Scanner(System.in);

        // Pera Peric 2342341
        System.out.print("Unesite ime prezime i telefon: ");
        String imePrezime = sc.next() + " " + sc.next();
        int telefon = sc.nextInt();
        sc.nextLine();

        System.out.print("Unesite adresu: ");
        String adresa = sc.nextLine();

        Osoba o = new Osoba();
        o.setImePrezime(imePrezime);
        o.setAdresa(adresa);
        o.setTelefon(telefon);

        if (osobe.contains(o))
            throw new RuntimeException("Osoba vec postoji u imeniku");

        osobe.add(o);
    }

   public void pronadjiOsobu() {
       Scanner sc = new Scanner(System.in);

        System.out.print("Unesite deo imena ili prezimena: ");
       String deoImena = sc.nextLine();

        for(Osoba o: osobe)
            if (o.getImePrezime().contains(deoImena))
                System.out.println(o);

   }

    public void ispisi(){
        for(Osoba o: osobe)
            System.out.println(o);
    }

}
