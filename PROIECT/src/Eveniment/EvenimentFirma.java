package Eveniment;

public class EvenimentFirma extends Eveniment {
   private String titluEveniment; // sedinta/petrecereAngajati/etc.

    public EvenimentFirma(int nrParticipanti, String titluEveniment) {
        super(nrParticipanti);
        this.titluEveniment = new String(titluEveniment);
    }

    public EvenimentFirma(Eveniment eveniment, String titluEveniment) {
        super(eveniment);
        this.titluEveniment = new String(titluEveniment);
    }

    public EvenimentFirma(EvenimentFirma ob) {
        super(ob.nrParticipanti);
        this.titluEveniment = new String(ob.titluEveniment);
    }

    public String getTitluEveniment() {
        return titluEveniment;
    }

    public void setTitluEveniment(String titluEveniment) {
        this.titluEveniment = new String(titluEveniment);
    }

    @Override
    public String toString() {
        return super.toString()+"Titlu eveniment: "+titluEveniment+"\n";
    }
}
