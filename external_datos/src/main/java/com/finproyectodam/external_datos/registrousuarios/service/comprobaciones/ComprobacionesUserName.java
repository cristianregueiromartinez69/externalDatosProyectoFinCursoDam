package com.finproyectodam.external_datos.registrousuarios.service.comprobaciones;

/**
 * Clase encargada de realizar diversas comprobaciones sobre la validez de un alias.
 * Incluye métodos para verificar el formato, la presencia de caracteres no permitidos, y la validez del dominio.
 * @author cristian && Joel
 * @version 1.0
 */
public class ComprobacionesUserName {

    /**
     * Metodo que engloba a los metodos de autenticación de username al registrarse en la pagina web
     * @param name el username a pasar
     * @return True o False dependiendo del nombre introducido
     */
    public boolean authenticationRegisterName(String name){

        return lengthUserName(name) && isDigitUserName(name) && strangeCharactersUsername(name);
    }

    /**
     * Metodo para comprobar si un nombre tiene 2 o más letras (existen usernames con 2 letras, por ejemplo, Ed)
     *
     * @param name el nombre que le vamos a pasar
     * @return True o False en caso de tener menos o mas letras
     */
    public boolean lengthUserName(String name) {

        return name.length() >= 2;
    }

    /**
     * Metodo para comprobar que no se introducen numeros en el username de una persona
     * @param name el nombre a introducir
     * @return True o False dependiendo del nombre que introdujeras
     */
    public boolean isDigitUserName(String name) {

        //se realiza un array de chars con los numeros y un array de chars con el string
        char[] numeros = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] chars = name.toCharArray();
        //con un bucle recorremos el array de letras y con otro anidado el de numeros
        for (char letra : chars) {

            //si alguna letra coincide con un numero, el metodo devuelve false
            for(char numero:numeros){
                if (letra == numero){
                    return false;
                }
            }

        }
        return true;

    }

    /**
     * Metodo para comprobar que no se introducen carácteres extraños en los username de registro
     * @param name el nombre que vas a introducir
     * @return True o False dependiendo del nombre introducido
     */
    public boolean strangeCharactersUsername(String name){
        //mismo procedimiento que en el metodo anterior pero con caracteres extraños
        char[] caracteres = {'!', '|', '@', '"', '#', '·', '~', '$', '%', '€','¬','&','/','(',')','=','?','¿'
                ,'¡','º','ª','<','>','+','-','*','^','[',']','¨','{','}',',',';',':','_','`','´'};
        char[] chars = name.toCharArray();
        for (char letra : chars) {

            for(char numero:caracteres){
                if (letra == numero){
                    return false;
                }
            }

        }
        return true;

    }
}
