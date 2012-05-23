
package ro.udvari.Command;

import java.util.Stack;

public class CommandeHistory
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	private CommandeHistory()
		{
		stackCommandes = new Stack<Commande_I>();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	public static CommandeHistory getInstance()
		{
		if (instance == null)
			{
			instance = new CommandeHistory();
			}
		return instance;
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/
	public Stack<Commande_I> getStackCommandes()
		{
		return this.stackCommandes;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private static CommandeHistory instance;
	private Stack<Commande_I> stackCommandes;
	}
