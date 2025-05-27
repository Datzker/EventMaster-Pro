package com.mycompany.eventmaster.pro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventMasterUI extends JFrame {
    private EventMasterSystem system;
    private JPanel mainPanel;
    private JComboBox<String> functionalityCombo;
    private CardLayout cardLayout;

    public EventMasterUI(EventMasterSystem system) {
        super("EventMaster Pro");
        this.system = system;
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
        mainPanel.add(new CreateEventPanelForm(system), "Create Event");
        mainPanel.add(new ModifyEventPanelForm(system), "Modify Event");
        mainPanel.add(new DeleteEventPanelForm(system), "Delete Event");
        mainPanel.add(new ManageLocationsPanelForm(system), "Manage Locations");
        mainPanel.add(new ManageArtistsPanelForm(system), "Manage Artists");
        mainPanel.add(new AssociateArtistPanelForm(system), "Associate Artist to Event");
        mainPanel.add(new ManageTicketsSalesPanelForm(system), "Manage Tickets and Sales");
        mainPanel.add(new AccessControlPanelForm(system), "Access Control");
        mainPanel.add(new FinanceOverviewPanelForm(system), "Finance Overview");
        mainPanel.add(new EventsCalendarPanelForm(system), "Events Calendar");

        functionalityCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) functionalityCombo.getSelectedItem();
                cardLayout.show(mainPanel, selected);
            }
        });
    }

    public static void main(String[] args) {
        EventMasterSystem system = new EventMasterSystem();
        EventMasterUI ui = new EventMasterUI(system);
        ui.setVisible(true);
    }
}
