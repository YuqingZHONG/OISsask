package ee3316.intoheart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ee3316.intoheart.Data.HeartRateStoreController;
import ee3316.intoheart.Data.UserStore;


public class AnalysisFragment extends Fragment {


    private static final String ARG_SECTION_NUMBER = "section_number";
    UserStore userStore;


    public static AnalysisFragment newInstance(int sectionNumber) {
        AnalysisFragment fragment = new AnalysisFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public AnalysisFragment() {

    }
    @InjectView(R.id.textAve)
    TextView aveText;
    @InjectView(R.id.textMin)
    TextView minText;
    @InjectView(R.id.textMax)
    TextView maxText;

    @InjectView(R.id.result_text)
    TextView resultText;

    @InjectView(R.id.pathogenic_score)
    TextView pathogenic_score;
    @InjectView(R.id.sleep_apnea_score)
    TextView sleep_apnea_score;
    @InjectView(R.id.symptom_score)
    TextView symptom_score;

    @InjectView(R.id.final_score_view)
    TextView finalScoreView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_analysis, container, false);
        setHasOptionsMenu(true);

        ButterKnife.inject(this,rootView);

       userStore = new UserStore(getActivity());
        finalScoreView.setText(String.valueOf(userStore.getFinalMark()));
        sleep_apnea_score.setText(String.valueOf(userStore.markingManager.getApneaMark()));
        pathogenic_score.setText(String.valueOf(userStore.getPathogenesisMark()));
        symptom_score.setText(String.valueOf(userStore.markingManager.getSymptomMark()));

        Button btn_slow=(Button)rootView.findViewById(R.id.sleep_apnea);
        btn_slow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), ApneaDetailActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }

    @Override
    public void onResume() {
        super.onResume();
        HeartRateStoreController.AnalysisResult analysisResult = ((MainActivity) getActivity()).heartRateStoreController.getDayAnalysis();
        aveText.setText(String.valueOf((int)analysisResult.average));
        minText.setText(String.valueOf((int)analysisResult.min));
        maxText.setText(String.valueOf((int)analysisResult.max));
        if (analysisResult.max-analysisResult.min > 40) resultText.setText("You might have sleep apnea.");
        else resultText.setText("Your sleep quality looks nice.");

        pathogenic_score.setText(String.valueOf(userStore.getPathogenesisMark()));
        sleep_apnea_score.setText(String.valueOf(userStore.markingManager.getApneaMark()));
        symptom_score.setText(String.valueOf(userStore.markingManager.getSymptomMark()));
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
