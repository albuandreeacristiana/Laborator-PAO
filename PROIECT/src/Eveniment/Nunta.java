package Eveniment;

public class Nunta extends Eveniment {
   private String numeMireasa;
   private String numeMire;
   private String culoareTematica;

   public Nunta(int nrParticipanti, String numeMireasa, String numeMire, String culoareTematica) {
      super(nrParticipanti);
      this.numeMireasa = new String(numeMireasa);
      this.numeMire = new String(numeMire);
      this.culoareTematica = new String(culoareTematica);
   }

   public Nunta(Eveniment eveniment, String numeMireasa, String numeMire, String culoareTematica) {
      super(eveniment);
      this.numeMireasa = new String(numeMireasa);
      this.numeMire = new String(numeMire);
      this.culoareTematica = new String(culoareTematica);
   }

   public String getNumeMireasa() {
      return numeMireasa;
   }

   public void setNumeMireasa(String numeMireasa) {
      this.numeMireasa = new String(numeMireasa);
   }

   public String getNumeMire() {
      return numeMire;
   }

   public void setNumeMire(String numeMire) {
      this.numeMire = new String(numeMire);
   }

   public String getCuloareTematica() {
      return culoareTematica;
   }

   public void setCuloareTematica(String culoareTematica) {
      this.culoareTematica = new String(culoareTematica);
   }

   @Override
   public String toString() {
      return super.toString()+"Nume miri: "+numeMireasa+" si "+numeMire+"\n"+"Culoare tematica: "+culoareTematica;
   }
}
