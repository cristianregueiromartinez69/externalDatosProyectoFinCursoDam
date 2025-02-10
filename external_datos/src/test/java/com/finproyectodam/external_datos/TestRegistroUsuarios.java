package com.finproyectodam.external_datos;

import com.finproyectodam.external_datos.registrousuarios.service.comprobaciones.ComprobacionesEmail;
import com.finproyectodam.external_datos.registrousuarios.service.comprobaciones.ComprobacionesPassword;
import com.finproyectodam.external_datos.registrousuarios.service.comprobaciones.ComprobacionesUserName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRegistroUsuarios {

    ComprobacionesUserName comproUser = new ComprobacionesUserName();
    ComprobacionesEmail comprobacionEmail = new ComprobacionesEmail();
    ComprobacionesPassword comprobacionPassword = new ComprobacionesPassword();


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

    @Test
    void checkIfAEmailHasAArobaFirstLetterTrue(){
        boolean aroba = comprobacionEmail.checkArobaEmailFirstLetter("peregrino@gmail.com");
        Assertions.assertTrue(aroba);
    }
    @Test
    void checkIfAEmailHasAArobaFirstLetterFalse(){
        boolean aroba = comprobacionEmail.checkArobaEmailFirstLetter("@peregrino.com");
        Assertions.assertFalse(aroba);
    }

    @Test
    void checkIfAEmailHasAArobaAllSizeTrue(){
        boolean aroba = comprobacionEmail.checkEmailHasAAroba("federico@hotmail.com");
        Assertions.assertTrue(aroba);
    }

    @Test
    void checkIfAEmailHasAArobaAllSizeFalse(){
        boolean aroba = comprobacionEmail.checkEmailHasAAroba("federicogamil.com");
        Assertions.assertFalse(aroba);
    }

    @Test
    void checkIfAEmailHasAArobaAllSizeMoreThan1TimeTrue(){
        boolean aroba = comprobacionEmail.checkEmailHasAArobaMoreThan1Time("carlos@hotmail.com");
        Assertions.assertTrue(aroba);
    }
    @Test
    void checkIfAEmailHasAArobaAllSizeMoreThan1TimeFalse(){
        boolean aroba = comprobacionEmail.checkEmailHasAArobaMoreThan1Time("carlos@hotma@il.com");
        Assertions.assertFalse(aroba);
    }

    @Test
    void checkIfAEmailHasAPuntoFirstLetterTrue(){
        boolean punto = comprobacionEmail.checkPuntoEmailFirstLetter("carlos@gmail.com");
        Assertions.assertTrue(punto);
    }

    @Test
    void checkIfAEmailHasAPuntoFirstLetterFalse(){
        boolean punto = comprobacionEmail.checkPuntoEmailFirstLetter(".carlos@gmail.com");
        Assertions.assertFalse(punto);
    }

    @Test
    void checkIfAEmailHasAPuntoAllSizeTrue(){
        boolean punto = comprobacionEmail.checkEmailHasAAPoint("carlos@gmail.com");
        Assertions.assertTrue(punto);
    }

    @Test
    void checkIfAEmailHasAPuntoAllSizeFalse(){
        boolean punto = comprobacionEmail.checkEmailHasAAPoint("carlos@gmailcom");
        Assertions.assertFalse(punto);
    }

    @Test
    void checkIfAEmailHasAPuntoMoreThan1TimeTrue(){
        boolean punto = comprobacionEmail.checkEmailHasAPointMoreThan1Time("carlos@gmail.com");
        Assertions.assertTrue(punto);
    }

    @Test
    void checkIfAEmailHasAPuntoMoreThan1TimeFalse(){
        boolean punto = comprobacionEmail.checkEmailHasAPointMoreThan1Time("car.los@gmail.com");
        Assertions.assertFalse(punto);
    }

    @Test
    void chechIfAEmailHasAStrangeCaracteresTrue(){
        boolean strangeThigs = comprobacionEmail.checkStrangeThingInEmail("carlos@gmail.com");
        Assertions.assertTrue(strangeThigs);
    }

    @Test
    void chechIfAEmailHasAStrangeCaracteresFalse(){
        boolean strangeThigs = comprobacionEmail.checkStrangeThingInEmail("car[lo=s@gmail.com");
        Assertions.assertFalse(strangeThigs);
    }

    @Test
    void checkIfAEmailHasAValidateDomainTrue(){
        boolean domain = comprobacionEmail.checkDomainEmail("carlos@gmail.com");
        Assertions.assertTrue(domain);
    }
    @Test
    void checkIfAEmailHasAValidateDomainFalse(){
        boolean domain = comprobacionEmail.checkDomainEmail("carlos@gmail.coooom");
        Assertions.assertFalse(domain);
    }

    @Test
    void authenticationAllRegisterEmailTrue(){
        boolean email = comprobacionEmail.authenticationRegisterEmail("mariavazquez@gmail.com");
        Assertions.assertTrue(email);
    }

    @Test
    void authenticationAllRegisterEmailFalse(){
        boolean email = comprobacionEmail.authenticationRegisterEmail("mariavazque@gmail.cam");
        Assertions.assertFalse(email);
    }


    @Test
    void checkLengthRegisterPasswordTrue(){
        boolean password = comprobacionPassword.checkLengthPassword("123456789lal");
        Assertions.assertTrue(password);
    }

    @Test
    void checkLengthRegisterPasswordFalse(){
        boolean password = comprobacionPassword.checkLengthPassword("1234567");
        Assertions.assertFalse(password);
    }

    @Test
    void checkIfAPasswordHaveSpecialCharactersTrue(){
        boolean password = comprobacionPassword.checkPasswordHasStrangeThings("12345$njnfn¨¨");
        Assertions.assertTrue(password);
    }

    @Test
    void checkIfAPasswordHaveSpecialCharactersFalse(){
        boolean password = comprobacionPassword.checkPasswordHasStrangeThings("123456789023fff");
        Assertions.assertFalse(password);
    }

    @Test
    void checkIfAPasswordHaveNumbersTrue(){
        boolean password = comprobacionPassword.checkPaswordHasNumbers("12345$njnfn¨¨");
        Assertions.assertTrue(password);
    }

    @Test
    void checkIfAPasswordHaveNumbersFalse(){
        boolean password = comprobacionPassword.checkPaswordHasNumbers("kakakaka");
        Assertions.assertFalse(password);
    }

    @Test
    void checkIfAPasswordIsValidateTrue(){
        boolean password = comprobacionPassword.authenticationRegisterPassword("cristiano#siuu1");
        Assertions.assertTrue(password);
    }

    @Test
    void checkIfAPasswordIsValidateFalse(){
        boolean password = comprobacionPassword.authenticationRegisterPassword("123456789");
        Assertions.assertFalse(password);
    }


}
