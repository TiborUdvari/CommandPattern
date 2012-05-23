
package ro.udvari.Command;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class CommandeKeyListener implements KeyListener
	{
	public CommandeKeyListener(char targetKey, Commande_I commande, JPanelPlayingField field)
		{
		this.field = field;
		this.targetKey = targetKey;
		this.commande = commande;
		}

	@Override
	public void keyPressed(KeyEvent e)
		{
		if (e.getKeyChar() == targetKey)
			{
			commande.execute();
			field.repaint();
			CommandeHistory.getInstance().getStackCommandes().push(commande);
			}
		}

	private char targetKey;
	private Commande_I commande;
	@Override
	public void keyReleased(KeyEvent e)
		{
		// TODO Auto-generated method stub

		}

	@Override
	public void keyTyped(KeyEvent e)
		{
		// TODO Auto-generated method stub

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private JPanelPlayingField field;


	}

