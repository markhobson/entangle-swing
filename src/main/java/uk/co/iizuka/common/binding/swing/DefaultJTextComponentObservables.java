/*
 * $HeadURL: https://svn.iizuka.co.uk/common/binding/swing/tags/1.0.0-beta-1/src/main/java/uk/co/iizuka/common/binding/swing/DefaultJTextComponentObservables.java $
 * 
 * (c) 2012 IIZUKA Software Technologies Ltd.  All rights reserved.
 */
package uk.co.iizuka.common.binding.swing;

import javax.swing.text.JTextComponent;

import org.hobsoft.entangle.Observable;

import uk.co.iizuka.common.binding.swing.SwingObservables.JTextComponentObservables;

/**
 * Default {@code JTextComponentObservables} implementation.
 * 
 * @author Mark Hobson
 * @version $Id: DefaultJTextComponentObservables.java 97624 2012-01-06 11:05:06Z mark@IIZUKA.CO.UK $
 * @see JTextComponentObservables
 */
class DefaultJTextComponentObservables extends DefaultJComponentObservables implements JTextComponentObservables
{
	// constructors -----------------------------------------------------------
	
	public DefaultJTextComponentObservables(JTextComponent textComponent)
	{
		super(textComponent);
	}
	
	// JTextComponentObservables methods --------------------------------------
	
	/**
	 * {@inheritDoc}
	 */
	public Observable<String> text()
	{
		return new JTextComponentTextObservable(getComponent());
	}
	
	// DefaultJComponentObservables methods -----------------------------------
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public JTextComponent getComponent()
	{
		return (JTextComponent) super.getComponent();
	}
}
