package dvocas12.zadatak1.poslovna_logika;

import java.util.Objects;

public class Osoba {

    private String ime, prezime, adresa;
    private int telefon;

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        if (ime == null)
            throw new NullPointerException("Ime ne sme biti null");

        if (ime.isEmpty())
            throw new IllegalArgumentException("Ime ne sme biti prazno");

        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        if (prezime == null)
            throw new NullPointerException("Prezime ne sme biti null");

        if (prezime.isEmpty())
            throw new IllegalArgumentException("Prezime ne sme biti prazno");

        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        if (adresa == null)
            throw new NullPointerException("Adresa ne sme biti null");

        if (adresa.isEmpty())
            throw new IllegalArgumentException("Adresa ne sme biti prazna");

        this.adresa = adresa;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        if (telefon <= 0)
            throw new IllegalArgumentException("Telefon mora biti veci od nule");

        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", adresa='" + adresa + '\'' +
                ", telefon=" + telefon +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Osoba osoba)) return false;

        return Objects.equals(ime, osoba.ime) && Objects.equals(prezime, osoba.prezime);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(ime);
        result = 31 * result + Objects.hashCode(prezime);
        return result;
    }
}
