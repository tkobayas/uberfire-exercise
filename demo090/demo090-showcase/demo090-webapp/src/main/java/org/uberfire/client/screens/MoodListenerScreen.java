package org.uberfire.client.screens;

import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.uberfire.client.annotations.WorkbenchPartTitle;
import org.uberfire.client.annotations.WorkbenchPartView;
import org.uberfire.client.annotations.WorkbenchScreen;
import org.uberfire.shared.Mood;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

@Dependent
@Templated
@WorkbenchScreen( identifier = "MoodListenerScreen" )
public class MoodListenerScreen extends Composite {

    @Inject
    @DataField
    TextBox moodTextBox;

    @WorkbenchPartTitle
    public String getScreenTitle() {
        return "MoodListenerScreen";
    }


    public void onMoodChange( @Observes Mood mood ) {
        moodTextBox.setValue( "You are feeling " + mood.getText() );
    }


}