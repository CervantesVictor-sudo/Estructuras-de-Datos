package ExamenPrimerParcial;

import edlineal.PilaEstatica;

public class BalanceoPila {
    
    public static boolean validarExpresion(String expresion) {
        PilaEstatica pilaSimbolos = new PilaEstatica(expresion.length());
        
        for (int posicionCaracter = 0; posicionCaracter < expresion.length(); posicionCaracter++) {
            char caracterActual = expresion.charAt(posicionCaracter);
            
            // Caso para comentarios de múltiples líneas /** ... **/
            if (posicionCaracter < expresion.length() - 2 && expresion.charAt(posicionCaracter) == '/' && 
                expresion.charAt(posicionCaracter + 1) == '*' && expresion.charAt(posicionCaracter + 2) == '*') {
                
                pilaSimbolos.meter("/**");
                posicionCaracter += 2; // Saltamos los caracteres adicionales del comentario

            // Caso para comentarios de una línea /* ... */
            }else if (posicionCaracter < expresion.length() - 1 && expresion.charAt(posicionCaracter) == '/' && 
                     expresion.charAt(posicionCaracter + 1) == '*') { 
            
                pilaSimbolos.meter("/*");
                posicionCaracter += 1; // Saltamos el siguiente carácter del comentario

            }else if (caracterActual == '(' || caracterActual == '[' || caracterActual == '{') {// Símbolos de apertura
                pilaSimbolos.meter(caracterActual);
            }
            else if (caracterActual == ')' || caracterActual == ']' || caracterActual == '}') { // Verificación de cierres
                if (pilaSimbolos.vacia()) {
                    return false; // Cierre sin apertura correspondiente
                }
                
                char simboloAperturaEsperado = obtenerSimboloAperturaCorrespondiente(caracterActual);
                Object simboloTopePila = pilaSimbolos.sacar();
                
                if (simboloTopePila instanceof Character) {
                    if ((char)simboloTopePila != simboloAperturaEsperado) {
                        return false; // El símbolo de apertura no coincide con el cierre
                    }
                } else {
                    return false; // Tipo de símbolo inesperado en la pila
                }

            // Cierre de comentarios **/
            }else if (posicionCaracter < expresion.length() - 2 && expresion.charAt(posicionCaracter) == '*' && 
                     expresion.charAt(posicionCaracter + 1) == '*' && expresion.charAt(posicionCaracter + 2) == '/') {
                
                if (pilaSimbolos.vacia()) {
                    return false; // Cierre de comentario sin apertura
                }
                
                Object simboloTopePila = pilaSimbolos.sacar();
                if (!simboloTopePila.equals("/**")) {
                    return false; // El cierre no coincide con la apertura esperada
                }
                posicionCaracter += 2; // Saltamos los caracteres adicionales del cierre
            }
            // Cierre de comentarios */
            else if (posicionCaracter < expresion.length() - 1 && 
                     expresion.charAt(posicionCaracter) == '*' && 
                     expresion.charAt(posicionCaracter + 1) == '/') {
                
                if (pilaSimbolos.vacia()) {
                    return false; // Cierre de comentario sin apertura
                }
                
                Object simboloTopePila = pilaSimbolos.sacar();
                if (!simboloTopePila.equals("/*")) {
                    return false; // El cierre no coincide con la apertura esperada
                }
                posicionCaracter += 1; // Saltamos el siguiente carácter del cierre
            }
        }
        
        // Si la pila no está vacía, hay símbolos de apertura sin cerrar
        return pilaSimbolos.vacia();
    }
    
    private static char obtenerSimboloAperturaCorrespondiente(char simboloCierre) {
        if (simboloCierre == ')') {
            return 'C';
        }else if (simboloCierre == ']') {
            return '[';
        }else if (simboloCierre == '}') {
            return '{';
        }else{
            return ' ';
        }
    }
}