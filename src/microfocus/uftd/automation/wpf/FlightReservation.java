package microfocus.uftd.automation.wpf;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
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
    public void FlightBooking() throws GeneralLeanFtException, ParseException, ReportException, InterruptedException {
        StartApp();
        Login();
        EnterFlightDetails();
        SelectFlight();
        EnterPassengerData();
        CloseAUT();

    }


    private void StartApp() throws GeneralLeanFtException {
        String AUTPath = "C:\\samples\\Flights Application\\FlightsGUI.exe";
        Aut FlightGUIApp = Desktop.launchAut(AUTPath);
    }

    private  void Login() throws GeneralLeanFtException {
        AUTFlightGUI.FlightWindow().AgentNameEditField().setText("John");
        AUTFlightGUI.FlightWindow().PasswordEditField().setText("HP");
        AUTFlightGUI.FlightWindow().OKButton().click();

    }

    private void EnterFlightDetails() throws GeneralLeanFtException, ParseException {
        AUTFlightGUI.FlightWindow().FromCityComboBox().select("Denver");
        AUTFlightGUI.FlightWindow().ToCityComboBox().select("Frankfurt");
        SimpleDateFormat shortdate = new SimpleDateFormat("dd/MM/yyyy");
        Date date = shortdate.parse("26/02/2022");
        AUTFlightGUI.FlightWindow().DatePickerCalendar().setDate(date);
        AUTFlightGUI.FlightWindow().NumOfTicketsComboBox().select("1");
        AUTFlightGUI.FlightWindow().ClassComboBox().select("Business");
        AUTFlightGUI.FlightWindow().FINDFLIGHTSButton().click();
    }

    private void SelectFlight() throws GeneralLeanFtException {
        AUTFlightGUI.FlightWindow().FlightsDataGridTable().selectRow(1);
        AUTFlightGUI.FlightWindow().SELECTFLIGHTButton().click();
    }

    private void EnterPassengerData() throws GeneralLeanFtException, ReportException, InterruptedException {
        AUTFlightGUI.FlightWindow().PassengerNameEditField().setText("Amir Khan");
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