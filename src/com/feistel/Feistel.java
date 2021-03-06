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
    /*
    Para manipular el bloque de 64 bits utilice el tipo long con su clase wrapper Long
    con el fin manipular de forma directa los bits ya que el tipo long es de 64 bits
    */
    
    //mensaje almacena el mensaje a encriptar/desencriptar
    private String mensaje;
    private String claveBits;
    //clave es la clave inicial que se usa para encriptar
    private Long clave;
    //bloque derecho
    private Long derecha;
    private Long izquierda;
    
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
            ochoBits = completarBits(ochoBits,8);
            binario = binario + ochoBits;
        } 
        return binario;
    }
    
    
    /**
     * completa la cadena en binario si le faltan bits a la izquierda con 0
     * @param completar cadena que contiene el binario a completar
     * @param size tamano total del bloque de bits
     * @return 
     */
    private String completarBits(String completar,int size){
        while(completar.length()<size){
                completar="0"+completar;
        }
        return completar;
    }
    
    /**
     * 
     * @param bloque64Bits mensaje codificado en binario de 64bits de longitud
     * @param key clave de 64 bits
     * @return 
     */
    public String rondaCifrado(String bloque64Bits,String key){
        //define el total de bits en 64 bits
        int n =64;
        //mitad de bits (32 bits)
        int mitad = n/2;
        String primerMitad="";
        String segundaMitad="";
        //obtiene los primeros 32 bits del bloque
        primerMitad = bloque64Bits.substring(0,mitad);
        //obtiene los segundos 32 bits del bloque
        segundaMitad = bloque64Bits.substring(mitad,n);
        //convierte el numero binario a un objeto Long 
        this.izquierda = Long.parseLong(primerMitad, 2);
        this.derecha = Long.parseLong(segundaMitad, 2);
        Long derechaInicial = derecha;
        this.clave = Long.parseUnsignedLong(key,2);
       //Se aplica la funcion f a la parte derecha con la clave
        this.derecha = funcion(this.derecha,this.clave);
        //Se hace XOR a la parte derecha con la izquierda
        this.derecha = this.derecha^this.izquierda;
        //el bloque izquierdo ahora toma el valor del valor que tenia el bloque derecho
        this.izquierda=derechaInicial;
        //
        primerMitad = Long.toBinaryString(this.izquierda);
        primerMitad = completarBits(primerMitad,32);
        segundaMitad = Long.toBinaryString(this.derecha);
        segundaMitad = completarBits(segundaMitad,32);
        this.mensaje = primerMitad+segundaMitad;
        return mensaje;
    }
    
    public String rondaDescifrado(String bloque64Bits,String key){
         //define el total de bits en 64 bits
        int n =64;
        //mitad de bits (32 bits)
        int mitad = n/2;
        String primerMitad="";
        String segundaMitad="";
        //obtiene los primeros 32 bits del bloque
        primerMitad = bloque64Bits.substring(0,mitad);
        //obtiene los segundos 32 bits del bloque
        segundaMitad = bloque64Bits.substring(mitad,n);
        //convierte el numero binario a un objeto Long 
        this.izquierda = Long.parseLong(primerMitad, 2);
        this.derecha = Long.parseLong(segundaMitad, 2);
        Long izquierdaInicial = izquierda;
        this.clave = Long.parseUnsignedLong(key,2);
        //Se aplica la funcion f a la parte izquierda con la clave
        this.izquierda = funcion(this.izquierda,this.clave);
        //Se hace XOR a la parte derecha con la izquierda
        this.izquierda = this.izquierda^this.derecha;
        //el bloque izquierdo ahora toma el valor del valor que tenia el bloque derecho
        this.derecha=izquierdaInicial;
        //
        primerMitad = Long.toBinaryString(this.izquierda);
        primerMitad = completarBits(primerMitad,32);
        segundaMitad = Long.toBinaryString(this.derecha);
        segundaMitad = completarBits(segundaMitad,32);
        this.mensaje = primerMitad+segundaMitad;
        return mensaje;
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
    
    public Long modulo32(Long l){
        return l % ((long)Math.pow(2, 32));
    }
    
    private Long funcion(Long parte, Long key){
        Long resultadoFuncion = modulo32(parte^key);
        return resultadoFuncion;
    }
    
    public String getMensaje(){
        return this.mensaje;
    }
    
    public void setMensaje(String msj){
        this.mensaje = binario(msj.getBytes());
    }
    
    public void setClaveBits(String clave){
        this.claveBits = binario(clave.getBytes());
    }
    
    public void cifrar(){
        for(int i=0;i<16;i++){
            this.mensaje = rondaCifrado(this.mensaje,this.claveBits);
        }
        
    }
    
    public void descifrar(){
        for(int i=0;i<16;i++){
            this.mensaje = rondaDescifrado(this.mensaje,this.claveBits);
        }
    }
    
    public String binaryToString(String binary){
        
        int n = binary.length()/8;
        String msj="";
        int asciicode;
        int begin = 0;
        int end = 8;
        for(int i = 0; i < n; i++){
            String cadena = binary.substring(begin, end);
            System.out.println(cadena);
            msj+=(char)Integer.parseInt(cadena,2);
            begin = end;
            end=end+8;
        }
        
        return msj;
    }
    
}
