import java.io.Serializable;
import java.util.*;
public class Protagonista extends Personaje implements Serializable {
    private Item armadura;
    private ArrayList<Item> bolsa;
    private int oro;

    public Protagonista(String nombre, int atk, int def, int hp, int oro) {
        super(nombre, atk, def, hp);
        setArmadura(armadura);
        this.bolsa = new ArrayList<>();
        this.oro = oro;
    }

    public void setArmadura(Item armadura) {

        if (this.armadura == null && armadura != null) {
            int atk_armadura = armadura.getAtk_armadura();
            int def_armadura = armadura.getDef_armadura();
            int hp_armadura = armadura.getHp_armadura();
            this.setAtk(this.getAtk()+ atk_armadura);
            this.setDef(this.getDef()+ def_armadura);
            this.setHp(this.getHp()+ hp_armadura);
        } else if (this.armadura != null && armadura != null) {
            int atk_armadura = this.armadura.getAtk_armadura();
            int def_armadura = this.armadura.getDef_armadura();
            int hp_armadura = this.armadura.getHp_armadura();

            int atk_armadura2 = armadura.getAtk_armadura();
            int def_armadura2 = armadura.getDef_armadura();
            int hp_armadura2 = armadura.getHp_armadura();

            this.setAtk(this.getAtk() - atk_armadura + atk_armadura2 );
            this.setDef(this.getDef() - def_armadura + def_armadura2);
            this.setHp(this.getHp() - hp_armadura + hp_armadura2);
        } else if (this.armadura != null && armadura == null) {
            int atk_armadura = this.armadura.getAtk_armadura();
            int def_armadura = this.armadura.getDef_armadura();
            int hp_armadura = this.armadura.getHp_armadura();

            this.setAtk(this.getAtk() - atk_armadura);
            this.setDef(this.getDef() - def_armadura);
            this.setHp(this.getHp() - hp_armadura);
        }
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

    public Item getArmadura() {
        return armadura;
    }

}
