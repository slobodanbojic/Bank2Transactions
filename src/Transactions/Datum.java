package Transactions;

public class Datum {
    private int dan;
    private int mesec;
    private int godina;

    public Datum(int dan, int mesec, int godina) throws ArithmeticException{
       boolean dobarDatum = proveriDatum(dan, mesec, godina);
       if(dobarDatum == false){
          // System.out.println("datum nije dobar");
           ArithmeticException greska = new ArithmeticException("Transactions.Datum nije dobar");
           throw greska;
       }
        this.dan = dan;
        this.mesec = mesec;
        this.godina = godina;
    }

    public int getDan() {
        return dan;
    }

    public int getMesec() {
        return mesec;
    }

    public int getGodina() {
        return godina;
    }

    public void setDan(int dan)throws ArithmeticException {
        boolean dobarDatum = proveriDatum(dan, mesec, godina);
        if(dobarDatum == false){
            ArithmeticException greska = new ArithmeticException("Transactions.Datum nije dobar");
            throw greska;
        }
        this.dan = dan;
    }

    public void setMesec(int mesec)throws ArithmeticException {
        boolean dobarDatum = proveriDatum(dan, mesec, godina); //za dan salje se vrednost polja,za mesec salje se argument,za godinu ide vrednost polja godina
        if(dobarDatum == false){
            ArithmeticException greska = new ArithmeticException("Transactions.Datum nije dobar");
            throw greska;
        }
        this.mesec = mesec;
    }

    public void setGodina(int godina)throws ArithmeticException {
        boolean dobarDatum = proveriDatum(dan, mesec, godina);
        if(dobarDatum == false){
            // System.out.println("datum nije dobar");
            ArithmeticException greska = new ArithmeticException("Transactions.Datum nije dobar");
            throw greska;
        }
        this.godina = godina;
    }
    public String toString (){
        StringBuilder sb = new StringBuilder();
        sb.append(dan).append("-").append(mesec).append("-").append(godina);
        return sb.toString();
    }
    ///posto je staticka metoda ona ne moze da pristupi ne statickim poljima gore ( private int dan ; private int mesec ;private int godina; )
    ///staticke metode mogu da pristupe samo statickim poljima,jedini nacin da im pristupi je da budu argumenti u zagradi

    private static boolean proveriDatum (int dan,int mesec,int godina){
      boolean dobarDatum = true;

      if (godina < 2000){
          dobarDatum = false;
      }
      switch (mesec){
          case 1,3,5,7,8,10,12:
          if (dan<1 || dan >31){
              dobarDatum = false;
              }
               break;
          case 4,6,9,11:
              if(dan<1 || dan>30){
                  dobarDatum = false;
              }
              break;
          case 2:
              if (godina % 4 == 0 ){
                  if (dan<1 || dan>29){
                      dobarDatum = false;
                     }
              }
              else {
                  if (dan<1 || dan>28){
                      dobarDatum = false;
                  }
              }
          default:
              dobarDatum = false;
      }
          return dobarDatum;

    }
}
