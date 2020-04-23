package eu.gebes.floppy_bird.game.utils.state;

import eu.gebes.floppy_bird.game.utils.world.Drawable;
import eu.gebes.floppy_bird.game.utils.state.renderer.Renderer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
/**
 * Gets updated when: isOnTop and is not paused
 */
public abstract class State implements Drawable {

    @Getter
    boolean paused;
    public void pause(){
        paused = true;
    }
    public void resume(){
        paused = false;
    }

    @Getter
    boolean onTop;

    public abstract void create();
    public abstract void update(float dt);
    public abstract void render(Renderer renderer);
    public abstract void dispose();



}
