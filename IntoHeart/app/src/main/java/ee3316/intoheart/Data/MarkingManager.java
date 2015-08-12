package ee3316.intoheart.Data;

import java.util.HashMap;
import java.util.Map;

import ee3316.intoheart.MainActivity;


public class MarkingManager {
    public Map<Integer, int[]> targetHRs = new HashMap<>();


    public MarkingManager() {
        targetHRs.put(20, new int[]{100, 170, 200});
        targetHRs.put(30, new int[]{95, 162, 190});
        targetHRs.put(35, new int[]{93, 157, 185});
        targetHRs.put(40, new int[]{90, 153, 180});
        targetHRs.put(45, new int[]{88, 149, 175});
    }

    public int mark[] = new int[]{0, 0, 0};

    private int matchTableAge(int age) {
        int tableAge = (Integer) targetHRs.keySet().toArray()[0];
        for (int key : targetHRs.keySet()) {
            if (age >= key) {
                tableAge = key;
                break;
            }
        }
        return tableAge;
    }

    public void evaluateApnea(int dif) {
       if(dif>=20 && dif<=40)
           mark[0]=50;

       else if (dif>40)
           mark[0]=100;
        else
           mark[0]=0;
    }




    public int getPathogenesisMark(int[] mark1, int age, int bmi){
        mark[1]=0;
        for(int i=0;i<mark1.length;i++){
            if(i==1||i==5) {
                if (mark1[i] == 1)
                    mark[1] += 15;
            }
            else {
                if (mark1[i] == 1)
                    mark[1]+=10;
            }
        }

        if(age>=40)
            mark[1]-=10;
        if(bmi>=25)
            mark[1]-=10;

        return mark[1];
    }

    public int getApneaMark() {
        return (int) mark[0];
    }

    public int getSymptomMark(int[] mark2){
        mark[2] = 0;
        for(int i = 0;i < mark2.length;i++){
            if(i == 0){
                if(mark2[i] == 1)
                    mark[2] += 40;
            }
            if(i == 1){
                if(mark2[i] == 1)
                    mark[2] += 20;
            }
            else{
                if(mark2[i] == 1)
                    mark[2] +=10;
            }
        }
        return  mark[2];
    }
}