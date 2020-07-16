package designpatterns.order.undo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xsg on 2019/12/9.
 */
public class Calculator {

    private Command addCommand;
    private Command substractCommand;

    private List<Command> redo = new ArrayList<>();
    private List<Command> undo = new ArrayList<>();

    public void setAddCommand(Command addCommand) {
        this.addCommand = addCommand;
    }

    public void setSubstractCommand(Command substractCommand) {
        this.substractCommand = substractCommand;
    }

    public void addPressed() {
        this.undo.add(this.addCommand);
        this.addCommand.execute();
    }

    public void substractPressed() {
        this.undo.add(this.substractCommand);
        this.substractCommand.execute();
    }

    public void undoPressed() {
        if(this.undo.size() > 0) {
            Command undoCommand = this.undo.get(undo.size() - 1);
            undoCommand.undo();
            this.undo.remove(undoCommand);
            this.redo.add(undoCommand);
        }
    }

    public void redoPressed() {
        if(this.redo.size() > 0) {
            Command redoCommand = this.redo.get(this.redo.size() - 1);
            redoCommand.execute();
            this.redo.remove(redoCommand);
            this.undo.add(redoCommand);
        }
    }
}
