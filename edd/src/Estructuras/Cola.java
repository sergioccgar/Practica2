package edd.src.Estructuras;

/**
 * Clase que representa una cola 
 * @author Irvin y Sergio.
 */
public class Cola<T> extends PushPop<T> {

    /**
     * Anexa un elemento al final de la cola
     * 
     * @param elemento Es el elemento que se quiere anexar.
     */
    public void push(T elemento){
        if(elemento == null){
            throw new IllegalArgumentException("");
        }

        Nodo aux = new Nodo(elemento);
        if(isEmpty()){
            this.cabeza = ultimo =aux;
            longi++;
            return ;
        }
        this.ultimo.siguiente = aux;
        ultimo = aux;
        longi++;    
    }

    /**
     * Regresa una copia de la cola.
     * 
     * @return nueva (copia de la cola).
     */
    public Cola<T> clone(){
        Cola<T> nueva = new Cola<T>();
        if (this.isEmpty()) {
            return nueva;
        }
        nueva.push(this.cabeza.elemento);
        Nodo n = this.cabeza;
        while (n.siguiente != null) {
           nueva.push(n.siguiente.elemento);
           n = n.siguiente;
        }
        return nueva;
    }

    /**
     * Regresa una representación en cadena de la pila.
     * 
     * @return regreso (representación en cadena de la coleccion).
     * a, b, c, d
     */
    public String toString(){
        if (this.isEmpty()) {
            return "";
        }
        String regreso = this.cabeza.elemento.toString();
        Nodo n = this.cabeza;
        while (n.siguiente != null) {
            regreso += ", " + n.siguiente.elemento.toString();
            n = n.siguiente;
        }
        return regreso;
    } 
}
