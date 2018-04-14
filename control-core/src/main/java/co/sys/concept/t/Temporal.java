package co.sys.concept.t;

import co.sys.concept.adt.context.type.Event;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Temporal<Do> extends Current<Do>{

    private Future<? extends Current<? extends Do>> temporalAgent;

    public Temporal(Future<? extends Current<? extends Do>> temporalAgent) {
        this.temporalAgent = temporalAgent;
    }

    @Override
    public Do call() throws Exception {
        return this.getTaskAgent();
    }

    public Temporal(Current<? extends Do> current){
        this.temporalAgent = new FutureTask<>(() -> current);
    }

    public Future<? extends Current<? extends Do>> getTemporalAgent() {
        return temporalAgent;
    }

    public void setTemporalAgent(Future<?extends Current<? extends Do>> temporalAgent) {
        this.temporalAgent = temporalAgent;
    }

    public Do getTaskAgent() throws ExecutionException, InterruptedException {
        return temporalAgent.get().getTaskAgent();
    }

    public void setTaskAgent(Do taskAgent) {
        this.temporalAgent.cancel(true);
        Current<Do> newTaskAgent = new Current<Do>(taskAgent);
        this.temporalAgent = new FutureTask<>(() -> newTaskAgent);
    }
}
