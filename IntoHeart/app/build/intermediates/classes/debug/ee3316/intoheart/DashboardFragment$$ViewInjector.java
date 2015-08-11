// Generated code from Butter Knife. Do not modify!
package ee3316.intoheart;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class DashboardFragment$$ViewInjector<T extends ee3316.intoheart.DashboardFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492999, "field 'sleep'");
    target.sleep = finder.castView(view, 2131492999, "field 'sleep'");
    view = finder.findRequiredView(source, 2131493001, "field 'heart'");
    target.heart = finder.castView(view, 2131493001, "field 'heart'");
    view = finder.findRequiredView(source, 2131493006, "field 'graph'");
    target.graph = finder.castView(view, 2131493006, "field 'graph'");
    view = finder.findRequiredView(source, 2131493002, "method 'showInstantView'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.showInstantView(p0);
        }
      });
    view = finder.findRequiredView(source, 2131493003, "method 'showDayView'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.showDayView(p0);
        }
      });
    view = finder.findRequiredView(source, 2131493004, "method 'showWeekView'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.showWeekView(p0);
        }
      });
    view = finder.findRequiredView(source, 2131493005, "method 'showMonthView'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.showMonthView(p0);
        }
      });
  }

  @Override public void reset(T target) {
    target.sleep = null;
    target.heart = null;
    target.graph = null;
  }
}
