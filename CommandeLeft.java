
package ro.udvari.Command;

public class CommandeLeft implements Commande_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public CommandeLeft(Sir sir)
		{
		this.sir = sir;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public void execute()
		{
		sir.left();
		}

	@Override
	public void undo()
		{
		sir.right();

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private Sir sir;

	}
