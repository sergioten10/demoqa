package orq.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class PageTest extends BaseTest {

    @Test
    public void fillAllFields1() {
        String firstName = "Gena";
        String lastName = "Bookin";
        String email = "bookin@mail.ru";
        String mobile = "9518896135";
        String dayOfBirth = "10";
        String monthOfBith = "October";
        String yearOfBirth = "1995";
        String dateOfBirthAfterSubmit = dayOfBirth + " " + monthOfBith + "," + yearOfBirth;
        String subjects = "Physics";
        String currentAddress = "Saratov";
        String state = "NCR";
        String city = "Delhi";

        Page practicePage = new Page(driver);
        practicePage.open();
        practicePage.fillFirstName(firstName);
        practicePage.fillLastName(lastName);
        practicePage.fillEmail(email);
        practicePage.fillMobile(mobile);
        practicePage.fillDate(dayOfBirth, monthOfBith, yearOfBirth);
        practicePage.fillSubject(subjects);
        practicePage.fillCurrentAddress(currentAddress);
        practicePage.fillState(state);
        practicePage.fillCity(city);
        practicePage.fillGender("Male");
        practicePage.fillHobbieReading();
        practicePage.fillHobbieMusic();
        practicePage.fillHobbieSports();
        practicePage.submit();

        Assertions.assertTrue(practicePage.modalIsOpen());
        Assertions.assertEquals(firstName + " " + lastName, practicePage.getSubmittedName().getText());
        Assertions.assertEquals(email, practicePage.getSubmittedEmail().getText());
        Assertions.assertEquals("Male", practicePage.getSubmittedGender().getText());
        Assertions.assertEquals(mobile, practicePage.getSubmittedMobile().getText());
        Assertions.assertEquals(dateOfBirthAfterSubmit, practicePage.getSubmittedBirth().getText());
        Assertions.assertEquals(subjects, practicePage.getSubmittedSubjects().getText());
        Assertions.assertEquals("Reading, Music, Sports", practicePage.getSubmittedHobbies().getText());
        Assertions.assertEquals(currentAddress, practicePage.getSubmittedAddress().getText());
        Assertions.assertEquals(state + " " + city, practicePage.getSubmittedStateAndCity().getText());
    }
    @Test
    public void fillAllFields2() {
        String firstName = "Igor";
        String lastName = "Pozov";
        String email = "pozov@mail.ru";
        String mobile = "9518896135";
        String dayOfBirth = "11";
        String monthOfBirth = "January";
        String yearOfBirth = "1980";
        String dateOfBirthAfterSubmit = dayOfBirth + " " + monthOfBirth + "," + yearOfBirth;

        Page practicePage = new  Page(driver);
        practicePage.open();
        practicePage.fillFirstName(firstName);
        practicePage.fillLastName(lastName);
        practicePage.fillEmail(email);
        practicePage.fillMobile(mobile);
        practicePage.fillDate(dayOfBirth, monthOfBirth, yearOfBirth);
        practicePage.fillGender("Male");
        practicePage.submit();

        Assertions.assertTrue(practicePage.modalIsOpen());
        Assertions.assertEquals(firstName + " " + lastName, practicePage.getSubmittedName().getText());
        Assertions.assertEquals(email, practicePage.getSubmittedEmail().getText());
        Assertions.assertEquals("Male", practicePage.getSubmittedGender().getText());
        Assertions.assertEquals(mobile, practicePage.getSubmittedMobile().getText());
        Assertions.assertEquals(dateOfBirthAfterSubmit, practicePage.getSubmittedBirth().getText());
        Assertions.assertEquals("", practicePage.getSubmittedSubjects().getText());
        Assertions.assertEquals("", practicePage.getSubmittedHobbies().getText());
        Assertions.assertEquals("", practicePage.getSubmittedPicture().getText());
        Assertions.assertEquals("", practicePage.getSubmittedAddress().getText());
        Assertions.assertEquals("", practicePage.getSubmittedStateAndCity().getText());
    }
//невалидный телефон
    @Test
    public void phoneNumberValidation(){
        String firstName = "Ork";
        String lastName = "Lorderon";
        String email = "mcronakd@mail.ru";
        String mobile = "DASDASDDAS";
        String dayOfBirth = "15";
        String monthOfBith = "September";
        String yearOfBirth = "1989";

        Page practicePage = new  Page(driver);
        practicePage.open();
        practicePage.fillFirstName(firstName);
        practicePage.fillLastName(lastName);
        practicePage.fillEmail(email);
        practicePage.fillMobile(mobile);
        practicePage.fillDate(dayOfBirth, monthOfBith, yearOfBirth);
        practicePage.fillGender("Female");
        practicePage.submit();

        Assertions.assertFalse(practicePage.modalIsOpen());
    }

    // не указан пол
    @Test
    public void genderValidation() {
        String firstName = "Ronald";
        String lastName = "McDonald";
        String email = "mcronakd@mail.ru";
        String mobile = "9518896135";
        String dayOfBirth = "11";
        String monthOfBith = "January";
        String yearOfBirth = "1995";

        Page practicePage = new  Page(driver);
        practicePage.open();
        practicePage.fillFirstName(firstName);
        practicePage.fillLastName(lastName);
        practicePage.fillEmail(email);
        practicePage.fillMobile(mobile);
        practicePage.fillDate(dayOfBirth, monthOfBith, yearOfBirth);
        practicePage.submit();

        Assertions.assertFalse(practicePage.modalIsOpen());
    }

    // не указано имя
    @Test
    public void firstNameValidation() {
        String lastName = "Ronald";
        String email = "mcronakd@mail.ru";
        String mobile = "9518896135";
        String dayOfBirth = "15";
        String monthOfBith = "October";
        String yearOfBirth = "1995";

        Page practicePage = new  Page(driver);
        practicePage.open();
        practicePage.fillLastName(lastName);
        practicePage.fillEmail(email);
        practicePage.fillMobile(mobile);
        practicePage.fillDate(dayOfBirth, monthOfBith, yearOfBirth);
        practicePage.fillGender("Male");
        practicePage.submit();

        Assertions.assertFalse(practicePage.modalIsOpen());
    }
}
