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

import javax.swing.text.JTextComponent;

import org.hobsoft.entangle.Observable;
import org.hobsoft.entangle.swing.SwingObservables.JTextComponentObservables;

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
