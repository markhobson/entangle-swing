/*
 * $HeadURL: https://svn.iizuka.co.uk/common/binding/swing/tags/1.0.0-beta-1/src/main/java/uk/co/iizuka/common/binding/swing/DefaultJComponentObservables.java $
 * 
 * (c) 2012 IIZUKA Software Technologies Ltd.  All rights reserved.
 */
package org.hobsoft.entangle.swing;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.border.Border;

import org.hobsoft.entangle.Observable;
import org.hobsoft.entangle.Observables;
import org.hobsoft.entangle.swing.SwingObservables.JComponentObservables;

/**
 * Default {@code JComponentObservables} implementation.
 * 
 * @author Mark Hobson
 * @version $Id: DefaultJComponentObservables.java 97639 2012-01-06 17:54:52Z mark@IIZUKA.CO.UK $
 * @see JComponentObservables
 */
class DefaultJComponentObservables implements JComponentObservables
{
	// fields -----------------------------------------------------------------
	
	private final JComponent component;
	
	// constructors -----------------------------------------------------------
	
	public DefaultJComponentObservables(JComponent component)
	{
		this.component = component;
	}
	
	// JComponentObservables methods ------------------------------------------
	
	/**
	 * {@inheritDoc}
	 */
	public Observable<Border> border()
	{
		return Observables.bean(component).property("border", Border.class);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Observable<Boolean> enabled()
	{
		return Observables.bean(component).property("enabled", boolean.class);
	}

	/**
	 * {@inheritDoc}
	 */
	public Observable<Color> foreground()
	{
		return Observables.bean(component).property("foreground", Color.class);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Observable<Color> background()
	{
		return Observables.bean(component).property("background", Color.class);
	}

	// public methods ---------------------------------------------------------
	
	public JComponent getComponent()
	{
		return component;
	}
}
