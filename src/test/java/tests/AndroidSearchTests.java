package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;
import static io.qameta.allure.Allure.step;

public class AndroidSearchTests extends TestBase {
    @Test
    void searchTest() {
        back();
       // switchTo().alert().accept();
        step("Saved Bar check ", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/nav_tab_reading_lists")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/messageTitleView")).shouldHave(Condition.text("Sync reading lists"));
        });
        step("Search Bar check ", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/nav_tab_search")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/history_title")).shouldHave(Condition.text("History"));
        });
        step("Edit Tab check ", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/nav_tab_edits")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/messageTitleView"))
                    .shouldHave(Condition.text("Did you know that everyone can edit Wikipedia?"));
        });
        step("Explore Tab check ", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/nav_tab_explore")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/view_announcement_text"))
                    .shouldHave(Condition.text("Customize your Explore feed You can now choose what to show on your feed, and also prioritize your favorite types of content."));
        });

    }


}
