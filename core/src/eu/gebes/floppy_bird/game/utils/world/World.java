package eu.gebes.floppy_bird.game.utils.world;

import eu.gebes.floppy_bird.game.utils.state.renderer.Renderer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class World {

    @Getter
    List<Entity> entities = new LinkedList<>();

    public void addEntity(Entity entity) {
        entity.setWorld(this);
        entity.create();
        entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        entity.setWorld(null);
        entities.remove(entity);
        System.out.println("Removed entity");
    }

    public void update(float dt) {
        for (int i = 0; i < entities.size(); i++) {
            Entity current = entities.get(i);
            current.update(dt);
            if (current.isDead())
                removeEntity(current);
        }
    }

    public void render(Renderer renderer) {
        Collections.sort(entities, new Comparator<Entity>() {
            @Override
            public int compare(Entity o1, Entity o2) {
                return ((Integer) o1.getRenderLayer()).compareTo(o2.getRenderLayer());
            }
        });
        for (Entity entity : entities)
            entity.render(renderer);
    }

    public <Type extends Entity> List<Type> getEntities(Class<Type> typeClass) {
        List<Type> categorised = new LinkedList<>();
        for (Entity entity : entities) {
            if (entity.getClass().equals(typeClass))
                categorised.add((Type) entity);
        }
        return categorised;
    }

}
