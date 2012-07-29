/*
 * $HeadURL: https://svn.iizuka.co.uk/common/binding/swing/tags/1.0.0-beta-1/src/main/java/uk/co/iizuka/common/binding/swing/JTextComponentTextObservable.java $
 * 
 * (c) 2011 IIZUKA Software Technologies Ltd.  All rights reserved.
 */
package uk.co.iizuka.common.binding.swing;

import java.util.EventListenerProxy;
import java.util.HashMap;
import java.util.Map;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;

import org.hobsoft.entangle.Observable;
import org.hobsoft.entangle.ObservableEvent;
import org.hobsoft.entangle.ObservableListener;

/**
 * 
 * 
 * @author Mark Hobson
 * @version $Id: JTextComponentTextObservable.java 97637 2012-01-06 16:05:07Z mark@IIZUKA.CO.UK $
 */
final class JTextComponentTextObservable implements Observable<String>
{
	// TODO: should listen for document changes too to switch listeners across
	
	// types ------------------------------------------------------------------
	
	private class ObservableListenerAdapter extends EventListenerProxy implements DocumentListener
	{
		// constructors -----------------------------------------------------------
		
		public ObservableListenerAdapter(ObservableListener<String> listener)
		{
			super(listener);
		}
		
		// DocumentListener methods -------------------------------------------

		/**
		 * {@inheritDoc}
		 */
		public void insertUpdate(DocumentEvent event)
		{
			fireValueChanged(event);
		}
		
		/**
		 * {@inheritDoc}
		 */
		public void changedUpdate(DocumentEvent event)
		{
			fireValueChanged(event);
		}
		
		/**
		 * {@inheritDoc}
		 */
		public void removeUpdate(DocumentEvent event)
		{
			fireValueChanged(event);
		}
		
		// EventListenerProxy methods -----------------------------------------
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public ObservableListener<String> getListener()
		{
			return (ObservableListener<String>) super.getListener();
		}
		
		// private methods --------------------------------------------------------
		
		private void fireValueChanged(DocumentEvent event)
		{
			Observable<String> source = JTextComponentTextObservable.this;
			
			// TODO: calculate old value
			String oldValue = null;
			String newValue = getText(event.getDocument());
			
			notifying = true;
			try
			{
				getListener().valueChanged(new ObservableEvent<String>(source, oldValue, newValue));
			}
			finally
			{
				notifying = false;
			}
		}
	}

	// fields -----------------------------------------------------------------
	
	private final JTextComponent textComponent;
	
	private final Map<ObservableListener<String>, DocumentListener> adaptersByListener;
	
	private boolean notifying;
	
	// constructors -----------------------------------------------------------
	
	public JTextComponentTextObservable(JTextComponent textComponent)
	{
		this.textComponent = textComponent;
		
		adaptersByListener = new HashMap<ObservableListener<String>, DocumentListener>();
		notifying = false;
	}

	// Observable methods -----------------------------------------------------
	
	/**
	 * {@inheritDoc}
	 */
	public void addObservableListener(ObservableListener<String> listener)
	{
		DocumentListener adapter = new ObservableListenerAdapter(listener);
		
		// remember adapter so we can remove it in removeObservableListener
		adaptersByListener.put(listener, adapter);

		textComponent.getDocument().addDocumentListener(adapter);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void removeObservableListener(ObservableListener<String> listener)
	{
		if (adaptersByListener.containsKey(listener))
		{
			DocumentListener adapter = adaptersByListener.remove(listener);
		
			textComponent.getDocument().removeDocumentListener(adapter);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getValue()
	{
		return textComponent.getText();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void setValue(String value)
	{
		// prevents setText being called within itself when document write locked
		if (!notifying)
		{
			textComponent.setText(value);
		}
	}
	
	// private methods --------------------------------------------------------
	
	private static String getText(Document document)
	{
		try
		{
			return document.getText(0, document.getLength());
		}
		catch (BadLocationException exception)
		{
			return null;
		}
	}
}
