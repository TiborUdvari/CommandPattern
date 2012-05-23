
package ro.udvari.Command;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class JPanelPlayingField extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JPanelPlayingField(Sir sir)
		{
		this.sir = sir;
		colNumber = 5;
		rowNumber = 5;

		int rectangleWidth = 50;
		int rectangleHeight = 50;

		rectangle = new Rectangle2D.Double(0, 0, rectangleWidth, rectangleHeight);

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	@Override
	protected void paintComponent(Graphics g)
		{
		super.paintComponent(g);
		setupValues();
		g2d = (Graphics2D)g;
		dessiner(g2d);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void dessiner(Graphics2D g2d)
		{

		double deltaWidth = getWidth() / colNumber;
		double deltaHeight = getHeight() / rowNumber;

		for(double i = 0; i < colNumber; i++)
			{
			for(double j = 0; j < rowNumber; j++)
				{
				if ((i + j) % 2 == 0)
					{
					//TODO make this smarter
					g2d.setColor(new Color(150,150,150));
					}
				else
					{
					g2d.setColor(Color.WHITE);
					}
				g2d.translate(i * deltaWidth, j * deltaHeight);
				g2d.fill(rectangle);
				g2d.translate(-i * deltaWidth, -j * deltaHeight);
				}
			}

		sir.drawSir(g2d);
		}

	private void setupValues()
		{
		rectangleWidth = getWidth() / colNumber;
		rectangleHeight = getHeight() / rowNumber;
		rectangle.setRect(0, 0, rectangleWidth, rectangleHeight);
		sir.setImageWidth((int)rectangleWidth);
		sir.setImageHeight((int)rectangleHeight);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private Graphics2D g2d;
	private Rectangle2D rectangle;
	private double rectangleWidth;
	private double rectangleHeight;

	private int colNumber;
	private int rowNumber;

	private Sir sir;
	}
