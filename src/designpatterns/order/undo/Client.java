package designpatterns.order.undo;

/**
 * Created by xsg on 2019/12/9.
 */
public class Client {
    public static void main(String[] args) {
        OperationApi receiver = new Operation();
        receiver.setResult(1);

        Command addCommand = new AddCommand(receiver, 5);
        Command substractCommand = new SubstractCommand(receiver, 5);

        Calculator calculator = new Calculator();
        calculator.setAddCommand(addCommand);
        calculator.setSubstractCommand(substractCommand);

        calculator.addPressed();
        System.out.println(receiver.getResult());

        calculator.substractPressed();
        System.out.println(receiver.getResult());

        calculator.undoPressed();
        System.out.println(receiver.getResult());

        calculator.redoPressed();
        System.out.println(receiver.getResult());
    }
}
