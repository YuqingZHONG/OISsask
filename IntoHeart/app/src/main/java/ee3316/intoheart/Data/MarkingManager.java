package ee3316.intoheart.Data;

import java.util.HashMap;
import java.util.Map;

import ee3316.intoheart.MainActivity;

/**
 * Created by aahung on 4/12/15.
 */
public class MarkingManager {
    public Map<Integer, int[]> targetHRs = new HashMap<>();


    public MarkingManager() {
        targetHRs.put(20, new int[]{100, 170, 200});
        targetHRs.put(30, new int[]{95, 162, 190});
        targetHRs.put(35, new int[]{93, 157, 185});
        targetHRs.put(40, new int[]{90, 153, 180});
        targetHRs.put(45, new int[]{88, 149, 175});
    }

    public int mark[] = new int[]{100, 100, 100};

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

<<<<<<< Updated upstream
    public void evaluateSymptom(boolean[] symptom) {
        int s0=0,s1=0,s2=0,s3=0,s4=0,s5=0;
        if(symptom[0]==true)
            s0 = 15;
        if(symptom[2]==true)
            s1 = 15;
        if(symptom[4]==true)
            s2 = 10;
        if(symptom[6]==true)
            s3 = 10;
        if(symptom[8]==true)
            s4 = 10;
        if(symptom[10]==true)
            s5 = 10;
        mark[2] = s0 + s1 + s2 + s3 + s4 + s5;

=======


    public void evaluateSymptom(float[] symptom) {
        mark[2] = 4 * (25 -
                (int) (symptom[0] + symptom[1] + symptom[2] + symptom[3] + symptom[4])
        );
>>>>>>> Stashed changes
    }

    public int getFinalMark() {
        return (int) (mark[0] * 0.6 + mark[1] * 0.16 + mark[2] * 0.24);
    }

    public int getApneaMark() {
        return (int) mark[0];
    }
<<<<<<< Updated upstream
    public int getRestMark(){
        return (int) mark[1];
    }
=======

>>>>>>> Stashed changes
    public int getSymptomMark(){
        return (int) mark[2];
    }
}