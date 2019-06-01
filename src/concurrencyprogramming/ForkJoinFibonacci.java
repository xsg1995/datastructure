package concurrencyprogramming;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Fork/Join计数斐波那也数
 * Created by xsg on 2019/6/1.
 */
public class ForkJoinFibonacci {
    static class Fibonacci extends RecursiveTask<Integer> {

        final int n;

        public Fibonacci(int n) {
            this.n = n;
        }

        @Override
        protected Integer compute() {
            if(n <= 1) {
                return n;
            }
            Fibonacci f1 = new Fibonacci(n - 1);
            Fibonacci f2 = new Fibonacci(n - 2);
            f1.fork();

            return f2.compute() + f1.join();
        }
    }

    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool(4);
        Fibonacci fib = new Fibonacci(10);
        Integer result = fjp.invoke(fib);

        System.out.println(result);
    }
}
