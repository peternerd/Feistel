/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feistel;

/**
 *
 * @author pedro
 */
public class Test {
    
    public static void main(String args[]){
        //Maximo valor 9223372036854775807 en 63 bits
        /*
        XOR
        0   0   |0
        0   1   |1
        1   0   |1
        1   1   |0
        */
        String msj = "diamante";
        String clave = "diamante";
        String binario;
        Feistel f = new Feistel();
        byte msjBytes[] = msj.getBytes();
        binario = f.binario(msjBytes);
        System.out.println(binario);
        System.out.println(f.ronda(binario, clave));
         
        
       
	
    }
    
    
    
}
