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
