package component;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class Base {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";
    }
}

