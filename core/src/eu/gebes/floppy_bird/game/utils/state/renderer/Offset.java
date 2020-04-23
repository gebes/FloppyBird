package eu.gebes.floppy_bird.game.utils.state.renderer;

import lombok.*;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@Getter @Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Offset {
    public static Offset NULL = new Offset(0,0);
   @NonNull float x, y;
}
