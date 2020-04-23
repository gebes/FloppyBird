package eu.gebes.floppy_bird.game.utils.files;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PUBLIC)
public class TexturePack extends FileLoader {

    @Path(path = "sprites/yellowbird-downflap.png")
    Texture bird_down;
    @Path(path = "sprites/yellowbird-midflap.png")
    Texture bird_mid;
    @Path(path = "sprites/yellowbird-upflap.png")
    Texture bird_up;

    @Path(path = "sprites/background-day.png")
    Texture background;

    @Path(path = "sprites/pipe-green.png")
    Sprite pipe;
    @Path(path = "sprites/base.png")
    Texture base;

    @Path(path = "audio/wing.wav")
    Sound flap;
    @Path(path = "audio/die.wav")
    Sound die;
    @Path(path = "audio/hit.wav")
    Sound hit;
}
