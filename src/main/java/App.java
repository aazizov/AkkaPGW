import actors.PrintingActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class App {
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
        ActorSystem SupervisorActor = ActorSystem.create("SupervisorActorCreated");
        ActorRef printActor = SupervisorActor.actorOf(PrintingActor.props(), "PrintingActor");
        ActorRef printActor2 = SupervisorActor.actorOf(PrintingActor.props(), "PrintingActor2");

        printActor.tell("Hello World from App", ActorRef.noSender());
        printActor2.tell("GoodBy from App", ActorRef.noSender());



    }
}
