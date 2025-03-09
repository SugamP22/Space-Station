import java.util.Arrays;

public class EstacionEspacial {
    private Modulo[] modulo;

    public EstacionEspacial() {
        this.modulo = new Modulo[20]; // Initialize an array of 20 modules
    }

    public Modulo[] getModulo() {
        return modulo;
    }

    public void setModulo(Modulo[] modulo) {
        this.modulo = new Modulo[20];
    }

    // Add a module to the station
    public boolean agregarModulo(Modulo m1) {
        for (int i = 0; i < modulo.length; i++) {
            if (modulo[i] == null) {
                modulo[i] = m1;
                return true;
            }
        }
        return false; // No space to add a new module
    }

    // Remove a module by its name
    public boolean eliminarModulo(String nombre) {
        for (int i = 0; i < modulo.length; i++) {
            if (modulo[i] != null && modulo[i].getNombre().equalsIgnoreCase(nombre)) {
                modulo[i] = null;
                // Shift remaining modules to fill the gap
                for (int j = i; j < modulo.length - 1; j++) {
                    modulo[j] = modulo[j + 1];
                }
                modulo[modulo.length - 1] = null;
                return true;
            }
        }
        return false; // Module not found
    }

    // List all modules
    public boolean listarModulo() {
        boolean flag = false;
        for (int i = 0; i < modulo.length; i++) {
            if (modulo[i] != null) {
                System.out.printf("Módulo en posición %d : %s\n", i + 1, modulo[i]);
                flag = true;
            }
        }
        return flag;
    }

    // Count the total number of inhabitants in all modules
    public int numeroTotalHabitantes() {
        int contador = 0;
        for (int i = 0; i < modulo.length; i++) {
            if (modulo[i] != null) {
                for (int j = 0; j < modulo[i].getHabitantes().length; j++) {
                    if (modulo[i].getHabitantes()[j] != null) {
                        contador++;
                    }
                }
            }
        }
        return contador; // Return the total count of inhabitants
    }

    @Override
    public String toString() {
        return "EstacionEspacial [modulo=" + Arrays.toString(modulo) + "]";
    }
}
