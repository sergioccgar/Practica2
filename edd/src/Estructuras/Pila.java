package edd.src.Estructuras;

/**
 * Clase que representa una pila 
 * @author Ulmo y alumnos de EDD.
 */
public class Pila<T> extends PushPop<T>{
    
    /**
     * 
     * 
     * @param elemento Es el elemento que se quiere anexar a la pila (al frente de la estructura).
     */
    public void push(T elemento){
        if(elemento == null){
            throw new IllegalArgumentException("");
        }
        Nodo aux = new Nodo(elemento);
        if(isEmpty()){
            this.cabeza=ultimo=aux;
            longi++;
            return ;
        }
        aux.siguiente = cabeza;
        cabeza = aux;
        longi ++;
    }

    /**
     * Regresa una copia de la pila.
     * 
     * @return nueva  (copia de la pila).
     */
    public Pila<T> clone(){
        Pila<T> nueva = new Pila<T>();
        Pila<T> aux = new Pila<T>();

        if (this.isEmpty()) {
            return nueva;
        }
        Nodo aux2 = this.cabeza;

        while(aux2 != null) {
            aux.push(aux2.elemento);
            aux2 = aux2.siguiente;
        }
        while(!aux.isEmpty()) {
            nueva.push(aux.pop());
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
