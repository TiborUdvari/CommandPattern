
package ro.udvari.Command;

public class CommandeDown implements Commande_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public CommandeDown(Sir sir)
		{
		this.sir = sir;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public void execute()
		{
		sir.down();
		}
	@Override
	public void undo()
		{
		sir.up();

		}
	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private Sir sir;



	}
