package designpatterns.order.undo;

public interface OperationApi {

    int getResult();

    void setResult(int result);

    void add(int num);

    void substract(int num);
}
