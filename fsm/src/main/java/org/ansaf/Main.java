package org.ansaf;


import static org.ansaf.instructions.Events.E1;
import static org.ansaf.instructions.Events.E2;
import static org.ansaf.instructions.Events.E3;
import static org.ansaf.instructions.States.S1;
import static org.ansaf.instructions.States.S2;
import static org.ansaf.instructions.States.SI;

import java.util.EnumSet;
import org.ansaf.instructions.Events;
import org.ansaf.instructions.States;

public class Main {

  public static void main(String[] args) {
    StateMachine<States, Events> stateMachine = new StateMachine<>(EnumSet.allOf(States.class), EnumSet.allOf(
        Events.class), SI);

    stateMachine.setInstruction(SI, S1, E1);
    stateMachine.setInstruction(SI, S2, E2);
    stateMachine.setInstruction(SI, S2, E3);

    stateMachine.setInstruction(S1, S2, E1);
    stateMachine.setInstruction(S1, SI, E2);
    stateMachine.setInstruction(S1, SI, E3);

    stateMachine.setInstruction(S2, SI, E1);
    stateMachine.setInstruction(S2, S1, E2);
    stateMachine.setInstruction(S2, S1, E3);



    System.out.println(stateMachine.getCurrentState());
    stateMachine.setNextState(E2);
    System.out.println(stateMachine.getCurrentState());
    stateMachine.setNextState(E2);
    System.out.println(stateMachine.getCurrentState());


  }
}