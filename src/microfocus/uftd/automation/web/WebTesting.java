package microfocus.uftd.automation.web;

import com.hp.lft.report.*;
import com.hp.lft.sdk.web.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.hp.lft.sdk.*;
import com.hp.lft.verifications.*;

import unittesting.*;

public class WebTesting extends UnitTestClassBase {

    public WebTesting() throws GeneralLeanFtException {
        //Change this constructor to private if you supply your own public constructor
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        instance = new WebTesting();
        globalSetup(WebTesting.class);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    //@Test
    public void TestRecorded() throws GeneralLeanFtException {
        Browser browser = BrowserFactory.launch(BrowserType.CHROME);

        browser.navigate("https://www.advantageonlineshopping.com/#/");


        Link userMenuLink = browser.describe(Link.class, new LinkDescription.Builder()
                .innerText("My account My orders Sign out ")
                .tagName("A").build());
        userMenuLink.click();

        EditField usernameEditField = browser.describe(EditField.class, new EditFieldDescription.Builder()
                .name("username")
                .tagName("INPUT")
                .type("text").build());
        usernameEditField.setValue("amir.khan");

        EditField passwordEditField = browser.describe(EditField.class, new EditFieldDescription.Builder()
                .name("password")
                .tagName("INPUT")
                .type("password").build());
        passwordEditField.setSecure("60423c66686caa2f6fd44f23bd927dfe5f4c9efd");

        Button signInBtnundefinedButton = browser.describe(Button.class, new ButtonDescription.Builder()
                .buttonType("button")
                .name("SIGN IN")
                .tagName("BUTTON").build());
        signInBtnundefinedButton.click();

        Link userMenuLink1 = browser.describe(Link.class, new LinkDescription.Builder()
                .innerText("amir.khan My account My orders Sign out ")
                .tagName("A").build());
        userMenuLink1.click();

        Link signOutLink = browser.describe(Link.class, new LinkDescription.Builder()
                .innerText("Sign out")
                .tagName("LABEL").build());
        signOutLink.click();



    }

    @Test
    public void CHROME() throws GeneralLeanFtException, ReportException {

        //Test Steps listed
        MainTest(BrowserType.CHROME, "2");

    }

    @Test
    public void FIREFOX() throws GeneralLeanFtException, ReportException {
        //Test Steps listed
        Reporter.startScreenRecording();
        Reporter.setSnapshotCaptureLevel(CaptureLevel.All);
        MainTest(BrowserType.FIREFOX, "3");
        Reporter.setSnapshotCaptureLevel(CaptureLevel.Off);
        Reporter.stopScreenRecording();
    }

    @Test
    public void CHROMIUM_EDGE() throws GeneralLeanFtException, ReportException {
        //Test Steps listed
        MainTest(BrowserType.EDGE_CHROMIUM,"1");

    }

    private void MainTest(BrowserType pBrowser, String Qty) throws GeneralLeanFtException, ReportException {
        Browser browser = BrowserFactory.launch(pBrowser);
        navigateBrowser(browser);

        //Application Model assignment
        AOSAppModel WebApp = new AOSAppModel(browser);

        //Steps
        checkProducts(WebApp);
        checkSpecialOffers(WebApp);
        checkPopularItems(WebApp);
        checkContactUsArea(WebApp);

        //Select and check price of speakers
        selectSpeakerArea(WebApp);
        selectFirstSpeaker(WebApp);

        //Calculation and checkpoints
        String priceItem = enterQtyGetPrice(WebApp, Qty);
        checkPriceCalc(WebApp,priceItem,Qty);

        //close Browser
        closeBrowser(browser);
    }

    private void navigateBrowser(Browser browser) throws GeneralLeanFtException {
        browser.navigate("https://advantageonlineshopping.com");

    }

    private void closeBrowser(Browser browser) throws GeneralLeanFtException {
        browser.close();
    }

    private void checkProducts(AOSAppModel WebApp) throws GeneralLeanFtException {
        Verify.isTrue(WebApp.AdvantageShoppingPage().SpeakersCategory().exists(),"SPEAKERS VERIFCATION");
        Verify.isTrue(WebApp.AdvantageShoppingPage().TabletsCategory().exists(),"TABLETS VERIFCATION");
        Verify.isTrue(WebApp.AdvantageShoppingPage().HeadphonesCategory().exists(),"HEADPHONES VERIFCATION");
        Verify.isTrue(WebApp.AdvantageShoppingPage().MiceCategory().exists(),"MICE VERIFCATION");
        Verify.isTrue(WebApp.AdvantageShoppingPage().LaptopsCategory().exists(),"LAPTOPS VERIFCATION");

    }

    private void checkSpecialOffers (AOSAppModel WebApp) throws GeneralLeanFtException {
        Verify.isTrue(WebApp.AdvantageShoppingPage().SPECIALOFFERS().exists(),"SPECIAL OFFER HEADER VERIFCATION");
        Verify.isTrue(WebApp.AdvantageShoppingPage().SEEOFFER().exists(),"SEE SPECIAL OFFER VERIFCATION");

    }

    private void checkPopularItems (AOSAppModel WebApp) throws GeneralLeanFtException {
        Verify.isTrue(WebApp.AdvantageShoppingPage().POPULARITEMSTitle().exists(),"POPULAR ITEMS HEADER VERIFCATION");
        Verify.isTrue(WebApp.AdvantageShoppingPage().PopularItemsDiv().exists(),"POPULAR ITEMS TABLE VERIFCATION");

    }

    private void checkContactUsArea(AOSAppModel WebApp) throws GeneralLeanFtException {
        Verify.isTrue(WebApp.AdvantageShoppingPage().CategoryContactUs().exists(),"CategoryContactUs VERIFCATION");
        Verify.isTrue(WebApp.AdvantageShoppingPage().ProductContactUs().exists(),"ProductContactUs VERIFCATION");
        Verify.isTrue(WebApp.AdvantageShoppingPage().EmailContactUs().exists(),"EmailContactUs VERIFCATION");
        Verify.isTrue(WebApp.AdvantageShoppingPage().SubjectTextareaContactUs().exists(),"SubjectTextareaContactUs VERIFCATION");
        Verify.isTrue(WebApp.AdvantageShoppingPage().SENDButton().exists(),"SENDButton VERIFCATION");

    }

    private void selectSpeakerArea(AOSAppModel WebApp) throws GeneralLeanFtException {
        WebApp.AdvantageShoppingPage().SpeakersCategory().click();


    }

    private void selectFirstSpeaker(AOSAppModel WebApp) throws GeneralLeanFtException{
        WebApp.AdvantageShoppingPage().FirstSpeakerItem().click();
    }

    private String enterQtyGetPrice(AOSAppModel WebApp, String Qty) throws GeneralLeanFtException, ReportException {
        WebApp.AdvantageShoppingPage().Quantity().setValue(Qty);
        String singlePrice = WebApp.AdvantageShoppingPage().PriceOfItem().getOuterText();
        String InnerText = WebApp.AdvantageShoppingPage().ADDTOCART().getNativeObject().getProperty("innerText", String.class);
        String Name = WebApp.AdvantageShoppingPage().ADDTOCART().getNativeObject().getProperty("name", String.class);

        Reporter.reportEvent("NativeObjectProperies", "InnerText: " + InnerText + " - name: " + Name, Status.Passed);
        WebApp.AdvantageShoppingPage().ADDTOCART().click();
        WebApp.AdvantageShoppingPage().ShoppingCartLink().click();



        return singlePrice;

    }

    private void checkPriceCalc(AOSAppModel WebApp, String singlePriceItem, String quantity) throws GeneralLeanFtException, ReportException {
        String totalPrice = WebApp.AdvantageShoppingPage().TotalPriceWebElement().getOuterText();

        Double dblTotalPrice = Double.parseDouble(totalPrice.replace("$","").replace(" SOLD OUT",""));
        Double dblSinglePrice = Double.parseDouble(singlePriceItem.replace("$","").replace(" SOLD OUT",""));
        Integer intQty = Integer.parseInt(quantity);


        if (dblSinglePrice * intQty == dblTotalPrice) {
            Reporter.reportEvent("Price Calulation is correct", "The price calculation is correct.", Status.Passed);
        }
        else {
            Reporter.reportEvent("Price Calulation is not correct", "The price calculation is not correct.", Status.Failed);
        }

        //Remove Items from Cart
        WebApp.AdvantageShoppingPage().REMOVEWebElement().click();
    }
}