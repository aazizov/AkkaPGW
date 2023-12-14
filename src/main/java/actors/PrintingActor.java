package actors;

import akka.actor.AbstractActor;
import akka.actor.Props;

public class PrintingActor extends AbstractActor {

    public static Props props() {
        Props props = Props.create(PrintingActor.class);
        return props;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, this::printString)
                .matchAny((Object o)-> System.out.println("unexpected message type for PrintingActor"))
                .build();
        }

    private void printString(String str) {
        System.out.println("Actor: " + str);
    }
}
