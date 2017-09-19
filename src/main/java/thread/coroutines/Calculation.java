package thread.coroutines;

import java.math.BigDecimal;

/**
 * Created by zjm on 2017/3/20.
 */
public class Calculation {

    private BigDecimal dividend;

    private BigDecimal divisor;

    private BigDecimal answer;

    public Calculation(BigDecimal dividend, BigDecimal divisor) {
        super();
        this.dividend = dividend;
        this.divisor = divisor;
    }

    public BigDecimal getDividend() {
        return dividend;
    }

    public void setDividend(BigDecimal dividend) {
        this.dividend = dividend;
    }

    public BigDecimal getDivisor() {
        return divisor;
    }

    public void setDivisor(BigDecimal divisor) {
        this.divisor = divisor;
    }

    public BigDecimal getAnswer() {
        return answer;
    }

    public void setAnswer(BigDecimal answer) {
        this.answer = answer;
    }

    public String pringAnswer(){
        return "The answer of " + dividend + " divided by " + divisor + " is " + answer;
    }
}
