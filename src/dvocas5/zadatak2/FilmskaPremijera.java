package dvocas5.zadatak2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatterBuilder;

class FilmskaPremijera {

    String nazivFilma;

    //staticka metoda now
    LocalDateTime premijeraAmerika =
            LocalDateTime.now();

    LocalDateTime premijeraSvet =
            LocalDateTime.of(2024, 3, 22, 21, 0);

    void postaviNaziv(String nazivFilma){
        if (nazivFilma == null || nazivFilma.isEmpty())
            System.out.println("Greska: morate uneti naziv filma");
        else
            this.nazivFilma = nazivFilma;
    }

    void postaviDatumePremijera (LocalDateTime premijeraAmerika,
                                 LocalDateTime premijeraSvet){
        LocalDateTime sada = LocalDateTime.now();

        if (premijeraAmerika == null || premijeraSvet == null ||
            premijeraSvet.isBefore(sada) ||
                premijeraAmerika.isBefore(sada))
            System.out.println("Greska: datumi moraju da se odnose na buducnost");
        else{
            this.premijeraAmerika = premijeraAmerika;
            this.premijeraSvet = premijeraSvet;
        }
    }

    void ispisi(){
        System.out.println("Naziv filma: " + nazivFilma);
        int danA = premijeraAmerika.getDayOfMonth();
        int mesecA = premijeraAmerika.getMonthValue();
        int godinaA = premijeraAmerika.getYear();
        int satA = premijeraAmerika.getHour();
        int minutA = premijeraAmerika.getMinute();

        System.out.println("Premijera Amerika: " +
                danA+"."+mesecA+"."+godinaA+". "+satA+":"+minutA);
        System.out.println("Premijera svet: " + premijeraSvet);
    }

    void pomeriPremijere(){
        premijeraAmerika = premijeraAmerika.plusYears(1);
        premijeraSvet = premijeraSvet.plusYears(1);
    }
}
