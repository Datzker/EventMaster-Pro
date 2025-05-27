package com.mycompany.eventmaster.pro;

/**
 * Desarrolladores:
 *         - Isabella Gómez Parra.
 *         - Daniel Eduardo González Palacio.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventMasterUI extends JFrame {
    private static EventMasterUI instance;
    private JPanel mainPanel;
    private JComboBox<String> functionalityCombo;
    private CardLayout cardLayout;
    private CreateEventPanelForm createEventPanelForm;
    private ModifyEventPanelForm modifyEventPanelForm;
    private AssociateArtistPanelForm associateArtistPanelForm;
    private EventsCalendarPanelForm eventsCalendarPanelForm;
    private FinanceOverviewPanelForm financeOverviewPanelForm;
    private ManageTicketsSalesPanelForm manageTicketsSalesPanelForm;

    public EventMasterUI(EventMasterSystem system) {
        super("EventMaster Pro");
        instance = this;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        String[] functionalities = {
            "Create Event",
            "Modify Event",
            "Delete Event",
            "Manage Locations",
            "Manage Artists",
            "Associate Artist to Event",
            "Manage Tickets and Sales",
            "Access Control",
            "Finance Overview",
            "Events Calendar"
        };
        functionalityCombo = new JComboBox<>(functionalities);
        add(functionalityCombo, BorderLayout.NORTH);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        add(mainPanel, BorderLayout.CENTER);

        // Add panels for each functionality
        createEventPanelForm = new CreateEventPanelForm(system);
        modifyEventPanelForm = new ModifyEventPanelForm(system);
        associateArtistPanelForm = new AssociateArtistPanelForm(system);
        eventsCalendarPanelForm = new EventsCalendarPanelForm(system);
        financeOverviewPanelForm = new FinanceOverviewPanelForm(system);
        manageTicketsSalesPanelForm = new ManageTicketsSalesPanelForm(system);
        mainPanel.add(createEventPanelForm, "Create Event");
        mainPanel.add(modifyEventPanelForm, "Modify Event");
        mainPanel.add(new DeleteEventPanelForm(system), "Delete Event");
        mainPanel.add(new ManageLocationsPanelForm(system), "Manage Locations");
        mainPanel.add(new ManageArtistsPanelForm(system), "Manage Artists");
        mainPanel.add(associateArtistPanelForm, "Associate Artist to Event");
        mainPanel.add(manageTicketsSalesPanelForm, "Manage Tickets and Sales");
        mainPanel.add(new AccessControlPanelForm(system), "Access Control");
        mainPanel.add(financeOverviewPanelForm, "Finance Overview");
        mainPanel.add(eventsCalendarPanelForm, "Events Calendar");

        functionalityCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) functionalityCombo.getSelectedItem();
                cardLayout.show(mainPanel, selected);
            }
        });
    }

    public void refreshAllEventComboBoxes() {
        if (modifyEventPanelForm != null) modifyEventPanelForm.refreshEvents();
        if (associateArtistPanelForm != null) associateArtistPanelForm.refreshEvents();
    }

    public void refreshAllLocationComboBoxes() {
        if (createEventPanelForm != null) createEventPanelForm.refreshLocations();
        if (modifyEventPanelForm != null) modifyEventPanelForm.refreshLocations();
        if (associateArtistPanelForm != null) associateArtistPanelForm.refreshEvents();
    }

    public void refreshAllArtistComboBoxes() {
        if (associateArtistPanelForm != null) associateArtistPanelForm.refreshArtists();
    }

    public void refreshAllPanels() {
        refreshAllLocationComboBoxes();
        refreshAllArtistComboBoxes();
        refreshAllEventComboBoxes();
        if (eventsCalendarPanelForm != null) eventsCalendarPanelForm.refreshCalendar();
        if (financeOverviewPanelForm != null) financeOverviewPanelForm.refreshFinance();
        if (manageTicketsSalesPanelForm != null) manageTicketsSalesPanelForm.refreshEvents();
    }

    public static EventMasterUI getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        EventMasterSystem system = new EventMasterSystem();
        EventMasterUI ui = new EventMasterUI(system);
        ui.setVisible(true);
    }
}
