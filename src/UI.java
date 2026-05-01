import java.awt.CardLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class UI {

	private JFrame frame;
	private CardLayout cardlay = new CardLayout(0, 0);
	
	JPanel cardPanel;
	JPanel panelSavedData;
	JPanel panelNewData;
	
	private JTextField textUsername;
	private JTextField textAge;
	private JTextField textContact;
	
	private DefaultTableModel dataInputModel = new DefaultTableModel(0, 2);
	private DefaultListModel<String> savedTableDisplay = new DefaultListModel<>();
	private DefaultTableModel savedTables[] = new DefaultTableModel[30];
	
	private int usedTableSlots = 0;
	private String savedCustomerDetails[][] = new String[30][3];
	private JCheckBox serviceBoxes[] = new JCheckBox[10];
	private double servicePrices[] = { // Prices are ordered from index 0-9 matching the order of the Chechboxes;
									1000,
									2000,
									3000,
									4000,
									5000,
									6000,
									7000,
									8000,
									9000,
									10000
	};
	private int usedInputSlots = 0;
	
	private JTable tableInput;
	private JList<String> listDisplayTables;
	private JTable tableDisplay;
	private JLabel lblDentalServices;
	
	private JTextField textSavedName;
	private JTextField textSavedContact;
	private JTextField textSavedAge;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 690, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		cardPanel = new JPanel();
		cardPanel.setBounds(10, 11, 654, 399);
		frame.getContentPane().add(cardPanel);
		//cardPanel.setLayout(cardlay);						// Uncomment code snippet for easier UI editting
		
		panelNewData = new JPanel();
		panelNewData.setBounds(0, 0, 654, 399);
		panelNewData.setLayout(null);
		panelNewData.setVisible(false);
		
		textUsername = new JTextField();
		textUsername.setColumns(10);
		textUsername.setBounds(84, 11, 175, 20);
		panelNewData.add(textUsername);
		
		JLabel lblUsername = new JLabel("Name");
		lblUsername.setBounds(10, 14, 46, 14);
		panelNewData.add(lblUsername);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(10, 39, 46, 14);
		panelNewData.add(lblAge);
		
		textAge = new JTextField();
		textAge.setColumns(10);
		textAge.setBounds(84, 36, 175, 20);
		panelNewData.add(textAge);
		
		JLabel lblContact = new JLabel("Contact No.");
		lblContact.setBounds(10, 64, 71, 14);
		panelNewData.add(lblContact);
		
		textContact = new JTextField();
		textContact.setColumns(10);
		textContact.setBounds(84, 61, 175, 20);
		panelNewData.add(textContact);
		
		JScrollPane scrollInput = new JScrollPane();
		scrollInput.setBounds(269, 11, 375, 325);
		panelNewData.add(scrollInput);
		
		tableInput = new JTable(dataInputModel) {
			
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
				}};
		tableInput.setFillsViewportHeight(true);
		tableInput.setBounds(269, 14, 375, 320);
		scrollInput.setViewportView(tableInput);
		
		lblDentalServices = new JLabel("Dental Services");
		lblDentalServices.setBounds(10, 89, 92, 14);
		panelNewData.add(lblDentalServices);
		
		JSeparator separatorDentalService = new JSeparator();
		separatorDentalService.setBounds(108, 96, 148, 2);
		panelNewData.add(separatorDentalService);
		
		JCheckBox chckbxOption1 = new JCheckBox("Option 1");
		serviceBoxes[0] = chckbxOption1;
		chckbxOption1.setBounds(5, 110, 254, 23);
		panelNewData.add(chckbxOption1);
		
		JCheckBox chckbxOption2 = new JCheckBox("Option 2");
		serviceBoxes[1] = chckbxOption2;
		chckbxOption2.setBounds(5, 136, 251, 23);
		panelNewData.add(chckbxOption2);
		
		JCheckBox chckbxOption3 = new JCheckBox("Option 3");
		serviceBoxes[2] = chckbxOption3;
		chckbxOption3.setBounds(5, 162, 251, 23);
		panelNewData.add(chckbxOption3);
		
		JSeparator separatorAddService = new JSeparator();
		separatorAddService.setBounds(124, 199, 135, 2);
		panelNewData.add(separatorAddService);
		
		JLabel lblAdditionalServices = new JLabel("Additional Services");
		lblAdditionalServices.setBounds(10, 192, 115, 14);
		panelNewData.add(lblAdditionalServices);
		
		JCheckBox chckbxOption4 = new JCheckBox("Option 4");
		serviceBoxes[3] = chckbxOption4;
		chckbxOption4.setBounds(5, 208, 251, 23);
		panelNewData.add(chckbxOption4);
		
		JCheckBox chckbxOption5 = new JCheckBox("Option 5");
		serviceBoxes[4] = chckbxOption5;
		chckbxOption5.setBounds(5, 234, 251, 23);
		panelNewData.add(chckbxOption5);
		
		JCheckBox chckbxOption6 = new JCheckBox("Option 6");
		serviceBoxes[5] = chckbxOption6;
		chckbxOption6.setBounds(5, 260, 251, 23);
		panelNewData.add(chckbxOption6);
		
		JCheckBox chckbxOption7 = new JCheckBox("Option 7");
		serviceBoxes[6] = chckbxOption7;
		chckbxOption7.setBounds(5, 286, 251, 23);
		panelNewData.add(chckbxOption7);
		
		JCheckBox chckbxOption8 = new JCheckBox("Option 8");
		serviceBoxes[7] = chckbxOption8;
		chckbxOption8.setBounds(5, 312, 251, 23);
		panelNewData.add(chckbxOption8);
		
		JCheckBox chckbxOption9 = new JCheckBox("Option 9");
		serviceBoxes[8] = chckbxOption9;
		chckbxOption9.setBounds(5, 338, 251, 23);
		panelNewData.add(chckbxOption9);
		
		JCheckBox chckbxOption10 = new JCheckBox("Option 10");
		serviceBoxes[9] = chckbxOption10;
		chckbxOption10.setBounds(5, 364, 251, 23);
		panelNewData.add(chckbxOption10);
		
		JButton btnCalculateBill = new JButton("Calculate Bill");
		btnCalculateBill.addActionListener(calculate);
		btnCalculateBill.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCalculateBill.setBounds(286, 364, 168, 23);
		panelNewData.add(btnCalculateBill);
		
		panelSavedData = new JPanel();
		panelSavedData.setBounds(0, 0, 654, 399);
		
		
		panelSavedData.setLayout(null);
		
		JScrollPane scrollTable = new JScrollPane();
		scrollTable.setBounds(271, 68, 373, 320);
		panelSavedData.add(scrollTable);
		
		tableDisplay = new JTable() {
			
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
				}};;
		tableDisplay.setFillsViewportHeight(true);
		tableDisplay.setBounds(271, 68, 375, 320);
		scrollTable.setViewportView(tableDisplay);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 251, 286);
		panelSavedData.add(scrollPane);
		
		listDisplayTables = new JList<>(savedTableDisplay);
		listDisplayTables.addMouseListener(selectView);
		scrollPane.setViewportView(listDisplayTables);
		
		JLabel lblSavedName = new JLabel("Customer Name:");
		lblSavedName.setBounds(271, 11, 102, 14);
		panelSavedData.add(lblSavedName);
		
		textSavedName = new JTextField();
		textSavedName.setEditable(false);
		textSavedName.setBounds(371, 8, 153, 20);
		panelSavedData.add(textSavedName);
		textSavedName.setColumns(10);
		
		JLabel lblSavedContact = new JLabel("Contact No.");
		lblSavedContact.setBounds(271, 40, 90, 14);
		panelSavedData.add(lblSavedContact);
		
		textSavedContact = new JTextField();
		textSavedContact.setEditable(false);
		textSavedContact.setColumns(10);
		textSavedContact.setBounds(371, 37, 153, 20);
		panelSavedData.add(textSavedContact);
		
		JLabel lblSavedAge = new JLabel("Age");
		lblSavedAge.setBounds(528, 11, 26, 14);
		panelSavedData.add(lblSavedAge);
		
		textSavedAge = new JTextField();
		textSavedAge.setEditable(false);
		textSavedAge.setColumns(10);
		textSavedAge.setBounds(557, 8, 87, 20);
		panelSavedData.add(textSavedAge);
		
		JButton btnNewEntry = new JButton("New Form");
		btnNewEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cardlay.next(cardPanel);
				panelNewData.setVisible(true);
				panelSavedData.setVisible(false);
			}
		});
		btnNewEntry.setBounds(76, 365, 102, 23);
		panelSavedData.add(btnNewEntry);

		dataInputModel.setColumnIdentifiers(new String[] {"Service", "Price"} );
		
		for(JCheckBox cb : serviceBoxes) {
			cb.addItemListener(service);
		}
		
		for(int tm = 0; tm < savedTables.length; tm++) {
			savedTables[tm] = new DefaultTableModel(0, 2);
			savedTables[tm].setColumnIdentifiers(new String[] {"Service", "Price"} );
		}
		cardPanel.setLayout(null);
		
		cardPanel.add(panelSavedData);
		cardPanel.add(panelNewData);
		
		JButton btnClear = new JButton("Clear Form");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnClear.setBounds(464, 364, 168, 23);
		panelNewData.add(btnClear);
		
		
		
		
	}
	
	void clearInput() {
		textUsername.setText("");
		textAge.setText("");
		textContact.setText("");
		deselectBoxes();
		usedInputSlots = 0;
	}
	
	void deselectBoxes() {
		
		for(JCheckBox cb : serviceBoxes) {
			cb.setSelected(false);
		}
		
	}
	
	// View Data Action Events
	
	MouseAdapter selectView = new MouseAdapter() {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
			int target = listDisplayTables.getSelectedIndex();
			tableDisplay.setModel(savedTables[target]);
			System.out.print("list index: " + target);
			textSavedName.setText(savedCustomerDetails[target][0]);
			textSavedAge.setText(savedCustomerDetails[target][1]);
			textSavedContact.setText(savedCustomerDetails[target][2]);
			
		}
		
	};
	
	
	// Input Data Action Events
	ItemListener service = new ItemListener() {

		@Override
		public void itemStateChanged(ItemEvent e) {

			int state = e.getStateChange();
			JCheckBox origin = (JCheckBox) e.getSource();
			String name = origin.getText();
			int target = 0;
			
			
			
			if (state == ItemEvent.SELECTED) {
				
				for(int i = 0; i <= serviceBoxes.length ; i++) {
					
					if(serviceBoxes[i] == origin) {
						target = i;
						System.out.println("target is at: " + i);
						break;
					}
					
				}
				
				String price = String.valueOf(servicePrices[target]);
				dataInputModel.addRow(new String[] {name, price});
				usedInputSlots++;
			}
			else {
				
				for(int i = 0; i <= usedInputSlots; i++) {
					
					String valueAt = dataInputModel.getValueAt(i, 0).toString();
					if(valueAt == name) {
						target = i;
						System.out.println("target is at: " + i);
						break;
					}
					
				}
				
				dataInputModel.removeRow(target);
				usedInputSlots--;
				
			}
			
		}};
		
	ActionListener calculate = new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        
		        String username = textUsername.getText();
		        String age = textAge.getText();
		        String contactNo = textContact.getText();
		            
		        if(username.isEmpty() || age.isEmpty() || contactNo.isEmpty()) {
		            JOptionPane.showMessageDialog(cardPanel, "Customer Information Fields cannot be empty!", "Missing Customer Details", 0);
		            return;    
		        }
		     
		        try {
		            Integer.parseInt(age);
		        } catch(Exception ex) {
		            JOptionPane.showMessageDialog(cardPanel, "Invalid age!", "Error", 0);
		            return;
		        }
    
		        if (dataInputModel.getRowCount() == 0) {
		            JOptionPane.showMessageDialog(cardPanel, "Please select at least one service!", "Error", 0);
		            return;
		        }

		        double totalBill = 0;
		        for (int i = 0; i < dataInputModel.getRowCount(); i++) {
		            double price = Double.parseDouble(dataInputModel.getValueAt(i, 1).toString());
		            totalBill += price;
		        }

		        JOptionPane.showMessageDialog(cardPanel, "Total Bill: ₱" + totalBill);

		        savedCustomerDetails[usedTableSlots][0] = username;
		        savedCustomerDetails[usedTableSlots][1] = age;
		        savedCustomerDetails[usedTableSlots][2] = contactNo;
		        savedTableDisplay.addElement(username);
		        
		        for(int row = 0; row < dataInputModel.getRowCount(); row++) {
		            String service = dataInputModel.getValueAt(row, 0).toString();
		            String price = dataInputModel.getValueAt(row, 1).toString();
		            
		            savedTables[usedTableSlots].addRow(new String[] {service, price});
		        }
		        
		        // Reset to Default
		        clearInput();
		        //for (int i = 0; i < usedTableSlots) dataInputModel.removeRow(i);
		        usedTableSlots++;
		        
                //cardlay.next(cardPanel);
		        panelNewData.setVisible(false);
		        panelSavedData.setVisible(true);
		    }
		};
		
}
