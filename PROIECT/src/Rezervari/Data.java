package Rezervari;
//verifica daca zi/luna/an au format valid la citire(zi 1-31, luna 1-12, an >=2020)

public class Data {
    private int zi;
    private int luna;
    private int an;

    public Data(int zi, int luna, int an) {
        this.zi = zi;
        this.luna = luna;
        this.an = an;
    }

    public Data(Data data) {
        this.zi = data.zi;
        this.luna = data.luna;
        this.an = data.an;
    }

    public int getZi() {
        return zi;
    }

    public void setZi(int zi) {
        this.zi = zi;
    }

    public int getLuna() {
        return luna;
    }

    public void setLuna(int luna) {
        this.luna = luna;
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    @Override
    public String toString() {
        return "Data: "+zi+"."+luna+"."+an;
    }
}
