/*
 * $HeadURL: https://svn.iizuka.co.uk/common/binding/swing/tags/1.0.0-beta-1/src/test/java/uk/co/iizuka/common/binding/swing/JTextComponentTextObservableTest.java $
 * 
 * (c) 2011 IIZUKA Software Technologies Ltd.  All rights reserved.
 */
package uk.co.iizuka.common.binding.swing;

import static org.junit.Assert.assertEquals;
import static uk.co.iizuka.common.binding.swing.test.TestObservableListeners.mockObservableListenerWithValueChanged;

import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import org.hobsoft.entangle.ObservableEvent;
import org.hobsoft.entangle.ObservableListener;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Tests {@code JTextComponentTextObservable}.
 * 
 * @author Mark Hobson
 * @version $Id: JTextComponentTextObservableTest.java 97730 2012-01-11 16:19:13Z mark@IIZUKA.CO.UK $
 * @see JTextComponentTextObservable
 */
@RunWith(JMock.class)
public class JTextComponentTextObservableTest
{
	// fields -----------------------------------------------------------------
	
	private final Mockery mockery = new JUnit4Mockery();
	
	private JTextComponent component;
	
	private JTextComponentTextObservable observable;

	// public methods ---------------------------------------------------------

	@Before
	public void setUp()
	{
		component = new JTextField();
		observable = new JTextComponentTextObservable(component);
	}

	// tests ------------------------------------------------------------------

	@Test
	public void getValue()
	{
		component.setText("x");
		
		assertEquals("x", observable.getValue());
	}
	
	@Test
	public void setValue()
	{
		observable.setValue("x");
		
		assertEquals("x", component.getText());
	}
	
	@Test
	public void setValueFiresEventWhenPropertyChanged()
	{
		observable.addObservableListener(mockObservableListenerWithValueChanged(mockery, observable, null, "x"));
		
		observable.setValue("x");
	}
	
	@Test
	public void setValueDoesNotSetTextWhenWithinNotification()
	{
		observable.addObservableListener(new ObservableListener<String>()
		{
			public void valueChanged(ObservableEvent<String> event)
			{
				observable.setValue("y");
			}
		});
		
		observable.setValue("x");
		
		assertEquals("x", observable.getValue());
	}
}
