package designpatterns.order.box;

import designpatterns.order.Command;

/**
 * Created by xsg on 2019/12/1.
 */
public class Box {
    private Command openCommand;

    public void setOpenCommand(Command openCommand) {
        this.openCommand = openCommand;
    }

    public void openButtonPressed() {
        this.openCommand.execute();
    }
}
