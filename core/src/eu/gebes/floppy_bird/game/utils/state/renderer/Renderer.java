package eu.gebes.floppy_bird.game.utils.state.renderer;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import eu.gebes.floppy_bird.game.FloppyBird;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
public class Renderer {

    @NonNull
    static SpriteBatch spriteBatch = new SpriteBatch();
    @NonNull
    static ShapeRenderer shapeRenderer = new ShapeRenderer();

    public Renderer(){
        spriteBatch.setProjectionMatrix(FloppyBird.camera.combined);
        shapeRenderer.setProjectionMatrix(FloppyBird.camera.combined);
    }

    @Getter
    @Setter
    Color color = Color.BLACK;

    @Getter
    @Setter
    Offset offset = Offset.NULL;

    public Renderer rect(Rectangle rectangle) {
        return rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public Renderer rect(float x, float y, float width, float height) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);
        shapeRenderer.rect(x + offset.getX(), y + offset.getY(), width, height);
        shapeRenderer.end();
        return this;
    }

    public Renderer image(Texture texture, Rectangle bounds) {
        return image(texture, bounds.x, bounds.y, bounds.width, bounds.height);
    }

    public Renderer image(Texture texture, float x, float y, float width, float height) {
        spriteBatch.begin();
        spriteBatch.draw(texture, x + offset.getX(), y + offset.getY(), width, height);
        spriteBatch.end();
        return this;
    }


    public Renderer image(Sprite texture, Rectangle bounds) {
        return image(texture, bounds.x, bounds.y, bounds.width, bounds.height);
    }

    public Renderer image(Sprite texture, float x, float y, float width, float height) {
        spriteBatch.begin();
        texture.setX(x);
        texture.setY(y);
        texture.setBounds(x,y,width,height);
        texture.draw(spriteBatch);
        spriteBatch.end();
        return this;
    }

}
