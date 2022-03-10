package Transactions;

public class TestTransakcije {
    public static void main(String[] args) {
        try {
            Datum d1 = new Datum(11, 12, 2012);
            Datum d2 = new Datum(4, 4, 2003);
            Datum d3 = new Datum(5, 11, 2017);

            Racun r1 = new Racun(1000,100);
            Racun r2 = new Racun(2000,200);
            Racun r3 = new Racun(3000,300);

            Banka b1 = new Banka("Komercijalna",r1);

            KreditniZahtev k1 = new KreditniZahtev(r1,r2,d1,900,d2,d3);
           Uplatnica u1 = new Uplatnica(r3,r1,d3,300,"bilo sta");

            b1.dodajZahtev(k1);
            b1.dodajZahtev(u1);

            b1.izvrsiZahtev();
            b1.izvrsiZahtev();
            System.out.println(b1);

        }catch (ArithmeticException ae){
            System.out.println(ae.getMessage());
        }
        }
}
