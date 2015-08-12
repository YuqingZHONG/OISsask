package ee3316.intoheart;

import android.app.Activity;
import android.content.SharedPreferences;
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
import butterknife.OnClick;
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
            R.id.snoring,
            R.id.highblood,
            R.id.inattention,
            R.id.sleepiness,
            R.id.heartdisease,
            R.id.emotional
            })RadioGroup[] radioGroups;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_symptom, container, false);
        setHasOptionsMenu(true);
        ButterKnife.inject(this, rootView);


        RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int buttonIndex = group.indexOfChild(group.findViewById(checkedId));
                int groupIndex = 0;
                for (int i = 0; i < radioGroups.length; ++i) {
                    if (radioGroups[i] == group) groupIndex = i;
                }
                System.out.printf("button %d:%d clicked\n", groupIndex, buttonIndex);
                userStore.symptoms[groupIndex] = buttonIndex;
            }
        };

        for (RadioGroup radioGroup: radioGroups) {
            radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);
        }
        {
            userStore = new UserStore(getActivity());

            updateContent();

            return rootView;
        }
    }
    private void updateContent(){
        for (int i = 0; i < radioGroups.length; ++i) {
            if (userStore.symptoms[i] < 0) continue;
            RadioButton radioButton = (RadioButton)radioGroups[i].getChildAt(userStore.symptoms[i]);
            radioButton.setChecked(true);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
    @OnClick(R.id.save_button_symptom)
    public void save(){
        userStore.snore=Integer.valueOf(radioGroups[0].getCheckedRadioButtonId());
        userStore.blood=Integer.valueOf(radioGroups[1].getCheckedRadioButtonId());
        userStore.inattention=Integer.valueOf(radioGroups[2].getCheckedRadioButtonId());
        userStore.sleepiness=Integer.valueOf(radioGroups[3].getCheckedRadioButtonId());
        userStore.heart_disease=Integer.valueOf(radioGroups[4].getCheckedRadioButtonId());
        userStore.emotional_lability=Integer.valueOf(radioGroups[5].getCheckedRadioButtonId());

        userStore.save();
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
