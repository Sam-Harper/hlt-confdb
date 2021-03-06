package confdb.gui;

import java.util.Iterator;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import confdb.data.EventContent;
import confdb.data.Path;
import confdb.data.Reference;
import confdb.data.ModuleInstance;
import confdb.data.OutputCommand;

/**
 * OutputCommandEditorDialog
 * -------------------------
 * @author Philipp Schieferdecker
 *
 * Edit output commands (drop/keep statements) of format
 * <classname>_<modulename>_<extraname>_<processname>.
 */
public class OutputCommandEditorDialog extends JDialog {
	//
	// member data
	//

	/** reference to the event content */
	private EventContent content = null;

	/** output command to be created / edited */
	private OutputCommand command = null;

	/** GUI components */
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton jRadioButtonKeep = new JRadioButton();
	private JRadioButton jRadioButtonDrop = new JRadioButton();
	private JTextField jTextFieldEventContent = new JTextField();
	private JTextField jTextFieldPath = new JTextField();
	private JTextField jTextFieldClassName = new JTextField();
	private JComboBox jComboBoxModuleName = new JComboBox();
	private JTextField jTextFieldExtraName = new JTextField();
	private JTextField jTextFieldProcess = new JTextField();
	private JTextPane jTextPanePreview = new JTextPane();
	private JButton jButtonOK = new JButton();
	private JButton jButtonCancel = new JButton();

	//
	// construction
	//

	/** constructor from event content */
	public OutputCommandEditorDialog(JFrame jFrame, EventContent content) {
		super(jFrame, true);
		this.content = content;
		this.command = new OutputCommand();
		setContentPane(createContentPane());
		setTitle("Edit Output Command");
		initialize();
	}

	/** constructor from event content *and* path */
	public OutputCommandEditorDialog(JFrame jFrame, EventContent content, OutputCommand command) {
		super(jFrame, true);
		this.content = content;
		this.command = new OutputCommand();
		this.command.set(command);
		setContentPane(createContentPane());
		setTitle("Edit Output Command");
		initialize();
	}

	//
	// member functions
	//

	/** get the edited command */
	public OutputCommand command() {
		return command;
	}

	//
	// private member functions
	//

	/** update all fields according to content and command fields */
	private void initialize() {
		jTextFieldEventContent.setText(content.name());
		String pathName = new String();
		if (!command.isGlobal())
			pathName = command.parentPath().name();
		jTextFieldPath.setText(pathName);
		if (command.isDrop())
			jRadioButtonDrop.setSelected(true);
		else
			jRadioButtonKeep.setSelected(true);

		jTextFieldClassName.setText(command.className());
		jTextFieldExtraName.setText(command.extraName());
		jTextFieldProcess.setText(command.processName());

		DefaultComboBoxModel cbm = (DefaultComboBoxModel) jComboBoxModuleName.getModel();
		cbm.removeAllElements();

		if (!command.isGlobal()) {
			String selectedModuleName = command.moduleName();
			jComboBoxModuleName.setEditable(false);
			Iterator<ModuleInstance> itM = command.parentPath().moduleIterator();
			while (itM.hasNext()) {
				ModuleInstance module = itM.next();
				String moduleName = module.name();
				cbm.addElement(moduleName);
				if (moduleName.equals(selectedModuleName))
					cbm.setSelectedItem(moduleName);
			}
		} else {
			jComboBoxModuleName.setEditable(true);
			cbm.addElement(command.moduleName());
			cbm.setSelectedItem(cbm.getElementAt(0));
		}

		jTextPanePreview.setText(command.toString());
	}

	/** update preview after manipulation of fields */
	private void updatePreview() {
		jTextPanePreview.setText(command.toString());
	}

	private void jRadioButtonDropActionPerformed(ActionEvent evt) {
		if (jRadioButtonDrop.isSelected())
			command.setDrop();
		else
			command.setKeep();
		updatePreview();
	}

	private void jRadioButtonKeepActionPerformed(ActionEvent evt) {
		if (jRadioButtonDrop.isSelected())
			command.setDrop();
		else
			command.setKeep();
		updatePreview();
	}

	private void jButtonCancelActionPerformed(ActionEvent evt) {
		command = null;
		setVisible(false);
	}

	private void jComboBoxModuleNameActionPerformed(ActionEvent evt) {
		String moduleName = jComboBoxModuleName.getSelectedItem().toString();
		if (command.parentReference() == null) {
			command.setModuleName(moduleName);
		} else {
			boolean found = false;
			Iterator<Reference> itR = command.parentPath().recursiveReferenceIterator();
			while (itR.hasNext() && !found) {
				Reference reference = itR.next();
				if (reference.name().equals(moduleName)) {
					command.setModuleReference(reference);
					found = true;
				}
			}
		}
		updatePreview();
	}

	private void jButtonOKActionPerformed(ActionEvent evt) {
		setVisible(false);
	}

	private void jTextFieldClassNameInsertUpdate(DocumentEvent e) {
		command.setClassName(jTextFieldClassName.getText());
		updatePreview();
	}

	private void jTextFieldClassNameRemoveUpdate(DocumentEvent e) {
		command.setClassName(jTextFieldClassName.getText());
		updatePreview();
	}

	private void jComboBoxModuleNameInsertUpdate(DocumentEvent e) {
		command.setModuleName(jComboBoxModuleName.getEditor().getItem().toString());
		updatePreview();
	}

	private void jComboBoxModuleNameRemoveUpdate(DocumentEvent e) {

		command.setModuleName(jComboBoxModuleName.getEditor().getItem().toString());
		updatePreview();
	}

	private void jTextFieldExtraNameInsertUpdate(DocumentEvent e) {
		command.setExtraName(jTextFieldExtraName.getText());
		updatePreview();
	}

	private void jTextFieldExtraNameRemoveUpdate(DocumentEvent e) {
		command.setExtraName(jTextFieldExtraName.getText());
		updatePreview();
	}

	private void jTextFieldProcessInsertUpdate(DocumentEvent e) {
		command.setProcessName(jTextFieldProcess.getText());
		updatePreview();
	}

	private void jTextFieldProcessRemoveUpdate(DocumentEvent e) {
		command.setProcessName(jTextFieldProcess.getText());
		updatePreview();
	}

	/** create the graphical components */
	private JPanel createContentPane() {
		JPanel jPanel = new JPanel();

		JLabel jLabelEventContent = new JLabel();
		JLabel jLabelPath = new JLabel();
		JLabel jLabelClassName = new JLabel();
		JLabel jLabelModuleName = new JLabel();
		JLabel jLabelExtraName = new JLabel();
		JLabel jLabelProcess = new JLabel();
		JScrollPane jScrollPanePreview = new JScrollPane();

		buttonGroup.add(jRadioButtonKeep);
		buttonGroup.add(jRadioButtonDrop);

		jLabelEventContent.setText("EventContent:");

		jTextFieldEventContent.setEditable(false);

		jLabelPath.setText("Path:");

		jRadioButtonKeep.setText("keep");
		jRadioButtonKeep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jRadioButtonKeepActionPerformed(evt);
			}
		});

		jRadioButtonDrop.setText("drop");
		jRadioButtonDrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jRadioButtonDropActionPerformed(evt);
			}
		});

		jLabelClassName.setText("Class Name:");

		jLabelModuleName.setText("Module Name:");

		jLabelExtraName.setText("Extra Name:");

		jLabelProcess.setText("Process:");

		jTextFieldClassName.setText("*");

		jComboBoxModuleName.setEditable(true);
		jComboBoxModuleName.setModel(new DefaultComboBoxModel(new String[] {}));
		jComboBoxModuleName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jComboBoxModuleNameActionPerformed(evt);
			}
		});

		jTextFieldExtraName.setText("*");

		jTextFieldProcess.setText("*");

		jTextFieldPath.setEditable(false);
		jTextFieldPath.setText("jTextField2");

		jTextFieldClassName.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				jTextFieldClassNameInsertUpdate(e);
			}

			public void removeUpdate(DocumentEvent e) {
				jTextFieldClassNameRemoveUpdate(e);
			}

			public void changedUpdate(DocumentEvent e) {
			}
		});
		JTextComponent tc = (JTextComponent) jComboBoxModuleName.getEditor().getEditorComponent();
		tc.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				jComboBoxModuleNameInsertUpdate(e);
			}

			public void removeUpdate(DocumentEvent e) {
				jComboBoxModuleNameRemoveUpdate(e);
			}

			public void changedUpdate(DocumentEvent e) {
			}
		});
		jTextFieldExtraName.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				jTextFieldExtraNameInsertUpdate(e);
			}

			public void removeUpdate(DocumentEvent e) {
				jTextFieldExtraNameRemoveUpdate(e);
			}

			public void changedUpdate(DocumentEvent e) {
			}
		});
		jTextFieldProcess.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				jTextFieldProcessInsertUpdate(e);
			}

			public void removeUpdate(DocumentEvent e) {
				jTextFieldProcessRemoveUpdate(e);
			}

			public void changedUpdate(DocumentEvent e) {
			}
		});

		jScrollPanePreview.setBorder(javax.swing.BorderFactory.createTitledBorder("Preview"));

		jTextPanePreview.setEditable(false);
		jScrollPanePreview.setViewportView(jTextPanePreview);

		jButtonOK.setText("OK");
		jButtonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonOKActionPerformed(evt);
			}
		});

		jButtonCancel.setText("Cancel");
		jButtonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonCancelActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(jPanel);
		jPanel.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jScrollPanePreview, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jRadioButtonDrop).addComponent(jRadioButtonKeep))
										.addGap(34)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
														.addComponent(jTextFieldClassName,
																javax.swing.GroupLayout.DEFAULT_SIZE, 120,
																Short.MAX_VALUE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED))
												.addGroup(layout.createSequentialGroup().addComponent(jLabelClassName)
														.addGap(48)))
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabelModuleName).addComponent(jComboBoxModuleName,
														javax.swing.GroupLayout.Alignment.TRAILING, 0, 120,
														Short.MAX_VALUE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabelExtraName).addComponent(jTextFieldExtraName,
														javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup().addComponent(jLabelProcess)
														.addGap(68))
												.addComponent(jTextFieldProcess, javax.swing.GroupLayout.DEFAULT_SIZE,
														120, Short.MAX_VALUE)))
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										layout.createSequentialGroup().addComponent(jLabelEventContent)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jTextFieldEventContent,
														javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
												.addGap(30).addComponent(jLabelPath).addGap(3)
												.addComponent(jTextFieldPath, javax.swing.GroupLayout.DEFAULT_SIZE, 210,
														Short.MAX_VALUE)))
								.addContainerGap())
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addComponent(jButtonCancel)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButtonOK)))));

		layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] { jButtonCancel, jButtonOK });

		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabelEventContent)
								.addComponent(jTextFieldEventContent, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jTextFieldPath, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabelPath))
						.addGap(37)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabelExtraName).addComponent(jLabelProcess)
										.addComponent(jLabelModuleName))
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabelClassName).addComponent(jRadioButtonKeep)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jTextFieldClassName, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jRadioButtonDrop)
								.addComponent(jComboBoxModuleName, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jTextFieldExtraName, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jTextFieldProcess, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(37)
						.addComponent(jScrollPanePreview, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
						.addGap(11).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButtonOK).addComponent(jButtonCancel))));

		return jPanel;
	}

}
