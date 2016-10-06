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
public class ListaDoble extends ListaD {

// Implementa todos los metodos que la clase listaD hereda de la clase Lista.
    @Override
    public void insertaInicio(Object dato) {
        if (vacio())
            inicio = ultimo = new NodoDoble(dato);
        else{
            NodoDoble nuevo = new NodoDoble(dato,inicio,null);
            inicio.setAnterior(nuevo);
            inicio = nuevo;
        }
    }

    @Override
    public void insertaFinal(Object dato) {
         if(vacio()){
            inicio = ultimo = new NodoDoble(dato);
        }   else    {
            NodoDoble aux = new NodoDoble(dato,null,ultimo);
            aux.anterior = ultimo;
            ultimo.siguiente = aux;
            ultimo = aux;
        }
    }

    @Override
    public Object eliminaInicio() {
        Object eliminado = null;
        if (vacio()){
            System.out.println("\nLa lista no contiene nada \n\n");
        }   else    {
            eliminado = inicio.getDato();
            if(inicio == ultimo){
                inicio = ultimo = null;
                System.out.println("\nLa lista no contiene nada \n\n");
            }   else    {
                inicio = inicio.siguiente;
                inicio.anterior = null;
            }
            
        }
        return eliminado;
    }

   @Override 
    public Object eliminaFinal() {
       Object eliminado = null;
        if (vacio()){
            System.out.println("\nLa lista no contiene nada \n\n");
        }   else    {
            eliminado = ultimo.getDato();
            if(inicio == ultimo){
                inicio = ultimo = null;
                System.out.println("\nLa lista no contiene nada \n\n");
            }   else    {
                ultimo = ultimo.anterior;
                ultimo.siguiente = null;
            }
            
        }
        return eliminado;
    }
    
    public void insertarOrdenado(int dato){
        if (vacio())
            insertaInicio(dato);
        else{
            if (inicio == ultimo){ //Solamente hay un nodo en la lista
                if (dato < (Integer)inicio.getDato()){ //Compara los datos de los nodos
                    insertaInicio(dato);
                    inicio.anterior = null;
                    inicio.siguiente = ultimo;
                }
                else{
                    insertaFinal(dato);
                    ultimo.anterior = inicio;
                    ultimo.siguiente = null;                 
                }
            }
            else{//La lista contiene más de un elemento [Revisar los apuntadores]
                NodoDoble anterior = null, ini = inicio, ult = ultimo;
                while(ini != null && dato > (Integer)ini.getDato()){
                    ini.anterior = null;
                    anterior = ini;
                    ini.siguiente = ult;
                    ult.siguiente = null;
                }
                if (anterior == null){
                    insertaInicio(dato);
                    inicio.anterior = null;
                    anterior = inicio;
                    inicio.siguiente = null;
                }
                else
                    if (ini == null){
                        insertaFinal(dato);
                        ini = inicio;
                        inicio.anterior = null;
                        inicio.siguiente = ult;
                        ult.siguiente = null;
                    } 
                    else{
                        NodoDoble nuevo = new NodoDoble(dato,inicio,ultimo);
                        anterior.siguiente = nuevo;
                        inicio = nuevo;
                        
                    }
            }
        }
    }
    
    
    public static void main(String[] args) {
        
        ListaDoble listaD = new ListaDoble();
        
        
        listaD.insertaInicio("Ligada");
        listaD.insertaInicio("Doblemente");
        listaD.insertaInicio("Lista");
        listaD.insertaInicio("Una");
        listaD.insertaInicio("Es");
        listaD.insertaInicio("Esta");
        listaD.insertaInicio("Hola");
        
        listaD.insertaFinal("By Dany");
        
        listaD.eliminaInicio();
        
        listaD.eliminaFinal();
        
        /*listaD.insertarOrdenado(5);
        listaD.insertarOrdenado(10);
        listaD.insertarOrdenado(19);
        listaD.insertarOrdenado(1);
        listaD.insertarOrdenado(0);
        listaD.insertarOrdenado(100);*/
       
        
        
        System.out.println("Imprimiendo la lista normal...\n");
        listaD.imprimir();
        System.out.println("\n\n\n\nImprimiendo la lista en orden inverso...\n");
        listaD.imprimirAlReves();
    }
}
