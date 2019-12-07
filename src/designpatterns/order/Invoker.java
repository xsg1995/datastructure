package designpatterns.order;

/**
 * Created by xsg on 2019/12/1.
 */
public class Invoker {
    private Command command = null;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action() {
        command.execute();
    }
}
