package thread.coroutines;

import kilim.Mailbox;
import kilim.Pausable;
import kilim.Task;

import java.math.RoundingMode;

/**
 * Created by zjm on 2017/3/20.
 */
public class Calculator extends Task {

    private Mailbox<Calculation> mailbox;

    public Calculator(Mailbox<Calculation> mailbox) {
        super();
        this.mailbox = mailbox;
    }

    @Override
    public void execute() throws Pausable, Exception{
        while(true){
            Calculation ca = mailbox.get();//block
            if(ca.getAnswer() == null){
                ca.setAnswer(ca.getDividend().divide(ca.getDivisor(), 8, RoundingMode.HALF_UP));
                System.out.println("Calculator determined answer");
                mailbox.putnb(ca);
            }
            Task.sleep(1000);
        }
    }
}
