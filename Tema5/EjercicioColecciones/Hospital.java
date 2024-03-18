package Tema5.EjercicioColecciones;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Hospital {
    private static int ticket = 1;
    LinkedList<Paciente> pacientes;

    public Hospital() {
        this.pacientes = new LinkedList<>();
    }

    public void addPaciente(Paciente paciente){
        Iterator<Paciente> it = pacientes.iterator();
        int pos = 0;
        boolean encontrado = false;

        while (it.hasNext() && !encontrado){
            Paciente paciente1 = it.next();

            if (paciente.compareTo(paciente1) < 0){
                encontrado = true;
            }
            else {
                pos++;
            }
        }

        pacientes.add(pos, paciente);
    }

    public List<Paciente> listadoDePacientesOrdenadoPorPrioridad(){
        return (LinkedList<Paciente>) pacientes.clone();
    }

    public Paciente atenderPaciente(){
        return pacientes.poll();
    }

    public List<Paciente> listadoPacientesEdad(){
        return pacientes.stream().sorted((p1, p2) -> p2.getEdad() - p1.getEdad()).toList();
    }

    public String datosEstadisticos(){
        StringBuilder datos = new StringBuilder();

        for (int i = 0; i < Paciente.MIN_PRIORIDAD; i++) {
            int finalI = i;
            List<Paciente> pacientesFiltrados = pacientes.stream().filter(p -> p.getPrioridad() == finalI).toList();

            datos.append("\n Hay ").append(pacientes.stream().filter(p -> p.getPrioridad() == finalI).count())
                    .append(" pacientes esperando de prioridad").append(i).append("\n");
            datos.append("\n El paciente más adulto es: ")
                    .append(pacientes.stream().mapToInt(Paciente::getEdad).max())
                    .append("\n")
                    .append(" y el paciente más joven es: ")
                    .append(pacientes.stream().mapToInt(Paciente::getEdad).min()).append("\n")
                    .append(" y la media de edad es: ")
                    .append(pacientes.stream().mapToInt(Paciente::getEdad).average().orElse(0));
        }
        return datos.toString();
    }
}
