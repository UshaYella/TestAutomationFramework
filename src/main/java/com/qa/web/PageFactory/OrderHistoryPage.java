package com.qa.web.PageFactory;
import com.qa.web.componenthelper.ObjectRepository;
import com.qa.web.driverclass.PageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class OrderHistoryPage extends PageBase {
    static final Logger logger = Logger.getLogger(OrderHistoryPage.class);
    private static WebDriver driver = ObjectRepository.Driver;

    public OrderHistoryPage() {
        super(driver);
    }
    /**
     * Webelement
     **/

    @FindBy(how = How.XPATH, using = "(//tbody)[1]")
    private WebElement orderTable;

    public String getOrderId() {
        return orderTable.getText();
    }


}
