/*
 * Author: Christian Bazoian
 * Created: Sunday, June 16, 2013 8:26:38 PM
 */



/*
 * ++++++++ NOTE WHEN UPDATING PROGRAM +++++++++++++++++++++++++++++++++++++++++
 * 
 * make sure to add the widget, add the action listener, and reset the widget
 *  at the end of the "submit" button action listener.
 *
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */


//TODO: make beds, and "other" JCheckBoxes


import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.Border;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.util.Calendar;
import java.text.SimpleDateFormat;




class PetceteraProgram extends JFrame
{
	// Declare variables here
	private JPanel main;
	Color petPurple = new Color(203,126,207);
	private JMenuItem aboutMenuItem, viewLogMenuItem, exitMenuItem;
	
	private JLabel numberLabel;
	private JLabel itemLabel;
	
	private JCheckBox clothesCheckBox;
	private JLabel clothesLabel;
	private JComboBox clothesCombo;
	
	
	private JCheckBox jewelryCheckBox;
	private JLabel jewelryLabel;
	private JComboBox jewelryCombo;
	
	private JLabel toyLabel;
	private JComboBox toyCombo;
	private JCheckBox toyCheckBox;
	
	private JCheckBox dishesCheckBox;
	private JComboBox dishesCombo;
	private JLabel dishesLabel;
	
	private JCheckBox treatsCheckBox;
	private JComboBox treatsCombo;
	private JLabel treatsLabel;
	
	private JCheckBox bedCheckBox;
	private JComboBox bedCombo;
	private JLabel bedLabel;
	
	private JCheckBox otherCheckBox;
	private JComboBox otherCombo;
	private JLabel otherLabel;
	
	private JButton submitButton;
	
	private JTextArea noteTextArea;
	private JTextField totalPriceTextField;
	
	private JRadioButton cashRadioButton;
	private JRadioButton creditRadioButton;
	private ButtonGroup radioButtonGroup;

	
	
	
	public PetceteraProgram() // constructor
	{
		createUserInterface();  // call createUserInterface()
	}
	
	
	
	
	
	
	public void createUserInterface()
	{
		
		// Returns the contentPane object for this frame.  All programs need this
		Container contentPane = getContentPane();
		
		// Enable explicit positioning of FUI components   All programs need this
		contentPane.setLayout(new BorderLayout());
		
		// Add an Icon to the JFrame
		Image icon = Toolkit.getDefaultToolkit().getImage("petceteraIcon.png");	
		setIconImage(icon);
		
		//make a new border
		Border blackline = BorderFactory.createLineBorder(Color.BLUE);
		
		
		//Make Menu bar
		JMenuBar menuBar = createMenuBar();
		setJMenuBar(menuBar);
		menuBar.setBorder(blackline);
		
		
		//Borders
		Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		
		
		
		
		//============== Main Panel Setup ==============================================
		
		main = new JPanel(null);  // make the main panel
		main.setBackground(petPurple);  // set the background color
		
		contentPane.add(main);
		
		
		
		
		
//+++++++++++ noteTextArea set up ++++++++++++++++++++++++++++++++++++++++++++++
		
		//noteTextArea JTextArea set up
		noteTextArea = new JTextArea("Notes from purchase: ");
		
		noteTextArea.setBorder(loweredbevel);
		noteTextArea.setLineWrap(true);
		noteTextArea.setWrapStyleWord(true);
		noteTextArea.setAutoscrolls(true);
		noteTextArea.setToolTipText("Notes from purchase");
		noteTextArea.setBorder(raisedbevel);
		
		//make the text area scroll down when no more words fit
		JScrollPane scroll = new JScrollPane(noteTextArea);
		scroll.setBounds(200,130,260,90);
		main.add(scroll);
		
		
		
		

		
//+++++++++++ totalPriceTextField set up ++++++++++++++++++++++++++++++++++++++

		totalPriceTextField = new JTextField("$");
		
		
		totalPriceTextField.setBounds(230,75, 80, 20);
		totalPriceTextField.setToolTipText("Type the total price here");
		main.add(totalPriceTextField);
		
		// no action listener - for better example, refer to dinosaur Everything GUI
		//
		//totalPriceTextField.addActionListener(new ActionListener() {
		//	public void actionPerformed(ActionEvent le) {
		//		// do nothing
		//	}
		//});
		
		
		
		
		
		
		
		//numberLabel setup
		numberLabel = new JLabel("Number");
		numberLabel.setBounds(115,10,50,20);
		//numberLabel.setBorder(raisedbevel);
		main.add(numberLabel);
		
		//itemLabel setup
		itemLabel = new JLabel("Item");
		itemLabel.setBounds(40,10,50,20);
		//itemLabel.setBorder(raisedbevel);
		main.add(itemLabel);
		
		
		
		
		
		
		
		
		//++++++++++++++ Radio Button Cash/Credit set up +++++++++++++++++++++++++++++++		
		
		// cash radio button set up	
		cashRadioButton = new JRadioButton("Cash");
		cashRadioButton.setBounds(350,70,60,15);					
		cashRadioButton.setActionCommand("Cash");  //sends "Cash to Action listeners when cash option is selected
		cashRadioButton.setSelected(true);
		cashRadioButton.setToolTipText("Cash Payment");
		main.add(cashRadioButton);
		
		
		//set up for credit radio button
		creditRadioButton = new JRadioButton("Credit");
		creditRadioButton.setBounds(350,90,60,15);		
		creditRadioButton.setActionCommand("Credit"); //sends "Credit" to Action Listeners when credit option is selected
		creditRadioButton.setSelected(false);
		creditRadioButton.setToolTipText("Credit Payment");
		main.add(creditRadioButton);
		
		//add action listeners to the radio buttons
		ActionListener RadioButtonListener = new RadioButtonSelector();
		cashRadioButton.addActionListener((RadioButtonListener));
		creditRadioButton.addActionListener((RadioButtonListener));
		
		// add radio buttons to a group
		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(cashRadioButton);
		radioButtonGroup.add(creditRadioButton);
		
		
		
		//+++++++++++++ Clothes Set up ++++++++++++++++++++++++++++++++++++++++++++++++
		
		// dress check box set up
		clothesCheckBox = new JCheckBox();
		clothesCheckBox.setBounds(70,50,20,20);
		clothesCheckBox.setBorderPaintedFlat(false);
		clothesCheckBox.setSelected(false);
		clothesCheckBox.setToolTipText("Pet Clothes");
		//clothesCheckBox.setBorder(raisedbevel);
		main.add(clothesCheckBox);
		
		//adds action listeners to the clothesCheckBox
		ActionListener clothesListener = new ClothesButtonSelector();
		clothesCheckBox.addActionListener((clothesListener));
		
		
		//clothesLabel setup
		clothesLabel = new JLabel("Clothes");
		clothesLabel.setBounds(10,50,50,20);
		main.add(clothesLabel);
		
		
		
		// Create a clothes combobox
		String[] numberOfItems = {"1", "2", "3", "4", "5", "6", "7"};
		clothesCombo = new JComboBox(numberOfItems);
		clothesCombo.setBounds(110,50,50,20);
		clothesCombo.setBorder(loweredbevel);
		clothesCombo.setToolTipText("How Many");
		clothesCombo.setEnabled(false);
		main.add(clothesCombo);
		
		//Add action listener to combo box
		clothesCombo.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent event) 
				{
					Object clothesContents = clothesCombo.getSelectedItem();
					System.out.println(clothesContents + " clothes selected");
				}
			});
		
		
		
		
		
		// +++++++++++++ Jewelry Set up ++++++++++++++++++++++++++++++++++++++++++++++++	
		
		//set up for jewelryCheckBox
		jewelryCheckBox = new JCheckBox();
		jewelryCheckBox.setBounds(70,80,20,20);
		jewelryCheckBox.setBorderPaintedFlat(false);
		jewelryCheckBox.setSelected(false);
		jewelryCheckBox.setToolTipText("Pet Themed Jewelry");
		//jewelryCheckBox.setBorder(raisedbevel);
		main.add(jewelryCheckBox);
		
		//adds action listeners to the jewelryCheckBox
		ActionListener jewelryListener = new JewelryButtonSelector();
		jewelryCheckBox.addActionListener((jewelryListener));
		
		//jewelryLabel set up
		jewelryLabel = new JLabel("Jewelry");
		jewelryLabel.setBounds(10,80,75,20);
		main.add(jewelryLabel);
		
		
		//set up for jewelryCombo
		//numberOfItems array already declared in clothesCombo
		jewelryCombo = new JComboBox(numberOfItems);
		jewelryCombo.setBounds(110,80,50,20);
		jewelryCombo.setBorder(loweredbevel);
		jewelryCombo.setToolTipText("How Many");
		jewelryCombo.setEnabled(false);
		main.add(jewelryCombo);
		
		//Add action listener to combo box
		jewelryCombo.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent event) 
				{
					Object jewelryContents = jewelryCombo.getSelectedItem();
					System.out.println(jewelryContents + " Jewelry selected");
				}
			});
		
		
		
		
		
		
		
		
		
		
//+++++++++++++++++ Toy Set up +++++++++++++++++++++++++++++++++++++++++++++++++
		
		// toy JCheckBox setup
		toyCheckBox = new JCheckBox();
		toyCheckBox.setBounds(70,110,20,20);
		toyCheckBox.setBorderPaintedFlat(false);
		toyCheckBox.setSelected(false);
		toyCheckBox.setToolTipText("Pet Toy");
		main.add(toyCheckBox);
		
		//adds action listeners to the jewelryCheckBox
		ActionListener toyListener = new ToyButtonSelector();
		toyCheckBox.addActionListener((toyListener));
		
		//jewelryLabel set up
		toyLabel = new JLabel("Toy");
		toyLabel.setBounds(30,110,75,20);
		main.add(toyLabel);
		
		
		//set up for toyCombo
		//numberOfItems array already declared in clothesCombo
		toyCombo = new JComboBox(numberOfItems);
		toyCombo.setBounds(110,110,50,20);
		toyCombo.setBorder(loweredbevel);
		toyCombo.setToolTipText("How Many");
		toyCombo.setEnabled(false);
		main.add(toyCombo);
		
		//Add action listener to combo box
		toyCombo.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent event) 
				{
					Object toyContents = toyCombo.getSelectedItem();
					System.out.println(toyContents + " toys selected");
				}
			});
		
		
		
		
//++++++++++++++++ dishes set up +++++++++++++++++++++++++++++++++++++++++++++++
		
		// toy JCheckBox setup
		dishesCheckBox = new JCheckBox();
		dishesCheckBox.setBounds(70,140,20,20);
		dishesCheckBox.setBorderPaintedFlat(false);
		dishesCheckBox.setSelected(false);
		dishesCheckBox.setToolTipText("Pet Toy");
		main.add(dishesCheckBox);
		
		//adds action listeners to the jewelryCheckBox
		ActionListener dishesListener = new DishesButtonSelector();
		dishesCheckBox.addActionListener((dishesListener));
		
		//dishesLabel set up
		dishesLabel = new JLabel("Dishes");
		dishesLabel.setBounds(30,140,75,20);
		main.add(dishesLabel);
		
		
		//set up for toyCombo
		//numberOfItems array already declared in clothesCombo
		dishesCombo = new JComboBox(numberOfItems);
		dishesCombo.setBounds(110,140,50,20);
		dishesCombo.setBorder(loweredbevel);
		dishesCombo.setToolTipText("How Many");
		dishesCombo.setEnabled(false);
		main.add(dishesCombo);
		
		//Add action listener to combo box
		dishesCombo.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent event) 
				{
					Object dishesContents = dishesCombo.getSelectedItem();
					System.out.println(dishesContents + " dishes selected");
				}
			});
		
		
		
		
		
//++++++++++++ treats Set up +++++++++++++++++++++++++++++++++++++++++++++++++++
		
		// treatsCheckBox setup
		treatsCheckBox = new JCheckBox();
		treatsCheckBox.setBounds(70,170,20,20);
		treatsCheckBox.setBorderPaintedFlat(false);
		treatsCheckBox.setSelected(false);
		treatsCheckBox.setToolTipText("Pet Treats");
		main.add(treatsCheckBox);
		
		//adds action listeners to the treatsCheckBox
		ActionListener treatsListener = new TreatsButtonSelector();
		treatsCheckBox.addActionListener((treatsListener));
		
		//treatsLabel set up
		treatsLabel = new JLabel("Treats");
		treatsLabel.setBounds(30,170,75,20);
		main.add(treatsLabel);
		
		
		//set up for treatCombo
		//numberOfItems array already declared in clothesCombo
		treatsCombo = new JComboBox(numberOfItems);
		treatsCombo.setBounds(110,170,50,20);
		treatsCombo.setBorder(loweredbevel);
		treatsCombo.setToolTipText("How Many");
		treatsCombo.setEnabled(false);
		main.add(treatsCombo);
		
		//Add action listener to combo box
		treatsCombo.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent event) 
				{
					Object treatsContents = treatsCombo.getSelectedItem();
					System.out.println(treatsContents + " treats selected");
				}
			});		




		
//++++++++++++ Bed Set up +++++++++++++++++++++++++++++++++++++++++++++++++++
		
		// bedCheckBox setup
		bedCheckBox = new JCheckBox();
		bedCheckBox.setBounds(70,200,20,20);
		bedCheckBox.setBorderPaintedFlat(false);
		bedCheckBox.setSelected(false);
		bedCheckBox.setToolTipText("Pet Beds");
		main.add(bedCheckBox);
		
		//adds action listeners to the bedCheckBox
		ActionListener bedListener = new BedButtonSelector();
		bedCheckBox.addActionListener((bedListener));
		
		//bedLabel set up
		bedLabel = new JLabel("Bed");
		bedLabel.setBounds(30,200,75,20);
		main.add(bedLabel);
		
		
		//set up for bedCombo
		//numberOfItems array already declared in clothesCombo
		bedCombo = new JComboBox(numberOfItems);
		bedCombo.setBounds(110,200,50,20);
		bedCombo.setBorder(loweredbevel);
		bedCombo.setToolTipText("How Many");
		bedCombo.setEnabled(false);
		main.add(bedCombo);
		
		//Add action listener to combo box
		bedCombo.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent event) 
				{
					Object bedContents = bedCombo.getSelectedItem();
					System.out.println( bedContents + " beds selected");
				}
			});		

		
		
		
		
		
//++++++++++++++++ Other set up ++++++++++++++++++++++++++++++++++++++++++++++++

		// otherCheckBox setup
		otherCheckBox = new JCheckBox();
		otherCheckBox.setBounds(70,230,20,20);
		otherCheckBox.setBorderPaintedFlat(false);
		otherCheckBox.setSelected(false);
		otherCheckBox.setToolTipText("Unlisted Items");
		main.add(otherCheckBox);
		
		//adds action listeners to the otherCheckBox
		ActionListener otherListener = new OtherButtonSelector();
		otherCheckBox.addActionListener((otherListener));
		
		//otherLabel set up
		otherLabel = new JLabel("Other");
		otherLabel.setBounds(30,230,75,20);
		main.add(otherLabel);
		
		
		//set up for otherCombo
		//numberOfItems array already declared in clothesCombo
		otherCombo = new JComboBox(numberOfItems);
		otherCombo.setBounds(110,230,50,20);
		otherCombo.setBorder(loweredbevel);
		otherCombo.setToolTipText("How Many");
		otherCombo.setEnabled(false);
		main.add(otherCombo);
		
		//Add action listener to combo box
		otherCombo.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent event) 
				{
					Object otherContents = otherCombo.getSelectedItem();
					System.out.println( otherContents + " other items selected");
				}
			});		






		
//++++++++++ submit button setUp +++++++++++++++++++++++++++++++++++++++++++++++
		
		submitButton = new JButton("Submit");
		submitButton.setBounds(360,230,80,40);
		submitButton.setToolTipText("Write to file");
		main.add(submitButton);
		
		//adds action listener to the submitButton
		ActionListener submitListener = new SubmitButtonSelector();
		submitButton.addActionListener((submitListener));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * The following code sets up both the size of the window
		 * and centers the window on the screen. The Toolkit class
		 * is the abstract superclass of all actual implementations 
		 * of the Abstract Window Toolkit.  The getScreenSize( ) method
		 * gets the size of the screen. On systems with multiple 
		 * displays, the primary display is used.
		 */
		
		int width = 500;
		int height = 350;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width-width)/2;
		int y = (screen.height-height)/2;
		setBounds(x,y,width,height);
		setResizable(false);
		
		setTitle("  Petcetera Purchase Log ");
		setSize(width, height);
		setVisible(true);
	}//end class createUserInterface
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Sets up the menu bar with File and Edit menus.
	 */
	
	public JMenuBar createMenuBar ()
	{
		MenuListener menuListener = new MenuListener ();
		
		JMenu fileMenu = new JMenu ("File");
		
		aboutMenuItem = new JMenuItem ("About...");
		aboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, 
			ActionEvent.CTRL_MASK));
		aboutMenuItem.addActionListener (menuListener);
		
		viewLogMenuItem = new JMenuItem("View Log");
		viewLogMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
			ActionEvent.CTRL_MASK));
		viewLogMenuItem.addActionListener (menuListener);
		
		exitMenuItem = new JMenuItem ("Exit");
		exitMenuItem.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_Q, 
			ActionEvent.CTRL_MASK));
		exitMenuItem.addActionListener (menuListener);
		
		
		fileMenu.addSeparator ();
		fileMenu.add (aboutMenuItem);
		fileMenu.addSeparator ();
		fileMenu.add (viewLogMenuItem);
		fileMenu.addSeparator ();
		fileMenu.add (exitMenuItem);
		
		JMenuBar bar = new JMenuBar ();
		bar.add (fileMenu);
		return bar;
	}
	
	
	
	
	
	
	
	/**
	 * An inner class to handle window events.
	 */
	public class WindowCloser extends WindowAdapter
	{
		//--------------------------------------------------------------
		//  Terminates the program when the window is closed.
		//--------------------------------------------------------------
		public void windowClosing (WindowEvent event)
		{
			exitMenuItem.doClick ();
		}
	}
	
	
	
	
	
	
	
	
	
	public class MenuListener implements ActionListener
	{
		//--------------------------------------------------------------
		//  Handles action events caused by menu selections.
		//--------------------------------------------------------------
		public void actionPerformed (ActionEvent event)
		{
			JFileChooser fileChooser = new JFileChooser ();
			String currentSaveName;
			if (event.getActionCommand ().equals ("Exit"))
				System.exit (0);
			
			else if (event.getActionCommand ().equals ("About..."))
			{
				JOptionPane.showMessageDialog (null,
					"Petcetera Purchase Log Program\n" +
					"Author: Christian Bazoian\n" + 
					"Version 1.1.0.0");
			}
			
			else if (event.getActionCommand().equals ("View Log"))
			{
				Runtime load = Runtime.getRuntime(); // get reference of current RunTime object
				
				try
				{
					load.exec("notepad Purchases.txt"); // exec method used to execute commands - can also launch other applications like "calc" will open the calculator
				}
				
				catch (IOException e)
				{
					System.out.println(e);
				}
			
				
			}
		}
	}		
	
	
	
	
	
	//======= Action Listeners ==============================================
	
	//Cash and credit radio button listener
	public class RadioButtonSelector implements ActionListener 
	{
		public void actionPerformed(ActionEvent event)
		{
			String choice = radioButtonGroup.getSelection().getActionCommand();
			System.out.println("Radio button selected " + choice );
		}
	}
	public class RadioButtonListener implements ItemListener
	{
		public void itemStateChanged(ItemEvent ev)
		{
			boolean selected = (ev.getStateChange() == ItemEvent.SELECTED);
			AbstractButton button = (AbstractButton)ev.getItemSelectable();
		}
	}
	
	
	
	
	
	//clothesCheckBox Action Listener
	public class ClothesButtonSelector implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			
			System.out.println("Clothes Check Box Selected" );
						
			//enable or disable number of items combo box
			if(clothesCombo.isEnabled() == false)
			{
				clothesCombo.setEnabled(true);
			}
			
			else
			{
				clothesCombo.setEnabled(false);
			}
		}
	}
	
	
	
	
	//jewelryCheckBox Action Listener
	public class JewelryButtonSelector implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			
			System.out.println("Jewelry Check Box Selected" );
			//textArea.append("\n" + "A Dinosaur that has " + choice);
			
			//enable or disable number of items combo box
			if(jewelryCombo.isEnabled() == false)
			{
				jewelryCombo.setEnabled(true);
			}
			
			else
			{
				jewelryCombo.setEnabled(false);
			}
		}
	}
	
	
	
	
	//toyCheckBox Action Listener
	public class ToyButtonSelector implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			
			System.out.println("Toy Check Box Selected" );
			
			//enable or disable number of items combo box
			if(toyCombo.isEnabled() == false)
			{
				toyCombo.setEnabled(true);
			}
			
			else
			{
				toyCombo.setEnabled(false);
			}
		}
	}
	
	
	//dishesCheckBox Action Listener
	public class DishesButtonSelector implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			
			System.out.println("Dishes Check Box Selected" );

			//enable or disable number of items combo box
			if(dishesCombo.isEnabled() == false)
			{
				dishesCombo.setEnabled(true);
			}
			
			else
			{
				dishesCombo.setEnabled(false);
			}
		}
	}
	
	
	
	
	//treatsCheckBox Action Listener
	public class TreatsButtonSelector implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			
			System.out.println("Treats Check Box Selected" );

			//enable or disable number of items combo box
			if(treatsCombo.isEnabled() == false)
			{
				treatsCombo.setEnabled(true);
			}
			
			else
			{
				treatsCombo.setEnabled(false);
			}
		}
	}
	
	
	
	//bedCheckBox Action Listener
	public class BedButtonSelector implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			
			System.out.println("Bed Check Box Selected" );

			//enable or disable number of items combo box
			if(bedCombo.isEnabled() == false)
			{
				bedCombo.setEnabled(true);
			}
			
			else
			{
				bedCombo.setEnabled(false);
			}
		}
	}	
	
	

	
	//otherCheckBox Action Listener
	public class OtherButtonSelector implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			
			System.out.println("Other Check Box Selected" );

			//enable or disable number of items combo box
			if(otherCombo.isEnabled() == false)
			{
				otherCombo.setEnabled(true);
			}
			
			else
			{
				otherCombo.setEnabled(false);
			}
		}
	}	
	
	
	
	
	
	
	
	
	
	//submit button  Action Listener
	public class SubmitButtonSelector implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				// Create a file
				FileWriter fstream = new FileWriter("Purchases.txt", true);  // true keeps from overwriting
				BufferedWriter out = new BufferedWriter(fstream);
				

				
				
				// get Current date
				Calendar currentDate = Calendar.getInstance();
				//SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
				SimpleDateFormat formatter = new SimpleDateFormat("MMM/dd/yyyy hh:mm");
				String dateNow = formatter.format(currentDate.getTime());
				
				//print date on output file
				out.write(dateNow);
				out.newLine();
				
				
				// says submit button was pressed
				System.out.println("Submit button pressed" );
				
				
				// get number of selected content
				String numClothes = (String)clothesCombo.getSelectedItem();
				String numJewelry = (String)jewelryCombo.getSelectedItem();
				String numToys = (String)toyCombo.getSelectedItem();
				String numDishes = (String)dishesCombo.getSelectedItem();
				String numTreats = (String)treatsCombo.getSelectedItem();
				String numBeds = (String)bedCombo.getSelectedItem();
				String numOther = (String)otherCombo.getSelectedItem();
				
				
				// if the combo boxes are enabled, then print the number of the 
				// selected item that was purchased
				if(clothesCombo.isEnabled() == true)
				{
					System.out.println( numClothes + " clothes purchased.\n");
					out.append( numClothes + " clothes purchased.");
					out.newLine();
					
				}
				
				if(jewelryCombo.isEnabled() == true)
				{
					System.out.println( numJewelry + " jewelry purchased.\n");
					out.append( numJewelry + " jewelry purchased.");
					out.newLine();
				}
				
				if(toyCombo.isEnabled() == true)
				{
					System.out.println( numToys + " toys purchased.\n");
					out.append( numToys + " toys purchased.");
					out.newLine();
				}
				
				if(dishesCombo.isEnabled() == true)
				{
					System.out.println( numDishes + " dishes purchased.\n");
					out.append( numDishes + " dishes purchased.\n");
					out.newLine();
				}
				
				if(treatsCombo.isEnabled() == true)
				{
					System.out.println( numTreats + " treats purchased.\n");
					out.append (numTreats + " treats purchased\n");
					out.newLine();
				}
				
				if(bedCombo.isEnabled() == true)
				{
					System.out.println( numBeds + " beds purchased.\n");
					out.append ( numBeds + " beds purchased");
					out.newLine();
				}
				
				if(otherCombo.isEnabled() == true)
				{
					System.out.println( numOther + " other items purchased.\n");
					out.append( numOther + " other items purchased");
					out.newLine();
				}
				
				
				
				
				
				//Get whether payment was cash or credit from radio buttons
				String choice = radioButtonGroup.getSelection().getActionCommand();
				out.append("Payment Type: " + choice);
				out.newLine();
				
				//Get totalPriceTextField contents
				out.write("Total: " + totalPriceTextField.getText());
				out.newLine();
				
				// get text area contents
				System.out.println(noteTextArea.getText());
				out.write(noteTextArea.getText());
				out.newLine();
				out.newLine(); // two newLines since its the end end of the entry 
				out.newLine();
				out.newLine();
				
				
				
				
				//Close output stream
				out.close();
				
			}// end of try statement
			
			
			
			//Catch exception if any from file writing
			catch (Exception e)
			{
				System.err.println("Error: " + e.getMessage());
			}
			
			
			
			
			
			//+++++++++++ clear all settings of previous purchase ++++++++++++++++++++++++++
			//clear textARea
			noteTextArea.setText("Notes from purchase: ");
			
			//clear textField
			totalPriceTextField.setText("$");
			
			//deselect all check boxes
			clothesCheckBox.setSelected(false);
			jewelryCheckBox.setSelected(false);
			toyCheckBox.setSelected(false);
			dishesCheckBox.setSelected(false);
			treatsCheckBox.setSelected(false);
			bedCheckBox.setSelected(false);
			otherCheckBox.setSelected(false);
			
			
			
			//set combo boxes to default values
			clothesCombo.setSelectedItem("1");
			jewelryCombo.setSelectedItem("1");
			toyCombo.setSelectedItem("1");
			dishesCombo.setSelectedItem("1");
			treatsCombo.setSelectedItem("1");
			bedCombo.setSelectedItem("1");
			otherCombo.setSelectedItem("1");
			
			
			//disable combo boxes
			clothesCombo.setEnabled(false);
			jewelryCombo.setEnabled(false);
			toyCombo.setEnabled(false);
			dishesCombo.setEnabled(false);
			treatsCombo.setEnabled(false);
			bedCombo.setEnabled(false);
			otherCombo.setEnabled(false);
			
			//disable radio buttons
			cashRadioButton.setSelected(false);
			creditRadioButton.setSelected(false);
			
			
		}// end of class		
	}//end action listener
	
	
	
	
	
	
	
	
	
	
	
	public static void main (String args[])
	{
		PetceteraProgram application = new PetceteraProgram();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}