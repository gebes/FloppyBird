package eu.gebes.floppy_bird.game.utils;

import com.badlogic.gdx.math.Rectangle;
import eu.gebes.floppy_bird.game.FloppyBird;

public class Toolbox {

    private static Rectangle screen = new Rectangle(0,0, FloppyBird.getProperties().getWidth(), FloppyBird.getProperties().getHeight());

    public boolean isOnScreen(Rectangle bounds){
        return bounds.overlaps(screen);
    }

}
