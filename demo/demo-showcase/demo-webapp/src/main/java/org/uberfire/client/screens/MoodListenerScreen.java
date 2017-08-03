package org.uberfire.client.screens;

import org.jboss.errai.common.client.dom.Input;
import org.jboss.errai.ui.client.local.api.IsElement;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.uberfire.client.annotations.WorkbenchPartTitle;
import org.uberfire.client.annotations.WorkbenchPartView;
import org.uberfire.client.annotations.WorkbenchScreen;
import org.uberfire.shared.Mood;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@Dependent
@Templated
@WorkbenchScreen( identifier = "MoodListenerScreen" )
public class MoodListenerScreen implements IsElement {

    @Inject
    @DataField
    Input moodTextBox;

    @WorkbenchPartTitle
    public String getScreenTitle() {
        return "MoodListenerScreen";
    }

    @WorkbenchPartView
    public IsElement getView() {
        return this;
    }

    public void onMoodChange( @Observes Mood mood ) {
        moodTextBox.setValue( "You are feeling " + mood.getText() );
    }
}