package org.uberfire.client.screens;


import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.uberfire.client.annotations.WorkbenchPartTitle;
import org.uberfire.client.annotations.WorkbenchPartView;
import org.uberfire.client.annotations.WorkbenchScreen;
import org.uberfire.shared.Mood;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;

@Dependent
@Templated
@WorkbenchScreen( identifier = "MoodScreen" )
public class MoodScreen extends Composite {

//    @Inject
//    @DataField
//    Form moodForm;

    @Inject
    @DataField
    TextBox moodTextBox;

    @Inject
    Event<Mood> moodEvent;

    @WorkbenchPartTitle
    public String getScreenTitle() {
        return "Change Mood";
    }


    @EventHandler("moodTextBox")
    private void onKeyDown(KeyDownEvent event) {
        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
            moodEvent.fire(new Mood(moodTextBox.getText()));
            moodTextBox.setText("");
        }
    }

}
