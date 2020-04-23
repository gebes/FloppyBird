package eu.gebes.floppy_bird.game.states.gameplay;

import eu.gebes.floppy_bird.game.FloppyBird;
import eu.gebes.floppy_bird.game.utils.state.AlwaysUpdatedState;
import eu.gebes.floppy_bird.game.utils.state.renderer.Renderer;
import eu.gebes.floppy_bird.game.utils.world.World;

public class Gameplay extends AlwaysUpdatedState {

    Bird bird;
    Pipes pipes;
    Floor floor;
    World world;

    @Override
    public void create() {
        world = new World();
        bird = new Bird();
        pipes = new Pipes(10);
        floor = new Floor();
        world.addEntity(floor);
        world.addEntity(pipes);
        world.addEntity(bird);
    }

    long target = -1;

    @Override
    public void update(float dt) {
        world.update(dt);
        if (System.currentTimeMillis() >= target && target != -1) {
            create();
            FloppyBird.dtFac = 1;
            target = -1;
        }
        if (FloppyBird.dtFac != 0) {
            for (Pipe p : world.getEntities(Pipe.class)) {
                if (bird.collidesWith(p)) {
                    die();
                }
            }
            if(bird.collidesWith(floor))
                die();
        }

    }

    private void die() {
        FloppyBird.getTexturePack().hit.play();
        FloppyBird.getTexturePack().die.play();
        bird.vel = -128;
        target = System.currentTimeMillis() + 2000;
        FloppyBird.movementSpeed = 0;
        FloppyBird.dtFac = 0;
    }

    @Override
    public void render(Renderer renderer) {
        world.render(renderer);
    }

    @Override
    public void dispose() {

    }
}

