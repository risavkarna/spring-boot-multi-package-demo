package co.sys.concept.patterns.things.adt.entities.env.time;

import co.sys.concept.Concept;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class Current<Do> extends Concept implements Callable<Do> {

    private Do taskAgent;

    protected Current(Do taskAgent) {
        this.taskAgent = taskAgent;
    }

    @Override
    public Do call() throws Exception {
        return taskAgent;
    }

    public Do getTaskAgent() throws ExecutionException, InterruptedException {
        return taskAgent;
    }

    public void setTaskAgent(Do taskAgent) {
        this.taskAgent = taskAgent;
    }

    public Current() {
    }
}
