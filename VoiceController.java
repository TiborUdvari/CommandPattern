/*
 * Copyright 1999-2004 Carnegie Mellon University.
 * Portions Copyright 2004 Sun Microsystems, Inc.
 * Portions Copyright 2004 Mitsubishi Electric Research Laboratories.
 * All Rights Reserved.  Use is subject to license terms.
 *
 * See the file "license.terms" for information on usage and
 * redistribution of this file, and for a DISCLAIMER OF ALL
 * WARRANTIES.
 *
 */

package ro.udvari.Command;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;

/**
 * A simple HelloWorld demo showing a simple speech application built using Sphinx-4. This application uses the Sphinx-4
 * endpointer, which automatically segments incoming audio into utterances and silences.
 */
public class VoiceController implements Runnable
	{

	public VoiceController(Sir sir, JPanelPlayingField field)
		{
		VoiceController.sir = sir;
		VoiceController.field = field;

		cm = new ConfigurationManager(VoiceController.class.getResource("/ro/udvari/Command/helloworld.config.xml"));

		recognizer = (Recognizer)cm.lookup("recognizer");
		recognizer.allocate();

		microphone = (Microphone)cm.lookup("microphone");
		if (!microphone.startRecording())
			{
			System.out.println("Cannot start microphone.");
			recognizer.deallocate();
			System.exit(1);
			}
		}


	@Override
	public void run()
		{
		recognizeVoice();

		}

	public static void recognizeVoice()
		{

		System.out.println("Say: ( Up | Down | Right | Left )");

		while(true)
			{
			System.out.println("Start speaking. Press Ctrl-C to quit.\n");

			result = recognizer.recognize();

			if (result != null)
				{
				String resultText = result.getBestFinalResultNoFiller();

				if (resultText.equalsIgnoreCase("up"))
					{
					commande = new CommandeUp(sir);
					}
				if (resultText.equalsIgnoreCase("down"))
					{
					commande = new CommandeDown(sir);
					}
				if (resultText.equalsIgnoreCase("left"))
					{
					commande = new CommandeLeft(sir);
					}
				if (resultText.equalsIgnoreCase("right"))
					{
					commande = new CommandeRight(sir);
					}
				System.out.println(resultText);
				commande.execute();
				field.repaint();
				CommandeHistory.getInstance().getStackCommandes().push(commande);
				}
			}
		}

	private static ConfigurationManager cm;
	private static Recognizer recognizer;
	private static Microphone microphone;
	private static Result result;
	private static Commande_I commande;

	private static Sir sir;
	private static JPanelPlayingField field;


	}
