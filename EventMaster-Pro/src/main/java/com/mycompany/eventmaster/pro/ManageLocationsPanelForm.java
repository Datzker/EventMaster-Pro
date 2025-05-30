/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.eventmaster.pro;

import com.mycompany.eventmaster.pro.EventMasterSystem;
import com.mycompany.eventmaster.pro.Location;

/**
 * Desarrolladores:
 *         - Isabella Gómez Parra.
 *         - Daniel Eduardo González Palacio.
 */

public class ManageLocationsPanelForm extends javax.swing.JPanel {

    private EventMasterSystem system;

    /**
     * Creates new form ManageLocationsPanelForm
     */
    public ManageLocationsPanelForm(EventMasterSystem system) {
        this.system = system;
        initComponents();
        jButtonAddLocation.addActionListener(e -> addLocation());
        jButtonShowLocations.addActionListener(e -> showLocations());
    }

    private void addLocation() {
        String name = jTextFLocationName.getText().trim();
        String capacityStr = jTextFCapacity.getText().trim();
        String techDetails = jTextFTechDetails.getText().trim();
        String availableDatesStr = jTextFAvailableDates.getText().trim();

        if (name.isEmpty() || capacityStr.isEmpty() || techDetails.isEmpty()) {
            jLabelResult.setText("Please fill all fields.");
            return;
        }

        int capacity;

        try {
            capacity = Integer.parseInt(capacityStr);
        } catch (NumberFormatException ex) {
            jLabelResult.setText("Invalid capacity.");
            return;
        }

        Location location = new Location(name, capacity, techDetails);

        if (!availableDatesStr.isEmpty()) {
            String[] dates = availableDatesStr.split(",");
            for (String date : dates) {
                location.addAvailableDate(date.trim());
            }
        }

        system.registerLocation(location);
        jLabelResult.setText("Location added.");
        clearFields();

        EventMasterUI mainUI = EventMasterUI.getInstance();
        if (mainUI != null) {
            mainUI.refreshAllPanels();
        }
    }

    private void deleteLocation() {
        String name = jTextFLocationName.getText().trim();

        if (name.isEmpty()) {
            jLabelResult.setText("Enter location name to delete.");
            return;
        }

        system.deleteLocation(name);
        jLabelResult.setText("Location deleted.");
        clearFields();

        EventMasterUI mainUI = EventMasterUI.getInstance();
        if (mainUI != null) {
            mainUI.refreshAllPanels();
        }
    }

    private void showLocations() {
        StringBuilder sb = new StringBuilder();
        for (Location loc : system.getLocations()) {
            sb.append(loc.toString()).append("\n");
        }
        jTextAreaLocations.setText(sb.toString());
    }

    private void clearFields() {
        jTextFLocationName.setText("");
        jTextFCapacity.setText("");
        jTextFTechDetails.setText("");
        jTextFAvailableDates.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAddLocation = new javax.swing.JButton();
        Result = new javax.swing.JLabel();
        jLabelResult = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFLocationName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFCapacity = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFTechDetails = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFAvailableDates = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaLocations = new javax.swing.JTextArea();
        jButtonShowLocations = new javax.swing.JButton();

        jButtonAddLocation.setText("Add Location");

        Result.setText("Result:");

        jLabel1.setText("Location Name:");

        jLabel2.setText("Capacity:");

        jLabel3.setText("Technical Details:");

        jLabel4.setText("Available Dates,(comma separated):");

        jLabel5.setText("Show all locations:");

        jTextAreaLocations.setColumns(20);
        jTextAreaLocations.setRows(5);
        jScrollPane1.setViewportView(jTextAreaLocations);

        jButtonShowLocations.setText("Show All Locations");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFAvailableDates, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                .addComponent(jTextFTechDetails, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFCapacity, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFLocationName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButtonAddLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jButtonShowLocations))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelResult, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Result, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFLocationName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFTechDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFAvailableDates, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAddLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButtonShowLocations, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(Result, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelResult, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Result;
    private javax.swing.JButton jButtonAddLocation;
    private javax.swing.JButton jButtonShowLocations;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelResult;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaLocations;
    private javax.swing.JTextField jTextFAvailableDates;
    private javax.swing.JTextField jTextFCapacity;
    private javax.swing.JTextField jTextFLocationName;
    private javax.swing.JTextField jTextFTechDetails;
    // End of variables declaration//GEN-END:variables
}
