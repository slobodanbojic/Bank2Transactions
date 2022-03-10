package Transactions;

public class Racun {
    private double stanje;
    private double dozvoljeniMinus;

    public Racun(double stanje, double dozvoljeniMinus) {
        this.stanje = stanje;
        this.dozvoljeniMinus = dozvoljeniMinus;
    }

    public double getStanje() {
        return stanje;
    }
    public double getDozvoljeniMinus() {
        return dozvoljeniMinus;
    }
    public void setDozvoljeniMinus(double dozvoljeniMinus) {
        this.dozvoljeniMinus = dozvoljeniMinus;
    }
    public void uplati (double suma){
        stanje = stanje + suma;
    }

    public boolean skini (double iznos){
                                              //double kolikoostajeposleSkidanja = stanje - iznos;
     if (dozvoljeniMinus + stanje > iznos){   //(kolikoostajeposleSkidanja > dozvoljeniMinus)
       stanje = stanje - iznos;               // stanje = kolikoostajeposleSkidanja;
       return true;
     }
     else {
         return false;
     }
    }
}
