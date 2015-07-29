// Generated code from Butter Knife. Do not modify!
package ee3316.intoheart;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class LifestyleFragment$$ViewInjector<T extends ee3316.intoheart.LifestyleFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492988, "field 'alcohol_block'");
    target.alcohol_block = finder.castView(view, 2131492988, "field 'alcohol_block'");
    view = finder.findRequiredView(source, 2131492993, "field 'smoking_block'");
    target.smoking_block = finder.castView(view, 2131492993, "field 'smoking_block'");
    view = finder.findRequiredView(source, 2131493008, "field 'stay_up_late_block'");
    target.stay_up_late_block = finder.castView(view, 2131493008, "field 'stay_up_late_block'");
    view = finder.findRequiredView(source, 2131492998, "field 'overwork_block'");
    target.overwork_block = finder.castView(view, 2131492998, "field 'overwork_block'");
    view = finder.findRequiredView(source, 2131493003, "field 'eating_disorder_block'");
    target.eating_disorder_block = finder.castView(view, 2131493003, "field 'eating_disorder_block'");
    target.ratingBars = Finder.arrayOf(
        finder.<android.widget.RatingBar>findRequiredView(source, 2131492996, "field 'ratingBars'"),
        finder.<android.widget.RatingBar>findRequiredView(source, 2131492991, "field 'ratingBars'"),
        finder.<android.widget.RatingBar>findRequiredView(source, 2131493001, "field 'ratingBars'"),
        finder.<android.widget.RatingBar>findRequiredView(source, 2131493006, "field 'ratingBars'"),
        finder.<android.widget.RatingBar>findRequiredView(source, 2131493011, "field 'ratingBars'")
    );
    target.rateNotes = Finder.arrayOf(
        finder.<android.widget.TextView>findRequiredView(source, 2131492997, "field 'rateNotes'"),
        finder.<android.widget.TextView>findRequiredView(source, 2131492992, "field 'rateNotes'"),
        finder.<android.widget.TextView>findRequiredView(source, 2131493002, "field 'rateNotes'"),
        finder.<android.widget.TextView>findRequiredView(source, 2131493007, "field 'rateNotes'"),
        finder.<android.widget.TextView>findRequiredView(source, 2131493012, "field 'rateNotes'")
    );
  }

  @Override public void reset(T target) {
    target.alcohol_block = null;
    target.smoking_block = null;
    target.stay_up_late_block = null;
    target.overwork_block = null;
    target.eating_disorder_block = null;
    target.ratingBars = null;
    target.rateNotes = null;
  }
}
