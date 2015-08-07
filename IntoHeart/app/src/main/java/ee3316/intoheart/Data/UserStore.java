package ee3316.intoheart.Data;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.internal.app.ToolbarActionBar;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioButton;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import android.os.Bundle;
import org.json.JSONObject;

import butterknife.InjectView;
import ee3316.intoheart.HTTP.Connector;
import ee3316.intoheart.HTTP.JCallback;
import ee3316.intoheart.HTTP.Outcome;
import ee3316.intoheart.MainActivity;

/**
 * Created by aahung on 3/31/15.
 */
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

    public SharedPreferences settings;

    private Context context;
    public String name, email, password;
    public int age, height, weight;
    public String emergencyTel;
    public boolean[] symptoms = new boolean[12];
    public RadioButton r0,r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11;



    public MarkingManager markingManager = new MarkingManager();

    public UserStore(Context context) {
        this.context = context;
        settings = context.getSharedPreferences(PREFERENCE, 0);
        fetch();
    }

    public void fetch() {
        name = settings.getString(PREFS_NAME_NAME, null);
        email = settings.getString(PREFS_NAME_EMAIL, null);
        password = settings.getString(PREFS_NAME_PASSWORD, null);
        emergencyTel = settings.getString(PREFS_NAME_EMERGENCY_TEL, null);
        age = settings.getInt(PREFS_NAME_AGE, -1);
        height = settings.getInt(PREFS_NAME_HEIGHT, -1);
        weight = settings.getInt(PREFS_NAME_WEIGHT, -1);
        symptoms[0] = settings.getBoolean(PREFS_NAME_SNORING_Y, false);
        symptoms[1] = settings.getBoolean(PREFS_NAME_SNORING_N, false);
        symptoms[2] = settings.getBoolean(PREFS_NAME_HIGH_BLOOD_PRESSURE_Y, false);
        symptoms[3] = settings.getBoolean(PREFS_NAME_HIGH_BLOOD_PRESSURE_N, false);
        symptoms[4] = settings.getBoolean(PREFS_NAME_INATTENTION_Y, false);
        symptoms[5] = settings.getBoolean(PREFS_NAME_INATTENTION_N, false);
        symptoms[6] = settings.getBoolean(PREFS_NAME_SLEEPINESS_Y, false);
        symptoms[7] = settings.getBoolean(PREFS_NAME_SLEEPINESS_N, false);
        symptoms[8] = settings.getBoolean(PREFS_NAME_HEART_DISEASE_Y, false);
        symptoms[9] = settings.getBoolean(PREFS_NAME_HEART_DISEASE_N, false);
        symptoms[10] = settings.getBoolean(PREFS_NAME_EMOTIONAL_LABILITY_Y, false);
        symptoms[11] = settings.getBoolean(PREFS_NAME_EMOTIONAL_LABILITY_N, false);
        markingManager.mark[0] = settings.getInt(PREFS_NAME_MARK_0, 100);
        markingManager.mark[1] = settings.getInt(PREFS_NAME_MARK_1, 100);
        markingManager.mark[2] = settings.getInt(PREFS_NAME_MARK_2, 100);
        syncSymptom();
<<<<<<< Updated upstream
=======
        syncPathogenesis();
>>>>>>> Stashed changes
    }

    public void saveUserLogin() {
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(PREFS_NAME_EMAIL, email);
        editor.putString(PREFS_NAME_PASSWORD, password);
        editor.commit();
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
        editor.putBoolean(PREFS_NAME_SNORING_Y,r0.isChecked());
        editor.putBoolean(PREFS_NAME_SNORING_N,r1.isChecked());
        editor.putBoolean(PREFS_NAME_HIGH_BLOOD_PRESSURE_Y,r2.isChecked());
        editor.putBoolean(PREFS_NAME_HIGH_BLOOD_PRESSURE_N,r3.isChecked());
        editor.putBoolean(PREFS_NAME_INATTENTION_Y,r4.isChecked());
        editor.putBoolean(PREFS_NAME_INATTENTION_N,r5.isChecked());
        editor.putBoolean(PREFS_NAME_SLEEPINESS_Y,r6.isChecked());
        editor.putBoolean(PREFS_NAME_SLEEPINESS_N,r7.isChecked());
        editor.putBoolean(PREFS_NAME_HEART_DISEASE_Y,r8.isChecked());
        editor.putBoolean(PREFS_NAME_HEART_DISEASE_N,r9.isChecked());
        editor.putBoolean(PREFS_NAME_EMOTIONAL_LABILITY_Y,r10.isChecked());
        editor.putBoolean(PREFS_NAME_EMOTIONAL_LABILITY_N,r11.isChecked());
        editor.putInt(PREFS_NAME_MARK_0, markingManager.mark[0]);
        editor.putInt(PREFS_NAME_MARK_1, markingManager.mark[1]);
        editor.putInt(PREFS_NAME_MARK_2, markingManager.mark[2]);
        editor.commit();
        // update
        Connector connector = new Connector();
        if (getLogin())
            connector.updateUserInfo(email, password, String.format("{\"password\":\"%s\", \"name\":\"%s\", "
                    + "\"info\":{\"age\":%d, \"height\":%d, \"weight\":%d, \"phone\":\"%s\", "
                    + "\"lifestyles\":[%f,%f,%f,%f,%f], \"score\":%d, \"scoreDetail\":[%d,%d,%d]}}",
                    password, name, age, height, weight, emergencyTel,
                    symptoms[0], symptoms[1], symptoms[2], symptoms[3], symptoms[4],symptoms[5],symptoms[6],symptoms[7],symptoms[8],symptoms[9],symptoms[10],symptoms[11],
                    markingManager.getFinalMark(), markingManager.mark[0],
                    markingManager.mark[1], markingManager.mark[2]), new JCallback<Outcome>() {
                @Override
                public void call(Outcome outcome) {
                    if (outcome.success) {
//                        Toast.makeText(context, "your info has been updated", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, outcome.getString(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
    }

    public void fetchFromOnline(final JCallback<Outcome> callback) {
        Connector connector = new Connector();
        connector.getUserInfo(email, password, new JCallback<Outcome>() {
            @Override
            public void call(Outcome outcome) {
                if (outcome.success) {
                    JsonObject jsonObject = (JsonObject) outcome.object;
                    if (jsonObject.get("age") != null)
                        age = jsonObject.get("age").getAsInt();
                    if (jsonObject.get("height") != null)
                        height = jsonObject.get("height").getAsInt();
                    if (jsonObject.get("weight") != null)
                        weight = jsonObject.get("weight").getAsInt();
                    if (jsonObject.get("phone") != null)
                        emergencyTel = jsonObject.get("phone").getAsString();
                    if (jsonObject.get("symptoms") != null) {
                        JsonArray symptomsArray = jsonObject.get("symptoms").getAsJsonArray();
                        for (int i = 0; i < symptomsArray.size(); ++i) {
                            symptoms[i] = symptomsArray.get(i).getAsBoolean();
                        }
                    }
                    save();
                    if (callback != null)
                        callback.call(new Outcome(true, ""));
                }
            }
        });
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

<<<<<<< Updated upstream
    public boolean getLogin() {
=======
    public Integer getGender() { return (gender == -1)? null : Integer.valueOf(gender); }

    public Integer getTonsil() { return (tonsil == -1)? null : Integer.valueOf(tonsil); }

    public Integer getAlcohol() { return (alcohol == -1)? null : Integer.valueOf(alcohol); }

    public Integer getSmoke() { return (smoke == -1)? null : Integer.valueOf(smoke); }

    public Integer getHypnotic() { return (hypnotic == -1)? null : Integer.valueOf(hypnotic); }

    public Integer getBrain() { return (brain_tumor == -1)? null : Integer.valueOf(brain_tumor); }

    public Integer getFamily() { return (family_history == -1)? null : Integer.valueOf(family_history); }




    public Boolean getLogin() {
>>>>>>> Stashed changes
        if (email == null) return false;
        if (email.isEmpty()) return false;
        if (password == null) return false;
        if (!email.isEmpty() && !password.isEmpty()) return true;
        return false;
    }

    public void syncSymptom() {
<<<<<<< Updated upstream
        markingManager.evaluateSymptom(symptoms);
=======
        markingManager.evaluateSymptom(lifestyles);
>>>>>>> Stashed changes
        save();
    }

    public void syncPathogenesis(){
        getFinalScore(MainActivity.finalScore);
        save();
    }

    public int getPathogenesisMark(){
        if(age>=40)
            MainActivity.finalScore=+10;
        if(weight/(((float)height/100)*((float)height/100))>=25)
            MainActivity.finalScore=+10;

        return MainActivity.finalScore;

    }

    public int getFinalMark(){
        return (int)(markingManager.mark[0]*0.6+getPathogenesisMark()*0.16+markingManager.mark[2]*0.24);
    }
}
