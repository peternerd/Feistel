/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feistel;

import java.math.BigDecimal;

/**
 *
 * @author pedro
 */
public class Feistel {
    
    //mensaje almacena el mensaje a encriptar/desencriptar
    private String mensaje;
    //clave es la clave inicial que se usa para encriptar
    private String clave;
    //bloque derecho
    private String derecha;
    private String izquierda;
    
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
            while(ochoBits.length()<8){
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
        String xorMsj="";
        int resultado;
        
        return xorMsj;
    }
    
    public String ronda(){
        
        return "";
    }
    
    /**
     * 
     * @param msj mensaje del cual se desea saber su longitud
     * @return la longitud del mensaje
     */
    public int getLongitudMensaje(String msj){
        return msj.length();
    }
    
    /**
     * 
     * @param msj mensaje a obtener bits
     * @return longitud del mensaje en bits
     */
    public int getBits(String msj){
        return getLongitudMensaje(msj)*8;
    }
    
    /**
     * 
     * @param msj mensaje
     * @return bloques de 64 bits que ocupa un mensaje
     */
    public byte[][] getBloques(String msj){
        
        int nbloques = (int)Math.ceil(getLongitudMensaje(msj)/8.0);
        byte bloques[][]=new byte[nbloques][8];
        return bloques;
    }
    
}
