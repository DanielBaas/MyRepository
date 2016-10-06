/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author rafael
 */
public class Nodo {
    protected Object dato;
    protected Nodo siguiente;
    
    public Nodo(){
        
    }
    
    public Nodo(Object dato){
        this.dato = dato;
    }
    
    public Nodo(Object dato, Nodo siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public Object getDato() {
        return dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
}
