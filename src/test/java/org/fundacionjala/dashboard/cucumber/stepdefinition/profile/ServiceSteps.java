package org.fundacionjala.dashboard.cucumber.stepdefinition.profile;

import cucumber.api.java.en.And;
import org.fundacionjala.dashboard.ui.pages.menu.Profile;
import org.fundacionjala.dashboard.ui.pages.menu.Service;
import org.fundacionjala.dashboard.ui.pages.menu.TopMenu;

/**
 * Class to manage Step definition  for table widget of features.project.
 */
public class ServiceSteps {

    @And("^Synchronize Mach2 and (.*)$")
    public void synchronizeMach2AndPivotal(String serviceType) {
    //    if (serviceType == "Pivotal") {
     //   }else{

       // }
        TopMenu topMenu = new TopMenu();
        Profile profile = topMenu.clickOnProfileMenu();
        Service service = profile.clickSetting();
        service.clickOnConfigureProject(serviceType);
        service.setDescriptionTextField(String.valueOf(System.currentTimeMillis()));
        service.clickSaveButton();

        topMenu.clickJalasoftIcon();
    }

}
