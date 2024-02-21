package Tema4.DeepSpaceConqueror;

public class Planeta implements IAtacable{

    public static final int NUM_MAX_MINAS = 10;
    public static final int NUM_MAX_NAVES_ORBITANDO = 100;
    public static final int UNIDADES_PIEDRA_DEFAULT = 5;
    public static final int UNIDADES_HIERRO_DEFAULT = 4;
    public static final int UNIDADES_COMBUSTIBLE_DEFAULT = 2;
    public static final int HABITANTES_DEFAULT = 30;
    public static final int NUEVOS_HABITANTES_POR_HORA = 2;

    private String nombre;
    private Jugador conquistador;
    private int numHabitantes;

    //materias primas
    private int unidadesPiedras;
    private int unidadesHierro;
    private int unidadesCombustible;

    //Construcciones del planeta
    private Mina[] minas;
    private EscudoProtector escudo;

    //naves orbitando en el planeta
    private Nave[] navesOrbitando;

    /*
    Lista en la que se incluirá a todos aquellos juagdores que, antes de que el planeta esté conquistado, mueven
    habitantes al mismo. Una vez el planeta se conquiste , se ignora.
     */
    private Jugador[] jugadoresMuevenHabitantes;

    //Evitar que se pueda construir si no se ha movido al menos una persona


    public Planeta(String nombre) throws InvalidValueException{
        if (nombre.isBlank()){
            throw new InvalidValueException("El nombre del planeta no puede estar en blanco");
        }
        this.nombre = nombre;

        //Inicializamos con valores por defecto
        unidadesPiedras = Planeta.UNIDADES_PIEDRA_DEFAULT;
        unidadesHierro = Planeta.UNIDADES_HIERRO_DEFAULT;
        unidadesCombustible = Planeta.UNIDADES_COMBUSTIBLE_DEFAULT;

        //Ponemos el número de habitantes por defecto
        numHabitantes = Planeta.HABITANTES_DEFAULT;

        //Inicializamos el array de minas
        minas = new Mina[Planeta.NUM_MAX_MINAS];

        //Inicializamos el array de naves orbitando
        navesOrbitando = new Nave[Planeta.NUM_MAX_NAVES_ORBITANDO];
    }

    /**
     *Transladamos los ataques y los puntos de defensa al escudo, en caso de que haya
     */
    @Override
    public int getPuntosDefensa() {
        int puntosDefensa = 0;

        if (escudo != null){
            puntosDefensa = escudo.getPuntosDefensa();
        }
        return puntosDefensa;
    }

    /**
     * Transladamos el ataque al escudo. Si el planeta no tenía escudo, directamente se lanza la excepción
     * DestructionException, marcando que ha sido conquistado. Si tras el ataque los puntos del escudo llegan a 0,
     * también ocurrirá lo mismo. Si el escudo se destryye , las personas asignadas al mismo deben volver al total de
     * habitantes.
     * @param puntosDaño El daño que le inflingen. Si el resultado de restar los puntos es negativo, se lanzará
     *                   una excepción DestructionException
     * @throws InvalidValueException
     * @throws DestructionException
     * @throws JuegoException
     */
    @Override
    public void serAtacado(int puntosDaño) throws InvalidValueException, DestructionException, JuegoException {

    }
}
