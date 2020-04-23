package eu.gebes.floppy_bird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.*;
import eu.gebes.floppy_bird.game.FloppyBird;
import eu.gebes.floppy_bird.game.states.background.BackgroundState;
import eu.gebes.floppy_bird.game.states.gameplay.Gameplay;
import eu.gebes.floppy_bird.game.utils.state.renderer.Renderer;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Main extends ApplicationAdapter {

    Viewport viewport;

    Renderer renderer;



    public void create() {
        FloppyBird.camera = new OrthographicCamera();
        viewport = new ScalingViewport(Scaling.fit, FloppyBird.getProperties().getWidth(), FloppyBird.getProperties().getHeight(), FloppyBird.camera);
        FloppyBird.camera.setToOrtho(false, FloppyBird.getProperties().getWidth(), FloppyBird.getProperties().getHeight());
        FloppyBird.camera.update();
        renderer = new Renderer();
        FloppyBird.getTexturePack().load();
        FloppyBird.getStateManager().push(new BackgroundState());
        FloppyBird.getStateManager().push(new Gameplay());

    }

    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        FloppyBird.getStateManager().renderAll(renderer, Gdx.graphics.getDeltaTime() * FloppyBird.dtFac);

    }

    public void dispose() {
        FloppyBird.getTexturePack().dispose();
    }

    public void resize(int width, int height) {
        viewport.update(width, height);
    }
}
