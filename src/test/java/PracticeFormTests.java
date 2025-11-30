import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.commands.ScrollIntoView;
import com.codeborne.selenide.commands.ScrollTo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
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
        $("#genterWrapper").$(byText("Other")).click();
        $("#userForm #userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText("1991")).click();
        $(".react-datepicker__month-select").$(byText("July")).click();
        $(".react-datepicker__day--020").click();
        $("#subjectsInput").setValue("co");
        $(".subjects-auto-complete__option").scrollTo();
        $(".subjects-auto-complete__menu-list").$(byText("Accounting")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $(byCssSelector("input[type='file']")).uploadFile(new File("src/test/data/sample.png"));
        $("#userForm #currentAddress").setValue("1835 73rd Ave NE, Medina, WA 98039, USA");
        $("#state").click();
        $(".css-26l3qy-menu").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(".css-26l3qy-menu").$(byText("Merrut")).click();
        $("#submit").click();
        //проверяем итоговую таблицу
        $(".table").shouldHave(text("Sven Macshnacnecs"));
        $(".table").shouldHave(text("sven@macshnacnecs.com"));
        $(".table").shouldHave(text("Other"));
        $(".table").shouldHave(text("1234567890"));
        $(".table").shouldHave(text("20 July,1991"));
        $(".table").shouldHave(text("Accounting"));
        $(".table").shouldHave(text("Reading, Music"));
        $(".table").shouldHave(text("sample.png"));
        $(".table").shouldHave(text("1835 73rd Ave NE, Medina, WA 98039, USA"));
        $(".table").shouldHave(text("Uttar Pradesh Merrut"));


    }
}
