package veterinaria;

public class Lista {

    private Nodo cabeza;

    public Lista() {
        cabeza = null;
    }

    public void agregar(Object dato) {

        Nodo nuevo = new Nodo(dato);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {

            Nodo aux = cabeza;

            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }

            aux.setSiguiente(nuevo);
        }
    }

    public void agregarAlInicio(Object dato) {

        Nodo nuevo = new Nodo(dato);

        nuevo.setSiguiente(cabeza);

        cabeza = nuevo;
    }

    public void agregarEnPosicion(int indice, Object dato) {

        if (indice < 0 || indice > cuentaElementos()) {
            System.out.println("Índice inválido");
            return;
        }

        if (indice == 0) {
            agregarAlInicio(dato);
            return;
        }

        Nodo nuevo = new Nodo(dato);

        Nodo aux = cabeza;

        for (int i = 0; i < indice - 1; i++) {
            aux = aux.getSiguiente();
        }

        nuevo.setSiguiente(aux.getSiguiente());

        aux.setSiguiente(nuevo);
    }

    public void eliminarPrimero() {

        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }

        cabeza = cabeza.getSiguiente();
    }

    public void eliminarUltimo() {

        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }

        if (cabeza.getSiguiente() == null) {
            cabeza = null;
            return;
        }

        Nodo aux = cabeza;

        while (aux.getSiguiente().getSiguiente() != null) {
            aux = aux.getSiguiente();
        }

        aux.setSiguiente(null);
    }

    public void eliminarEnPosicion(int indice) {

        if (indice < 0 || indice >= cuentaElementos()) {
            System.out.println("Índice inválido");
            return;
        }

        if (indice == 0) {
            eliminarPrimero();
            return;
        }

        Nodo aux = cabeza;

        for (int i = 0; i < indice - 1; i++) {
            aux = aux.getSiguiente();
        }

        aux.setSiguiente(aux.getSiguiente().getSiguiente());
    }

    public Object buscarDato(int indice) {

        if (indice < 0 || indice >= cuentaElementos()) {
            return null;
        }

        Nodo aux = cabeza;

        for (int i = 0; i < indice; i++) {
            aux = aux.getSiguiente();
        }

        return aux.getDato();
    }

    public Object buscarDato(Object dato) {

        Nodo aux = cabeza;

        while (aux != null) {

            if (aux.getDato().equals(dato)) {
                return aux.getDato();
            }

            aux = aux.getSiguiente();
        }

        return null;
    }

    public boolean contiene(Object dato) {

        Nodo aux = cabeza;

        while (aux != null) {

            if (aux.getDato().equals(dato)) {
                return true;
            }

            aux = aux.getSiguiente();
        }

        return false;
    }

    public int cuentaElementos() {

        int contador = 0;

        Nodo aux = cabeza;

        while (aux != null) {
            contador++;
            aux = aux.getSiguiente();
        }

        return contador;
    }

    public void limpiar() {
        cabeza = null;
    }


    public void mostrarAdelante() {

        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }

        Nodo aux = cabeza;

        while (aux != null) {
            System.out.println(aux.getDato());
            aux = aux.getSiguiente();
        }
    }

    private void mostrarAtrasRecursivo(Nodo nodo) {

        if (nodo == null) {
            return;
        }

        mostrarAtrasRecursivo(nodo.getSiguiente());

        System.out.println(nodo.getDato());
    }

    public void mostrarAtras() {

        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }

        mostrarAtrasRecursivo(cabeza);
    }
}
