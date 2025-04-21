import java.io.*;
import java.util.*;


public class App {
    final static Scanner TECLADO = new Scanner(System.in);
    static HashMap <String, Personaje> LISTAPERSONAJES = new HashMap<>();
    static HashMap<String, Item> LISTAITEMS = new HashMap<>();
    public static void main(String[] args) throws Exception {
            menuJuego();
    }

    public static void datosPrueba() {


        Personaje p1 = new Protagonista("Copernico", 25, 15, 60, 3000 );
        Personaje p2 = new Enemigo("Atlas", 40, 20, 30, 1, 4000);
        Personaje p3 = new Enemigo("Ichigo", 9, 45, 75, 4, 1500);
        Personaje p4 = new Protagonista("Valquiria", 18, 65, 35, 1000);
        Personaje p5 = new Protagonista("Oikawa", 55, 35, 20, 2000);

        LISTAPERSONAJES.put(p1.getNombre(), p1);
        LISTAPERSONAJES.put(p2.getNombre(), p2);
        LISTAPERSONAJES.put(p3.getNombre(), p3);
        LISTAPERSONAJES.put(p4.getNombre(), p4);
        LISTAPERSONAJES.put(p5.getNombre(), p5);
    }

    public static void ordenarArraySorted() {
        //Mi forma de hacerlo
        SortedMap <String, Personaje> arrayAuxiliar =  new TreeMap<>(LISTAPERSONAJES);
        ArrayList<Personaje> listaAuxiliar = new ArrayList<>(arrayAuxiliar.values());
        Collections.sort(listaAuxiliar);

        arrayAuxiliar.clear();
        for (Personaje personaje : listaAuxiliar) {
            arrayAuxiliar.put(personaje.getNombre(), personaje);
        }
        
        //El chatgpt me dijo que no hace falta todo esto, el treemap ordenada automaticamente, porque?
    }

    public static void ordenarArrayLinked() {
        LinkedHashMap <String, Personaje> linkedAuxiliar = new LinkedHashMap<>(LISTAPERSONAJES);
        ArrayList<Personaje> listaAuxiliar = new ArrayList<>(linkedAuxiliar.values());
        Collections.sort(listaAuxiliar);
        linkedAuxiliar.clear();
        for (Personaje personaje : listaAuxiliar) {
            linkedAuxiliar.put(personaje.getNombre(), personaje);
        }
    }

    //Enunciado 4

    public static void decidirPersonaje() {
        ArrayList<Personaje> listaPersonajesAux = new ArrayList<>(LISTAPERSONAJES.values());

        System.out.println("Elige que personaje queres visualizar \n 1 ---- Protagonista\n 2 ---- Enemigo");
        int decision = pedirNumero();

        while (decision != 1 || decision != 2) {
            System.out.println("Error. Tenes que elegir la opcion 1 o 2");
            System.out.println("Elige que personaje queres visualizar \n 1 ---- Protagonista\n 2 ---- Enemigo");
            decision = pedirNumero();
        }

        if (decision == 1) {
            for (Personaje personaje : listaPersonajesAux) {
                if (personaje instanceof Protagonista) {
                    System.out.println(personaje);
                }
            }
        } else {
            for (Personaje personaje : listaPersonajesAux) {
                if (personaje instanceof Enemigo) {
                    System.out.println(personaje);
                }
            }
        } 
    }

    //Enunciado 5 punto a 

    public static void unDelimitador() {
        
        try {
            File fichero = crearFichero();
            //Leer el fichero
            FileReader lector = new FileReader(fichero);
            BufferedReader lector_linea = new BufferedReader(lector);

            while (lector_linea.readLine() != null) {
                String linea = lector_linea.readLine();
                String [] vector = linea.split(",");

                int precio = Integer.parseInt(vector[2]);
                int atk_armadura = Integer.parseInt(vector[3]);
                int def_armadura = Integer.parseInt(vector[4]);
                int hp_armadura = Integer.parseInt(vector[5]);

                //Tengo que hacer un equals al vector[1] y si es de tal o tal asignarle a mi variable tipo_armadura en un switch
                //tipo_armadura = Tipo.basica / Tipo.normal etc etc

                for (String li : vector) {
                    Item nuevo = new Item(vector[0], null, precio, atk_armadura, def_armadura, hp_armadura);
                    //Crea la estructura de datos que no acepte repetidos == un conjunto o un mapa
                    LISTAITEMS.put(nuevo.getNombre(), nuevo);
                }
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }

        //Mostrar solo items curativos = for each implementando un if que pregunte el tipo armadura del objeto item y tambien mostrar el valor del hp que restaura
        for (Item loot : LISTAITEMS.values()) {
            if (loot.getTipoArmadura() == Item.Tipo.Epica) {
                System.out.println("Armadura: " + loot.getNombre() + "Restaura hp: " + loot.getHp_armadura());
            }
        }
        
    }

    //Enunciado 5 punto b
    public static void dosDelimitadores() {
        try {
            File fichero = crearFichero();

            //Leer el fichero
            FileReader lector = new FileReader(fichero);
            BufferedReader lector_linea = new BufferedReader(lector);

            while (lector_linea.readLine() != null) {
                String linea = lector_linea.readLine();
                String [] vector = linea.split("@");
                for (String aux : vector) {
                    String [] vector2 = aux.split(",");
                    int precio = Integer.parseInt(vector2[2]);
                    int atk_armadura = Integer.parseInt(vector2[3]);
                    int def_armadura = Integer.parseInt(vector2[4]);
                    int hp_armadura = Integer.parseInt(vector2[5]);

                //Tengo que hacer un equals al vector[1] y si es de tal o tal asignarle a mi variable tipo_armadura en un switch
                //tipo_armadura = Tipo.basica / Tipo.normal etc etc

                for (String li : vector2) {
                    Item nuevo = new Item(vector2[0], null, precio, atk_armadura, def_armadura, hp_armadura);
                    //Crea la estructura de datos que no acepte repetidos == un conjunto o un mapa
                    LISTAITEMS.put(nuevo.getNombre(), nuevo);
                }
                }

            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    //Enunciado 6
    public static void binario() {
        ArrayList<Item> listaAux = new ArrayList<>();
        Item armadura1 = new Item("Peto mataabuelitas777", Item.Tipo.Legendaria, 8500, 60, 120, 200);
        Item armadura2 = new Item("Botas momeras", Item.Tipo.Mitica, 5400, 40, 80, 140);
        listaAux.add(armadura1);
        listaAux.add(armadura2);
        int contador = 0;

        for (Personaje p : LISTAPERSONAJES.values()) {
            if (p instanceof Protagonista) {
                ((Protagonista)p).setArmadura(listaAux.get(contador));
                contador++;
            }
        }

        try {
            File fichero = new File("fichero-binario.txt");
            if (!fichero.exists()) {
                fichero.createNewFile();
            }
            FileOutputStream binario = new FileOutputStream(fichero);
            ObjectOutputStream escribir = new ObjectOutputStream(binario);
            //Pregunte al gpt y dice que: LISTAPERSONAJES.values() devuelve una Collection, no es directamente serializable como tal en todos los contextos.
            //Que hay que convertilo a una estructura que sabés seguro que es serializable, como una List.
            escribir.writeObject(LISTAPERSONAJES.values());
            escribir.close();
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    //Enunciado 7 
    public static HashMap<String, Personaje> leerBinario(File fichero) {
        HashMap <String, Personaje> mapaAuxiliar = new HashMap<>();
        try {
            FileInputStream leer = new FileInputStream(fichero);
            ObjectInputStream leer_objetos = new ObjectInputStream(leer);
            //Todavia no entiendo esta linea, me la dio el gpt. Porque se hace de esa manera. Hay alguna otra forma de hacerlo?
            List <Personaje> personajesLeidos = (List<Personaje>) leer_objetos.readObject();
            //Tengo que cargarlos en un mapa auxiliar?? O a donde lo cargo? a mi mapa static?
            for (Personaje p : personajesLeidos) {
                mapaAuxiliar.put(p.getNombre(), p);
            }
            leer_objetos.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return mapaAuxiliar;
    }

    //Enunciado 8
    public static void comprobarPersonajesBinario(File fichero) {
        HashMap<String, Personaje> comprobar = leerBinario(fichero);
        Iterator <Map.Entry<String, Personaje>> iterator = comprobar.entrySet().iterator();
        
        while (iterator.hasNext()) {
            Map.Entry<String, Personaje> entry = iterator.next();
            Personaje p = entry.getValue();

            System.out.println(p);
            System.out.println("Queres borrar este personaje?");
            System.out.println("1 ---- Si | 2 ---- No");
            int decision = pedirNumero();

            while (decision != 1 && decision != 2) {
                System.out.println("Opcion invalida. Intenta de nuevo");
                decision = pedirNumero();
            }

            if (decision == 1) {
                iterator.remove();
                System.out.println("Personaje eliminado");
            } else {
                System.out.println("Personaje conservado");
            }

            System.out.println("---------------------------------------");
        }
        System.out.println("Revision de personajes finalizada");
    }

    //Enunciado 9
    public static HashMap<String, Item> comprobarItemsFicheros(File fichero) {
        HashMap<String, Item> mapaItems = new HashMap<>();
    
        try {
            FileReader lector = new FileReader(fichero);
            BufferedReader lectorLinea = new BufferedReader(lector);
    
            String linea;
            while ((linea = lectorLinea.readLine()) != null) {
                // Separar por delimitador (",")
                String[] partes = linea.split(",");
    
                if (partes.length >= 6) {
                    String nombre = partes[0];
                    String tipoTexto = partes[1];
                    int precio = Integer.parseInt(partes[2]);
                    int atk = Integer.parseInt(partes[3]);
                    int def = Integer.parseInt(partes[4]);
                    int hp = Integer.parseInt(partes[5]);
    
                    Item.Tipo tipo;
    
                    switch (tipoTexto.toLowerCase()) {
                        case "curativo":
                            tipo = Item.Tipo.Curativo;
                            break;
                        case "armadura":
                            tipo = Item.Tipo.Armadura;
                            break;
                        default:
                            System.out.println("Tipo no reconocido para el ítem: " + nombre + ". Se omitirá.");
                            continue; // salta este ítem
                    }
    
                    Item nuevoItem = new Item(nombre, tipo, precio, atk, def, hp);
                    mapaItems.put(nombre, nuevoItem); // si ya existe, lo reemplaza
                }
            }
    
            lectorLinea.close();
    
        } catch (IOException e) {
            System.out.println("Error leyendo el fichero: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error de formato en valores numéricos.");
        }
    
        // Revisión de ítems uno a uno con opción de eliminar
        Iterator<Map.Entry<String, Item>> iterator = mapaItems.entrySet().iterator();
    
        while (iterator.hasNext()) {
            Map.Entry<String, Item> entry = iterator.next();
            Item item = entry.getValue();
    
            System.out.println("Item encontrado: " + item);
            System.out.println("¿Deseás borrar este item?");
            System.out.println("1 = Sí | 2 = No");
    
            int decision = pedirNumero();
            while (decision != 1 && decision != 2) {
                System.out.println("Opción inválida. Introduce 1 para borrar o 2 para conservar.");
                decision = pedirNumero();
            }
    
            if (decision == 1) {
                iterator.remove();
                System.out.println("Item eliminado.");
            } else {
                System.out.println("Item conservado.");
            }
    
            System.out.println("------------");
        }
    
        System.out.println("Proceso de revisión de ítems finalizado.");
        return mapaItems;
    }

    //Ampliacion de la ampliacion

    public static void menuJuego() {
        boolean seguir = true;
        while (seguir) {
            System.out.println("1 ---- Editar Lista Personajes"); //Ejercicio 8
            System.out.println("2 ---- Editar Lista Objetos"); //Ejercicio 9
            System.out.println("3 ---- Crear personaje custom"); //Dara la opcion de crear un personaje, crear un enemigo o protagonista al usuario (Sin armadura ni items en el caso de protagonista) y lo añadira al juego
            System.out.println("4 ---- Crear item custom"); //Dara la opcion de crear un item, ya se armadura o curativo, y lo añadira al juego
            System.out.println("5 ---- Jugar"); 
            System.out.println("6 ---- Salir"); //Ejercicio 8
            int eleccion = pedirNumero();
            switch (eleccion) {
                case 1:
                //Agregar tambien que pueda elegir crear uno y meto el metodo
                    System.out.println("Ingrese el nombre de su fichero");
                    String ruta = TECLADO.nextLine();
                    File fichero = new File(ruta);
                    comprobarPersonajesBinario(fichero);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de su fichero");
                    String ruta2 = TECLADO.nextLine();
                    File fichero2 = new File(ruta2);
                    comprobarItemsFicheros(fichero2);
                    break;
                case 3:
                    submenu();
                    break;
                case 4:
                    crearItem();
                    break;
                case 5:
                    jugar();
                    break;
                case 6:
                    seguir = false;
                default:
                    System.out.println("Opcion incorrecta, ingresa tu eleccion de nuevo");
                    break;
            }
        }
    }

    public static void jugar() {
        boolean ok = true;
        Protagonista elegido = null;
        while (ok) {
            System.out.println("1 ---- Elegir Personaje\n 2 ---- Elegir Aleatorio");
            int eleccion = pedirNumero();
            switch (eleccion) {
                case 1:
                    for (Personaje perso : LISTAPERSONAJES.values()) {
                        if (perso instanceof Protagonista) {
                            System.out.println(perso);
                        }
                    }
                    System.out.println("Ingresa el nombre del personaje que quieras utiliar");
                    String nombre = TECLADO.nextLine();
                    if (LISTAPERSONAJES.containsKey(nombre)) {
                        //elegido = LISTAPERSONAJES.get(nombre);
                    } else {
                        System.out.println("El personaje que seleccionaste no existe. Prueba con otro");
                    }
                    break;
                case 2: 
                    int random = (int) (Math.random() * LISTAPERSONAJES.size());
                    ArrayList<Personaje> aux = new ArrayList<>(LISTAPERSONAJES.values());
                    for (Personaje personaje : aux) {
                        if (personaje instanceof Protagonista) {
                            //elegido = aux.get(random);
                        }
                    }
                default:
                    System.out.println("Opcion incorrecta, ingresa tu eleccion de nuevo");
                    break;
            }
        }
        System.out.println("Introducir dificultad del juego\n 1 ---- Facil\n 2 ---- Dificil");
        int dificultad = pedirNumero();
        if (dificultad == 1) {
            ArrayList<Item> aux = new ArrayList<>(LISTAITEMS.values());
            int random = (int) (Math.random() * aux.size());
            elegido.setArmadura(aux.get(random));
            elegido.setOro(20);
        } if (dificultad == 2) {
            
        } else {
            
        }

        
    }

    public static void funcionamientoJuego(Protagonista p) {
        boolean ok = true;
        while (ok) {
            ArrayList<Enemigo> aux = new ArrayList<>();
            for (Map.Entry<String, Personaje> personaje : LISTAPERSONAJES.entrySet()) {
                if (personaje.getValue() instanceof Enemigo) {
                    aux.add((Enemigo) personaje.getValue());
                }
            }
            int random = (int) (Math.random() * aux.size());
            Enemigo e = aux.get(random);
            boolean seguir = true;
            while (seguir) {
                System.out.println("Tu enemigo es: " + e);
                System.out.println("1 ---- Atacar\n 2 ---- Item\n 3 ---- Salir");
                int eleccion = pedirNumero();
                if (eleccion == 1) {
                    e.recibirDano(p.getAtk());
                } else if (eleccion == 2) {
                    System.out.println("Nuestro inventario de items");
                    for (Item bolsita : LISTAITEMS.values()) {
                        System.out.println(bolsita);
                    }
                    System.out.println("Selecciona el nombre del item a usar");
                    String nombre = TECLADO.nextLine();
                    Item seleccionado = null;
                    if (LISTAITEMS.containsKey(nombre)) {
                    seleccionado = LISTAITEMS.get(nombre);
                    } else {
                        System.out.println("El item seleccionado no existe, prueba otro");
                    }
                } else if (eleccion == 3) {
                    seguir = false;
                } else {
                    System.out.println("Eleccion incorrecta. Prueba eligiendo otra opcion.");
                }

                if (e.getHp() > 0) {
                    p.recibirDano(e.getAtk());
                } else {
                    ok = false;
                }

                if (p.getHp() > 0) {
                    e.recibirDano(p.getAtk());
                } else {
                    ok = false;
                }
            }
        }
    }

    public static void submenu() {
        boolean ok = true;
        while (ok) {
            System.out.println("Menu de Creacion\n 1 --- Crear Personaje\n 2 --- Crear Enemigo\n 3 --- Crear Protagonista");
            System.out.println("Introduce tu eleccion");
            int eleccion = pedirNumero();
            switch (eleccion) {
                case 1:
                    crearPersonaje();
                    break;
                case 2:
                    crearEnemigo();
                    break;
                case 3:
                    crearProtagonista();
                    break;
                default:
                    System.out.println("Opcion incorrecta, por favor ingresa una de las 3 opciones que aparecen en pantalla");
                    break;
            }
        }
    }

    public static Personaje crearPersonaje(){
        Personaje p1 = null;
        System.out.println("Ingresa el nombre de tu protagonista");
        String nombre = TECLADO.nextLine();
        System.out.println("Ingresa el ataque de tu protagonista");
        int ataque = pedirNumero();
        System.out.println("Ingresa la defensa de tu protagonista");
        int defensa = pedirNumero();
        System.out.println("Ingresa la vida de tu protagonista");
        int vida = pedirNumero();
        p1 = new Personaje(nombre, ataque, defensa, vida);
        return p1;
    }

    public static Enemigo crearEnemigo(){
        Enemigo e1 = null;
        System.out.println("Ingresa el nombre de tu protagonista");
        String nombre = TECLADO.nextLine();
        System.out.println("Ingresa el ataque de tu protagonista");
        int ataque = pedirNumero();
        System.out.println("Ingresa la defensa de tu protagonista");
        int defensa = pedirNumero();
        System.out.println("Ingresa la vida de tu protagonista");
        int vida = pedirNumero();
        System.out.println("Ingresa las veces que fue derrotado tu enemigo");
        int derrotado = pedirNumero();
        System.out.println("Ingresa el oro que da tu enemigo al ser derrotado");
        int oro = pedirNumero();
        e1 = new Enemigo(nombre, ataque, defensa, vida, derrotado, oro);
        LISTAPERSONAJES.put(nombre, e1);
        return e1;
    }


    public static Protagonista crearProtagonista(){
        Protagonista p1 = null;
        System.out.println("Ingresa el nombre de tu protagonista");
        String nombre = TECLADO.nextLine();
        System.out.println("Ingresa el ataque de tu protagonista");
        int ataque = pedirNumero();
        System.out.println("Ingresa la defensa de tu protagonista");
        int defensa = pedirNumero();
        System.out.println("Ingresa la vida de tu protagonista");
        int vida = pedirNumero();
        System.out.println("Ingresa la cantidad de oro que tiene tu protagosnita");
        int oro = pedirNumero();
        p1 = new Protagonista(nombre, ataque, defensa, vida, oro);
        LISTAPERSONAJES.put(nombre, p1);
        return p1;
    }

    public static Item crearItem() {
        Item i = null;
        System.out.println("Igresa el nombre de tu item");
        String nombre = TECLADO.nextLine();
        System.out.println("Ingresa la rareza de la armadura: ");
        Item.Tipo.mostrarTipos();
        String tipo_aux = TECLADO.nextLine();
        Item.Tipo tipo;
        if (tipo_aux.equalsIgnoreCase("Basico")) {
            tipo = Item.Tipo.Basica;
        } else if (tipo_aux.equalsIgnoreCase("Normal")) {
            tipo = Item.Tipo.Normal;
        } else if (tipo_aux.equalsIgnoreCase("Rara")) {
            tipo = Item.Tipo.Rara;
        } else if (tipo_aux.equalsIgnoreCase("Epica")) {
            tipo = Item.Tipo.Epica;
        } else if (tipo_aux.equalsIgnoreCase("Mitica")) {
            tipo = Item.Tipo.Mitica;
        } else {
            tipo = Item.Tipo.Legendaria;
        }
        System.out.println("Ingresa el precio de tu armadura");
        int precio = pedirNumero();
        System.out.println("Ingresa el ataque de tu armadura");
        int ataque = pedirNumero();
        System.out.println("Ingresa la defensa de tu armadura");
        int defensa = pedirNumero();
        System.out.println("Ingresa la vida de tu armadura");
        int vida = pedirNumero();
        i = new Item(nombre, tipo, precio, ataque, defensa, vida);
        LISTAITEMS.put(nombre, i);
        return i;
    }

    public static File crearFichero() {

        File fichero = null;
        try {
            fichero = new File("fichero.txt");
            if (!fichero.exists()) {
                fichero.createNewFile();
            }

            //Escribir en el fichero
            FileWriter escribir = new FileWriter(fichero);
            BufferedWriter escribir_linea = new BufferedWriter(escribir);

            boolean seguir = true;
            while (seguir) {
                System.out.println("Bienvenido al modificador del fichero");
                System.out.println("Opcion --- 1 Agregar un item\n Opcion 2 --- Salir del editor de texto");
                int eleccion = pedirNumero();
                switch (eleccion) {
                    case 1:
                        System.out.println("Un item tiene: nombre, tipo de armadura, precio, ataque, defensa, y hp. Introduce cada valor separado por una coma");
                        String linea = TECLADO.nextLine();
                        escribir_linea.write(linea);
                        break;
                    case 2: 
                        seguir = false;
                        break;
                    default:
                        System.out.println("Eleccion incorrecta. Vuelve a introducir la opcion a elegir");
                        break;
                }
            }
            escribir_linea.close();
        } catch (Exception e) {
            System.out.println("Error. xd");
        }
        return fichero;
    }

    public static int pedirNumero() {
        int num = 0;
        boolean ok = false;
        while (!ok) {
            try {
                num = TECLADO.nextInt();
                ok = true;
            } catch (Exception e) {
                TECLADO.nextLine();
                System.out.println("Error. Introduce un numero entero");
            }
        }
        return num;
    }
}
