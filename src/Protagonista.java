import java.io.Serializable;
import java.util.*;
public class Protagonista extends Personaje implements Serializable {
    private Item armadura;
    private ArrayList<Item> bolsa;
    private int oro;

    public Protagonista(String nombre, int atk, int def, int hp, int oro) {
        super(nombre, atk, def, hp);
        this.bolsa = new ArrayList<>();
        this.oro = oro;
    }

    public void setArmadura(Item armadura) {
        this.armadura = armadura;
    }

    public void sumarAtributosArmadura() {
        setAtk(this.getAtk()+armadura.getAtk_armadura());
        setDef(this.getDef()+armadura.getDef_armadura());
        setHp(this.getHp()+armadura.getHp_armadura());
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public void recibirDano(int ataque) {
        setHp(this.getHp()-ataque);
    }

    public ArrayList<Item> getBolsa() {
        return bolsa;
    }

}
