import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RunwayUI implements ActionListener {

    JFrame jf;
    JLabel lblTitle, lblFlightNo, lblAirline, lblType;
    JTextField tFlightNo, tAirline;
    JComboBox<String> cbType;
    JCheckBox chkEmergency;
    JButton bAdd, bProcess, bSave, bClear;
    JLabel lblQueue, lblLog;
    JTextArea taQueue, taLog;
    JScrollPane spQueue, spLog;

    FlightQueue runwayQueue = new FlightQueue();

    public RunwayUI() {
        jf = new JFrame("Airport Runway Scheduling System");
        jf.setLayout(null);
        jf.setSize(750, 520);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);

        lblTitle = new JLabel("AIRPORT RUNWAY SCHEDULING SYSTEM");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitle.setBounds(30, 15, 500, 25);
        jf.add(lblTitle);

        lblFlightNo = new JLabel("Flight No:");
        lblFlightNo.setBounds(30, 60, 90, 25);
        jf.add(lblFlightNo);

        tFlightNo = new JTextField();
        tFlightNo.setBounds(120, 60, 160, 25);
        jf.add(tFlightNo);

        lblAirline = new JLabel("Airline:");
        lblAirline.setBounds(30, 95, 90, 25);
        jf.add(lblAirline);

        tAirline = new JTextField();
        tAirline.setBounds(120, 95, 160, 25);
        jf.add(tAirline);

        lblType = new JLabel("Operation:");
        lblType.setBounds(30, 130, 90, 25);
        jf.add(lblType);

        String[] types = {"Landing", "Takeoff"};
        cbType = new JComboBox<>(types);
        cbType.setBounds(120, 130, 160, 25);
        jf.add(cbType);

        chkEmergency = new JCheckBox("Emergency (High Priority)");
        chkEmergency.setBounds(30, 165, 250, 25);
        jf.add(chkEmergency);

        bAdd = new JButton("Add Flight to Queue");
        bAdd.setBounds(30, 205, 250, 35);
        bAdd.addActionListener(this);
        jf.add(bAdd);

        bProcess = new JButton("Clear Runway (Process Next)");
        bProcess.setBounds(30, 265, 250, 35);
        bProcess.setBackground(new Color(220, 240, 220));
        bProcess.addActionListener(this);
        jf.add(bProcess);

        bSave = new JButton("Save Log to File");
        bSave.setBounds(30, 315, 250, 35);
        bSave.addActionListener(this);
        jf.add(bSave);

        bClear = new JButton("Clear Form Fields");
        bClear.setBounds(30, 365, 250, 30);
        bClear.addActionListener(this);
        jf.add(bClear);

        lblQueue = new JLabel("Runway Queue (Emergency Flights at Front):");
        lblQueue.setBounds(310, 45, 350, 20);
        jf.add(lblQueue);

        taQueue = new JTextArea();
        taQueue.setEditable(false);
        spQueue = new JScrollPane(taQueue);
        spQueue.setBounds(310, 70, 400, 165);
        jf.add(spQueue);

        lblLog = new JLabel("Runway Activity Log:");
        lblLog.setBounds(310, 245, 350, 20);
        jf.add(lblLog);

        taLog = new JTextArea();
        taLog.setEditable(false);
        spLog = new JScrollPane(taLog);
        spLog.setBounds(310, 270, 400, 175);
        jf.add(spLog);

        updateQueueDisplay();
        jf.setVisible(true);
    }

    private void updateQueueDisplay() {
        taQueue.setText(runwayQueue.getDisplayList());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bAdd) {
            String fNo = tFlightNo.getText().trim();
            String airline = tAirline.getText().trim();
            String type = (String) cbType.getSelectedItem();
            boolean isEmergency = chkEmergency.isSelected();

            if (fNo.isEmpty() || airline.isEmpty()) {
                JOptionPane.showMessageDialog(jf, "Please enter both Flight Number and Airline!");
                return;
            }

            Aircraft flight = new Aircraft(fNo, airline, type, isEmergency);
            runwayQueue.enqueue(flight);

            tFlightNo.setText("");
            tAirline.setText("");
            chkEmergency.setSelected(false);

            updateQueueDisplay();
            JOptionPane.showMessageDialog(jf, "Flight " + fNo + " added to Runway Queue!");
        } else if (e.getSource() == bProcess) {
            if (!runwayQueue.isEmpty()) {
                Aircraft a = runwayQueue.dequeue();
                String msg = "[RUNWAY] " + a.flightNo + " (" + a.airline + ") completed " 
                             + a.type.toUpperCase() + (a.isEmergency ? " [EMERGENCY]" : "");
                taLog.append(msg + "\n");
                FileHandler.saveLog(msg);
                updateQueueDisplay();
            } else {
                JOptionPane.showMessageDialog(jf, "Runway is clear! No aircraft waiting.");
            }
        } else if (e.getSource() == bSave) {
            String logContent = taLog.getText().trim();
            if (logContent.isEmpty()) {
                JOptionPane.showMessageDialog(jf, "No activity to save yet!");
                return;
            }
            boolean success = FileHandler.saveLog("--- SESSION LOG EXPORT ---\n" + logContent);
            if (success) {
                JOptionPane.showMessageDialog(jf, "Log successfully saved to 'runway_log.txt'!");
            } else {
                JOptionPane.showMessageDialog(jf, "Failed to save log to file.");
            }
        } else if (e.getSource() == bClear) {
            tFlightNo.setText("");
            tAirline.setText("");
            cbType.setSelectedIndex(0);
            chkEmergency.setSelected(false);
        }
    }

    public static void main(String[] args) {
        new RunwayUI();
    }
}
