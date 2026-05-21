package veterinaria;

public class Pila {

    private Nodo cima;

    public Pila() {
        cima = null;
    }

    public void apilar(Object dato) {

        Nodo nuevo = new Nodo(dato);

        nuevo.setSiguiente(cima);

        cima = nuevo;
    }

    public Object desapilar() {

        if (esVacia()) {
            return null;
        }

        Object dato = cima.getDato();

        cima = cima.getSiguiente();

        return dato;
    }

    public Object peek() {

        if (esVacia()) {
            return null;
        }

        return cima.getDato();
    }

    public int tamanio() {

        int contador = 0;

        Nodo aux = cima;

        while (aux != null) {
            contador++;
            aux = aux.getSiguiente();
        }

        return contador;
    }

    public boolean esVacia() {
        return cima == null;
    }

    public boolean contiene(Object dato) {

        Nodo aux = cima;

        while (aux != null) {

            if (aux.getDato().equals(dato)) {
                return true;
            }

            aux = aux.getSiguiente();
        }

        return false;
    }

    public void limpiar() {
        cima = null;
    }

    public void mostrar() {

        if (esVacia()) {
            System.out.println("La pila está vacía");
            return;
        }

        Nodo aux = cima;

        while (aux != null) {
            System.out.println(aux.getDato());
            aux = aux.getSiguiente();
        }
    }

    public Object buscar(Object dato) {

        Nodo aux = cima;

        while (aux != null) {

            if (aux.getDato().equals(dato)) {
                return aux.getDato();
            }

            aux = aux.getSiguiente();
        }

        return null;
    }
}
