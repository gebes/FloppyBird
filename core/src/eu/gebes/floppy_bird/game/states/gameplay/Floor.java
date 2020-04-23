package eu.gebes.floppy_bird.game.states.gameplay;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import eu.gebes.floppy_bird.game.FloppyBird;
import eu.gebes.floppy_bird.game.utils.state.renderer.Renderer;
import eu.gebes.floppy_bird.game.utils.world.Entity;
import lombok.var;

import java.util.LinkedList;
import java.util.List;

public class Floor extends Entity {
    static int WIDTH = FloppyBird.getTexturePack().base.getWidth(), HEIGHT = FloppyBird.getTexturePack().base.getHeight();

    public Floor() {
        super(new Rectangle(0, -HEIGHT/1.25f, FloppyBird.getProperties().getWidth(), HEIGHT), 11);
    }

    List<Rectangle> base;
    final private static int AMOUNT = 10;
    Texture texture = FloppyBird.getTexturePack().base;
    float width;

    @Override
    public void create() {
        base = new LinkedList<>();
        for (int i = 0; i < AMOUNT; i++) {
            base.add(new Rectangle(i * WIDTH,-HEIGHT/1.25f, WIDTH, HEIGHT));
        }
    }

    @Override
    public void update(float dt) {
        for (var rect : base){
            rect.x -= 75 * dt;
            if(rect.x + width < 0)
                rect.x += AMOUNT * width;
        }
    }

    @Override
    public void render(Renderer renderer) {
        for (var rect : base)
            renderer.image(texture, rect);
    }

}
