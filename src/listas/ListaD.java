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
public abstract class ListaD extends Lista {
    
    // Declaracion de atributos
    protected NodoDoble inicio;
    protected NodoDoble ultimo;
    
    // Sobrecarga de metodos
    public boolean vacio(){
        return inicio == null;
    }
    
    public void imprimir(){
       // super.setInicio(inicio);
       // super.imprimir();
        
        NodoDoble actual = inicio;
        while (actual != null){
            System.out.print(actual.getDato() + " --> ");
            actual = actual.siguiente;
        }
    }
    
    // Metodo para imprimir a la inversa
    public void imprimirAlReves(){
        NodoDoble actual = ultimo;
            while(actual != null){
                System.out.print(actual.getDato() + " < -- ");
                actual = actual.getAnterior();
            }
    }
}
