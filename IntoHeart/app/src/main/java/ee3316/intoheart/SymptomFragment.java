package ee3316.intoheart;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.InjectViews;
import ee3316.intoheart.Data.UserStore;
import ee3316.intoheart.HTTP.JCallback;
import ee3316.intoheart.HTTP.Outcome;

/**
 * Created by Vivian on 6/8/15.
 */
public class SymptomFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    UserStore userStore;


    public static SymptomFragment newInstance(int sectionNumber) {
        SymptomFragment fragment = new SymptomFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public SymptomFragment(){

    }



    @InjectViews({
            R.id.ysnore_check,
            R.id.nsnore_check,
            R.id.yblood_check,
            R.id.nblood_check,
            R.id.yattention_check,
            R.id.nattention_check,
            R.id.ysleep_check,
            R.id.nsleep_check,
            R.id.yheart_check,
            R.id.nheart_check,
            R.id.ytesty_check,
            R.id.ntesty_check
            })RadioButton[] radioButtons;
    @InjectViews({
            R.id.snoring,
            R.id.highblood,
            R.id.inattention,
            R.id.sleepiness,
            R.id.heart,
            R.id.emotional
            })RadioGroup[] radioGroups;

    @InjectView(R.id.ysnore_check) RadioButton r0;
    @InjectView(R.id.nsnore_check) RadioButton r1;
    @InjectView(R.id.yblood_check) RadioButton r2;
    @InjectView(R.id.nblood_check) RadioButton r3;
    @InjectView(R.id.yattention_check) RadioButton r4;
    @InjectView(R.id.nattention_check) RadioButton r5;
    @InjectView(R.id.ysleep_check) RadioButton r6;
    @InjectView(R.id.nsleep_check) RadioButton r7;
    @InjectView(R.id.yheart_check) RadioButton r8;
    @InjectView(R.id.nheart_check) RadioButton r9;
    @InjectView(R.id.ytesty_check) RadioButton r10;
    @InjectView(R.id.ntesty_check) RadioButton r11;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_symptom, container, false);
        setHasOptionsMenu(true);
        {
            userStore = new UserStore(getActivity());

          //  updateContent();

            return rootView;
        }
      /* ButterKnife.inject(this, rootView);

        fetchSymptom = new JCallback<Outcome>() {
            @Override
            public void call(Outcome outcome) {
                userStore.fetch();
                for (int i = 0; i < 12; ++i)
                    radioButtons[i].setChecked(userStore.symptoms[i]);

            }
        };
        updateSymptom = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for(int i=0;i<6;++i) {
                    RadioButton checkedRadioButton = (RadioButton) radioGroups[i].findViewById(checkedId);

                }

                userStore.fetch();
                for (int i = 0; i < 12; ++i) {

                    userStore.symptoms[i] = radioButtons[i].isChecked();
                }
                userStore.save();
            }
        };
        userStore = new UserStore(getActivity());
        fetchSymptom.call(null);

        for (int i = 0; i < 6; ++i)
            radioGroups[i].setOnCheckedChangeListener(updateSymptom);
        return rootView;*/
    }



    public JCallback<Outcome> fetchSymptom;
    public RadioGroup.OnCheckedChangeListener updateSymptom;
/*
    private void updateContent() {
        for(int i=0; i<12;i++){
            if(userStore)
        }

        if (userStore.getGender() != null)
            genderEdit=(RadioGroup)genderEdit.findViewById(userStore.getGender());

        if (userStore.getTonsil() != null)
            tonsilEdit=(RadioGroup)tonsilEdit.findViewById(userStore.getTonsil());
        if (userStore.getAlcohol() != null)
            alcoholEdit=(RadioGroup)alcoholEdit.findViewById(userStore.getAlcohol());

        if (userStore.getSmoke() != null)
            smokeEdit=(RadioGroup)smokeEdit.findViewById(userStore.getSmoke());

        if (userStore.getHypnotic() != null)
            sedativeEdit=(RadioGroup)sedativeEdit.findViewById(userStore.getHypnotic());

        if (userStore.getBrain() != null)
            brainEdit=(RadioGroup)brainEdit.findViewById(userStore.getBrain());

        if (userStore.getFamily() != null)
            familyEdit=(RadioGroup)familyEdit.findViewById(userStore.getFamily());


    }
*/

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }


    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}
