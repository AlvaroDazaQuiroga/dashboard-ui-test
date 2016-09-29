package org.fundacionjala.dashboard.ui.pages.menu;

import java.util.List;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Service extends AbstractBasePage {

    @FindBy(css = "div.ui.selection.dropdown")
    private WebElement dropDownListOfServices;

    @FindBy(css = "input[name='token']")
    private WebElement tokenTextField;

    @FindBy(name = "description")
    private WebElement descriptionTextField;

    @FindBy(css = "div.ui.shadowless.top.sidebar.overlay.visible button.ui.right.floated.blue.submit.button")
    private WebElement saveButton;

    @FindBy(css = "div.ui.stackable.three.column.grid")
    private WebElement columnServices;

    @FindBy(css = "input[name=\"serverAddress\"]")
    private WebElement setJatServer;

    public void setServerAddress(String server) {
        setJatServer.clear();
        setJatServer.sendKeys(server);
    }

    public void selectServiceDropdown(String serviceName) {
        dropDownListOfServices.click();
        driver.findElement(By.xpath("//div[@class='menu transition visible']/div[text()='" + serviceName + "']")).click();
    }

    public void setTokenTextField(String token) {
        tokenTextField.clear();
        tokenTextField.sendKeys(token);
    }

    public void setDescriptionTextField(String description) {
        descriptionTextField.clear();
        descriptionTextField.sendKeys(description);
    }


    public Profile clickSaveButton() {
        saveButton.click();
        driver.navigate().refresh();
        return new Profile();
    }

    public void clickOnConfigureProject(String projectType, String projectName) {
        List<WebElement> servicesList = columnServices.findElements(By.className("column"));
        
        for (WebElement x : servicesList) {
            if (x.findElement(By.cssSelector("div.sub.header.truncated.text")).getText().equals(projectType)
                    && x.findElement(By.cssSelector("h4.ui.header  > [class=\"truncated text\"]"))
                    .getText().equals(projectName)) {
                x.findElement(By.cssSelector("i.setting.link.icon")).click();
            }
        }
    }

}
