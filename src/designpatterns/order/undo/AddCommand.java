package designpatterns.order.undo;

/**
 * Created by xsg on 2019/12/9.
 */
public class AddCommand implements Command {

    private OperationApi receiver;
    private int operNum;

    public AddCommand(OperationApi receiver, int operNum) {
        this.receiver = receiver;
        this.operNum = operNum;
    }

    @Override
    public void execute() {
        this.receiver.add(operNum);
    }

    @Override
    public void undo() {
        this.receiver.substract(operNum);
    }
}
