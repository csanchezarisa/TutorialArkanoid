package assets.sonidos;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class Sound {
    /*
    public static final AudioClip BALL = Applet.newAudioClip(Sound.class.getResource("ball.wav"));
    public static final AudioClip GAME_OVER = Applet.newAudioClip(Sound.class.getResource("gameover.wav"));
    public static final AudioClip BACK = Applet.newAudioClip(Sound.class.getResource("back.wav"));
     */
    public static AudioClip BALL;
    public static AudioClip GAME_OVER;
    public static AudioClip BACK;

    static {
        try {
            BALL = Applet.newAudioClip(new URL("http://www.edu4java.com/sound/ball.wav"));
            GAME_OVER = Applet.newAudioClip(new URL("http://www.edu4java.com/sound/gameover.wav"));
            BACK = Applet.newAudioClip(new URL("http://www.edu4java.com/sound/back.wav"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
