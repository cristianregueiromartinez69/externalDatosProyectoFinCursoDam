package com.finproyectodam.external_datos;

import com.finproyectodam.external_datos.registrousuarios.service.ComprobacionesUserName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

public class TestRegistroUsuarios {

    ComprobacionesUserName comproUser = new ComprobacionesUserName();

    @Test
    void checkLengthUserNameTrueComprobation() {

        boolean length = comproUser.lengthUserName("carlos");

        Assertions.assertTrue(length);

    }
    @Test
    void checkLengthUserNameFalseComprobation() {

        boolean length = comproUser.lengthUserName("a");

        Assertions.assertFalse(length);

    }

    @Test
    void CheckIfANameHasNumbersTrue(){
        boolean number = comproUser.isDigitUserName("Javier mancillo rodriguez");
        Assertions.assertTrue(number);
    }

    @Test
    void CheckIfANameHasNumbersFalse(){
        boolean number = comproUser.isDigitUserName("J123avier mancillo rodriguez");
        Assertions.assertFalse(number);
    }

    @Test
    void checkIfANameHasStrangerCharactersTrue(){
        boolean thing = comproUser.strangeCharactersUsername("Camión");
        Assertions.assertTrue(thing);
    }
    @Test
    void checkIfANameHasStrangerCharactersFalse(){
        boolean thing = comproUser.strangeCharactersUsername("Pepe de los monte´s");
        Assertions.assertFalse(thing);
    }

    @Test
    void checkAllPosibilitysRegisterNameTrue(){
        boolean goodName = comproUser.authenticationRegisterName("Javier garcía vázquez");
        Assertions.assertTrue(goodName);
    }
    @Test
    void checkAllPosibilitysRegisterNameFalse(){
        boolean badname = comproUser.authenticationRegisterName("Pe1dro castaños ?de los puentes");
        Assertions.assertFalse(badname);
    }
}
