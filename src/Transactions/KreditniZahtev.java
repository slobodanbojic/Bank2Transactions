package Transactions;

import Transactions.Datum;

public class KreditniZahtev extends ZahtevZaTransfer{
    private Datum datumPocetkaOtplate;
    private Datum datumKrajaOtplate;

    public KreditniZahtev(Racun primaoc, Racun uplatioc, Datum datum, double iznos, Datum datumPocetkaOtplate, Datum datumKrajaOtplate) {
        super(primaoc, uplatioc, datum, iznos);
        this.datumPocetkaOtplate = datumPocetkaOtplate;
        this.datumKrajaOtplate = datumKrajaOtplate;
    }

    public Datum getDatumPocetkaOtplate() {
        return datumPocetkaOtplate;
    }

    public void setDatumPocetkaOtplate(Datum datumPocetkaOtplate) {
        this.datumPocetkaOtplate = datumPocetkaOtplate;
    }

    public Datum getDatumKrajaOtplate() {
        return datumKrajaOtplate;
    }

    public void setDatumKrajaOtplate(Datum datumKrajaOtplate) {
        this.datumKrajaOtplate = datumKrajaOtplate;
    }
    public String toString () {
        StringBuilder sb = new StringBuilder();
        sb.append("kredit (");
        sb.append(id);
        sb.append(") ");
        sb.append(datum.toString());
        sb.append("[");
        sb.append(iznos);
        sb.append("] ");
        sb.append("Transactions.Datum pocetka otplate :");
        sb.append(datumKrajaOtplate);
        sb.append("Transactions.Datum kraja otplate :");
        sb.append(datumKrajaOtplate);
        return sb.toString();
    }

    @Override
    public boolean izvrsiZahtev() {
        boolean skinuto = uplatioc.skini(iznos);
        if (skinuto){                                              //ako sam skinuo izracunam koliko je iznos manje kamata
            double iznosMnajeKamata = iznos - 5 * iznos /100;
           primaoc.uplati(iznosMnajeKamata);
           return true;
        }
        else{
            return false;
        }

    }
}
