package co.sys.concept.t;

import co.sys.concept.adt.event.type.verb.Do;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class Current<Do> implements Callable<Do> {

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
