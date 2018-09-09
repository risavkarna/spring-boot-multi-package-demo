package co.sys.util;

import co.sys.concept.patterns.things.adt.entities.Identity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

/**
 * Created by rkarna on 11.04.18
 */
public class Misc {

    // via http://stackoverflow.com/a/8592871
    private static final int CLIENT_CODE_STACK_INDEX;

    private static final Logger LOGGER = LoggerFactory.getLogger(Misc.class);

    static {
        // Finds out the index of "this code" in the returned stack trace - funny but it differs in JDK 1.5 and 1.6
        int i = 0;
        for (StackTraceElement ste : Thread.currentThread().getStackTrace()) {
            i++;
            if (ste.getClassName().equals(Misc.class.getName())) {
                break;
            }
        }
        CLIENT_CODE_STACK_INDEX = i;
    }

    private static String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[CLIENT_CODE_STACK_INDEX].getMethodName();
    }

    private Misc() {
    }

    public static UnsupportedOperationException unsupported() {
        throw new UnsupportedOperationException();
    }

    @SuppressWarnings("unchecked")
    public static void tryCatchLog(Consumer consumer, Identity o) {
        try {
            o.ifPresent(consumer);
        } catch (Exception e) {
            LOGGER.error("{} : {}", Misc.getCurrentMethodName(), e.getMessage());
        }
    }
}
