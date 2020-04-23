package eu.gebes.floppy_bird.game.states.gameplay;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import eu.gebes.floppy_bird.game.FloppyBird;
import eu.gebes.floppy_bird.game.utils.state.renderer.Renderer;
import eu.gebes.floppy_bird.game.utils.world.Entity;

public class Pipe extends Entity {
    final public static float WIDTH = FloppyBird.getTexturePack().pipe.getWidth();
    final public static float HEIGHT = FloppyBird.getTexturePack().pipe.getHeight();
    Direction direction;

    public Pipe(Rectangle bounds, Direction direction) {
        super(bounds, 10);
        this.direction = direction;
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(Renderer renderer) {
        Sprite sprite = FloppyBird.getTexturePack().pipe;
        sprite.setFlip(false, direction == Direction.DOWN);
        renderer.image(FloppyBird.getTexturePack().pipe, getBounds());
    }

    enum Direction {
        UP, DOWN
    }
}
