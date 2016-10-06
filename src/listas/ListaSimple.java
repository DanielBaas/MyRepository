/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import listas.Alumno;

/**
 *
 * @author Root
 */
public class ListaSimple extends Lista{

    public void insertaInicio(Object dato) {
        if (vacio()) {
            inicio = ultimo = new Nodo(dato);
        } else {
            inicio = new Nodo(dato, inicio);
        }
    }
    
    public void insertaFinal(Object dato) {
        if (vacio()) {
            inicio = ultimo = new Nodo(dato);
        } else {
            Nodo temporal = new Nodo(dato);
            ultimo.setSiguiente(temporal);
            ultimo = temporal;
        }
    }

    public Object eliminaInicio() {
        Object eliminado;
        
        if (vacio()) {
            eliminado = null;
        } else {
            eliminado = inicio.getDato();
            inicio = inicio.getSiguiente();
        }
        
        return eliminado;
    }

    public Object eliminaFinal() {
        Object eliminado = null;
        Nodo actual = inicio;
        
        if (vacio()) {
            eliminado = null;
        } else {
            while (actual != null) {
                if (actual.getSiguiente().getSiguiente() == null) {
                    eliminado = actual.getSiguiente().getDato();
                    ultimo = actual;
                }
            }
        }
        
        return eliminado;
    }
    
    public Object get(int index){
        Object elemento = null;
        Nodo actual = inicio;   
        int contador = 0;
        
        while (actual != null) {
            if (contador == index) {
                return actual.getDato();
            } else {
                actual = actual.getSiguiente();
                contador++;
            }
        }
        
        return elemento;
    }
    
    public void insertaOrdenado(int dato){
        if (vacio())
            insertaInicio(dato);
        else
            if (inicio == ultimo){ //Solamente hay un nodo en la lista
                if (dato < (Integer)inicio.getDato()) //Compara los datos de los nodos
                    insertaInicio(dato);
                else
                    insertaFinal(dato);
            }
            else{//La lista contiene más de un elemento
                Nodo antes = null, despues = inicio;
                while(despues != null && dato > (Integer)despues.getDato()){
                    antes = despues;
                    despues = despues.getSiguiente();
                }
                if (antes == null)
                    insertaInicio(dato);
                else
                    if (despues == null)
                        insertaFinal(dato);
                    else{
                        Nodo nuevo = new Nodo(dato,despues);
                        antes.setSiguiente(nuevo);
                    }
            }
    }
    
        public void insertaOrdenado(Alumno alumno){
        if (vacio())
            insertaInicio(alumno);
        else
            if (((Alumno)inicio.getDato()).getEdad() == ((Alumno)ultimo.getDato()).getEdad()){ 
                if (alumno.getEdad() < ((Alumno)inicio.getDato()).getEdad())
                    insertaInicio(alumno);
                else
                    insertaFinal(alumno);
            }
            else{//La lista contiene más de un elemento
                Nodo antes = null, despues = inicio;
                while(despues != null && alumno.getEdad() > ((Alumno)despues.getDato()).getEdad()){
                    antes = despues;
                    despues = despues.getSiguiente();
                }
                if (antes == null)
                    insertaInicio(alumno);
                else
                    if (despues == null)
                        insertaFinal(alumno);
                    else{
                        Nodo nuevo = new Nodo(alumno,despues);
                        antes.setSiguiente(nuevo);
                    }
            }
    }
        

    
    public static void main(String[] args) {
        
        ListaSimple lista = new ListaSimple();
        
        Alumno alumno1 = new Alumno("Daniel", "Baas", 22);  
        Alumno alumno2 = new Alumno("Fernando", "Ortiz", 30);
        Alumno alumno3 = new Alumno("José", "Rodríguez", 17);
        Alumno alumno4 = new Alumno("Andrés", "Pérez", 28);  
        Alumno alumno5 = new Alumno("Esteban", "Cárdenas", 16);
        Alumno alumno6 = new Alumno("Manuel", "Hernández", 40);
        
        lista.insertaOrdenado(alumno1);
        lista.insertaOrdenado(alumno2);
        lista.insertaOrdenado(alumno3);
        lista.insertaOrdenado(alumno4);
        lista.insertaOrdenado(alumno5);
        lista.insertaOrdenado(alumno6);
        
        lista.imprimir();
    }
}
