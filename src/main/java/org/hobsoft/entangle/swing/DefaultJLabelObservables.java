/*
 * $HeadURL: https://svn.iizuka.co.uk/common/binding/swing/tags/1.0.0-beta-1/src/main/java/uk/co/iizuka/common/binding/swing/DefaultJLabelObservables.java $
 * 
 * (c) 2012 IIZUKA Software Technologies Ltd.  All rights reserved.
 */
package org.hobsoft.entangle.swing;

import javax.swing.JLabel;

import org.hobsoft.entangle.Observable;
import org.hobsoft.entangle.Observables;
import org.hobsoft.entangle.swing.SwingObservables.JLabelObservables;


/**
 * Default {@code JLabelObservables} implementation.
 * 
 * @author Mark Hobson
 * @version $Id: DefaultJLabelObservables.java 97624 2012-01-06 11:05:06Z mark@IIZUKA.CO.UK $
 * @see JLabelObservables
 */
class DefaultJLabelObservables extends DefaultJComponentObservables implements JLabelObservables
{
	// constructors -----------------------------------------------------------
	
	public DefaultJLabelObservables(JLabel label)
	{
		super(label);
	}
	
	// JLabelObservables methods ----------------------------------------------
	
	/**
	 * {@inheritDoc}
	 */
	public Observable<String> text()
	{
		return Observables.bean(getComponent()).string("text");
	}
}
