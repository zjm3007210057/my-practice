package thread.coroutines;

import kilim.Mailbox;
import kilim.Pausable;
import kilim.Task;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;
import java.util.Random;

/**
 * Created by zjm on 2017/3/20.
 */
public class DeferredDivision extends Task {

    private Mailbox<Calculation> mailbox;

    public DeferredDivision(Mailbox<Calculation> mailbox) {
        super();
        this.mailbox = mailbox;
    }

    @Override
    public void execute() throws Pausable, Exception {
        Random numberGenerator = new Random(new Date().getTime());
        MathContext context = new MathContext(8);
        while(true){
            System.out.println("I need to know the answer of something");
            mailbox.putb(new Calculation(new BigDecimal(numberGenerator.nextDouble(), context), new BigDecimal(numberGenerator.nextDouble(), context)));
            Task.sleep(1000);
            Calculation answer = mailbox.getb();//not block
            if(answer != null && answer.getAnswer() != null){
                System.out.println("Answer is: " + answer.pringAnswer());
            }
        }
    }
}
