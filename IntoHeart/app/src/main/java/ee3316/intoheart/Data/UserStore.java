package ee3316.intoheart.Data;

import android.content.Context;
import android.content.SharedPreferences;

import android.widget.Toast;
import android.widget.RadioButton;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


import ee3316.intoheart.HTTP.Outcome;
import ee3316.intoheart.MainActivity;
import ee3316.intoheart.R;


public class UserStore {
    private final String PREFERENCE = "apnea_out";
    private final String PREFS_NAME_NAME = "user_name";
    private final String PREFS_NAME_AGE = "user_age";
    private final String PREFS_NAME_HEIGHT = "user_height";
    private final String PREFS_NAME_WEIGHT = "user_weight";
    private final String PREFS_NAME_EMERGENCY_TEL = "user_emergency_tel";
    private final String PREFS_NAME_EMAIL = "user_email";
    private final String PREFS_NAME_PASSWORD = "user_password";
    private final String PREFS_NAME_SNORING = "user_snoring";
    private final String PREFS_NAME_HIGH_BLOOD_PRESSURE = "user_high_blood_pressure";
    private final String PREFS_NAME_INATTENTION = "user_inattention";
    private final String PREFS_NAME_SLEEPINESS = "user_sleepiness";
    private final String PREFS_NAME_HEART_DISEASE = "user_heart_disease";
    private final String PREFS_NAME_EMOTIONAL_LABILITY = "user_emotional_lability";
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
    private final String KEY_SAVED_RADIO_BUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX";


    public SharedPreferences settings;
    public int mark1=0;
    public int mark2=0;
    private Context context;
    public String name, email, password;
    public int gender,tonsil,alcohol,smoke,hypnotic,brain_tumor,family_history;
    public int age, height, weight;
    public int snore,blood,inattention,sleepiness,heart_disease,emotional_lability;
    public String emergencyTel;
    public int[] pathogenesis=new int [7];
    public int[] symptoms = new int[6];


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
        snore = settings.getInt(PREFS_NAME_SNORING, -1);
        blood = settings.getInt(PREFS_NAME_HIGH_BLOOD_PRESSURE, -1);
        inattention = settings.getInt(PREFS_NAME_INATTENTION, -1);
        sleepiness = settings.getInt(PREFS_NAME_SLEEPINESS, -1);
        heart_disease = settings.getInt(PREFS_NAME_HEART_DISEASE, -1);
        emotional_lability = settings.getInt(PREFS_NAME_EMOTIONAL_LABILITY, -1);
        markingManager.mark[0] = settings.getInt(PREFS_NAME_MARK_0, 0);
        markingManager.mark[1] = settings.getInt(PREFS_NAME_MARK_1, 0);
        markingManager.mark[2] = settings.getInt(PREFS_NAME_MARK_2, 0);

        for (int i = 0; i < pathogenesis.length; ++i) {
            pathogenesis[i] = settings.getInt(radioGroupStrings[i], -1); // -1 means undefined
        }


    }
    final String[] radioGroupStrings = new String[] {
            PREFS_NAME_SEX,
            PREFS_NAME_ENLARGED_TONSIL,
            PREFS_NAME_ALCOHOLISM,
            PREFS_NAME_SMOKE,
            PREFS_NAME_TAKE_HYPNOTIC,
            PREFS_NAME_BRAIN_TUMOR,
            PREFS_NAME_FAMILY_HISTORY
    };
    final String[] radioGroupStringsSymptoms = new String[] {
            PREFS_NAME_SNORING,
            PREFS_NAME_HIGH_BLOOD_PRESSURE,
            PREFS_NAME_INATTENTION,
            PREFS_NAME_SLEEPINESS,
            PREFS_NAME_HEART_DISEASE,
            PREFS_NAME_EMOTIONAL_LABILITY
    };



    public void save() {
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(PREFS_NAME_NAME, name);
        editor.putInt(PREFS_NAME_AGE, age);
        editor.putInt(PREFS_NAME_HEIGHT, height);
        editor.putInt(PREFS_NAME_WEIGHT, weight);
        editor.putString(PREFS_NAME_EMERGENCY_TEL, emergencyTel);
        editor.putString(PREFS_NAME_EMAIL, email);
        editor.putString(PREFS_NAME_PASSWORD, password);


        for (int i = 0; i < radioGroupStrings.length; ++i) {
            editor.putInt(radioGroupStrings[i], pathogenesis[i]);
        }
        for (int i = 0; i < radioGroupStringsSymptoms.length; ++i){
            editor.putInt(radioGroupStringsSymptoms[i],symptoms[i]);
        }



        editor.commit();
    }


    public Integer getAge() { return (age == -1)? null : Integer.valueOf(age); }

    public Integer getHeight() {
        return (height == -1)? null : Integer.valueOf(height);
    }

    public Integer getWeight() {
        return (weight == -1)? null : Integer.valueOf(weight);
    }




    public int getFinalMark(){
        float bmi=(float)weight/(((float)height/100)*((float)height/100));
        mark1=markingManager.getPathogenesisMark(pathogenesis,age,(int)bmi);
        mark2=markingManager.getSymptomMark(symptoms);
        return (int)(markingManager.mark[0]*0.6+mark1*0.16+mark2*0.24);
    }
}
