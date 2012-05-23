
package ro.udvari.Command;



public class CommandeUp implements Commande_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public CommandeUp(Sir sir)
		{
		this.sir = sir;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public void execute()
		{
		sir.up();
		}

	@Override
	public void undo()
		{
		sir.down();
		}
	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private Sir sir;


	}

