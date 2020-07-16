package designpatterns.order.undo;

public interface Command {
    void execute();
    void undo();
}
