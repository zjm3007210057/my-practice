package thread.coroutines;

import kilim.Mailbox;
import kilim.Task;

/**
 * Created by zjm on 2017/3/20.
 */
public class CalculateMain {

    public static void main(String[] args) {
        Mailbox<Calculation> sharedMailbox = new Mailbox<>();
        Task deferred = new DeferredDivision(sharedMailbox);
        Task calculator = new Calculator(sharedMailbox);

        deferred.start();
        calculator.start();
    }
}
