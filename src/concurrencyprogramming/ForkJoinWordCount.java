package concurrencyprogramming;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 使用Fork/Join实现单词计数
 * Created by xsg on 2019/6/1.
 */
public class ForkJoinWordCount {

    static class MR extends RecursiveTask<Map<String, Long>> {

        private String[] fc;
        private int start;
        private int end;

        public MR(String[] fc, int start, int end) {
            this.fc = fc;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Map<String, Long> compute() {
            if(end - start == 1) {
                return calc(fc[start]);
            }
            int mid = start + (end - start) / 2;
            MR mr1 = new MR(fc, start, mid);
            mr1.fork();
            MR mr2 = new MR(fc, mid, end);
            
            return merge(mr2.compute(), mr1.join());
        }

        private Map<String, Long> merge(Map<String, Long> r1, Map<String, Long> r2) {
            Map<String, Long> result = new HashMap<>();
            result.putAll(r1);
            
            r2.forEach((k, v) -> {
                Long c = result.get(k);
                if(c == null) {
                    c = 0L;
                }
                result.put(k, c + v);
            });
            return result;
        }

        private Map<String,Long> calc(String line) {
            Map<String, Long> result = new HashMap<>();

            String [] worlds = line.split("\\s+");

            for(String w : worlds) {
                Long v = result.get(w);
                if(v == null) {
                    v = 0L;
                }
                result.put(w, v + 1);
            }

            return result;
        }
    }
    
    public static void main(String[] args) {
        String[] fc = new String[]{
                "hello me",
                "hello fork",
                "hello join",
                "fork join in world"
        };

        ForkJoinPool fkl = new ForkJoinPool(3);
        MR mr = new MR(fc, 0, fc.length);
        Map<String, Long> result = fkl.invoke(mr);

        result.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
    }
}
