
package ro.udvari.Command;



public class CommandeRight implements Commande_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public CommandeRight(Sir sir)
		{
		this.sir = sir;
		}
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	public void execute()
		{
		sir.right();
		}

	@Override
	public void undo()
		{
		sir.left();

		}
	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private Sir sir;



	}

