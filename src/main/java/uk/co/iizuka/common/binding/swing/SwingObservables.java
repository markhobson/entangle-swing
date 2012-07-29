/*
 * $HeadURL: https://svn.iizuka.co.uk/common/binding/swing/tags/1.0.0-beta-1/src/main/java/uk/co/iizuka/common/binding/swing/SwingObservables.java $
 * 
 * (c) 2011 IIZUKA Software Technologies Ltd.  All rights reserved.
 */
package uk.co.iizuka.common.binding.swing;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;

import uk.co.iizuka.common.binding.Observable;

/**
 * 
 * 
 * @author Mark Hobson
 * @version $Id: SwingObservables.java 97641 2012-01-06 18:23:27Z mark@IIZUKA.CO.UK $
 */
public final class SwingObservables
{
	// types ------------------------------------------------------------------
	
	/**
	 * Observable properties for {@code JComponent}.
	 * 
	 * @see javax.swing.JComponent
	 */
	public interface JComponentObservables
	{
		// TODO: inheritsPopupMenu
		// TODO: componentPopupMenu
		// TODO: UI
		// TODO: UIClassId
		// TODO: verifyInputWhenFocusTarget
		// TODO: preferredSize
		// TODO: maximumSize
		// TODO: minimumSize
		
		Observable<Border> border();
		
		// TODO: insets
		// TODO: alignmentY
		// TODO: alignmentX
		// TODO: inputVerifier
		// TODO: debugGraphicsOptions
		// TODO: visible
		
		Observable<Boolean> enabled();
		
		Observable<Color> foreground();
		
		Observable<Color> background();
		
		// TODO: font
		// TODO: toolTipText
		// TODO: autoscrolls
		// TODO: transferHandler
		// TODO: focusTraversalKeys
		// TODO: opaque
	}

	/**
	 * Observable properties for {@code JLabel}.
	 *
	 * @see JLabel
	 */
	public interface JLabelObservables extends JComponentObservables
	{
		// TODO: UI
		
		Observable<String> text();
		
		// TODO: icon
		// TODO: disabledIcon
		// TODO: displayedMnemonic
		// TODO: iconTextGap
		// TODO: verticalAlignment
		// TODO: horizontalAlignment
		// TODO: verticalTextPosition
		// TODO: horizontalTextPosition
		// TODO: labelFor
		// TODO: accessibleContext
	}
	
	/**
	 * Observable properties for {@code JTextComponent}.
	 *
	 * @see javax.swing.text.JTextComponent
	 */
	public interface JTextComponentObservables extends JComponentObservables
	{
		// TODO: document
		// TODO: margin
		// TODO: caret
		// TODO: highlighter
		// TODO: keymap
		// TODO: dragEnabled
		// TODO: caretColor
		// TODO: selectionColor
		// TODO: selectedTextColor
		// TODO: disabledTextColor
		// TODO: focusAccelerator
		// TODO: caretPosition
		
		Observable<String> text();
		
		// TODO: editable
		// TODO: selectionStart
		// TODO: selectionEnd
	}
	
	// constructors -----------------------------------------------------------
	
	private SwingObservables()
	{
		throw new AssertionError();
	}
	
	// public methods ---------------------------------------------------------
	
	public static JComponentObservables component(JComponent component)
	{
		return new DefaultJComponentObservables(component);
	}
	
	// TODO: AbstractButton
	// TODO: JButton
	// TODO: JMenuItem
	// TODO: JCheckBoxMenuItem
	// TODO: JMenu
	// TODO: JRadioButtonMenuItem
	// TODO: JToggleButton
	// TODO: JCheckBox
	// TODO: JRadioButton
	// TODO: Box
	// TODO: Box.Filler
	// TODO: JColorChooser
	// TODO: JComboBox
	// TODO: JFileChooser
	// TODO: JInternalFrame
	
	public static JLabelObservables component(JLabel label)
	{
		return new DefaultJLabelObservables(label);
	}
	
	// TODO: JLayeredPane
	// TODO: JDesktopPane
	// TODO: JList
	// TODO: JMenuBar
	// TODO: JOptionPane
	// TODO: JPanel
	// TODO: JPopupMenu
	// TODO: JProgressBar
	// TODO: JRootPane
	// TODO: JScrollBar
	// TODO: JScrollPane
	// TODO: JSeparator
	// TODO: JSlider
	// TODO: JSpinner
	// TODO: JSplitPane
	// TODO: JTabbedPane
	// TODO: JTable
	// TODO: JTableHeader
	
	public static JTextComponentObservables component(JTextComponent textComponent)
	{
		return new DefaultJTextComponentObservables(textComponent);
	}

	// TODO: JEditorPane
	// TODO: JTextPane
	// TODO: JTextArea
	// TODO: JTextField
	// TODO: JToolBar
	// TODO: JToolTip
	// TODO: JTree
	// TODO: JViewport
}
