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

import javax.swing.JLabel;

import org.hobsoft.entangle.swing.DefaultJLabelObservables;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests {@code DefaultJLabelObservables}.
 * 
 * @author Mark Hobson
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
