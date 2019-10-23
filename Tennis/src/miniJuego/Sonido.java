package miniJuego;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sonido{
	 
	public static final AudioClip BACK = Applet.newAudioClip(Sonido.class.getResource("musicaDeFondo.wav"));
	public static final AudioClip GAMEOVER = Applet.newAudioClip(Sonido.class.getResource("perdio.wav"));

}
