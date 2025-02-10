package com.finproyectodam.external_datos.registrousuarios.service.comprobaciones;

public class ComprobacionesEmail {

    public boolean authenticationRegisterEmail(String email){

        return checkArobaEmailFirstLetter(email) && checkEmailHasAAroba(email) && checkEmailHasAArobaMoreThan1Time(email) &&
                checkPuntoEmailFirstLetter(email) && checkEmailHasAAPoint(email) && checkEmailHasAPointMoreThan1Time(email)
                && checkStrangeThingInEmail(email) && checkDomainEmail(email);
    }

    /**
     * Metodo que comprueba si la primera letra del email es un @
     * @param email el nombre que pasamos
     * @return True o False dependiendo del nombre
     */
    public boolean checkArobaEmailFirstLetter(String email){

        char aroba = '@';

        //hacemos un array de letras con el nombre
        char [] chars = email.toCharArray();

        //comprobamos mediante un bucle si la primera letra es un @, si es así devuelve false
        for(int i = 0; i < chars.length; i++){

            if(chars[0] == aroba){
                return false;
            }
        }
        return true;

    }


    /**
     * Metodo para comprobar si el email lleva o no lleva aroba
     * @param email el nombre a pasarle
     * @return True o False dependiendo del nombre que le pasemos
     */
    public boolean checkEmailHasAAroba(String email){

        //declaramos la variable char con el aroba y un array de letras del nombre a pasar
        char aroba = '@';
        char [] chars = email.toCharArray();

        //bucle para buscar el @
        for(char c : chars){

            //si la encuentra devuelve true
            if(c == aroba){
                return true;
            }

        }
        return false;
    }

    /**
     * Metodo para comprobar si el email lleva aroba más de 1 vez
     * @param email el nombre a pasarle
     * @return True o False dependiendo del nombre que le pasemos
     */
    public boolean checkEmailHasAArobaMoreThan1Time(String email){

        //declaramos la variable char con el aroba y un array de letras del nombre a pasar
        char aroba = '@';
        char [] chars = email.toCharArray();
        int contador = 0;

        //bucle para buscar el @
        for(char c : chars){

            //si la encuentra devuelve true
            if(c == aroba){
                contador++;
            }
            if(contador > 1){
                return false;
            }

        }
        return true;
    }

    /**
     * Metodo para comprobar si el email lleva o no lleva punto
     * @param email el nombre a pasarle
     * @return True o False dependiendo del nombre que le pasemos
     */
    public boolean checkEmailHasAAPoint(String email){

        //declaramos la variable char con el punto y un array de letras del nombre a pasar
        char punto = '.';
        char [] chars = email.toCharArray();

        //bucle para buscar el punto
        for(char c : chars){

            //si la encuentra devuelve true
            if(c == punto){
                return true;
            }

        }
        return false;
    }

    /**
     * Metodo que comprueba si la primera letra del email es un punto
     * @param email el nombre que pasamos
     * @return True o False dependiendo del nombre
     */
    public boolean checkPuntoEmailFirstLetter(String email){

        char punto = '.';

        //hacemos un array de letras con el nombre
        char [] chars = email.toCharArray();

        //comprobamos mediante un bucle si la primera letra es un punto, si es así devuelve false
        for(int i = 0; i < chars.length; i++){

            if(chars[0] == punto){
                return false;
            }
        }
        return true;

    }

    /**
     * Metodo para comprobar si el email lleva punto más de 1 vez
     * @param email el nombre a pasarle
     * @return True o False dependiendo del nombre que le pasemos
     */
    public boolean checkEmailHasAPointMoreThan1Time(String email){

        //declaramos la variable char con el punto y un array de letras del nombre a pasar
        char punto = '.';
        char [] chars = email.toCharArray();
        int contador = 0;

        //bucle para buscar el @
        for(char c : chars){

            //si la encuentra devuelve true
            if(c == punto){
                contador++;
            }
            if(contador > 1){
                return false;
            }

        }
        return true;
    }

    /**
     * Metodo que comprueba si se introducen caracteres extraños en el email
     * @param email el email a introducir
     * @return true o false dependiendo del email
     */
    public boolean checkStrangeThingInEmail(String email){

        //array de caracteres no permitidos en email
        char [] strangeCharacters = {' ', '!', '#', '$', '%', '^', '&', '*', '(', ')', '=', '[', ']',
                '<', '>', ',', '"', '/', ';', '?'};

        //pasamos a array de letras el email introducido
        char[] chars = email.toCharArray();
        for (char letra : chars) {

            //bucle anidado para comprobar si hay coincidencias de caracteres extraños
            for(char letraRara:strangeCharacters){
                if (letra == letraRara){
                    return false;
                }
            }

        }
        return true;
    }

    /**
     * Metodo para comprobar si un email tiene un dominio válido o no
     * @param email el email proporcionado
     * @return true o false dependiendo del email introducido
     */
    public boolean checkDomainEmail(String email){

        //array de Strings con los dominios más populares de emails
        String [] domains = {"@gmail.com", "@outlook.com","@hotmail.com","@yahoo.com","@icloud.com",
                "@zoho.com","@protonmail.com","@mail.com","@aol.com","@gmx.com","@yandex.com","@tutanota.com"};

        //bucle for para averiguar si coincide el email con los dominios
        for(int i = 0; i < domains.length; i++){
            if(email.endsWith(domains[i])){
                return true;
            }
        }

        return false;
    }

}
