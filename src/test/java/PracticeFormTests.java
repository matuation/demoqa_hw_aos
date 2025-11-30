import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.commands.ScrollIntoView;
import com.codeborne.selenide.commands.ScrollTo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class PracticeFormTests {

    @BeforeAll
    static void BeforeAll() {
        //Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
        //Configuration.timeout = 5000; // default 4000
        new ScrollTo();
    }

    @Test
    void successfulFormFillTest(){
        //открываем форму
    open("automation-practice-form");
        //заполняем форму
        $("#userForm #firstName").setValue("Sven");
        $("#userForm #lastName").setValue("Macshnacnecs");
        $("#userForm #userEmail").setValue("sven@macshnacnecs.com");
        $(byCssSelector("label[for='gender-radio-3']")).click();
        $("#userForm #userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byCssSelector("option[value='1991']")).click();
        $(".react-datepicker__month-select").$(byCssSelector("option[value='7']")).click();
        $(".react-datepicker__day.react-datepicker__day--020").click();
        $("#subjectsInput").setValue("co");
        $(".subjects-auto-complete__option.css-yt9ioa-option#react-select-2-option-2").scrollTo();
        $(".subjects-auto-complete__option.css-yt9ioa-option#react-select-2-option-2").click();
        $(byCssSelector("label[for='hobbies-checkbox-2']")).click();
        $(byCssSelector("label[for='hobbies-checkbox-3']")).click();
        $(byCssSelector("input[type='file']")).uploadFile(new File("src/test/data/sample.png"));
        $("#userForm #currentAddress").setValue("1835 73rd Ave NE, Medina, WA 98039, USA");
        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#react-select-4-option-2").click();
        $("#submit").click();
        //проверяем итоговую таблицу
        $(".table").shouldHave(text("Sven Macshnacnecs"));
        $(".table").shouldHave(text("sven@macshnacnecs.com"));
        $(".table").shouldHave(text("Other"));
        $(".table").shouldHave(text("1234567890"));
        $(".table").shouldHave(text("20 August,1991"));
        $(".table").shouldHave(text("Accounting"));
        $(".table").shouldHave(text("Reading, Music"));
        $(".table").shouldHave(text("sample.png"));
        $(".table").shouldHave(text("1835 73rd Ave NE, Medina, WA 98039, USA"));
        $(".table").shouldHave(text("Uttar Pradesh Merrut"));


    }
}
