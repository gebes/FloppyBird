package eu.gebes.floppy_bird.game.states.gameplay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import eu.gebes.floppy_bird.game.FloppyBird;
import eu.gebes.floppy_bird.game.utils.state.renderer.Renderer;
import eu.gebes.floppy_bird.game.utils.world.Entity;

public class Bird extends Entity {

    final static int WIDTH = 34, HEIGHT = 24, GRAVITY = 900, MOVEMENT = 256;

    public double vel = 0;


    int currentAnimFrame = 1, countFrames = 3;
    double animTimer;

    public Bird(){
        super(new Rectangle(150, (FloppyBird.getProperties().getHeight() + HEIGHT) * 0.5f, WIDTH, HEIGHT), 11);
    }




    @Override
    public void update(float dt) {
        animTimer += dt;
        if (animTimer > 1 / 9f) {
            currentAnimFrame++;
            animTimer = 0;
            if (currentAnimFrame > countFrames)
                currentAnimFrame = 1;
        }

        vel += GRAVITY * dt;
        getBounds().y -= vel * dt;


        if(FloppyBird.movementSpeed == 0 && getBounds().y < 100 && FloppyBird.dtFac != 0)
            vel = -MOVEMENT;

        if (FloppyBird.dtFac != 0 && (Gdx.input.justTouched() || Gdx.input.isKeyJustPressed(Input.Keys.SPACE))) {
            FloppyBird.getTexturePack().flap.play();
            vel = -MOVEMENT;
            FloppyBird.movementSpeed = 1;
        }

        if(dt == 0){
            vel += GRAVITY *Gdx.graphics.getDeltaTime();
            getBounds().y -= vel * Gdx.graphics.getDeltaTime();
        }
/*
        if(getBounds().y < 0)
            getBounds().y = 0;
*/
        if(getBounds().y + getBounds().height > FloppyBird.getProperties().getHeight())
            getBounds().y = FloppyBird.getProperties().getHeight() - getBounds().height;
   }

    @Override
    public void render(Renderer renderer) {
        Texture texture = null;
        switch (currentAnimFrame) {
            case 1:
                texture = FloppyBird.getTexturePack().bird_down;
                break;
            case 2:
                texture = FloppyBird.getTexturePack().bird_mid;
                break;
            case 3:
                texture = FloppyBird.getTexturePack().bird_up;
                break;
            default:
                break;
        }
        renderer.image(texture, getBounds());
    }
}
