// Generated code from Butter Knife. Do not modify!
package ee3316.intoheart;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class AnalysisFragment$$ViewInjector<T extends ee3316.intoheart.AnalysisFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492963, "field 'aveText'");
    target.aveText = finder.castView(view, 2131492963, "field 'aveText'");
    view = finder.findRequiredView(source, 2131492962, "field 'minText'");
    target.minText = finder.castView(view, 2131492962, "field 'minText'");
    view = finder.findRequiredView(source, 2131492964, "field 'maxText'");
    target.maxText = finder.castView(view, 2131492964, "field 'maxText'");
    view = finder.findRequiredView(source, 2131492972, "field 'resultText'");
    target.resultText = finder.castView(view, 2131492972, "field 'resultText'");
    view = finder.findRequiredView(source, 2131492968, "field 'pathogenic_score'");
    target.pathogenic_score = finder.castView(view, 2131492968, "field 'pathogenic_score'");
    view = finder.findRequiredView(source, 2131492966, "field 'sleep_apnea_score'");
    target.sleep_apnea_score = finder.castView(view, 2131492966, "field 'sleep_apnea_score'");
    view = finder.findRequiredView(source, 2131492970, "field 'symptom_score'");
    target.symptom_score = finder.castView(view, 2131492970, "field 'symptom_score'");
    view = finder.findRequiredView(source, 2131492955, "field 'finalScoreView'");
    target.finalScoreView = finder.castView(view, 2131492955, "field 'finalScoreView'");
  }

  @Override public void reset(T target) {
    target.aveText = null;
    target.minText = null;
    target.maxText = null;
    target.resultText = null;
    target.pathogenic_score = null;
    target.sleep_apnea_score = null;
    target.symptom_score = null;
    target.finalScoreView = null;
  }
}
