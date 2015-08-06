package ee3316.intoheart.Data;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.internal.app.ToolbarActionBar;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import ee3316.intoheart.HTTP.Connector;
import ee3316.intoheart.HTTP.JCallback;
import ee3316.intoheart.HTTP.Outcome;

public class UserStore {
    private final String PREFERENCE = "into_heart";
    private final String PREFS_NAME_NAME = "user_name";
    private final String PREFS_NAME_AGE = "user_age";
    private final String PREFS_NAME_HEIGHT = "user_height";
    private final String PREFS_NAME_WEIGHT = "user_weight";
    private final String PREFS_NAME_EMERGENCY_TEL = "user_emergency_tel";
    private final String PREFS_NAME_EMAIL = "user_email";
    private final String PREFS_NAME_PASSWORD = "user_password";
    private final String PREFS_NAME_RATE_SMOKE = "user_smoke_rate";
    private final String PREFS_NAME_RATE_DRINK = "user_drink_rate";
    private final String PREFS_NAME_RATE_OVERWORK = "user_ow_rate";
    private final String PREFS_NAME_RATE_DISORDER = "user_dis_rate";
    private final String PREFS_NAME_RATE_STAY_UP = "user_stay_rate";
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
    public float[] lifestyles = new float[5];

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
        lifestyles[0] = settings.getFloat(PREFS_NAME_RATE_SMOKE, 0);
        lifestyles[1] = settings.getFloat(PREFS_NAME_RATE_DRINK, 0);
        lifestyles[2] = settings.getFloat(PREFS_NAME_RATE_OVERWORK, 0);
        lifestyles[3] = settings.getFloat(PREFS_NAME_RATE_DISORDER, 0);
        lifestyles[4] = settings.getFloat(PREFS_NAME_RATE_STAY_UP, 0);
        markingManager.mark[0] = settings.getInt(PREFS_NAME_MARK_0, 100);
        markingManager.mark[1] = settings.getInt(PREFS_NAME_MARK_1, 100);
        markingManager.mark[2] = settings.getInt(PREFS_NAME_MARK_2, 100);
        syncLifestyle();
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

        editor.putInt(PREFS_NAME_SEX, gender);
        editor.putInt(PREFS_NAME_ENLARGED_TONSIL, tonsil);
        editor.putInt(PREFS_NAME_ALCOHOLISM, alcohol);
        editor.putInt(PREFS_NAME_SMOKE, smoke);
        editor.putInt(PREFS_NAME_TAKE_HYPNOTIC, hypnotic);
        editor.putInt(PREFS_NAME_BRAIN_TUMOR, brain_tumor);
        editor.putInt(PREFS_NAME_FAMILY_HISTORY, family_history);

        editor.putFloat(PREFS_NAME_RATE_SMOKE, lifestyles[0]);
        editor.putFloat(PREFS_NAME_RATE_DRINK, lifestyles[1]);
        editor.putFloat(PREFS_NAME_RATE_OVERWORK, lifestyles[2]);
        editor.putFloat(PREFS_NAME_RATE_DISORDER, lifestyles[3]);
        editor.putFloat(PREFS_NAME_RATE_STAY_UP, lifestyles[4]);
        editor.putInt(PREFS_NAME_MARK_0, markingManager.mark[0]);
        editor.putInt(PREFS_NAME_MARK_1, markingManager.mark[1]);
        editor.putInt(PREFS_NAME_MARK_2, markingManager.mark[2]);

        editor.commit();
        // update
        Connector connector = new Connector();
        if (getLogin())
            connector.updateUserInfo(email, password, String.format("{\"password\":\"%s\", \"name\":\"%s\", "
                    + "\"info\":{\"age\":%d, \"height\":%d, \"weight\":%d, \"phone\":\"%s\"," +
                            "\"gender\":\"%d\",\"tonsil\":\"%d\"," +"\"alcohol\":\"%d\",\"smoke\":\"%d\"," +
                            "\"hypnotic\":\"%d\",\"brain_tumor\":\"%d\",\"family_history\":\"%d\" "
                    + "\"lifestyles\":[%f,%f,%f,%f,%f], \"score\":%d, \"scoreDetail\":[%d,%d,%d]}}",
                    password, name, age, height, weight, emergencyTel,
                    gender,tonsil,alcohol,smoke,hypnotic,brain_tumor,family_history,
                    lifestyles[0], lifestyles[1], lifestyles[2], lifestyles[3], lifestyles[4],
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
                    if (jsonObject.get("gender")!=null)
                        gender=jsonObject.get("gender").getAsInt();
                    if (jsonObject.get("tonsil")!=null)
                        tonsil=jsonObject.get("tonsil").getAsInt();
                    if (jsonObject.get("alcohol")!=null)
                        alcohol=jsonObject.get("alcohol").getAsInt();
                    if (jsonObject.get("smoke")!=null)
                        smoke=jsonObject.get("smoke").getAsInt();
                    if (jsonObject.get("hypnotic")!=null)
                        hypnotic=jsonObject.get("hypnotic").getAsInt();
                    if (jsonObject.get("brain_tumor")!=null)
                        brain_tumor=jsonObject.get("brain_tumor").getAsInt();
                    if (jsonObject.get("family_history")!=null)
                        family_history=jsonObject.get("family_history").getAsInt();


                    if (jsonObject.get("lifestyles") != null) {
                        JsonArray lifestylesArray = jsonObject.get("lifestyles").getAsJsonArray();
                        for (int i = 0; i < lifestylesArray.size(); ++i) {
                            lifestyles[i] = lifestylesArray.get(i).getAsFloat();
                        }
                    }
                    save();
                    if (callback != null)
                        callback.call(new Outcome(true, ""));
                }
            }
        });
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



    public Boolean getLogin() {
        if (email == null) return false;
        if (email.isEmpty()) return false;
        if (password == null) return false;
        if (!email.isEmpty() && !password.isEmpty()) return true;
        return false;
    }

    public void syncLifestyle() {
        markingManager.evaluateLifestyle(lifestyles);
        save();
    }
}
