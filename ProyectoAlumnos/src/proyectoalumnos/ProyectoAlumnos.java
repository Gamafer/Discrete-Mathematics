/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoalumnos;

import java.util.Scanner;

/**
 *
 * @author garro
 */
public class ProyectoAlumnos {

    public static String[] altaGrupo1(){
        String array[]=new String[50];
        Scanner entrada=new Scanner(System.in);
        System.out.println("Cuantos alumnos hay en el grupo 1?");
        String cadena=entrada.nextLine();
        int i=Integer.parseInt(cadena);
        
        for(int cont=0; cont<i; cont++){
            System.out.println("Ingresa la matricula del alumno"+(cont+1)+"del grupo 1");
            cadena=entrada.nextLine();
            array[cont]=cadena;
        }
        return array;
        
    }
    
    public static String[] altaGrupo2(){
        String array[]=new String[50];
        Scanner entrada=new Scanner(System.in);
        
        System.out.println("Cuantos alumnos hay en el grupo 2?");
        String cadena=entrada.nextLine();
        int i=Integer.parseInt(cadena);
        
        for(int cont=0; cont<i; cont++){
            System.out.println("Ingresa la matricula del alumno"+(cont+1)+"del grupo 2");
            cadena=entrada.nextLine();
            array[cont]=cadena;
        }
       return array;
        
    }
   
    public static String[] generaGrupo(String x[], String x1[]){
        String arrayG[]=new String[100];
        int cont1=0;
        for(int cont=0; cont<x.length; cont++){
            arrayG[cont]=x[cont];
            cont1++;
        }
        
        for(int cont=0; cont<x.length; cont++){
            boolean res=true;
            for(int i=0; i<cont1; i++){
                if(x1[cont].equals(arrayG[i]))
                    res=false;
            }
            if(res)
                arrayG[cont+cont1]=x1[cont];
        }
        return arrayG;
    }
    
    public static String[] generaMismoGrupo(String x[], String x1[]){
        String arrayG[]=new String[100];
        int cont1=0;
        for(int i=0; i<x.length; i++){
            boolean res=false;
            for(int cont=0; i<x1.length; i++){
                if(x[i].equals(x1[cont]))
                    res=true;
            }
            if (res){
                arrayG[cont1]=x[i];
                cont1++;
            }
        }
        
        return arrayG;
    }
    
    
    public static String[] generaParejas(String x[], String x1[]){
        String arrayG[]=new String[10000];
        int cont1=0;
        for(int i=0; i<x.length; i++){
            for(int cont=0; i<x1.length; i++){
                if(!(x[i].equals(x1[cont])))
                    arrayG[cont1]=x[i]+x1[cont];
            }
            
        }
        
        return arrayG;
    }
    
    public static String[] orden(String x[]){
        String arrayG[]=new String[10000];
        int cont1=0;
        
        
        return arrayG;
    }
    
    
    
    public static void main(String[] args) {
        String arrayGrupo1[]=new String[100];
        arrayGrupo1=altaGrupo1();
        //System.out.print(arrayGrupo1);
        
        String arrayGrupo2[]=new String[100];
        arrayGrupo2=altaGrupo2();
        //System.out.print(arrayGrupo2);
        
        String arrayGrupoJunto[]=new String[100];
        arrayGrupoJunto=generaGrupo(arrayGrupo1, arrayGrupo2);
        //System.out.print(arrayGrupoJunto[3]);
        System.out.print(arrayGrupo1[1]);
    
    }
}
