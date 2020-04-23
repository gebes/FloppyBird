package eu.gebes.floppy_bird.game.states.background;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import eu.gebes.floppy_bird.game.FloppyBird;
import eu.gebes.floppy_bird.game.utils.state.AlwaysUpdatedState;
import eu.gebes.floppy_bird.game.utils.state.renderer.Renderer;
import lombok.var;

import java.util.LinkedList;
import java.util.List;

public class BackgroundState extends AlwaysUpdatedState {
    List<Rectangle> background;
    final private static int AMOUNT = 5;
    Texture texture = FloppyBird.getTexturePack().background;
    float width;
    @Override
    public void create() {
        background = new LinkedList<>();
        float fac = FloppyBird.getProperties().getHeight() / (float)texture.getHeight();
        width = (texture.getWidth()*fac);
        for (int i = 0; i < AMOUNT; i++) {
            background.add(new Rectangle(i * width, 0, width, texture.getHeight()*fac));
        }
    }

    @Override
    public void update(float dt) {
        for (var rect : background){
            rect.x -= 75 * dt;
            if(rect.x + width < 0)
                rect.x += AMOUNT * width ;
        }
    }

    @Override
    public void render(Renderer renderer) {
        for (var rect : background)
            renderer.image(texture, rect);
    }

    @Override
    public void dispose() {

    }
}
