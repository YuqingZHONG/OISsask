// Generated code from Butter Knife. Do not modify!
package ee3316.intoheart;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class AnalysisFragment$$ViewInjector<T extends ee3316.intoheart.AnalysisFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492969, "field 'aveText'");
    target.aveText = finder.castView(view, 2131492969, "field 'aveText'");
    view = finder.findRequiredView(source, 2131492968, "field 'minText'");
    target.minText = finder.castView(view, 2131492968, "field 'minText'");
    view = finder.findRequiredView(source, 2131492970, "field 'maxText'");
    target.maxText = finder.castView(view, 2131492970, "field 'maxText'");
    view = finder.findRequiredView(source, 2131492972, "field 'resultText'");
    target.resultText = finder.castView(view, 2131492972, "field 'resultText'");
  }

  @Override public void reset(T target) {
    target.aveText = null;
    target.minText = null;
    target.maxText = null;
    target.resultText = null;
  }
}
