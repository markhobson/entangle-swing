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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.Border;

import org.hobsoft.entangle.swing.DefaultJComponentObservables;
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
