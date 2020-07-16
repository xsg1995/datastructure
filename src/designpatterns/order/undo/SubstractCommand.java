package designpatterns.order.undo;

/**
 * Created by xsg on 2019/12/9.
 */
public class SubstractCommand implements Command {
    private OperationApi receiver;
    private int operNum;

    public SubstractCommand(OperationApi receiver, int operNum) {
        this.receiver = receiver;
        this.operNum = operNum;
    }

    @Override
    public void execute() {
        this.receiver.substract(this.operNum);
    }

    @Override
    public void undo() {
        this.receiver.add(this.operNum);
    }
}
