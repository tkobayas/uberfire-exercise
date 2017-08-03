package org.uberfire.client.perspectives;

import javax.inject.Inject;

import com.google.gwt.user.client.Window;
import org.jboss.errai.common.client.dom.Div;
import org.jboss.errai.ui.client.local.api.IsElement;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.uberfire.client.annotations.Perspective;
import org.uberfire.client.annotations.WorkbenchPanel;
import org.uberfire.client.annotations.WorkbenchPerspective;
import org.uberfire.client.workbench.panels.impl.MultiListWorkbenchPanelPresenter;
import org.uberfire.client.workbench.panels.impl.SimpleWorkbenchPanelPresenter;
import org.uberfire.lifecycle.OnOpen;
import org.uberfire.mvp.impl.DefaultPlaceRequest;
import org.uberfire.workbench.model.CompassPosition;
import org.uberfire.workbench.model.PanelDefinition;
import org.uberfire.workbench.model.PerspectiveDefinition;
import org.uberfire.workbench.model.impl.PanelDefinitionImpl;
import org.uberfire.workbench.model.impl.PartDefinitionImpl;
import org.uberfire.workbench.model.impl.PerspectiveDefinitionImpl;

@Templated
@WorkbenchPerspective(identifier = "MoodPerspective")
public class MoodPerspective implements IsElement {

//    @Inject
//    @DataField
//    @WorkbenchPanel(parts = "MoodScreen")
//    Div moodScreen;
//
//    @Inject
//    @DataField
//    @WorkbenchPanel(parts = "MoodListenerScreen")
//    Div moodListener;
    
    @Perspective
    public PerspectiveDefinition buildPerspective() {
        final PerspectiveDefinition p = new PerspectiveDefinitionImpl( MultiListWorkbenchPanelPresenter.class.getName() );
        p.setName( "MoodPerspective" );

        p.getRoot().addPart( new PartDefinitionImpl( new DefaultPlaceRequest( "MoodScreen" ) ) );
        
        final PanelDefinition east = new PanelDefinitionImpl( SimpleWorkbenchPanelPresenter.class.getName() );
        east.setWidth( 400 );
        east.addPart( new PartDefinitionImpl( new DefaultPlaceRequest( "MoodListenerScreen" ) ) );
        
        p.getRoot().insertChild(CompassPosition.EAST, east );

        return p;
    }
    
    @OnOpen
    public void onOpen() {
        Window.alert( "On Open" );
    }

    @org.uberfire.lifecycle.OnClose
    public void OnClose() {
        Window.alert( "On Close" );
    }
}