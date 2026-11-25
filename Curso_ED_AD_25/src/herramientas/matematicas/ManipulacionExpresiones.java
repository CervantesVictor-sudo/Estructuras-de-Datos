package herramientas.matematicas;

import EntradaSalida.Salida;
import edlineal.PilaEstatica;

public class ManipulacionExpresiones {
    public static String infijaPrefija(String infija){
        return "";
    }

    public static String infijaPostfija(String prefija){
        return "";
    }

    public static Double evaluarInfija(String infija){
        //Primero se tendria que convertir a prefija o postfija.
        //Por ejemplo, invocando al metodo que convierte de infija a postfija(infija).
        //Despues, se tendria que invocar al metodo de evaluacion de esa expresion.
        //Por ejemplo, al de evaluarPostfija(postfija).
        return 0.0;
    }

    public static Double evaluarPrefija(String prefija){
        return 0.0;
    }

    public static Double evaluarPostfija(String postfija){
        PilaEstatica pila = new PilaEstatica(postfija.length());
        //Tomando como base una expresion postfija
        // 9  3  9  5  -  /  4  2  ^  *  +
        // 0. 1. 2. 3. 4. 5. 6. 7. 8. 9. 10. postoken
        for (int posToken = 0; posToken < postfija.length(); posToken++){
            //Pasos:
            //1. Tokenizar de izquierda ->> derecha.
            char token = postfija.charAt(posToken);
            //2. Si el token es:
            if (esOperando(token) == true){
                //   a) Si es operando, se mete en la pila.
                if(pila.meter(token+"")==false){ //ERROR
                    return null;
                }
            } else {
                //   b) Si es operador, sacar dos operandos de la pila (el primero es OP2), se hace el
                //      calculo con ese operador y se mete en la pila.
               String op2 = (String)pila.sacar();
               String op1 = (String)pila.sacar();
               Double operando1 = (Double.parseDouble(op1));
               Double operando2 = (Double.parseDouble(op2));
               Double resultado = calculo(token, operando1, operando2);
               Salida.terminal("op1: " + operando1+" " + token);
               Salida.terminal(" op2: " + operando2);
               Salida.terminal(" -- Calculo: " + resultado + "\n");
               if (pila.meter(resultado+"") == false){
                return null; //ERROR
               }
            }
        }
        //3. El resultado final está en la pila.
        String resultadoFinal = (String)pila.sacar();
        return Double.parseDouble(resultadoFinal);
    }

    public static boolean esOperando(char token){
        if (token == '+'){
            return false;
        } else if (token == '-'){
            return false;
        } else if (token == '*'){
            return false;
        } else if (token == '/'){
            return false;
        } else if (token == '^'){
            return false;
        } else if (token == '%'){
            return false;
        } else if (token == '('){
            return false;
        } else if (token == ')'){
            return false;
        } else { //NO es ninguno de arriba, por lo tanto ES operando
            return true;
        }
    }

    public static Double calculo(char oper, double op1, double op2){
        if (oper == '+'){
            return op1 + op2;
        }  else if (oper == '-'){
            return op1 - op2;
        } else if (oper == '*'){
            return op1 * op2;
        } else if (oper == '/'){
            if (op2 != 0){
                return op1 / op2;
            } else {
                return null;
            }
        } else if (oper == '^'){
            return Math.pow(op1, op2);
        } else if (oper == '%'){
            return op1 % op2;
        } else { //ERROR
            return null;
        }
    }
}
