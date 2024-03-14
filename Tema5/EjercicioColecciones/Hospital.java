package Tema5.EjercicioColecciones;

import java.util.Iterator;
import java.util.LinkedList;

public class Hospital {
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
}
