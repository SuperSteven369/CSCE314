// Author Name: Siyuan Yang
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

public class MainWindow extends JFrame
{
	private static final long serialVersionUID = -3880026026104218593L;
	private Primes m_Primes;
	private JTextField tfPrimeFileName;
	private JTextField tfCrossFileName;
	private JLabel lblPrimeCount;
	private JLabel lblCrossCount;
	private JLabel lblLargestPrime;
	private JLabel lblLargestCross;
	private JLabel lblStatus;
	
	MainWindow(String name, Primes p)
	{
	    m_Primes = p;
	    getContentPane().setBackground(new Color(80, 0, 0));
	    getContentPane().setLayout(null);
	    
	    tfPrimeFileName = new JTextField();
	    tfPrimeFileName.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    tfPrimeFileName.setText(Config.PRIMEFILENAME);
	    tfPrimeFileName.setBounds(10, 11, 853, 34);
        getContentPane().add(tfPrimeFileName);
        tfPrimeFileName.setColumns(10);
        
        tfCrossFileName = new JTextField();
        tfCrossFileName.setText(Config.CROSSFILENAME);
        tfCrossFileName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tfCrossFileName.setColumns(10);
        tfCrossFileName.setBounds(10, 121, 853, 34);
        getContentPane().add(tfCrossFileName);
        
        lblStatus = new JLabel("Status: Bored");
        lblStatus.setForeground(Color.WHITE);
        lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblStatus.setBounds(10, 324, 463, 26);
        getContentPane().add(lblStatus);
	    
	    JButton btnLoad = new JButton("Load");
	    btnLoad.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            String PrimeFileName = tfPrimeFileName.getText();
	            if (FileAccess.loadPrimes(m_Primes, PrimeFileName)) {
	                lblStatus.setText("Prime list loaded successfully.");
        	        updateStats();
	            }
	        }
	    });
	    btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    btnLoad.setBounds(731, 56, 115, 48);
	    getContentPane().add(btnLoad);
	    
        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String PrimeFileName = tfPrimeFileName.getText();
                if (FileAccess.savePrimes(m_Primes, PrimeFileName)) {
                    lblStatus.setText("Prime list saved successfully.");
                }               
            }
        });
        btnSave.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnSave.setBounds(859, 56, 115, 48);
        getContentPane().add(btnSave);
        
	    JLabel lblPrimesFile = new JLabel("Primes File");
	    lblPrimesFile.setForeground(Color.WHITE);
	    lblPrimesFile.setFont(new Font("Tahoma", Font.PLAIN, 30));
	    lblPrimesFile.setBounds(10, 48, 157, 48);
	    getContentPane().add(lblPrimesFile);
	    
	    JLabel lblHexagonCrossFile = new JLabel("Hexagon Cross File");
	    lblHexagonCrossFile.setForeground(Color.WHITE);
	    lblHexagonCrossFile.setFont(new Font("Tahoma", Font.PLAIN, 30));
	    lblHexagonCrossFile.setBounds(10, 166, 259, 48);
	    getContentPane().add(lblHexagonCrossFile);
	    
	    JButton button = new JButton("Load");
	    button.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            String CrossFileName = tfCrossFileName.getText();
	            if (FileAccess.loadCrosses(m_Primes, CrossFileName)) {
    	            lblStatus.setText("Cross list loaded successfully.");
    	            updateStats();
	            }
	        }
	    });
	    button.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    button.setBounds(731, 166, 115, 48);
	    getContentPane().add(button);
	    
	    JButton button_1 = new JButton("Save");
	    button_1.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            String CrossFileName = tfCrossFileName.getText();
                if (FileAccess.saveCrosses(m_Primes, CrossFileName)) {
                    lblStatus.setText("Cross list saved successfully.");
                }        
	        }
	    });
	    button_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    button_1.setBounds(859, 166, 115, 48);
	    getContentPane().add(button_1);
	    
	    JButton btnGeneratePrimes_1 = new JButton("Generate Primes");
	    btnGeneratePrimes_1.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            popupGeneratePrimes();
	        }
	    });
	    btnGeneratePrimes_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    btnGeneratePrimes_1.setBounds(10, 248, 259, 48);
	    getContentPane().add(btnGeneratePrimes_1);
	    
	    JButton btnGenerateCrosses = new JButton("Generate Crosses");
	    btnGenerateCrosses.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            popupGenerateCrosses();
	        }
	    });
	    btnGenerateCrosses.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    btnGenerateCrosses.setBounds(715, 248, 259, 48);
	    getContentPane().add(btnGenerateCrosses);
	    
	    lblLargestPrime = new JLabel("The largest prime has 0 digits.");
	    lblLargestPrime.setForeground(Color.WHITE);
	    lblLargestPrime.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblLargestPrime.setBounds(390, 248, 265, 26);
	    getContentPane().add(lblLargestPrime);
	    
	    lblLargestCross = new JLabel("The largest cross has 0 and 0 digits.");
	    lblLargestCross.setForeground(Color.WHITE);
	    lblLargestCross.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblLargestCross.setBounds(374, 270, 281, 26);
	    getContentPane().add(lblLargestCross);
	    
	    lblPrimeCount = new JLabel("0");
	    lblPrimeCount.setForeground(Color.WHITE);
	    lblPrimeCount.setFont(new Font("Tahoma", Font.PLAIN, 22));
	    lblPrimeCount.setBounds(914, 9, 60, 30);
	    getContentPane().add(lblPrimeCount);
	    
	    lblCrossCount = new JLabel("0");
	    lblCrossCount.setForeground(Color.WHITE);
	    lblCrossCount.setFont(new Font("Tahoma", Font.PLAIN, 22));
	    lblCrossCount.setBounds(914, 119, 60, 30);
	    getContentPane().add(lblCrossCount);
	    
	}

	protected void popupGeneratePrimes()
	{
		JDialog dPrimes = new JDialog(this, "Prime Number Generation");
		GridBagLayout gridLayout = new GridBagLayout(); 
		dPrimes.getContentPane().setBackground(new Color(52, 0, 0));
		dPrimes.getContentPane().setLayout(gridLayout);
		
		GridBagConstraints gbcDialog = new GridBagConstraints();
		gbcDialog.fill = GridBagConstraints.HORIZONTAL;
		gbcDialog.anchor = GridBagConstraints.WEST;
		gbcDialog.ipady = 10;
		gbcDialog.weightx = .5;
		gbcDialog.insets = new Insets(1,2,0,0);
		gbcDialog.gridx = 0;
		gbcDialog.gridy = 0;
		
		GridBagConstraints gbcPanel = new GridBagConstraints();
		gbcPanel.anchor = GridBagConstraints.WEST;
		gbcPanel.weightx = .5;
		gbcPanel.insets = new Insets(1,2,0,0);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		
		JPanel pnlGenerate = new JPanel();
		pnlGenerate.setLayout(new GridBagLayout());
		
		JLabel lblCount = new JLabel("Number of Primes to Generate");
		lblCount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pnlGenerate.add(lblCount, gbcPanel);
		
		JTextField tfCount = new JTextField();
		lblCount.setLabelFor(tfCount);
		tfCount.setColumns(30);
		gbcPanel.gridx = 1;
		pnlGenerate.add(tfCount, gbcPanel);
		
		JLabel lblStart = new JLabel("Starting Number (does not have to be prime)");
		lblStart.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;
		pnlGenerate.add(lblStart, gbcPanel);
		
		JTextField tfStart = new JTextField();
		lblStart.setLabelFor(tfStart);
		tfStart.setColumns(30);
		gbcPanel.gridx = 1;
		pnlGenerate.add(tfStart, gbcPanel);
		
		dPrimes.getContentPane().add(pnlGenerate, gbcDialog);
		
		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new GridBagLayout());
		
		JButton btnGeneratePrimes = new JButton("Generate Primes");
		btnGeneratePrimes.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      	try
      	{
      		BigInteger start = new BigInteger(tfStart.getText());
      		int count = Integer.parseInt(tfCount.getText());
       		m_Primes.generatePrimes(start, count);
       		lblStatus.setText("Status: Excited. Primes have been generated.");
       		updateStats();
      		dPrimes.dispose();
      	}
      	catch(NumberFormatException ex)
      	{
      		lblStatus.setText("You failed to type in an integer successfully. You are terrible at math. Shame.");
      		dPrimes.dispose();
      	}
      	
      }
    });
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 0;
		pnlButtons.add(btnGeneratePrimes, gbcPanel);
		
		JButton btnCancel = new JButton("Cancel Generation");
		btnCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      	dPrimes.dispose();
      }
    });
		gbcPanel.anchor = GridBagConstraints.EAST;
		gbcPanel.gridx = 1;
		pnlButtons.add(btnCancel, gbcPanel);		
		
		gbcDialog.gridy = 1;
		dPrimes.getContentPane().add(pnlButtons, gbcDialog);
		
		JPanel pnlStatus = new JPanel();
		pnlStatus.setLayout(new GridBagLayout());

		gbcPanel.anchor = GridBagConstraints.SOUTHWEST;
		gbcPanel.weightx = .5;
		gbcPanel.insets = new Insets(1,2,0,0);
		gbcPanel.gridx = 0;
		gbcPanel.gridy = 1;

		JLabel lblNotice = new JLabel("Warning: This application is single threaded, and will freeze while generating primes.");
		lblNotice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pnlStatus.add(lblNotice, gbcPanel);
		
		gbcDialog.gridy = 2;
		dPrimes.getContentPane().add(pnlStatus, gbcDialog);
		
		dPrimes.setSize(200,200);
		dPrimes.pack(); // Knowing what this is and why it is needed is important. You should read the documentation on this function!
		dPrimes.setVisible(true);		
	}
	
	protected void popupGenerateCrosses()
    {
        JDialog dPrimes = new JDialog(this, "Hexagon Cross Generation");
        GridBagLayout gridLayout = new GridBagLayout(); 
        dPrimes.getContentPane().setBackground(new Color(52, 0, 0));
        dPrimes.getContentPane().setLayout(gridLayout);
        
        GridBagConstraints gbcDialog = new GridBagConstraints();
        gbcDialog.fill = GridBagConstraints.HORIZONTAL;
        gbcDialog.anchor = GridBagConstraints.WEST;
        gbcDialog.ipady = 10;
        gbcDialog.weightx = .5;
        gbcDialog.insets = new Insets(1,2,0,0);
        gbcDialog.gridx = 0;
        gbcDialog.gridy = 0;
        
        GridBagConstraints gbcPanel = new GridBagConstraints();
        gbcPanel.anchor = GridBagConstraints.WEST;
        gbcPanel.weightx = .5;
        gbcPanel.insets = new Insets(1,2,0,0);
        gbcPanel.gridx = 0;
        gbcPanel.gridy = 0;
        
        JPanel pnlGenerate = new JPanel();
        pnlGenerate.setLayout(new GridBagLayout());
        
        JLabel lblCount = new JLabel("Number of Primes to Generate");
        lblCount.setFont(new Font("Tahoma", Font.PLAIN, 12));
        pnlGenerate.add(lblCount, gbcPanel);
        
        JTextField tfCount = new JTextField();
        lblCount.setLabelFor(tfCount);
        tfCount.setColumns(30);
        gbcPanel.gridx = 1;
        pnlGenerate.add(tfCount, gbcPanel);
        
        JLabel lblStart = new JLabel("Starting Number (does not have to be prime)");
        lblStart.setFont(new Font("Tahoma", Font.PLAIN, 12));
        gbcPanel.gridx = 0;
        gbcPanel.gridy = 1;
        pnlGenerate.add(lblStart, gbcPanel);
        
        JTextField tfStart = new JTextField();
        lblStart.setLabelFor(tfStart);
        tfStart.setColumns(30);
        gbcPanel.gridx = 1;
        pnlGenerate.add(tfStart, gbcPanel);
        
        dPrimes.getContentPane().add(pnlGenerate, gbcDialog);
        
        JPanel pnlButtons = new JPanel();
        pnlButtons.setLayout(new GridBagLayout());
        
        JButton btnGeneratePrimes = new JButton("Generate Crosses");
        btnGeneratePrimes.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try
        {
            BigInteger start = new BigInteger(tfStart.getText());
            int count = Integer.parseInt(tfCount.getText());
            m_Primes.generatePrimes(start, count);
            m_Primes.generateTwinPrimes();
            m_Primes.generateHexPrimes();
            lblStatus.setText("Status: Excited. Crosses have been generated.");
            updateStats();
            dPrimes.dispose();
        }
        catch(NumberFormatException ex)
        {
            lblStatus.setText("You failed to type in an integer successfully. You are terrible at math. Shame.");
            dPrimes.dispose();
        }
      }
    });
        gbcPanel.gridx = 0;
        gbcPanel.gridy = 0;
        pnlButtons.add(btnGeneratePrimes, gbcPanel);
        
        JButton btnCancel = new JButton("Cancel Generation");
        btnCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dPrimes.dispose();
      }
    });
        gbcPanel.anchor = GridBagConstraints.EAST;
        gbcPanel.gridx = 1;
        pnlButtons.add(btnCancel, gbcPanel);        
        
        gbcDialog.gridy = 1;
        dPrimes.getContentPane().add(pnlButtons, gbcDialog);
        
        JPanel pnlStatus = new JPanel();
        pnlStatus.setLayout(new GridBagLayout());

        gbcPanel.anchor = GridBagConstraints.SOUTHWEST;
        gbcPanel.weightx = .5;
        gbcPanel.insets = new Insets(1,2,0,0);
        gbcPanel.gridx = 0;
        gbcPanel.gridy = 1;

        JLabel lblNotice = new JLabel("Warning: This application is single threaded, and will freeze while generating primes.");
        lblNotice.setFont(new Font("Tahoma", Font.PLAIN, 12));
        pnlStatus.add(lblNotice, gbcPanel);
        
        gbcDialog.gridy = 2;
        dPrimes.getContentPane().add(pnlStatus, gbcDialog);
        
        dPrimes.setSize(200,200);
        dPrimes.pack(); // Knowing what this is and why it is needed is important. You should read the documentation on this function!
        dPrimes.setVisible(true);       
    }
	// This function updates all the GUI statistics. (# of primes, # of crosses, etc)
	private void updateStats()
	{
	    if (m_Primes.primeCount() != 0) {
    	    // Update lblPrimeCount
            lblPrimeCount.setText(Integer.toString(m_Primes.primeCount())); 
            // Update lblLargestPrime
            lblLargestPrime.setText("The largest prime has " + m_Primes.sizeofLastPrime() +" digits.");   
	    }
	    if (m_Primes.crossesCount() != 0) {
            // Update lblCrossCount
            lblCrossCount.setText(Integer.toString(m_Primes.crossesCount()));
            // Update lblLargestCross
            lblLargestCross.setText("The largest cross has " + m_Primes.sizeofLastCross().left() + " and " + m_Primes.sizeofLastCross().right() + " digits.");
	    }
 	}
}
