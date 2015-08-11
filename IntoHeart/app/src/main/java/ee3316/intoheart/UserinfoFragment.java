package ee3316.intoheart;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RadioGroup;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import ee3316.intoheart.Data.UserStore;
import ee3316.intoheart.HTTP.JCallback;
import ee3316.intoheart.HTTP.Outcome;
import ee3316.intoheart.UIComponent.SimpleAlertController;

/**
 * Created by aahung on 3/7/15.
 */
public class UserinfoFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    UserStore userStore;


    public static UserinfoFragment newInstance(int sectionNumber) {
        UserinfoFragment fragment = new UserinfoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public UserinfoFragment() {

    }

    @InjectView(R.id.name_edit) EditText nameEdit;
    @InjectView(R.id.age_edit) EditText ageEdit;
    @InjectView(R.id.height_edit) EditText heightEdit;
    @InjectView(R.id.weightPicker)
    NumberPicker weightPicker;
    @InjectView(R.id.weightPicker2)
    NumberPicker weightPicker2;
    @InjectView(R.id.weightPicker3)
    NumberPicker weightPicker3;
    @InjectView(R.id.emergency_edit) EditText emergencyEdit;

    @InjectView(R.id.gender_edit)
    RadioGroup genderEdit;
    @InjectView(R.id.tonsil_edit)
    RadioGroup tonsilEdit;
    @InjectView(R.id.alcohol_edit)
    RadioGroup alcoholEdit;
    @InjectView(R.id.smoke_edit)
    RadioGroup smokeEdit;
    @InjectView(R.id.sedative_edit)
    RadioGroup sedativeEdit;
    @InjectView(R.id.brain_edit)
    RadioGroup brainEdit;
    @InjectView(R.id.family_edit)
    RadioGroup familyEdit;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_userinfo, container, false);
        setHasOptionsMenu(true);
        ButterKnife.inject(this, rootView);
        {
            userStore = new UserStore(getActivity());

            updateContent();

            return rootView;
        }
    }

    private void updateContent() {
        nameEdit.setText(userStore.name);
        if (userStore.getAge() != null)
            ageEdit.setText(userStore.getAge().toString());
        if (userStore.getHeight() != null)
            heightEdit.setText(userStore.getHeight().toString());
        weightPicker.setMaxValue(9);weightPicker.setMinValue(0);
        weightPicker2.setMaxValue(9);weightPicker2.setMinValue(0);
        weightPicker3.setMaxValue(9);weightPicker3.setMinValue(0);
        if (userStore.getWeight() != null) {
            int weight = userStore.getWeight().intValue();
            weightPicker.setValue(weight / 100);
            weightPicker2.setValue(weight % 100 / 10);
            weightPicker3.setValue(weight % 10);
        }
        emergencyEdit.setText(userStore.emergencyTel);

        if (userStore.getGender() != null)
           genderEdit.check(userStore.getGender());

        if (userStore.getTonsil() != null)
            tonsilEdit.check(userStore.getTonsil());
        if (userStore.getAlcohol() != null)
            alcoholEdit.check(userStore.getAlcohol());

        if (userStore.getSmoke() != null)
            smokeEdit.check(userStore.getSmoke());

        if (userStore.getHypnotic() != null)
            sedativeEdit.check(userStore.getHypnotic());

        if (userStore.getBrain() != null)
            brainEdit.check(userStore.getBrain());

        if (userStore.getFamily() != null)
            familyEdit.check(userStore.getFamily());


    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }



    @OnClick(R.id.save_button)
    public void save() {
        userStore.name = nameEdit.getText().toString().trim();
        userStore.emergencyTel = emergencyEdit.getText().toString().trim();
        try {
            userStore.age = Integer.valueOf(ageEdit.getText().toString());
        } catch (Exception ex) {}
        try {
            userStore.height = Integer.valueOf(heightEdit.getText().toString());
        } catch (Exception ex) {}
        int weight = weightPicker.getValue() * 100 + weightPicker2.getValue() * 10 + weightPicker3.getValue();
        userStore.weight = Integer.valueOf(weight);

        userStore.gender=Integer.valueOf(genderEdit.getCheckedRadioButtonId());
        userStore.tonsil=Integer.valueOf(tonsilEdit.getCheckedRadioButtonId());
        userStore.alcohol=Integer.valueOf(alcoholEdit.getCheckedRadioButtonId());
        userStore.smoke=Integer.valueOf(smokeEdit.getCheckedRadioButtonId());
        userStore.hypnotic=Integer.valueOf(sedativeEdit.getCheckedRadioButtonId());
        userStore.brain_tumor=Integer.valueOf(brainEdit.getCheckedRadioButtonId());
        userStore.family_history=Integer.valueOf(familyEdit.getCheckedRadioButtonId());


        userStore.save();
    }





}
