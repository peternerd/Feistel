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
        String msjBinario;
        String keyBinario;
        
        Feistel f = new Feistel();
        byte msjBytes[] = msj.getBytes();
        byte keyBytes[] = clave.getBytes();
        msjBinario = f.binario(msjBytes);
        keyBinario = f.binario(keyBytes);
        
        System.out.println(msjBinario);
        System.out.println(f.rondaCifrado(msjBinario, keyBinario));
        System.out.println(f.getMensaje()+"\t cifrado");
        System.out.println(f.rondaDescifrado(f.getMensaje(), keyBinario));         
        
       
	
    }
    
    
    
}
