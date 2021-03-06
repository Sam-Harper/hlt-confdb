package confdb.gui;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;


    
/**
 * AboutDialog
 * -----------
 * @author Philipp Schieferdecker
 *
 * Display information about the application.
 */
public class AboutDialog extends JDialog
{
    //
    // member data
    //

    /** GUI components */
    JEditorPane jEditorPaneAbout      		= new JEditorPane();
    JButton     jButtonOk             		= new JButton();
    JTextField  jTextFieldApplication 		= new JTextField();
    
    /* NOTE: to change the GUI version go to: /conf/confdb.version file .*/
    static JTextField  jTextFieldVersion	= new JTextField(); // ConfDb Version.
    static String		contactEmail		= ""; // Change in confdb.version file!
    
    
    //
    // construction
    //
    
    /** standard constructor */
    public AboutDialog(JFrame frame)
    {
	super(frame,true);
	
	getConfDbVersion(); //load info from confdb.version file
	getContactPerson(); //load info from confdb.version file
	
	setTitle("About ConfDbGUI");
	
	setContentPane(initComponents());
	
	String txt =
	    "<p>Thank you for using <b>ConfDbGUI</b>," +
	    "a CMS tool to create and manage " +
	    "CMSSW job configurations based on a " +
	    "relational database.</p>" +
	    
	    "This software was originally developed " +
	    "by Philipp Schieferdecker and is currently " +
	    "maintained by Raul Jimenez Estupinan " +
	    "with contributions from Ulf Behrens, " +
	    "Jonathan Hollar, Vasundhara Chetluru " +
	    "and Martin Gruenewald. " +
	    "<p>For feedback please contact me at " +
	    "<b>"+ contactEmail +"</b>.</p>" +
	    
	    
	    "<p>Find documentation on the web under " +
	    "<b>https://twiki.cern.ch/twiki/bin/view/CMS/EvfConfDBGUI</b>.</p>";

	jTextFieldApplication.setText("ConfDbGUI");
	// jTextFieldVersion.setText("V01-05-82"); // Change in confdb.version file!

	jEditorPaneAbout.setContentType("text/html");
	jEditorPaneAbout.setText(txt);
	

	
    }

    
    
    //
    // member functions
    //

    /**
     * getConfDbVersion
     * -------------------------------
     * return ConfDb current version String.
     * Allow get confdb version in case of errors.
     * NOTE: to change the GUI version go to: /conf/confdb.version file .*/
    public String getConfDbVersion() {
		
    	ConfdbSoftwareVersion softversion = new ConfdbSoftwareVersion();
    	softversion.loadLocalProperties();
		
		jTextFieldVersion.setText(softversion.getClientVersion());
    	
    	return jTextFieldVersion.getText();
    }
    
    /**
     * getContactPerson
     * -------------------------------
     * return ConfDb current contact person.
     * Allow get confdb contact person in case of errors.
     * NOTE: to change the GUI version go to: /conf/confdb.version file .*/
    public String getContactPerson() {
    	
    	ConfdbSoftwareVersion softversion = new ConfdbSoftwareVersion();
    	softversion.loadLocalProperties();

		contactEmail = softversion.getContact();
    	
    	return contactEmail;
    }
    
    /** close the dialog window if 'OK' was pressed */
    public void jButtonOkActionPerformed(ActionEvent e) { setVisible(false); }
    
    
    //
    // private member functions
    //

    /** initialize GUI components */
    private JPanel initComponents()
    {
	JPanel      panel        = new JPanel();
        JScrollPane jScrollPane1 = new JScrollPane();
        JLabel      jLabel1      = new JLabel();
        JLabel      jLabel2      = new JLabel();
	
        jScrollPane1.setViewportView(jEditorPaneAbout);
	

	jButtonOk.addActionListener( new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
		    jButtonOkActionPerformed(e);
		}
	    });
	
        jButtonOk.setText("OK");	
        jLabel1.setText("Application:");
        jLabel2.setText("Version:");
	
	jTextFieldApplication.setBackground(new Color(255, 255, 255));
        jTextFieldApplication.setEditable(false);
        jTextFieldApplication.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.RAISED));

        jTextFieldVersion.setBackground(new Color(255, 255, 255));
        jTextFieldVersion.setEditable(false);
        jTextFieldVersion.setBorder(BorderFactory
				    .createBevelBorder(BevelBorder.RAISED));

	jEditorPaneAbout.setEditable(false);
        
	javax.swing.GroupLayout layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(layout);
        layout
	    .setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
				     .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					  .addGroup(layout.createSequentialGroup()
					       .addContainerGap()
					       .addGroup(layout
						    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						    .addComponent(jScrollPane1,
							 javax.swing.GroupLayout.DEFAULT_SIZE,
							 289, Short.MAX_VALUE)
						    .addGroup(layout
							 .createSequentialGroup()
							 .addGroup(layout
							      .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							      .addComponent(jTextFieldApplication,
								   javax.swing.GroupLayout
								   .PREFERRED_SIZE,
								   145,
								   javax.swing.GroupLayout
								   .PREFERRED_SIZE)
							      .addComponent(jLabel1))
							 .addGap(4)
							 .addGroup(layout
							      .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							      .addComponent(jLabel2)
							      .addComponent(jTextFieldVersion,
								   javax.swing.GroupLayout
								   .DEFAULT_SIZE,
								   140,
								   Short
								   .MAX_VALUE)))))
					  .addGroup(layout.createSequentialGroup()
					       .addGap(106)
					       .addComponent(jButtonOk,
						    javax.swing.GroupLayout.DEFAULT_SIZE,
						    101, Short.MAX_VALUE)
					       .addGap(94)))
				       .addContainerGap())
				);
        layout
	    .setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			      .addGroup(layout.createSequentialGroup()
				   .addContainerGap()
				   .addGroup(layout
					.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
					.addComponent(jLabel1)
					.addComponent(jLabel2))
				   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				   .addGroup(layout
					.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
					.addComponent(jTextFieldApplication,
					     javax.swing.GroupLayout.PREFERRED_SIZE,
					     javax.swing.GroupLayout.DEFAULT_SIZE,
					     javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(jTextFieldVersion,
					     javax.swing.GroupLayout.PREFERRED_SIZE,
					     javax.swing.GroupLayout.DEFAULT_SIZE,
					     javax.swing.GroupLayout.PREFERRED_SIZE))
				   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				   .addComponent(jScrollPane1,
					javax.swing.GroupLayout.DEFAULT_SIZE,
					300,
					Short.MAX_VALUE)
				   .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				   .addComponent(jButtonOk)
				   .addContainerGap())
			      );
	return panel;
    }
    
}
