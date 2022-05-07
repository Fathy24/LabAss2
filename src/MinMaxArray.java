public class MinMaxArray {
    int GetMax(int[] num){
        int max = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] > max)
                max = num[i];
        }
        return max;
    }
    int GetMin(int[] num){
        int min = num[0];
        for(int i =1; i< num.length; i++){
            if(num[i] < min)
                min = num[i];
        }
        return min;
    }
}
