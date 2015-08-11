package ee3316.intoheart.Data;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;
import android.widget.RadioButton;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import butterknife.InjectView;
import ee3316.intoheart.HTTP.JCallback;
import ee3316.intoheart.HTTP.Outcome;
import ee3316.intoheart.MainActivity;
import ee3316.intoheart.R;


public class UserStore {
    private final String PREFERENCE = "into_heart";
    private final String PREFS_NAME_NAME = "user_name";
    private final String PREFS_NAME_AGE = "user_age";
    private final String PREFS_NAME_HEIGHT = "user_height";
    private final String PREFS_NAME_WEIGHT = "user_weight";
    private final String PREFS_NAME_EMERGENCY_TEL = "user_emergency_tel";
    private final String PREFS_NAME_EMAIL = "user_email";
    private final String PREFS_NAME_PASSWORD = "user_password";
    private final String PREFS_NAME_SNORING_Y = "user_snoring_yes";
    private final String PREFS_NAME_SNORING_N = "user_snoring_no";
    private final String PREFS_NAME_HIGH_BLOOD_PRESSURE_Y = "user_high_blood_pressure_yes";
    private final String PREFS_NAME_HIGH_BLOOD_PRESSURE_N = "user_high_blood_pressure_no";
    private final String PREFS_NAME_INATTENTION_Y = "user_inattention_yes";
    private final String PREFS_NAME_INATTENTION_N = "user_inattention_no";
    private final String PREFS_NAME_SLEEPINESS_Y = "user_sleepiness_yes";
    private final String PREFS_NAME_SLEEPINESS_N = "user_sleepiness_no";
    private final String PREFS_NAME_HEART_DISEASE_Y = "user_heart_disease_yes";
    private final String PREFS_NAME_HEART_DISEASE_N = "user_heart_disease_no";
    private final String PREFS_NAME_EMOTIONAL_LABILITY_Y = "user_emotional_lability_yes";
    private final String PREFS_NAME_EMOTIONAL_LABILITY_N= "user_emotional_lability_no";
    private final String PREFS_NAME_MARK_0 = "mark_0";
    private final String PREFS_NAME_MARK_1 = "mark_1";
    private final String PREFS_NAME_MARK_2 = "mark_2";
    private final String PREFS_NAME_SEX="user_gender";
    private final String PREFS_NAME_ENLARGED_TONSIL="user_tonsil";
    private final String PREFS_NAME_ALCOHOLISM="user_alcohol";
    private final String PREFS_NAME_SMOKE="user_smoke";
    private final String PREFS_NAME_TAKE_HYPNOTIC="user_hypnotic";
    private final String PREFS_NAME_BRAIN_TUMOR="user_brain_tumor";
    private final String PREFS_NAME_FAMILY_HISTORY="user_family_history";


    public SharedPreferences settings;

    private Context context;
    public String name, email, password;
    public int gender,tonsil,alcohol,smoke,hypnotic,brain_tumor,family_history;
    public int age, height, weight;
    public String emergencyTel;
    public int[] symptoms = new int[12];





    public MarkingManager markingManager = new MarkingManager();

    public UserStore(Context context) {
        this.context = context;
        settings = context.getSharedPreferences(PREFERENCE, 0);
        fetch();
    }

    public void fetch() {
        name = settings.getString(PREFS_NAME_NAME, null);
        gender=settings.getInt(PREFS_NAME_SEX, -1);
        tonsil=settings.getInt(PREFS_NAME_ENLARGED_TONSIL, -1);
        alcohol=settings.getInt(PREFS_NAME_ALCOHOLISM, -1);
        smoke=settings.getInt(PREFS_NAME_SMOKE, -1);
        hypnotic=settings.getInt(PREFS_NAME_TAKE_HYPNOTIC, -1);
        brain_tumor=settings.getInt(PREFS_NAME_BRAIN_TUMOR, -1);
        family_history=settings.getInt(PREFS_NAME_FAMILY_HISTORY, -1);

        email = settings.getString(PREFS_NAME_EMAIL, null);
        password = settings.getString(PREFS_NAME_PASSWORD, null);
        emergencyTel = settings.getString(PREFS_NAME_EMERGENCY_TEL, null);
        age = settings.getInt(PREFS_NAME_AGE, -1);
        height = settings.getInt(PREFS_NAME_HEIGHT, -1);
        weight = settings.getInt(PREFS_NAME_WEIGHT, -1);
       /* symptoms[0] = settings.getInt(PREFS_NAME_SNORING_Y, -1);
        symptoms[1] = settings.getInt(PREFS_NAME_SNORING_N, -1);
        symptoms[2] = settings.getInt(PREFS_NAME_HIGH_BLOOD_PRESSURE_Y, -1);
        symptoms[3] = settings.getInt(PREFS_NAME_HIGH_BLOOD_PRESSURE_N, -1);
        symptoms[4] = settings.getInt(PREFS_NAME_INATTENTION_Y, -1);
        symptoms[5] = settings.getInt(PREFS_NAME_INATTENTION_N, -1);
        symptoms[6] = settings.getInt(PREFS_NAME_SLEEPINESS_Y, -1);
        symptoms[7] = settings.getInt(PREFS_NAME_SLEEPINESS_N, -1);
        symptoms[8] = settings.getInt(PREFS_NAME_HEART_DISEASE_Y, -1);
        symptoms[9] = settings.getInt(PREFS_NAME_HEART_DISEASE_N, -1);
        symptoms[10] = settings.getInt(PREFS_NAME_EMOTIONAL_LABILITY_Y, -1);
        symptoms[11] = settings.getInt(PREFS_NAME_EMOTIONAL_LABILITY_N, -1);*/
        markingManager.mark[0] = settings.getInt(PREFS_NAME_MARK_0, 100);
        markingManager.mark[1] = settings.getInt(PREFS_NAME_MARK_1, 100);
        markingManager.mark[2] = settings.getInt(PREFS_NAME_MARK_2, 100);


    }


    public void save() {
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(PREFS_NAME_NAME, name);
        editor.putInt(PREFS_NAME_AGE, age);
        editor.putInt(PREFS_NAME_HEIGHT, height);
        editor.putInt(PREFS_NAME_WEIGHT, weight);
        editor.putString(PREFS_NAME_EMERGENCY_TEL, emergencyTel);
        editor.putString(PREFS_NAME_EMAIL, email);
        editor.putString(PREFS_NAME_PASSWORD, password);


        editor.putInt(PREFS_NAME_SEX, gender);
        editor.putInt(PREFS_NAME_ENLARGED_TONSIL, tonsil);
        editor.putInt(PREFS_NAME_ALCOHOLISM, alcohol);
        editor.putInt(PREFS_NAME_SMOKE, smoke);
        editor.putInt(PREFS_NAME_TAKE_HYPNOTIC, hypnotic);
        editor.putInt(PREFS_NAME_BRAIN_TUMOR, brain_tumor);
        editor.putInt(PREFS_NAME_FAMILY_HISTORY, family_history);


       /* editor.putInt(PREFS_NAME_SNORING_Y, symptoms[0]);
        editor.putInt(PREFS_NAME_SNORING_N, symptoms[1]);
        editor.putInt(PREFS_NAME_HIGH_BLOOD_PRESSURE_Y, symptoms[2]);
        editor.putInt(PREFS_NAME_HIGH_BLOOD_PRESSURE_N, symptoms[3]);
        editor.putInt(PREFS_NAME_INATTENTION_Y, symptoms[4]);
        editor.putInt(PREFS_NAME_INATTENTION_N, symptoms[5]);
        editor.putInt(PREFS_NAME_SLEEPINESS_Y, symptoms[6]);
        editor.putInt(PREFS_NAME_SLEEPINESS_N, symptoms[7]);
        editor.putInt(PREFS_NAME_HEART_DISEASE_Y, symptoms[8]);
        editor.putInt(PREFS_NAME_HEART_DISEASE_N,symptoms[9]);
        editor.putInt(PREFS_NAME_EMOTIONAL_LABILITY_Y, symptoms[10]);
        editor.putInt(PREFS_NAME_EMOTIONAL_LABILITY_N, symptoms[11]);
        editor.putInt(PREFS_NAME_MARK_0, markingManager.mark[0]);
        editor.putInt(PREFS_NAME_MARK_1, markingManager.mark[1]);
        editor.putInt(PREFS_NAME_MARK_2, markingManager.mark[2]);*/

        editor.commit();
    }

    public void getFinalScore(int score){
        if(age>=40)
            score=+10;
        if(weight/(((float)height/100)*((float)height/100))>=25)
            score=+10;


    }

    public Integer getAge() { return (age == -1)? null : Integer.valueOf(age); }

    public Integer getHeight() {
        return (height == -1)? null : Integer.valueOf(height);
    }

    public Integer getWeight() {
        return (weight == -1)? null : Integer.valueOf(weight);
    }


    public Integer getGender() { return (gender == -1)? null : Integer.valueOf(gender); }

    public Integer getTonsil() { return (tonsil == -1)? null : Integer.valueOf(tonsil); }

    public Integer getAlcohol() { return (alcohol == -1)? null : Integer.valueOf(alcohol); }

    public Integer getSmoke() { return (smoke == -1)? null : Integer.valueOf(smoke); }

    public Integer getHypnotic() { return (hypnotic == -1)? null : Integer.valueOf(hypnotic); }

    public Integer getBrain() { return (brain_tumor == -1)? null : Integer.valueOf(brain_tumor); }

    public Integer getFamily() { return (family_history == -1)? null : Integer.valueOf(family_history); }


    public int getPathogenesisMark(){
        if(age>=40)
            MainActivity.finalScore=+10;
        if(weight/(((float)height/100)*((float)height/100))>=25)
            MainActivity.finalScore=+10;

        return MainActivity.finalScore;

    }

    public int getFinalMark(){
        return (int)(markingManager.mark[0]*0.6+getPathogenesisMark()*0.16+markingManager.getSymptomMark()*0.24);
    }
}
