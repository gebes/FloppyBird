package eu.gebes.floppy_bird.game.utils.state;

/**
 * Gets never updated
 */
public abstract class StaticState extends State {
    @Override
    public void update(float dt) {

    }
}
