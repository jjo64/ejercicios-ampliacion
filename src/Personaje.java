import java.io.*;
import java.util.ArrayList;

public class Personaje implements Comparable<Personaje>, Serializable {
    private String nombre;
    private int atk;
    private int def;
    private int hp;
    ArrayList<Enemigo> enemigosDerrotados;

    public Personaje (String nombre, int atk, int def, int hp) {
        this.nombre = nombre;
        this.atk = atk;
        this.def = def;
        this.hp = hp;
        enemigosDerrotados = new ArrayList<>();
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getHp() {
        return hp;
    }

    public ArrayList<Enemigo> getEnemigosDerrotados() {
        return enemigosDerrotados;
    }

    public void mostrarPoderosos(Personaje p) {
        if (p.getAtk() > 10) {
            System.out.println("Este personaje es poderoso, tiene +10 de ataque");
        }
    }

    @Override
    public int compareTo(Personaje o) {
        return this.nombre.compareTo(o.getNombre());
    }
}
