package microfocus.uftd.automation.wpf;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
import com.hp.lft.sdk.internal.common.MessageFieldNames;
import com.hp.lft.sdk.wpf.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.hp.lft.sdk.*;
import com.hp.lft.verifications.*;

import unittesting.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FlightReservation extends UnitTestClassBase {
    private FlightGUI AUTFlightGUI = new FlightGUI();

    public FlightReservation() throws GeneralLeanFtException {
        //Change this constructor to private if you supply your own public constructor

    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        instance = new FlightReservation();
        globalSetup(FlightReservation.class);
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

    @Test
    public void FlightBooking_Business() throws GeneralLeanFtException, ParseException, ReportException, InterruptedException {
        StartApp();
        Login();
        EnterFlightDetails("Denver", "Frankfurt", "26/02/2022", "1", "Business");
        SelectFlight();
        EnterPassengerData("Amir Khan");
        CloseAUT();

    }

    @Test
    public void FlightBooking_First() throws GeneralLeanFtException, ParseException, ReportException, InterruptedException {
        StartApp();
        Login();
        EnterFlightDetails("Frankfurt", "Paris", "26/03/2021", "2", "First");
        SelectFlight();
        EnterPassengerData("Avi Genshaft");
        CloseAUT();

    }

    @Test
    public void FlightBooking_Economy() throws GeneralLeanFtException, ParseException, ReportException, InterruptedException {
        StartApp();
        Login();
        EnterFlightDetails("London", "Frankfurt", "10/03/2022", "3", "Economy");
        SelectFlight();
        EnterPassengerData("Dror Sarooni");
        CloseAUT();

    }


    @Test
    public void RecordedActions() throws GeneralLeanFtException {
        Window microFocusMyFlightSampleApplicationWindow = Desktop.describe(Window.class, new WindowDescription.Builder()
                .fullType("window")
                .objectName("Micro Focus MyFlight Sample Application")
                .windowTitleRegExp("Micro Focus MyFlight Sample Application").build());
        EditField agentNameEditField = microFocusMyFlightSampleApplicationWindow.describe(EditField.class, new EditFieldDescription.Builder()
                .objectName("agentName").build());
        agentNameEditField.setText("John");

        EditField passwordEditField = microFocusMyFlightSampleApplicationWindow.describe(EditField.class, new EditFieldDescription.Builder()
                .objectName("password").build());
        passwordEditField.setSecure("603c80b47b1f6cc61838");

        Button wpfButtonButton = microFocusMyFlightSampleApplicationWindow.describe(Button.class, new ButtonDescription.Builder()
                .objectName("okButton")
                .text("OK").build());
        wpfButtonButton.click();

        ComboBox fromCityComboBox = microFocusMyFlightSampleApplicationWindow.describe(ComboBox.class, new ComboBoxDescription.Builder()
                .objectName("fromCity").build());
        fromCityComboBox.select("Denver");

        ComboBox toCityComboBox = microFocusMyFlightSampleApplicationWindow.describe(ComboBox.class, new ComboBoxDescription.Builder()
                .objectName("toCity").build());
        toCityComboBox.select("Frankfurt");

        ComboBox classComboBox = microFocusMyFlightSampleApplicationWindow.describe(ComboBox.class, new ComboBoxDescription.Builder()
                .fullType("combo box")
                .objectName("Class").build());
        classComboBox.select("Business");

        ComboBox numOfTicketsComboBox = microFocusMyFlightSampleApplicationWindow.describe(ComboBox.class, new ComboBoxDescription.Builder()
                .objectName("numOfTickets").build());
        numOfTicketsComboBox.select("2");

        Button fINDFLIGHTSButton = microFocusMyFlightSampleApplicationWindow.describe(Button.class, new ButtonDescription.Builder()
                .objectName("FIND FLIGHTS")
                .text("FIND FLIGHTS").build());
        fINDFLIGHTSButton.click();

        Table flightsDataGridTable = microFocusMyFlightSampleApplicationWindow.describe(Table.class, new TableDescription.Builder()
                .objectName("flightsDataGrid").build());
        flightsDataGridTable.selectCell(0, 1);

        Button sELECTFLIGHTButton = microFocusMyFlightSampleApplicationWindow.describe(Button.class, new ButtonDescription.Builder()
                .objectName("selectFlightBtn")
                .text("SELECT FLIGHT").build());
        sELECTFLIGHTButton.click();

        EditField passengerNameEditField = microFocusMyFlightSampleApplicationWindow.describe(EditField.class, new EditFieldDescription.Builder()
                .objectName("passengerName").build());
        passengerNameEditField.setText("Amir Khan");

        Button oRDERButton = microFocusMyFlightSampleApplicationWindow.describe(Button.class, new ButtonDescription.Builder()
                .objectName("orderBtn")
                .text("ORDER").build());
        oRDERButton.click();

        Button nEWSEARCHButton = microFocusMyFlightSampleApplicationWindow.describe(Button.class, new ButtonDescription.Builder()
                .objectName("newSearchBtn")
                .text("NEW SEARCH").build());
        nEWSEARCHButton.click();

    }

    private void StartApp() throws GeneralLeanFtException {
        String AUTPath = "C:\\samples\\Flights Application\\FlightsGUI.exe";
        Aut FlightGUIApp = Desktop.launchAut(AUTPath);
    }

    private  void Login() throws GeneralLeanFtException, ReportException {
        AUTFlightGUI.FlightWindow().AgentNameEditField().setText("John");


        Boolean isEnabled = null;
        isEnabled = AUTFlightGUI.FlightWindow().OKButton().getNativeObject().getProperty("IsEnabled", Boolean.class);
        Reporter.reportEvent("Before Password", isEnabled.toString());


        AUTFlightGUI.FlightWindow().PasswordEditField().setText("HP");
        isEnabled = AUTFlightGUI.FlightWindow().OKButton().getNativeObject().getProperty("IsEnabled", Boolean.class);
        Reporter.reportEvent("After Password", isEnabled.toString());
        AUTFlightGUI.FlightWindow().OKButton().click();
    }

    private void EnterFlightDetails(String FlyFrom, String FlyTo, String Date, String TicketsNo, String ClassType) throws GeneralLeanFtException, ParseException {
        AUTFlightGUI.FlightWindow().FromCityComboBox().select(FlyFrom);
        AUTFlightGUI.FlightWindow().ToCityComboBox().select(FlyTo);
        SimpleDateFormat shortdate = new SimpleDateFormat("dd/MM/yyyy");
        Date date = shortdate.parse(Date);
        AUTFlightGUI.FlightWindow().DatePickerCalendar().setDate(date);
        AUTFlightGUI.FlightWindow().NumOfTicketsComboBox().select(TicketsNo);
        AUTFlightGUI.FlightWindow().ClassComboBox().select(ClassType);
        AUTFlightGUI.FlightWindow().FINDFLIGHTSButton().click();
    }

    private void SelectFlight() throws GeneralLeanFtException {
        AUTFlightGUI.FlightWindow().FlightsDataGridTable().selectRow(0);
        AUTFlightGUI.FlightWindow().SELECTFLIGHTButton().click();
    }

    private void EnterPassengerData(String PassengerName) throws GeneralLeanFtException, ReportException, InterruptedException {
        AUTFlightGUI.FlightWindow().PassengerNameEditField().setText(PassengerName);
        AUTFlightGUI.FlightWindow().ORDERButton().click();

        String NumOfTickets = AUTFlightGUI.FlightWindow().NumberOfTickets().getText();
        String TicketPrice = AUTFlightGUI.FlightWindow().PriceTicket().getText();
        String TotalPrice = AUTFlightGUI.FlightWindow().TotalPrice().getText();

        Integer conNumOfTickets = Integer.parseInt(NumOfTickets);
        Double conTicketPrice = Double.parseDouble(TicketPrice.replace("$",""));
        Double conTotalPrice = Double.parseDouble(TotalPrice.replace("$",""));
        if (conNumOfTickets * conTicketPrice == conTotalPrice) {
            Reporter.reportEvent("Price Calculation Passed", "Total Price: " + TotalPrice + " is correct.", Status.Passed);
        } else {
            Reporter.reportEvent("Price Calculation Failed", "Total Price: " + TotalPrice + " is not correct.", Status.Failed);
        }
        Thread.sleep(4000);
        if (AUTFlightGUI.FlightWindow().Confirmation().exists(5)) {
            String ConfirmationMessage = AUTFlightGUI.FlightWindow().ConfirmationMessage().getText();
            String OrderNumber = ConfirmationMessage.replace("Order ", "").replace(" completed", "");

            Reporter.reportEvent("Confirmation Message", ConfirmationMessage);
            Reporter.reportEvent("Order Number", "Order Number " + OrderNumber + " created.");
            AUTFlightGUI.FlightWindow().NEWSEARCHButton().click();
        } else {
            Reporter.reportEvent("Order Confirmation", "Order was not booked successfully", Status.Failed);
        }

    }

    private void CloseAUT() throws GeneralLeanFtException {
        AUTFlightGUI.FlightWindow().close();
    }

}