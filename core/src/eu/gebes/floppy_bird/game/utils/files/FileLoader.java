package eu.gebes.floppy_bird.game.utils.files;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Disposable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class FileLoader {

    public void load() {
        for (Field f : getClass().getFields()) {

            f.setAccessible(true);

            try {
                Path path = f.getAnnotation(Path.class);
                if (f.getType().equals(Texture.class))
                    f.set(this, new Texture(Gdx.files.internal(path.path())));
                if (f.getType().equals(Sprite.class))
                    f.set(this, new Sprite(new Texture(Gdx.files.internal(path.path()))));
                if (f.getType().equals(Sound.class))
                    f.set(this, Gdx.audio.newSound(Gdx.files.internal(path.path())));

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        System.out.println("Loading finished");
    }

    public void dispose() {
        for (Field f : getClass().getFields()) {

            f.setAccessible(true);

            try {
                if (f.get(this) instanceof Disposable)
                    ((Disposable) f.get(this)).dispose();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }



}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Path{
    public String path() default "";
}