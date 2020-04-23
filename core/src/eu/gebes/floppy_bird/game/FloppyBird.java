package eu.gebes.floppy_bird.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import eu.gebes.floppy_bird.game.utils.Toolbox;
import eu.gebes.floppy_bird.game.utils.files.TexturePack;
import eu.gebes.floppy_bird.game.utils.state.StateManager;
import lombok.Getter;

public class FloppyBird {

    @Getter
    public static TexturePack texturePack = new TexturePack();

    @Getter
    public static Properties properties = new Properties();

    @Getter
    public static StateManager stateManager = new StateManager();

    @Getter
    public static Toolbox toolbox = new Toolbox();

    @Getter
    public static OrthographicCamera camera;

    public static float dtFac = 1, movementSpeed = 0;

}
