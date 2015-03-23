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
public class Feistel {
    
    //mensaje almacena el mensaje a encriptar/desencriptar
    private String mensaje;
    //clave es la clave inicial que se usa para encriptar
    private String clave;
    
    /**
     * 
     * @param bloque es un bloque de bytes que se desea pasar a binario
     * @return cadena que representa el bloque en binario
     */
    public String binario(byte[] bloque){
        String binario="";
        String ochoBits;
        for(int i=0;i<bloque.length;i++){
            ochoBits = Integer.toBinaryString(bloque[i]);
            if(ochoBits.length()==7){
                ochoBits="0"+ochoBits;
            }
            binario = binario + ochoBits;
        } 
        return binario;
    }
    
    /**
     * 
     * @param msj mensaje a aplicarle xor
     * @param key llave con la que se trabaja
     * @return cadena resultante de aplicar la funcion XOR a mensaje y llave
     */
    public String xor(String msj, String key){
        
        return "";
    }
    
}
