package algorithm;

import java.util.Stack;

/**
 * 每日温度
 * Created by xsg on 2020/1/12.
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {23, 24, 25, 21, 19, 22, 26, 23};

        int[] result = analyze(temperatures);

        for (int r : result) {
            System.out.print(r);
        }
    }

    private static int[] analyze(int[] temperatures) {
        TemperaturesObj[] temperaturesObjs = new TemperaturesObj[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            TemperaturesObj temperaturesObj = new TemperaturesObj();
            temperaturesObj.index = i;
            temperaturesObj.temp = temperatures[i];

            temperaturesObjs[i] = temperaturesObj;
        }

        int[] result = new int[temperatures.length];

        Stack<TemperaturesObj> stack = new Stack<>();
        for (TemperaturesObj temperaturesObj : temperaturesObjs){
            if(stack.isEmpty() || stack.peek().temp > temperaturesObj.temp) {
                stack.push(temperaturesObj);
            } else {
                while (temperaturesObj.temp > stack.peek().temp) {
                    TemperaturesObj pop = stack.pop();
                    result[pop.index] = temperaturesObj.index - pop.index;

                    if(stack.isEmpty()) {
                        break;
                    }
                }

                stack.push(temperaturesObj);
            }
        }

        return result;
    }

    static class TemperaturesObj {
        public int index;
        private int temp;
    }
}
