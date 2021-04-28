package Model;

import java.util.Objects;

public class Nume {
    private String nume;
    private String initialeleTatalui;
    private String prenume;

    public Nume(String nume, String initialeleTatalui, String prenume) {
        this.nume = nume;
        this.initialeleTatalui = initialeleTatalui;
        this.prenume = prenume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nume)) return false;
        Nume nume1 = (Nume) o;
        return Objects.equals(getNume(), nume1.getNume()) && Objects.equals(getInitialeleTatalui(), nume1.getInitialeleTatalui()) && Objects.equals(getPrenume(), nume1.getPrenume());
    }


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getInitialeleTatalui() {
        return initialeleTatalui;
    }

    public void setInitialeleTatalui(String initialeleTatalui) {
        this.initialeleTatalui = initialeleTatalui;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    @Override
    public String toString() {
        return "Nume{" +
                "nume='" + nume + '\'' +
                ", initialeleTatalui='" + initialeleTatalui + '\'' +
                ", prenume='" + prenume + '\'' +
                '}';
    }
}
