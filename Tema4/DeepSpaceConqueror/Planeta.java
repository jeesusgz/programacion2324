package Tema4.DeepSpaceConqueror;

import java.util.Arrays;

public class Planeta implements IAtacable{

    public static final int NUM_MAX_MINAS = 10;
    public static final int NUM_MAX_NAVES_ORBITANDO = 100;
    public static final int UNIDADES_PIEDRA_DEFAULT = 5;
    public static final int UNIDADES_HIERRO_DEFAULT = 4;
    public static final int UNIDADES_COMBUSTIBLE_DEFAULT = 2;
    public static final int HABITANTES_DEFAULT = 30;
    public static final int NUEVOS_HABITANTES_POR_RONDA = 2;

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
     * @throws InvalidValueException si puntosDaño es 0 o menor que 0
     * @throws DestructionException Si el planeta ha sido conquistado
     * @throws JuegoException Si el planeta no estaba conquistado previamente
     */
    @Override
    public void serAtacado(int puntosDaño) throws InvalidValueException, DestructionException, JuegoException {
        if (this.conquistador == null){
            throw new JuegoException("Un planeta sin conquistar no puede ser atacado");
        }

        //Si el planeta no tiene escudo y es atacado, pasa a ser del jugador atacante
        if (this.escudo == null){
            //Lanzamos DestructionException para marcar que ha sido conquistado
            throw new DestructionException();
        }

        try{
            this.escudo.serAtacado(puntosDaño);
        }
        catch (DestructionException e){
            /*
            El escudo ha sido destruido. pasamos las personas asignadas a los habitantes y marcamos el escudo
            como null
             */

            this.escudo = null;
            this.numHabitantes += EscudoProtector.PERSONAS_ASIGNADAS_ESCUDO_PROTECTOR;

            //avisamos de la conquista
            throw new DestructionException();
        }
    }

    /**
     * El conquistador del planeta cambia
     * @param j El jugador que ha conquistado el plantea
     */
    public void conquistar(Jugador j){
        this.conquistador = j;
    }

    /**
     *
     * @return el nombre del planeta
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @return el jugador conquistador del planeta o null si no está conquistado
     */
    public Jugador getConquistador() {
        return conquistador;
    }

    /**
     *
     * @return el número de habitantes del planeta
     */
    public int getNumHabitantes() {
        return numHabitantes;
    }

    /**
     *
     * @return el número de habitantes del planeta
     */
    public int getUnidadesPiedras() {
        return unidadesPiedras;
    }

    /**
     *
     * @return las unidades de hierro que hay en el planeta
     */
    public int getUnidadesHierro() {
        return unidadesHierro;
    }

    /**
     *
     * @return las unidades de combustible que hay en el planeta
     */
    public int getUnidadesCombustible() {
        return unidadesCombustible;
    }

    /**
     *
     * @return las minas del planeta
     */
    public Mina[] getMinas() {
        return minas;
    }

    /**
     *
     * @return el escudo protector, si lo hay y si no null
     */
    public EscudoProtector getEscudo() {
        return escudo;
    }

    /**
     * Devuelve el número de minas activas en el planeta
     * @return el número de minas en el planeta
     */
    public int getNumMinasActivas(){
        int minas = 0;

        for (Mina m : this.minas){
            if (m != null){
                minas++;
            }
        }
        return minas;
    }

    public void addNaveOrbitando(Nave n) throws JuegoException{
        boolean added = false;

        for (int i = 0; i < this.navesOrbitando.length && !added; i++) {
            if (this.navesOrbitando[i] == null){
                this.navesOrbitando[i] = n;
                added = true;
            }
        }

        if (!added){
            throw new JuegoException("No se puede añadir la nave");
        }
    }

    /**
     * Elimina una nave de la órbita de un planeta
     * @param n la nave a eliminar
     * @throws JuegoException si la nave no orbita en dicho planeta
     */
    public void deleteNaveOrbitando(Nave n)throws JuegoException{
        boolean deleted = false;

        for (int i = 0; i < this.navesOrbitando.length && !deleted; i++) {
            if (this.navesOrbitando[i] == n){
                this.navesOrbitando[i] = null;
                deleted = true;
            }
        }

        if (!deleted){
            throw new JuegoException("La nave no está orbitando este planeta");
        }
    }

    /**
     * Devuelve el array de naves que orbita el planeta, reduciendo al número concreto de naves que lo orbita.
     * @return un array con las naves exactas que están orbitando un planeta
     */
    public Nave[] getNavesOrbitando() {
        /**
         * Vamos a contar primero las naves que orbitan este planeta.
         *
         * Creamos un array que contendrá las naves que orbitan dicho planeta.
         * El tamaño de dicho array será por tanto, el número de naves que lo orbita.
         */
        Nave[] navesOrbitanPlaneta = new Nave[this.getNumNavesOrbitando()];

        int i = 0;
        for (Nave n : this.navesOrbitando){
            if (n != null){
                navesOrbitanPlaneta[i++] = n;
            }
        }

        return navesOrbitanPlaneta;
    }

    /**
     * Devuelve el número de naves que orbitan este planeta (No el tamaño del array, sino el número de naves que
     * orbita)
     * @return El número de naves que está actualmente orbitando este planeta
     */
    public int getNumNavesOrbitando(){
        int naves = 0;

        for (Nave n: this.navesOrbitando){
            if (n != null){
                naves++;
            }
        }
        return naves;
    }

    /**
     * Añade las unidades pasadas como parámetro a las cantidades existentes del material.
     * Solo se admiten hierro, piedra y combustible. Cualquier otro valor provoca el lanzamiento de la excepción
     * InvalidValuesException
     * @param material el material que queremos añadir
     * @param unidades la cantidad de unidades de material que añadiremos
     * @throws InvalidValueException si intentamos añadir 0 ó un número negativo de unidades, o un material diferente
     * de los aceptados
     */
    public void addUnidadesDeMateriaPrima(TMateriales material, int unidades) throws InvalidValueException{
        if (unidades <= 0){
            throw new InvalidValueException("No puedes añadir 0 o un número negativo de unidades");
        }

        //Vamos a ver que materiales añadimos
        if (material.equals(TMateriales.HIERO)){
            this.unidadesHierro += unidades;
        } else if (material.equals(TMateriales.PIEDRA)) {
            this.unidadesPiedras += unidades;
        } else if (material.equals(TMateriales.COMBUSTIBLE)) {
            this.unidadesCombustible += unidades;
        }else {
            throw new InvalidValueException("No puedes añadir al planeta este material: " + material.toString());
        }
    }

    /**
     * Aumenta la población de este planeta en el número de habitantes marque la constante
     * Planeta.NUEVOS_HABITANTES_POR_RONDA
     */
    public void aumentarPoblacionTrasRonda(){
        this.numHabitantes += Planeta.NUEVOS_HABITANTES_POR_RONDA;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Planeta{");

        sb.append("{").append(System.lineSeparator())
                .append(this.getNombre()).append(System.lineSeparator())
                .append("Conquistador: ").append(this.getConquistador() == null ? "No conquistado" : this.getConquistador().getNombre())
                .append(". Habitantes: ").append(this.getNumHabitantes())
                .append(". Materias primas: ")
                .append("[Piedra: ").append(this.getUnidadesPiedras())
                .append(". Hierro: ").append(this.getUnidadesHierro())
                .append(". Combustible: ").append(this.getUnidadesCombustible())
                .append("]").append(System.lineSeparator())
                .append("Minas: ");

        if (this.getNumMinasActivas() > 0){
            sb.append("[[");
            int numMinas = 1;

            for (Mina m : this.minas){
                if (m != null){
                    sb.append(numMinas++).append("@ Material: ")
                            .append(m.getMaterial().toString()).append(". ")
                            .append(m.getCantidadExtraidaTurno()).append(" unidades por turno")
                            .append(System.lineSeparator());
                }
            }

            sb.append("]]").append(System.lineSeparator());
        }else {
            sb.append("[[Sin minas activas]]");
        }

        //Por último, la información del escudo protector
        sb.append(System.lineSeparator()).append("Escudo protector: ");

        if (this.getEscudo() != null){
            sb.append("[[").append(this.getEscudo().getPuntosDefensa())
                    .append(" puntos de defensa restantes]]");
        }else{
           sb.append("[[Sin escudo protector]]");
        }

        sb.append(System.lineSeparator()).append("}").append(System.lineSeparator());
        return sb.toString();
    }
}
