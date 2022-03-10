package Transactions;

public abstract class ZahtevZaTransfer {

    private static int NextId=1;     //staticka polja su osobina klase a obicna polja su osobina objekta
                                    // ovo polje static nam treba da pamti id
    protected int id;              //jednostaticki int -staticko polje postoji samo na jednom mestu,!!!staticko polje je zajednicko za sve objekte!! iz ZahtevZaTrasfer
                                   //ovo nije vec svaki objekat ima svoj ID

    protected Racun primaoc;
    protected Racun uplatioc;
   protected Datum datum;
   protected double iznos;

    public ZahtevZaTransfer(Racun primaoc, Racun uplatioc, Datum datum, double iznos) {
        this.primaoc = primaoc;
        this.uplatioc = uplatioc;
        this.datum = datum;
        this.iznos = iznos;
        this.id = NextId;   //pri svakom kreiranju zahteva za transfer id ce se uvecavati za 1
        NextId++;
    }

    public Racun getPrimaoc() {
        return primaoc;
    }

    public Racun getUplatioc() {
        return uplatioc;
    }

    public Datum getDatum() {
        return datum;
    }

    public void setDatum(Datum datum) {
        this.datum = datum;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }
    public abstract boolean izvrsiZahtev();   //nema implementaciju implementacija se dodeljuje u izvedenim klasama
}
