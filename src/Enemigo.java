import java.io.Serializable;

public class Enemigo extends Personaje implements Serializable {
    private int vecesDerrotado;
    private int oroProporcionado;

    public Enemigo(String nombre, int atk, int def, int hp, int vecesDerrotado, int oroProporcionado) {
        super(nombre, atk, def, hp);
        this.vecesDerrotado = vecesDerrotado;
        this.oroProporcionado = oroProporcionado;
    }

    public void recibirDano(int ataque) {
        super.setHp(this.getHp()- (ataque-this.getDef()));
    }

}
