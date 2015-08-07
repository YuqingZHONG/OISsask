// Generated code from Butter Knife. Do not modify!
package ee3316.intoheart;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class MarkingActivity$$ViewInjector<T extends ee3316.intoheart.MarkingActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492957, "field 'heart_rate_score'");
    target.heart_rate_score = finder.castView(view, 2131492957, "field 'heart_rate_score'");
    view = finder.findRequiredView(source, 2131492956, "field 'exercise_score'");
    target.exercise_score = finder.castView(view, 2131492956, "field 'exercise_score'");
    view = finder.findRequiredView(source, 2131492958, "field 'life_style_score'");
    target.life_style_score = finder.castView(view, 2131492958, "field 'life_style_score'");
  }

  @Override public void reset(T target) {
    target.heart_rate_score = null;
    target.exercise_score = null;
    target.life_style_score = null;
  }
}
