package Transactions;

public class Uplatnica extends ZahtevZaTransfer {
    private String svrhaUplate;

    public Uplatnica(Racun primaoc, Racun uplatioc, Datum datum, double iznos, String svrhaUplate) {
        super(primaoc, uplatioc, datum, iznos);
        this.svrhaUplate = svrhaUplate;
    }

    public String getSvrhaUplate() {
        return svrhaUplate;
    }

    public void setSvrhaUplate(String svrhaUplate) {
        this.svrhaUplate = svrhaUplate;
    }
    public String toString () {
        StringBuilder sb = new StringBuilder();
        sb.append("uplatnica (");
        sb.append(id);
        sb.append(")");

        sb.append(datum.toString());     //datum.getDan()+(-)+datum.getMesec+(-)+datum.getGodina ---duzi nacin ali nema potrebe
        sb.append("[");
        sb.append(iznos);
        sb.append(" : ");
        sb.append(iznos /100);            //provizija je 1% znaci delimo sa 100
        sb.append("]");
        sb.append("svrha uplatnice :");
        sb.append(svrhaUplate);
        return sb.toString();
    }
    public boolean izvrsiZahtev() {
        double provizija = iznos / 100;
        double iznosIprovizija = iznos + provizija;
        boolean skinuto = uplatioc.skini(iznosIprovizija);
        if (skinuto){
            primaoc.uplati(iznos);
        }else {

        }
        return false ;
    }
}
