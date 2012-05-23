
package ro.udvari.Command;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Sir
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public Sir(int xPosition, int yPosition, int colNumber, int rowNumber, int imageWidth, int imageHeight)
		{
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.colNumber = colNumber;
		this.rowNumber = rowNumber;
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
		image = new ImageIcon("like_a_sir.png").getImage();
		}

	public Sir(int colNumber, int rowNumber, int imageWidth, int imageHeight)
		{
		this.colNumber = colNumber;
		this.rowNumber = rowNumber;
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
		xPosition = colNumber / 2;
		yPosition = rowNumber / 2;

		image = new ImageIcon("like_a_sir.png").getImage();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/
	public void drawSir(Graphics2D g2d)
		{
		g2d.translate(imageWidth * xPosition + imageWidth / 2, imageHeight * yPosition + imageHeight / 2);
		g2d.drawImage(image, -imageWidth / 2, -imageHeight / 2, imageWidth, imageHeight, null);
		g2d.translate(-imageWidth * xPosition + imageWidth / 2, -imageHeight * yPosition + imageHeight / 2);
		}

	public void up()
		{
		if (yPosition >= 1)
			{
			yPosition--;
			}
		}

	public void down()
		{
		if (yPosition < rowNumber-1)
			{
			yPosition++;
			}
		}

	public void right()
		{
		if (xPosition < colNumber-1)
			{
			xPosition++;
			}
		}

	public void left()
		{
		if (xPosition >= 1)
			{
			xPosition--;
			}
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/
	public void setImageWidth(int imageWidth)
		{
		this.imageWidth = imageWidth;
		}

	public void setImageHeight(int imageHeight)
		{
		this.imageHeight = imageHeight;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private int xPosition;

	private int yPosition;
	private int colNumber;
	private int rowNumber;
	private int imageWidth;
	private int imageHeight;

	private Image image;

	}
