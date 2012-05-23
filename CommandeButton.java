
package ro.udvari.Command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Invoker
 */
public class CommandeButton extends JButton
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public CommandeButton(String text, Commande_I commande, JPanelPlayingField field)
		{
		setText(text);
		this.commande = commande;
		this.field = field;
		addListener();
		setFocusable(false);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void addListener()
		{
		addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
					{
					commande.execute();
					field.repaint();
					CommandeHistory.getInstance().getStackCommandes().push(commande);
					}
			});

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private Commande_I commande;
	private JPanelPlayingField field;
	}
