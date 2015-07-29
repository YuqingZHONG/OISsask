// Generated code from Butter Knife. Do not modify!
package ee3316.intoheart;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class RankingFragment$$ViewInjector<T extends ee3316.intoheart.RankingFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492961, "field 'finalScoreView'");
    target.finalScoreView = finder.castView(view, 2131492961, "field 'finalScoreView'");
    view = finder.findRequiredView(source, 2131492963, "field 'heart_rate_score'");
    target.heart_rate_score = finder.castView(view, 2131492963, "field 'heart_rate_score'");
    view = finder.findRequiredView(source, 2131492962, "field 'exercise_score'");
    target.exercise_score = finder.castView(view, 2131492962, "field 'exercise_score'");
    view = finder.findRequiredView(source, 2131492964, "field 'life_style_score'");
    target.life_style_score = finder.castView(view, 2131492964, "field 'life_style_score'");
    view = finder.findRequiredView(source, 2131493022, "field 'listView'");
    target.listView = finder.castView(view, 2131493022, "field 'listView'");
  }

  @Override public void reset(T target) {
    target.finalScoreView = null;
    target.heart_rate_score = null;
    target.exercise_score = null;
    target.life_style_score = null;
    target.listView = null;
  }
}
