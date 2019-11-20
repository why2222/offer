package src;

public class SolutionThree {
    public static boolean duplicate(int numbers[],int length,int [] duplication){
        for (int i = 0;i < length;i++){
            for (int j = i+1;j < length;j++){
                if (numbers[i] == numbers[j]){
                    duplication[0] = numbers[i];
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean duplicate2(int numbers[],int length,int [] duplication){
        int tmp;
        for (int i = 0;i < length;i++){
            if(numbers[i] == i){
                continue;
            }else {
                if (numbers[numbers[i]] == numbers[i]){
                    duplication[0] = numbers[i];
                    return true;
                }else {
                    tmp = numbers[numbers[i]];
                    numbers[numbers[i]] = numbers[i];
                    numbers[i] = tmp;
                }
            }
        }
        return false;
    }
}
