/*
 * $HeadURL: https://svn.iizuka.co.uk/common/binding/swing/tags/1.0.0-beta-1/src/test/java/uk/co/iizuka/common/binding/swing/DefaultJLabelObservablesTest.java $
 * 
 * (c) 2012 IIZUKA Software Technologies Ltd.  All rights reserved.
 */
package uk.co.iizuka.common.binding.swing;

import static org.junit.Assert.assertEquals;

import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests {@code DefaultJLabelObservables}.
 * 
 * @author Mark Hobson
 * @version $Id: DefaultJLabelObservablesTest.java 97628 2012-01-06 13:42:08Z mark@IIZUKA.CO.UK $
 * @see DefaultJLabelObservables
 */
public class DefaultJLabelObservablesTest
{
	// fields -----------------------------------------------------------------
	
	private JLabel label;
	
	private DefaultJLabelObservables observables;
	
	// public methods ---------------------------------------------------------
	
	@Before
	public void setUp()
	{
		label = new JLabel();
		observables = new DefaultJLabelObservables(label);
	}

	// tests ------------------------------------------------------------------
	
	@Test
	public void textSetValue()
	{
		observables.text().setValue("x");
		
		assertEquals("x", label.getText());
	}
}
