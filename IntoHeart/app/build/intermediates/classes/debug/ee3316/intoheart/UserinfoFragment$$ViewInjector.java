// Generated code from Butter Knife. Do not modify!
package ee3316.intoheart;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class UserinfoFragment$$ViewInjector<T extends ee3316.intoheart.UserinfoFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131493036, "field 'login_block'");
    target.login_block = finder.castView(view, 2131493036, "field 'login_block'");
    view = finder.findRequiredView(source, 2131493039, "field 'logout_block'");
    target.logout_block = finder.castView(view, 2131493039, "field 'logout_block'");
    view = finder.findRequiredView(source, 2131492965, "field 'nameEdit'");
    target.nameEdit = finder.castView(view, 2131492965, "field 'nameEdit'");
    view = finder.findRequiredView(source, 2131493026, "field 'ageEdit'");
    target.ageEdit = finder.castView(view, 2131493026, "field 'ageEdit'");
    view = finder.findRequiredView(source, 2131493028, "field 'heightEdit'");
    target.heightEdit = finder.castView(view, 2131493028, "field 'heightEdit'");
    view = finder.findRequiredView(source, 2131493030, "field 'weightPicker'");
    target.weightPicker = finder.castView(view, 2131493030, "field 'weightPicker'");
    view = finder.findRequiredView(source, 2131493031, "field 'weightPicker2'");
    target.weightPicker2 = finder.castView(view, 2131493031, "field 'weightPicker2'");
    view = finder.findRequiredView(source, 2131493032, "field 'weightPicker3'");
    target.weightPicker3 = finder.castView(view, 2131493032, "field 'weightPicker3'");
    view = finder.findRequiredView(source, 2131493034, "field 'emergencyEdit'");
    target.emergencyEdit = finder.castView(view, 2131493034, "field 'emergencyEdit'");
    view = finder.findRequiredView(source, 2131493035, "method 'save'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.save();
        }
      });
    view = finder.findRequiredView(source, 2131493038, "method 'loginPrompt'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.loginPrompt(p0);
        }
      });
    view = finder.findRequiredView(source, 2131493037, "method 'registerPrompt'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.registerPrompt(p0);
        }
      });
    view = finder.findRequiredView(source, 2131493040, "method 'logout'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.logout();
        }
      });
  }

  @Override public void reset(T target) {
    target.login_block = null;
    target.logout_block = null;
    target.nameEdit = null;
    target.ageEdit = null;
    target.heightEdit = null;
    target.weightPicker = null;
    target.weightPicker2 = null;
    target.weightPicker3 = null;
    target.emergencyEdit = null;
  }
}
