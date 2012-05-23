
package ro.udvari.Command;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelButtons extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JPanelButtons(Sir sir, JPanelPlayingField field)
		{
		this.sir = sir;
		this.field = field;

		createComposant();
		addComposant();
		addListener();
		setPropriete();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void addListener()
		{
		undoButton.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent arg0)
					{
					Stack<Commande_I> stackCommandes = CommandeHistory.getInstance().getStackCommandes();
					if (!stackCommandes.isEmpty())
						{
						stackCommandes.pop().undo();
						field.repaint();
						}
					}
			});

		}

	private void setPropriete()
		{
		setPreferredSize(new Dimension(100, 50));
		setVisible(true);
		}

	private void createComposant()
		{
		buttonDown = new CommandeButton("Down", new CommandeDown(sir), field);
		buttonLeft = new CommandeButton("Left", new CommandeLeft(sir), field);
		buttonUp = new CommandeButton("Up", new CommandeUp(sir), field);
		buttonRight = new CommandeButton("Right", new CommandeRight(sir), field);
		undoButton = new JButton("Undo");
		undoButton.setFocusable(false);
		}

	private void addComposant()
		{
		setLayout(new FlowLayout());
		add(buttonLeft);
		add(buttonRight);
		add(buttonUp);
		add(buttonDown);
		add(undoButton);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private CommandeButton buttonUp;
	private CommandeButton buttonDown;
	private CommandeButton buttonLeft;
	private CommandeButton buttonRight;
	private JButton undoButton;
	private Sir sir;
	private JPanelPlayingField field;
	}
