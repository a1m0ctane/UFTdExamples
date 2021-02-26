<?xml version="1.0" encoding="utf-8" standalone="yes"?>
<applicationModel>
    <name>Application Model</name>
    <className>FlightGUI</className>
    <objects>
        <object type="Window" technology="WPF">
            <name>Micro Focus MyFlight Sample Application</name>
            <codeName>FlightWindow</codeName>
            <description></description>
            <identification>
                <properties>
                    <property name="WindowTitleRegExp" type="string" isRegExp="false">Micro Focus MyFlight Sample Application</property>
                    <property name="ObjectName" type="string" isRegExp="false">Micro Focus MyFlight Sample Application</property>
                    <property name="FullType" type="string" isRegExp="false">window</property>
                </properties>
            </identification>
            <children>
                <object type="EditField" technology="WPF">
                    <name>agentName</name>
                    <codeName>AgentNameEditField</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">agentName</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>Login</tag>
                    </tags>
                </object>
                <object type="EditField" technology="WPF">
                    <name>password</name>
                    <codeName>PasswordEditField</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">password</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>Login</tag>
                    </tags>
                </object>
                <object type="Button" technology="WPF">
                    <name>OK</name>
                    <codeName>OKButton</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">okButton</property>
                            <property name="Text" type="string" isRegExp="false">OK</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>Login</tag>
                    </tags>
                </object>
                <object type="Button" technology="WPF">
                    <name>Cancel</name>
                    <codeName>CancelButton</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">Cancel</property>
                            <property name="Text" type="string" isRegExp="false">Cancel</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>Login</tag>
                    </tags>
                </object>
                <object type="ComboBox" technology="WPF">
                    <name>fromCity</name>
                    <codeName>FromCityComboBox</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">fromCity</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>FlightInformation</tag>
                    </tags>
                </object>
                <object type="ComboBox" technology="WPF">
                    <name>toCity</name>
                    <codeName>ToCityComboBox</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">toCity</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>FlightInformation</tag>
                    </tags>
                </object>
                <object type="Calendar" technology="WPF">
                    <name>datePicker</name>
                    <codeName>DatePickerCalendar</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">datePicker</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>FlightInformation</tag>
                    </tags>
                </object>
                <object type="ComboBox" technology="WPF">
                    <name>Class</name>
                    <codeName>ClassComboBox</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">Class</property>
                            <property name="FullType" type="string" isRegExp="false">combo box</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>FlightInformation</tag>
                    </tags>
                </object>
                <object type="ComboBox" technology="WPF">
                    <name>numOfTickets</name>
                    <codeName>NumOfTicketsComboBox</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">numOfTickets</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>FlightInformation</tag>
                    </tags>
                </object>
                <object type="Button" technology="WPF">
                    <name>FIND FLIGHTS</name>
                    <codeName>FINDFLIGHTSButton</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">FIND FLIGHTS</property>
                            <property name="Text" type="string" isRegExp="false">FIND FLIGHTS</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>FlightInformation</tag>
                    </tags>
                </object>
                <object type="TabStrip" technology="WPF">
                    <name>WpfTabStrip</name>
                    <codeName>WpfTabStrip</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false"></property>
                            <property name="FullNamePath" type="string" isRegExp="false">;;</property>
                            <property name="FullType" type="string" isRegExp="false">tab</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>Selection Type</tag>
                    </tags>
                </object>
                <object type="Table" technology="WPF">
                    <name>flightsDataGrid</name>
                    <codeName>FlightsDataGridTable</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">flightsDataGrid</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>FlightSelection</tag>
                    </tags>
                </object>
                <object type="Button" technology="WPF">
                    <name>SELECT FLIGHT</name>
                    <codeName>SELECTFLIGHTButton</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">selectFlightBtn</property>
                            <property name="Text" type="string" isRegExp="false">SELECT FLIGHT</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>FlightSelection</tag>
                    </tags>
                </object>
                <object type="Button" technology="WPF">
                    <name>BACK</name>
                    <codeName>BACKButton</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">BACK</property>
                            <property name="Text" type="string" isRegExp="false">BACK</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>FlightSelection</tag>
                    </tags>
                </object>
                <object type="EditField" technology="WPF">
                    <name>passengerName</name>
                    <codeName>PassengerNameEditField</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">passengerName</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>PassengerInfo</tag>
                    </tags>
                </object>
                <object type="Button" technology="WPF">
                    <name>NEW SEARCH</name>
                    <codeName>NEWSEARCHButton</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">newSearchBtn</property>
                            <property name="Text" type="string" isRegExp="false">NEW SEARCH</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>PassengerInfo</tag>
                    </tags>
                </object>
                <object type="Button" technology="WPF">
                    <name>ORDER</name>
                    <codeName>ORDERButton</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">orderBtn</property>
                            <property name="Text" type="string" isRegExp="false">ORDER</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>PassengerInfo</tag>
                    </tags>
                </object>
                <object type="UiObject" technology="WPF">
                    <name>NumberOfTickets</name>
                    <codeName>NumberOfTickets</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">numOfTickets</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>PassengerInfo</tag>
                    </tags>
                </object>
                <object type="UiObject" technology="WPF">
                    <name>Totalprice</name>
                    <codeName>TotalPrice</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">totalPrice</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>PassengerInfo</tag>
                    </tags>
                </object>
                <object type="UiObject" technology="WPF">
                    <name>PriceTicket</name>
                    <codeName>PriceTicket</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">pricePerTicket</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>PassengerInfo</tag>
                    </tags>
                </object>
                <object type="Image" technology="WPF">
                    <name>Confirmation</name>
                    <codeName>Confirmation</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="WindowTitleRegExp" type="string" isRegExp="false">Micro Focus MyFlight Sample Application</property>
                            <property name="ObjectName" type="string" isRegExp="false"></property>
                            <property name="FullNamePath" type="string" isRegExp="false">;;</property>
                            <property name="FullType" type="string" isRegExp="false">image</property>
                        </properties>
                        <index>3</index>
                    </identification>
                    <tags>
                        <tag>PassengerInfo</tag>
                    </tags>
                </object>
                <object type="UiObject" technology="WPF">
                    <name>ConfirmationMessage</name>
                    <codeName>ConfirmationMessage</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">orderCompleted</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>PassengerInfo</tag>
                    </tags>
                </object>
                <object type="RadioButton" technology="WPF">
                    <name>byNameOrDateRadio</name>
                    <codeName>ByNameOrDateRadioRadioButton</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">byNameOrDateRadio</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>OpenOrder</tag>
                    </tags>
                </object>
                <object type="RadioButton" technology="WPF">
                    <name>byNumberRadio</name>
                    <codeName>ByNumberRadioRadioButton</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">byNumberRadio</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>OpenOrder</tag>
                    </tags>
                </object>
                <object type="EditField" technology="WPF">
                    <name>byNameWatermark</name>
                    <codeName>ByNameWatermarkEditField</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">byNameWatermark</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>OpenOrder</tag>
                    </tags>
                </object>
                <object type="Calendar" technology="WPF">
                    <name>byDatePicker</name>
                    <codeName>ByDatePickerCalendar</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">byDatePicker</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>OpenOrder</tag>
                    </tags>
                </object>
                <object type="EditField" technology="WPF">
                    <name>byNumberWatermark</name>
                    <codeName>ByNumberWatermarkEditField</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">byNumberWatermark</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>OpenOrder</tag>
                    </tags>
                </object>
                <object type="Button" technology="WPF">
                    <name>SEARCH</name>
                    <codeName>SEARCHButton</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">searchBtn</property>
                            <property name="Text" type="string" isRegExp="false">SEARCH</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>OpenOrder</tag>
                    </tags>
                </object>
                <object type="Table" technology="WPF">
                    <name>ordersDataGrid</name>
                    <codeName>OrdersDataGridTable</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">ordersDataGrid</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>OrderSelection</tag>
                    </tags>
                </object>
                <object type="Button" technology="WPF">
                    <name>SELECT ORDER</name>
                    <codeName>SELECTORDERButton</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">selectOrderBtn</property>
                            <property name="Text" type="string" isRegExp="false">SELECT ORDER</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>OrderSelection</tag>
                    </tags>
                </object>
                <object type="ComboBox" technology="WPF">
                    <name>numOfTicketsCombo</name>
                    <codeName>NumOfTicketsComboComboBox</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">numOfTicketsCombo</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>UpdateOrder</tag>
                    </tags>
                </object>
                <object type="ComboBox" technology="WPF">
                    <name>flightClassCombo</name>
                    <codeName>FlightClassComboComboBox</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">flightClassCombo</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>UpdateOrder</tag>
                    </tags>
                </object>
                <object type="Button" technology="WPF">
                    <name>updateBtn</name>
                    <codeName>UpdateBtnButton</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ObjectName" type="string" isRegExp="false">updateBtn</property>
                        </properties>
                    </identification>
                    <tags>
                        <tag>UpdateOrder</tag>
                    </tags>
                </object>
                <object type="Button" technology="WPF">
                    <name>WpfButton</name>
                    <codeName>WpfButton</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="WindowTitleRegExp" type="string" isRegExp="false">Micro Focus MyFlight Sample Application</property>
                            <property name="ObjectName" type="string" isRegExp="false"></property>
                            <property name="FullNamePath" type="string" isRegExp="false">;;</property>
                            <property name="FullType" type="string" isRegExp="false">button</property>
                        </properties>
                        <index>0</index>
                    </identification>
                    <tags>
                        <tag>UpdateOrder</tag>
                    </tags>
                </object>
            </children>
            <tags>
                <tag>Main</tag>
            </tags>
        </object>
    </objects>
</applicationModel>
