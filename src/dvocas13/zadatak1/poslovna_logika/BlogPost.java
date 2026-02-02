package dvocas13.zadatak1.poslovna_logika;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.time.LocalDateTime;

public class BlogPost implements Serializable {

    // Nije obavezno, ali se stavlja ako se klasa menja da bi mogla
    //i nova verzija klase da se identifikuje kao stara
    private static final long serialVersionUID = 1L;

    private String naslov;
    private String sadrzaj;
    private LocalDateTime datum;

    public BlogPost() {
        this.datum = LocalDateTime.now();
    }

    //    relativna putanja u odnosu na paket test
    //    ./TestBlog.java

    //    relativna putanja u odnosu na koren projekta
    //    ./src/dvocas11/zadatak1/test/TestBlog.java

    //    apsolutna putanja
    //    C:/Users/student2/IdeaProjects/predavanja2025/src/dvocas11/zadatak1/test/TestBlog.java

    public BlogPost(String putanja){

        try (BufferedReader br = new BufferedReader(new FileReader(putanja)))
        {
            this.naslov = br.readLine();
            String sadrzaj = "";

            while(true){
                String red = br.readLine();
                if (red == null) break;
                else sadrzaj = sadrzaj + red + System.lineSeparator();
            }

            this.sadrzaj = sadrzaj;
            this.datum = LocalDateTime.now();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        if (naslov == null)
            throw new NullPointerException("Naslov ne sme biti null");

        if (naslov.isEmpty())
            throw new IllegalArgumentException("Naslov ne sme biti prazan");

        this.naslov = naslov;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        if (sadrzaj == null)
            throw new NullPointerException("Sadrzaj ne sme biti null");

        if (sadrzaj.isEmpty())
            throw new IllegalArgumentException("Sadrzaj ne sme biti prazan");

        this.sadrzaj = sadrzaj;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        if (datum == null)
            throw new NullPointerException("Datum ne sme biti null");

        if (datum.isAfter(LocalDateTime.now()))
            throw new IllegalArgumentException("Datum ne sme biti u buducnosti");

        this.datum = datum;
    }

    @Override
    public String toString() {
        return datum + System.lineSeparator() + System.lineSeparator() +
                naslov + System.lineSeparator() + System.lineSeparator() +
                sadrzaj + System.lineSeparator();
    }
}
