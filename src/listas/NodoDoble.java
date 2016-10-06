/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author hkroot
 */
public class NodoDoble extends Nodo {
    
    // Declaracion de atributos
    protected NodoDoble anterior;
    protected NodoDoble siguiente;

    // Contructores
    public NodoDoble(Object dato, NodoDoble siguiente, NodoDoble anterior) {
        super(dato);
        this.anterior = anterior;
        this.siguiente = siguiente;
    }

    public NodoDoble(Object dato) {
        super(dato);
    }
    
    // Metodos para obtener y modificar los atributos
    /**
     * @return the anterior
     */
    public NodoDoble getAnterior() {
        return anterior;
    }

    /**
     * @param anterior the anterior to set
     */
    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

    /**
     * @return the siguiente
     */
    public NodoDoble getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
