package eu.gebes.floppy_bird.game.utils.state;

import eu.gebes.floppy_bird.game.utils.state.renderer.Renderer;
import lombok.Getter;
import lombok.Setter;

import java.util.Stack;

public class StateManager {

    Stack<State> states = new Stack<>();
    @Getter @Setter
    private float speed = 1.0f;

    public void push(State state) {
        state.create();
        states.push(state);
    }

    public void add(State state) {
        state.create();
        states.push(state);
    }
    public State pop() {
        State state = states.pop();
        state.dispose();
        return state;
    }

    public State peek() {
        return states.peek();
    }

    public void renderAll(Renderer renderer, float dt) {
        dt *= speed;
        for (State state : states) {
            state.onTop = state == peek();
            if((state instanceof AlwaysUpdatedState || state == peek())  && !state.isPaused() && !(state instanceof StaticState))
                state.update(dt);
            state.render(renderer);
        }
    }




}
