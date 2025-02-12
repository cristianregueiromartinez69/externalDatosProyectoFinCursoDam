package com.finproyectodam.external_datos.usuarios.registrousuarios.service.comprobaciones;

/**
 * Clase encargada de realizar diversas comprobaciones sobre la validez de una contraseña.
 * @author cristian && Joel
 * @version 1.0
 */
public class ComprobacionesPassword {

    /**
     * Metodo para comprobar autenticación de contraseña en registro de usuario
     * @param password la contraseña
     * @return true o false dependiendo de si la introduces bien o mal
     */
    public boolean authenticationRegisterPassword(String password){
        return checkLengthPassword(password) && checkPasswordHasStrangeThings(password) &&
                checkPaswordHasNumbers(password);
    }

    /**
     * Metodo para comprobar si la contraseña del usuario tiene 12 o más caracteres
     * @param password la contraseña proporcionada
     * @return true o false si cumple los requisitios
     */
    public boolean checkLengthPassword(String password){

        return password.length() >= 12;
    }

    /**
     * Metodo para comprobar si la contraseña introducida tiene al menos 1 caracter especial
     * @param password la contraseña introducida
     * @return true o false dependiendo de la contraseña
     */
    public boolean checkPasswordHasStrangeThings(String password){
        //array con los caracteres especiales
        char[] caracteres = {'!', '|', '@', '"', '#', '·', '~', '$', '%', '€','¬','&','/','(',')','=','?','¿'
                ,'¡','<','>','+','-','*','^','[',']','¨','{','}',',',';',':','_','`','´'};

        return extracted(password, caracteres);
    }

    /**
     * Metodo para comprobar que la contraseña tiene al menos 1 número
     * @param password la contraseña introducida
     * @return true o false dependiendo de la contraseña proporcionada
     */
    public boolean checkPaswordHasNumbers(String password){

        //array de numeros
        char [] numbers = {'1','2','3','4','5','6','7','8','9','0'};

        return extracted(password, numbers);
    }

    private static boolean extracted(String password, char[] numbers) {
        //array de letras de la contraseña
        char [] passwordChars = password.toCharArray();

        //bucle anidado para comprobar la coincidencia
        for (char number : numbers) {
            for (char passwordChar : passwordChars) {
                if (number == passwordChar) {
                    return true;
                }
            }
        }
        return false;
    }
}
