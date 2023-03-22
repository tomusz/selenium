package com.sii.selenium.widgets;

import com.sii.selenium.BaseTest;
import com.sii.selenium.constants.TestTagConstants;
import com.sii.selenium.utils.WebPageUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ModalDialog extends BaseTest {

    private final String modalDialogUrl = baseUrl + webAddresses.get("widgets.modaldialog");
    @Test
    @Tag(TestTagConstants.MODAL_DIALOG)
    @Tag("FAKE-JIRA-NO-0011")
    public void addNewUser() {
        driver.get(modalDialogUrl);
        WebPageUtils.maximiseWindow.accept(driver);

//        . Modal dialog (po czwartku)
//• Click 'Create new user'
//• Fill form
//• Click on 'Create an account'
//• Check if a new row with correct 'Name', 'Email' and 'Password' has been added

    }

    //data provider for parameters for tests

}
