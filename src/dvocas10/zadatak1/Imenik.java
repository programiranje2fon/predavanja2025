package dvocas10.zadatak1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Imenik {

    private List<Osoba> osobe = new ArrayList<Osoba>();

    public void ucitajOsobu() {
        try {
            BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Unesite ime i prezime: ");
            String imePrezime = br.readLine();

            System.out.print("Unesite adresu: ");
            String adresa = br.readLine();

            System.out.print("Unesite telefon: ");
            int telefon = Integer.parseInt(br.readLine());


        Osoba o = new Osoba();
        o.setImePrezime(imePrezime);
        o.setAdresa(adresa);
        o.setTelefon(telefon);

        if (osobe.contains(o))
            throw new RuntimeException("Osoba vec postoji u imeniku");

        osobe.add(o);

        }catch (IOException e){
        e.printStackTrace();
        }
    }

   public void pronadjiOsobu() {
       try{
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


       System.out.print("Unesite deo imena ili prezimena: ");
       String deoImena = br.readLine();

        for(Osoba o: osobe)
            if (o.getImePrezime().contains(deoImena))
                System.out.println(o);
       }catch (IOException e){
           e.printStackTrace();
       }
   }

    public void ispisi(){
        for(Osoba o: osobe)
            System.out.println(o);
    }

}
