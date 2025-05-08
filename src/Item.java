import java.io.Serializable;

public class Item implements Serializable {
    public enum Tipo {
        Curativo,
        Armadura;

        public static void mostrarTipos() {
            for (Tipo armadura : Tipo.values()) {
                System.out.println(armadura);
            }
        }
    }
    private String nombre; //vector[0]
    private Tipo tipoArmadura; //vector[1]
    private int precio;
    private int atk_armadura;
    private int def_armadura;
    private int hp_armadura; //vector[5]

    

    public Item(String nombre, Item.Tipo tipoArmadura, int precio, int atk_armadura, int def_armadura, int hp_armadura) {
        this.nombre = nombre;
        this.tipoArmadura = tipoArmadura;
        this.precio = precio;
        this.atk_armadura = atk_armadura;
        this.def_armadura = def_armadura;
        this.hp_armadura = hp_armadura;
    }

    public String getNombre() {
        return nombre;
    }

    public Tipo getTipoArmadura() {
        return tipoArmadura;
    }

    public int getAtk_armadura() {
        return atk_armadura;
    }

    public int getDef_armadura() {
        return def_armadura;
    }

    public int getHp_armadura() {
        return hp_armadura;
    }

    public int getPrecio() {
        return precio;
    }
}
