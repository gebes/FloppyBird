package eu.gebes.floppy_bird.game.states.gameplay;

import com.badlogic.gdx.math.Rectangle;
import eu.gebes.floppy_bird.game.FloppyBird;
import eu.gebes.floppy_bird.game.utils.state.renderer.Renderer;
import eu.gebes.floppy_bird.game.utils.world.Entity;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class Pipes extends Entity {
    int amount;
    final static int SPACE = 80;

    public Pipes(int amount) {
        super(new Rectangle(), 0);
        this.amount = amount;
    }

    @Override
    public void create() {
        for (int i = 0; i < amount; i++) {
            int center = ThreadLocalRandom.current().nextInt(190 + 1 - 100) + 100;
            getWorld().addEntity(new Pipe(
                    new Rectangle(FloppyBird.getProperties().getWidth() + (Pipe.WIDTH * 3f) * i, center + SPACE / 2f, Pipe.WIDTH, Pipe.HEIGHT), Pipe.Direction.DOWN
            ));
            getWorld().addEntity(new Pipe(
                    new Rectangle(FloppyBird.getProperties().getWidth() + (Pipe.WIDTH * 3f) * i, center - SPACE / 2f - Pipe.HEIGHT, Pipe.WIDTH, Pipe.HEIGHT), Pipe.Direction.UP
            ));
        }
    }

    @Override
    public void update(float dt) {
        for (Pipe p : getWorld().getEntities(Pipe.class)) {
            p.getBounds().x -= 75 * dt * FloppyBird.movementSpeed;
            if (p.getBounds().x + Pipe.WIDTH < 0)
                p.getBounds().x = Pipe.WIDTH*3* amount - Pipe.WIDTH;
        }
    }

    @Override
    public void render(Renderer renderer) {

    }
}
