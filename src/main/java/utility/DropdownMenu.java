package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.Testbase;

public class DropdownMenu extends Testbase{

    // Select by visible text
    public static void selectByVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    // Select by value
    public static void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    // Select by index
    public static void selectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }
}
