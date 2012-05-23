
package ro.udvari.Command;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class JFrameMain extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JFrameMain()
		{
		creerComposant();
		addComposant();
		addListener();
		setPropriete();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	private void creerComposant()
		{
		sir = new Sir(3, 3, 5, 5, 50, 50);
		jPanelPlayingField = new JPanelPlayingField(sir);
		jFrameButtons = new JPanelButtons(sir, jPanelPlayingField);
		}

	private void addComposant()
		{
		BorderLayout borderLayout = new BorderLayout();
		setLayout(borderLayout);
		add(jPanelPlayingField, BorderLayout.CENTER);
		add(jFrameButtons, BorderLayout.SOUTH);
		}

	private void addListener()
		{
		addKeyListener(new CommandeKeyListener('w', new CommandeUp(sir), jPanelPlayingField));
		addKeyListener(new CommandeKeyListener('s', new CommandeDown(sir), jPanelPlayingField));
		addKeyListener(new CommandeKeyListener('a', new CommandeLeft(sir), jPanelPlayingField));
		addKeyListener(new CommandeKeyListener('d', new CommandeRight(sir), jPanelPlayingField));

		Thread thread = new Thread(new VoiceController(sir, jPanelPlayingField));
		thread.start();
		}

	private void setPropriete()
		{
		setSize(700, 700);
		setTitle("Command Design Pattern Demo");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setFocusable(true);
		setVisible(true);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	public Sir getSir()
		{
		return sir;
		}

	private JPanelPlayingField jPanelPlayingField;
	private JPanelButtons jFrameButtons;
	private Sir sir;
	private VoiceController voiceController;
	}
