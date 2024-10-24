/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Bryan
 */
public class Hash {
    public static String toSHA1(String contraseña) {
        try {
            // Crear una instancia de MessageDigest para SHA-1
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            // Actualizar el MessageDigest con los bytes del String
            byte[] inputBytes = contraseña.getBytes();
            md.update(inputBytes);

            // Calcular el digest (el hash)
            byte[] digest = md.digest();

            // Convertir el resultado a una cadena hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < digest.length; i++) {
                String hex = Integer.toHexString(0xff & digest[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } 
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("No se pudo encontrar el algoritmo SHA-1", e);
        }
    }
}
