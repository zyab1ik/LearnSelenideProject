package pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Address;
import com.github.javafaker.Artist;
import com.github.javafaker.Faker;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationForm {

    Faker faker = new Faker();

    /**
     * URL
     */
    public final String URL = "/automation-practice-form";

    /**
     * Form title
     */
    public final String TITLE = "Student Registration Form";

    /**
     * Form wrapper selector
     */
    public final SelenideElement formTitleWrapper = $(".practice-form-wrapper");

    /**
     * First name input
     */
    protected final SelenideElement firstNameInput = $("#firstName");

    /**
     * Last name input
     */
    protected final SelenideElement lastNameInput = $("#lastName");

    /**
     * Last name input
     */
    protected final SelenideElement emailInput = $("#userEmail");

    /**
     * Gender radio button id
     */
    protected final SelenideElement genderInput = $("#genterWrapper");

    /**
     * Mobile number input
     */
    protected final SelenideElement userNumberInput = $("#userNumber");

    /**
     * Date of birth input
     */
    protected final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");

    /**
     * Subjects check box id
     */
    protected final SelenideElement subjectsInput = $("#subjectsInput");

    /**
     * Hobbies wrapper id
     */
    protected final SelenideElement hobbiesWrapper = $("#hobbiesWrapper");

    /**
     * Upload Picture id
     */
    protected final SelenideElement uploadPicture = $("#uploadPicture");

    /**
     * Current address input
     */
    protected final SelenideElement currentAddress = $("#currentAddress");

    /**
     * React datepicker month selector
     */
    protected final SelenideElement dataPickerMonthSelector = $(".react-datepicker__month-select");

    /**
     * React datepicker year selector
     */
    protected final SelenideElement dataPickerYearSelector = $(".react-datepicker__year-select");

    /**
     * React datepicker day selector
     */
    protected final SelenideElement dataPickerDaySelector = $(".react-datepicker__day--0");

    /**
     * Select city wrapper selector
     */
    protected final SelenideElement stateCityWrapperSelector = $("#stateCity-wrapper");

    /**
     * Select state selector
     */
    protected final SelenideElement stateSelector = $("#state");

    /**
     * Select city selector
     */
    protected final SelenideElement citySelector = $("#city");

    /**
     * Open page and check title
     */
    public void amOnPage() {
        open(URL);
        formTitleWrapper.shouldHave(text(TITLE));
    }

    /**
     * Fill first name
     */
    public void fillFirstName() {
        String firstName = faker.name().firstName();
        $(firstNameInput).sendKeys(firstName);
    }

    /**
     * Fill last name
     */
    public void fillLastName() {
        String lastName = faker.name().firstName();
        $(lastNameInput).sendKeys(lastName);
    }

    /**
     * Fill email
     */
    public void fillEmail() {
        String email = faker.internet().emailAddress();
        $(emailInput).sendKeys(email);
    }

    /**
     * Fill gender
     */
    public void fillGender() {
        $(genderInput).$(byText("Other")).click();
    }

    /**
     * Fill phone number
     */
    public void fillPhoneNumber() {
        String userNumber = faker.number().numberBetween(900,999) + faker.number().digits(10);
        $(userNumberInput).setValue(userNumber);
    }

    /**
     * Set date via calendar
     */
    public void setDate(String day, String month, String year) {
        $(dateOfBirthInput).click();
        $(dataPickerMonthSelector).selectOption(month);
        $(dataPickerYearSelector).selectOption(year);
        $(".react-datepicker__day--0" + day +
                ":not(.react-datepicker__day--outside-month)").click();
    }

    /**
     * Fill subject field
     */
    public void fillSubject() {
        Artist subject = faker.artist();
        $(subjectsInput).scrollTo();
        $(subjectsInput).click();
        $(subjectsInput).setValue(String.valueOf(subject));
    }

    /**
     * Fill hobbies field
     */
    public void fillHobbies(String hobby) {
        $(hobbiesWrapper).$(byText(hobby)).click();
    }

    /**
     * Upload picture
     */
    public void uploadPicture() {
        File file = new File("src/test/resources/zyablik.jpg");
        $(uploadPicture).uploadFile(file);
    }

    /**
     * Fill current address field
     */
    public void fillCurrentAddress() {
        Address address = faker.address();
        $(currentAddress).setValue(String.valueOf(address));
    }

    /**
     * Select state
     */
    public void selectState(String stateValue) {
        $(stateSelector).click();
        $(stateCityWrapperSelector).$(byText(stateValue)).click();
    }

    /**
     * Select city
     */
    public void selectCity(String cityValue) {
        $(citySelector).click();
        $(stateCityWrapperSelector).$(byText(cityValue)).click();
    }

    /**
     * Click on submit button
     */
    public void clickOnSubmitButton() {
        $("#submit").click();
    }

    /**
     * See submitting form
     */
    public void submittingForm() {
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        // TODO: do assets and check forms
    }
}
