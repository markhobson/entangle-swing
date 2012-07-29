/*
 * $HeadURL: https://svn.iizuka.co.uk/common/binding/swing/tags/1.0.0-beta-1/src/test/java/uk/co/iizuka/common/binding/swing/DefaultJComponentObservablesTest.java $
 * 
 * (c) 2012 IIZUKA Software Technologies Ltd.  All rights reserved.
 */
package uk.co.iizuka.common.binding.swing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.Border;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests {@code DefaultJComponentObservables}.
 * 
 * @author Mark Hobson
 * @version $Id: DefaultJComponentObservablesTest.java 97639 2012-01-06 17:54:52Z mark@IIZUKA.CO.UK $
 * @see DefaultJComponentObservables
 */
public class DefaultJComponentObservablesTest
{
	// fields -----------------------------------------------------------------
	
	private JComponent component;
	
	private DefaultJComponentObservables observables;
	
	// public methods ---------------------------------------------------------
	
	@Before
	public void setUp()
	{
		component = new FakeJComponent();
		observables = new DefaultJComponentObservables(component);
	}

	// tests ------------------------------------------------------------------
	
	@Test
	public void borderSetValue()
	{
		Border border = BorderFactory.createEmptyBorder();
		
		observables.border().setValue(border);
		
		assertEquals(border, component.getBorder());
	}
	
	@Test
	public void enabledSetValue()
	{
		observables.enabled().setValue(false);
		
		assertFalse(component.isEnabled());
	}
	
	@Test
	public void foregroundSetValue()
	{
		observables.foreground().setValue(Color.RED);
		
		assertEquals(Color.RED, component.getForeground());
	}
	
	@Test
	public void backgroundSetValue()
	{
		observables.background().setValue(Color.RED);
		
		assertEquals(Color.RED, component.getBackground());
	}
}
