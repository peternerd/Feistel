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
        String msj = "diamantes";
        String clave = "diamante";
        
        int n = msj.length();
        int mitad= msj.length()/2;
        int nBits = n*8;
        int mitadBits= mitad*8;
        byte msjBytes[] = msj.getBytes();
        //System.out.println(msjBytes[0]);
        String bits = Integer.toBinaryString(msjBytes[0]);
        //System.out.println(bits);
        //System.out.println(mitadBits);
        
        Feistel f = new Feistel();
        f.getBloques(msj);
        System.out.println(f.xor("1101","110"));
        Long l = Long.parseUnsignedLong("9223372036854775807");
        Long l2 =Long.parseUnsignedLong("9223372036854775809");
        Long l3 = Long.valueOf(l.longValue()^l2.longValue());
        System.out.println(Long.toBinaryString(l.longValue()));
        System.out.println(Long.toBinaryString(l2.longValue()));
        System.out.println(Long.toBinaryString(l3.longValue()));
       
	
    }
    
    
    
}
