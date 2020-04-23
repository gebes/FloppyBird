package eu.gebes.floppy_bird.game.utils.world;

import com.badlogic.gdx.math.Rectangle;
import eu.gebes.floppy_bird.game.FloppyBird;
import eu.gebes.floppy_bird.game.utils.state.renderer.Renderer;
import lombok.*;


@RequiredArgsConstructor
public abstract class Entity implements Drawable, Updateable {

    @Getter @Setter
    @NonNull Rectangle bounds;

    @Getter @Setter
    @NonNull int renderLayer;

    public void create(){

    }

    @Override
    public abstract void update(float dt);
    @Override
    public abstract void render(Renderer renderer);

    public boolean isOnScreen(){
        return FloppyBird.getToolbox().isOnScreen(getBounds());
    }

    public boolean collidesWith(Entity entity){
        return entity.getBounds().overlaps(this.getBounds());
    }

    @Setter(value = AccessLevel.PACKAGE) @Getter
    World world;

    @Getter
    private boolean isDead;

    public void kill(){
        isDead = true;
    }


}
