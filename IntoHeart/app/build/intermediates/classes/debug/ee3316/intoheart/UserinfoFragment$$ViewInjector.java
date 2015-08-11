// Generated code from Butter Knife. Do not modify!
package ee3316.intoheart;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class UserinfoFragment$$ViewInjector<T extends ee3316.intoheart.UserinfoFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492959, "field 'nameEdit'");
    target.nameEdit = finder.castView(view, 2131492959, "field 'nameEdit'");
    view = finder.findRequiredView(source, 2131493043, "field 'ageEdit'");
    target.ageEdit = finder.castView(view, 2131493043, "field 'ageEdit'");
    view = finder.findRequiredView(source, 2131493048, "field 'heightEdit'");
    target.heightEdit = finder.castView(view, 2131493048, "field 'heightEdit'");
    view = finder.findRequiredView(source, 2131493049, "field 'weightPicker'");
    target.weightPicker = finder.castView(view, 2131493049, "field 'weightPicker'");
    view = finder.findRequiredView(source, 2131493050, "field 'weightPicker2'");
    target.weightPicker2 = finder.castView(view, 2131493050, "field 'weightPicker2'");
    view = finder.findRequiredView(source, 2131493051, "field 'weightPicker3'");
    target.weightPicker3 = finder.castView(view, 2131493051, "field 'weightPicker3'");
    view = finder.findRequiredView(source, 2131493075, "field 'emergencyEdit'");
    target.emergencyEdit = finder.castView(view, 2131493075, "field 'emergencyEdit'");
    view = finder.findRequiredView(source, 2131493045, "field 'genderEdit'");
    target.genderEdit = finder.castView(view, 2131493045, "field 'genderEdit'");
    view = finder.findRequiredView(source, 2131493053, "field 'tonsilEdit'");
    target.tonsilEdit = finder.castView(view, 2131493053, "field 'tonsilEdit'");
    view = finder.findRequiredView(source, 2131493056, "field 'alcoholEdit'");
    target.alcoholEdit = finder.castView(view, 2131493056, "field 'alcoholEdit'");
    view = finder.findRequiredView(source, 2131493060, "field 'smokeEdit'");
    target.smokeEdit = finder.castView(view, 2131493060, "field 'smokeEdit'");
    view = finder.findRequiredView(source, 2131493064, "field 'sedativeEdit'");
    target.sedativeEdit = finder.castView(view, 2131493064, "field 'sedativeEdit'");
    view = finder.findRequiredView(source, 2131493068, "field 'brainEdit'");
    target.brainEdit = finder.castView(view, 2131493068, "field 'brainEdit'");
    view = finder.findRequiredView(source, 2131493072, "field 'familyEdit'");
    target.familyEdit = finder.castView(view, 2131493072, "field 'familyEdit'");
    view = finder.findRequiredView(source, 2131493076, "method 'save'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.save();
        }
      });
  }

  @Override public void reset(T target) {
    target.nameEdit = null;
    target.ageEdit = null;
    target.heightEdit = null;
    target.weightPicker = null;
    target.weightPicker2 = null;
    target.weightPicker3 = null;
    target.emergencyEdit = null;
    target.genderEdit = null;
    target.tonsilEdit = null;
    target.alcoholEdit = null;
    target.smokeEdit = null;
    target.sedativeEdit = null;
    target.brainEdit = null;
    target.familyEdit = null;
  }
}
