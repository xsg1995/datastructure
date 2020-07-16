package concurrencyprogramming;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by xsg on 2019/12/29.
 */
public class TestPriorityBlockingQueue {

    static class Task implements Comparable<Task> {
        private int priority = 0;
        private String taskName;

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public int compareTo(Task o) {
            return o.priority - this.priority;
        }

        public void doSomeTing() {
            System.out.println(taskName + ":" + priority);
        }
    }

    public static void main(String[] args) {
        PriorityBlockingQueue<Task> priorityQueue = new PriorityBlockingQueue<>();
        Random random = new Random();
        for(int i = 0; i < 10; i++) {
            Task task = new Task();
            task.setPriority(random.nextInt(10));
            task.setTaskName("taskNme" + i);
            priorityQueue.offer(task);
        }
        while (!priorityQueue.isEmpty()) {
            Task task = priorityQueue.poll();
            if(task != null) {
                task.doSomeTing();
            }
        }

    }
}
