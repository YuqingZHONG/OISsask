// Generated code from Butter Knife. Do not modify!
package ee3316.intoheart;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class AddFriendActivity$$ViewInjector<T extends ee3316.intoheart.AddFriendActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492948, "field 'searchView'");
    target.searchView = finder.castView(view, 2131492948, "field 'searchView'");
    view = finder.findRequiredView(source, 2131492949, "field 'resultBlock'");
    target.resultBlock = finder.castView(view, 2131492949, "field 'resultBlock'");
    view = finder.findRequiredView(source, 2131492950, "field 'userNameText'");
    target.userNameText = finder.castView(view, 2131492950, "field 'userNameText'");
    view = finder.findRequiredView(source, 2131492951, "field 'userEmailText'");
    target.userEmailText = finder.castView(view, 2131492951, "field 'userEmailText'");
    view = finder.findRequiredView(source, 2131492952, "method 'addFriend'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.addFriend(p0);
        }
      });
  }

  @Override public void reset(T target) {
    target.searchView = null;
    target.resultBlock = null;
    target.userNameText = null;
    target.userEmailText = null;
  }
}
