import component.Base;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationForm;

public class RegistrationFormTests extends Base {

    RegistrationForm registrationForm = new RegistrationForm();

    @Test
    @DisplayName("Check successful form registration")
    void studentRegistrationForm() {
        registrationForm.amOnPage();
        registrationForm.fillFirstName();
        registrationForm.fillLastName();
        registrationForm.fillEmail();
        registrationForm.fillGender();
        registrationForm.fillPhoneNumber();
        registrationForm.setDate("28", "July", "2005");
        registrationForm.fillSubject();
        registrationForm.fillHobbies("Music");
        registrationForm.uploadPicture();
        registrationForm.fillCurrentAddress();
        registrationForm.selectState("NCR");
        registrationForm.selectCity("Noida");
        registrationForm.clickOnSubmitButton();
        registrationForm.submittingForm();
    }
}
