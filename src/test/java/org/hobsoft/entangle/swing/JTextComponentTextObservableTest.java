/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hobsoft.entangle.swing;

import static org.hobsoft.entangle.swing.test.TestObservableListeners.mockObservableListenerWithValueChanged;
import static org.junit.Assert.assertEquals;

import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import org.hobsoft.entangle.ObservableEvent;
import org.hobsoft.entangle.ObservableListener;
import org.hobsoft.entangle.swing.JTextComponentTextObservable;
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
