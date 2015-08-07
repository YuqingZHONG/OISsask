// Generated code from Butter Knife. Do not modify!
package ee3316.intoheart;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class LifestyleFragment$$ViewInjector<T extends ee3316.intoheart.LifestyleFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    target.ratingBars = Finder.arrayOf(
        finder.<android.widget.RatingBar>findRequiredView(source, 2131492983, "field 'ratingBars'"),
        finder.<android.widget.RatingBar>findRequiredView(source, 2131492978, "field 'ratingBars'"),
        finder.<android.widget.RatingBar>findRequiredView(source, 2131492988, "field 'ratingBars'"),
        finder.<android.widget.RatingBar>findRequiredView(source, 2131492993, "field 'ratingBars'"),
        finder.<android.widget.RatingBar>findRequiredView(source, 2131492998, "field 'ratingBars'")
    );
    target.rateNotes = Finder.arrayOf(
        finder.<android.widget.TextView>findRequiredView(source, 2131492984, "field 'rateNotes'"),
        finder.<android.widget.TextView>findRequiredView(source, 2131492979, "field 'rateNotes'"),
        finder.<android.widget.TextView>findRequiredView(source, 2131492989, "field 'rateNotes'"),
        finder.<android.widget.TextView>findRequiredView(source, 2131492994, "field 'rateNotes'"),
        finder.<android.widget.TextView>findRequiredView(source, 2131492999, "field 'rateNotes'")
    );
  }

  @Override public void reset(T target) {
    target.ratingBars = null;
    target.rateNotes = null;
  }
}
