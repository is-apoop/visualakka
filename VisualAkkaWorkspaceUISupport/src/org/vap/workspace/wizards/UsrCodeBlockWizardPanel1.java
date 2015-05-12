/* 
 */
package org.vap.workspace.wizards;

import javax.swing.event.ChangeListener;
import org.openide.WizardDescriptor;
import org.openide.util.HelpCtx;
import org.vap.core.model.micro.Method;

public class UsrCodeBlockWizardPanel1 implements WizardDescriptor.Panel<WizardDescriptor> {

    /**
     * The visual component that displays this panel. If you need to access the
     * component from this class, just use getComponent().
     */
    private UsrCodeBlockVisualPanel1 component;

    // Get the visual component for the panel. In this template, the component
    // is kept separate. This can be more efficient: if the wizard is created
    // but never displayed, or not all panels are displayed, it is better to
    // create only those which really need to be visible.
    @Override
    public UsrCodeBlockVisualPanel1 getComponent() {
        if (component == null) {
            component = new UsrCodeBlockVisualPanel1();
        }
        return component;
    }

    @Override
    public HelpCtx getHelp() {
        // Show no Help button for this panel:
        return HelpCtx.DEFAULT_HELP;
        // If you have context help:
        // return new HelpCtx("help.key.here");
    }

    @Override
    public boolean isValid() {
        // If it is always OK to press Next or Finish, then:
        return true;
        // If it depends on some condition (form filled out...) and
        // this condition changes (last form field filled in...) then
        // use ChangeSupport to implement add/removeChangeListener below.
        // WizardDescriptor.ERROR/WARNING/INFORMATION_MESSAGE will also be useful.
    }

    @Override
    public void addChangeListener(ChangeListener l) {
    }

    @Override
    public void removeChangeListener(ChangeListener l) {
    }

//    @Override
//    public void readSettings(WizardDescriptor wiz) {
//        Method m = (Method) wiz.getProperty("method");
//        component.setMethodName(m.getName());
//    }
//
//    @Override
//    public void storeSettings(WizardDescriptor wiz) {
//        Method m = (Method) wiz.getProperty("method");
//        m.setName(component.getMethodName());
//    }
    
    @Override
    public void readSettings(WizardDescriptor wiz) {
        Method m = (Method) wiz.getProperty("method");
        component.updateSettings(m);
    }

    @Override
    public void storeSettings(WizardDescriptor wiz) {
        component.saveSettings();
    }

}
