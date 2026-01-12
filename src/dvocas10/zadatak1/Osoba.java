package dvocas10.zadatak1;

import java.util.Objects;

public class Osoba {

    private String imePrezime;
    private String adresa;
    private int telefon;

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        if (imePrezime == null || imePrezime.isEmpty())
            throw new RuntimeException("Ime i prezime ne smeju biti prazni niti null");

        this.imePrezime = imePrezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        if (adresa == null || adresa.isEmpty())
            throw new RuntimeException("Adresa ne sme biti prazna niti null");

        this.adresa = adresa;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        if (telefon <= 0)
            throw new RuntimeException("Telefon mora biti veci od nule");

        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "imePrezime='" + imePrezime + '\'' +
                ", adresa='" + adresa + '\'' +
                ", telefon=" + telefon +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Osoba osoba)) return false;

        return Objects.equals(imePrezime, osoba.imePrezime);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(imePrezime);
    }
}
