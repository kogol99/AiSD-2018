package Lista8;

public interface IExecutor<T,R> {
    void execute(int elem);
    R getResult();
}
