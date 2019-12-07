package designpatterns.order.box;

import designpatterns.order.Command;

/**
 * Created by xsg on 2019/12/1.
 */
public class Client {
    public static void main(String[] args) {
        MainBoardApi mainBoard = new GigaMainBoard();
        Command openCommand = new OpenCommand(mainBoard);
        Box box = new Box();
        box.setOpenCommand(openCommand);
        box.openButtonPressed();
    }
}
