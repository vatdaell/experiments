package org.ansaf;

import java.util.EnumSet;
import java.util.HashMap;

public class StateMachine<S extends Enum<S>, E extends Enum<E>> {

  private Enum<S> currentState;
  private final HashMap<Enum<S>, HashMap<Enum<E>, Enum<S>>> instructions;

  public StateMachine(EnumSet<S> states, EnumSet<E> events, Enum<S> initialState) {
    this.instructions = new HashMap<>();
    this.currentState = initialState;

    HashMap<Enum<E>,Enum<S>> eventInstructions = new HashMap<>();
    events.forEach(e -> {
      eventInstructions.put(e, null);
    });

    states.forEach(s->{
      instructions.put(s, eventInstructions);
    });
  }

  public Enum<S> getCurrentState() {
    return currentState;
  }

  public HashMap<Enum<S>, HashMap<Enum<E>, Enum<S>>> getInstructions() {
    return instructions;
  }

  public void setInstruction(Enum<S> sourceState, Enum<S> targetState, Enum<E> event) {
    instructions.get(sourceState).put(event, targetState);
  }

  public void setNextState(Enum<E> event){
    Enum<S> nextState = instructions.get(currentState).get(event);
    if(nextState != null){
      currentState = nextState;
    }
  }
}
