package veterinaria;

public class Cola {

    private Nodo frente;
    private Nodo fin;

    public Cola() {
        frente = null;
        fin = null;
    }

    public void encolar(Object dato) {

        Nodo nuevo = new Nodo(dato);

        if (esVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }

    public Object desencolar() {

        if (esVacia()) {
            return null;
        }

        Object dato = frente.getDato();

        frente = frente.getSiguiente();

        if (frente == null) {
            fin = null;
        }

        return dato;
    }

    public Object peek() {

        if (esVacia()) {
            return null;
        }

        return frente.getDato();
    }

    public int tamanio() {

        int contador = 0;

        Nodo aux = frente;

        while (aux != null) {
            contador++;
            aux = aux.getSiguiente();
        }

        return contador;
    }

    public boolean esVacia() {
        return frente == null;
    }

    public boolean contiene(Object dato) {

        Nodo aux = frente;

        while (aux != null) {

            if (aux.getDato().equals(dato)) {
                return true;
            }

            aux = aux.getSiguiente();
        }

        return false;
    }

    public void limpiar() {
        frente = null;
        fin = null;
    }

    public void mostrar() {

        if (esVacia()) {
            System.out.println("La cola está vacía");
            return;
        }

        Nodo aux = frente;

        while (aux != null) {
            System.out.println(aux.getDato());
            aux = aux.getSiguiente();
        }
    }
}
