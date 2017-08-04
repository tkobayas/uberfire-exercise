package org.jboss.errai.ioc.client;

import com.allen_sauer.gwt.dnd.client.AbstractDragController;
import com.allen_sauer.gwt.dnd.client.DragController;
import com.allen_sauer.gwt.dnd.client.FiresDragEvents;
import com.allen_sauer.gwt.dnd.client.PickupDragController;
import com.allen_sauer.gwt.dnd.client.drop.DropController;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasAllDragAndDropHandlers;
import com.google.gwt.event.dom.client.HasAllFocusHandlers;
import com.google.gwt.event.dom.client.HasAllGestureHandlers;
import com.google.gwt.event.dom.client.HasAllKeyHandlers;
import com.google.gwt.event.dom.client.HasAllMouseHandlers;
import com.google.gwt.event.dom.client.HasAllTouchHandlers;
import com.google.gwt.event.dom.client.HasBlurHandlers;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasDoubleClickHandlers;
import com.google.gwt.event.dom.client.HasDragEndHandlers;
import com.google.gwt.event.dom.client.HasDragEnterHandlers;
import com.google.gwt.event.dom.client.HasDragHandlers;
import com.google.gwt.event.dom.client.HasDragLeaveHandlers;
import com.google.gwt.event.dom.client.HasDragOverHandlers;
import com.google.gwt.event.dom.client.HasDragStartHandlers;
import com.google.gwt.event.dom.client.HasDropHandlers;
import com.google.gwt.event.dom.client.HasFocusHandlers;
import com.google.gwt.event.dom.client.HasGestureChangeHandlers;
import com.google.gwt.event.dom.client.HasGestureEndHandlers;
import com.google.gwt.event.dom.client.HasGestureStartHandlers;
import com.google.gwt.event.dom.client.HasKeyDownHandlers;
import com.google.gwt.event.dom.client.HasKeyPressHandlers;
import com.google.gwt.event.dom.client.HasKeyUpHandlers;
import com.google.gwt.event.dom.client.HasMouseDownHandlers;
import com.google.gwt.event.dom.client.HasMouseMoveHandlers;
import com.google.gwt.event.dom.client.HasMouseOutHandlers;
import com.google.gwt.event.dom.client.HasMouseOverHandlers;
import com.google.gwt.event.dom.client.HasMouseUpHandlers;
import com.google.gwt.event.dom.client.HasMouseWheelHandlers;
import com.google.gwt.event.dom.client.HasTouchCancelHandlers;
import com.google.gwt.event.dom.client.HasTouchEndHandlers;
import com.google.gwt.event.dom.client.HasTouchMoveHandlers;
import com.google.gwt.event.dom.client.HasTouchStartHandlers;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.logical.shared.HasAttachHandlers;
import com.google.gwt.event.logical.shared.HasBeforeSelectionHandlers;
import com.google.gwt.event.logical.shared.HasCloseHandlers;
import com.google.gwt.event.logical.shared.HasSelectionHandlers;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.i18n.client.AutoDirectionHandler.Target;
import com.google.gwt.i18n.client.HasDirection;
import com.google.gwt.i18n.shared.HasDirectionEstimator;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ClientBundle.Source;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.safehtml.client.HasSafeHtml;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.TakesValue;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.Focusable;
import com.google.gwt.user.client.ui.HasConstrainedValue;
import com.google.gwt.user.client.ui.HasDirectionalSafeHtml;
import com.google.gwt.user.client.ui.HasDirectionalText;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasFocus;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasVisibility;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.HasWidgets.ForIsWidget;
import com.google.gwt.user.client.ui.HasWordWrap;
import com.google.gwt.user.client.ui.HeaderPanel;
import com.google.gwt.user.client.ui.IndexedPanel;
import com.google.gwt.user.client.ui.InsertPanel;
import com.google.gwt.user.client.ui.IsRenderable;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.ProvidesResize;
import com.google.gwt.user.client.ui.RequiresResize;
import com.google.gwt.user.client.ui.ResizeComposite;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.SourcesChangeEvents;
import com.google.gwt.user.client.ui.SourcesClickEvents;
import com.google.gwt.user.client.ui.SourcesFocusEvents;
import com.google.gwt.user.client.ui.SourcesKeyboardEvents;
import com.google.gwt.user.client.ui.SourcesMouseEvents;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.ValueBoxBase;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Instance;
import javax.inject.Named;
import javax.inject.Provider;
import org.gwtbootstrap3.client.ui.AnchorListItem;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.CheckBox;
import org.gwtbootstrap3.client.ui.IsClosable;
import org.gwtbootstrap3.client.ui.Modal;
import org.gwtbootstrap3.client.ui.base.AbstractAnchorListItem;
import org.gwtbootstrap3.client.ui.base.AbstractListItem;
import org.gwtbootstrap3.client.ui.base.ComplexWidget;
import org.gwtbootstrap3.client.ui.base.HasActive;
import org.gwtbootstrap3.client.ui.base.HasContextualBackground;
import org.gwtbootstrap3.client.ui.base.HasDataSpy;
import org.gwtbootstrap3.client.ui.base.HasDataTarget;
import org.gwtbootstrap3.client.ui.base.HasDataToggle;
import org.gwtbootstrap3.client.ui.base.HasFormValue;
import org.gwtbootstrap3.client.ui.base.HasHref;
import org.gwtbootstrap3.client.ui.base.HasIcon;
import org.gwtbootstrap3.client.ui.base.HasIconPosition;
import org.gwtbootstrap3.client.ui.base.HasId;
import org.gwtbootstrap3.client.ui.base.HasInlineStyle;
import org.gwtbootstrap3.client.ui.base.HasPull;
import org.gwtbootstrap3.client.ui.base.HasResponsiveness;
import org.gwtbootstrap3.client.ui.base.HasSize;
import org.gwtbootstrap3.client.ui.base.HasTargetHistoryToken;
import org.gwtbootstrap3.client.ui.base.HasType;
import org.gwtbootstrap3.client.ui.base.button.AbstractButton;
import org.gwtbootstrap3.client.ui.base.button.AbstractIconButton;
import org.gwtbootstrap3.client.ui.base.button.AbstractToggleButton;
import org.gwtbootstrap3.client.ui.gwt.ButtonBase;
import org.gwtbootstrap3.client.ui.gwt.HTMLPanel;
import org.gwtbootstrap3.client.ui.html.Div;
import org.gwtbootstrap3.client.ui.html.Span;
import org.gwtbootstrap3.client.ui.html.UnorderedList;
import org.jboss.errai.bus.client.ErraiBus;
import org.jboss.errai.bus.client.api.ClientMessageBus;
import org.jboss.errai.bus.client.api.Subscription;
import org.jboss.errai.bus.client.framework.ClientMessageBusImpl;
import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.common.client.api.ErrorCallback;
import org.jboss.errai.common.client.api.extension.InitVotes;
import org.jboss.errai.common.client.api.interceptor.RemoteCallInterceptor;
import org.jboss.errai.databinding.client.DataBinderProvider;
import org.jboss.errai.databinding.client.DataBindingModuleBootstrapper;
import org.jboss.errai.enterprise.client.cdi.AbstractCDIEventCallback;
import org.jboss.errai.enterprise.client.cdi.CDIEventTypeLookup;
import org.jboss.errai.enterprise.client.cdi.EventProvider;
import org.jboss.errai.enterprise.client.cdi.InstanceProvider;
import org.jboss.errai.enterprise.client.cdi.api.CDI;
import org.jboss.errai.enterprise.client.jaxrs.api.RestErrorCallback;
import org.jboss.errai.ioc.client.api.ContextualTypeProvider;
import org.jboss.errai.ioc.client.api.builtin.CallerProvider;
import org.jboss.errai.ioc.client.api.builtin.DisposerProvider;
import org.jboss.errai.ioc.client.api.builtin.IOCBeanManagerProvider;
import org.jboss.errai.ioc.client.api.builtin.InitBallotProvider;
import org.jboss.errai.ioc.client.api.builtin.RootPanelProvider;
import org.jboss.errai.ioc.client.container.BeanProvider;
import org.jboss.errai.ioc.client.container.CreationalContext;
import org.jboss.errai.ioc.client.container.DestructionCallback;
import org.jboss.errai.ioc.client.container.InitializationCallback;
import org.jboss.errai.ioc.client.container.ProxyResolver;
import org.jboss.errai.ioc.client.container.RefHolder;
import org.jboss.errai.ioc.client.container.SimpleCreationalContext;
import org.jboss.errai.ioc.client.container.SyncBeanManager;
import org.jboss.errai.ioc.client.lifecycle.api.Access;
import org.jboss.errai.ioc.client.lifecycle.api.Creation;
import org.jboss.errai.ioc.client.lifecycle.api.Destruction;
import org.jboss.errai.ioc.client.lifecycle.api.LifecycleEvent;
import org.jboss.errai.ioc.client.lifecycle.api.LifecycleListenerRegistrar;
import org.jboss.errai.ioc.client.lifecycle.api.StateChange;
import org.jboss.errai.ioc.client.lifecycle.impl.AccessImpl;
import org.jboss.errai.ioc.client.lifecycle.impl.CreationImpl;
import org.jboss.errai.ioc.client.lifecycle.impl.DestructionImpl;
import org.jboss.errai.ioc.client.lifecycle.impl.LifecycleEventImpl;
import org.jboss.errai.ioc.client.lifecycle.impl.LifecycleListenerRegistrarImpl;
import org.jboss.errai.ioc.client.lifecycle.impl.StateChangeImpl;
import org.jboss.errai.ioc.support.bus.client.BatchCallerProvider;
import org.jboss.errai.ioc.support.bus.client.MessageBusProvider;
import org.jboss.errai.ioc.support.bus.client.RequestDispatcherProvider;
import org.jboss.errai.ioc.support.bus.client.SenderProvider;
import org.jboss.errai.security.client.local.api.SecurityContext;
import org.jboss.errai.security.client.local.callback.DefaultBusSecurityErrorCallback;
import org.jboss.errai.security.client.local.callback.DefaultRestSecurityErrorCallback;
import org.jboss.errai.security.client.local.context.BasicUserCacheImpl;
import org.jboss.errai.security.client.local.context.SecurityContextImpl;
import org.jboss.errai.security.client.local.context.SecurityContextImpl.SecurityRolesConstraintPage;
import org.jboss.errai.security.client.local.interceptors.AuthenticationServiceInterceptor;
import org.jboss.errai.security.client.local.interceptors.ClientSecurityRoleInterceptor;
import org.jboss.errai.security.client.local.nav.SecurityContextHoldingSingleton;
import org.jboss.errai.security.client.local.roles.ClientRequiredRolesExtractorImpl;
import org.jboss.errai.security.client.local.spi.ActiveUserCache;
import org.jboss.errai.security.client.local.storage.CookieStorageHandlerProvider;
import org.jboss.errai.security.client.local.storage.UserStorageHandler;
import org.jboss.errai.security.client.local.style.RoleStyleBindingProvider;
import org.jboss.errai.security.shared.api.identity.User;
import org.jboss.errai.security.shared.event.LoggedInEvent;
import org.jboss.errai.security.shared.event.LoggedOutEvent;
import org.jboss.errai.security.shared.roles.SharedRequiredRolesExtractorImpl;
import org.jboss.errai.security.shared.service.NonCachingUserService;
import org.jboss.errai.security.shared.spi.RequiredRolesExtractor;
import org.jboss.errai.ui.client.local.spi.LessStyle;
import org.jboss.errai.ui.client.local.spi.TemplateProvider;
import org.jboss.errai.ui.client.local.spi.TranslationServiceProvider;
import org.jboss.errai.ui.client.widget.ListWidgetProvider;
import org.jboss.errai.ui.client.widget.LocaleListBox;
import org.jboss.errai.ui.client.widget.LocaleSelector;
import org.jboss.errai.ui.nav.client.local.HistoryTokenFactory;
import org.jboss.errai.ui.nav.client.local.Navigation;
import org.jboss.errai.ui.nav.client.local.NavigationPanelProvider;
import org.jboss.errai.ui.nav.client.local.PageTransitionProvider;
import org.jboss.errai.ui.nav.client.local.TransitionAnchorFactoryProvider;
import org.jboss.errai.ui.nav.client.local.TransitionAnchorProvider;
import org.jboss.errai.ui.nav.client.local.TransitionToRole;
import org.jboss.errai.ui.nav.client.local.TransitionToRoleProvider;
import org.jboss.errai.ui.nav.client.local.URLPatternMatcher;
import org.jboss.errai.ui.nav.client.local.URLPatternMatcherProvider;
import org.jboss.errai.ui.nav.client.local.api.LoginPage;
import org.jboss.errai.ui.nav.client.local.api.SecurityError;
import org.jboss.errai.ui.nav.client.local.spi.NavigationGraph;
import org.jboss.errai.ui.shared.ServerTemplateProvider;
import org.jboss.errai.ui.shared.Template;
import org.jboss.errai.ui.shared.TemplateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.uberfire.backend.plugin.RuntimePluginsService;
import org.uberfire.backend.vfs.IsVersioned;
import org.uberfire.backend.vfs.ObservablePath;
import org.uberfire.backend.vfs.Path;
import org.uberfire.backend.vfs.VFSLockService;
import org.uberfire.backend.vfs.VFSService;
import org.uberfire.backend.vfs.impl.ForceUnlockEvent;
import org.uberfire.backend.vfs.impl.LockInfo;
import org.uberfire.backend.vfs.impl.ObservablePathImpl;
import org.uberfire.client.JSEntryPoint;
import org.uberfire.client.RuntimePluginsServiceProxyBackendImpl;
import org.uberfire.client.ShowcaseEntryPoint;
import org.uberfire.client.VFSLockServiceProxyBackendImpl;
import org.uberfire.client.VFSServiceProxyBackendImpl;
import org.uberfire.client.WorkbenchBackendEntryPoint;
import org.uberfire.client.WorkbenchServicesProxyBackendImpl;
import org.uberfire.client.editor.JSNativeEditor;
import org.uberfire.client.exporter.EditorJSExporter;
import org.uberfire.client.exporter.HTML5DndSeleniumSupport;
import org.uberfire.client.exporter.PerspectiveJSExporter;
import org.uberfire.client.exporter.PlaceManagerJSExporter;
import org.uberfire.client.exporter.PluginJSExporter;
import org.uberfire.client.exporter.SplashScreenJSExporter;
import org.uberfire.client.exporter.UberfireJSAPIExporter;
import org.uberfire.client.exporter.UberfireJSExporter;
import org.uberfire.client.exporter.VFSJSExporter;
import org.uberfire.client.menu.CustomSplashHelp;
import org.uberfire.client.menu.SplashScreenMenuPresenter;
import org.uberfire.client.menu.SplashScreenMenuPresenter.View;
import org.uberfire.client.menu.WorkbenchViewModeSwitcherMenuBuilder;
import org.uberfire.client.menu.WorkbenchViewModeSwitcherPresenter;
import org.uberfire.client.mvp.AbstractActivity;
import org.uberfire.client.mvp.AbstractPopupActivity;
import org.uberfire.client.mvp.AbstractWorkbenchActivity;
import org.uberfire.client.mvp.AbstractWorkbenchPerspectiveActivity;
import org.uberfire.client.mvp.AbstractWorkbenchScreenActivity;
import org.uberfire.client.mvp.Activity;
import org.uberfire.client.mvp.ActivityBeansCache;
import org.uberfire.client.mvp.ActivityBeansInfo;
import org.uberfire.client.mvp.ActivityLifecycleError;
import org.uberfire.client.mvp.ActivityLifecycleErrorHandler;
import org.uberfire.client.mvp.ActivityManager;
import org.uberfire.client.mvp.ActivityManagerImpl;
import org.uberfire.client.mvp.ContextSensitiveActivity;
import org.uberfire.client.mvp.ForceUnlockEventObserver;
import org.uberfire.client.mvp.LockDemandDetector;
import org.uberfire.client.mvp.LockManager;
import org.uberfire.client.mvp.LockManagerImpl;
import org.uberfire.client.mvp.LockRequiredEvent;
import org.uberfire.client.mvp.PerspectiveActivity;
import org.uberfire.client.mvp.PerspectiveManager;
import org.uberfire.client.mvp.PerspectiveManagerImpl;
import org.uberfire.client.mvp.PlaceHistoryHandler;
import org.uberfire.client.mvp.PlaceManager;
import org.uberfire.client.mvp.PlaceManagerImpl;
import org.uberfire.client.mvp.PlaceRequestHistoryMapper;
import org.uberfire.client.mvp.PlaceRequestHistoryMapperImpl;
import org.uberfire.client.mvp.PlaceStatus;
import org.uberfire.client.mvp.PopupActivity;
import org.uberfire.client.mvp.SaveInProgressEvent;
import org.uberfire.client.mvp.UberView;
import org.uberfire.client.mvp.UpdatedLockStatusEvent;
import org.uberfire.client.mvp.WorkbenchActivity;
import org.uberfire.client.mvp.WorkbenchScreenActivity;
import org.uberfire.client.navbar.AppNavBar;
import org.uberfire.client.perspective.JSNativePerspective;
import org.uberfire.client.perspectives.MainPerspective;
import org.uberfire.client.perspectives.MainPerspectiveActivity;
import org.uberfire.client.perspectives.MoodPerspective;
import org.uberfire.client.perspectives.MoodPerspectiveActivity;
import org.uberfire.client.plugin.JSNativePlugin;
import org.uberfire.client.plugin.RuntimePluginsServiceProxy;
import org.uberfire.client.plugin.RuntimePluginsServiceProxyClientImpl;
import org.uberfire.client.screen.JSNativeScreen;
import org.uberfire.client.screens.HelloWorldScreen;
import org.uberfire.client.screens.HelloWorldScreenActivity;
import org.uberfire.client.screens.MoodListenerScreen;
import org.uberfire.client.screens.MoodListenerScreenActivity;
import org.uberfire.client.screens.MoodScreen;
import org.uberfire.client.screens.MoodScreenActivity;
import org.uberfire.client.splash.JSNativeSplashScreen;
import org.uberfire.client.views.pfly.dnd.CompassWidgetImpl;
import org.uberfire.client.views.pfly.listbar.ListBarWidgetImpl;
import org.uberfire.client.views.pfly.menu.HasMenuItems;
import org.uberfire.client.views.pfly.menu.MainBrand;
import org.uberfire.client.views.pfly.menu.PartContextMenusView;
import org.uberfire.client.views.pfly.menu.SplashScreenMenuView;
import org.uberfire.client.views.pfly.menu.UserMenu;
import org.uberfire.client.views.pfly.menu.UserMenu.UserMenuView;
import org.uberfire.client.views.pfly.menu.UserMenuViewImpl;
import org.uberfire.client.views.pfly.menu.UtilityMenuBarView;
import org.uberfire.client.views.pfly.menu.WorkbenchMenuBarView;
import org.uberfire.client.views.pfly.menu.WorkbenchMenuCompactNavBarView;
import org.uberfire.client.views.pfly.menu.WorkbenchMenuNavBarView;
import org.uberfire.client.views.pfly.menu.WorkbenchMenuStandardNavBarView;
import org.uberfire.client.views.pfly.menu.WorkbenchViewModeSwitcherView;
import org.uberfire.client.views.pfly.modal.Bs3Modal;
import org.uberfire.client.views.pfly.modal.ErrorPopupView;
import org.uberfire.client.views.pfly.multipage.MultiPageEditorImpl;
import org.uberfire.client.views.pfly.multipage.MultiPageEditorViewImpl;
import org.uberfire.client.views.pfly.notfound.ActivityNotFoundView;
import org.uberfire.client.views.pfly.notifications.NotificationPopupsManagerView;
import org.uberfire.client.views.pfly.popup.PopupViewImpl;
import org.uberfire.client.views.pfly.splash.SplashModalFooter;
import org.uberfire.client.views.pfly.splash.SplashViewImpl;
import org.uberfire.client.views.pfly.tab.MultiTabWorkbenchPanelView;
import org.uberfire.client.views.pfly.tab.ResizeTabPanel;
import org.uberfire.client.views.pfly.tab.TabPanelWithDropdowns;
import org.uberfire.client.views.pfly.tab.UberTabPanel;
import org.uberfire.client.views.pfly.toolbar.WorkbenchToolBarView;
import org.uberfire.client.workbench.BeanFactory;
import org.uberfire.client.workbench.DefaultBeanFactory;
import org.uberfire.client.workbench.Header;
import org.uberfire.client.workbench.LayoutSelection;
import org.uberfire.client.workbench.OrderableIsWidget;
import org.uberfire.client.workbench.PanelManager;
import org.uberfire.client.workbench.PanelManagerImpl;
import org.uberfire.client.workbench.StandaloneEditorPerspective;
import org.uberfire.client.workbench.VFSLockServiceProxy;
import org.uberfire.client.workbench.VFSLockServiceProxyClientImpl;
import org.uberfire.client.workbench.VFSServiceProxy;
import org.uberfire.client.workbench.VFSServiceProxyClientImpl;
import org.uberfire.client.workbench.Workbench;
import org.uberfire.client.workbench.WorkbenchLayout;
import org.uberfire.client.workbench.WorkbenchLayoutImpl;
import org.uberfire.client.workbench.WorkbenchLayoutInfo;
import org.uberfire.client.workbench.WorkbenchLayoutInfoImpl;
import org.uberfire.client.workbench.WorkbenchServicesProxy;
import org.uberfire.client.workbench.WorkbenchServicesProxyClientImpl;
import org.uberfire.client.workbench.events.ApplicationReadyEvent;
import org.uberfire.client.workbench.events.BeforeClosePlaceEvent;
import org.uberfire.client.workbench.events.ChangeTitleWidgetEvent;
import org.uberfire.client.workbench.events.ClosePlaceEvent;
import org.uberfire.client.workbench.events.DropPlaceEvent;
import org.uberfire.client.workbench.events.NewPerspectiveEvent;
import org.uberfire.client.workbench.events.NewSplashScreenActiveEvent;
import org.uberfire.client.workbench.events.NewWorkbenchScreenEvent;
import org.uberfire.client.workbench.events.PanelFocusEvent;
import org.uberfire.client.workbench.events.PerspectiveChange;
import org.uberfire.client.workbench.events.PlaceGainFocusEvent;
import org.uberfire.client.workbench.events.PlaceHiddenEvent;
import org.uberfire.client.workbench.events.PlaceLostFocusEvent;
import org.uberfire.client.workbench.events.PlaceMaximizedEvent;
import org.uberfire.client.workbench.events.PlaceMinimizedEvent;
import org.uberfire.client.workbench.events.SelectPlaceEvent;
import org.uberfire.client.workbench.panels.DockingWorkbenchPanelPresenter;
import org.uberfire.client.workbench.panels.DockingWorkbenchPanelView;
import org.uberfire.client.workbench.panels.MultiPartWidget;
import org.uberfire.client.workbench.panels.WorkbenchPanelPresenter;
import org.uberfire.client.workbench.panels.WorkbenchPanelView;
import org.uberfire.client.workbench.panels.impl.AbstractDockingWorkbenchPanelPresenter;
import org.uberfire.client.workbench.panels.impl.AbstractDockingWorkbenchPanelView;
import org.uberfire.client.workbench.panels.impl.AbstractMultiPartWorkbenchPanelPresenter;
import org.uberfire.client.workbench.panels.impl.AbstractMultiPartWorkbenchPanelView;
import org.uberfire.client.workbench.panels.impl.AbstractSimpleWorkbenchPanelView;
import org.uberfire.client.workbench.panels.impl.AbstractWorkbenchPanelPresenter;
import org.uberfire.client.workbench.panels.impl.AbstractWorkbenchPanelView;
import org.uberfire.client.workbench.panels.impl.AdaptiveWorkbenchPanelPresenter;
import org.uberfire.client.workbench.panels.impl.AdaptiveWorkbenchPanelView;
import org.uberfire.client.workbench.panels.impl.ClosableSimpleWorkbenchPanelPresenter;
import org.uberfire.client.workbench.panels.impl.ClosableSimpleWorkbenchPanelView;
import org.uberfire.client.workbench.panels.impl.LayoutPanelPresenter;
import org.uberfire.client.workbench.panels.impl.LayoutPanelView;
import org.uberfire.client.workbench.panels.impl.MultiListWorkbenchPanelPresenter;
import org.uberfire.client.workbench.panels.impl.MultiListWorkbenchPanelView;
import org.uberfire.client.workbench.panels.impl.MultiTabWorkbenchPanelPresenter;
import org.uberfire.client.workbench.panels.impl.SimpleDnDWorkbenchPanelPresenter;
import org.uberfire.client.workbench.panels.impl.SimpleDnDWorkbenchPanelView;
import org.uberfire.client.workbench.panels.impl.SimpleWorkbenchPanelPresenter;
import org.uberfire.client.workbench.panels.impl.SimpleWorkbenchPanelView;
import org.uberfire.client.workbench.panels.impl.SplitLayoutPanelPresenter;
import org.uberfire.client.workbench.panels.impl.SplitLayoutPanelView;
import org.uberfire.client.workbench.panels.impl.StaticWorkbenchPanelPresenter;
import org.uberfire.client.workbench.panels.impl.StaticWorkbenchPanelView;
import org.uberfire.client.workbench.panels.impl.TemplatedWorkbenchPanelPresenter;
import org.uberfire.client.workbench.panels.impl.TemplatedWorkbenchPanelView;
import org.uberfire.client.workbench.panels.support.PartManager;
import org.uberfire.client.workbench.part.WorkbenchPartPresenter;
import org.uberfire.client.workbench.pmgr.nswe.part.WorkbenchPartPresenterDefault;
import org.uberfire.client.workbench.pmgr.nswe.part.WorkbenchPartView;
import org.uberfire.client.workbench.type.AnyResourceType;
import org.uberfire.client.workbench.type.ClientResourceType;
import org.uberfire.client.workbench.type.ClientTypeRegistry;
import org.uberfire.client.workbench.type.DotResourceType;
import org.uberfire.client.workbench.type.impl.ClientTypeRegistryImpl;
import org.uberfire.client.workbench.widgets.common.ErrorPopupPresenter;
import org.uberfire.client.workbench.widgets.dnd.CompassDropController;
import org.uberfire.client.workbench.widgets.dnd.CompassWidget;
import org.uberfire.client.workbench.widgets.dnd.WorkbenchDragAndDropManager;
import org.uberfire.client.workbench.widgets.dnd.WorkbenchDragContext;
import org.uberfire.client.workbench.widgets.dnd.WorkbenchPickupDragController;
import org.uberfire.client.workbench.widgets.listbar.ListBarWidget;
import org.uberfire.client.workbench.widgets.listbar.ListbarPreferences;
import org.uberfire.client.workbench.widgets.listbar.ResizeFlowPanel;
import org.uberfire.client.workbench.widgets.menu.HasMenus;
import org.uberfire.client.workbench.widgets.menu.PartContextMenusPresenter;
import org.uberfire.client.workbench.widgets.menu.UtilityMenuBar;
import org.uberfire.client.workbench.widgets.menu.UtilityMenuBarPresenter;
import org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBar;
import org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarPresenter;
import org.uberfire.client.workbench.widgets.multipage.MultiPageEditor;
import org.uberfire.client.workbench.widgets.multipage.MultiPageEditorView;
import org.uberfire.client.workbench.widgets.notfound.ActivityNotFoundPresenter;
import org.uberfire.client.workbench.widgets.notifications.NotificationManager;
import org.uberfire.client.workbench.widgets.panel.StaticFocusedResizePanel;
import org.uberfire.client.workbench.widgets.popup.PopupView;
import org.uberfire.client.workbench.widgets.splash.SplashView;
import org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarPresenter;
import org.uberfire.commons.lifecycle.Disposable;
import org.uberfire.component.client.ComponentPresenter;
import org.uberfire.component.client.ComponentPresenterActivity;
import org.uberfire.component.client.ComponentView;
import org.uberfire.component.service.MyService;
import org.uberfire.mvp.Command;
import org.uberfire.mvp.PlaceRequest;
import org.uberfire.rpc.SessionInfo;
import org.uberfire.security.Resource;
import org.uberfire.security.authz.AuthorizationManager;
import org.uberfire.security.authz.RuntimeFeatureResource;
import org.uberfire.security.authz.RuntimeResource;
import org.uberfire.security.client.SecurityEntryPoint;
import org.uberfire.security.impl.authz.RuntimeAuthorizationManager;
import org.uberfire.shared.Mood;
import org.uberfire.workbench.events.NotificationEvent;
import org.uberfire.workbench.events.ResourceAddedEvent;
import org.uberfire.workbench.events.ResourceBatchChangesEvent;
import org.uberfire.workbench.events.ResourceCopiedEvent;
import org.uberfire.workbench.events.ResourceDeletedEvent;
import org.uberfire.workbench.events.ResourceRenamedEvent;
import org.uberfire.workbench.events.ResourceUpdatedEvent;
import org.uberfire.workbench.model.PanelDefinition;
import org.uberfire.workbench.model.PartDefinition;
import org.uberfire.workbench.model.menu.MenuFactory.CustomMenuBuilder;
import org.uberfire.workbench.services.WorkbenchServices;
import org.uberfire.workbench.type.AnyResourceTypeDefinition;
import org.uberfire.workbench.type.DotResourceTypeDefinition;
import org.uberfire.workbench.type.ResourceTypeDefinition;
import org.uberfire.workbench.type.TextResourceTypeDefinition;

public class BootstrapperImpl implements Bootstrapper {
  {
    addLookups_0();
    new CDI().initLookupTable(CDIEventTypeLookup.get());
    new DataBindingModuleBootstrapper().run();
  }

  private final Named _1314308073Named__1637268404 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=ClosableSimpleWorkbenchPanelView)";
    }
    public String value() {
      return "ClosableSimpleWorkbenchPanelView";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1738119949 = new Annotation[] { QualifierUtil.DEFAULT_ANNOTATION, _1314308073Named__1637268404, QualifierUtil.ANY_ANNOTATION };
  private final Named _1314308073Named_797591419 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=TemplatedWorkbenchPanelView)";
    }
    public String value() {
      return "TemplatedWorkbenchPanelView";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_966516661 = new Annotation[] { _1314308073Named_797591419, QualifierUtil.DEFAULT_ANNOTATION, QualifierUtil.ANY_ANNOTATION };
  private final Named _1314308073Named_1651888556 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=MainPerspective)";
    }
    public String value() {
      return "MainPerspective";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1601691956 = new Annotation[] { QualifierUtil.DEFAULT_ANNOTATION, QualifierUtil.ANY_ANNOTATION, _1314308073Named_1651888556 };
  private final Named _1314308073Named__1901730907 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=StandaloneEditorPerspective)";
    }
    public String value() {
      return "StandaloneEditorPerspective";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1796742650 = new Annotation[] { _1314308073Named__1901730907, QualifierUtil.DEFAULT_ANNOTATION, QualifierUtil.ANY_ANNOTATION };
  private final Named _1314308073Named_2123941264 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=LayoutPanelView)";
    }
    public String value() {
      return "LayoutPanelView";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1286405175 = new Annotation[] { QualifierUtil.DEFAULT_ANNOTATION, QualifierUtil.ANY_ANNOTATION, _1314308073Named_2123941264 };
  private final Named _1314308073Named_1811347959 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=StaticWorkbenchPanelView)";
    }
    public String value() {
      return "StaticWorkbenchPanelView";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1048561786 = new Annotation[] { _1314308073Named_1811347959, QualifierUtil.DEFAULT_ANNOTATION, QualifierUtil.ANY_ANNOTATION };
  private final Named _1314308073Named_12923817 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=MultiTabWorkbenchPanelView)";
    }
    public String value() {
      return "MultiTabWorkbenchPanelView";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_913099561 = new Annotation[] { QualifierUtil.DEFAULT_ANNOTATION, QualifierUtil.ANY_ANNOTATION, _1314308073Named_12923817 };
  private final Named _1314308073Named_834929514 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=SplitLayoutPanelView)";
    }
    public String value() {
      return "SplitLayoutPanelView";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_799239204 = new Annotation[] { QualifierUtil.DEFAULT_ANNOTATION, QualifierUtil.ANY_ANNOTATION, _1314308073Named_834929514 };
  private final Named _1314308073Named__266016381 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=HelloWorldScreen)";
    }
    public String value() {
      return "HelloWorldScreen";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_882203174 = new Annotation[] { QualifierUtil.DEFAULT_ANNOTATION, QualifierUtil.ANY_ANNOTATION, _1314308073Named__266016381 };
  private final Named _1314308073Named__516863473 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=AdaptiveWorkbenchPanelView)";
    }
    public String value() {
      return "AdaptiveWorkbenchPanelView";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_482389261 = new Annotation[] { QualifierUtil.DEFAULT_ANNOTATION, QualifierUtil.ANY_ANNOTATION, _1314308073Named__516863473 };
  private final Named _1314308073Named_771251763 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=SimpleWorkbenchPanelView)";
    }
    public String value() {
      return "SimpleWorkbenchPanelView";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_351968993 = new Annotation[] { QualifierUtil.DEFAULT_ANNOTATION, QualifierUtil.ANY_ANNOTATION, _1314308073Named_771251763 };
  private final Named _1314308073Named__1649374806 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=MoodPerspective)";
    }
    public String value() {
      return "MoodPerspective";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1179408223 = new Annotation[] { QualifierUtil.DEFAULT_ANNOTATION, QualifierUtil.ANY_ANNOTATION, _1314308073Named__1649374806 };
  private final Named _1314308073Named_607526542 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=MultiListWorkbenchPanelView)";
    }
    public String value() {
      return "MultiListWorkbenchPanelView";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_381280622 = new Annotation[] { QualifierUtil.DEFAULT_ANNOTATION, QualifierUtil.ANY_ANNOTATION, _1314308073Named_607526542 };
  private final Named _1314308073Named_1746626884 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=ComponentPresenter)";
    }
    public String value() {
      return "ComponentPresenter";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1553332319 = new Annotation[] { QualifierUtil.DEFAULT_ANNOTATION, QualifierUtil.ANY_ANNOTATION, _1314308073Named_1746626884 };
  private final Named _1314308073Named_2061124429 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=uf.workbench.activity.notfound)";
    }
    public String value() {
      return "uf.workbench.activity.notfound";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_343148925 = new Annotation[] { QualifierUtil.DEFAULT_ANNOTATION, QualifierUtil.ANY_ANNOTATION, _1314308073Named_2061124429 };
  private final Named _1314308073Named_1141066092 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=MoodScreen)";
    }
    public String value() {
      return "MoodScreen";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_335935540 = new Annotation[] { QualifierUtil.DEFAULT_ANNOTATION, QualifierUtil.ANY_ANNOTATION, _1314308073Named_1141066092 };
  private final Named _1314308073Named_1276495416 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=MoodListenerScreen)";
    }
    public String value() {
      return "MoodListenerScreen";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_594926657 = new Annotation[] { QualifierUtil.DEFAULT_ANNOTATION, QualifierUtil.ANY_ANNOTATION, _1314308073Named_1276495416 };
  private final SimpleInjectionContext injContext = new SimpleInjectionContext();
  private final SimpleCreationalContext context = injContext.getRootContext();
  private final BeanProvider<MainPerspective> inj2193_MainPerspective_creational = new BeanProvider<MainPerspective>() {
    public MainPerspective getInstance(final CreationalContext context) {
      final MainPerspective inj2192_MainPerspective = new MainPerspective();
      context.addBean(context.getBeanReference(MainPerspective.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2192_MainPerspective);
      return inj2192_MainPerspective;
    }
  };
  private final MainPerspective inj2192_MainPerspective = inj2193_MainPerspective_creational.getInstance(context);
  private final BeanProvider<WorkbenchPickupDragController> inj2195_WorkbenchPickupDragController_creational = new BeanProvider<WorkbenchPickupDragController>() {
    public WorkbenchPickupDragController getInstance(final CreationalContext context) {
      final WorkbenchPickupDragController inj2194_WorkbenchPickupDragController = new WorkbenchPickupDragController();
      context.addBean(context.getBeanReference(WorkbenchPickupDragController.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2194_WorkbenchPickupDragController);
      final WorkbenchDragAndDropManager_inj2196_proxy inj2196_proxy = new WorkbenchDragAndDropManager_inj2196_proxy();
      context.addUnresolvedProxy(new ProxyResolver<WorkbenchDragAndDropManager>() {
        public void resolve(WorkbenchDragAndDropManager obj) {
          inj2196_proxy.__$setProxiedInstance$(obj);
          context.addProxyReference(inj2196_proxy, obj);
        }
      }, WorkbenchDragAndDropManager.class, QualifierUtil.DEFAULT_QUALIFIERS);
      _683332058__153624969_dndManager(inj2194_WorkbenchPickupDragController, inj2196_proxy);
      return inj2194_WorkbenchPickupDragController;
    }
  };
  private final WorkbenchPickupDragController inj2194_WorkbenchPickupDragController = inj2195_WorkbenchPickupDragController_creational.getInstance(context);
  private final BeanProvider<IOCBeanManagerProvider> inj2197_IOCBeanManagerProvider_creational = new BeanProvider<IOCBeanManagerProvider>() {
    public IOCBeanManagerProvider getInstance(final CreationalContext context) {
      final IOCBeanManagerProvider inj2155_IOCBeanManagerProvider = new IOCBeanManagerProvider();
      context.addBean(context.getBeanReference(IOCBeanManagerProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2155_IOCBeanManagerProvider);
      return inj2155_IOCBeanManagerProvider;
    }
  };
  private final IOCBeanManagerProvider inj2155_IOCBeanManagerProvider = inj2197_IOCBeanManagerProvider_creational.getInstance(context);
  private final BeanProvider<DefaultBeanFactory> inj2199_DefaultBeanFactory_creational = new BeanProvider<DefaultBeanFactory>() {
    public DefaultBeanFactory getInstance(final CreationalContext context) {
      final DefaultBeanFactory inj2198_DefaultBeanFactory = new DefaultBeanFactory();
      context.addBean(context.getBeanReference(DefaultBeanFactory.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2198_DefaultBeanFactory);
      _1174169399__$652658075_iocManager(inj2198_DefaultBeanFactory, inj2155_IOCBeanManagerProvider.get());
      return inj2198_DefaultBeanFactory;
    }
  };
  private final DefaultBeanFactory inj2198_DefaultBeanFactory = inj2199_DefaultBeanFactory_creational.getInstance(context);
  private final BeanProvider<WorkbenchDragAndDropManager> inj2201_WorkbenchDragAndDropManager_creational = new BeanProvider<WorkbenchDragAndDropManager>() {
    public WorkbenchDragAndDropManager getInstance(final CreationalContext context) {
      final WorkbenchDragAndDropManager inj2200_WorkbenchDragAndDropManager = new WorkbenchDragAndDropManager();
      context.addBean(context.getBeanReference(WorkbenchDragAndDropManager.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2200_WorkbenchDragAndDropManager);
      _153624969__683332058_dragController(inj2200_WorkbenchDragAndDropManager, ((SimpleCreationalContext) context).getInstanceOrNew(inj2195_WorkbenchPickupDragController_creational, WorkbenchPickupDragController.class, QualifierUtil.DEFAULT_QUALIFIERS));
      _153624969__$1887041540_factory(inj2200_WorkbenchDragAndDropManager, inj2198_DefaultBeanFactory);
      return inj2200_WorkbenchDragAndDropManager;
    }
  };
  private final WorkbenchDragAndDropManager inj2200_WorkbenchDragAndDropManager = inj2201_WorkbenchDragAndDropManager_creational.getInstance(context);
  private final BeanProvider<CookieStorageHandlerProvider> inj2202_CookieStorageHandlerProvider_creational = new BeanProvider<CookieStorageHandlerProvider>() {
    public CookieStorageHandlerProvider getInstance(final CreationalContext context) {
      final CookieStorageHandlerProvider inj2165_CookieStorageHandlerProvider = new CookieStorageHandlerProvider();
      context.addBean(context.getBeanReference(CookieStorageHandlerProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2165_CookieStorageHandlerProvider);
      return inj2165_CookieStorageHandlerProvider;
    }
  };
  private final CookieStorageHandlerProvider inj2165_CookieStorageHandlerProvider = inj2202_CookieStorageHandlerProvider_creational.getInstance(context);
  private InitializationCallback<BasicUserCacheImpl> init_inj2203_BasicUserCacheImpl = new InitializationCallback<BasicUserCacheImpl>() {
    public void init(final BasicUserCacheImpl obj) {
      _663569186_maybeLoadStoredCache(obj);
    }
  };
  private final BeanProvider<BasicUserCacheImpl> inj2204_BasicUserCacheImpl_creational = new BeanProvider<BasicUserCacheImpl>() {
    public BasicUserCacheImpl getInstance(final CreationalContext context) {
      final BasicUserCacheImpl inj2203_BasicUserCacheImpl = new BasicUserCacheImpl();
      context.addBean(context.getBeanReference(BasicUserCacheImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2203_BasicUserCacheImpl);
      final Logger var1 = LoggerFactory.getLogger("org.jboss.errai.security.client.local.context.BasicUserCacheImpl");
      _663569186__1388723237_logger(inj2203_BasicUserCacheImpl, var1);
      _663569186__$1444549593_userStorageHandler(inj2203_BasicUserCacheImpl, inj2165_CookieStorageHandlerProvider.get());
      context.addInitializationCallback(inj2203_BasicUserCacheImpl, init_inj2203_BasicUserCacheImpl);
      return inj2203_BasicUserCacheImpl;
    }
  };
  private final BasicUserCacheImpl inj2203_BasicUserCacheImpl = inj2204_BasicUserCacheImpl_creational.getInstance(context);
  private final BeanProvider<User> inj2146_User_creational = new BeanProvider<User>() {
    public User getInstance(CreationalContext pContext) {
      User var2 = _663569186_produceActiveUser(inj2203_BasicUserCacheImpl);
      context.addBean(context.getBeanReference(User.class, QualifierUtil.DEFAULT_QUALIFIERS), var2);
      return var2;
    }
  };
  private final BeanProvider<InstanceProvider> inj2205_InstanceProvider_creational = new BeanProvider<InstanceProvider>() {
    public InstanceProvider getInstance(final CreationalContext context) {
      final InstanceProvider inj2189_InstanceProvider = new InstanceProvider();
      context.addBean(context.getBeanReference(InstanceProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2189_InstanceProvider);
      return inj2189_InstanceProvider;
    }
  };
  private final InstanceProvider inj2189_InstanceProvider = inj2205_InstanceProvider_creational.getInstance(context);
  private final BeanProvider<RuntimeAuthorizationManager> inj2207_RuntimeAuthorizationManager_creational = new BeanProvider<RuntimeAuthorizationManager>() {
    public RuntimeAuthorizationManager getInstance(final CreationalContext context) {
      final RuntimeAuthorizationManager inj2206_RuntimeAuthorizationManager = new RuntimeAuthorizationManager();
      context.addBean(context.getBeanReference(RuntimeAuthorizationManager.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2206_RuntimeAuthorizationManager);
      return inj2206_RuntimeAuthorizationManager;
    }
  };
  private final RuntimeAuthorizationManager inj2206_RuntimeAuthorizationManager = inj2207_RuntimeAuthorizationManager_creational.getInstance(context);
  private final BeanProvider<EventProvider> inj2208_EventProvider_creational = new BeanProvider<EventProvider>() {
    public EventProvider getInstance(final CreationalContext context) {
      final EventProvider inj2187_EventProvider = new EventProvider();
      context.addBean(context.getBeanReference(EventProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2187_EventProvider);
      return inj2187_EventProvider;
    }
  };
  private final EventProvider inj2187_EventProvider = inj2208_EventProvider_creational.getInstance(context);
  private final BeanProvider<LayoutSelection> inj2210_LayoutSelection_creational = new BeanProvider<LayoutSelection>() {
    public LayoutSelection getInstance(final CreationalContext context) {
      final LayoutSelection inj2209_LayoutSelection = new LayoutSelection();
      context.addBean(context.getBeanReference(LayoutSelection.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2209_LayoutSelection);
      _$1825231548__$652658075_iocManager(inj2209_LayoutSelection, inj2155_IOCBeanManagerProvider.get());
      return inj2209_LayoutSelection;
    }
  };
  private final LayoutSelection inj2209_LayoutSelection = inj2210_LayoutSelection_creational.getInstance(context);
  private InitializationCallback<PanelManagerImpl> init_inj2211_PanelManagerImpl = new InitializationCallback<PanelManagerImpl>() {
    public void init(final PanelManagerImpl obj) {
      _$389641401_setup(obj);
    }
  };
  private DestructionCallback<PanelManagerImpl> destroy_inj2211_PanelManagerImpl = new DestructionCallback<PanelManagerImpl>() {
    public void destroy(final PanelManagerImpl obj) {
      _$389641401_teardown(obj);
    }
  };
  private final BeanProvider<PanelManagerImpl> inj2212_PanelManagerImpl_creational = new BeanProvider<PanelManagerImpl>() {
    public PanelManagerImpl getInstance(final CreationalContext context) {
      final Event var3 = inj2187_EventProvider.provide(new Class[] { PlaceGainFocusEvent.class }, null);
      final Event var4 = inj2187_EventProvider.provide(new Class[] { PlaceLostFocusEvent.class }, null);
      final Event var5 = inj2187_EventProvider.provide(new Class[] { PanelFocusEvent.class }, null);
      final Event var6 = inj2187_EventProvider.provide(new Class[] { SelectPlaceEvent.class }, null);
      final Event var7 = inj2187_EventProvider.provide(new Class[] { PlaceMaximizedEvent.class }, null);
      final Event var8 = inj2187_EventProvider.provide(new Class[] { PlaceMinimizedEvent.class }, null);
      final Event var9 = inj2187_EventProvider.provide(new Class[] { PlaceHiddenEvent.class }, null);
      final SyncBeanManager var10 = inj2155_IOCBeanManagerProvider.get();
      final Instance var11 = inj2189_InstanceProvider.provide(new Class[] { PlaceManager.class }, null);
      final LayoutSelection var12 = inj2209_LayoutSelection;
      final BeanFactory var13 = inj2198_DefaultBeanFactory;
      final PanelManagerImpl inj2211_PanelManagerImpl = new PanelManagerImpl(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13);
      context.addBean(context.getBeanReference(PanelManagerImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2211_PanelManagerImpl);
      final Subscription var14 = CDI.subscribeLocal("org.uberfire.client.workbench.events.SelectPlaceEvent", new AbstractCDIEventCallback<SelectPlaceEvent>() {
        public void fireEvent(final SelectPlaceEvent event) {
          _$389641401_onSelectPlaceEvent_SelectPlaceEvent(inj2211_PanelManagerImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.SelectPlaceEvent []";
        }
      });
      context.addDestructionCallback(inj2211_PanelManagerImpl, new DestructionCallback<PanelManagerImpl>() {
        public void destroy(final PanelManagerImpl obj) {
          var14.remove();
          // WEEEEE!;
        }
      });
      final Subscription var15 = CDI.subscribeLocal("org.uberfire.client.workbench.events.DropPlaceEvent", new AbstractCDIEventCallback<DropPlaceEvent>() {
        public void fireEvent(final DropPlaceEvent event) {
          _$389641401_onDropPlaceEvent_DropPlaceEvent(inj2211_PanelManagerImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.DropPlaceEvent []";
        }
      });
      context.addDestructionCallback(inj2211_PanelManagerImpl, new DestructionCallback<PanelManagerImpl>() {
        public void destroy(final PanelManagerImpl obj) {
          var15.remove();
          // WEEEEE!;
        }
      });
      final Subscription var16 = CDI.subscribeLocal("org.uberfire.client.workbench.events.ChangeTitleWidgetEvent", new AbstractCDIEventCallback<ChangeTitleWidgetEvent>() {
        public void fireEvent(final ChangeTitleWidgetEvent event) {
          _$389641401_onChangeTitleWidgetEvent_ChangeTitleWidgetEvent(inj2211_PanelManagerImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.ChangeTitleWidgetEvent []";
        }
      });
      context.addDestructionCallback(inj2211_PanelManagerImpl, new DestructionCallback<PanelManagerImpl>() {
        public void destroy(final PanelManagerImpl obj) {
          var16.remove();
          // WEEEEE!;
        }
      });
      context.addInitializationCallback(inj2211_PanelManagerImpl, init_inj2211_PanelManagerImpl);
      context.addDestructionCallback(inj2211_PanelManagerImpl, destroy_inj2211_PanelManagerImpl);
      return inj2211_PanelManagerImpl;
    }
  };
  private final PanelManagerImpl inj2211_PanelManagerImpl = inj2212_PanelManagerImpl_creational.getInstance(context);
  private InitializationCallback<ListBarWidgetImpl> init_inj2213_ListBarWidgetImpl = new InitializationCallback<ListBarWidgetImpl>() {
    public void init(final ListBarWidgetImpl obj) {
      _$1316152188_postConstruct(obj);
    }
  };
  private final BeanProvider<ListBarWidgetImpl> inj2214_ListBarWidgetImpl_creational = new BeanProvider<ListBarWidgetImpl>() {
    public ListBarWidgetImpl getInstance(final CreationalContext context) {
      final ListBarWidgetImpl inj2213_ListBarWidgetImpl = new ListBarWidgetImpl();
      context.addBean(context.getBeanReference(ListBarWidgetImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2213_ListBarWidgetImpl);
      _$1316152188__$903668163_optionalListBarPrefs(inj2213_ListBarWidgetImpl, inj2189_InstanceProvider.provide(new Class[] { ListbarPreferences.class }, null));
      _$1316152188__$262319993_panelManager(inj2213_ListBarWidgetImpl, inj2211_PanelManagerImpl);
      _$1316152188__$1574799830_authzManager(inj2213_ListBarWidgetImpl, inj2206_RuntimeAuthorizationManager);
      _$1316152188__597466346_identity(inj2213_ListBarWidgetImpl, _663569186_produceActiveUser(inj2203_BasicUserCacheImpl));
      context.addInitializationCallback(inj2213_ListBarWidgetImpl, init_inj2213_ListBarWidgetImpl);
      return inj2213_ListBarWidgetImpl;
    }
  };
  private final BeanProvider<SimpleLayoutPanel> inj2217_SimpleLayoutPanel_creational = new BeanProvider<SimpleLayoutPanel>() {
    public SimpleLayoutPanel getInstance(final CreationalContext context) {
      final SimpleLayoutPanel inj1136_SimpleLayoutPanel = new SimpleLayoutPanel();
      context.addBean(context.getBeanReference(SimpleLayoutPanel.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1136_SimpleLayoutPanel);
      return inj1136_SimpleLayoutPanel;
    }
  };
  private final BeanProvider<ResizeFlowPanel> inj2218_ResizeFlowPanel_creational = new BeanProvider<ResizeFlowPanel>() {
    public ResizeFlowPanel getInstance(final CreationalContext context) {
      final ResizeFlowPanel inj1057_ResizeFlowPanel = new ResizeFlowPanel();
      context.addBean(context.getBeanReference(ResizeFlowPanel.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1057_ResizeFlowPanel);
      return inj1057_ResizeFlowPanel;
    }
  };
  private InitializationCallback<ClosableSimpleWorkbenchPanelView> init_inj2215_ClosableSimpleWorkbenchPanelView = new InitializationCallback<ClosableSimpleWorkbenchPanelView>() {
    public void init(final ClosableSimpleWorkbenchPanelView obj) {
      _618642634_setupDockingPanel(obj);
      _1346204971_setup(obj);
    }
  };
  private DestructionCallback<ClosableSimpleWorkbenchPanelView> destroy_inj2215_ClosableSimpleWorkbenchPanelView = new DestructionCallback<ClosableSimpleWorkbenchPanelView>() {
    public void destroy(final ClosableSimpleWorkbenchPanelView obj) {
      _618642634_tearDownDockingPanel(obj);
    }
  };
  private final BeanProvider<ClosableSimpleWorkbenchPanelView> inj2216_ClosableSimpleWorkbenchPanelView_creational = new BeanProvider<ClosableSimpleWorkbenchPanelView>() {
    public ClosableSimpleWorkbenchPanelView getInstance(final CreationalContext context) {
      final ClosableSimpleWorkbenchPanelView inj2215_ClosableSimpleWorkbenchPanelView = new ClosableSimpleWorkbenchPanelView();
      context.addBean(context.getBeanReference(ClosableSimpleWorkbenchPanelView.class, arrayOf_19635043Annotation_1738119949), inj2215_ClosableSimpleWorkbenchPanelView);
      _1346204971__$924432381_listBar(inj2215_ClosableSimpleWorkbenchPanelView, inj2214_ListBarWidgetImpl_creational.getInstance(context));
      _618642634__153624969_dndManager(inj2215_ClosableSimpleWorkbenchPanelView, inj2200_WorkbenchDragAndDropManager);
      _618642634__$1887041540_factory(inj2215_ClosableSimpleWorkbenchPanelView, inj2198_DefaultBeanFactory);
      _618642634__$634457504_topLevelWidget(inj2215_ClosableSimpleWorkbenchPanelView, inj2217_SimpleLayoutPanel_creational.getInstance(context));
      _618642634__820873068_partViewContainer(inj2215_ClosableSimpleWorkbenchPanelView, inj2218_ResizeFlowPanel_creational.getInstance(context));
      _$1397438695__$262319993_panelManager(inj2215_ClosableSimpleWorkbenchPanelView, inj2211_PanelManagerImpl);
      _$1397438695__$1825231548_layoutSelection(inj2215_ClosableSimpleWorkbenchPanelView, inj2209_LayoutSelection);
      context.addInitializationCallback(inj2215_ClosableSimpleWorkbenchPanelView, init_inj2215_ClosableSimpleWorkbenchPanelView);
      context.addDestructionCallback(inj2215_ClosableSimpleWorkbenchPanelView, destroy_inj2215_ClosableSimpleWorkbenchPanelView);
      return inj2215_ClosableSimpleWorkbenchPanelView;
    }
  };
  private final BeanProvider<DestructionImpl> inj2220_DestructionImpl_creational = new BeanProvider<DestructionImpl>() {
    public DestructionImpl getInstance(final CreationalContext context) {
      final DestructionImpl inj2219_DestructionImpl = new DestructionImpl();
      context.addBean(context.getBeanReference(DestructionImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2219_DestructionImpl);
      return inj2219_DestructionImpl;
    }
  };
  private final BeanProvider<EditorJSExporter> inj2222_EditorJSExporter_creational = new BeanProvider<EditorJSExporter>() {
    public EditorJSExporter getInstance(final CreationalContext context) {
      final EditorJSExporter inj2221_EditorJSExporter = new EditorJSExporter();
      context.addBean(context.getBeanReference(EditorJSExporter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2221_EditorJSExporter);
      return inj2221_EditorJSExporter;
    }
  };
  private final EditorJSExporter inj2221_EditorJSExporter = inj2222_EditorJSExporter_creational.getInstance(context);
  private final BeanProvider<URLPatternMatcherProvider> inj2223_URLPatternMatcherProvider_creational = new BeanProvider<URLPatternMatcherProvider>() {
    public URLPatternMatcherProvider getInstance(final CreationalContext context) {
      final URLPatternMatcherProvider inj2025_URLPatternMatcherProvider = new URLPatternMatcherProvider();
      context.addBean(context.getBeanReference(URLPatternMatcherProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2025_URLPatternMatcherProvider);
      return inj2025_URLPatternMatcherProvider;
    }
  };
  private final BeanProvider<NavigationGraph> inj2150_NavigationGraph_creational = new BeanProvider<NavigationGraph>() {
    public NavigationGraph getInstance(CreationalContext pContext) {
      NavigationGraph var17 = inj2223_URLPatternMatcherProvider_creational.getInstance(context).createNavigationGraph();
      context.addBean(context.getBeanReference(NavigationGraph.class, QualifierUtil.DEFAULT_QUALIFIERS), var17);
      return var17;
    }
  };
  private final BeanProvider<URLPatternMatcher> inj2147_URLPatternMatcher_creational = new BeanProvider<URLPatternMatcher>() {
    public URLPatternMatcher getInstance(CreationalContext pContext) {
      final BeanProvider<NavigationGraph> var19 = new BeanProvider<NavigationGraph>() {
        public NavigationGraph getInstance(CreationalContext pContext) {
          NavigationGraph var19 = inj2223_URLPatternMatcherProvider_creational.getInstance(context).createNavigationGraph();
          context.addBean(context.getBeanReference(NavigationGraph.class, QualifierUtil.DEFAULT_QUALIFIERS), var19);
          return var19;
        }
      };
      URLPatternMatcher var18 = inj2223_URLPatternMatcherProvider_creational.getInstance(context).createURLPatternMatcher(context.getSingletonInstanceOrNew(injContext, var19, NavigationGraph.class, QualifierUtil.DEFAULT_QUALIFIERS));
      context.addBean(context.getBeanReference(URLPatternMatcher.class, QualifierUtil.DEFAULT_QUALIFIERS), var18);
      return var18;
    }
  };
  private final BeanProvider<HistoryTokenFactory> inj2225_HistoryTokenFactory_creational = new BeanProvider<HistoryTokenFactory>() {
    public HistoryTokenFactory getInstance(final CreationalContext context) {
      final BeanProvider<NavigationGraph> var21 = new BeanProvider<NavigationGraph>() {
        public NavigationGraph getInstance(CreationalContext pContext) {
          NavigationGraph var21 = inj2223_URLPatternMatcherProvider_creational.getInstance(context).createNavigationGraph();
          context.addBean(context.getBeanReference(NavigationGraph.class, QualifierUtil.DEFAULT_QUALIFIERS), var21);
          return var21;
        }
      };
      final NavigationGraph var22 = ((SimpleCreationalContext) context).getSingletonInstanceOrNew(injContext, var21, NavigationGraph.class, QualifierUtil.DEFAULT_QUALIFIERS);
      final BeanProvider<URLPatternMatcher> var20 = new BeanProvider<URLPatternMatcher>() {
        public URLPatternMatcher getInstance(CreationalContext pContext) {
          URLPatternMatcher var20 = inj2223_URLPatternMatcherProvider_creational.getInstance(context).createURLPatternMatcher(var22);
          context.addBean(context.getBeanReference(URLPatternMatcher.class, QualifierUtil.DEFAULT_QUALIFIERS), var20);
          return var20;
        }
      };
      final URLPatternMatcher var23 = ((SimpleCreationalContext) context).getSingletonInstanceOrNew(injContext, var20, URLPatternMatcher.class, QualifierUtil.DEFAULT_QUALIFIERS);
      final HistoryTokenFactory inj2224_HistoryTokenFactory = new HistoryTokenFactory(var23);
      context.addBean(context.getBeanReference(HistoryTokenFactory.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2224_HistoryTokenFactory);
      return inj2224_HistoryTokenFactory;
    }
  };
  private final HistoryTokenFactory inj2224_HistoryTokenFactory = inj2225_HistoryTokenFactory_creational.getInstance(context);
  private final BeanProvider<StateChangeImpl> inj2227_StateChangeImpl_creational = new BeanProvider<StateChangeImpl>() {
    public StateChangeImpl getInstance(final CreationalContext context) {
      final StateChangeImpl inj2226_StateChangeImpl = new StateChangeImpl();
      context.addBean(context.getBeanReference(StateChangeImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2226_StateChangeImpl);
      return inj2226_StateChangeImpl;
    }
  };
  private InitializationCallback<Navigation> init_inj2228_Navigation = new InitializationCallback<Navigation>() {
    public void init(final Navigation obj) {
      _136504311_init(obj);
    }
  };
  private DestructionCallback<Navigation> destroy_inj2228_Navigation = new DestructionCallback<Navigation>() {
    public void destroy(final Navigation obj) {
      obj.cleanUp();
    }
  };
  private final BeanProvider<Navigation> inj2229_Navigation_creational = new BeanProvider<Navigation>() {
    public Navigation getInstance(final CreationalContext context) {
      final Navigation inj2228_Navigation = new Navigation();
      context.addBean(context.getBeanReference(Navigation.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2228_Navigation);
      final Logger var24 = LoggerFactory.getLogger("org.jboss.errai.ui.nav.client.local.Navigation");
      _136504311__1388723237_logger(inj2228_Navigation, var24);
      final BeanProvider<NavigationGraph> var25 = new BeanProvider<NavigationGraph>() {
        public NavigationGraph getInstance(CreationalContext pContext) {
          NavigationGraph var25 = inj2223_URLPatternMatcherProvider_creational.getInstance(context).createNavigationGraph();
          context.addBean(context.getBeanReference(NavigationGraph.class, QualifierUtil.DEFAULT_QUALIFIERS), var25);
          return var25;
        }
      };
      _136504311__2062761173_navGraph(inj2228_Navigation, ((SimpleCreationalContext) context).getSingletonInstanceOrNew(injContext, var25, NavigationGraph.class, QualifierUtil.DEFAULT_QUALIFIERS));
      _136504311__$2056551207_stateChangeEvent(inj2228_Navigation, inj2227_StateChangeImpl_creational.getInstance(context));
      _136504311__515581186_historyTokenFactory(inj2228_Navigation, inj2224_HistoryTokenFactory);
      context.addInitializationCallback(inj2228_Navigation, init_inj2228_Navigation);
      context.addDestructionCallback(inj2228_Navigation, destroy_inj2228_Navigation);
      return inj2228_Navigation;
    }
  };
  private final Navigation inj2228_Navigation = inj2229_Navigation_creational.getInstance(context);
  private final BeanProvider<NavigationPanelProvider> inj2230_NavigationPanelProvider_creational = new BeanProvider<NavigationPanelProvider>() {
    public NavigationPanelProvider getInstance(final CreationalContext context) {
      final NavigationPanelProvider inj2159_NavigationPanelProvider = new NavigationPanelProvider();
      context.addBean(context.getBeanReference(NavigationPanelProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2159_NavigationPanelProvider);
      _2051073374__136504311_navigation(inj2159_NavigationPanelProvider, inj2228_Navigation);
      return inj2159_NavigationPanelProvider;
    }
  };
  private final NavigationPanelProvider inj2159_NavigationPanelProvider = inj2230_NavigationPanelProvider_creational.getInstance(context);
  private final BeanProvider<WorkbenchViewModeSwitcherMenuBuilder> inj2232_WorkbenchViewModeSwitcherMenuBuilder_creational = new BeanProvider<WorkbenchViewModeSwitcherMenuBuilder>() {
    public WorkbenchViewModeSwitcherMenuBuilder getInstance(final CreationalContext context) {
      final WorkbenchViewModeSwitcherMenuBuilder inj2231_WorkbenchViewModeSwitcherMenuBuilder = new WorkbenchViewModeSwitcherMenuBuilder();
      context.addBean(context.getBeanReference(WorkbenchViewModeSwitcherMenuBuilder.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2231_WorkbenchViewModeSwitcherMenuBuilder);
      return inj2231_WorkbenchViewModeSwitcherMenuBuilder;
    }
  };
  private final BeanProvider<CallerProvider> inj2233_CallerProvider_creational = new BeanProvider<CallerProvider>() {
    public CallerProvider getInstance(final CreationalContext context) {
      final CallerProvider inj2161_CallerProvider = new CallerProvider();
      context.addBean(context.getBeanReference(CallerProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2161_CallerProvider);
      return inj2161_CallerProvider;
    }
  };
  private final CallerProvider inj2161_CallerProvider = inj2233_CallerProvider_creational.getInstance(context);
  private InitializationCallback<SecurityContextImpl> init_inj2234_SecurityContextImpl = new InitializationCallback<SecurityContextImpl>() {
    public void init(final SecurityContextImpl obj) {
      _378913974_setup(obj);
    }
  };
  private final BeanProvider<SecurityContextImpl> inj2235_SecurityContextImpl_creational = new BeanProvider<SecurityContextImpl>() {
    public SecurityContextImpl getInstance(final CreationalContext context) {
      final SecurityContextImpl inj2234_SecurityContextImpl = new SecurityContextImpl();
      context.addBean(context.getBeanReference(SecurityContextImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2234_SecurityContextImpl);
      _378913974__1116818801_loginEvent(inj2234_SecurityContextImpl, inj2187_EventProvider.provide(new Class[] { LoggedInEvent.class }, null));
      _378913974__1116818801_logoutEvent(inj2234_SecurityContextImpl, inj2187_EventProvider.provide(new Class[] { LoggedOutEvent.class }, null));
      _378913974__136504311_navigation(inj2234_SecurityContextImpl, inj2228_Navigation);
      _378913974__$282317259_userCache(inj2234_SecurityContextImpl, inj2203_BasicUserCacheImpl);
      final Logger var26 = LoggerFactory.getLogger("org.jboss.errai.security.client.local.context.SecurityContextImpl");
      _378913974__1388723237_logger(inj2234_SecurityContextImpl, var26);
      _378913974__120980481_userServiceCaller(inj2234_SecurityContextImpl, inj2161_CallerProvider.provide(new Class[] { NonCachingUserService.class }, null));
      context.addInitializationCallback(inj2234_SecurityContextImpl, init_inj2234_SecurityContextImpl);
      return inj2234_SecurityContextImpl;
    }
  };
  private final SecurityContextImpl inj2234_SecurityContextImpl = inj2235_SecurityContextImpl_creational.getInstance(context);
  private final BeanProvider<ClientRequiredRolesExtractorImpl> inj2237_ClientRequiredRolesExtractorImpl_creational = new BeanProvider<ClientRequiredRolesExtractorImpl>() {
    public ClientRequiredRolesExtractorImpl getInstance(final CreationalContext context) {
      final ClientRequiredRolesExtractorImpl inj2236_ClientRequiredRolesExtractorImpl = new ClientRequiredRolesExtractorImpl();
      context.addBean(context.getBeanReference(ClientRequiredRolesExtractorImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2236_ClientRequiredRolesExtractorImpl);
      return inj2236_ClientRequiredRolesExtractorImpl;
    }
  };
  private final BeanProvider<ClientSecurityRoleInterceptor> inj2239_ClientSecurityRoleInterceptor_creational = new BeanProvider<ClientSecurityRoleInterceptor>() {
    public ClientSecurityRoleInterceptor getInstance(final CreationalContext context) {
      final SecurityContext var27 = inj2234_SecurityContextImpl;
      final RequiredRolesExtractor var28 = inj2237_ClientRequiredRolesExtractorImpl_creational.getInstance(context);
      final ClientSecurityRoleInterceptor inj2238_ClientSecurityRoleInterceptor = new ClientSecurityRoleInterceptor(var27, var28);
      context.addBean(context.getBeanReference(ClientSecurityRoleInterceptor.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2238_ClientSecurityRoleInterceptor);
      return inj2238_ClientSecurityRoleInterceptor;
    }
  };
  private final BeanProvider<HeaderPanel> inj2242_HeaderPanel_creational = new BeanProvider<HeaderPanel>() {
    public HeaderPanel getInstance(final CreationalContext context) {
      final HeaderPanel inj1446_HeaderPanel = new HeaderPanel();
      context.addBean(context.getBeanReference(HeaderPanel.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1446_HeaderPanel);
      return inj1446_HeaderPanel;
    }
  };
  private InitializationCallback<WorkbenchLayoutImpl> init_inj2240_WorkbenchLayoutImpl = new InitializationCallback<WorkbenchLayoutImpl>() {
    public void init(final WorkbenchLayoutImpl obj) {
      _1934862923_init(obj);
    }
  };
  private final BeanProvider<WorkbenchLayoutImpl> inj2241_WorkbenchLayoutImpl_creational = new BeanProvider<WorkbenchLayoutImpl>() {
    public WorkbenchLayoutImpl getInstance(final CreationalContext context) {
      final WorkbenchLayoutImpl inj2240_WorkbenchLayoutImpl = new WorkbenchLayoutImpl();
      context.addBean(context.getBeanReference(WorkbenchLayoutImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2240_WorkbenchLayoutImpl);
      _1934862923__$652658075_iocManager(inj2240_WorkbenchLayoutImpl, inj2155_IOCBeanManagerProvider.get());
      _1934862923__$1393584145_root(inj2240_WorkbenchLayoutImpl, inj2242_HeaderPanel_creational.getInstance(context));
      _1934862923__153624969_dndManager(inj2240_WorkbenchLayoutImpl, inj2200_WorkbenchDragAndDropManager);
      _1934862923__683332058_dragController(inj2240_WorkbenchLayoutImpl, inj2194_WorkbenchPickupDragController);
      context.addInitializationCallback(inj2240_WorkbenchLayoutImpl, init_inj2240_WorkbenchLayoutImpl);
      return inj2240_WorkbenchLayoutImpl;
    }
  };
  private final WorkbenchLayoutImpl inj2240_WorkbenchLayoutImpl = inj2241_WorkbenchLayoutImpl_creational.getInstance(context);
  private final BeanProvider<WorkbenchLayoutInfoImpl> inj2244_WorkbenchLayoutInfoImpl_creational = new BeanProvider<WorkbenchLayoutInfoImpl>() {
    public WorkbenchLayoutInfoImpl getInstance(final CreationalContext context) {
      final WorkbenchLayoutInfoImpl inj2243_WorkbenchLayoutInfoImpl = new WorkbenchLayoutInfoImpl();
      context.addBean(context.getBeanReference(WorkbenchLayoutInfoImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2243_WorkbenchLayoutInfoImpl);
      _364015257__1934862923_workbenchLayout(inj2243_WorkbenchLayoutInfoImpl, inj2240_WorkbenchLayoutImpl);
      return inj2243_WorkbenchLayoutInfoImpl;
    }
  };
  private final WorkbenchLayoutInfoImpl inj2243_WorkbenchLayoutInfoImpl = inj2244_WorkbenchLayoutInfoImpl_creational.getInstance(context);
  private final BeanProvider<ActivityLifecycleErrorHandler> inj2246_ActivityLifecycleErrorHandler_creational = new BeanProvider<ActivityLifecycleErrorHandler>() {
    public ActivityLifecycleErrorHandler getInstance(final CreationalContext context) {
      final ActivityLifecycleErrorHandler inj2245_ActivityLifecycleErrorHandler = new ActivityLifecycleErrorHandler();
      context.addBean(context.getBeanReference(ActivityLifecycleErrorHandler.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2245_ActivityLifecycleErrorHandler);
      final Logger var29 = LoggerFactory.getLogger("org.uberfire.client.mvp.ActivityLifecycleErrorHandler");
      _$1934524921__1388723237_logger(inj2245_ActivityLifecycleErrorHandler, var29);
      _$1934524921__1116818801_lifecycleErrorEvent(inj2245_ActivityLifecycleErrorHandler, inj2187_EventProvider.provide(new Class[] { ActivityLifecycleError.class }, null));
      final NotificationManager_inj2247_proxy inj2247_proxy = new NotificationManager_inj2247_proxy();
      context.addUnresolvedProxy(new ProxyResolver<NotificationManager>() {
        public void resolve(NotificationManager obj) {
          inj2247_proxy.__$setProxiedInstance$(obj);
          context.addProxyReference(inj2247_proxy, obj);
        }
      }, NotificationManager.class, QualifierUtil.DEFAULT_QUALIFIERS);
      _$1934524921__383150079_notificationManager(inj2245_ActivityLifecycleErrorHandler, inj2247_proxy);
      return inj2245_ActivityLifecycleErrorHandler;
    }
  };
  private final ActivityLifecycleErrorHandler inj2245_ActivityLifecycleErrorHandler = inj2246_ActivityLifecycleErrorHandler_creational.getInstance(context);
  private final BeanProvider<NotificationManager> inj2249_NotificationManager_creational = new BeanProvider<NotificationManager>() {
    public NotificationManager getInstance(final CreationalContext context) {
      final SyncBeanManager var30 = inj2155_IOCBeanManagerProvider.get();
      final PlaceManager_inj2250_proxy inj2250_proxy = new PlaceManager_inj2250_proxy();
      context.addUnresolvedProxy(new ProxyResolver<PlaceManager>() {
        public void resolve(PlaceManager obj) {
          inj2250_proxy.__$setProxiedInstance$(obj);
          context.addProxyReference(inj2250_proxy, obj);
        }
      }, PlaceManager.class, QualifierUtil.DEFAULT_QUALIFIERS);
      final PlaceManager var31 = inj2250_proxy;
      final WorkbenchLayoutInfo var32 = inj2243_WorkbenchLayoutInfoImpl;
      final NotificationManager inj2248_NotificationManager = new NotificationManager(var30, var31, var32);
      context.addBean(context.getBeanReference(NotificationManager.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2248_NotificationManager);
      final Subscription var33 = CDI.subscribeLocal("org.uberfire.workbench.events.NotificationEvent", new AbstractCDIEventCallback<NotificationEvent>() {
        public void fireEvent(final NotificationEvent event) {
          inj2248_NotificationManager.addNotification(event);
        }
        public String toString() {
          return "Observer: org.uberfire.workbench.events.NotificationEvent []";
        }
      });
      context.addDestructionCallback(inj2248_NotificationManager, new DestructionCallback<NotificationManager>() {
        public void destroy(final NotificationManager obj) {
          var33.remove();
          // WEEEEE!;
        }
      });
      final Subscription var34 = CDI.subscribeLocal("org.uberfire.client.workbench.events.ClosePlaceEvent", new AbstractCDIEventCallback<ClosePlaceEvent>() {
        public void fireEvent(final ClosePlaceEvent event) {
          inj2248_NotificationManager.onClosePlaceEvent(event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.ClosePlaceEvent []";
        }
      });
      context.addDestructionCallback(inj2248_NotificationManager, new DestructionCallback<NotificationManager>() {
        public void destroy(final NotificationManager obj) {
          var34.remove();
          // WEEEEE!;
        }
      });
      final Subscription var35 = CDI.subscribeLocal("org.uberfire.client.workbench.events.PlaceLostFocusEvent", new AbstractCDIEventCallback<PlaceLostFocusEvent>() {
        public void fireEvent(final PlaceLostFocusEvent event) {
          inj2248_NotificationManager.onPlaceLostFocus(event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.PlaceLostFocusEvent []";
        }
      });
      context.addDestructionCallback(inj2248_NotificationManager, new DestructionCallback<NotificationManager>() {
        public void destroy(final NotificationManager obj) {
          var35.remove();
          // WEEEEE!;
        }
      });
      return inj2248_NotificationManager;
    }
  };
  private final NotificationManager inj2248_NotificationManager = inj2249_NotificationManager_creational.getInstance(context);
  private final BeanProvider<WorkbenchServicesProxyBackendImpl> inj2252_WorkbenchServicesProxyBackendImpl_creational = new BeanProvider<WorkbenchServicesProxyBackendImpl>() {
    public WorkbenchServicesProxyBackendImpl getInstance(final CreationalContext context) {
      final WorkbenchServicesProxyBackendImpl inj2251_WorkbenchServicesProxyBackendImpl = new WorkbenchServicesProxyBackendImpl();
      context.addBean(context.getBeanReference(WorkbenchServicesProxyBackendImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2251_WorkbenchServicesProxyBackendImpl);
      _596565460__120980481_workbenchServices(inj2251_WorkbenchServicesProxyBackendImpl, inj2161_CallerProvider.provide(new Class[] { WorkbenchServices.class }, null));
      return inj2251_WorkbenchServicesProxyBackendImpl;
    }
  };
  private final BeanProvider<WorkbenchServicesProxyClientImpl> inj2254_WorkbenchServicesProxyClientImpl_creational = new BeanProvider<WorkbenchServicesProxyClientImpl>() {
    public WorkbenchServicesProxyClientImpl getInstance(final CreationalContext context) {
      final WorkbenchServicesProxyClientImpl inj2253_WorkbenchServicesProxyClientImpl = new WorkbenchServicesProxyClientImpl();
      context.addBean(context.getBeanReference(WorkbenchServicesProxyClientImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2253_WorkbenchServicesProxyClientImpl);
      return inj2253_WorkbenchServicesProxyClientImpl;
    }
  };
  private final BeanProvider<PerspectiveManagerImpl> inj2256_PerspectiveManagerImpl_creational = new BeanProvider<PerspectiveManagerImpl>() {
    public PerspectiveManagerImpl getInstance(final CreationalContext context) {
      final PerspectiveManagerImpl inj2255_PerspectiveManagerImpl = new PerspectiveManagerImpl();
      context.addBean(context.getBeanReference(PerspectiveManagerImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2255_PerspectiveManagerImpl);
      _$348507737__$262319993_panelManager(inj2255_PerspectiveManagerImpl, inj2211_PanelManagerImpl);
      _$348507737__$304677073_wbServices(inj2255_PerspectiveManagerImpl, inj2252_WorkbenchServicesProxyBackendImpl_creational.getInstance(context));
      _$348507737__1116818801_perspectiveChangeEvent(inj2255_PerspectiveManagerImpl, inj2187_EventProvider.provide(new Class[] { PerspectiveChange.class }, null));
      return inj2255_PerspectiveManagerImpl;
    }
  };
  private final PerspectiveManagerImpl inj2255_PerspectiveManagerImpl = inj2256_PerspectiveManagerImpl_creational.getInstance(context);
  private InitializationCallback<ActivityBeansCache> init_inj2257_ActivityBeansCache = new InitializationCallback<ActivityBeansCache>() {
    public void init(final ActivityBeansCache obj) {
      _2052955140_init(obj);
    }
  };
  private final BeanProvider<ActivityBeansCache> inj2258_ActivityBeansCache_creational = new BeanProvider<ActivityBeansCache>() {
    public ActivityBeansCache getInstance(final CreationalContext context) {
      final ActivityBeansCache inj2257_ActivityBeansCache = new ActivityBeansCache();
      context.addBean(context.getBeanReference(ActivityBeansCache.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2257_ActivityBeansCache);
      _2052955140__$652658075_iocManager(inj2257_ActivityBeansCache, inj2155_IOCBeanManagerProvider.get());
      _2052955140__1116818801_newPerspectiveEventEvent(inj2257_ActivityBeansCache, inj2187_EventProvider.provide(new Class[] { NewPerspectiveEvent.class }, null));
      _2052955140__1116818801_newWorkbenchScreenEventEvent(inj2257_ActivityBeansCache, inj2187_EventProvider.provide(new Class[] { NewWorkbenchScreenEvent.class }, null));
      context.addInitializationCallback(inj2257_ActivityBeansCache, init_inj2257_ActivityBeansCache);
      return inj2257_ActivityBeansCache;
    }
  };
  private final ActivityBeansCache inj2257_ActivityBeansCache = inj2258_ActivityBeansCache_creational.getInstance(context);
  private final BeanProvider<ActivityManagerImpl> inj2260_ActivityManagerImpl_creational = new BeanProvider<ActivityManagerImpl>() {
    public ActivityManagerImpl getInstance(final CreationalContext context) {
      final ActivityManagerImpl inj2259_ActivityManagerImpl = new ActivityManagerImpl();
      context.addBean(context.getBeanReference(ActivityManagerImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2259_ActivityManagerImpl);
      _1730935432__$652658075_iocManager(inj2259_ActivityManagerImpl, inj2155_IOCBeanManagerProvider.get());
      _1730935432__$1574799830_authzManager(inj2259_ActivityManagerImpl, inj2206_RuntimeAuthorizationManager);
      _1730935432__2052955140_activityBeansCache(inj2259_ActivityManagerImpl, inj2257_ActivityBeansCache);
      _1730935432__597466346_identity(inj2259_ActivityManagerImpl, _663569186_produceActiveUser(inj2203_BasicUserCacheImpl));
      _1730935432__$1934524921_lifecycleErrorHandler(inj2259_ActivityManagerImpl, inj2245_ActivityLifecycleErrorHandler);
      return inj2259_ActivityManagerImpl;
    }
  };
  private final ActivityManagerImpl inj2259_ActivityManagerImpl = inj2260_ActivityManagerImpl_creational.getInstance(context);
  private final BeanProvider<PlaceRequestHistoryMapperImpl> inj2263_PlaceRequestHistoryMapperImpl_creational = new BeanProvider<PlaceRequestHistoryMapperImpl>() {
    public PlaceRequestHistoryMapperImpl getInstance(final CreationalContext context) {
      final PlaceRequestHistoryMapperImpl inj1775_PlaceRequestHistoryMapperImpl = new PlaceRequestHistoryMapperImpl();
      context.addBean(context.getBeanReference(PlaceRequestHistoryMapperImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1775_PlaceRequestHistoryMapperImpl);
      return inj1775_PlaceRequestHistoryMapperImpl;
    }
  };
  private final BeanProvider<PlaceHistoryHandler> inj2262_PlaceHistoryHandler_creational = new BeanProvider<PlaceHistoryHandler>() {
    public PlaceHistoryHandler getInstance(final CreationalContext context) {
      final PlaceHistoryHandler inj2261_PlaceHistoryHandler = new PlaceHistoryHandler();
      context.addBean(context.getBeanReference(PlaceHistoryHandler.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2261_PlaceHistoryHandler);
      _1047951015__$695339145_mapper(inj2261_PlaceHistoryHandler, inj2263_PlaceRequestHistoryMapperImpl_creational.getInstance(context));
      return inj2261_PlaceHistoryHandler;
    }
  };
  private InitializationCallback<PlaceManagerImpl> init_inj2264_PlaceManagerImpl = new InitializationCallback<PlaceManagerImpl>() {
    public void init(final PlaceManagerImpl obj) {
      obj.initPlaceHistoryHandler();
    }
  };
  private final BeanProvider<PlaceManagerImpl> inj2265_PlaceManagerImpl_creational = new BeanProvider<PlaceManagerImpl>() {
    public PlaceManagerImpl getInstance(final CreationalContext context) {
      final PlaceManagerImpl inj2264_PlaceManagerImpl = new PlaceManagerImpl();
      context.addBean(context.getBeanReference(PlaceManagerImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2264_PlaceManagerImpl);
      _$1757102468__1116818801_workbenchPartBeforeCloseEvent(inj2264_PlaceManagerImpl, inj2187_EventProvider.provide(new Class[] { BeforeClosePlaceEvent.class }, null));
      _$1757102468__1116818801_workbenchPartCloseEvent(inj2264_PlaceManagerImpl, inj2187_EventProvider.provide(new Class[] { ClosePlaceEvent.class }, null));
      _$1757102468__1116818801_newSplashScreenActiveEvent(inj2264_PlaceManagerImpl, inj2187_EventProvider.provide(new Class[] { NewSplashScreenActiveEvent.class }, null));
      _$1757102468__$1583970232_activityManager(inj2264_PlaceManagerImpl, inj2259_ActivityManagerImpl);
      _$1757102468__1047951015_placeHistoryHandler(inj2264_PlaceManagerImpl, inj2262_PlaceHistoryHandler_creational.getInstance(context));
      _$1757102468__1116818801_selectWorkbenchPartEvent(inj2264_PlaceManagerImpl, inj2187_EventProvider.provide(new Class[] { SelectPlaceEvent.class }, null));
      _$1757102468__$262319993_panelManager(inj2264_PlaceManagerImpl, inj2211_PanelManagerImpl);
      _$1757102468__$1335679257_perspectiveManager(inj2264_PlaceManagerImpl, inj2255_PerspectiveManagerImpl);
      _$1757102468__$1934524921_lifecycleErrorHandler(inj2264_PlaceManagerImpl, inj2245_ActivityLifecycleErrorHandler);
      _$1757102468__$1825231548_layoutSelection(inj2264_PlaceManagerImpl, inj2209_LayoutSelection);
      final Subscription var36 = CDI.subscribeLocal("org.uberfire.client.workbench.events.PlaceGainFocusEvent", new AbstractCDIEventCallback<PlaceGainFocusEvent>() {
        public void fireEvent(final PlaceGainFocusEvent event) {
          _$1757102468_onWorkbenchPartOnFocus_PlaceGainFocusEvent(inj2264_PlaceManagerImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.PlaceGainFocusEvent []";
        }
      });
      context.addDestructionCallback(inj2264_PlaceManagerImpl, new DestructionCallback<PlaceManagerImpl>() {
        public void destroy(final PlaceManagerImpl obj) {
          var36.remove();
          // WEEEEE!;
        }
      });
      final Subscription var37 = CDI.subscribeLocal("org.uberfire.client.workbench.events.PlaceLostFocusEvent", new AbstractCDIEventCallback<PlaceLostFocusEvent>() {
        public void fireEvent(final PlaceLostFocusEvent event) {
          _$1757102468_onWorkbenchPartLostFocus_PlaceLostFocusEvent(inj2264_PlaceManagerImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.PlaceLostFocusEvent []";
        }
      });
      context.addDestructionCallback(inj2264_PlaceManagerImpl, new DestructionCallback<PlaceManagerImpl>() {
        public void destroy(final PlaceManagerImpl obj) {
          var37.remove();
          // WEEEEE!;
        }
      });
      context.addInitializationCallback(inj2264_PlaceManagerImpl, init_inj2264_PlaceManagerImpl);
      return inj2264_PlaceManagerImpl;
    }
  };
  private final PlaceManagerImpl inj2264_PlaceManagerImpl = inj2265_PlaceManagerImpl_creational.getInstance(context);
  private final BeanProvider<WorkbenchToolBarView> inj2268_WorkbenchToolBarView_creational = new BeanProvider<WorkbenchToolBarView>() {
    public WorkbenchToolBarView getInstance(final CreationalContext context) {
      final WorkbenchToolBarView inj601_WorkbenchToolBarView = new WorkbenchToolBarView();
      context.addBean(context.getBeanReference(WorkbenchToolBarView.class, QualifierUtil.DEFAULT_QUALIFIERS), inj601_WorkbenchToolBarView);
      return inj601_WorkbenchToolBarView;
    }
  };
  private final BeanProvider<WorkbenchToolBarPresenter> inj2267_WorkbenchToolBarPresenter_creational = new BeanProvider<WorkbenchToolBarPresenter>() {
    public WorkbenchToolBarPresenter getInstance(final CreationalContext context) {
      final WorkbenchToolBarPresenter inj2266_WorkbenchToolBarPresenter = new WorkbenchToolBarPresenter();
      context.addBean(context.getBeanReference(WorkbenchToolBarPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2266_WorkbenchToolBarPresenter);
      _40974972__$1426067475_view(inj2266_WorkbenchToolBarPresenter, inj2268_WorkbenchToolBarView_creational.getInstance(context));
      _40974972__$906533316_placeManager(inj2266_WorkbenchToolBarPresenter, inj2264_PlaceManagerImpl);
      final Subscription var38 = CDI.subscribeLocal("org.uberfire.client.workbench.events.ClosePlaceEvent", new AbstractCDIEventCallback<ClosePlaceEvent>() {
        public void fireEvent(final ClosePlaceEvent event) {
          _40974972_onWorkbenchPartClose_ClosePlaceEvent(inj2266_WorkbenchToolBarPresenter, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.ClosePlaceEvent []";
        }
      });
      context.addDestructionCallback(inj2266_WorkbenchToolBarPresenter, new DestructionCallback<WorkbenchToolBarPresenter>() {
        public void destroy(final WorkbenchToolBarPresenter obj) {
          var38.remove();
          // WEEEEE!;
        }
      });
      final Subscription var39 = CDI.subscribeLocal("org.uberfire.client.workbench.events.PlaceGainFocusEvent", new AbstractCDIEventCallback<PlaceGainFocusEvent>() {
        public void fireEvent(final PlaceGainFocusEvent event) {
          _40974972_onWorkbenchPartOnFocus_PlaceGainFocusEvent(inj2266_WorkbenchToolBarPresenter, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.PlaceGainFocusEvent []";
        }
      });
      context.addDestructionCallback(inj2266_WorkbenchToolBarPresenter, new DestructionCallback<WorkbenchToolBarPresenter>() {
        public void destroy(final WorkbenchToolBarPresenter obj) {
          var39.remove();
          // WEEEEE!;
        }
      });
      return inj2266_WorkbenchToolBarPresenter;
    }
  };
  private final WorkbenchToolBarPresenter inj2266_WorkbenchToolBarPresenter = inj2267_WorkbenchToolBarPresenter_creational.getInstance(context);
  private final BeanProvider<DisposerProvider> inj2269_DisposerProvider_creational = new BeanProvider<DisposerProvider>() {
    public DisposerProvider getInstance(final CreationalContext context) {
      final DisposerProvider inj2163_DisposerProvider = new DisposerProvider();
      context.addBean(context.getBeanReference(DisposerProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2163_DisposerProvider);
      _$1300398733__$652658075_beanManager(inj2163_DisposerProvider, inj2155_IOCBeanManagerProvider.get());
      return inj2163_DisposerProvider;
    }
  };
  private final DisposerProvider inj2163_DisposerProvider = inj2269_DisposerProvider_creational.getInstance(context);
  private final BeanProvider<ErrorPopupView> inj2271_ErrorPopupView_creational = new BeanProvider<ErrorPopupView>() {
    public ErrorPopupView getInstance(final CreationalContext context) {
      final ErrorPopupView inj2270_ErrorPopupView = new ErrorPopupView();
      context.addBean(context.getBeanReference(ErrorPopupView.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2270_ErrorPopupView);
      _1252540070__$903668163_modalFactory(inj2270_ErrorPopupView, inj2189_InstanceProvider.provide(new Class[] { Bs3Modal.class }, null));
      return inj2270_ErrorPopupView;
    }
  };
  private final BeanProvider<DotResourceTypeDefinition> inj2273_DotResourceTypeDefinition_creational = new BeanProvider<DotResourceTypeDefinition>() {
    public DotResourceTypeDefinition getInstance(final CreationalContext context) {
      final DotResourceTypeDefinition inj2272_DotResourceTypeDefinition = new DotResourceTypeDefinition();
      context.addBean(context.getBeanReference(DotResourceTypeDefinition.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2272_DotResourceTypeDefinition);
      return inj2272_DotResourceTypeDefinition;
    }
  };
  private final DotResourceTypeDefinition inj2272_DotResourceTypeDefinition = inj2273_DotResourceTypeDefinition_creational.getInstance(context);
  private final BeanProvider<AuthenticationServiceInterceptor> inj2275_AuthenticationServiceInterceptor_creational = new BeanProvider<AuthenticationServiceInterceptor>() {
    public AuthenticationServiceInterceptor getInstance(final CreationalContext context) {
      final SecurityContext var40 = inj2234_SecurityContextImpl;
      final AuthenticationServiceInterceptor inj2274_AuthenticationServiceInterceptor = new AuthenticationServiceInterceptor(var40);
      context.addBean(context.getBeanReference(AuthenticationServiceInterceptor.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2274_AuthenticationServiceInterceptor);
      return inj2274_AuthenticationServiceInterceptor;
    }
  };
  private InitializationCallback<ComponentView> init_inj2276_ComponentView = new InitializationCallback<ComponentView>() {
    public void init(final ComponentView obj) {
      obj.setup();
    }
  };
  private final BeanProvider<ComponentView> inj2277_ComponentView_creational = new BeanProvider<ComponentView>() {
    public ComponentView getInstance(final CreationalContext context) {
      final ComponentView inj2276_ComponentView = new ComponentView();
      context.addBean(context.getBeanReference(ComponentView.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2276_ComponentView);
      context.addInitializationCallback(inj2276_ComponentView, init_inj2276_ComponentView);
      return inj2276_ComponentView;
    }
  };
  private InitializationCallback<ComponentPresenter> init_inj2278_ComponentPresenter = new InitializationCallback<ComponentPresenter>() {
    public void init(final ComponentPresenter obj) {
      _$1732630359_init(obj);
    }
  };
  private final BeanProvider<ComponentPresenter> inj2279_ComponentPresenter_creational = new BeanProvider<ComponentPresenter>() {
    public ComponentPresenter getInstance(final CreationalContext context) {
      final ComponentPresenter inj2278_ComponentPresenter = new ComponentPresenter();
      context.addBean(context.getBeanReference(ComponentPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2278_ComponentPresenter);
      _$1732630359__120980481_myService(inj2278_ComponentPresenter, inj2161_CallerProvider.provide(new Class[] { MyService.class }, null));
      _$1732630359__803591648_view(inj2278_ComponentPresenter, inj2277_ComponentView_creational.getInstance(context));
      context.addInitializationCallback(inj2278_ComponentPresenter, init_inj2278_ComponentPresenter);
      return inj2278_ComponentPresenter;
    }
  };
  private InitializationCallback<WorkbenchMenuStandardNavBarView> init_inj2280_WorkbenchMenuStandardNavBarView = new InitializationCallback<WorkbenchMenuStandardNavBarView>() {
    public void init(final WorkbenchMenuStandardNavBarView obj) {
      _$110318115_setup(obj);
    }
  };
  private final BeanProvider<WorkbenchMenuStandardNavBarView> inj2281_WorkbenchMenuStandardNavBarView_creational = new BeanProvider<WorkbenchMenuStandardNavBarView>() {
    public WorkbenchMenuStandardNavBarView getInstance(final CreationalContext context) {
      final WorkbenchMenuStandardNavBarView inj2280_WorkbenchMenuStandardNavBarView = new WorkbenchMenuStandardNavBarView();
      context.addBean(context.getBeanReference(WorkbenchMenuStandardNavBarView.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2280_WorkbenchMenuStandardNavBarView);
      context.addInitializationCallback(inj2280_WorkbenchMenuStandardNavBarView, init_inj2280_WorkbenchMenuStandardNavBarView);
      return inj2280_WorkbenchMenuStandardNavBarView;
    }
  };
  private final WorkbenchMenuStandardNavBarView inj2280_WorkbenchMenuStandardNavBarView = inj2281_WorkbenchMenuStandardNavBarView_creational.getInstance(context);
  private InitializationCallback<WorkbenchMenuCompactNavBarView> init_inj2282_WorkbenchMenuCompactNavBarView = new InitializationCallback<WorkbenchMenuCompactNavBarView>() {
    public void init(final WorkbenchMenuCompactNavBarView obj) {
      _$1582791603_setup(obj);
    }
  };
  private final BeanProvider<WorkbenchMenuCompactNavBarView> inj2283_WorkbenchMenuCompactNavBarView_creational = new BeanProvider<WorkbenchMenuCompactNavBarView>() {
    public WorkbenchMenuCompactNavBarView getInstance(final CreationalContext context) {
      final WorkbenchMenuCompactNavBarView inj2282_WorkbenchMenuCompactNavBarView = new WorkbenchMenuCompactNavBarView();
      context.addBean(context.getBeanReference(WorkbenchMenuCompactNavBarView.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2282_WorkbenchMenuCompactNavBarView);
      context.addInitializationCallback(inj2282_WorkbenchMenuCompactNavBarView, init_inj2282_WorkbenchMenuCompactNavBarView);
      return inj2282_WorkbenchMenuCompactNavBarView;
    }
  };
  private final WorkbenchMenuCompactNavBarView inj2282_WorkbenchMenuCompactNavBarView = inj2283_WorkbenchMenuCompactNavBarView_creational.getInstance(context);
  private InitializationCallback<UtilityMenuBarView> init_inj2284_UtilityMenuBarView = new InitializationCallback<UtilityMenuBarView>() {
    public void init(final UtilityMenuBarView obj) {
      obj.setup();
    }
  };
  private final BeanProvider<UtilityMenuBarView> inj2285_UtilityMenuBarView_creational = new BeanProvider<UtilityMenuBarView>() {
    public UtilityMenuBarView getInstance(final CreationalContext context) {
      final UtilityMenuBarView inj2284_UtilityMenuBarView = new UtilityMenuBarView();
      context.addBean(context.getBeanReference(UtilityMenuBarView.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2284_UtilityMenuBarView);
      _$2124140384__$1574799830_authzManager(inj2284_UtilityMenuBarView, inj2206_RuntimeAuthorizationManager);
      _$2124140384__597466346_identity(inj2284_UtilityMenuBarView, _663569186_produceActiveUser(inj2203_BasicUserCacheImpl));
      context.addInitializationCallback(inj2284_UtilityMenuBarView, init_inj2284_UtilityMenuBarView);
      return inj2284_UtilityMenuBarView;
    }
  };
  private final UtilityMenuBarView inj2284_UtilityMenuBarView = inj2285_UtilityMenuBarView_creational.getInstance(context);
  private InitializationCallback<WorkbenchMenuBarView> init_inj2286_WorkbenchMenuBarView = new InitializationCallback<WorkbenchMenuBarView>() {
    public void init(final WorkbenchMenuBarView obj) {
      _$623677011_setup(obj);
    }
  };
  private final BeanProvider<WorkbenchMenuBarView> inj2287_WorkbenchMenuBarView_creational = new BeanProvider<WorkbenchMenuBarView>() {
    public WorkbenchMenuBarView getInstance(final CreationalContext context) {
      final WorkbenchMenuBarView inj2286_WorkbenchMenuBarView = new WorkbenchMenuBarView();
      context.addBean(context.getBeanReference(WorkbenchMenuBarView.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2286_WorkbenchMenuBarView);
      _$623677011__$903668163_menuBarBrand(inj2286_WorkbenchMenuBarView, inj2189_InstanceProvider.provide(new Class[] { MainBrand.class }, null));
      _$623677011__$1582791603_workbenchMenuCompactNavBarView(inj2286_WorkbenchMenuBarView, inj2282_WorkbenchMenuCompactNavBarView);
      _$623677011__$110318115_workbenchMenuStandardNavBarView(inj2286_WorkbenchMenuBarView, inj2280_WorkbenchMenuStandardNavBarView);
      _$623677011__$2124140384_utilityMenuBarView(inj2286_WorkbenchMenuBarView, inj2284_UtilityMenuBarView);
      context.addInitializationCallback(inj2286_WorkbenchMenuBarView, init_inj2286_WorkbenchMenuBarView);
      return inj2286_WorkbenchMenuBarView;
    }
  };
  private final WorkbenchMenuBarView inj2286_WorkbenchMenuBarView = inj2287_WorkbenchMenuBarView_creational.getInstance(context);
  private InitializationCallback<WorkbenchMenuBarPresenter> init_inj2288_WorkbenchMenuBarPresenter = new InitializationCallback<WorkbenchMenuBarPresenter>() {
    public void init(final WorkbenchMenuBarPresenter obj) {
      _$292735039_setup(obj);
    }
  };
  private final BeanProvider<WorkbenchMenuBarPresenter> inj2289_WorkbenchMenuBarPresenter_creational = new BeanProvider<WorkbenchMenuBarPresenter>() {
    public WorkbenchMenuBarPresenter getInstance(final CreationalContext context) {
      final WorkbenchMenuBarPresenter inj2288_WorkbenchMenuBarPresenter = new WorkbenchMenuBarPresenter();
      context.addBean(context.getBeanReference(WorkbenchMenuBarPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2288_WorkbenchMenuBarPresenter);
      _$292735039__$1574799830_authzManager(inj2288_WorkbenchMenuBarPresenter, inj2206_RuntimeAuthorizationManager);
      _$292735039__597466346_identity(inj2288_WorkbenchMenuBarPresenter, _663569186_produceActiveUser(inj2203_BasicUserCacheImpl));
      _$292735039__$1335679257_perspectiveManager(inj2288_WorkbenchMenuBarPresenter, inj2255_PerspectiveManagerImpl);
      _$292735039__$1583970232_activityManager(inj2288_WorkbenchMenuBarPresenter, inj2259_ActivityManagerImpl);
      _$292735039__1201173960_view(inj2288_WorkbenchMenuBarPresenter, inj2286_WorkbenchMenuBarView);
      final Subscription var41 = CDI.subscribeLocal("org.uberfire.client.workbench.events.PerspectiveChange", new AbstractCDIEventCallback<PerspectiveChange>() {
        public void fireEvent(final PerspectiveChange event) {
          _$292735039_onPerspectiveChange_PerspectiveChange(inj2288_WorkbenchMenuBarPresenter, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.PerspectiveChange []";
        }
      });
      context.addDestructionCallback(inj2288_WorkbenchMenuBarPresenter, new DestructionCallback<WorkbenchMenuBarPresenter>() {
        public void destroy(final WorkbenchMenuBarPresenter obj) {
          var41.remove();
          // WEEEEE!;
        }
      });
      final Subscription var42 = CDI.subscribeLocal("org.uberfire.client.workbench.events.PlaceMinimizedEvent", new AbstractCDIEventCallback<PlaceMinimizedEvent>() {
        public void fireEvent(final PlaceMinimizedEvent event) {
          _$292735039_onPlaceMinimized_PlaceMinimizedEvent(inj2288_WorkbenchMenuBarPresenter, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.PlaceMinimizedEvent []";
        }
      });
      context.addDestructionCallback(inj2288_WorkbenchMenuBarPresenter, new DestructionCallback<WorkbenchMenuBarPresenter>() {
        public void destroy(final WorkbenchMenuBarPresenter obj) {
          var42.remove();
          // WEEEEE!;
        }
      });
      final Subscription var43 = CDI.subscribeLocal("org.uberfire.client.workbench.events.PlaceMaximizedEvent", new AbstractCDIEventCallback<PlaceMaximizedEvent>() {
        public void fireEvent(final PlaceMaximizedEvent event) {
          _$292735039_onPlaceMaximized_PlaceMaximizedEvent(inj2288_WorkbenchMenuBarPresenter, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.PlaceMaximizedEvent []";
        }
      });
      context.addDestructionCallback(inj2288_WorkbenchMenuBarPresenter, new DestructionCallback<WorkbenchMenuBarPresenter>() {
        public void destroy(final WorkbenchMenuBarPresenter obj) {
          var43.remove();
          // WEEEEE!;
        }
      });
      context.addInitializationCallback(inj2288_WorkbenchMenuBarPresenter, init_inj2288_WorkbenchMenuBarPresenter);
      return inj2288_WorkbenchMenuBarPresenter;
    }
  };
  private final WorkbenchMenuBarPresenter inj2288_WorkbenchMenuBarPresenter = inj2289_WorkbenchMenuBarPresenter_creational.getInstance(context);
  private final BeanProvider<AppNavBar> inj2291_AppNavBar_creational = new BeanProvider<AppNavBar>() {
    public AppNavBar getInstance(final CreationalContext context) {
      final AppNavBar inj2290_AppNavBar = new AppNavBar();
      context.addBean(context.getBeanReference(AppNavBar.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2290_AppNavBar);
      _1071005634__$292735039_menuBarPresenter(inj2290_AppNavBar, inj2288_WorkbenchMenuBarPresenter);
      return inj2290_AppNavBar;
    }
  };
  private final AppNavBar inj2290_AppNavBar = inj2291_AppNavBar_creational.getInstance(context);
  private final BeanProvider<ServerTemplateProvider> inj2293_ServerTemplateProvider_creational = new BeanProvider<ServerTemplateProvider>() {
    public ServerTemplateProvider getInstance(final CreationalContext context) {
      final ServerTemplateProvider inj2292_ServerTemplateProvider = new ServerTemplateProvider();
      context.addBean(context.getBeanReference(ServerTemplateProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2292_ServerTemplateProvider);
      return inj2292_ServerTemplateProvider;
    }
  };
  private final ServerTemplateProvider inj2292_ServerTemplateProvider = inj2293_ServerTemplateProvider_creational.getInstance(context);
  private final BeanProvider<TemplatedWorkbenchPanelView> inj2295_TemplatedWorkbenchPanelView_creational = new BeanProvider<TemplatedWorkbenchPanelView>() {
    public TemplatedWorkbenchPanelView getInstance(final CreationalContext context) {
      final TemplatedWorkbenchPanelView inj2294_TemplatedWorkbenchPanelView = new TemplatedWorkbenchPanelView();
      context.addBean(context.getBeanReference(TemplatedWorkbenchPanelView.class, arrayOf_19635043Annotation_966516661), inj2294_TemplatedWorkbenchPanelView);
      _280033959__$1825231548_layoutSelection(inj2294_TemplatedWorkbenchPanelView, inj2209_LayoutSelection);
      return inj2294_TemplatedWorkbenchPanelView;
    }
  };
  private final BeanProvider<Span> inj2298_Span_creational = new BeanProvider<Span>() {
    public Span getInstance(final CreationalContext context) {
      final Span inj1205_Span = new Span();
      context.addBean(context.getBeanReference(Span.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1205_Span);
      return inj1205_Span;
    }
  };
  private final BeanProvider<ActivityNotFoundView> inj2297_ActivityNotFoundView_creational = new BeanProvider<ActivityNotFoundView>() {
    public ActivityNotFoundView getInstance(final CreationalContext context) {
      final ActivityNotFoundView inj2296_ActivityNotFoundView = new ActivityNotFoundView();
      context.addBean(context.getBeanReference(ActivityNotFoundView.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2296_ActivityNotFoundView);
      _$1119962330__280475719_identifier(inj2296_ActivityNotFoundView, inj2298_Span_creational.getInstance(context));
      context.addInitializationCallback(inj2296_ActivityNotFoundView, new InitializationCallback<ActivityNotFoundView>() {
        public void init(final ActivityNotFoundView obj) {
          org_uberfire_client_views_pfly_notfound_ActivityNotFoundViewTemplateResource var44 = GWT.create(org_uberfire_client_views_pfly_notfound_ActivityNotFoundViewTemplateResource.class);
          Element var45 = TemplateUtil.getRootTemplateElement(var44.getContents().getText(), "org/uberfire/client/views/pfly/notfound/ActivityNotFoundView.html", "");
          TemplateUtil.translateTemplate("org/uberfire/client/views/pfly/notfound/ActivityNotFoundView.html", var45);
          Map<String, Element> var46 = TemplateUtil.getDataFieldElements(var45);
          Map<String, Widget> var47 = new LinkedHashMap<String, Widget>();
          TemplateUtil.compositeComponentReplace("org.uberfire.client.views.pfly.notfound.ActivityNotFoundView", "org/uberfire/client/views/pfly/notfound/ActivityNotFoundView.html", _$1119962330__280475719_identifier(inj2296_ActivityNotFoundView), var46, "identifier");
          var47.put("identifier", _$1119962330__280475719_identifier(inj2296_ActivityNotFoundView));
          TemplateUtil.initWidget(inj2296_ActivityNotFoundView, var45, var47.values());
        }
      });
      return inj2296_ActivityNotFoundView;
    }
  };
  private final BeanProvider<PlaceManagerJSExporter> inj2300_PlaceManagerJSExporter_creational = new BeanProvider<PlaceManagerJSExporter>() {
    public PlaceManagerJSExporter getInstance(final CreationalContext context) {
      final PlaceManagerJSExporter inj2299_PlaceManagerJSExporter = new PlaceManagerJSExporter();
      context.addBean(context.getBeanReference(PlaceManagerJSExporter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2299_PlaceManagerJSExporter);
      return inj2299_PlaceManagerJSExporter;
    }
  };
  private final PlaceManagerJSExporter inj2299_PlaceManagerJSExporter = inj2300_PlaceManagerJSExporter_creational.getInstance(context);
  private final BeanProvider<MainPerspectiveActivity> inj2302_MainPerspectiveActivity_creational = new BeanProvider<MainPerspectiveActivity>() {
    public MainPerspectiveActivity getInstance(final CreationalContext context) {
      final PlaceManager var48 = inj2264_PlaceManagerImpl;
      final MainPerspectiveActivity inj2301_MainPerspectiveActivity = new MainPerspectiveActivity(var48);
      context.addBean(context.getBeanReference(MainPerspectiveActivity.class, arrayOf_19635043Annotation_1601691956), inj2301_MainPerspectiveActivity);
      _$943894__$1480971077_realPresenter(inj2301_MainPerspectiveActivity, inj2192_MainPerspective);
      return inj2301_MainPerspectiveActivity;
    }
  };
  private final BeanProvider<TransitionToRoleProvider> inj2303_TransitionToRoleProvider_creational = new BeanProvider<TransitionToRoleProvider>() {
    public TransitionToRoleProvider getInstance(final CreationalContext context) {
      final TransitionToRoleProvider inj2177_TransitionToRoleProvider = new TransitionToRoleProvider();
      context.addBean(context.getBeanReference(TransitionToRoleProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2177_TransitionToRoleProvider);
      return inj2177_TransitionToRoleProvider;
    }
  };
  private final TransitionToRoleProvider inj2177_TransitionToRoleProvider = inj2303_TransitionToRoleProvider_creational.getInstance(context);
  private final BeanProvider<SecurityRolesConstraintPage> inj2304_SecurityRolesConstraintPage_creational = new BeanProvider<SecurityRolesConstraintPage>() {
    public SecurityRolesConstraintPage getInstance(final CreationalContext context) {
      final SecurityRolesConstraintPage inj383_SecurityRolesConstraintPage = new SecurityRolesConstraintPage();
      context.addBean(context.getBeanReference(SecurityRolesConstraintPage.class, QualifierUtil.DEFAULT_QUALIFIERS), inj383_SecurityRolesConstraintPage);
      _1084732347__314455785_loginTransition(inj383_SecurityRolesConstraintPage, inj2177_TransitionToRoleProvider.provide(new Class[] { LoginPage.class }, null));
      _1084732347__314455785_securityErrorTransition(inj383_SecurityRolesConstraintPage, inj2177_TransitionToRoleProvider.provide(new Class[] { SecurityError.class }, null));
      return inj383_SecurityRolesConstraintPage;
    }
  };
  private final BeanProvider<RequestDispatcherProvider> inj2305_RequestDispatcherProvider_creational = new BeanProvider<RequestDispatcherProvider>() {
    public RequestDispatcherProvider getInstance(final CreationalContext context) {
      final RequestDispatcherProvider inj2167_RequestDispatcherProvider = new RequestDispatcherProvider();
      context.addBean(context.getBeanReference(RequestDispatcherProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2167_RequestDispatcherProvider);
      return inj2167_RequestDispatcherProvider;
    }
  };
  private final RequestDispatcherProvider inj2167_RequestDispatcherProvider = inj2305_RequestDispatcherProvider_creational.getInstance(context);
  private final BeanProvider<AnyResourceTypeDefinition> inj2307_AnyResourceTypeDefinition_creational = new BeanProvider<AnyResourceTypeDefinition>() {
    public AnyResourceTypeDefinition getInstance(final CreationalContext context) {
      final AnyResourceTypeDefinition inj2306_AnyResourceTypeDefinition = new AnyResourceTypeDefinition();
      context.addBean(context.getBeanReference(AnyResourceTypeDefinition.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2306_AnyResourceTypeDefinition);
      return inj2306_AnyResourceTypeDefinition;
    }
  };
  private final AnyResourceTypeDefinition inj2306_AnyResourceTypeDefinition = inj2307_AnyResourceTypeDefinition_creational.getInstance(context);
  private final BeanProvider<LockDemandDetector> inj2309_LockDemandDetector_creational = new BeanProvider<LockDemandDetector>() {
    public LockDemandDetector getInstance(final CreationalContext context) {
      final LockDemandDetector inj2308_LockDemandDetector = new LockDemandDetector();
      context.addBean(context.getBeanReference(LockDemandDetector.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2308_LockDemandDetector);
      return inj2308_LockDemandDetector;
    }
  };
  private final BeanProvider<StandaloneEditorPerspective> inj2311_StandaloneEditorPerspective_creational = new BeanProvider<StandaloneEditorPerspective>() {
    public StandaloneEditorPerspective getInstance(final CreationalContext context) {
      final PlaceManager var49 = inj2264_PlaceManagerImpl;
      final StandaloneEditorPerspective inj2310_StandaloneEditorPerspective = new StandaloneEditorPerspective(var49);
      context.addBean(context.getBeanReference(StandaloneEditorPerspective.class, arrayOf_19635043Annotation_1796742650), inj2310_StandaloneEditorPerspective);
      return inj2310_StandaloneEditorPerspective;
    }
  };
  private final BeanProvider<ListWidgetProvider> inj2312_ListWidgetProvider_creational = new BeanProvider<ListWidgetProvider>() {
    public ListWidgetProvider getInstance(final CreationalContext context) {
      final ListWidgetProvider inj2173_ListWidgetProvider = new ListWidgetProvider();
      context.addBean(context.getBeanReference(ListWidgetProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2173_ListWidgetProvider);
      return inj2173_ListWidgetProvider;
    }
  };
  private final ListWidgetProvider inj2173_ListWidgetProvider = inj2312_ListWidgetProvider_creational.getInstance(context);
  private final BeanProvider<UberfireJSAPIExporter> inj2314_UberfireJSAPIExporter_creational = new BeanProvider<UberfireJSAPIExporter>() {
    public UberfireJSAPIExporter getInstance(final CreationalContext context) {
      final UberfireJSAPIExporter inj2313_UberfireJSAPIExporter = new UberfireJSAPIExporter();
      context.addBean(context.getBeanReference(UberfireJSAPIExporter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2313_UberfireJSAPIExporter);
      InitVotes.registerOneTimeInitCallback(new Runnable() {
        public void run() {
          inj2313_UberfireJSAPIExporter.export();
        }
      });
      return inj2313_UberfireJSAPIExporter;
    }
  };
  private final UberfireJSAPIExporter inj2313_UberfireJSAPIExporter = inj2314_UberfireJSAPIExporter_creational.getInstance(context);
  private final BeanProvider<SenderProvider> inj2315_SenderProvider_creational = new BeanProvider<SenderProvider>() {
    public SenderProvider getInstance(final CreationalContext context) {
      final SenderProvider inj2183_SenderProvider = new SenderProvider();
      context.addBean(context.getBeanReference(SenderProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2183_SenderProvider);
      return inj2183_SenderProvider;
    }
  };
  private final SenderProvider inj2183_SenderProvider = inj2315_SenderProvider_creational.getInstance(context);
  private final BeanProvider<TextBox> inj2318_TextBox_creational = new BeanProvider<TextBox>() {
    public TextBox getInstance(final CreationalContext context) {
      final TextBox inj1106_TextBox = new TextBox();
      context.addBean(context.getBeanReference(TextBox.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1106_TextBox);
      return inj1106_TextBox;
    }
  };
  private final BeanProvider<MoodListenerScreen> inj2317_MoodListenerScreen_creational = new BeanProvider<MoodListenerScreen>() {
    public MoodListenerScreen getInstance(final CreationalContext context) {
      final MoodListenerScreen inj2316_MoodListenerScreen = new MoodListenerScreen();
      context.addBean(context.getBeanReference(MoodListenerScreen.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2316_MoodListenerScreen);
      _1025798413__$371269162_moodTextBox(inj2316_MoodListenerScreen, inj2318_TextBox_creational.getInstance(context));
      final Subscription var50 = CDI.subscribeLocal("org.uberfire.shared.Mood", new AbstractCDIEventCallback<Mood>() {
        public void fireEvent(final Mood event) {
          inj2316_MoodListenerScreen.onMoodChange(event);
        }
        public String toString() {
          return "Observer: org.uberfire.shared.Mood []";
        }
      });
      context.addDestructionCallback(inj2316_MoodListenerScreen, new DestructionCallback<MoodListenerScreen>() {
        public void destroy(final MoodListenerScreen obj) {
          var50.remove();
          // WEEEEE!;
        }
      });
      context.addInitializationCallback(inj2316_MoodListenerScreen, new InitializationCallback<MoodListenerScreen>() {
        public void init(final MoodListenerScreen obj) {
          org_uberfire_client_screens_MoodListenerScreenTemplateResource var51 = GWT.create(org_uberfire_client_screens_MoodListenerScreenTemplateResource.class);
          Element var52 = TemplateUtil.getRootTemplateElement(var51.getContents().getText(), "org/uberfire/client/screens/MoodListenerScreen.html", "");
          TemplateUtil.translateTemplate("org/uberfire/client/screens/MoodListenerScreen.html", var52);
          Map<String, Element> var53 = TemplateUtil.getDataFieldElements(var52);
          Map<String, Widget> var54 = new LinkedHashMap<String, Widget>();
          TemplateUtil.compositeComponentReplace("org.uberfire.client.screens.MoodListenerScreen", "org/uberfire/client/screens/MoodListenerScreen.html", _1025798413__$371269162_moodTextBox(inj2316_MoodListenerScreen), var53, "moodTextBox");
          var54.put("moodTextBox", _1025798413__$371269162_moodTextBox(inj2316_MoodListenerScreen));
          TemplateUtil.initWidget(inj2316_MoodListenerScreen, var52, var54.values());
        }
      });
      return inj2316_MoodListenerScreen;
    }
  };
  private final BeanProvider<CheckBox> inj2320_CheckBox_creational = new BeanProvider<CheckBox>() {
    public CheckBox getInstance(final CreationalContext context) {
      final CheckBox inj1298_CheckBox = new CheckBox();
      context.addBean(context.getBeanReference(CheckBox.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1298_CheckBox);
      return inj1298_CheckBox;
    }
  };
  private final BeanProvider<Button> inj2321_Button_creational = new BeanProvider<Button>() {
    public Button getInstance(final CreationalContext context) {
      final Button inj325_Button = new Button();
      context.addBean(context.getBeanReference(Button.class, QualifierUtil.DEFAULT_QUALIFIERS), inj325_Button);
      return inj325_Button;
    }
  };
  private InitializationCallback<SplashModalFooter> init_inj1254_SplashModalFooter = new InitializationCallback<SplashModalFooter>() {
    public void init(final SplashModalFooter obj) {
      _2112332982_setup(obj);
    }
  };
  private final BeanProvider<SplashModalFooter> inj2319_SplashModalFooter_creational = new BeanProvider<SplashModalFooter>() {
    public SplashModalFooter getInstance(final CreationalContext context) {
      final SplashModalFooter inj1254_SplashModalFooter = new SplashModalFooter();
      context.addBean(context.getBeanReference(SplashModalFooter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1254_SplashModalFooter);
      _2112332982__563415049_show(inj1254_SplashModalFooter, inj2320_CheckBox_creational.getInstance(context));
      _2112332982__534146328_closeButton(inj1254_SplashModalFooter, inj2321_Button_creational.getInstance(context));
      context.addInitializationCallback(inj1254_SplashModalFooter, new InitializationCallback<SplashModalFooter>() {
        public void init(final SplashModalFooter obj) {
          org_uberfire_client_views_pfly_splash_SplashModalFooterTemplateResource var55 = GWT.create(org_uberfire_client_views_pfly_splash_SplashModalFooterTemplateResource.class);
          Element var56 = TemplateUtil.getRootTemplateElement(var55.getContents().getText(), "org/uberfire/client/views/pfly/splash/SplashModalFooter.html", "");
          TemplateUtil.translateTemplate("org/uberfire/client/views/pfly/splash/SplashModalFooter.html", var56);
          Map<String, Element> var57 = TemplateUtil.getDataFieldElements(var56);
          Map<String, Widget> var58 = new LinkedHashMap<String, Widget>();
          TemplateUtil.compositeComponentReplace("org.uberfire.client.views.pfly.splash.SplashModalFooter", "org/uberfire/client/views/pfly/splash/SplashModalFooter.html", _2112332982__563415049_show(inj1254_SplashModalFooter), var57, "show");
          TemplateUtil.compositeComponentReplace("org.uberfire.client.views.pfly.splash.SplashModalFooter", "org/uberfire/client/views/pfly/splash/SplashModalFooter.html", _2112332982__534146328_closeButton(inj1254_SplashModalFooter), var57, "closeButton");
          var58.put("show", _2112332982__563415049_show(inj1254_SplashModalFooter));
          var58.put("closeButton", _2112332982__534146328_closeButton(inj1254_SplashModalFooter));
          TemplateUtil.initWidget(inj1254_SplashModalFooter, var56, var58.values());
          ((HasClickHandlers) var58.get("closeButton")).addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj1254_SplashModalFooter.onOKButtonClick(event);
            }
          });
        }
      });
      context.addInitializationCallback(inj1254_SplashModalFooter, init_inj1254_SplashModalFooter);
      return inj1254_SplashModalFooter;
    }
  };
  private final BeanProvider<Bs3Modal> inj2323_Bs3Modal_creational = new BeanProvider<Bs3Modal>() {
    public Bs3Modal getInstance(final CreationalContext context) {
      final Bs3Modal inj2322_Bs3Modal = new Bs3Modal();
      context.addBean(context.getBeanReference(Bs3Modal.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2322_Bs3Modal);
      return inj2322_Bs3Modal;
    }
  };
  private InitializationCallback<SplashViewImpl> init_inj2324_SplashViewImpl = new InitializationCallback<SplashViewImpl>() {
    public void init(final SplashViewImpl obj) {
      obj.setup();
    }
  };
  private final BeanProvider<SplashViewImpl> inj2325_SplashViewImpl_creational = new BeanProvider<SplashViewImpl>() {
    public SplashViewImpl getInstance(final CreationalContext context) {
      final SplashViewImpl inj2324_SplashViewImpl = new SplashViewImpl();
      context.addBean(context.getBeanReference(SplashViewImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2324_SplashViewImpl);
      _$163699945__$1553627672_modal(inj2324_SplashViewImpl, inj2323_Bs3Modal_creational.getInstance(context));
      _$163699945__2112332982_footer(inj2324_SplashViewImpl, inj2319_SplashModalFooter_creational.getInstance(context));
      context.addInitializationCallback(inj2324_SplashViewImpl, init_inj2324_SplashViewImpl);
      return inj2324_SplashViewImpl;
    }
  };
  private final BeanProvider<PageTransitionProvider> inj2326_PageTransitionProvider_creational = new BeanProvider<PageTransitionProvider>() {
    public PageTransitionProvider getInstance(final CreationalContext context) {
      final PageTransitionProvider inj2179_PageTransitionProvider = new PageTransitionProvider();
      context.addBean(context.getBeanReference(PageTransitionProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2179_PageTransitionProvider);
      return inj2179_PageTransitionProvider;
    }
  };
  private final PageTransitionProvider inj2179_PageTransitionProvider = inj2326_PageTransitionProvider_creational.getInstance(context);
  private final BeanProvider<RootPanelProvider> inj2327_RootPanelProvider_creational = new BeanProvider<RootPanelProvider>() {
    public RootPanelProvider getInstance(final CreationalContext context) {
      final RootPanelProvider inj2175_RootPanelProvider = new RootPanelProvider();
      context.addBean(context.getBeanReference(RootPanelProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2175_RootPanelProvider);
      return inj2175_RootPanelProvider;
    }
  };
  private final RootPanelProvider inj2175_RootPanelProvider = inj2327_RootPanelProvider_creational.getInstance(context);
  private InitializationCallback<MultiPageEditorViewImpl> init_inj2328_MultiPageEditorViewImpl = new InitializationCallback<MultiPageEditorViewImpl>() {
    public void init(final MultiPageEditorViewImpl obj) {
      obj.init();
    }
  };
  private final BeanProvider<MultiPageEditorViewImpl> inj2329_MultiPageEditorViewImpl_creational = new BeanProvider<MultiPageEditorViewImpl>() {
    public MultiPageEditorViewImpl getInstance(final CreationalContext context) {
      final MultiPageEditorViewImpl inj2328_MultiPageEditorViewImpl = new MultiPageEditorViewImpl();
      context.addBean(context.getBeanReference(MultiPageEditorViewImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2328_MultiPageEditorViewImpl);
      context.addInitializationCallback(inj2328_MultiPageEditorViewImpl, init_inj2328_MultiPageEditorViewImpl);
      return inj2328_MultiPageEditorViewImpl;
    }
  };
  private final BeanProvider<ActivityBeansInfo> inj2331_ActivityBeansInfo_creational = new BeanProvider<ActivityBeansInfo>() {
    public ActivityBeansInfo getInstance(final CreationalContext context) {
      final ActivityBeansInfo inj2330_ActivityBeansInfo = new ActivityBeansInfo();
      context.addBean(context.getBeanReference(ActivityBeansInfo.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2330_ActivityBeansInfo);
      return inj2330_ActivityBeansInfo;
    }
  };
  private final ActivityBeansInfo inj2330_ActivityBeansInfo = inj2331_ActivityBeansInfo_creational.getInstance(context);
  private final BeanProvider<PartManager> inj2333_PartManager_creational = new BeanProvider<PartManager>() {
    public PartManager getInstance(final CreationalContext context) {
      final PartManager inj2332_PartManager = new PartManager();
      context.addBean(context.getBeanReference(PartManager.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2332_PartManager);
      return inj2332_PartManager;
    }
  };
  private final PartManager inj2332_PartManager = inj2333_PartManager_creational.getInstance(context);
  private final BeanProvider<LayoutPanelView> inj2335_LayoutPanelView_creational = new BeanProvider<LayoutPanelView>() {
    public LayoutPanelView getInstance(final CreationalContext context) {
      final LayoutPanelView inj2334_LayoutPanelView = new LayoutPanelView();
      context.addBean(context.getBeanReference(LayoutPanelView.class, arrayOf_19635043Annotation_1286405175), inj2334_LayoutPanelView);
      _1420226898__443136474_partManager(inj2334_LayoutPanelView, inj2332_PartManager);
      _1420226898__$1825231548_layoutSelection(inj2334_LayoutPanelView, inj2209_LayoutSelection);
      return inj2334_LayoutPanelView;
    }
  };
  private InitializationCallback<LayoutPanelPresenter> init_inj2336_LayoutPanelPresenter = new InitializationCallback<LayoutPanelPresenter>() {
    public void init(final LayoutPanelPresenter obj) {
      _253255348_init(obj);
    }
  };
  private final BeanProvider<LayoutPanelPresenter> inj2337_LayoutPanelPresenter_creational = new BeanProvider<LayoutPanelPresenter>() {
    public LayoutPanelPresenter getInstance(final CreationalContext context) {
      final LayoutPanelView var59 = inj2335_LayoutPanelView_creational.getInstance(context);
      final PerspectiveManager var60 = inj2255_PerspectiveManagerImpl;
      final LayoutPanelPresenter inj2336_LayoutPanelPresenter = new LayoutPanelPresenter(var59, var60);
      context.addBean(context.getBeanReference(LayoutPanelPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2336_LayoutPanelPresenter);
      context.addInitializationCallback(inj2336_LayoutPanelPresenter, init_inj2336_LayoutPanelPresenter);
      return inj2336_LayoutPanelPresenter;
    }
  };
  private final BeanProvider<TransitionAnchorFactoryProvider> inj2338_TransitionAnchorFactoryProvider_creational = new BeanProvider<TransitionAnchorFactoryProvider>() {
    public TransitionAnchorFactoryProvider getInstance(final CreationalContext context) {
      final TransitionAnchorFactoryProvider inj2169_TransitionAnchorFactoryProvider = new TransitionAnchorFactoryProvider();
      context.addBean(context.getBeanReference(TransitionAnchorFactoryProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2169_TransitionAnchorFactoryProvider);
      _1496760654__136504311_navigation(inj2169_TransitionAnchorFactoryProvider, inj2228_Navigation);
      _1496760654__515581186_htFactory(inj2169_TransitionAnchorFactoryProvider, inj2224_HistoryTokenFactory);
      return inj2169_TransitionAnchorFactoryProvider;
    }
  };
  private final TransitionAnchorFactoryProvider inj2169_TransitionAnchorFactoryProvider = inj2338_TransitionAnchorFactoryProvider_creational.getInstance(context);
  private final BeanProvider<JSNativePerspective> inj2340_JSNativePerspective_creational = new BeanProvider<JSNativePerspective>() {
    public JSNativePerspective getInstance(final CreationalContext context) {
      final JSNativePerspective inj2339_JSNativePerspective = new JSNativePerspective();
      context.addBean(context.getBeanReference(JSNativePerspective.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2339_JSNativePerspective);
      _684448251__$262319993_panelManager(inj2339_JSNativePerspective, inj2211_PanelManagerImpl);
      _684448251__$906533316_placeManager(inj2339_JSNativePerspective, inj2264_PlaceManagerImpl);
      _684448251__$1583970232_activityManager(inj2339_JSNativePerspective, inj2259_ActivityManagerImpl);
      _684448251__$304677073_wbServices(inj2339_JSNativePerspective, inj2252_WorkbenchServicesProxyBackendImpl_creational.getInstance(context));
      return inj2339_JSNativePerspective;
    }
  };
  private final BeanProvider<VFSLockServiceProxyClientImpl> inj2342_VFSLockServiceProxyClientImpl_creational = new BeanProvider<VFSLockServiceProxyClientImpl>() {
    public VFSLockServiceProxyClientImpl getInstance(final CreationalContext context) {
      final VFSLockServiceProxyClientImpl inj2341_VFSLockServiceProxyClientImpl = new VFSLockServiceProxyClientImpl();
      context.addBean(context.getBeanReference(VFSLockServiceProxyClientImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2341_VFSLockServiceProxyClientImpl);
      return inj2341_VFSLockServiceProxyClientImpl;
    }
  };
  private final BeanProvider<VFSLockServiceProxyBackendImpl> inj2345_VFSLockServiceProxyBackendImpl_creational = new BeanProvider<VFSLockServiceProxyBackendImpl>() {
    public VFSLockServiceProxyBackendImpl getInstance(final CreationalContext context) {
      final VFSLockServiceProxyBackendImpl inj1849_VFSLockServiceProxyBackendImpl = new VFSLockServiceProxyBackendImpl();
      context.addBean(context.getBeanReference(VFSLockServiceProxyBackendImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1849_VFSLockServiceProxyBackendImpl);
      _1549975964__120980481_vfsLockService(inj1849_VFSLockServiceProxyBackendImpl, inj2161_CallerProvider.provide(new Class[] { VFSLockService.class }, null));
      final Logger var61 = LoggerFactory.getLogger("org.uberfire.client.VFSLockServiceProxyBackendImpl");
      _1549975964__1388723237_logger(inj1849_VFSLockServiceProxyBackendImpl, var61);
      return inj1849_VFSLockServiceProxyBackendImpl;
    }
  };
  private final BeanProvider<LockManagerImpl> inj2344_LockManagerImpl_creational = new BeanProvider<LockManagerImpl>() {
    public LockManagerImpl getInstance(final CreationalContext context) {
      final LockManagerImpl inj2343_LockManagerImpl = new LockManagerImpl();
      context.addBean(context.getBeanReference(LockManagerImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2343_LockManagerImpl);
      _31024108__848807465_lockService(inj2343_LockManagerImpl, inj2345_VFSLockServiceProxyBackendImpl_creational.getInstance(context));
      _31024108__1116818801_changeTitleEvent(inj2343_LockManagerImpl, inj2187_EventProvider.provide(new Class[] { ChangeTitleWidgetEvent.class }, null));
      _31024108__1116818801_updatedLockStatusEvent(inj2343_LockManagerImpl, inj2187_EventProvider.provide(new Class[] { UpdatedLockStatusEvent.class }, null));
      _31024108__1116818801_lockNotification(inj2343_LockManagerImpl, inj2187_EventProvider.provide(new Class[] { NotificationEvent.class }, null));
      _31024108__910953042_lockDemandDetector(inj2343_LockManagerImpl, inj2309_LockDemandDetector_creational.getInstance(context));
      _31024108__597466346_user(inj2343_LockManagerImpl, _663569186_produceActiveUser(inj2203_BasicUserCacheImpl));
      final Subscription var62 = CDI.subscribe("org.uberfire.backend.vfs.impl.LockInfo", new AbstractCDIEventCallback<LockInfo>() {
        public void fireEvent(final LockInfo event) {
          _31024108_updateLockInfo_LockInfo(inj2343_LockManagerImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.backend.vfs.impl.LockInfo []";
        }
      });
      final Subscription var63 = ErraiBus.get().subscribe("cdi.event:org.uberfire.backend.vfs.impl.LockInfo", CDI.ROUTING_CALLBACK);
      context.addDestructionCallback(inj2343_LockManagerImpl, new DestructionCallback<LockManagerImpl>() {
        public void destroy(final LockManagerImpl obj) {
          var62.remove();
          // WEEEEE!
          var63.remove();
        }
      });
      final Subscription var64 = CDI.subscribe("org.uberfire.workbench.events.ResourceAddedEvent", new AbstractCDIEventCallback<ResourceAddedEvent>() {
        public void fireEvent(final ResourceAddedEvent event) {
          _31024108_onResourceAdded_ResourceAddedEvent(inj2343_LockManagerImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.workbench.events.ResourceAddedEvent []";
        }
      });
      final Subscription var65 = ErraiBus.get().subscribe("cdi.event:org.uberfire.workbench.events.ResourceAddedEvent", CDI.ROUTING_CALLBACK);
      context.addDestructionCallback(inj2343_LockManagerImpl, new DestructionCallback<LockManagerImpl>() {
        public void destroy(final LockManagerImpl obj) {
          var64.remove();
          // WEEEEE!
          var65.remove();
        }
      });
      final Subscription var66 = CDI.subscribe("org.uberfire.workbench.events.ResourceUpdatedEvent", new AbstractCDIEventCallback<ResourceUpdatedEvent>() {
        public void fireEvent(final ResourceUpdatedEvent event) {
          _31024108_onResourceUpdated_ResourceUpdatedEvent(inj2343_LockManagerImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.workbench.events.ResourceUpdatedEvent []";
        }
      });
      final Subscription var67 = ErraiBus.get().subscribe("cdi.event:org.uberfire.workbench.events.ResourceUpdatedEvent", CDI.ROUTING_CALLBACK);
      context.addDestructionCallback(inj2343_LockManagerImpl, new DestructionCallback<LockManagerImpl>() {
        public void destroy(final LockManagerImpl obj) {
          var66.remove();
          // WEEEEE!
          var67.remove();
        }
      });
      final Subscription var68 = CDI.subscribeLocal("org.uberfire.client.mvp.SaveInProgressEvent", new AbstractCDIEventCallback<SaveInProgressEvent>() {
        public void fireEvent(final SaveInProgressEvent event) {
          _31024108_onSaveInProgress_SaveInProgressEvent(inj2343_LockManagerImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.mvp.SaveInProgressEvent []";
        }
      });
      context.addDestructionCallback(inj2343_LockManagerImpl, new DestructionCallback<LockManagerImpl>() {
        public void destroy(final LockManagerImpl obj) {
          var68.remove();
          // WEEEEE!;
        }
      });
      final Subscription var69 = CDI.subscribeLocal("org.uberfire.client.mvp.LockRequiredEvent", new AbstractCDIEventCallback<LockRequiredEvent>() {
        public void fireEvent(final LockRequiredEvent event) {
          _31024108_onLockRequired_LockRequiredEvent(inj2343_LockManagerImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.mvp.LockRequiredEvent []";
        }
      });
      context.addDestructionCallback(inj2343_LockManagerImpl, new DestructionCallback<LockManagerImpl>() {
        public void destroy(final LockManagerImpl obj) {
          var69.remove();
          // WEEEEE!;
        }
      });
      return inj2343_LockManagerImpl;
    }
  };
  private final BeanProvider<StaticFocusedResizePanel> inj2348_StaticFocusedResizePanel_creational = new BeanProvider<StaticFocusedResizePanel>() {
    public StaticFocusedResizePanel getInstance(final CreationalContext context) {
      final StaticFocusedResizePanel inj1088_StaticFocusedResizePanel = new StaticFocusedResizePanel();
      context.addBean(context.getBeanReference(StaticFocusedResizePanel.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1088_StaticFocusedResizePanel);
      return inj1088_StaticFocusedResizePanel;
    }
  };
  private InitializationCallback<StaticWorkbenchPanelView> init_inj2346_StaticWorkbenchPanelView = new InitializationCallback<StaticWorkbenchPanelView>() {
    public void init(final StaticWorkbenchPanelView obj) {
      _$896357979_postConstruct(obj);
    }
  };
  private final BeanProvider<StaticWorkbenchPanelView> inj2347_StaticWorkbenchPanelView_creational = new BeanProvider<StaticWorkbenchPanelView>() {
    public StaticWorkbenchPanelView getInstance(final CreationalContext context) {
      final StaticWorkbenchPanelView inj2346_StaticWorkbenchPanelView = new StaticWorkbenchPanelView();
      context.addBean(context.getBeanReference(StaticWorkbenchPanelView.class, arrayOf_19635043Annotation_1048561786), inj2346_StaticWorkbenchPanelView);
      _$896357979__$906533316_placeManager(inj2346_StaticWorkbenchPanelView, inj2264_PlaceManagerImpl);
      _$896357979__$1655162226_panel(inj2346_StaticWorkbenchPanelView, inj2348_StaticFocusedResizePanel_creational.getInstance(context));
      _$1397438695__$262319993_panelManager(inj2346_StaticWorkbenchPanelView, inj2211_PanelManagerImpl);
      _$1397438695__$1825231548_layoutSelection(inj2346_StaticWorkbenchPanelView, inj2209_LayoutSelection);
      context.addInitializationCallback(inj2346_StaticWorkbenchPanelView, init_inj2346_StaticWorkbenchPanelView);
      return inj2346_StaticWorkbenchPanelView;
    }
  };
  private final BeanProvider<DefaultBusSecurityErrorCallback> inj2350_DefaultBusSecurityErrorCallback_creational = new BeanProvider<DefaultBusSecurityErrorCallback>() {
    public DefaultBusSecurityErrorCallback getInstance(final CreationalContext context) {
      final SecurityContext var70 = inj2234_SecurityContextImpl;
      final DefaultBusSecurityErrorCallback inj2349_DefaultBusSecurityErrorCallback = new DefaultBusSecurityErrorCallback(var70);
      context.addBean(context.getBeanReference(DefaultBusSecurityErrorCallback.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2349_DefaultBusSecurityErrorCallback);
      final RefHolder<UncaughtExceptionHandler> var71 = new RefHolder<UncaughtExceptionHandler>();
      context.addInitializationCallback(inj2349_DefaultBusSecurityErrorCallback, new InitializationCallback<DefaultBusSecurityErrorCallback>() {
        public void init(final DefaultBusSecurityErrorCallback obj) {
          final UncaughtExceptionHandler handler = new UncaughtExceptionHandler() {
            public void onUncaughtException(Throwable t) {
              inj2349_DefaultBusSecurityErrorCallback.handleError(t);
            }
          };
          var71.set(handler);
          ((ClientMessageBusImpl) ErraiBus.get()).addUncaughtExceptionHandler(handler);
        }
      });
      context.addDestructionCallback(inj2349_DefaultBusSecurityErrorCallback, new DestructionCallback<DefaultBusSecurityErrorCallback>() {
        public void destroy(final DefaultBusSecurityErrorCallback obj) {
          ((ClientMessageBusImpl) ErraiBus.get()).removeUncaughtExceptionHandler(var71.get());
        }
      });
      return inj2349_DefaultBusSecurityErrorCallback;
    }
  };
  private final DefaultBusSecurityErrorCallback inj2349_DefaultBusSecurityErrorCallback = inj2350_DefaultBusSecurityErrorCallback_creational.getInstance(context);
  private final BeanProvider<TextResourceTypeDefinition> inj2352_TextResourceTypeDefinition_creational = new BeanProvider<TextResourceTypeDefinition>() {
    public TextResourceTypeDefinition getInstance(final CreationalContext context) {
      final TextResourceTypeDefinition inj2351_TextResourceTypeDefinition = new TextResourceTypeDefinition();
      context.addBean(context.getBeanReference(TextResourceTypeDefinition.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2351_TextResourceTypeDefinition);
      return inj2351_TextResourceTypeDefinition;
    }
  };
  private final TextResourceTypeDefinition inj2351_TextResourceTypeDefinition = inj2352_TextResourceTypeDefinition_creational.getInstance(context);
  private final BeanProvider<BatchCallerProvider> inj2353_BatchCallerProvider_creational = new BeanProvider<BatchCallerProvider>() {
    public BatchCallerProvider getInstance(final CreationalContext context) {
      final BatchCallerProvider inj2185_BatchCallerProvider = new BatchCallerProvider();
      context.addBean(context.getBeanReference(BatchCallerProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2185_BatchCallerProvider);
      return inj2185_BatchCallerProvider;
    }
  };
  private final BatchCallerProvider inj2185_BatchCallerProvider = inj2353_BatchCallerProvider_creational.getInstance(context);
  private final BeanProvider<MessageBusProvider> inj2354_MessageBusProvider_creational = new BeanProvider<MessageBusProvider>() {
    public MessageBusProvider getInstance(final CreationalContext context) {
      final MessageBusProvider inj2191_MessageBusProvider = new MessageBusProvider();
      context.addBean(context.getBeanReference(MessageBusProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2191_MessageBusProvider);
      return inj2191_MessageBusProvider;
    }
  };
  private final MessageBusProvider inj2191_MessageBusProvider = inj2354_MessageBusProvider_creational.getInstance(context);
  private final BeanProvider<VFSServiceProxyClientImpl> inj2356_VFSServiceProxyClientImpl_creational = new BeanProvider<VFSServiceProxyClientImpl>() {
    public VFSServiceProxyClientImpl getInstance(final CreationalContext context) {
      final VFSServiceProxyClientImpl inj2355_VFSServiceProxyClientImpl = new VFSServiceProxyClientImpl();
      context.addBean(context.getBeanReference(VFSServiceProxyClientImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2355_VFSServiceProxyClientImpl);
      return inj2355_VFSServiceProxyClientImpl;
    }
  };
  private final BeanProvider<VFSServiceProxyBackendImpl> inj2359_VFSServiceProxyBackendImpl_creational = new BeanProvider<VFSServiceProxyBackendImpl>() {
    public VFSServiceProxyBackendImpl getInstance(final CreationalContext context) {
      final VFSServiceProxyBackendImpl inj1916_VFSServiceProxyBackendImpl = new VFSServiceProxyBackendImpl();
      context.addBean(context.getBeanReference(VFSServiceProxyBackendImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1916_VFSServiceProxyBackendImpl);
      _$1422416569__120980481_vfsService(inj1916_VFSServiceProxyBackendImpl, inj2161_CallerProvider.provide(new Class[] { VFSService.class }, null));
      return inj1916_VFSServiceProxyBackendImpl;
    }
  };
  private InitializationCallback<Workbench> init_inj2357_Workbench = new InitializationCallback<Workbench>() {
    public void init(final Workbench obj) {
      _$1462522111_earlyInit(obj);
    }
  };
  private final BeanProvider<Workbench> inj2358_Workbench_creational = new BeanProvider<Workbench>() {
    public Workbench getInstance(final CreationalContext context) {
      final Workbench inj2357_Workbench = new Workbench();
      context.addBean(context.getBeanReference(Workbench.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2357_Workbench);
      _$1462522111__1116818801_appReady(inj2357_Workbench, inj2187_EventProvider.provide(new Class[] { ApplicationReadyEvent.class }, null));
      _$1462522111__$652658075_iocManager(inj2357_Workbench, inj2155_IOCBeanManagerProvider.get());
      _$1462522111__$906533316_placeManager(inj2357_Workbench, inj2264_PlaceManagerImpl);
      _$1462522111__$715182114_vfsService(inj2357_Workbench, inj2359_VFSServiceProxyBackendImpl_creational.getInstance(context));
      _$1462522111__$1825231548_layoutSelection(inj2357_Workbench, inj2209_LayoutSelection);
      _$1462522111__597466346_identity(inj2357_Workbench, _663569186_produceActiveUser(inj2203_BasicUserCacheImpl));
      _$1462522111__879292651_bus(inj2357_Workbench, inj2191_MessageBusProvider.get());
      InitVotes.registerOneTimeInitCallback(new Runnable() {
        public void run() {
          _$1462522111_startIfNotBlocked(inj2357_Workbench);
        }
      });
      context.addInitializationCallback(inj2357_Workbench, init_inj2357_Workbench);
      return inj2357_Workbench;
    }
  };
  private final Workbench inj2357_Workbench = inj2358_Workbench_creational.getInstance(context);
  private final BeanProvider<SessionInfo> inj2149_SessionInfo_creational = new BeanProvider<SessionInfo>() {
    public SessionInfo getInstance(CreationalContext pContext) {
      SessionInfo var72 = _$1462522111_currentSession(inj2357_Workbench);
      context.addBean(context.getBeanReference(SessionInfo.class, QualifierUtil.DEFAULT_QUALIFIERS), var72);
      return var72;
    }
  };
  private final BeanProvider<ObservablePathImpl> inj2361_ObservablePathImpl_creational = new BeanProvider<ObservablePathImpl>() {
    public ObservablePathImpl getInstance(final CreationalContext context) {
      final ObservablePathImpl inj2360_ObservablePathImpl = new ObservablePathImpl();
      context.addBean(context.getBeanReference(ObservablePathImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2360_ObservablePathImpl);
      final BeanProvider<SessionInfo> var73 = new BeanProvider<SessionInfo>() {
        public SessionInfo getInstance(CreationalContext pContext) {
          SessionInfo var73 = _$1462522111_currentSession(inj2357_Workbench);
          context.addBean(context.getBeanReference(SessionInfo.class, QualifierUtil.DEFAULT_QUALIFIERS), var73);
          return var73;
        }
      };
      _$1304194947__291376327_sessionInfo(inj2360_ObservablePathImpl, ((SimpleCreationalContext) context).getSingletonInstanceOrNew(injContext, var73, SessionInfo.class, QualifierUtil.DEFAULT_QUALIFIERS));
      final Subscription var74 = CDI.subscribe("org.uberfire.workbench.events.ResourceRenamedEvent", new AbstractCDIEventCallback<ResourceRenamedEvent>() {
        public void fireEvent(final ResourceRenamedEvent event) {
          _$1304194947_onResourceRenamed_ResourceRenamedEvent(inj2360_ObservablePathImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.workbench.events.ResourceRenamedEvent []";
        }
      });
      final Subscription var75 = ErraiBus.get().subscribe("cdi.event:org.uberfire.workbench.events.ResourceRenamedEvent", CDI.ROUTING_CALLBACK);
      context.addDestructionCallback(inj2360_ObservablePathImpl, new DestructionCallback<ObservablePathImpl>() {
        public void destroy(final ObservablePathImpl obj) {
          var74.remove();
          // WEEEEE!
          var75.remove();
        }
      });
      final Subscription var76 = CDI.subscribe("org.uberfire.workbench.events.ResourceDeletedEvent", new AbstractCDIEventCallback<ResourceDeletedEvent>() {
        public void fireEvent(final ResourceDeletedEvent event) {
          _$1304194947_onResourceDeleted_ResourceDeletedEvent(inj2360_ObservablePathImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.workbench.events.ResourceDeletedEvent []";
        }
      });
      final Subscription var77 = ErraiBus.get().subscribe("cdi.event:org.uberfire.workbench.events.ResourceDeletedEvent", CDI.ROUTING_CALLBACK);
      context.addDestructionCallback(inj2360_ObservablePathImpl, new DestructionCallback<ObservablePathImpl>() {
        public void destroy(final ObservablePathImpl obj) {
          var76.remove();
          // WEEEEE!
          var77.remove();
        }
      });
      final Subscription var78 = CDI.subscribe("org.uberfire.workbench.events.ResourceUpdatedEvent", new AbstractCDIEventCallback<ResourceUpdatedEvent>() {
        public void fireEvent(final ResourceUpdatedEvent event) {
          _$1304194947_onResourceUpdated_ResourceUpdatedEvent(inj2360_ObservablePathImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.workbench.events.ResourceUpdatedEvent []";
        }
      });
      final Subscription var79 = ErraiBus.get().subscribe("cdi.event:org.uberfire.workbench.events.ResourceUpdatedEvent", CDI.ROUTING_CALLBACK);
      context.addDestructionCallback(inj2360_ObservablePathImpl, new DestructionCallback<ObservablePathImpl>() {
        public void destroy(final ObservablePathImpl obj) {
          var78.remove();
          // WEEEEE!
          var79.remove();
        }
      });
      final Subscription var80 = CDI.subscribe("org.uberfire.workbench.events.ResourceCopiedEvent", new AbstractCDIEventCallback<ResourceCopiedEvent>() {
        public void fireEvent(final ResourceCopiedEvent event) {
          _$1304194947_onResourceCopied_ResourceCopiedEvent(inj2360_ObservablePathImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.workbench.events.ResourceCopiedEvent []";
        }
      });
      final Subscription var81 = ErraiBus.get().subscribe("cdi.event:org.uberfire.workbench.events.ResourceCopiedEvent", CDI.ROUTING_CALLBACK);
      context.addDestructionCallback(inj2360_ObservablePathImpl, new DestructionCallback<ObservablePathImpl>() {
        public void destroy(final ObservablePathImpl obj) {
          var80.remove();
          // WEEEEE!
          var81.remove();
        }
      });
      final Subscription var82 = CDI.subscribe("org.uberfire.workbench.events.ResourceBatchChangesEvent", new AbstractCDIEventCallback<ResourceBatchChangesEvent>() {
        public void fireEvent(final ResourceBatchChangesEvent event) {
          _$1304194947_onResourceBatchEvent_ResourceBatchChangesEvent(inj2360_ObservablePathImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.workbench.events.ResourceBatchChangesEvent []";
        }
      });
      final Subscription var83 = ErraiBus.get().subscribe("cdi.event:org.uberfire.workbench.events.ResourceBatchChangesEvent", CDI.ROUTING_CALLBACK);
      context.addDestructionCallback(inj2360_ObservablePathImpl, new DestructionCallback<ObservablePathImpl>() {
        public void destroy(final ObservablePathImpl obj) {
          var82.remove();
          // WEEEEE!
          var83.remove();
        }
      });
      return inj2360_ObservablePathImpl;
    }
  };
  private InitializationCallback<UberTabPanel> init_inj2362_UberTabPanel = new InitializationCallback<UberTabPanel>() {
    public void init(final UberTabPanel obj) {
      obj.init();
    }
  };
  private final BeanProvider<UberTabPanel> inj2363_UberTabPanel_creational = new BeanProvider<UberTabPanel>() {
    public UberTabPanel getInstance(final CreationalContext context) {
      final PlaceManager var84 = inj2264_PlaceManagerImpl;
      final ResizeTabPanel var85 = inj2329_MultiPageEditorViewImpl_creational.getInstance(context);
      final UberTabPanel inj2362_UberTabPanel = new UberTabPanel(var84, var85);
      context.addBean(context.getBeanReference(UberTabPanel.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2362_UberTabPanel);
      context.addInitializationCallback(inj2362_UberTabPanel, init_inj2362_UberTabPanel);
      return inj2362_UberTabPanel;
    }
  };
  private InitializationCallback<MultiTabWorkbenchPanelView> init_inj2364_MultiTabWorkbenchPanelView = new InitializationCallback<MultiTabWorkbenchPanelView>() {
    public void init(final MultiTabWorkbenchPanelView obj) {
      _618642634_setupDockingPanel(obj);
      _$821728441_setupMultiPartPanel(obj);
    }
  };
  private DestructionCallback<MultiTabWorkbenchPanelView> destroy_inj2364_MultiTabWorkbenchPanelView = new DestructionCallback<MultiTabWorkbenchPanelView>() {
    public void destroy(final MultiTabWorkbenchPanelView obj) {
      _618642634_tearDownDockingPanel(obj);
    }
  };
  private final BeanProvider<MultiTabWorkbenchPanelView> inj2365_MultiTabWorkbenchPanelView_creational = new BeanProvider<MultiTabWorkbenchPanelView>() {
    public MultiTabWorkbenchPanelView getInstance(final CreationalContext context) {
      final UberTabPanel var86 = inj2363_UberTabPanel_creational.getInstance(context);
      final MultiTabWorkbenchPanelView inj2364_MultiTabWorkbenchPanelView = new MultiTabWorkbenchPanelView(var86);
      context.addBean(context.getBeanReference(MultiTabWorkbenchPanelView.class, arrayOf_19635043Annotation_913099561), inj2364_MultiTabWorkbenchPanelView);
      _618642634__153624969_dndManager(inj2364_MultiTabWorkbenchPanelView, inj2200_WorkbenchDragAndDropManager);
      _618642634__$1887041540_factory(inj2364_MultiTabWorkbenchPanelView, inj2198_DefaultBeanFactory);
      _618642634__$634457504_topLevelWidget(inj2364_MultiTabWorkbenchPanelView, inj2217_SimpleLayoutPanel_creational.getInstance(context));
      _618642634__820873068_partViewContainer(inj2364_MultiTabWorkbenchPanelView, inj2218_ResizeFlowPanel_creational.getInstance(context));
      _$1397438695__$262319993_panelManager(inj2364_MultiTabWorkbenchPanelView, inj2211_PanelManagerImpl);
      _$1397438695__$1825231548_layoutSelection(inj2364_MultiTabWorkbenchPanelView, inj2209_LayoutSelection);
      context.addInitializationCallback(inj2364_MultiTabWorkbenchPanelView, init_inj2364_MultiTabWorkbenchPanelView);
      context.addDestructionCallback(inj2364_MultiTabWorkbenchPanelView, destroy_inj2364_MultiTabWorkbenchPanelView);
      return inj2364_MultiTabWorkbenchPanelView;
    }
  };
  private final BeanProvider<MoodPerspective> inj2366_MoodPerspective_creational = new BeanProvider<MoodPerspective>() {
    public MoodPerspective getInstance(final CreationalContext context) {
      final MoodPerspective inj2046_MoodPerspective = new MoodPerspective();
      context.addBean(context.getBeanReference(MoodPerspective.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2046_MoodPerspective);
      context.addInitializationCallback(inj2046_MoodPerspective, new InitializationCallback<MoodPerspective>() {
        public void init(final MoodPerspective obj) {
          org_uberfire_client_perspectives_MoodPerspectiveTemplateResource var87 = GWT.create(org_uberfire_client_perspectives_MoodPerspectiveTemplateResource.class);
          Element var88 = TemplateUtil.getRootTemplateElement(var87.getContents().getText(), "org/uberfire/client/perspectives/MoodPerspective.html", "");
          TemplateUtil.translateTemplate("org/uberfire/client/perspectives/MoodPerspective.html", var88);
          Map<String, Element> var89 = TemplateUtil.getDataFieldElements(var88);
          Map<String, Widget> var90 = new LinkedHashMap<String, Widget>();
          TemplateUtil.initWidget(inj2046_MoodPerspective, var88, var90.values());
        }
      });
      return inj2046_MoodPerspective;
    }
  };
  private final BeanProvider<RuntimePluginsServiceProxyClientImpl> inj2368_RuntimePluginsServiceProxyClientImpl_creational = new BeanProvider<RuntimePluginsServiceProxyClientImpl>() {
    public RuntimePluginsServiceProxyClientImpl getInstance(final CreationalContext context) {
      final RuntimePluginsServiceProxyClientImpl inj2367_RuntimePluginsServiceProxyClientImpl = new RuntimePluginsServiceProxyClientImpl();
      context.addBean(context.getBeanReference(RuntimePluginsServiceProxyClientImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2367_RuntimePluginsServiceProxyClientImpl);
      final Logger var91 = LoggerFactory.getLogger("org.uberfire.client.plugin.RuntimePluginsServiceProxyClientImpl");
      _$1933089096__1388723237_logger(inj2367_RuntimePluginsServiceProxyClientImpl, var91);
      return inj2367_RuntimePluginsServiceProxyClientImpl;
    }
  };
  private final BeanProvider<RuntimePluginsServiceProxyBackendImpl> inj2370_RuntimePluginsServiceProxyBackendImpl_creational = new BeanProvider<RuntimePluginsServiceProxyBackendImpl>() {
    public RuntimePluginsServiceProxyBackendImpl getInstance(final CreationalContext context) {
      final RuntimePluginsServiceProxyBackendImpl inj2369_RuntimePluginsServiceProxyBackendImpl = new RuntimePluginsServiceProxyBackendImpl();
      context.addBean(context.getBeanReference(RuntimePluginsServiceProxyBackendImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2369_RuntimePluginsServiceProxyBackendImpl);
      _$2073633020__120980481_runtimePluginsService(inj2369_RuntimePluginsServiceProxyBackendImpl, inj2161_CallerProvider.provide(new Class[] { RuntimePluginsService.class }, null));
      return inj2369_RuntimePluginsServiceProxyBackendImpl;
    }
  };
  private final BeanProvider<JSNativeEditor> inj2372_JSNativeEditor_creational = new BeanProvider<JSNativeEditor>() {
    public JSNativeEditor getInstance(final CreationalContext context) {
      final JSNativeEditor inj2371_JSNativeEditor = new JSNativeEditor();
      context.addBean(context.getBeanReference(JSNativeEditor.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2371_JSNativeEditor);
      _1584088255__$2073863603_runtimePluginsService(inj2371_JSNativeEditor, inj2370_RuntimePluginsServiceProxyBackendImpl_creational.getInstance(context));
      return inj2371_JSNativeEditor;
    }
  };
  private final BeanProvider<TransitionAnchorProvider> inj2373_TransitionAnchorProvider_creational = new BeanProvider<TransitionAnchorProvider>() {
    public TransitionAnchorProvider getInstance(final CreationalContext context) {
      final TransitionAnchorProvider inj2171_TransitionAnchorProvider = new TransitionAnchorProvider();
      context.addBean(context.getBeanReference(TransitionAnchorProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2171_TransitionAnchorProvider);
      _$1034438370__136504311_navigation(inj2171_TransitionAnchorProvider, inj2228_Navigation);
      _$1034438370__515581186_htFactory(inj2171_TransitionAnchorProvider, inj2224_HistoryTokenFactory);
      return inj2171_TransitionAnchorProvider;
    }
  };
  private final TransitionAnchorProvider inj2171_TransitionAnchorProvider = inj2373_TransitionAnchorProvider_creational.getInstance(context);
  private final BeanProvider<TranslationServiceProvider> inj2374_TranslationServiceProvider_creational = new BeanProvider<TranslationServiceProvider>() {
    public TranslationServiceProvider getInstance(final CreationalContext context) {
      final TranslationServiceProvider inj2181_TranslationServiceProvider = new TranslationServiceProvider();
      context.addBean(context.getBeanReference(TranslationServiceProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2181_TranslationServiceProvider);
      return inj2181_TranslationServiceProvider;
    }
  };
  private final TranslationServiceProvider inj2181_TranslationServiceProvider = inj2374_TranslationServiceProvider_creational.getInstance(context);
  private InitializationCallback<UserMenuViewImpl> init_inj2375_UserMenuViewImpl = new InitializationCallback<UserMenuViewImpl>() {
    public void init(final UserMenuViewImpl obj) {
      obj.setup();
    }
  };
  private final BeanProvider<UserMenuViewImpl> inj2376_UserMenuViewImpl_creational = new BeanProvider<UserMenuViewImpl>() {
    public UserMenuViewImpl getInstance(final CreationalContext context) {
      final UserMenuViewImpl inj2375_UserMenuViewImpl = new UserMenuViewImpl();
      context.addBean(context.getBeanReference(UserMenuViewImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2375_UserMenuViewImpl);
      context.addInitializationCallback(inj2375_UserMenuViewImpl, init_inj2375_UserMenuViewImpl);
      return inj2375_UserMenuViewImpl;
    }
  };
  private InitializationCallback<UserMenu> init_inj2377_UserMenu = new InitializationCallback<UserMenu>() {
    public void init(final UserMenu obj) {
      _$680440259_setup(obj);
    }
  };
  private final BeanProvider<UserMenu> inj2378_UserMenu_creational = new BeanProvider<UserMenu>() {
    public UserMenu getInstance(final CreationalContext context) {
      final UserMenu inj2377_UserMenu = new UserMenu();
      context.addBean(context.getBeanReference(UserMenu.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2377_UserMenu);
      _$680440259__804064438_userMenuView(inj2377_UserMenu, inj2376_UserMenuViewImpl_creational.getInstance(context));
      _$680440259__597466346_user(inj2377_UserMenu, _663569186_produceActiveUser(inj2203_BasicUserCacheImpl));
      _$680440259__$1574799830_authzManager(inj2377_UserMenu, inj2206_RuntimeAuthorizationManager);
      context.addInitializationCallback(inj2377_UserMenu, init_inj2377_UserMenu);
      return inj2377_UserMenu;
    }
  };
  private InitializationCallback<ClientTypeRegistryImpl> init_inj2379_ClientTypeRegistryImpl = new InitializationCallback<ClientTypeRegistryImpl>() {
    public void init(final ClientTypeRegistryImpl obj) {
      obj.init();
    }
  };
  private final BeanProvider<ClientTypeRegistryImpl> inj2380_ClientTypeRegistryImpl_creational = new BeanProvider<ClientTypeRegistryImpl>() {
    public ClientTypeRegistryImpl getInstance(final CreationalContext context) {
      final SyncBeanManager var92 = inj2155_IOCBeanManagerProvider.get();
      final ClientTypeRegistryImpl inj2379_ClientTypeRegistryImpl = new ClientTypeRegistryImpl(var92);
      context.addBean(context.getBeanReference(ClientTypeRegistryImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2379_ClientTypeRegistryImpl);
      context.addInitializationCallback(inj2379_ClientTypeRegistryImpl, init_inj2379_ClientTypeRegistryImpl);
      return inj2379_ClientTypeRegistryImpl;
    }
  };
  private final ClientTypeRegistryImpl inj2379_ClientTypeRegistryImpl = inj2380_ClientTypeRegistryImpl_creational.getInstance(context);
  private final BeanProvider<SplitLayoutPanelView> inj2382_SplitLayoutPanelView_creational = new BeanProvider<SplitLayoutPanelView>() {
    public SplitLayoutPanelView getInstance(final CreationalContext context) {
      final SplitLayoutPanelView inj2381_SplitLayoutPanelView = new SplitLayoutPanelView();
      context.addBean(context.getBeanReference(SplitLayoutPanelView.class, arrayOf_19635043Annotation_799239204), inj2381_SplitLayoutPanelView);
      _1698844050__$906533316_placeManager(inj2381_SplitLayoutPanelView, inj2264_PlaceManagerImpl);
      _1698844050__$1825231548_layoutSelection(inj2381_SplitLayoutPanelView, inj2209_LayoutSelection);
      return inj2381_SplitLayoutPanelView;
    }
  };
  private InitializationCallback<SplitLayoutPanelPresenter> init_inj2383_SplitLayoutPanelPresenter = new InitializationCallback<SplitLayoutPanelPresenter>() {
    public void init(final SplitLayoutPanelPresenter obj) {
      _253255348_init(obj);
    }
  };
  private final BeanProvider<SplitLayoutPanelPresenter> inj2384_SplitLayoutPanelPresenter_creational = new BeanProvider<SplitLayoutPanelPresenter>() {
    public SplitLayoutPanelPresenter getInstance(final CreationalContext context) {
      final SplitLayoutPanelView var93 = inj2382_SplitLayoutPanelView_creational.getInstance(context);
      final PerspectiveManager var94 = inj2255_PerspectiveManagerImpl;
      final SplitLayoutPanelPresenter inj2383_SplitLayoutPanelPresenter = new SplitLayoutPanelPresenter(var93, var94);
      context.addBean(context.getBeanReference(SplitLayoutPanelPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2383_SplitLayoutPanelPresenter);
      context.addInitializationCallback(inj2383_SplitLayoutPanelPresenter, init_inj2383_SplitLayoutPanelPresenter);
      return inj2383_SplitLayoutPanelPresenter;
    }
  };
  private final BeanProvider<WorkbenchViewModeSwitcherView> inj2386_WorkbenchViewModeSwitcherView_creational = new BeanProvider<WorkbenchViewModeSwitcherView>() {
    public WorkbenchViewModeSwitcherView getInstance(final CreationalContext context) {
      final WorkbenchViewModeSwitcherView inj2385_WorkbenchViewModeSwitcherView = new WorkbenchViewModeSwitcherView();
      context.addBean(context.getBeanReference(WorkbenchViewModeSwitcherView.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2385_WorkbenchViewModeSwitcherView);
      return inj2385_WorkbenchViewModeSwitcherView;
    }
  };
  private final BeanProvider<VFSJSExporter> inj2388_VFSJSExporter_creational = new BeanProvider<VFSJSExporter>() {
    public VFSJSExporter getInstance(final CreationalContext context) {
      final VFSJSExporter inj2387_VFSJSExporter = new VFSJSExporter();
      context.addBean(context.getBeanReference(VFSJSExporter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2387_VFSJSExporter);
      _$1254526097__120980481_vfsServices(inj2387_VFSJSExporter, inj2161_CallerProvider.provide(new Class[] { VFSService.class }, null));
      return inj2387_VFSJSExporter;
    }
  };
  private final VFSJSExporter inj2387_VFSJSExporter = inj2388_VFSJSExporter_creational.getInstance(context);
  private InitializationCallback<HelloWorldScreen> init_inj2389_HelloWorldScreen = new InitializationCallback<HelloWorldScreen>() {
    public void init(final HelloWorldScreen obj) {
      obj.init();
    }
  };
  private final BeanProvider<HelloWorldScreen> inj2390_HelloWorldScreen_creational = new BeanProvider<HelloWorldScreen>() {
    public HelloWorldScreen getInstance(final CreationalContext context) {
      final HelloWorldScreen inj2389_HelloWorldScreen = new HelloWorldScreen();
      context.addBean(context.getBeanReference(HelloWorldScreen.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2389_HelloWorldScreen);
      context.addInitializationCallback(inj2389_HelloWorldScreen, init_inj2389_HelloWorldScreen);
      return inj2389_HelloWorldScreen;
    }
  };
  private final BeanProvider<HelloWorldScreenActivity> inj2392_HelloWorldScreenActivity_creational = new BeanProvider<HelloWorldScreenActivity>() {
    public HelloWorldScreenActivity getInstance(final CreationalContext context) {
      final PlaceManager var95 = inj2264_PlaceManagerImpl;
      final HelloWorldScreenActivity inj2391_HelloWorldScreenActivity = new HelloWorldScreenActivity(var95);
      context.addBean(context.getBeanReference(HelloWorldScreenActivity.class, arrayOf_19635043Annotation_882203174), inj2391_HelloWorldScreenActivity);
      _1095151889__960584674_realPresenter(inj2391_HelloWorldScreenActivity, inj2390_HelloWorldScreen_creational.getInstance(context));
      return inj2391_HelloWorldScreenActivity;
    }
  };
  private final BeanProvider<CreationImpl> inj2394_CreationImpl_creational = new BeanProvider<CreationImpl>() {
    public CreationImpl getInstance(final CreationalContext context) {
      final CreationImpl inj2393_CreationImpl = new CreationImpl();
      context.addBean(context.getBeanReference(CreationImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2393_CreationImpl);
      return inj2393_CreationImpl;
    }
  };
  private final BeanProvider<HTML5DndSeleniumSupport> inj2396_HTML5DndSeleniumSupport_creational = new BeanProvider<HTML5DndSeleniumSupport>() {
    public HTML5DndSeleniumSupport getInstance(final CreationalContext context) {
      final HTML5DndSeleniumSupport inj2395_HTML5DndSeleniumSupport = new HTML5DndSeleniumSupport();
      context.addBean(context.getBeanReference(HTML5DndSeleniumSupport.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2395_HTML5DndSeleniumSupport);
      return inj2395_HTML5DndSeleniumSupport;
    }
  };
  private final HTML5DndSeleniumSupport inj2395_HTML5DndSeleniumSupport = inj2396_HTML5DndSeleniumSupport_creational.getInstance(context);
  private InitializationCallback<CompassWidgetImpl> init_inj2397_CompassWidgetImpl = new InitializationCallback<CompassWidgetImpl>() {
    public void init(final CompassWidgetImpl obj) {
      _1723589606_init(obj);
    }
  };
  private final BeanProvider<CompassWidgetImpl> inj2398_CompassWidgetImpl_creational = new BeanProvider<CompassWidgetImpl>() {
    public CompassWidgetImpl getInstance(final CreationalContext context) {
      final CompassWidgetImpl inj2397_CompassWidgetImpl = new CompassWidgetImpl();
      context.addBean(context.getBeanReference(CompassWidgetImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2397_CompassWidgetImpl);
      context.addInitializationCallback(inj2397_CompassWidgetImpl, init_inj2397_CompassWidgetImpl);
      return inj2397_CompassWidgetImpl;
    }
  };
  private final CompassWidgetImpl inj2397_CompassWidgetImpl = inj2398_CompassWidgetImpl_creational.getInstance(context);
  private final BeanProvider<NotificationPopupsManagerView> inj2400_NotificationPopupsManagerView_creational = new BeanProvider<NotificationPopupsManagerView>() {
    public NotificationPopupsManagerView getInstance(final CreationalContext context) {
      final NotificationPopupsManagerView inj2399_NotificationPopupsManagerView = new NotificationPopupsManagerView();
      context.addBean(context.getBeanReference(NotificationPopupsManagerView.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2399_NotificationPopupsManagerView);
      return inj2399_NotificationPopupsManagerView;
    }
  };
  private InitializationCallback<AdaptiveWorkbenchPanelView> init_inj2401_AdaptiveWorkbenchPanelView = new InitializationCallback<AdaptiveWorkbenchPanelView>() {
    public void init(final AdaptiveWorkbenchPanelView obj) {
      _618642634_setupDockingPanel(obj);
      _1346204971_setup(obj);
    }
  };
  private DestructionCallback<AdaptiveWorkbenchPanelView> destroy_inj2401_AdaptiveWorkbenchPanelView = new DestructionCallback<AdaptiveWorkbenchPanelView>() {
    public void destroy(final AdaptiveWorkbenchPanelView obj) {
      _618642634_tearDownDockingPanel(obj);
    }
  };
  private final BeanProvider<AdaptiveWorkbenchPanelView> inj2402_AdaptiveWorkbenchPanelView_creational = new BeanProvider<AdaptiveWorkbenchPanelView>() {
    public AdaptiveWorkbenchPanelView getInstance(final CreationalContext context) {
      final AdaptiveWorkbenchPanelView inj2401_AdaptiveWorkbenchPanelView = new AdaptiveWorkbenchPanelView();
      context.addBean(context.getBeanReference(AdaptiveWorkbenchPanelView.class, arrayOf_19635043Annotation_482389261), inj2401_AdaptiveWorkbenchPanelView);
      _1346204971__$924432381_listBar(inj2401_AdaptiveWorkbenchPanelView, inj2214_ListBarWidgetImpl_creational.getInstance(context));
      _618642634__153624969_dndManager(inj2401_AdaptiveWorkbenchPanelView, inj2200_WorkbenchDragAndDropManager);
      _618642634__$1887041540_factory(inj2401_AdaptiveWorkbenchPanelView, inj2198_DefaultBeanFactory);
      _618642634__$634457504_topLevelWidget(inj2401_AdaptiveWorkbenchPanelView, inj2217_SimpleLayoutPanel_creational.getInstance(context));
      _618642634__820873068_partViewContainer(inj2401_AdaptiveWorkbenchPanelView, inj2218_ResizeFlowPanel_creational.getInstance(context));
      _$1397438695__$262319993_panelManager(inj2401_AdaptiveWorkbenchPanelView, inj2211_PanelManagerImpl);
      _$1397438695__$1825231548_layoutSelection(inj2401_AdaptiveWorkbenchPanelView, inj2209_LayoutSelection);
      context.addInitializationCallback(inj2401_AdaptiveWorkbenchPanelView, init_inj2401_AdaptiveWorkbenchPanelView);
      context.addDestructionCallback(inj2401_AdaptiveWorkbenchPanelView, destroy_inj2401_AdaptiveWorkbenchPanelView);
      return inj2401_AdaptiveWorkbenchPanelView;
    }
  };
  private InitializationCallback<SimpleWorkbenchPanelView> init_inj2403_SimpleWorkbenchPanelView = new InitializationCallback<SimpleWorkbenchPanelView>() {
    public void init(final SimpleWorkbenchPanelView obj) {
      _618642634_setupDockingPanel(obj);
      _1346204971_setup(obj);
    }
  };
  private DestructionCallback<SimpleWorkbenchPanelView> destroy_inj2403_SimpleWorkbenchPanelView = new DestructionCallback<SimpleWorkbenchPanelView>() {
    public void destroy(final SimpleWorkbenchPanelView obj) {
      _618642634_tearDownDockingPanel(obj);
    }
  };
  private final BeanProvider<SimpleWorkbenchPanelView> inj2404_SimpleWorkbenchPanelView_creational = new BeanProvider<SimpleWorkbenchPanelView>() {
    public SimpleWorkbenchPanelView getInstance(final CreationalContext context) {
      final SimpleWorkbenchPanelView inj2403_SimpleWorkbenchPanelView = new SimpleWorkbenchPanelView();
      context.addBean(context.getBeanReference(SimpleWorkbenchPanelView.class, arrayOf_19635043Annotation_351968993), inj2403_SimpleWorkbenchPanelView);
      _1346204971__$924432381_listBar(inj2403_SimpleWorkbenchPanelView, inj2214_ListBarWidgetImpl_creational.getInstance(context));
      _618642634__153624969_dndManager(inj2403_SimpleWorkbenchPanelView, inj2200_WorkbenchDragAndDropManager);
      _618642634__$1887041540_factory(inj2403_SimpleWorkbenchPanelView, inj2198_DefaultBeanFactory);
      _618642634__$634457504_topLevelWidget(inj2403_SimpleWorkbenchPanelView, inj2217_SimpleLayoutPanel_creational.getInstance(context));
      _618642634__820873068_partViewContainer(inj2403_SimpleWorkbenchPanelView, inj2218_ResizeFlowPanel_creational.getInstance(context));
      _$1397438695__$262319993_panelManager(inj2403_SimpleWorkbenchPanelView, inj2211_PanelManagerImpl);
      _$1397438695__$1825231548_layoutSelection(inj2403_SimpleWorkbenchPanelView, inj2209_LayoutSelection);
      context.addInitializationCallback(inj2403_SimpleWorkbenchPanelView, init_inj2403_SimpleWorkbenchPanelView);
      context.addDestructionCallback(inj2403_SimpleWorkbenchPanelView, destroy_inj2403_SimpleWorkbenchPanelView);
      return inj2403_SimpleWorkbenchPanelView;
    }
  };
  private InitializationCallback<LessStyle> init_inj2405_LessStyle = new InitializationCallback<LessStyle>() {
    public void init(final LessStyle obj) {
      obj.init();
    }
  };
  private final BeanProvider<LessStyle> inj2406_LessStyle_creational = new BeanProvider<LessStyle>() {
    public LessStyle getInstance(final CreationalContext context) {
      final LessStyle inj2405_LessStyle = new LessStyle();
      context.addBean(context.getBeanReference(LessStyle.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2405_LessStyle);
      context.addInitializationCallback(inj2405_LessStyle, init_inj2405_LessStyle);
      return inj2405_LessStyle;
    }
  };
  private final LessStyle inj2405_LessStyle = inj2406_LessStyle_creational.getInstance(context);
  private final BeanProvider<MoodPerspectiveActivity> inj2408_MoodPerspectiveActivity_creational = new BeanProvider<MoodPerspectiveActivity>() {
    public MoodPerspectiveActivity getInstance(final CreationalContext context) {
      final PlaceManager var96 = inj2264_PlaceManagerImpl;
      final MoodPerspectiveActivity inj2407_MoodPerspectiveActivity = new MoodPerspectiveActivity(var96);
      context.addBean(context.getBeanReference(MoodPerspectiveActivity.class, arrayOf_19635043Annotation_1179408223), inj2407_MoodPerspectiveActivity);
      _$1702547732__1274864829_realPresenter(inj2407_MoodPerspectiveActivity, inj2366_MoodPerspective_creational.getInstance(context));
      return inj2407_MoodPerspectiveActivity;
    }
  };
  private final BeanProvider<EventBus> inj2148_EventBus_creational = new BeanProvider<EventBus>() {
    public EventBus getInstance(CreationalContext pContext) {
      EventBus var97 = _$1757102468_produceEventBus(inj2264_PlaceManagerImpl);
      context.addBean(context.getBeanReference(EventBus.class, QualifierUtil.DEFAULT_QUALIFIERS), var97);
      return var97;
    }
  };
  private final BeanProvider<PluginJSExporter> inj2410_PluginJSExporter_creational = new BeanProvider<PluginJSExporter>() {
    public PluginJSExporter getInstance(final CreationalContext context) {
      final PluginJSExporter inj2409_PluginJSExporter = new PluginJSExporter();
      context.addBean(context.getBeanReference(PluginJSExporter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2409_PluginJSExporter);
      return inj2409_PluginJSExporter;
    }
  };
  private final PluginJSExporter inj2409_PluginJSExporter = inj2410_PluginJSExporter_creational.getInstance(context);
  private final BeanProvider<DefaultRestSecurityErrorCallback> inj2412_DefaultRestSecurityErrorCallback_creational = new BeanProvider<DefaultRestSecurityErrorCallback>() {
    public DefaultRestSecurityErrorCallback getInstance(final CreationalContext context) {
      final SecurityContext var98 = inj2234_SecurityContextImpl;
      final DefaultRestSecurityErrorCallback inj2411_DefaultRestSecurityErrorCallback = new DefaultRestSecurityErrorCallback(var98);
      context.addBean(context.getBeanReference(DefaultRestSecurityErrorCallback.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2411_DefaultRestSecurityErrorCallback);
      return inj2411_DefaultRestSecurityErrorCallback;
    }
  };
  private final BeanProvider<SplashScreenMenuView> inj2414_SplashScreenMenuView_creational = new BeanProvider<SplashScreenMenuView>() {
    public SplashScreenMenuView getInstance(final CreationalContext context) {
      final SplashScreenMenuView inj2413_SplashScreenMenuView = new SplashScreenMenuView();
      context.addBean(context.getBeanReference(SplashScreenMenuView.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2413_SplashScreenMenuView);
      return inj2413_SplashScreenMenuView;
    }
  };
  private final BeanProvider<SplashScreenMenuPresenter> inj2416_SplashScreenMenuPresenter_creational = new BeanProvider<SplashScreenMenuPresenter>() {
    public SplashScreenMenuPresenter getInstance(final CreationalContext context) {
      final PlaceManager var99 = inj2264_PlaceManagerImpl;
      final View var100 = inj2414_SplashScreenMenuView_creational.getInstance(context);
      final SplashScreenMenuPresenter inj2415_SplashScreenMenuPresenter = new SplashScreenMenuPresenter(var99, var100);
      context.addBean(context.getBeanReference(SplashScreenMenuPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2415_SplashScreenMenuPresenter);
      final Subscription var101 = CDI.subscribeLocal("org.uberfire.client.workbench.events.NewSplashScreenActiveEvent", new AbstractCDIEventCallback<NewSplashScreenActiveEvent>() {
        public void fireEvent(final NewSplashScreenActiveEvent event) {
          _348398006_onNewSplashScreen_NewSplashScreenActiveEvent(inj2415_SplashScreenMenuPresenter, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.NewSplashScreenActiveEvent []";
        }
      });
      context.addDestructionCallback(inj2415_SplashScreenMenuPresenter, new DestructionCallback<SplashScreenMenuPresenter>() {
        public void destroy(final SplashScreenMenuPresenter obj) {
          var101.remove();
          // WEEEEE!;
        }
      });
      return inj2415_SplashScreenMenuPresenter;
    }
  };
  private final SplashScreenMenuPresenter inj2415_SplashScreenMenuPresenter = inj2416_SplashScreenMenuPresenter_creational.getInstance(context);
  private final BeanProvider<LocaleSelector> inj2418_LocaleSelector_creational = new BeanProvider<LocaleSelector>() {
    public LocaleSelector getInstance(final CreationalContext context) {
      final LocaleSelector inj2417_LocaleSelector = new LocaleSelector();
      context.addBean(context.getBeanReference(LocaleSelector.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2417_LocaleSelector);
      return inj2417_LocaleSelector;
    }
  };
  private final LocaleSelector inj2417_LocaleSelector = inj2418_LocaleSelector_creational.getInstance(context);
  private final BeanProvider<LocaleListBox> inj2420_LocaleListBox_creational = new BeanProvider<LocaleListBox>() {
    public LocaleListBox getInstance(final CreationalContext context) {
      final LocaleListBox inj2419_LocaleListBox = new LocaleListBox();
      context.addBean(context.getBeanReference(LocaleListBox.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2419_LocaleListBox);
      _1350680564__$1232121576_selector(inj2419_LocaleListBox, inj2417_LocaleSelector);
      InitVotes.registerOneTimeInitCallback(new Runnable() {
        public void run() {
          inj2419_LocaleListBox.init();
        }
      });
      return inj2419_LocaleListBox;
    }
  };
  private InitializationCallback<SimpleDnDWorkbenchPanelView> init_inj2421_SimpleDnDWorkbenchPanelView = new InitializationCallback<SimpleDnDWorkbenchPanelView>() {
    public void init(final SimpleDnDWorkbenchPanelView obj) {
      _618642634_setupDockingPanel(obj);
      _1346204971_setup(obj);
    }
  };
  private DestructionCallback<SimpleDnDWorkbenchPanelView> destroy_inj2421_SimpleDnDWorkbenchPanelView = new DestructionCallback<SimpleDnDWorkbenchPanelView>() {
    public void destroy(final SimpleDnDWorkbenchPanelView obj) {
      _618642634_tearDownDockingPanel(obj);
    }
  };
  private final BeanProvider<SimpleDnDWorkbenchPanelView> inj2422_SimpleDnDWorkbenchPanelView_creational = new BeanProvider<SimpleDnDWorkbenchPanelView>() {
    public SimpleDnDWorkbenchPanelView getInstance(final CreationalContext context) {
      final SimpleDnDWorkbenchPanelView inj2421_SimpleDnDWorkbenchPanelView = new SimpleDnDWorkbenchPanelView();
      context.addBean(context.getBeanReference(SimpleDnDWorkbenchPanelView.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2421_SimpleDnDWorkbenchPanelView);
      _1346204971__$924432381_listBar(inj2421_SimpleDnDWorkbenchPanelView, inj2214_ListBarWidgetImpl_creational.getInstance(context));
      _618642634__153624969_dndManager(inj2421_SimpleDnDWorkbenchPanelView, inj2200_WorkbenchDragAndDropManager);
      _618642634__$1887041540_factory(inj2421_SimpleDnDWorkbenchPanelView, inj2198_DefaultBeanFactory);
      _618642634__$634457504_topLevelWidget(inj2421_SimpleDnDWorkbenchPanelView, inj2217_SimpleLayoutPanel_creational.getInstance(context));
      _618642634__820873068_partViewContainer(inj2421_SimpleDnDWorkbenchPanelView, inj2218_ResizeFlowPanel_creational.getInstance(context));
      _$1397438695__$262319993_panelManager(inj2421_SimpleDnDWorkbenchPanelView, inj2211_PanelManagerImpl);
      _$1397438695__$1825231548_layoutSelection(inj2421_SimpleDnDWorkbenchPanelView, inj2209_LayoutSelection);
      context.addInitializationCallback(inj2421_SimpleDnDWorkbenchPanelView, init_inj2421_SimpleDnDWorkbenchPanelView);
      context.addDestructionCallback(inj2421_SimpleDnDWorkbenchPanelView, destroy_inj2421_SimpleDnDWorkbenchPanelView);
      return inj2421_SimpleDnDWorkbenchPanelView;
    }
  };
  private InitializationCallback<MultiListWorkbenchPanelView> init_inj2423_MultiListWorkbenchPanelView = new InitializationCallback<MultiListWorkbenchPanelView>() {
    public void init(final MultiListWorkbenchPanelView obj) {
      _618642634_setupDockingPanel(obj);
      _$821728441_setupMultiPartPanel(obj);
    }
  };
  private DestructionCallback<MultiListWorkbenchPanelView> destroy_inj2423_MultiListWorkbenchPanelView = new DestructionCallback<MultiListWorkbenchPanelView>() {
    public void destroy(final MultiListWorkbenchPanelView obj) {
      _618642634_tearDownDockingPanel(obj);
    }
  };
  private final BeanProvider<MultiListWorkbenchPanelView> inj2424_MultiListWorkbenchPanelView_creational = new BeanProvider<MultiListWorkbenchPanelView>() {
    public MultiListWorkbenchPanelView getInstance(final CreationalContext context) {
      final MultiListWorkbenchPanelView inj2423_MultiListWorkbenchPanelView = new MultiListWorkbenchPanelView();
      context.addBean(context.getBeanReference(MultiListWorkbenchPanelView.class, arrayOf_19635043Annotation_381280622), inj2423_MultiListWorkbenchPanelView);
      _474272692__$924432381_listBar(inj2423_MultiListWorkbenchPanelView, inj2214_ListBarWidgetImpl_creational.getInstance(context));
      _618642634__153624969_dndManager(inj2423_MultiListWorkbenchPanelView, inj2200_WorkbenchDragAndDropManager);
      _618642634__$1887041540_factory(inj2423_MultiListWorkbenchPanelView, inj2198_DefaultBeanFactory);
      _618642634__$634457504_topLevelWidget(inj2423_MultiListWorkbenchPanelView, inj2217_SimpleLayoutPanel_creational.getInstance(context));
      _618642634__820873068_partViewContainer(inj2423_MultiListWorkbenchPanelView, inj2218_ResizeFlowPanel_creational.getInstance(context));
      _$1397438695__$262319993_panelManager(inj2423_MultiListWorkbenchPanelView, inj2211_PanelManagerImpl);
      _$1397438695__$1825231548_layoutSelection(inj2423_MultiListWorkbenchPanelView, inj2209_LayoutSelection);
      context.addInitializationCallback(inj2423_MultiListWorkbenchPanelView, init_inj2423_MultiListWorkbenchPanelView);
      context.addDestructionCallback(inj2423_MultiListWorkbenchPanelView, destroy_inj2423_MultiListWorkbenchPanelView);
      return inj2423_MultiListWorkbenchPanelView;
    }
  };
  private InitializationCallback<ClosableSimpleWorkbenchPanelPresenter> init_inj2425_ClosableSimpleWorkbenchPanelPresenter = new InitializationCallback<ClosableSimpleWorkbenchPanelPresenter>() {
    public void init(final ClosableSimpleWorkbenchPanelPresenter obj) {
      _253255348_init(obj);
    }
  };
  private final BeanProvider<ClosableSimpleWorkbenchPanelPresenter> inj2426_ClosableSimpleWorkbenchPanelPresenter_creational = new BeanProvider<ClosableSimpleWorkbenchPanelPresenter>() {
    public ClosableSimpleWorkbenchPanelPresenter getInstance(final CreationalContext context) {
      final WorkbenchPanelView var102 = inj2216_ClosableSimpleWorkbenchPanelView_creational.getInstance(context);
      final PerspectiveManager var103 = inj2255_PerspectiveManagerImpl;
      final ClosableSimpleWorkbenchPanelPresenter inj2425_ClosableSimpleWorkbenchPanelPresenter = new ClosableSimpleWorkbenchPanelPresenter(var102, var103);
      context.addBean(context.getBeanReference(ClosableSimpleWorkbenchPanelPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2425_ClosableSimpleWorkbenchPanelPresenter);
      _1653100451__$262319993_panelManager(inj2425_ClosableSimpleWorkbenchPanelPresenter, inj2211_PanelManagerImpl);
      context.addInitializationCallback(inj2425_ClosableSimpleWorkbenchPanelPresenter, init_inj2425_ClosableSimpleWorkbenchPanelPresenter);
      return inj2425_ClosableSimpleWorkbenchPanelPresenter;
    }
  };
  private InitializationCallback<RoleStyleBindingProvider> init_inj2427_RoleStyleBindingProvider = new InitializationCallback<RoleStyleBindingProvider>() {
    public void init(final RoleStyleBindingProvider obj) {
      obj.init();
    }
  };
  private final BeanProvider<RoleStyleBindingProvider> inj2428_RoleStyleBindingProvider_creational = new BeanProvider<RoleStyleBindingProvider>() {
    public RoleStyleBindingProvider getInstance(final CreationalContext context) {
      final ActiveUserCache var104 = inj2203_BasicUserCacheImpl;
      final RequiredRolesExtractor var105 = inj2237_ClientRequiredRolesExtractorImpl_creational.getInstance(context);
      final RoleStyleBindingProvider inj2427_RoleStyleBindingProvider = new RoleStyleBindingProvider(var104, var105);
      context.addBean(context.getBeanReference(RoleStyleBindingProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2427_RoleStyleBindingProvider);
      context.addInitializationCallback(inj2427_RoleStyleBindingProvider, init_inj2427_RoleStyleBindingProvider);
      return inj2427_RoleStyleBindingProvider;
    }
  };
  private final RoleStyleBindingProvider inj2427_RoleStyleBindingProvider = inj2428_RoleStyleBindingProvider_creational.getInstance(context);
  private final BeanProvider<AnyResourceType> inj2430_AnyResourceType_creational = new BeanProvider<AnyResourceType>() {
    public AnyResourceType getInstance(final CreationalContext context) {
      final AnyResourceType inj2429_AnyResourceType = new AnyResourceType();
      context.addBean(context.getBeanReference(AnyResourceType.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2429_AnyResourceType);
      return inj2429_AnyResourceType;
    }
  };
  private final AnyResourceType inj2429_AnyResourceType = inj2430_AnyResourceType_creational.getInstance(context);
  private InitializationCallback<AdaptiveWorkbenchPanelPresenter> init_inj2431_AdaptiveWorkbenchPanelPresenter = new InitializationCallback<AdaptiveWorkbenchPanelPresenter>() {
    public void init(final AdaptiveWorkbenchPanelPresenter obj) {
      _253255348_init(obj);
    }
  };
  private final BeanProvider<AdaptiveWorkbenchPanelPresenter> inj2432_AdaptiveWorkbenchPanelPresenter_creational = new BeanProvider<AdaptiveWorkbenchPanelPresenter>() {
    public AdaptiveWorkbenchPanelPresenter getInstance(final CreationalContext context) {
      final WorkbenchPanelView var106 = inj2402_AdaptiveWorkbenchPanelView_creational.getInstance(context);
      final PerspectiveManager var107 = inj2255_PerspectiveManagerImpl;
      final AdaptiveWorkbenchPanelPresenter inj2431_AdaptiveWorkbenchPanelPresenter = new AdaptiveWorkbenchPanelPresenter(var106, var107);
      context.addBean(context.getBeanReference(AdaptiveWorkbenchPanelPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2431_AdaptiveWorkbenchPanelPresenter);
      _1653100451__$262319993_panelManager(inj2431_AdaptiveWorkbenchPanelPresenter, inj2211_PanelManagerImpl);
      context.addInitializationCallback(inj2431_AdaptiveWorkbenchPanelPresenter, init_inj2431_AdaptiveWorkbenchPanelPresenter);
      return inj2431_AdaptiveWorkbenchPanelPresenter;
    }
  };
  private InitializationCallback<SimpleWorkbenchPanelPresenter> init_inj2433_SimpleWorkbenchPanelPresenter = new InitializationCallback<SimpleWorkbenchPanelPresenter>() {
    public void init(final SimpleWorkbenchPanelPresenter obj) {
      _253255348_init(obj);
    }
  };
  private final BeanProvider<SimpleWorkbenchPanelPresenter> inj2434_SimpleWorkbenchPanelPresenter_creational = new BeanProvider<SimpleWorkbenchPanelPresenter>() {
    public SimpleWorkbenchPanelPresenter getInstance(final CreationalContext context) {
      final WorkbenchPanelView var108 = inj2404_SimpleWorkbenchPanelView_creational.getInstance(context);
      final PerspectiveManager var109 = inj2255_PerspectiveManagerImpl;
      final SimpleWorkbenchPanelPresenter inj2433_SimpleWorkbenchPanelPresenter = new SimpleWorkbenchPanelPresenter(var108, var109);
      context.addBean(context.getBeanReference(SimpleWorkbenchPanelPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2433_SimpleWorkbenchPanelPresenter);
      _1653100451__$262319993_panelManager(inj2433_SimpleWorkbenchPanelPresenter, inj2211_PanelManagerImpl);
      context.addInitializationCallback(inj2433_SimpleWorkbenchPanelPresenter, init_inj2433_SimpleWorkbenchPanelPresenter);
      return inj2433_SimpleWorkbenchPanelPresenter;
    }
  };
  private final BeanProvider<DotResourceType> inj2436_DotResourceType_creational = new BeanProvider<DotResourceType>() {
    public DotResourceType getInstance(final CreationalContext context) {
      final DotResourceType inj2435_DotResourceType = new DotResourceType();
      context.addBean(context.getBeanReference(DotResourceType.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2435_DotResourceType);
      return inj2435_DotResourceType;
    }
  };
  private final DotResourceType inj2435_DotResourceType = inj2436_DotResourceType_creational.getInstance(context);
  private final BeanProvider<SplashScreenJSExporter> inj2438_SplashScreenJSExporter_creational = new BeanProvider<SplashScreenJSExporter>() {
    public SplashScreenJSExporter getInstance(final CreationalContext context) {
      final SplashScreenJSExporter inj2437_SplashScreenJSExporter = new SplashScreenJSExporter();
      context.addBean(context.getBeanReference(SplashScreenJSExporter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2437_SplashScreenJSExporter);
      return inj2437_SplashScreenJSExporter;
    }
  };
  private final SplashScreenJSExporter inj2437_SplashScreenJSExporter = inj2438_SplashScreenJSExporter_creational.getInstance(context);
  private final BeanProvider<PerspectiveJSExporter> inj2440_PerspectiveJSExporter_creational = new BeanProvider<PerspectiveJSExporter>() {
    public PerspectiveJSExporter getInstance(final CreationalContext context) {
      final PerspectiveJSExporter inj2439_PerspectiveJSExporter = new PerspectiveJSExporter();
      context.addBean(context.getBeanReference(PerspectiveJSExporter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2439_PerspectiveJSExporter);
      return inj2439_PerspectiveJSExporter;
    }
  };
  private final PerspectiveJSExporter inj2439_PerspectiveJSExporter = inj2440_PerspectiveJSExporter_creational.getInstance(context);
  private final BeanProvider<ErrorPopupPresenter> inj2442_ErrorPopupPresenter_creational = new BeanProvider<ErrorPopupPresenter>() {
    public ErrorPopupPresenter getInstance(final CreationalContext context) {
      final org.uberfire.client.workbench.widgets.common.ErrorPopupPresenter.View var110 = inj2271_ErrorPopupView_creational.getInstance(context);
      final ErrorPopupPresenter inj2441_ErrorPopupPresenter = new ErrorPopupPresenter(var110);
      context.addBean(context.getBeanReference(ErrorPopupPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2441_ErrorPopupPresenter);
      return inj2441_ErrorPopupPresenter;
    }
  };
  private final ErrorPopupPresenter inj2441_ErrorPopupPresenter = inj2442_ErrorPopupPresenter_creational.getInstance(context);
  private InitializationCallback<WorkbenchBackendEntryPoint> init_inj2443_WorkbenchBackendEntryPoint = new InitializationCallback<WorkbenchBackendEntryPoint>() {
    public void init(final WorkbenchBackendEntryPoint obj) {
      obj.init();
    }
  };
  private final BeanProvider<WorkbenchBackendEntryPoint> inj2444_WorkbenchBackendEntryPoint_creational = new BeanProvider<WorkbenchBackendEntryPoint>() {
    public WorkbenchBackendEntryPoint getInstance(final CreationalContext context) {
      final WorkbenchBackendEntryPoint inj2443_WorkbenchBackendEntryPoint = new WorkbenchBackendEntryPoint();
      context.addBean(context.getBeanReference(WorkbenchBackendEntryPoint.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2443_WorkbenchBackendEntryPoint);
      _$679243230__879292651_bus(inj2443_WorkbenchBackendEntryPoint, inj2191_MessageBusProvider.get());
      _$679243230__1671104094_errorPopupPresenter(inj2443_WorkbenchBackendEntryPoint, inj2441_ErrorPopupPresenter);
      context.addInitializationCallback(inj2443_WorkbenchBackendEntryPoint, init_inj2443_WorkbenchBackendEntryPoint);
      return inj2443_WorkbenchBackendEntryPoint;
    }
  };
  private final WorkbenchBackendEntryPoint inj2443_WorkbenchBackendEntryPoint = inj2444_WorkbenchBackendEntryPoint_creational.getInstance(context);
  private final BeanProvider<MoodScreen> inj2446_MoodScreen_creational = new BeanProvider<MoodScreen>() {
    public MoodScreen getInstance(final CreationalContext context) {
      final MoodScreen inj2445_MoodScreen = new MoodScreen();
      context.addBean(context.getBeanReference(MoodScreen.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2445_MoodScreen);
      _1150956601__$371269162_moodTextBox(inj2445_MoodScreen, inj2318_TextBox_creational.getInstance(context));
      _1150956601__1116818801_moodEvent(inj2445_MoodScreen, inj2187_EventProvider.provide(new Class[] { Mood.class }, null));
      context.addInitializationCallback(inj2445_MoodScreen, new InitializationCallback<MoodScreen>() {
        public void init(final MoodScreen obj) {
          org_uberfire_client_screens_MoodScreenTemplateResource var111 = GWT.create(org_uberfire_client_screens_MoodScreenTemplateResource.class);
          Element var112 = TemplateUtil.getRootTemplateElement(var111.getContents().getText(), "org/uberfire/client/screens/MoodScreen.html", "");
          TemplateUtil.translateTemplate("org/uberfire/client/screens/MoodScreen.html", var112);
          Map<String, Element> var113 = TemplateUtil.getDataFieldElements(var112);
          Map<String, Widget> var114 = new LinkedHashMap<String, Widget>();
          TemplateUtil.compositeComponentReplace("org.uberfire.client.screens.MoodScreen", "org/uberfire/client/screens/MoodScreen.html", _1150956601__$371269162_moodTextBox(inj2445_MoodScreen), var113, "moodTextBox");
          var114.put("moodTextBox", _1150956601__$371269162_moodTextBox(inj2445_MoodScreen));
          TemplateUtil.initWidget(inj2445_MoodScreen, var112, var114.values());
          ((HasKeyDownHandlers) var114.get("moodTextBox")).addKeyDownHandler(new KeyDownHandler() {
            public void onKeyDown(KeyDownEvent event) {
              _1150956601_onKeyDown_KeyDownEvent(inj2445_MoodScreen, event);
            }
          });
        }
      });
      return inj2445_MoodScreen;
    }
  };
  private InitializationCallback<ShowcaseEntryPoint> init_inj2447_ShowcaseEntryPoint = new InitializationCallback<ShowcaseEntryPoint>() {
    public void init(final ShowcaseEntryPoint obj) {
      obj.startApp();
    }
  };
  private final BeanProvider<ShowcaseEntryPoint> inj2448_ShowcaseEntryPoint_creational = new BeanProvider<ShowcaseEntryPoint>() {
    public ShowcaseEntryPoint getInstance(final CreationalContext context) {
      final ShowcaseEntryPoint inj2447_ShowcaseEntryPoint = new ShowcaseEntryPoint();
      context.addBean(context.getBeanReference(ShowcaseEntryPoint.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2447_ShowcaseEntryPoint);
      _73328378__$351881561_menubar(inj2447_ShowcaseEntryPoint, inj2288_WorkbenchMenuBarPresenter);
      _73328378__$906533316_placeManager(inj2447_ShowcaseEntryPoint, inj2264_PlaceManagerImpl);
      final Subscription var115 = CDI.subscribeLocal("org.uberfire.client.workbench.events.ApplicationReadyEvent", new AbstractCDIEventCallback<ApplicationReadyEvent>() {
        public void fireEvent(final ApplicationReadyEvent event) {
          _73328378_setupMenu_ApplicationReadyEvent(inj2447_ShowcaseEntryPoint, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.ApplicationReadyEvent []";
        }
      });
      context.addDestructionCallback(inj2447_ShowcaseEntryPoint, new DestructionCallback<ShowcaseEntryPoint>() {
        public void destroy(final ShowcaseEntryPoint obj) {
          var115.remove();
          // WEEEEE!;
        }
      });
      context.addInitializationCallback(inj2447_ShowcaseEntryPoint, init_inj2447_ShowcaseEntryPoint);
      return inj2447_ShowcaseEntryPoint;
    }
  };
  private final ShowcaseEntryPoint inj2447_ShowcaseEntryPoint = inj2448_ShowcaseEntryPoint_creational.getInstance(context);
  private InitializationCallback<SecurityContextHoldingSingleton> init_inj2449_SecurityContextHoldingSingleton = new InitializationCallback<SecurityContextHoldingSingleton>() {
    public void init(final SecurityContextHoldingSingleton obj) {
      _322507922_setInstance(obj);
    }
  };
  private final BeanProvider<SecurityContextHoldingSingleton> inj2450_SecurityContextHoldingSingleton_creational = new BeanProvider<SecurityContextHoldingSingleton>() {
    public SecurityContextHoldingSingleton getInstance(final CreationalContext context) {
      final SecurityContext var116 = inj2234_SecurityContextImpl;
      final SecurityContextHoldingSingleton inj2449_SecurityContextHoldingSingleton = new SecurityContextHoldingSingleton(var116);
      context.addBean(context.getBeanReference(SecurityContextHoldingSingleton.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2449_SecurityContextHoldingSingleton);
      context.addInitializationCallback(inj2449_SecurityContextHoldingSingleton, init_inj2449_SecurityContextHoldingSingleton);
      return inj2449_SecurityContextHoldingSingleton;
    }
  };
  private final SecurityContextHoldingSingleton inj2449_SecurityContextHoldingSingleton = inj2450_SecurityContextHoldingSingleton_creational.getInstance(context);
  private final BeanProvider<WorkbenchViewModeSwitcherPresenter> inj2452_WorkbenchViewModeSwitcherPresenter_creational = new BeanProvider<WorkbenchViewModeSwitcherPresenter>() {
    public WorkbenchViewModeSwitcherPresenter getInstance(final CreationalContext context) {
      final org.uberfire.client.menu.WorkbenchViewModeSwitcherPresenter.View var117 = inj2386_WorkbenchViewModeSwitcherView_creational.getInstance(context);
      final WorkbenchMenuBar var118 = inj2288_WorkbenchMenuBarPresenter;
      final WorkbenchViewModeSwitcherPresenter inj2451_WorkbenchViewModeSwitcherPresenter = new WorkbenchViewModeSwitcherPresenter(var117, var118);
      context.addBean(context.getBeanReference(WorkbenchViewModeSwitcherPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2451_WorkbenchViewModeSwitcherPresenter);
      final Subscription var119 = CDI.subscribeLocal("org.uberfire.client.workbench.events.PerspectiveChange", new AbstractCDIEventCallback<PerspectiveChange>() {
        public void fireEvent(final PerspectiveChange event) {
          _$1098181088_onPerspectiveChange_PerspectiveChange(inj2451_WorkbenchViewModeSwitcherPresenter, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.PerspectiveChange []";
        }
      });
      context.addDestructionCallback(inj2451_WorkbenchViewModeSwitcherPresenter, new DestructionCallback<WorkbenchViewModeSwitcherPresenter>() {
        public void destroy(final WorkbenchViewModeSwitcherPresenter obj) {
          var119.remove();
          // WEEEEE!;
        }
      });
      final Subscription var120 = CDI.subscribeLocal("org.uberfire.client.workbench.events.PlaceMinimizedEvent", new AbstractCDIEventCallback<PlaceMinimizedEvent>() {
        public void fireEvent(final PlaceMinimizedEvent event) {
          _$1098181088_onPlaceMinimized_PlaceMinimizedEvent(inj2451_WorkbenchViewModeSwitcherPresenter, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.PlaceMinimizedEvent []";
        }
      });
      context.addDestructionCallback(inj2451_WorkbenchViewModeSwitcherPresenter, new DestructionCallback<WorkbenchViewModeSwitcherPresenter>() {
        public void destroy(final WorkbenchViewModeSwitcherPresenter obj) {
          var120.remove();
          // WEEEEE!;
        }
      });
      final Subscription var121 = CDI.subscribeLocal("org.uberfire.client.workbench.events.PlaceMaximizedEvent", new AbstractCDIEventCallback<PlaceMaximizedEvent>() {
        public void fireEvent(final PlaceMaximizedEvent event) {
          _$1098181088_onPlaceMaximized_PlaceMaximizedEvent(inj2451_WorkbenchViewModeSwitcherPresenter, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.PlaceMaximizedEvent []";
        }
      });
      context.addDestructionCallback(inj2451_WorkbenchViewModeSwitcherPresenter, new DestructionCallback<WorkbenchViewModeSwitcherPresenter>() {
        public void destroy(final WorkbenchViewModeSwitcherPresenter obj) {
          var121.remove();
          // WEEEEE!;
        }
      });
      return inj2451_WorkbenchViewModeSwitcherPresenter;
    }
  };
  private final BeanProvider<SecurityEntryPoint> inj2454_SecurityEntryPoint_creational = new BeanProvider<SecurityEntryPoint>() {
    public SecurityEntryPoint getInstance(final CreationalContext context) {
      final SecurityEntryPoint inj2453_SecurityEntryPoint = new SecurityEntryPoint();
      context.addBean(context.getBeanReference(SecurityEntryPoint.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2453_SecurityEntryPoint);
      _1135152903__879292651_bus(inj2453_SecurityEntryPoint, inj2191_MessageBusProvider.get());
      return inj2453_SecurityEntryPoint;
    }
  };
  private final SecurityEntryPoint inj2453_SecurityEntryPoint = inj2454_SecurityEntryPoint_creational.getInstance(context);
  private final BeanProvider<UtilityMenuBarPresenter> inj2456_UtilityMenuBarPresenter_creational = new BeanProvider<UtilityMenuBarPresenter>() {
    public UtilityMenuBarPresenter getInstance(final CreationalContext context) {
      final UtilityMenuBarPresenter inj2455_UtilityMenuBarPresenter = new UtilityMenuBarPresenter();
      context.addBean(context.getBeanReference(UtilityMenuBarPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2455_UtilityMenuBarPresenter);
      _$111792914__434812091_view(inj2455_UtilityMenuBarPresenter, inj2284_UtilityMenuBarView);
      return inj2455_UtilityMenuBarPresenter;
    }
  };
  private final UtilityMenuBarPresenter inj2455_UtilityMenuBarPresenter = inj2456_UtilityMenuBarPresenter_creational.getInstance(context);
  private InitializationCallback<MultiTabWorkbenchPanelPresenter> init_inj2457_MultiTabWorkbenchPanelPresenter = new InitializationCallback<MultiTabWorkbenchPanelPresenter>() {
    public void init(final MultiTabWorkbenchPanelPresenter obj) {
      _253255348_init(obj);
    }
  };
  private final BeanProvider<MultiTabWorkbenchPanelPresenter> inj2458_MultiTabWorkbenchPanelPresenter_creational = new BeanProvider<MultiTabWorkbenchPanelPresenter>() {
    public MultiTabWorkbenchPanelPresenter getInstance(final CreationalContext context) {
      final WorkbenchPanelView var122 = inj2365_MultiTabWorkbenchPanelView_creational.getInstance(context);
      final ActivityManager var123 = inj2259_ActivityManagerImpl;
      final PerspectiveManager var124 = inj2255_PerspectiveManagerImpl;
      final MultiTabWorkbenchPanelPresenter inj2457_MultiTabWorkbenchPanelPresenter = new MultiTabWorkbenchPanelPresenter(var122, var123, var124);
      context.addBean(context.getBeanReference(MultiTabWorkbenchPanelPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2457_MultiTabWorkbenchPanelPresenter);
      _1653100451__$262319993_panelManager(inj2457_MultiTabWorkbenchPanelPresenter, inj2211_PanelManagerImpl);
      context.addInitializationCallback(inj2457_MultiTabWorkbenchPanelPresenter, init_inj2457_MultiTabWorkbenchPanelPresenter);
      return inj2457_MultiTabWorkbenchPanelPresenter;
    }
  };
  private final BeanProvider<WorkbenchPartView> inj2461_WorkbenchPartView_creational = new BeanProvider<WorkbenchPartView>() {
    public WorkbenchPartView getInstance(final CreationalContext context) {
      final WorkbenchPartView inj1988_WorkbenchPartView = new WorkbenchPartView();
      context.addBean(context.getBeanReference(WorkbenchPartView.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1988_WorkbenchPartView);
      return inj1988_WorkbenchPartView;
    }
  };
  private InitializationCallback<WorkbenchPartPresenterDefault> init_inj2459_WorkbenchPartPresenterDefault = new InitializationCallback<WorkbenchPartPresenterDefault>() {
    public void init(final WorkbenchPartPresenterDefault obj) {
      _35605411_init(obj);
    }
  };
  private final BeanProvider<WorkbenchPartPresenterDefault> inj2460_WorkbenchPartPresenterDefault_creational = new BeanProvider<WorkbenchPartPresenterDefault>() {
    public WorkbenchPartPresenterDefault getInstance(final CreationalContext context) {
      final org.uberfire.client.workbench.part.WorkbenchPartPresenter.View var125 = inj2461_WorkbenchPartView_creational.getInstance(context);
      final WorkbenchPartPresenterDefault inj2459_WorkbenchPartPresenterDefault = new WorkbenchPartPresenterDefault(var125);
      context.addBean(context.getBeanReference(WorkbenchPartPresenterDefault.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2459_WorkbenchPartPresenterDefault);
      context.addInitializationCallback(inj2459_WorkbenchPartPresenterDefault, init_inj2459_WorkbenchPartPresenterDefault);
      return inj2459_WorkbenchPartPresenterDefault;
    }
  };
  private final BeanProvider<ComponentPresenterActivity> inj2463_ComponentPresenterActivity_creational = new BeanProvider<ComponentPresenterActivity>() {
    public ComponentPresenterActivity getInstance(final CreationalContext context) {
      final PlaceManager var126 = inj2264_PlaceManagerImpl;
      final ComponentPresenterActivity inj2462_ComponentPresenterActivity = new ComponentPresenterActivity(var126);
      context.addBean(context.getBeanReference(ComponentPresenterActivity.class, arrayOf_19635043Annotation_1553332319), inj2462_ComponentPresenterActivity);
      _1919272664__$1732630359_realPresenter(inj2462_ComponentPresenterActivity, inj2279_ComponentPresenter_creational.getInstance(context));
      return inj2462_ComponentPresenterActivity;
    }
  };
  private InitializationCallback<PopupViewImpl> init_inj2464_PopupViewImpl = new InitializationCallback<PopupViewImpl>() {
    public void init(final PopupViewImpl obj) {
      obj.init();
    }
  };
  private final BeanProvider<PopupViewImpl> inj2465_PopupViewImpl_creational = new BeanProvider<PopupViewImpl>() {
    public PopupViewImpl getInstance(final CreationalContext context) {
      final PopupViewImpl inj2464_PopupViewImpl = new PopupViewImpl();
      context.addBean(context.getBeanReference(PopupViewImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2464_PopupViewImpl);
      _$2043532045__$1553627672_modal(inj2464_PopupViewImpl, inj2323_Bs3Modal_creational.getInstance(context));
      context.addInitializationCallback(inj2464_PopupViewImpl, init_inj2464_PopupViewImpl);
      return inj2464_PopupViewImpl;
    }
  };
  private final BeanProvider<InitBallotProvider> inj2466_InitBallotProvider_creational = new BeanProvider<InitBallotProvider>() {
    public InitBallotProvider getInstance(final CreationalContext context) {
      final InitBallotProvider inj2157_InitBallotProvider = new InitBallotProvider();
      context.addBean(context.getBeanReference(InitBallotProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2157_InitBallotProvider);
      return inj2157_InitBallotProvider;
    }
  };
  private final InitBallotProvider inj2157_InitBallotProvider = inj2466_InitBallotProvider_creational.getInstance(context);
  private final BeanProvider<JSNativeScreen> inj2468_JSNativeScreen_creational = new BeanProvider<JSNativeScreen>() {
    public JSNativeScreen getInstance(final CreationalContext context) {
      final JSNativeScreen inj2467_JSNativeScreen = new JSNativeScreen();
      context.addBean(context.getBeanReference(JSNativeScreen.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2467_JSNativeScreen);
      _1584088255__$2073863603_runtimePluginsService(inj2467_JSNativeScreen, inj2370_RuntimePluginsServiceProxyBackendImpl_creational.getInstance(context));
      return inj2467_JSNativeScreen;
    }
  };
  private final BeanProvider<CustomSplashHelp> inj2470_CustomSplashHelp_creational = new BeanProvider<CustomSplashHelp>() {
    public CustomSplashHelp getInstance(final CreationalContext context) {
      final CustomSplashHelp inj2469_CustomSplashHelp = new CustomSplashHelp();
      context.addBean(context.getBeanReference(CustomSplashHelp.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2469_CustomSplashHelp);
      return inj2469_CustomSplashHelp;
    }
  };
  private final CustomSplashHelp inj2469_CustomSplashHelp = inj2470_CustomSplashHelp_creational.getInstance(context);
  private InitializationCallback<JSEntryPoint> init_inj2471_JSEntryPoint = new InitializationCallback<JSEntryPoint>() {
    public void init(final JSEntryPoint obj) {
      obj.init();
    }
  };
  private final BeanProvider<JSEntryPoint> inj2472_JSEntryPoint_creational = new BeanProvider<JSEntryPoint>() {
    public JSEntryPoint getInstance(final CreationalContext context) {
      final JSEntryPoint inj2471_JSEntryPoint = new JSEntryPoint();
      context.addBean(context.getBeanReference(JSEntryPoint.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2471_JSEntryPoint);
      _$662927178__$1462522111_workbench(inj2471_JSEntryPoint, inj2357_Workbench);
      _$662927178__$2073863603_runtimePluginsService(inj2471_JSEntryPoint, inj2370_RuntimePluginsServiceProxyBackendImpl_creational.getInstance(context));
      InitVotes.registerOneTimeInitCallback(new Runnable() {
        public void run() {
          inj2471_JSEntryPoint.setup();
        }
      });
      context.addInitializationCallback(inj2471_JSEntryPoint, init_inj2471_JSEntryPoint);
      return inj2471_JSEntryPoint;
    }
  };
  private final JSEntryPoint inj2471_JSEntryPoint = inj2472_JSEntryPoint_creational.getInstance(context);
  private final BeanProvider<JSNativeSplashScreen> inj2474_JSNativeSplashScreen_creational = new BeanProvider<JSNativeSplashScreen>() {
    public JSNativeSplashScreen getInstance(final CreationalContext context) {
      final JSNativeSplashScreen inj2473_JSNativeSplashScreen = new JSNativeSplashScreen();
      context.addBean(context.getBeanReference(JSNativeSplashScreen.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2473_JSNativeSplashScreen);
      _$448678005__$304677073_wbServices(inj2473_JSNativeSplashScreen, inj2252_WorkbenchServicesProxyBackendImpl_creational.getInstance(context));
      _1584088255__$2073863603_runtimePluginsService(inj2473_JSNativeSplashScreen, inj2370_RuntimePluginsServiceProxyBackendImpl_creational.getInstance(context));
      return inj2473_JSNativeSplashScreen;
    }
  };
  private final BeanProvider<MainBrand> inj2151_MainBrand_creational = new BeanProvider<MainBrand>() {
    public MainBrand getInstance(CreationalContext pContext) {
      MainBrand var127 = inj2447_ShowcaseEntryPoint.createBrandLogo();
      context.addBean(context.getBeanReference(MainBrand.class, QualifierUtil.DEFAULT_QUALIFIERS), var127);
      return var127;
    }
  };
  private final BeanProvider<ForceUnlockEventObserver> inj2476_ForceUnlockEventObserver_creational = new BeanProvider<ForceUnlockEventObserver>() {
    public ForceUnlockEventObserver getInstance(final CreationalContext context) {
      final ForceUnlockEventObserver inj2475_ForceUnlockEventObserver = new ForceUnlockEventObserver();
      context.addBean(context.getBeanReference(ForceUnlockEventObserver.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2475_ForceUnlockEventObserver);
      _1033421399__848807465_lockService(inj2475_ForceUnlockEventObserver, inj2345_VFSLockServiceProxyBackendImpl_creational.getInstance(context));
      _1033421399__1671104094_errorPopupPresenter(inj2475_ForceUnlockEventObserver, inj2441_ErrorPopupPresenter);
      final Subscription var128 = CDI.subscribeLocal("org.uberfire.backend.vfs.impl.ForceUnlockEvent", new AbstractCDIEventCallback<ForceUnlockEvent>() {
        public void fireEvent(final ForceUnlockEvent event) {
          _1033421399_onForceUnlock_ForceUnlockEvent(inj2475_ForceUnlockEventObserver, event);
        }
        public String toString() {
          return "Observer: org.uberfire.backend.vfs.impl.ForceUnlockEvent []";
        }
      });
      context.addDestructionCallback(inj2475_ForceUnlockEventObserver, new DestructionCallback<ForceUnlockEventObserver>() {
        public void destroy(final ForceUnlockEventObserver obj) {
          var128.remove();
          // WEEEEE!;
        }
      });
      return inj2475_ForceUnlockEventObserver;
    }
  };
  private final ForceUnlockEventObserver inj2475_ForceUnlockEventObserver = inj2476_ForceUnlockEventObserver_creational.getInstance(context);
  private InitializationCallback<StaticWorkbenchPanelPresenter> init_inj2477_StaticWorkbenchPanelPresenter = new InitializationCallback<StaticWorkbenchPanelPresenter>() {
    public void init(final StaticWorkbenchPanelPresenter obj) {
      _253255348_init(obj);
    }
  };
  private final BeanProvider<StaticWorkbenchPanelPresenter> inj2478_StaticWorkbenchPanelPresenter_creational = new BeanProvider<StaticWorkbenchPanelPresenter>() {
    public StaticWorkbenchPanelPresenter getInstance(final CreationalContext context) {
      final StaticWorkbenchPanelView var129 = inj2347_StaticWorkbenchPanelView_creational.getInstance(context);
      final PerspectiveManager var130 = inj2255_PerspectiveManagerImpl;
      final StaticWorkbenchPanelPresenter inj2477_StaticWorkbenchPanelPresenter = new StaticWorkbenchPanelPresenter(var129, var130);
      context.addBean(context.getBeanReference(StaticWorkbenchPanelPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2477_StaticWorkbenchPanelPresenter);
      context.addInitializationCallback(inj2477_StaticWorkbenchPanelPresenter, init_inj2477_StaticWorkbenchPanelPresenter);
      return inj2477_StaticWorkbenchPanelPresenter;
    }
  };
  private InitializationCallback<MultiListWorkbenchPanelPresenter> init_inj2479_MultiListWorkbenchPanelPresenter = new InitializationCallback<MultiListWorkbenchPanelPresenter>() {
    public void init(final MultiListWorkbenchPanelPresenter obj) {
      _253255348_init(obj);
    }
  };
  private final BeanProvider<MultiListWorkbenchPanelPresenter> inj2480_MultiListWorkbenchPanelPresenter_creational = new BeanProvider<MultiListWorkbenchPanelPresenter>() {
    public MultiListWorkbenchPanelPresenter getInstance(final CreationalContext context) {
      final WorkbenchPanelView var131 = inj2424_MultiListWorkbenchPanelView_creational.getInstance(context);
      final ActivityManager var132 = inj2259_ActivityManagerImpl;
      final PerspectiveManager var133 = inj2255_PerspectiveManagerImpl;
      final MultiListWorkbenchPanelPresenter inj2479_MultiListWorkbenchPanelPresenter = new MultiListWorkbenchPanelPresenter(var131, var132, var133);
      context.addBean(context.getBeanReference(MultiListWorkbenchPanelPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2479_MultiListWorkbenchPanelPresenter);
      _1653100451__$262319993_panelManager(inj2479_MultiListWorkbenchPanelPresenter, inj2211_PanelManagerImpl);
      context.addInitializationCallback(inj2479_MultiListWorkbenchPanelPresenter, init_inj2479_MultiListWorkbenchPanelPresenter);
      return inj2479_MultiListWorkbenchPanelPresenter;
    }
  };
  private final BeanProvider<AccessImpl> inj2482_AccessImpl_creational = new BeanProvider<AccessImpl>() {
    public AccessImpl getInstance(final CreationalContext context) {
      final AccessImpl inj2481_AccessImpl = new AccessImpl();
      context.addBean(context.getBeanReference(AccessImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2481_AccessImpl);
      return inj2481_AccessImpl;
    }
  };
  private final BeanProvider<CompassDropController> inj2484_CompassDropController_creational = new BeanProvider<CompassDropController>() {
    public CompassDropController getInstance(final CreationalContext context) {
      final CompassDropController inj2483_CompassDropController = new CompassDropController();
      context.addBean(context.getBeanReference(CompassDropController.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2483_CompassDropController);
      _$1705636724__690997221_compass(inj2483_CompassDropController, inj2397_CompassWidgetImpl);
      _$1705636724__$262319993_panelManager(inj2483_CompassDropController, inj2211_PanelManagerImpl);
      _$1705636724__153624969_dndManager(inj2483_CompassDropController, inj2200_WorkbenchDragAndDropManager);
      _$1705636724__1116818801_workbenchPartDroppedEvent(inj2483_CompassDropController, inj2187_EventProvider.provide(new Class[] { DropPlaceEvent.class }, null));
      return inj2483_CompassDropController;
    }
  };
  private InitializationCallback<ActivityNotFoundPresenter> init_inj2485_ActivityNotFoundPresenter = new InitializationCallback<ActivityNotFoundPresenter>() {
    public void init(final ActivityNotFoundPresenter obj) {
      obj.init();
    }
  };
  private final BeanProvider<ActivityNotFoundPresenter> inj2486_ActivityNotFoundPresenter_creational = new BeanProvider<ActivityNotFoundPresenter>() {
    public ActivityNotFoundPresenter getInstance(final CreationalContext context) {
      final PlaceManager var134 = inj2264_PlaceManagerImpl;
      final PopupView var135 = inj2465_PopupViewImpl_creational.getInstance(context);
      final ActivityNotFoundPresenter inj2485_ActivityNotFoundPresenter = new ActivityNotFoundPresenter(var134, var135);
      context.addBean(context.getBeanReference(ActivityNotFoundPresenter.class, arrayOf_19635043Annotation_343148925), inj2485_ActivityNotFoundPresenter);
      _$2051573400__$1566038911_view(inj2485_ActivityNotFoundPresenter, inj2297_ActivityNotFoundView_creational.getInstance(context));
      _$2051573400__$906533316_placeManager(inj2485_ActivityNotFoundPresenter, inj2264_PlaceManagerImpl);
      context.addInitializationCallback(inj2485_ActivityNotFoundPresenter, init_inj2485_ActivityNotFoundPresenter);
      return inj2485_ActivityNotFoundPresenter;
    }
  };
  private final ActivityNotFoundPresenter inj2485_ActivityNotFoundPresenter = inj2486_ActivityNotFoundPresenter_creational.getInstance(context);
  private final BeanProvider<MoodScreenActivity> inj2488_MoodScreenActivity_creational = new BeanProvider<MoodScreenActivity>() {
    public MoodScreenActivity getInstance(final CreationalContext context) {
      final PlaceManager var136 = inj2264_PlaceManagerImpl;
      final MoodScreenActivity inj2487_MoodScreenActivity = new MoodScreenActivity(var136);
      context.addBean(context.getBeanReference(MoodScreenActivity.class, arrayOf_19635043Annotation_335935540), inj2487_MoodScreenActivity);
      _$1786166680__1150956601_realPresenter(inj2487_MoodScreenActivity, inj2446_MoodScreen_creational.getInstance(context));
      return inj2487_MoodScreenActivity;
    }
  };
  private InitializationCallback<SimpleDnDWorkbenchPanelPresenter> init_inj2489_SimpleDnDWorkbenchPanelPresenter = new InitializationCallback<SimpleDnDWorkbenchPanelPresenter>() {
    public void init(final SimpleDnDWorkbenchPanelPresenter obj) {
      _253255348_init(obj);
    }
  };
  private final BeanProvider<SimpleDnDWorkbenchPanelPresenter> inj2490_SimpleDnDWorkbenchPanelPresenter_creational = new BeanProvider<SimpleDnDWorkbenchPanelPresenter>() {
    public SimpleDnDWorkbenchPanelPresenter getInstance(final CreationalContext context) {
      final SimpleDnDWorkbenchPanelView var137 = inj2422_SimpleDnDWorkbenchPanelView_creational.getInstance(context);
      final PerspectiveManager var138 = inj2255_PerspectiveManagerImpl;
      final SimpleDnDWorkbenchPanelPresenter inj2489_SimpleDnDWorkbenchPanelPresenter = new SimpleDnDWorkbenchPanelPresenter(var137, var138);
      context.addBean(context.getBeanReference(SimpleDnDWorkbenchPanelPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2489_SimpleDnDWorkbenchPanelPresenter);
      _1653100451__$262319993_panelManager(inj2489_SimpleDnDWorkbenchPanelPresenter, inj2211_PanelManagerImpl);
      context.addInitializationCallback(inj2489_SimpleDnDWorkbenchPanelPresenter, init_inj2489_SimpleDnDWorkbenchPanelPresenter);
      return inj2489_SimpleDnDWorkbenchPanelPresenter;
    }
  };
  private final BeanProvider<DataBinderProvider> inj2491_DataBinderProvider_creational = new BeanProvider<DataBinderProvider>() {
    public DataBinderProvider getInstance(final CreationalContext context) {
      final DataBinderProvider inj2153_DataBinderProvider = new DataBinderProvider();
      context.addBean(context.getBeanReference(DataBinderProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2153_DataBinderProvider);
      return inj2153_DataBinderProvider;
    }
  };
  private final DataBinderProvider inj2153_DataBinderProvider = inj2491_DataBinderProvider_creational.getInstance(context);
  private final BeanProvider<PartContextMenusView> inj2493_PartContextMenusView_creational = new BeanProvider<PartContextMenusView>() {
    public PartContextMenusView getInstance(final CreationalContext context) {
      final PartContextMenusView inj2492_PartContextMenusView = new PartContextMenusView();
      context.addBean(context.getBeanReference(PartContextMenusView.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2492_PartContextMenusView);
      _$14119216__$1574799830_authzManager(inj2492_PartContextMenusView, inj2206_RuntimeAuthorizationManager);
      _$14119216__597466346_identity(inj2492_PartContextMenusView, _663569186_produceActiveUser(inj2203_BasicUserCacheImpl));
      return inj2492_PartContextMenusView;
    }
  };
  private final BeanProvider<PartContextMenusPresenter> inj2495_PartContextMenusPresenter_creational = new BeanProvider<PartContextMenusPresenter>() {
    public PartContextMenusPresenter getInstance(final CreationalContext context) {
      final PartContextMenusPresenter inj2494_PartContextMenusPresenter = new PartContextMenusPresenter();
      context.addBean(context.getBeanReference(PartContextMenusPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2494_PartContextMenusPresenter);
      _$274999170__$906533316_placeManager(inj2494_PartContextMenusPresenter, inj2264_PlaceManagerImpl);
      _$274999170__154256171_view(inj2494_PartContextMenusPresenter, inj2493_PartContextMenusView_creational.getInstance(context));
      final Subscription var139 = CDI.subscribeLocal("org.uberfire.client.workbench.events.PlaceGainFocusEvent", new AbstractCDIEventCallback<PlaceGainFocusEvent>() {
        public void fireEvent(final PlaceGainFocusEvent event) {
          _$274999170_onWorkbenchPartOnFocus_PlaceGainFocusEvent(inj2494_PartContextMenusPresenter, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.PlaceGainFocusEvent []";
        }
      });
      context.addDestructionCallback(inj2494_PartContextMenusPresenter, new DestructionCallback<PartContextMenusPresenter>() {
        public void destroy(final PartContextMenusPresenter obj) {
          var139.remove();
          // WEEEEE!;
        }
      });
      return inj2494_PartContextMenusPresenter;
    }
  };
  private final PartContextMenusPresenter inj2494_PartContextMenusPresenter = inj2495_PartContextMenusPresenter_creational.getInstance(context);
  private final BeanProvider<MultiPageEditorImpl> inj2497_MultiPageEditorImpl_creational = new BeanProvider<MultiPageEditorImpl>() {
    public MultiPageEditorImpl getInstance(final CreationalContext context) {
      final MultiPageEditorImpl inj2496_MultiPageEditorImpl = new MultiPageEditorImpl();
      context.addBean(context.getBeanReference(MultiPageEditorImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2496_MultiPageEditorImpl);
      _$780895853__158751832_view(inj2496_MultiPageEditorImpl, inj2329_MultiPageEditorViewImpl_creational.getInstance(context));
      return inj2496_MultiPageEditorImpl;
    }
  };
  private InitializationCallback<TemplatedWorkbenchPanelPresenter> init_inj2498_TemplatedWorkbenchPanelPresenter = new InitializationCallback<TemplatedWorkbenchPanelPresenter>() {
    public void init(final TemplatedWorkbenchPanelPresenter obj) {
      _253255348_init(obj);
    }
  };
  private final BeanProvider<TemplatedWorkbenchPanelPresenter> inj2499_TemplatedWorkbenchPanelPresenter_creational = new BeanProvider<TemplatedWorkbenchPanelPresenter>() {
    public TemplatedWorkbenchPanelPresenter getInstance(final CreationalContext context) {
      final TemplatedWorkbenchPanelView var140 = inj2295_TemplatedWorkbenchPanelView_creational.getInstance(context);
      final PerspectiveManager var141 = inj2255_PerspectiveManagerImpl;
      final TemplatedWorkbenchPanelPresenter inj2498_TemplatedWorkbenchPanelPresenter = new TemplatedWorkbenchPanelPresenter(var140, var141);
      context.addBean(context.getBeanReference(TemplatedWorkbenchPanelPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2498_TemplatedWorkbenchPanelPresenter);
      context.addInitializationCallback(inj2498_TemplatedWorkbenchPanelPresenter, init_inj2498_TemplatedWorkbenchPanelPresenter);
      return inj2498_TemplatedWorkbenchPanelPresenter;
    }
  };
  private final BeanProvider<LifecycleListenerRegistrarImpl> inj2501_LifecycleListenerRegistrarImpl_creational = new BeanProvider<LifecycleListenerRegistrarImpl>() {
    public LifecycleListenerRegistrarImpl getInstance(final CreationalContext context) {
      final LifecycleListenerRegistrarImpl inj2500_LifecycleListenerRegistrarImpl = new LifecycleListenerRegistrarImpl();
      context.addBean(context.getBeanReference(LifecycleListenerRegistrarImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2500_LifecycleListenerRegistrarImpl);
      return inj2500_LifecycleListenerRegistrarImpl;
    }
  };
  private final LifecycleListenerRegistrarImpl inj2500_LifecycleListenerRegistrarImpl = inj2501_LifecycleListenerRegistrarImpl_creational.getInstance(context);
  private final BeanProvider<MoodListenerScreenActivity> inj2503_MoodListenerScreenActivity_creational = new BeanProvider<MoodListenerScreenActivity>() {
    public MoodListenerScreenActivity getInstance(final CreationalContext context) {
      final PlaceManager var142 = inj2264_PlaceManagerImpl;
      final MoodListenerScreenActivity inj2502_MoodListenerScreenActivity = new MoodListenerScreenActivity(var142);
      context.addBean(context.getBeanReference(MoodListenerScreenActivity.class, arrayOf_19635043Annotation_594926657), inj2502_MoodListenerScreenActivity);
      _918776636__1025798413_realPresenter(inj2502_MoodListenerScreenActivity, inj2317_MoodListenerScreen_creational.getInstance(context));
      return inj2502_MoodListenerScreenActivity;
    }
  };
  static class WorkbenchDragAndDropManager_inj2196_proxy extends WorkbenchDragAndDropManager {
    private WorkbenchDragAndDropManager $$_proxy_$$;
    private boolean $$_init_$$;
    @Override public void makeDraggable(IsWidget a0, IsWidget a1) {
      if ($$_init_$$) {
        $$_proxy_$$.makeDraggable(a0, a1);
      }
    }

    @Override public void registerDropController(WorkbenchPanelView a0, DropController a1) {
      if ($$_init_$$) {
        $$_proxy_$$.registerDropController(a0, a1);
      }
    }

    @Override public void unregisterDropController(WorkbenchPanelView a0) {
      if ($$_init_$$) {
        $$_proxy_$$.unregisterDropController(a0);
      }
    }

    @Override public void unregisterDropControllers() {
      if ($$_init_$$) {
        $$_proxy_$$.unregisterDropControllers();
      }
    }

    @Override public void setWorkbenchContext(WorkbenchDragContext a0) {
      if ($$_init_$$) {
        $$_proxy_$$.setWorkbenchContext(a0);
      }
    }

    @Override public WorkbenchDragContext getWorkbenchContext() {
      if ($$_init_$$) {
        return $$_proxy_$$.getWorkbenchContext();
      } else {
        return null;
      }
    }

    @Override public int hashCode() {
      if ($$_proxy_$$ == null) {
        throw new IllegalStateException("call to hashCode() on an unclosed proxy.");
      } else {
        return $$_proxy_$$.hashCode();
      }
    }

    @Override public boolean equals(Object o) {
      if ($$_proxy_$$ == null) {
        throw new IllegalStateException("call to equals() on an unclosed proxy.");
      } else {
        return $$_proxy_$$.equals(o);
      }
    }

    public void __$setProxiedInstance$(WorkbenchDragAndDropManager proxy) {
      $$_proxy_$$ = proxy;
      $$_init_$$ = true;
    }
  }
  static class NotificationManager_inj2247_proxy extends NotificationManager {
    private NotificationManager $$_proxy_$$;
    private boolean $$_init_$$;
    @Override public void addNotification(NotificationEvent a0) {
      if ($$_init_$$) {
        $$_proxy_$$.addNotification(a0);
      }
    }

    @Override public void onClosePlaceEvent(ClosePlaceEvent a0) {
      if ($$_init_$$) {
        $$_proxy_$$.onClosePlaceEvent(a0);
      }
    }

    @Override public void onPlaceLostFocus(PlaceLostFocusEvent a0) {
      if ($$_init_$$) {
        $$_proxy_$$.onPlaceLostFocus(a0);
      }
    }

    @Override public int hashCode() {
      if ($$_proxy_$$ == null) {
        throw new IllegalStateException("call to hashCode() on an unclosed proxy.");
      } else {
        return $$_proxy_$$.hashCode();
      }
    }

    @Override public boolean equals(Object o) {
      if ($$_proxy_$$ == null) {
        throw new IllegalStateException("call to equals() on an unclosed proxy.");
      } else {
        return $$_proxy_$$.equals(o);
      }
    }

    public void __$setProxiedInstance$(NotificationManager proxy) {
      $$_proxy_$$ = proxy;
      $$_init_$$ = true;
    }
  }
  static class PlaceManager_inj2250_proxy implements PlaceManager {
    private PlaceManager $$_proxy_$$;
    private boolean $$_init_$$;
    @Override public void goTo(String a0) {
      if ($$_init_$$) {
        $$_proxy_$$.goTo(a0);
      }
    }

    @Override public void goTo(PlaceRequest a0) {
      if ($$_init_$$) {
        $$_proxy_$$.goTo(a0);
      }
    }

    @Override public void goTo(Path a0) {
      if ($$_init_$$) {
        $$_proxy_$$.goTo(a0);
      }
    }

    @Override public void goTo(Path a0, PlaceRequest a1) {
      if ($$_init_$$) {
        $$_proxy_$$.goTo(a0, a1);
      }
    }

    @Override public void goTo(PartDefinition a0, PanelDefinition a1) {
      if ($$_init_$$) {
        $$_proxy_$$.goTo(a0, a1);
      }
    }

    @Override public void goTo(String a0, PanelDefinition a1) {
      if ($$_init_$$) {
        $$_proxy_$$.goTo(a0, a1);
      }
    }

    @Override public void goTo(PlaceRequest a0, PanelDefinition a1) {
      if ($$_init_$$) {
        $$_proxy_$$.goTo(a0, a1);
      }
    }

    @Override public void goTo(Path a0, PanelDefinition a1) {
      if ($$_init_$$) {
        $$_proxy_$$.goTo(a0, a1);
      }
    }

    @Override public void goTo(Path a0, PlaceRequest a1, PanelDefinition a2) {
      if ($$_init_$$) {
        $$_proxy_$$.goTo(a0, a1, a2);
      }
    }

    @Override public void goTo(PlaceRequest a0, HasWidgets a1) {
      if ($$_init_$$) {
        $$_proxy_$$.goTo(a0, a1);
      }
    }

    @Override public Activity getActivity(PlaceRequest a0) {
      if ($$_init_$$) {
        return $$_proxy_$$.getActivity(a0);
      } else {
        return null;
      }
    }

    @Override public PlaceStatus getStatus(String a0) {
      if ($$_init_$$) {
        return $$_proxy_$$.getStatus(a0);
      } else {
        return null;
      }
    }

    @Override public PlaceStatus getStatus(PlaceRequest a0) {
      if ($$_init_$$) {
        return $$_proxy_$$.getStatus(a0);
      } else {
        return null;
      }
    }

    @Override public void closePlace(String a0) {
      if ($$_init_$$) {
        $$_proxy_$$.closePlace(a0);
      }
    }

    @Override public void closePlace(PlaceRequest a0) {
      if ($$_init_$$) {
        $$_proxy_$$.closePlace(a0);
      }
    }

    @Override public void tryClosePlace(PlaceRequest a0, Command a1) {
      if ($$_init_$$) {
        $$_proxy_$$.tryClosePlace(a0, a1);
      }
    }

    @Override public void forceClosePlace(String a0) {
      if ($$_init_$$) {
        $$_proxy_$$.forceClosePlace(a0);
      }
    }

    @Override public void forceClosePlace(PlaceRequest a0) {
      if ($$_init_$$) {
        $$_proxy_$$.forceClosePlace(a0);
      }
    }

    @Override public void closeAllPlaces() {
      if ($$_init_$$) {
        $$_proxy_$$.closeAllPlaces();
      }
    }

    @Override public void registerOnOpenCallback(PlaceRequest a0, Command a1) {
      if ($$_init_$$) {
        $$_proxy_$$.registerOnOpenCallback(a0, a1);
      }
    }

    @Override public void unregisterOnOpenCallback(PlaceRequest a0) {
      if ($$_init_$$) {
        $$_proxy_$$.unregisterOnOpenCallback(a0);
      }
    }

    @Override public void executeOnOpenCallback(PlaceRequest a0) {
      if ($$_init_$$) {
        $$_proxy_$$.executeOnOpenCallback(a0);
      }
    }

    @Override public Collection getActiveSplashScreens() {
      if ($$_init_$$) {
        return $$_proxy_$$.getActiveSplashScreens();
      } else {
        return null;
      }
    }

    public void __$setProxiedInstance$(PlaceManager proxy) {
      $$_proxy_$$ = proxy;
      $$_init_$$ = true;
    }
  }
  public interface org_uberfire_client_views_pfly_notfound_ActivityNotFoundViewTemplateResource extends Template, ClientBundle { @Source("org/uberfire/client/views/pfly/notfound/ActivityNotFoundView.html") public TextResource getContents(); }
  public interface org_uberfire_client_screens_MoodListenerScreenTemplateResource extends Template, ClientBundle { @Source("org/uberfire/client/screens/MoodListenerScreen.html") public TextResource getContents(); }
  public interface org_uberfire_client_views_pfly_splash_SplashModalFooterTemplateResource extends Template, ClientBundle { @Source("org/uberfire/client/views/pfly/splash/SplashModalFooter.html") public TextResource getContents(); }
  public interface org_uberfire_client_perspectives_MoodPerspectiveTemplateResource extends Template, ClientBundle { @Source("org/uberfire/client/perspectives/MoodPerspective.html") public TextResource getContents(); }
  public interface org_uberfire_client_screens_MoodScreenTemplateResource extends Template, ClientBundle { @Source("org/uberfire/client/screens/MoodScreen.html") public TextResource getContents(); }
  private static void addLookups_0() {
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.PlaceMinimizedEvent", "org.uberfire.client.workbench.events.AbstractPlaceEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.PlaceMinimizedEvent", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.PlaceMinimizedEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.SelectPlaceEvent", "org.uberfire.client.workbench.events.AbstractPlaceEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.SelectPlaceEvent", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.SelectPlaceEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.mvp.SaveInProgressEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.backend.vfs.impl.LockInfo", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.shared.Mood", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.PerspectiveChange", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.PerspectiveChange", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.ChangeTitleWidgetEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceRenamedEvent", "org.uberfire.workbench.events.ResourceEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceRenamedEvent", "org.uberfire.workbench.events.ResourceRenamed");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceRenamedEvent", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceRenamedEvent", "org.uberfire.workbench.events.ResourceChange");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceRenamedEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceDeletedEvent", "org.uberfire.workbench.events.ResourceEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceDeletedEvent", "org.uberfire.workbench.events.ResourceDeleted");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceDeletedEvent", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceDeletedEvent", "org.uberfire.workbench.events.ResourceChange");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceDeletedEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.NewSplashScreenActiveEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.DropPlaceEvent", "org.uberfire.client.workbench.events.AbstractPlaceEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.DropPlaceEvent", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.DropPlaceEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.PlaceMaximizedEvent", "org.uberfire.client.workbench.events.AbstractPlaceEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.PlaceMaximizedEvent", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.PlaceMaximizedEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.PlaceLostFocusEvent", "org.uberfire.client.workbench.events.AbstractPlaceEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.PlaceLostFocusEvent", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.PlaceLostFocusEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.ApplicationReadyEvent", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.ApplicationReadyEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceCopiedEvent", "org.uberfire.workbench.events.ResourceEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceCopiedEvent", "org.uberfire.workbench.events.ResourceCopied");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceCopiedEvent", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceCopiedEvent", "org.uberfire.workbench.events.ResourceChange");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceCopiedEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceUpdatedEvent", "org.uberfire.workbench.events.ResourceEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceUpdatedEvent", "org.uberfire.workbench.events.ResourceUpdated");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceUpdatedEvent", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceUpdatedEvent", "org.uberfire.workbench.events.ResourceChange");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceUpdatedEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.PlaceGainFocusEvent", "org.uberfire.client.workbench.events.AbstractPlaceEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.PlaceGainFocusEvent", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.PlaceGainFocusEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.backend.vfs.impl.ForceUnlockEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceBatchChangesEvent", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceBatchChangesEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.NotificationEvent", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.NotificationEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceAddedEvent", "org.uberfire.workbench.events.ResourceEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceAddedEvent", "org.uberfire.workbench.events.ResourceAdded");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceAddedEvent", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceAddedEvent", "org.uberfire.workbench.events.ResourceChange");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceAddedEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.mvp.LockRequiredEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.ClosePlaceEvent", "org.uberfire.client.workbench.events.AbstractPlaceEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.ClosePlaceEvent", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.ClosePlaceEvent", "java.lang.Object");
  }

  private void declareBeans_0() {
    injContext.addBean(MainPerspective.class, MainPerspective.class, inj2193_MainPerspective_creational, inj2192_MainPerspective, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(WorkbenchPickupDragController.class, WorkbenchPickupDragController.class, inj2195_WorkbenchPickupDragController_creational, inj2194_WorkbenchPickupDragController, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(PickupDragController.class, WorkbenchPickupDragController.class, inj2195_WorkbenchPickupDragController_creational, inj2194_WorkbenchPickupDragController, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AbstractDragController.class, WorkbenchPickupDragController.class, inj2195_WorkbenchPickupDragController_creational, inj2194_WorkbenchPickupDragController, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DragController.class, WorkbenchPickupDragController.class, inj2195_WorkbenchPickupDragController_creational, inj2194_WorkbenchPickupDragController, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(FiresDragEvents.class, WorkbenchPickupDragController.class, inj2195_WorkbenchPickupDragController_creational, inj2194_WorkbenchPickupDragController, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IOCBeanManagerProvider.class, IOCBeanManagerProvider.class, inj2197_IOCBeanManagerProvider_creational, inj2155_IOCBeanManagerProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Provider.class, IOCBeanManagerProvider.class, inj2197_IOCBeanManagerProvider_creational, inj2155_IOCBeanManagerProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DefaultBeanFactory.class, DefaultBeanFactory.class, inj2199_DefaultBeanFactory_creational, inj2198_DefaultBeanFactory, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(BeanFactory.class, DefaultBeanFactory.class, inj2199_DefaultBeanFactory_creational, inj2198_DefaultBeanFactory, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchDragAndDropManager.class, WorkbenchDragAndDropManager.class, inj2201_WorkbenchDragAndDropManager_creational, inj2200_WorkbenchDragAndDropManager, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(CookieStorageHandlerProvider.class, CookieStorageHandlerProvider.class, inj2202_CookieStorageHandlerProvider_creational, inj2165_CookieStorageHandlerProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Provider.class, CookieStorageHandlerProvider.class, inj2202_CookieStorageHandlerProvider_creational, inj2165_CookieStorageHandlerProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(BasicUserCacheImpl.class, BasicUserCacheImpl.class, inj2204_BasicUserCacheImpl_creational, inj2203_BasicUserCacheImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ActiveUserCache.class, BasicUserCacheImpl.class, inj2204_BasicUserCacheImpl_creational, inj2203_BasicUserCacheImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(User.class, User.class, inj2146_User_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Serializable.class, User.class, inj2146_User_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(InstanceProvider.class, InstanceProvider.class, inj2205_InstanceProvider_creational, inj2189_InstanceProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ContextualTypeProvider.class, InstanceProvider.class, inj2205_InstanceProvider_creational, inj2189_InstanceProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(RuntimeAuthorizationManager.class, RuntimeAuthorizationManager.class, inj2207_RuntimeAuthorizationManager_creational, inj2206_RuntimeAuthorizationManager, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(AuthorizationManager.class, RuntimeAuthorizationManager.class, inj2207_RuntimeAuthorizationManager_creational, inj2206_RuntimeAuthorizationManager, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventProvider.class, EventProvider.class, inj2208_EventProvider_creational, inj2187_EventProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ContextualTypeProvider.class, EventProvider.class, inj2208_EventProvider_creational, inj2187_EventProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LayoutSelection.class, LayoutSelection.class, inj2210_LayoutSelection_creational, inj2209_LayoutSelection, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(PanelManagerImpl.class, PanelManagerImpl.class, inj2212_PanelManagerImpl_creational, inj2211_PanelManagerImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(PanelManager.class, PanelManagerImpl.class, inj2212_PanelManagerImpl_creational, inj2211_PanelManagerImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ListBarWidgetImpl.class, ListBarWidgetImpl.class, inj2214_ListBarWidgetImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ListBarWidget.class, ListBarWidgetImpl.class, inj2214_ListBarWidgetImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(MultiPartWidget.class, ListBarWidgetImpl.class, inj2214_ListBarWidgetImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, ListBarWidgetImpl.class, inj2214_ListBarWidgetImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(RequiresResize.class, ListBarWidgetImpl.class, inj2214_ListBarWidgetImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasBeforeSelectionHandlers.class, ListBarWidgetImpl.class, inj2214_ListBarWidgetImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, ListBarWidgetImpl.class, inj2214_ListBarWidgetImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasSelectionHandlers.class, ListBarWidgetImpl.class, inj2214_ListBarWidgetImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ResizeComposite.class, ListBarWidgetImpl.class, inj2214_ListBarWidgetImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Composite.class, ListBarWidgetImpl.class, inj2214_ListBarWidgetImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, ListBarWidgetImpl.class, inj2214_ListBarWidgetImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, ListBarWidgetImpl.class, inj2214_ListBarWidgetImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, ListBarWidgetImpl.class, inj2214_ListBarWidgetImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, ListBarWidgetImpl.class, inj2214_ListBarWidgetImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, ListBarWidgetImpl.class, inj2214_ListBarWidgetImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, ListBarWidgetImpl.class, inj2214_ListBarWidgetImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SimpleLayoutPanel.class, SimpleLayoutPanel.class, inj2217_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(RequiresResize.class, SimpleLayoutPanel.class, inj2217_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ProvidesResize.class, SimpleLayoutPanel.class, inj2217_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SimplePanel.class, SimpleLayoutPanel.class, inj2217_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasOneWidget.class, SimpleLayoutPanel.class, inj2217_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AcceptsOneWidget.class, SimpleLayoutPanel.class, inj2217_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Panel.class, SimpleLayoutPanel.class, inj2217_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ForIsWidget.class, SimpleLayoutPanel.class, inj2217_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasWidgets.class, SimpleLayoutPanel.class, inj2217_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Iterable.class, SimpleLayoutPanel.class, inj2217_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, SimpleLayoutPanel.class, inj2217_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, SimpleLayoutPanel.class, inj2217_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, SimpleLayoutPanel.class, inj2217_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, SimpleLayoutPanel.class, inj2217_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, SimpleLayoutPanel.class, inj2217_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, SimpleLayoutPanel.class, inj2217_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, SimpleLayoutPanel.class, inj2217_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ResizeFlowPanel.class, ResizeFlowPanel.class, inj2218_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(RequiresResize.class, ResizeFlowPanel.class, inj2218_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ProvidesResize.class, ResizeFlowPanel.class, inj2218_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(FlowPanel.class, ResizeFlowPanel.class, inj2218_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(com.google.gwt.user.client.ui.InsertPanel.ForIsWidget.class, ResizeFlowPanel.class, inj2218_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(InsertPanel.class, ResizeFlowPanel.class, inj2218_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IndexedPanel.class, ResizeFlowPanel.class, inj2218_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(com.google.gwt.user.client.ui.IndexedPanel.ForIsWidget.class, ResizeFlowPanel.class, inj2218_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ComplexPanel.class, ResizeFlowPanel.class, inj2218_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Panel.class, ResizeFlowPanel.class, inj2218_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ForIsWidget.class, ResizeFlowPanel.class, inj2218_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasWidgets.class, ResizeFlowPanel.class, inj2218_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Iterable.class, ResizeFlowPanel.class, inj2218_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, ResizeFlowPanel.class, inj2218_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, ResizeFlowPanel.class, inj2218_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, ResizeFlowPanel.class, inj2218_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, ResizeFlowPanel.class, inj2218_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, ResizeFlowPanel.class, inj2218_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, ResizeFlowPanel.class, inj2218_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, ResizeFlowPanel.class, inj2218_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ClosableSimpleWorkbenchPanelView.class, ClosableSimpleWorkbenchPanelView.class, inj2216_ClosableSimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1738119949, "ClosableSimpleWorkbenchPanelView", true);
    injContext.addBean(AbstractSimpleWorkbenchPanelView.class, ClosableSimpleWorkbenchPanelView.class, inj2216_ClosableSimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1738119949, "ClosableSimpleWorkbenchPanelView", false);
    injContext.addBean(AbstractDockingWorkbenchPanelView.class, ClosableSimpleWorkbenchPanelView.class, inj2216_ClosableSimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1738119949, null, false);
    injContext.addBean(DockingWorkbenchPanelView.class, ClosableSimpleWorkbenchPanelView.class, inj2216_ClosableSimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1738119949, null, false);
    injContext.addBean(WorkbenchPanelView.class, ClosableSimpleWorkbenchPanelView.class, inj2216_ClosableSimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1738119949, null, false);
    injContext.addBean(UberView.class, ClosableSimpleWorkbenchPanelView.class, inj2216_ClosableSimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1738119949, null, false);
    injContext.addBean(IsWidget.class, ClosableSimpleWorkbenchPanelView.class, inj2216_ClosableSimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1738119949, null, false);
    injContext.addBean(RequiresResize.class, ClosableSimpleWorkbenchPanelView.class, inj2216_ClosableSimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1738119949, null, false);
    injContext.addBean(AbstractWorkbenchPanelView.class, ClosableSimpleWorkbenchPanelView.class, inj2216_ClosableSimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1738119949, null, false);
    injContext.addBean(ResizeComposite.class, ClosableSimpleWorkbenchPanelView.class, inj2216_ClosableSimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1738119949, null, false);
    injContext.addBean(Composite.class, ClosableSimpleWorkbenchPanelView.class, inj2216_ClosableSimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1738119949, null, false);
    injContext.addBean(IsRenderable.class, ClosableSimpleWorkbenchPanelView.class, inj2216_ClosableSimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1738119949, null, false);
    injContext.addBean(Widget.class, ClosableSimpleWorkbenchPanelView.class, inj2216_ClosableSimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1738119949, null, false);
    injContext.addBean(EventListener.class, ClosableSimpleWorkbenchPanelView.class, inj2216_ClosableSimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1738119949, null, false);
    injContext.addBean(HasAttachHandlers.class, ClosableSimpleWorkbenchPanelView.class, inj2216_ClosableSimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1738119949, null, false);
    injContext.addBean(HasHandlers.class, ClosableSimpleWorkbenchPanelView.class, inj2216_ClosableSimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1738119949, null, false);
    injContext.addBean(UIObject.class, ClosableSimpleWorkbenchPanelView.class, inj2216_ClosableSimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1738119949, null, false);
    injContext.addBean(HasVisibility.class, ClosableSimpleWorkbenchPanelView.class, inj2216_ClosableSimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1738119949, null, false);
    injContext.addBean(DestructionImpl.class, DestructionImpl.class, inj2220_DestructionImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Destruction.class, DestructionImpl.class, inj2220_DestructionImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LifecycleEvent.class, DestructionImpl.class, inj2220_DestructionImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LifecycleEventImpl.class, DestructionImpl.class, inj2220_DestructionImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LifecycleEvent.class, DestructionImpl.class, inj2220_DestructionImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EditorJSExporter.class, EditorJSExporter.class, inj2222_EditorJSExporter_creational, inj2221_EditorJSExporter, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(UberfireJSExporter.class, EditorJSExporter.class, inj2222_EditorJSExporter_creational, inj2221_EditorJSExporter, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(URLPatternMatcherProvider.class, URLPatternMatcherProvider.class, inj2223_URLPatternMatcherProvider_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(NavigationGraph.class, NavigationGraph.class, inj2150_NavigationGraph_creational, SimpleInjectionContext.LAZY_INIT_REF, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(URLPatternMatcher.class, URLPatternMatcher.class, inj2147_URLPatternMatcher_creational, SimpleInjectionContext.LAZY_INIT_REF, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(HistoryTokenFactory.class, HistoryTokenFactory.class, inj2225_HistoryTokenFactory_creational, inj2224_HistoryTokenFactory, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(StateChangeImpl.class, StateChangeImpl.class, inj2227_StateChangeImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(StateChange.class, StateChangeImpl.class, inj2227_StateChangeImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LifecycleEvent.class, StateChangeImpl.class, inj2227_StateChangeImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LifecycleEventImpl.class, StateChangeImpl.class, inj2227_StateChangeImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LifecycleEvent.class, StateChangeImpl.class, inj2227_StateChangeImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Navigation.class, Navigation.class, inj2229_Navigation_creational, inj2228_Navigation, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(NavigationPanelProvider.class, NavigationPanelProvider.class, inj2230_NavigationPanelProvider_creational, inj2159_NavigationPanelProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Provider.class, NavigationPanelProvider.class, inj2230_NavigationPanelProvider_creational, inj2159_NavigationPanelProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchViewModeSwitcherMenuBuilder.class, WorkbenchViewModeSwitcherMenuBuilder.class, inj2232_WorkbenchViewModeSwitcherMenuBuilder_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(CustomMenuBuilder.class, WorkbenchViewModeSwitcherMenuBuilder.class, inj2232_WorkbenchViewModeSwitcherMenuBuilder_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(CallerProvider.class, CallerProvider.class, inj2233_CallerProvider_creational, inj2161_CallerProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ContextualTypeProvider.class, CallerProvider.class, inj2233_CallerProvider_creational, inj2161_CallerProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SecurityContextImpl.class, SecurityContextImpl.class, inj2235_SecurityContextImpl_creational, inj2234_SecurityContextImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(SecurityContext.class, SecurityContextImpl.class, inj2235_SecurityContextImpl_creational, inj2234_SecurityContextImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ClientRequiredRolesExtractorImpl.class, ClientRequiredRolesExtractorImpl.class, inj2237_ClientRequiredRolesExtractorImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(SharedRequiredRolesExtractorImpl.class, ClientRequiredRolesExtractorImpl.class, inj2237_ClientRequiredRolesExtractorImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(RequiredRolesExtractor.class, ClientRequiredRolesExtractorImpl.class, inj2237_ClientRequiredRolesExtractorImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ClientSecurityRoleInterceptor.class, ClientSecurityRoleInterceptor.class, inj2239_ClientSecurityRoleInterceptor_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(RemoteCallInterceptor.class, ClientSecurityRoleInterceptor.class, inj2239_ClientSecurityRoleInterceptor_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HeaderPanel.class, HeaderPanel.class, inj2242_HeaderPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(RequiresResize.class, HeaderPanel.class, inj2242_HeaderPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Panel.class, HeaderPanel.class, inj2242_HeaderPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ForIsWidget.class, HeaderPanel.class, inj2242_HeaderPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasWidgets.class, HeaderPanel.class, inj2242_HeaderPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Iterable.class, HeaderPanel.class, inj2242_HeaderPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, HeaderPanel.class, inj2242_HeaderPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, HeaderPanel.class, inj2242_HeaderPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, HeaderPanel.class, inj2242_HeaderPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, HeaderPanel.class, inj2242_HeaderPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, HeaderPanel.class, inj2242_HeaderPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, HeaderPanel.class, inj2242_HeaderPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, HeaderPanel.class, inj2242_HeaderPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchLayoutImpl.class, WorkbenchLayoutImpl.class, inj2241_WorkbenchLayoutImpl_creational, inj2240_WorkbenchLayoutImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(WorkbenchLayout.class, WorkbenchLayoutImpl.class, inj2241_WorkbenchLayoutImpl_creational, inj2240_WorkbenchLayoutImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchLayoutInfoImpl.class, WorkbenchLayoutInfoImpl.class, inj2244_WorkbenchLayoutInfoImpl_creational, inj2243_WorkbenchLayoutInfoImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(WorkbenchLayoutInfo.class, WorkbenchLayoutInfoImpl.class, inj2244_WorkbenchLayoutInfoImpl_creational, inj2243_WorkbenchLayoutInfoImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ActivityLifecycleErrorHandler.class, ActivityLifecycleErrorHandler.class, inj2246_ActivityLifecycleErrorHandler_creational, inj2245_ActivityLifecycleErrorHandler, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(NotificationManager.class, NotificationManager.class, inj2249_NotificationManager_creational, inj2248_NotificationManager, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(WorkbenchServicesProxyBackendImpl.class, WorkbenchServicesProxyBackendImpl.class, inj2252_WorkbenchServicesProxyBackendImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(WorkbenchServicesProxy.class, WorkbenchServicesProxyBackendImpl.class, inj2252_WorkbenchServicesProxyBackendImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchServicesProxyClientImpl.class, WorkbenchServicesProxyClientImpl.class, inj2254_WorkbenchServicesProxyClientImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(WorkbenchServicesProxy.class, WorkbenchServicesProxyClientImpl.class, inj2254_WorkbenchServicesProxyClientImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(PerspectiveManagerImpl.class, PerspectiveManagerImpl.class, inj2256_PerspectiveManagerImpl_creational, inj2255_PerspectiveManagerImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(PerspectiveManager.class, PerspectiveManagerImpl.class, inj2256_PerspectiveManagerImpl_creational, inj2255_PerspectiveManagerImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ActivityBeansCache.class, ActivityBeansCache.class, inj2258_ActivityBeansCache_creational, inj2257_ActivityBeansCache, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ActivityManagerImpl.class, ActivityManagerImpl.class, inj2260_ActivityManagerImpl_creational, inj2259_ActivityManagerImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ActivityManager.class, ActivityManagerImpl.class, inj2260_ActivityManagerImpl_creational, inj2259_ActivityManagerImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(PlaceRequestHistoryMapperImpl.class, PlaceRequestHistoryMapperImpl.class, inj2263_PlaceRequestHistoryMapperImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(PlaceRequestHistoryMapper.class, PlaceRequestHistoryMapperImpl.class, inj2263_PlaceRequestHistoryMapperImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(PlaceHistoryHandler.class, PlaceHistoryHandler.class, inj2262_PlaceHistoryHandler_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(PlaceManagerImpl.class, PlaceManagerImpl.class, inj2265_PlaceManagerImpl_creational, inj2264_PlaceManagerImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(PlaceManager.class, PlaceManagerImpl.class, inj2265_PlaceManagerImpl_creational, inj2264_PlaceManagerImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchToolBarView.class, WorkbenchToolBarView.class, inj2268_WorkbenchToolBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarPresenter.View.class, WorkbenchToolBarView.class, inj2268_WorkbenchToolBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, WorkbenchToolBarView.class, inj2268_WorkbenchToolBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Composite.class, WorkbenchToolBarView.class, inj2268_WorkbenchToolBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, WorkbenchToolBarView.class, inj2268_WorkbenchToolBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, WorkbenchToolBarView.class, inj2268_WorkbenchToolBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, WorkbenchToolBarView.class, inj2268_WorkbenchToolBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, WorkbenchToolBarView.class, inj2268_WorkbenchToolBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, WorkbenchToolBarView.class, inj2268_WorkbenchToolBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, WorkbenchToolBarView.class, inj2268_WorkbenchToolBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, WorkbenchToolBarView.class, inj2268_WorkbenchToolBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchToolBarPresenter.class, WorkbenchToolBarPresenter.class, inj2267_WorkbenchToolBarPresenter_creational, inj2266_WorkbenchToolBarPresenter, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(DisposerProvider.class, DisposerProvider.class, inj2269_DisposerProvider_creational, inj2163_DisposerProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ContextualTypeProvider.class, DisposerProvider.class, inj2269_DisposerProvider_creational, inj2163_DisposerProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ErrorPopupView.class, ErrorPopupView.class, inj2271_ErrorPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(org.uberfire.client.workbench.widgets.common.ErrorPopupPresenter.View.class, ErrorPopupView.class, inj2271_ErrorPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Composite.class, ErrorPopupView.class, inj2271_ErrorPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, ErrorPopupView.class, inj2271_ErrorPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, ErrorPopupView.class, inj2271_ErrorPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, ErrorPopupView.class, inj2271_ErrorPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, ErrorPopupView.class, inj2271_ErrorPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, ErrorPopupView.class, inj2271_ErrorPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, ErrorPopupView.class, inj2271_ErrorPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, ErrorPopupView.class, inj2271_ErrorPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, ErrorPopupView.class, inj2271_ErrorPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DotResourceTypeDefinition.class, DotResourceTypeDefinition.class, inj2273_DotResourceTypeDefinition_creational, inj2272_DotResourceTypeDefinition, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ResourceTypeDefinition.class, DotResourceTypeDefinition.class, inj2273_DotResourceTypeDefinition_creational, inj2272_DotResourceTypeDefinition, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AuthenticationServiceInterceptor.class, AuthenticationServiceInterceptor.class, inj2275_AuthenticationServiceInterceptor_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(RemoteCallInterceptor.class, AuthenticationServiceInterceptor.class, inj2275_AuthenticationServiceInterceptor_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ComponentView.class, ComponentView.class, inj2277_ComponentView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(org.uberfire.component.client.ComponentPresenter.View.class, ComponentView.class, inj2277_ComponentView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, ComponentView.class, inj2277_ComponentView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Composite.class, ComponentView.class, inj2277_ComponentView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, ComponentView.class, inj2277_ComponentView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, ComponentView.class, inj2277_ComponentView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, ComponentView.class, inj2277_ComponentView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, ComponentView.class, inj2277_ComponentView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, ComponentView.class, inj2277_ComponentView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, ComponentView.class, inj2277_ComponentView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, ComponentView.class, inj2277_ComponentView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ComponentPresenter.class, ComponentPresenter.class, inj2279_ComponentPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(WorkbenchMenuStandardNavBarView.class, WorkbenchMenuStandardNavBarView.class, inj2281_WorkbenchMenuStandardNavBarView_creational, inj2280_WorkbenchMenuStandardNavBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(WorkbenchMenuNavBarView.class, WorkbenchMenuStandardNavBarView.class, inj2281_WorkbenchMenuStandardNavBarView_creational, inj2280_WorkbenchMenuStandardNavBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(org.uberfire.client.views.pfly.menu.WorkbenchMenuBarView.WorkbenchMenuNavBarView.class, WorkbenchMenuStandardNavBarView.class, inj2281_WorkbenchMenuStandardNavBarView_creational, inj2280_WorkbenchMenuStandardNavBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Composite.class, WorkbenchMenuStandardNavBarView.class, inj2281_WorkbenchMenuStandardNavBarView_creational, inj2280_WorkbenchMenuStandardNavBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, WorkbenchMenuStandardNavBarView.class, inj2281_WorkbenchMenuStandardNavBarView_creational, inj2280_WorkbenchMenuStandardNavBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, WorkbenchMenuStandardNavBarView.class, inj2281_WorkbenchMenuStandardNavBarView_creational, inj2280_WorkbenchMenuStandardNavBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, WorkbenchMenuStandardNavBarView.class, inj2281_WorkbenchMenuStandardNavBarView_creational, inj2280_WorkbenchMenuStandardNavBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, WorkbenchMenuStandardNavBarView.class, inj2281_WorkbenchMenuStandardNavBarView_creational, inj2280_WorkbenchMenuStandardNavBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, WorkbenchMenuStandardNavBarView.class, inj2281_WorkbenchMenuStandardNavBarView_creational, inj2280_WorkbenchMenuStandardNavBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, WorkbenchMenuStandardNavBarView.class, inj2281_WorkbenchMenuStandardNavBarView_creational, inj2280_WorkbenchMenuStandardNavBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, WorkbenchMenuStandardNavBarView.class, inj2281_WorkbenchMenuStandardNavBarView_creational, inj2280_WorkbenchMenuStandardNavBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, WorkbenchMenuStandardNavBarView.class, inj2281_WorkbenchMenuStandardNavBarView_creational, inj2280_WorkbenchMenuStandardNavBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchMenuCompactNavBarView.class, WorkbenchMenuCompactNavBarView.class, inj2283_WorkbenchMenuCompactNavBarView_creational, inj2282_WorkbenchMenuCompactNavBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(WorkbenchMenuNavBarView.class, WorkbenchMenuCompactNavBarView.class, inj2283_WorkbenchMenuCompactNavBarView_creational, inj2282_WorkbenchMenuCompactNavBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(org.uberfire.client.views.pfly.menu.WorkbenchMenuBarView.WorkbenchMenuNavBarView.class, WorkbenchMenuCompactNavBarView.class, inj2283_WorkbenchMenuCompactNavBarView_creational, inj2282_WorkbenchMenuCompactNavBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Composite.class, WorkbenchMenuCompactNavBarView.class, inj2283_WorkbenchMenuCompactNavBarView_creational, inj2282_WorkbenchMenuCompactNavBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, WorkbenchMenuCompactNavBarView.class, inj2283_WorkbenchMenuCompactNavBarView_creational, inj2282_WorkbenchMenuCompactNavBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, WorkbenchMenuCompactNavBarView.class, inj2283_WorkbenchMenuCompactNavBarView_creational, inj2282_WorkbenchMenuCompactNavBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, WorkbenchMenuCompactNavBarView.class, inj2283_WorkbenchMenuCompactNavBarView_creational, inj2282_WorkbenchMenuCompactNavBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, WorkbenchMenuCompactNavBarView.class, inj2283_WorkbenchMenuCompactNavBarView_creational, inj2282_WorkbenchMenuCompactNavBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, WorkbenchMenuCompactNavBarView.class, inj2283_WorkbenchMenuCompactNavBarView_creational, inj2282_WorkbenchMenuCompactNavBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, WorkbenchMenuCompactNavBarView.class, inj2283_WorkbenchMenuCompactNavBarView_creational, inj2282_WorkbenchMenuCompactNavBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, WorkbenchMenuCompactNavBarView.class, inj2283_WorkbenchMenuCompactNavBarView_creational, inj2282_WorkbenchMenuCompactNavBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, WorkbenchMenuCompactNavBarView.class, inj2283_WorkbenchMenuCompactNavBarView_creational, inj2282_WorkbenchMenuCompactNavBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UtilityMenuBarView.class, UtilityMenuBarView.class, inj2285_UtilityMenuBarView_creational, inj2284_UtilityMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(org.uberfire.client.workbench.widgets.menu.UtilityMenuBarPresenter.View.class, UtilityMenuBarView.class, inj2285_UtilityMenuBarView_creational, inj2284_UtilityMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, UtilityMenuBarView.class, inj2285_UtilityMenuBarView_creational, inj2284_UtilityMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMenus.class, UtilityMenuBarView.class, inj2285_UtilityMenuBarView_creational, inj2284_UtilityMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMenuItems.class, UtilityMenuBarView.class, inj2285_UtilityMenuBarView_creational, inj2284_UtilityMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UnorderedList.class, UtilityMenuBarView.class, inj2285_UtilityMenuBarView_creational, inj2284_UtilityMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ComplexWidget.class, UtilityMenuBarView.class, inj2285_UtilityMenuBarView_creational, inj2284_UtilityMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasId.class, UtilityMenuBarView.class, inj2285_UtilityMenuBarView_creational, inj2284_UtilityMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasResponsiveness.class, UtilityMenuBarView.class, inj2285_UtilityMenuBarView_creational, inj2284_UtilityMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasInlineStyle.class, UtilityMenuBarView.class, inj2285_UtilityMenuBarView_creational, inj2284_UtilityMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasPull.class, UtilityMenuBarView.class, inj2285_UtilityMenuBarView_creational, inj2284_UtilityMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ComplexPanel.class, UtilityMenuBarView.class, inj2285_UtilityMenuBarView_creational, inj2284_UtilityMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(com.google.gwt.user.client.ui.IndexedPanel.ForIsWidget.class, UtilityMenuBarView.class, inj2285_UtilityMenuBarView_creational, inj2284_UtilityMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IndexedPanel.class, UtilityMenuBarView.class, inj2285_UtilityMenuBarView_creational, inj2284_UtilityMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Panel.class, UtilityMenuBarView.class, inj2285_UtilityMenuBarView_creational, inj2284_UtilityMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ForIsWidget.class, UtilityMenuBarView.class, inj2285_UtilityMenuBarView_creational, inj2284_UtilityMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasWidgets.class, UtilityMenuBarView.class, inj2285_UtilityMenuBarView_creational, inj2284_UtilityMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Iterable.class, UtilityMenuBarView.class, inj2285_UtilityMenuBarView_creational, inj2284_UtilityMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, UtilityMenuBarView.class, inj2285_UtilityMenuBarView_creational, inj2284_UtilityMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, UtilityMenuBarView.class, inj2285_UtilityMenuBarView_creational, inj2284_UtilityMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, UtilityMenuBarView.class, inj2285_UtilityMenuBarView_creational, inj2284_UtilityMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, UtilityMenuBarView.class, inj2285_UtilityMenuBarView_creational, inj2284_UtilityMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, UtilityMenuBarView.class, inj2285_UtilityMenuBarView_creational, inj2284_UtilityMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, UtilityMenuBarView.class, inj2285_UtilityMenuBarView_creational, inj2284_UtilityMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchMenuBarView.class, WorkbenchMenuBarView.class, inj2287_WorkbenchMenuBarView_creational, inj2286_WorkbenchMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarPresenter.View.class, WorkbenchMenuBarView.class, inj2287_WorkbenchMenuBarView_creational, inj2286_WorkbenchMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, WorkbenchMenuBarView.class, inj2287_WorkbenchMenuBarView_creational, inj2286_WorkbenchMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Composite.class, WorkbenchMenuBarView.class, inj2287_WorkbenchMenuBarView_creational, inj2286_WorkbenchMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, WorkbenchMenuBarView.class, inj2287_WorkbenchMenuBarView_creational, inj2286_WorkbenchMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, WorkbenchMenuBarView.class, inj2287_WorkbenchMenuBarView_creational, inj2286_WorkbenchMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, WorkbenchMenuBarView.class, inj2287_WorkbenchMenuBarView_creational, inj2286_WorkbenchMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, WorkbenchMenuBarView.class, inj2287_WorkbenchMenuBarView_creational, inj2286_WorkbenchMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, WorkbenchMenuBarView.class, inj2287_WorkbenchMenuBarView_creational, inj2286_WorkbenchMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, WorkbenchMenuBarView.class, inj2287_WorkbenchMenuBarView_creational, inj2286_WorkbenchMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, WorkbenchMenuBarView.class, inj2287_WorkbenchMenuBarView_creational, inj2286_WorkbenchMenuBarView, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchMenuBarPresenter.class, WorkbenchMenuBarPresenter.class, inj2289_WorkbenchMenuBarPresenter_creational, inj2288_WorkbenchMenuBarPresenter, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(WorkbenchMenuBar.class, WorkbenchMenuBarPresenter.class, inj2289_WorkbenchMenuBarPresenter_creational, inj2288_WorkbenchMenuBarPresenter, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMenus.class, WorkbenchMenuBarPresenter.class, inj2289_WorkbenchMenuBarPresenter_creational, inj2288_WorkbenchMenuBarPresenter, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AppNavBar.class, AppNavBar.class, inj2291_AppNavBar_creational, inj2290_AppNavBar, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Header.class, AppNavBar.class, inj2291_AppNavBar_creational, inj2290_AppNavBar, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(OrderableIsWidget.class, AppNavBar.class, inj2291_AppNavBar_creational, inj2290_AppNavBar, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, AppNavBar.class, inj2291_AppNavBar_creational, inj2290_AppNavBar, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Composite.class, AppNavBar.class, inj2291_AppNavBar_creational, inj2290_AppNavBar, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, AppNavBar.class, inj2291_AppNavBar_creational, inj2290_AppNavBar, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, AppNavBar.class, inj2291_AppNavBar_creational, inj2290_AppNavBar, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, AppNavBar.class, inj2291_AppNavBar_creational, inj2290_AppNavBar, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, AppNavBar.class, inj2291_AppNavBar_creational, inj2290_AppNavBar, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, AppNavBar.class, inj2291_AppNavBar_creational, inj2290_AppNavBar, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, AppNavBar.class, inj2291_AppNavBar_creational, inj2290_AppNavBar, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, AppNavBar.class, inj2291_AppNavBar_creational, inj2290_AppNavBar, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ServerTemplateProvider.class, ServerTemplateProvider.class, inj2293_ServerTemplateProvider_creational, inj2292_ServerTemplateProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(TemplateProvider.class, ServerTemplateProvider.class, inj2293_ServerTemplateProvider_creational, inj2292_ServerTemplateProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(TemplatedWorkbenchPanelView.class, TemplatedWorkbenchPanelView.class, inj2295_TemplatedWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_966516661, "TemplatedWorkbenchPanelView", true);
    injContext.addBean(WorkbenchPanelView.class, TemplatedWorkbenchPanelView.class, inj2295_TemplatedWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_966516661, "TemplatedWorkbenchPanelView", false);
    injContext.addBean(UberView.class, TemplatedWorkbenchPanelView.class, inj2295_TemplatedWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_966516661, null, false);
    injContext.addBean(IsWidget.class, TemplatedWorkbenchPanelView.class, inj2295_TemplatedWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_966516661, null, false);
    injContext.addBean(RequiresResize.class, TemplatedWorkbenchPanelView.class, inj2295_TemplatedWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_966516661, null, false);
    injContext.addBean(Span.class, Span.class, inj2298_Span_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(HTMLPanel.class, Span.class, inj2298_Span_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasId.class, Span.class, inj2298_Span_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDataSpy.class, Span.class, inj2298_Span_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDataTarget.class, Span.class, inj2298_Span_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasResponsiveness.class, Span.class, inj2298_Span_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasInlineStyle.class, Span.class, inj2298_Span_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasContextualBackground.class, Span.class, inj2298_Span_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(com.google.gwt.user.client.ui.HTMLPanel.class, Span.class, inj2298_Span_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ComplexPanel.class, Span.class, inj2298_Span_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(com.google.gwt.user.client.ui.IndexedPanel.ForIsWidget.class, Span.class, inj2298_Span_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IndexedPanel.class, Span.class, inj2298_Span_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Panel.class, Span.class, inj2298_Span_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ForIsWidget.class, Span.class, inj2298_Span_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasWidgets.class, Span.class, inj2298_Span_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Iterable.class, Span.class, inj2298_Span_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, Span.class, inj2298_Span_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, Span.class, inj2298_Span_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, Span.class, inj2298_Span_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, Span.class, inj2298_Span_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, Span.class, inj2298_Span_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, Span.class, inj2298_Span_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, Span.class, inj2298_Span_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ActivityNotFoundView.class, ActivityNotFoundView.class, inj2297_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(org.uberfire.client.workbench.widgets.notfound.ActivityNotFoundPresenter.View.class, ActivityNotFoundView.class, inj2297_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UberView.class, ActivityNotFoundView.class, inj2297_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, ActivityNotFoundView.class, inj2297_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Composite.class, ActivityNotFoundView.class, inj2297_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, ActivityNotFoundView.class, inj2297_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, ActivityNotFoundView.class, inj2297_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, ActivityNotFoundView.class, inj2297_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, ActivityNotFoundView.class, inj2297_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, ActivityNotFoundView.class, inj2297_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, ActivityNotFoundView.class, inj2297_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, ActivityNotFoundView.class, inj2297_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(PlaceManagerJSExporter.class, PlaceManagerJSExporter.class, inj2300_PlaceManagerJSExporter_creational, inj2299_PlaceManagerJSExporter, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(UberfireJSExporter.class, PlaceManagerJSExporter.class, inj2300_PlaceManagerJSExporter_creational, inj2299_PlaceManagerJSExporter, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(MainPerspectiveActivity.class, MainPerspectiveActivity.class, inj2302_MainPerspectiveActivity_creational, null, arrayOf_19635043Annotation_1601691956, "MainPerspective", true);
    injContext.addBean(AbstractWorkbenchPerspectiveActivity.class, MainPerspectiveActivity.class, inj2302_MainPerspectiveActivity_creational, null, arrayOf_19635043Annotation_1601691956, "MainPerspective", false);
    injContext.addBean(PerspectiveActivity.class, MainPerspectiveActivity.class, inj2302_MainPerspectiveActivity_creational, null, arrayOf_19635043Annotation_1601691956, null, false);
    injContext.addBean(ContextSensitiveActivity.class, MainPerspectiveActivity.class, inj2302_MainPerspectiveActivity_creational, null, arrayOf_19635043Annotation_1601691956, null, false);
    injContext.addBean(Activity.class, MainPerspectiveActivity.class, inj2302_MainPerspectiveActivity_creational, null, arrayOf_19635043Annotation_1601691956, null, false);
    injContext.addBean(RuntimeFeatureResource.class, MainPerspectiveActivity.class, inj2302_MainPerspectiveActivity_creational, null, arrayOf_19635043Annotation_1601691956, null, false);
    injContext.addBean(RuntimeResource.class, MainPerspectiveActivity.class, inj2302_MainPerspectiveActivity_creational, null, arrayOf_19635043Annotation_1601691956, null, false);
    injContext.addBean(Resource.class, MainPerspectiveActivity.class, inj2302_MainPerspectiveActivity_creational, null, arrayOf_19635043Annotation_1601691956, null, false);
    injContext.addBean(AbstractActivity.class, MainPerspectiveActivity.class, inj2302_MainPerspectiveActivity_creational, null, arrayOf_19635043Annotation_1601691956, null, false);
    injContext.addBean(TransitionToRoleProvider.class, TransitionToRoleProvider.class, inj2303_TransitionToRoleProvider_creational, inj2177_TransitionToRoleProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ContextualTypeProvider.class, TransitionToRoleProvider.class, inj2303_TransitionToRoleProvider_creational, inj2177_TransitionToRoleProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SecurityRolesConstraintPage.class, SecurityRolesConstraintPage.class, inj2304_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(SimplePanel.class, SecurityRolesConstraintPage.class, inj2304_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasOneWidget.class, SecurityRolesConstraintPage.class, inj2304_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AcceptsOneWidget.class, SecurityRolesConstraintPage.class, inj2304_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Panel.class, SecurityRolesConstraintPage.class, inj2304_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ForIsWidget.class, SecurityRolesConstraintPage.class, inj2304_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasWidgets.class, SecurityRolesConstraintPage.class, inj2304_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Iterable.class, SecurityRolesConstraintPage.class, inj2304_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, SecurityRolesConstraintPage.class, inj2304_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, SecurityRolesConstraintPage.class, inj2304_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, SecurityRolesConstraintPage.class, inj2304_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, SecurityRolesConstraintPage.class, inj2304_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, SecurityRolesConstraintPage.class, inj2304_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, SecurityRolesConstraintPage.class, inj2304_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, SecurityRolesConstraintPage.class, inj2304_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(RequestDispatcherProvider.class, RequestDispatcherProvider.class, inj2305_RequestDispatcherProvider_creational, inj2167_RequestDispatcherProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Provider.class, RequestDispatcherProvider.class, inj2305_RequestDispatcherProvider_creational, inj2167_RequestDispatcherProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AnyResourceTypeDefinition.class, AnyResourceTypeDefinition.class, inj2307_AnyResourceTypeDefinition_creational, inj2306_AnyResourceTypeDefinition, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ResourceTypeDefinition.class, AnyResourceTypeDefinition.class, inj2307_AnyResourceTypeDefinition_creational, inj2306_AnyResourceTypeDefinition, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LockDemandDetector.class, LockDemandDetector.class, inj2309_LockDemandDetector_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(StandaloneEditorPerspective.class, StandaloneEditorPerspective.class, inj2311_StandaloneEditorPerspective_creational, null, arrayOf_19635043Annotation_1796742650, "StandaloneEditorPerspective", true);
    injContext.addBean(AbstractWorkbenchPerspectiveActivity.class, StandaloneEditorPerspective.class, inj2311_StandaloneEditorPerspective_creational, null, arrayOf_19635043Annotation_1796742650, "StandaloneEditorPerspective", false);
    injContext.addBean(PerspectiveActivity.class, StandaloneEditorPerspective.class, inj2311_StandaloneEditorPerspective_creational, null, arrayOf_19635043Annotation_1796742650, null, false);
    injContext.addBean(ContextSensitiveActivity.class, StandaloneEditorPerspective.class, inj2311_StandaloneEditorPerspective_creational, null, arrayOf_19635043Annotation_1796742650, null, false);
    injContext.addBean(Activity.class, StandaloneEditorPerspective.class, inj2311_StandaloneEditorPerspective_creational, null, arrayOf_19635043Annotation_1796742650, null, false);
    injContext.addBean(RuntimeFeatureResource.class, StandaloneEditorPerspective.class, inj2311_StandaloneEditorPerspective_creational, null, arrayOf_19635043Annotation_1796742650, null, false);
    injContext.addBean(RuntimeResource.class, StandaloneEditorPerspective.class, inj2311_StandaloneEditorPerspective_creational, null, arrayOf_19635043Annotation_1796742650, null, false);
    injContext.addBean(Resource.class, StandaloneEditorPerspective.class, inj2311_StandaloneEditorPerspective_creational, null, arrayOf_19635043Annotation_1796742650, null, false);
    injContext.addBean(AbstractActivity.class, StandaloneEditorPerspective.class, inj2311_StandaloneEditorPerspective_creational, null, arrayOf_19635043Annotation_1796742650, null, false);
    injContext.addBean(ListWidgetProvider.class, ListWidgetProvider.class, inj2312_ListWidgetProvider_creational, inj2173_ListWidgetProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ContextualTypeProvider.class, ListWidgetProvider.class, inj2312_ListWidgetProvider_creational, inj2173_ListWidgetProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UberfireJSAPIExporter.class, UberfireJSAPIExporter.class, inj2314_UberfireJSAPIExporter_creational, inj2313_UberfireJSAPIExporter, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(SenderProvider.class, SenderProvider.class, inj2315_SenderProvider_creational, inj2183_SenderProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ContextualTypeProvider.class, SenderProvider.class, inj2315_SenderProvider_creational, inj2183_SenderProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(TextBox.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(TextBoxBase.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SourcesChangeEvents.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ValueBoxBase.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasChangeHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasName.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDirectionEstimator.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasValue.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(TakesValue.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasValueChangeHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasText.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Target.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDirection.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasKeyUpHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsEditor.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(FocusWidget.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SourcesClickEvents.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasClickHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDoubleClickHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasFocus.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Focusable.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SourcesFocusEvents.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SourcesKeyboardEvents.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasEnabled.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAllDragAndDropHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDragEndHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDragEnterHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDragLeaveHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDragHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDragOverHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDragStartHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDropHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAllFocusHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasFocusHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasBlurHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAllGestureHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasGestureStartHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasGestureChangeHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasGestureEndHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAllKeyHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasKeyDownHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasKeyPressHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAllMouseHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMouseDownHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMouseUpHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMouseOutHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMouseOverHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMouseMoveHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMouseWheelHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAllTouchHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasTouchStartHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasTouchMoveHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasTouchEndHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasTouchCancelHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SourcesMouseEvents.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, TextBox.class, inj2318_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(MoodListenerScreen.class, MoodListenerScreen.class, inj2317_MoodListenerScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Composite.class, MoodListenerScreen.class, inj2317_MoodListenerScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, MoodListenerScreen.class, inj2317_MoodListenerScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, MoodListenerScreen.class, inj2317_MoodListenerScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, MoodListenerScreen.class, inj2317_MoodListenerScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, MoodListenerScreen.class, inj2317_MoodListenerScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, MoodListenerScreen.class, inj2317_MoodListenerScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, MoodListenerScreen.class, inj2317_MoodListenerScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, MoodListenerScreen.class, inj2317_MoodListenerScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, MoodListenerScreen.class, inj2317_MoodListenerScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(CheckBox.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(HasName.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasValue.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(TakesValue.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasValueChangeHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasWordWrap.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDirectionalSafeHtml.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDirectionalText.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasText.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasSafeHtml.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDirectionEstimator.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsEditor.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasFormValue.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasChangeHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ButtonBase.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasResponsiveness.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasId.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasPull.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(com.google.gwt.user.client.ui.ButtonBase.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHTML.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(FocusWidget.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SourcesClickEvents.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasClickHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDoubleClickHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasFocus.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Focusable.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SourcesFocusEvents.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SourcesKeyboardEvents.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasEnabled.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAllDragAndDropHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDragEndHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDragEnterHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDragLeaveHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDragHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDragOverHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDragStartHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDropHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAllFocusHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasFocusHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasBlurHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAllGestureHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasGestureStartHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasGestureChangeHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasGestureEndHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAllKeyHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasKeyUpHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasKeyDownHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasKeyPressHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAllMouseHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMouseDownHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMouseUpHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMouseOutHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMouseOverHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMouseMoveHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMouseWheelHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAllTouchHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasTouchStartHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasTouchMoveHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasTouchEndHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasTouchCancelHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SourcesMouseEvents.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
  }

  private void declareBeans_1() {
    injContext.addBean(HasAttachHandlers.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, CheckBox.class, inj2320_CheckBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Button.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(AbstractToggleButton.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDataToggle.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AbstractIconButton.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasText.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasIcon.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasIconPosition.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AbstractButton.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasEnabled.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasActive.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasType.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasSize.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDataTarget.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasClickHandlers.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Focusable.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAllMouseHandlers.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMouseDownHandlers.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMouseUpHandlers.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMouseOutHandlers.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMouseOverHandlers.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMouseMoveHandlers.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMouseWheelHandlers.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ComplexWidget.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasId.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasResponsiveness.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasInlineStyle.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasPull.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ComplexPanel.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(com.google.gwt.user.client.ui.IndexedPanel.ForIsWidget.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IndexedPanel.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Panel.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ForIsWidget.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasWidgets.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Iterable.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, Button.class, inj2321_Button_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SplashModalFooter.class, SplashModalFooter.class, inj2319_SplashModalFooter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Composite.class, SplashModalFooter.class, inj2319_SplashModalFooter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, SplashModalFooter.class, inj2319_SplashModalFooter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, SplashModalFooter.class, inj2319_SplashModalFooter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, SplashModalFooter.class, inj2319_SplashModalFooter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, SplashModalFooter.class, inj2319_SplashModalFooter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, SplashModalFooter.class, inj2319_SplashModalFooter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, SplashModalFooter.class, inj2319_SplashModalFooter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, SplashModalFooter.class, inj2319_SplashModalFooter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, SplashModalFooter.class, inj2319_SplashModalFooter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Bs3Modal.class, Bs3Modal.class, inj2323_Bs3Modal_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Modal.class, Bs3Modal.class, inj2323_Bs3Modal_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsClosable.class, Bs3Modal.class, inj2323_Bs3Modal_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Div.class, Bs3Modal.class, inj2323_Bs3Modal_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ComplexWidget.class, Bs3Modal.class, inj2323_Bs3Modal_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasId.class, Bs3Modal.class, inj2323_Bs3Modal_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasResponsiveness.class, Bs3Modal.class, inj2323_Bs3Modal_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasInlineStyle.class, Bs3Modal.class, inj2323_Bs3Modal_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasPull.class, Bs3Modal.class, inj2323_Bs3Modal_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ComplexPanel.class, Bs3Modal.class, inj2323_Bs3Modal_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(com.google.gwt.user.client.ui.IndexedPanel.ForIsWidget.class, Bs3Modal.class, inj2323_Bs3Modal_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IndexedPanel.class, Bs3Modal.class, inj2323_Bs3Modal_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Panel.class, Bs3Modal.class, inj2323_Bs3Modal_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ForIsWidget.class, Bs3Modal.class, inj2323_Bs3Modal_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasWidgets.class, Bs3Modal.class, inj2323_Bs3Modal_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Iterable.class, Bs3Modal.class, inj2323_Bs3Modal_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, Bs3Modal.class, inj2323_Bs3Modal_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, Bs3Modal.class, inj2323_Bs3Modal_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, Bs3Modal.class, inj2323_Bs3Modal_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, Bs3Modal.class, inj2323_Bs3Modal_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, Bs3Modal.class, inj2323_Bs3Modal_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, Bs3Modal.class, inj2323_Bs3Modal_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, Bs3Modal.class, inj2323_Bs3Modal_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SplashViewImpl.class, SplashViewImpl.class, inj2325_SplashViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(SplashView.class, SplashViewImpl.class, inj2325_SplashViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasCloseHandlers.class, SplashViewImpl.class, inj2325_SplashViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, SplashViewImpl.class, inj2325_SplashViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Composite.class, SplashViewImpl.class, inj2325_SplashViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, SplashViewImpl.class, inj2325_SplashViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, SplashViewImpl.class, inj2325_SplashViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, SplashViewImpl.class, inj2325_SplashViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, SplashViewImpl.class, inj2325_SplashViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, SplashViewImpl.class, inj2325_SplashViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, SplashViewImpl.class, inj2325_SplashViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, SplashViewImpl.class, inj2325_SplashViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(PageTransitionProvider.class, PageTransitionProvider.class, inj2326_PageTransitionProvider_creational, inj2179_PageTransitionProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ContextualTypeProvider.class, PageTransitionProvider.class, inj2326_PageTransitionProvider_creational, inj2179_PageTransitionProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(RootPanelProvider.class, RootPanelProvider.class, inj2327_RootPanelProvider_creational, inj2175_RootPanelProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Provider.class, RootPanelProvider.class, inj2327_RootPanelProvider_creational, inj2175_RootPanelProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(MultiPageEditorViewImpl.class, MultiPageEditorViewImpl.class, inj2329_MultiPageEditorViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(MultiPageEditorView.class, MultiPageEditorViewImpl.class, inj2329_MultiPageEditorViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, MultiPageEditorViewImpl.class, inj2329_MultiPageEditorViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ResizeTabPanel.class, MultiPageEditorViewImpl.class, inj2329_MultiPageEditorViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(RequiresResize.class, MultiPageEditorViewImpl.class, inj2329_MultiPageEditorViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ProvidesResize.class, MultiPageEditorViewImpl.class, inj2329_MultiPageEditorViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(TabPanelWithDropdowns.class, MultiPageEditorViewImpl.class, inj2329_MultiPageEditorViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Composite.class, MultiPageEditorViewImpl.class, inj2329_MultiPageEditorViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, MultiPageEditorViewImpl.class, inj2329_MultiPageEditorViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, MultiPageEditorViewImpl.class, inj2329_MultiPageEditorViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, MultiPageEditorViewImpl.class, inj2329_MultiPageEditorViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, MultiPageEditorViewImpl.class, inj2329_MultiPageEditorViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, MultiPageEditorViewImpl.class, inj2329_MultiPageEditorViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, MultiPageEditorViewImpl.class, inj2329_MultiPageEditorViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, MultiPageEditorViewImpl.class, inj2329_MultiPageEditorViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ActivityBeansInfo.class, ActivityBeansInfo.class, inj2331_ActivityBeansInfo_creational, inj2330_ActivityBeansInfo, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(PartManager.class, PartManager.class, inj2333_PartManager_creational, inj2332_PartManager, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(LayoutPanelView.class, LayoutPanelView.class, inj2335_LayoutPanelView_creational, null, arrayOf_19635043Annotation_1286405175, "LayoutPanelView", true);
    injContext.addBean(WorkbenchPanelView.class, LayoutPanelView.class, inj2335_LayoutPanelView_creational, null, arrayOf_19635043Annotation_1286405175, "LayoutPanelView", false);
    injContext.addBean(UberView.class, LayoutPanelView.class, inj2335_LayoutPanelView_creational, null, arrayOf_19635043Annotation_1286405175, null, false);
    injContext.addBean(IsWidget.class, LayoutPanelView.class, inj2335_LayoutPanelView_creational, null, arrayOf_19635043Annotation_1286405175, null, false);
    injContext.addBean(RequiresResize.class, LayoutPanelView.class, inj2335_LayoutPanelView_creational, null, arrayOf_19635043Annotation_1286405175, null, false);
    injContext.addBean(LayoutPanelPresenter.class, LayoutPanelPresenter.class, inj2337_LayoutPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(AbstractWorkbenchPanelPresenter.class, LayoutPanelPresenter.class, inj2337_LayoutPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchPanelPresenter.class, LayoutPanelPresenter.class, inj2337_LayoutPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(TransitionAnchorFactoryProvider.class, TransitionAnchorFactoryProvider.class, inj2338_TransitionAnchorFactoryProvider_creational, inj2169_TransitionAnchorFactoryProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ContextualTypeProvider.class, TransitionAnchorFactoryProvider.class, inj2338_TransitionAnchorFactoryProvider_creational, inj2169_TransitionAnchorFactoryProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(JSNativePerspective.class, JSNativePerspective.class, inj2340_JSNativePerspective_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(VFSLockServiceProxyClientImpl.class, VFSLockServiceProxyClientImpl.class, inj2342_VFSLockServiceProxyClientImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(VFSLockServiceProxy.class, VFSLockServiceProxyClientImpl.class, inj2342_VFSLockServiceProxyClientImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(VFSLockServiceProxyBackendImpl.class, VFSLockServiceProxyBackendImpl.class, inj2345_VFSLockServiceProxyBackendImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(VFSLockServiceProxy.class, VFSLockServiceProxyBackendImpl.class, inj2345_VFSLockServiceProxyBackendImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LockManagerImpl.class, LockManagerImpl.class, inj2344_LockManagerImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(LockManager.class, LockManagerImpl.class, inj2344_LockManagerImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(StaticFocusedResizePanel.class, StaticFocusedResizePanel.class, inj2348_StaticFocusedResizePanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(HasSelectionHandlers.class, StaticFocusedResizePanel.class, inj2348_StaticFocusedResizePanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, StaticFocusedResizePanel.class, inj2348_StaticFocusedResizePanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasFocusHandlers.class, StaticFocusedResizePanel.class, inj2348_StaticFocusedResizePanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ResizeComposite.class, StaticFocusedResizePanel.class, inj2348_StaticFocusedResizePanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(RequiresResize.class, StaticFocusedResizePanel.class, inj2348_StaticFocusedResizePanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Composite.class, StaticFocusedResizePanel.class, inj2348_StaticFocusedResizePanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, StaticFocusedResizePanel.class, inj2348_StaticFocusedResizePanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, StaticFocusedResizePanel.class, inj2348_StaticFocusedResizePanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, StaticFocusedResizePanel.class, inj2348_StaticFocusedResizePanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, StaticFocusedResizePanel.class, inj2348_StaticFocusedResizePanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, StaticFocusedResizePanel.class, inj2348_StaticFocusedResizePanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, StaticFocusedResizePanel.class, inj2348_StaticFocusedResizePanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, StaticFocusedResizePanel.class, inj2348_StaticFocusedResizePanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(StaticWorkbenchPanelView.class, StaticWorkbenchPanelView.class, inj2347_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1048561786, "StaticWorkbenchPanelView", true);
    injContext.addBean(AbstractWorkbenchPanelView.class, StaticWorkbenchPanelView.class, inj2347_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1048561786, "StaticWorkbenchPanelView", false);
    injContext.addBean(WorkbenchPanelView.class, StaticWorkbenchPanelView.class, inj2347_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1048561786, null, false);
    injContext.addBean(UberView.class, StaticWorkbenchPanelView.class, inj2347_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1048561786, null, false);
    injContext.addBean(IsWidget.class, StaticWorkbenchPanelView.class, inj2347_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1048561786, null, false);
    injContext.addBean(RequiresResize.class, StaticWorkbenchPanelView.class, inj2347_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1048561786, null, false);
    injContext.addBean(ResizeComposite.class, StaticWorkbenchPanelView.class, inj2347_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1048561786, null, false);
    injContext.addBean(Composite.class, StaticWorkbenchPanelView.class, inj2347_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1048561786, null, false);
    injContext.addBean(IsRenderable.class, StaticWorkbenchPanelView.class, inj2347_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1048561786, null, false);
    injContext.addBean(Widget.class, StaticWorkbenchPanelView.class, inj2347_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1048561786, null, false);
    injContext.addBean(EventListener.class, StaticWorkbenchPanelView.class, inj2347_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1048561786, null, false);
    injContext.addBean(HasAttachHandlers.class, StaticWorkbenchPanelView.class, inj2347_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1048561786, null, false);
    injContext.addBean(HasHandlers.class, StaticWorkbenchPanelView.class, inj2347_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1048561786, null, false);
    injContext.addBean(UIObject.class, StaticWorkbenchPanelView.class, inj2347_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1048561786, null, false);
    injContext.addBean(HasVisibility.class, StaticWorkbenchPanelView.class, inj2347_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1048561786, null, false);
    injContext.addBean(DefaultBusSecurityErrorCallback.class, DefaultBusSecurityErrorCallback.class, inj2350_DefaultBusSecurityErrorCallback_creational, inj2349_DefaultBusSecurityErrorCallback, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(TextResourceTypeDefinition.class, TextResourceTypeDefinition.class, inj2352_TextResourceTypeDefinition_creational, inj2351_TextResourceTypeDefinition, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ResourceTypeDefinition.class, TextResourceTypeDefinition.class, inj2352_TextResourceTypeDefinition_creational, inj2351_TextResourceTypeDefinition, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(BatchCallerProvider.class, BatchCallerProvider.class, inj2353_BatchCallerProvider_creational, inj2185_BatchCallerProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Provider.class, BatchCallerProvider.class, inj2353_BatchCallerProvider_creational, inj2185_BatchCallerProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(MessageBusProvider.class, MessageBusProvider.class, inj2354_MessageBusProvider_creational, inj2191_MessageBusProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Provider.class, MessageBusProvider.class, inj2354_MessageBusProvider_creational, inj2191_MessageBusProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(VFSServiceProxyClientImpl.class, VFSServiceProxyClientImpl.class, inj2356_VFSServiceProxyClientImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(VFSServiceProxy.class, VFSServiceProxyClientImpl.class, inj2356_VFSServiceProxyClientImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(VFSServiceProxyBackendImpl.class, VFSServiceProxyBackendImpl.class, inj2359_VFSServiceProxyBackendImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(VFSServiceProxy.class, VFSServiceProxyBackendImpl.class, inj2359_VFSServiceProxyBackendImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Workbench.class, Workbench.class, inj2358_Workbench_creational, inj2357_Workbench, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(SessionInfo.class, SessionInfo.class, inj2149_SessionInfo_creational, SimpleInjectionContext.LAZY_INIT_REF, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ObservablePathImpl.class, ObservablePathImpl.class, inj2361_ObservablePathImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ObservablePath.class, ObservablePathImpl.class, inj2361_ObservablePathImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Path.class, ObservablePathImpl.class, inj2361_ObservablePathImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Comparable.class, ObservablePathImpl.class, inj2361_ObservablePathImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Disposable.class, ObservablePathImpl.class, inj2361_ObservablePathImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsVersioned.class, ObservablePathImpl.class, inj2361_ObservablePathImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UberTabPanel.class, UberTabPanel.class, inj2363_UberTabPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(MultiPartWidget.class, UberTabPanel.class, inj2363_UberTabPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, UberTabPanel.class, inj2363_UberTabPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(RequiresResize.class, UberTabPanel.class, inj2363_UberTabPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasBeforeSelectionHandlers.class, UberTabPanel.class, inj2363_UberTabPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, UberTabPanel.class, inj2363_UberTabPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasSelectionHandlers.class, UberTabPanel.class, inj2363_UberTabPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ClickHandler.class, UberTabPanel.class, inj2363_UberTabPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventHandler.class, UberTabPanel.class, inj2363_UberTabPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ResizeComposite.class, UberTabPanel.class, inj2363_UberTabPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Composite.class, UberTabPanel.class, inj2363_UberTabPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, UberTabPanel.class, inj2363_UberTabPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, UberTabPanel.class, inj2363_UberTabPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, UberTabPanel.class, inj2363_UberTabPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, UberTabPanel.class, inj2363_UberTabPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, UberTabPanel.class, inj2363_UberTabPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, UberTabPanel.class, inj2363_UberTabPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(MultiTabWorkbenchPanelView.class, MultiTabWorkbenchPanelView.class, inj2365_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_913099561, "MultiTabWorkbenchPanelView", true);
    injContext.addBean(AbstractMultiPartWorkbenchPanelView.class, MultiTabWorkbenchPanelView.class, inj2365_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_913099561, "MultiTabWorkbenchPanelView", false);
    injContext.addBean(AbstractDockingWorkbenchPanelView.class, MultiTabWorkbenchPanelView.class, inj2365_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_913099561, null, false);
    injContext.addBean(DockingWorkbenchPanelView.class, MultiTabWorkbenchPanelView.class, inj2365_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_913099561, null, false);
    injContext.addBean(WorkbenchPanelView.class, MultiTabWorkbenchPanelView.class, inj2365_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_913099561, null, false);
    injContext.addBean(UberView.class, MultiTabWorkbenchPanelView.class, inj2365_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_913099561, null, false);
    injContext.addBean(IsWidget.class, MultiTabWorkbenchPanelView.class, inj2365_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_913099561, null, false);
    injContext.addBean(RequiresResize.class, MultiTabWorkbenchPanelView.class, inj2365_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_913099561, null, false);
    injContext.addBean(AbstractWorkbenchPanelView.class, MultiTabWorkbenchPanelView.class, inj2365_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_913099561, null, false);
    injContext.addBean(ResizeComposite.class, MultiTabWorkbenchPanelView.class, inj2365_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_913099561, null, false);
    injContext.addBean(Composite.class, MultiTabWorkbenchPanelView.class, inj2365_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_913099561, null, false);
    injContext.addBean(IsRenderable.class, MultiTabWorkbenchPanelView.class, inj2365_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_913099561, null, false);
    injContext.addBean(Widget.class, MultiTabWorkbenchPanelView.class, inj2365_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_913099561, null, false);
    injContext.addBean(EventListener.class, MultiTabWorkbenchPanelView.class, inj2365_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_913099561, null, false);
    injContext.addBean(HasAttachHandlers.class, MultiTabWorkbenchPanelView.class, inj2365_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_913099561, null, false);
    injContext.addBean(HasHandlers.class, MultiTabWorkbenchPanelView.class, inj2365_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_913099561, null, false);
    injContext.addBean(UIObject.class, MultiTabWorkbenchPanelView.class, inj2365_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_913099561, null, false);
    injContext.addBean(HasVisibility.class, MultiTabWorkbenchPanelView.class, inj2365_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_913099561, null, false);
    injContext.addBean(MoodPerspective.class, MoodPerspective.class, inj2366_MoodPerspective_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Composite.class, MoodPerspective.class, inj2366_MoodPerspective_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, MoodPerspective.class, inj2366_MoodPerspective_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, MoodPerspective.class, inj2366_MoodPerspective_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, MoodPerspective.class, inj2366_MoodPerspective_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, MoodPerspective.class, inj2366_MoodPerspective_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, MoodPerspective.class, inj2366_MoodPerspective_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, MoodPerspective.class, inj2366_MoodPerspective_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, MoodPerspective.class, inj2366_MoodPerspective_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, MoodPerspective.class, inj2366_MoodPerspective_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(RuntimePluginsServiceProxyClientImpl.class, RuntimePluginsServiceProxyClientImpl.class, inj2368_RuntimePluginsServiceProxyClientImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(RuntimePluginsServiceProxy.class, RuntimePluginsServiceProxyClientImpl.class, inj2368_RuntimePluginsServiceProxyClientImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(RuntimePluginsServiceProxyBackendImpl.class, RuntimePluginsServiceProxyBackendImpl.class, inj2370_RuntimePluginsServiceProxyBackendImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(RuntimePluginsServiceProxy.class, RuntimePluginsServiceProxyBackendImpl.class, inj2370_RuntimePluginsServiceProxyBackendImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(JSNativeEditor.class, JSNativeEditor.class, inj2372_JSNativeEditor_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(JSNativePlugin.class, JSNativeEditor.class, inj2372_JSNativeEditor_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(TransitionAnchorProvider.class, TransitionAnchorProvider.class, inj2373_TransitionAnchorProvider_creational, inj2171_TransitionAnchorProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ContextualTypeProvider.class, TransitionAnchorProvider.class, inj2373_TransitionAnchorProvider_creational, inj2171_TransitionAnchorProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(TranslationServiceProvider.class, TranslationServiceProvider.class, inj2374_TranslationServiceProvider_creational, inj2181_TranslationServiceProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Provider.class, TranslationServiceProvider.class, inj2374_TranslationServiceProvider_creational, inj2181_TranslationServiceProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UserMenuViewImpl.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(UserMenuView.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMenuItems.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AnchorListItem.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasText.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AbstractAnchorListItem.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHref.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasTargetHistoryToken.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasClickHandlers.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Focusable.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDataToggle.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasIcon.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasIconPosition.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AbstractListItem.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasEnabled.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasPull.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasActive.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasResponsiveness.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasId.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ComplexWidget.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasInlineStyle.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ComplexPanel.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(com.google.gwt.user.client.ui.IndexedPanel.ForIsWidget.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IndexedPanel.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Panel.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ForIsWidget.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasWidgets.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Iterable.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, UserMenuViewImpl.class, inj2376_UserMenuViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UserMenu.class, UserMenu.class, inj2378_UserMenu_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(CustomMenuBuilder.class, UserMenu.class, inj2378_UserMenu_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMenus.class, UserMenu.class, inj2378_UserMenu_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ClientTypeRegistryImpl.class, ClientTypeRegistryImpl.class, inj2380_ClientTypeRegistryImpl_creational, inj2379_ClientTypeRegistryImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ClientTypeRegistry.class, ClientTypeRegistryImpl.class, inj2380_ClientTypeRegistryImpl_creational, inj2379_ClientTypeRegistryImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SplitLayoutPanelView.class, SplitLayoutPanelView.class, inj2382_SplitLayoutPanelView_creational, null, arrayOf_19635043Annotation_799239204, "SplitLayoutPanelView", true);
    injContext.addBean(WorkbenchPanelView.class, SplitLayoutPanelView.class, inj2382_SplitLayoutPanelView_creational, null, arrayOf_19635043Annotation_799239204, "SplitLayoutPanelView", false);
    injContext.addBean(UberView.class, SplitLayoutPanelView.class, inj2382_SplitLayoutPanelView_creational, null, arrayOf_19635043Annotation_799239204, null, false);
    injContext.addBean(IsWidget.class, SplitLayoutPanelView.class, inj2382_SplitLayoutPanelView_creational, null, arrayOf_19635043Annotation_799239204, null, false);
    injContext.addBean(RequiresResize.class, SplitLayoutPanelView.class, inj2382_SplitLayoutPanelView_creational, null, arrayOf_19635043Annotation_799239204, null, false);
    injContext.addBean(SplitLayoutPanelPresenter.class, SplitLayoutPanelPresenter.class, inj2384_SplitLayoutPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(AbstractWorkbenchPanelPresenter.class, SplitLayoutPanelPresenter.class, inj2384_SplitLayoutPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchPanelPresenter.class, SplitLayoutPanelPresenter.class, inj2384_SplitLayoutPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchViewModeSwitcherView.class, WorkbenchViewModeSwitcherView.class, inj2386_WorkbenchViewModeSwitcherView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(org.uberfire.client.menu.WorkbenchViewModeSwitcherPresenter.View.class, WorkbenchViewModeSwitcherView.class, inj2386_WorkbenchViewModeSwitcherView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UberView.class, WorkbenchViewModeSwitcherView.class, inj2386_WorkbenchViewModeSwitcherView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, WorkbenchViewModeSwitcherView.class, inj2386_WorkbenchViewModeSwitcherView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(VFSJSExporter.class, VFSJSExporter.class, inj2388_VFSJSExporter_creational, inj2387_VFSJSExporter, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(UberfireJSExporter.class, VFSJSExporter.class, inj2388_VFSJSExporter_creational, inj2387_VFSJSExporter, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HelloWorldScreen.class, HelloWorldScreen.class, inj2390_HelloWorldScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Composite.class, HelloWorldScreen.class, inj2390_HelloWorldScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, HelloWorldScreen.class, inj2390_HelloWorldScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, HelloWorldScreen.class, inj2390_HelloWorldScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, HelloWorldScreen.class, inj2390_HelloWorldScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, HelloWorldScreen.class, inj2390_HelloWorldScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, HelloWorldScreen.class, inj2390_HelloWorldScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, HelloWorldScreen.class, inj2390_HelloWorldScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, HelloWorldScreen.class, inj2390_HelloWorldScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, HelloWorldScreen.class, inj2390_HelloWorldScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HelloWorldScreenActivity.class, HelloWorldScreenActivity.class, inj2392_HelloWorldScreenActivity_creational, null, arrayOf_19635043Annotation_882203174, "HelloWorldScreen", true);
    injContext.addBean(AbstractWorkbenchScreenActivity.class, HelloWorldScreenActivity.class, inj2392_HelloWorldScreenActivity_creational, null, arrayOf_19635043Annotation_882203174, "HelloWorldScreen", false);
    injContext.addBean(WorkbenchScreenActivity.class, HelloWorldScreenActivity.class, inj2392_HelloWorldScreenActivity_creational, null, arrayOf_19635043Annotation_882203174, null, false);
    injContext.addBean(WorkbenchActivity.class, HelloWorldScreenActivity.class, inj2392_HelloWorldScreenActivity_creational, null, arrayOf_19635043Annotation_882203174, null, false);
    injContext.addBean(ContextSensitiveActivity.class, HelloWorldScreenActivity.class, inj2392_HelloWorldScreenActivity_creational, null, arrayOf_19635043Annotation_882203174, null, false);
    injContext.addBean(Activity.class, HelloWorldScreenActivity.class, inj2392_HelloWorldScreenActivity_creational, null, arrayOf_19635043Annotation_882203174, null, false);
    injContext.addBean(RuntimeFeatureResource.class, HelloWorldScreenActivity.class, inj2392_HelloWorldScreenActivity_creational, null, arrayOf_19635043Annotation_882203174, null, false);
    injContext.addBean(RuntimeResource.class, HelloWorldScreenActivity.class, inj2392_HelloWorldScreenActivity_creational, null, arrayOf_19635043Annotation_882203174, null, false);
    injContext.addBean(Resource.class, HelloWorldScreenActivity.class, inj2392_HelloWorldScreenActivity_creational, null, arrayOf_19635043Annotation_882203174, null, false);
    injContext.addBean(AbstractWorkbenchActivity.class, HelloWorldScreenActivity.class, inj2392_HelloWorldScreenActivity_creational, null, arrayOf_19635043Annotation_882203174, null, false);
    injContext.addBean(AbstractActivity.class, HelloWorldScreenActivity.class, inj2392_HelloWorldScreenActivity_creational, null, arrayOf_19635043Annotation_882203174, null, false);
    injContext.addBean(CreationImpl.class, CreationImpl.class, inj2394_CreationImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Creation.class, CreationImpl.class, inj2394_CreationImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LifecycleEvent.class, CreationImpl.class, inj2394_CreationImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LifecycleEventImpl.class, CreationImpl.class, inj2394_CreationImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LifecycleEvent.class, CreationImpl.class, inj2394_CreationImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HTML5DndSeleniumSupport.class, HTML5DndSeleniumSupport.class, inj2396_HTML5DndSeleniumSupport_creational, inj2395_HTML5DndSeleniumSupport, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(UberfireJSExporter.class, HTML5DndSeleniumSupport.class, inj2396_HTML5DndSeleniumSupport_creational, inj2395_HTML5DndSeleniumSupport, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(CompassWidgetImpl.class, CompassWidgetImpl.class, inj2398_CompassWidgetImpl_creational, inj2397_CompassWidgetImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(CompassWidget.class, CompassWidgetImpl.class, inj2398_CompassWidgetImpl_creational, inj2397_CompassWidgetImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DropController.class, CompassWidgetImpl.class, inj2398_CompassWidgetImpl_creational, inj2397_CompassWidgetImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(NotificationPopupsManagerView.class, NotificationPopupsManagerView.class, inj2400_NotificationPopupsManagerView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(org.uberfire.client.workbench.widgets.notifications.NotificationManager.View.class, NotificationPopupsManagerView.class, inj2400_NotificationPopupsManagerView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AdaptiveWorkbenchPanelView.class, AdaptiveWorkbenchPanelView.class, inj2402_AdaptiveWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_482389261, "AdaptiveWorkbenchPanelView", true);
    injContext.addBean(AbstractSimpleWorkbenchPanelView.class, AdaptiveWorkbenchPanelView.class, inj2402_AdaptiveWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_482389261, "AdaptiveWorkbenchPanelView", false);
    injContext.addBean(AbstractDockingWorkbenchPanelView.class, AdaptiveWorkbenchPanelView.class, inj2402_AdaptiveWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_482389261, null, false);
    injContext.addBean(DockingWorkbenchPanelView.class, AdaptiveWorkbenchPanelView.class, inj2402_AdaptiveWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_482389261, null, false);
    injContext.addBean(WorkbenchPanelView.class, AdaptiveWorkbenchPanelView.class, inj2402_AdaptiveWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_482389261, null, false);
    injContext.addBean(UberView.class, AdaptiveWorkbenchPanelView.class, inj2402_AdaptiveWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_482389261, null, false);
    injContext.addBean(IsWidget.class, AdaptiveWorkbenchPanelView.class, inj2402_AdaptiveWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_482389261, null, false);
    injContext.addBean(RequiresResize.class, AdaptiveWorkbenchPanelView.class, inj2402_AdaptiveWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_482389261, null, false);
    injContext.addBean(AbstractWorkbenchPanelView.class, AdaptiveWorkbenchPanelView.class, inj2402_AdaptiveWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_482389261, null, false);
    injContext.addBean(ResizeComposite.class, AdaptiveWorkbenchPanelView.class, inj2402_AdaptiveWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_482389261, null, false);
    injContext.addBean(Composite.class, AdaptiveWorkbenchPanelView.class, inj2402_AdaptiveWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_482389261, null, false);
    injContext.addBean(IsRenderable.class, AdaptiveWorkbenchPanelView.class, inj2402_AdaptiveWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_482389261, null, false);
    injContext.addBean(Widget.class, AdaptiveWorkbenchPanelView.class, inj2402_AdaptiveWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_482389261, null, false);
    injContext.addBean(EventListener.class, AdaptiveWorkbenchPanelView.class, inj2402_AdaptiveWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_482389261, null, false);
    injContext.addBean(HasAttachHandlers.class, AdaptiveWorkbenchPanelView.class, inj2402_AdaptiveWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_482389261, null, false);
    injContext.addBean(HasHandlers.class, AdaptiveWorkbenchPanelView.class, inj2402_AdaptiveWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_482389261, null, false);
    injContext.addBean(UIObject.class, AdaptiveWorkbenchPanelView.class, inj2402_AdaptiveWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_482389261, null, false);
    injContext.addBean(HasVisibility.class, AdaptiveWorkbenchPanelView.class, inj2402_AdaptiveWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_482389261, null, false);
    injContext.addBean(SimpleWorkbenchPanelView.class, SimpleWorkbenchPanelView.class, inj2404_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_351968993, "SimpleWorkbenchPanelView", true);
    injContext.addBean(AbstractSimpleWorkbenchPanelView.class, SimpleWorkbenchPanelView.class, inj2404_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_351968993, "SimpleWorkbenchPanelView", false);
    injContext.addBean(AbstractDockingWorkbenchPanelView.class, SimpleWorkbenchPanelView.class, inj2404_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_351968993, null, false);
    injContext.addBean(DockingWorkbenchPanelView.class, SimpleWorkbenchPanelView.class, inj2404_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_351968993, null, false);
    injContext.addBean(WorkbenchPanelView.class, SimpleWorkbenchPanelView.class, inj2404_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_351968993, null, false);
    injContext.addBean(UberView.class, SimpleWorkbenchPanelView.class, inj2404_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_351968993, null, false);
    injContext.addBean(IsWidget.class, SimpleWorkbenchPanelView.class, inj2404_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_351968993, null, false);
    injContext.addBean(RequiresResize.class, SimpleWorkbenchPanelView.class, inj2404_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_351968993, null, false);
    injContext.addBean(AbstractWorkbenchPanelView.class, SimpleWorkbenchPanelView.class, inj2404_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_351968993, null, false);
    injContext.addBean(ResizeComposite.class, SimpleWorkbenchPanelView.class, inj2404_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_351968993, null, false);
    injContext.addBean(Composite.class, SimpleWorkbenchPanelView.class, inj2404_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_351968993, null, false);
    injContext.addBean(IsRenderable.class, SimpleWorkbenchPanelView.class, inj2404_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_351968993, null, false);
    injContext.addBean(Widget.class, SimpleWorkbenchPanelView.class, inj2404_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_351968993, null, false);
    injContext.addBean(EventListener.class, SimpleWorkbenchPanelView.class, inj2404_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_351968993, null, false);
    injContext.addBean(HasAttachHandlers.class, SimpleWorkbenchPanelView.class, inj2404_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_351968993, null, false);
    injContext.addBean(HasHandlers.class, SimpleWorkbenchPanelView.class, inj2404_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_351968993, null, false);
    injContext.addBean(UIObject.class, SimpleWorkbenchPanelView.class, inj2404_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_351968993, null, false);
    injContext.addBean(HasVisibility.class, SimpleWorkbenchPanelView.class, inj2404_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_351968993, null, false);
    injContext.addBean(LessStyle.class, LessStyle.class, inj2406_LessStyle_creational, inj2405_LessStyle, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(MoodPerspectiveActivity.class, MoodPerspectiveActivity.class, inj2408_MoodPerspectiveActivity_creational, null, arrayOf_19635043Annotation_1179408223, "MoodPerspective", true);
    injContext.addBean(AbstractWorkbenchPerspectiveActivity.class, MoodPerspectiveActivity.class, inj2408_MoodPerspectiveActivity_creational, null, arrayOf_19635043Annotation_1179408223, "MoodPerspective", false);
    injContext.addBean(PerspectiveActivity.class, MoodPerspectiveActivity.class, inj2408_MoodPerspectiveActivity_creational, null, arrayOf_19635043Annotation_1179408223, null, false);
    injContext.addBean(ContextSensitiveActivity.class, MoodPerspectiveActivity.class, inj2408_MoodPerspectiveActivity_creational, null, arrayOf_19635043Annotation_1179408223, null, false);
    injContext.addBean(Activity.class, MoodPerspectiveActivity.class, inj2408_MoodPerspectiveActivity_creational, null, arrayOf_19635043Annotation_1179408223, null, false);
    injContext.addBean(RuntimeFeatureResource.class, MoodPerspectiveActivity.class, inj2408_MoodPerspectiveActivity_creational, null, arrayOf_19635043Annotation_1179408223, null, false);
    injContext.addBean(RuntimeResource.class, MoodPerspectiveActivity.class, inj2408_MoodPerspectiveActivity_creational, null, arrayOf_19635043Annotation_1179408223, null, false);
    injContext.addBean(Resource.class, MoodPerspectiveActivity.class, inj2408_MoodPerspectiveActivity_creational, null, arrayOf_19635043Annotation_1179408223, null, false);
    injContext.addBean(AbstractActivity.class, MoodPerspectiveActivity.class, inj2408_MoodPerspectiveActivity_creational, null, arrayOf_19635043Annotation_1179408223, null, false);
    injContext.addBean(EventBus.class, EventBus.class, inj2148_EventBus_creational, SimpleInjectionContext.LAZY_INIT_REF, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(PluginJSExporter.class, PluginJSExporter.class, inj2410_PluginJSExporter_creational, inj2409_PluginJSExporter, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(UberfireJSExporter.class, PluginJSExporter.class, inj2410_PluginJSExporter_creational, inj2409_PluginJSExporter, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DefaultRestSecurityErrorCallback.class, DefaultRestSecurityErrorCallback.class, inj2412_DefaultRestSecurityErrorCallback_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(RestErrorCallback.class, DefaultRestSecurityErrorCallback.class, inj2412_DefaultRestSecurityErrorCallback_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ErrorCallback.class, DefaultRestSecurityErrorCallback.class, inj2412_DefaultRestSecurityErrorCallback_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SplashScreenMenuView.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(View.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UberView.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AnchorListItem.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasText.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AbstractAnchorListItem.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHref.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasTargetHistoryToken.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasClickHandlers.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Focusable.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDataToggle.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasIcon.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasIconPosition.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AbstractListItem.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasEnabled.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasPull.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasActive.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasResponsiveness.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasId.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ComplexWidget.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasInlineStyle.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ComplexPanel.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(com.google.gwt.user.client.ui.IndexedPanel.ForIsWidget.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IndexedPanel.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Panel.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ForIsWidget.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasWidgets.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Iterable.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, SplashScreenMenuView.class, inj2414_SplashScreenMenuView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SplashScreenMenuPresenter.class, SplashScreenMenuPresenter.class, inj2416_SplashScreenMenuPresenter_creational, inj2415_SplashScreenMenuPresenter, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(IsWidget.class, SplashScreenMenuPresenter.class, inj2416_SplashScreenMenuPresenter_creational, inj2415_SplashScreenMenuPresenter, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LocaleSelector.class, LocaleSelector.class, inj2418_LocaleSelector_creational, inj2417_LocaleSelector, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(LocaleListBox.class, LocaleListBox.class, inj2420_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ValueListBox.class, LocaleListBox.class, inj2420_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Focusable.class, LocaleListBox.class, inj2420_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasConstrainedValue.class, LocaleListBox.class, inj2420_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasValue.class, LocaleListBox.class, inj2420_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(TakesValue.class, LocaleListBox.class, inj2420_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasValueChangeHandlers.class, LocaleListBox.class, inj2420_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, LocaleListBox.class, inj2420_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasEnabled.class, LocaleListBox.class, inj2420_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsEditor.class, LocaleListBox.class, inj2420_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Composite.class, LocaleListBox.class, inj2420_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, LocaleListBox.class, inj2420_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, LocaleListBox.class, inj2420_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, LocaleListBox.class, inj2420_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, LocaleListBox.class, inj2420_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, LocaleListBox.class, inj2420_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, LocaleListBox.class, inj2420_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, LocaleListBox.class, inj2420_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SimpleDnDWorkbenchPanelView.class, SimpleDnDWorkbenchPanelView.class, inj2422_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(AbstractSimpleWorkbenchPanelView.class, SimpleDnDWorkbenchPanelView.class, inj2422_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AbstractDockingWorkbenchPanelView.class, SimpleDnDWorkbenchPanelView.class, inj2422_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DockingWorkbenchPanelView.class, SimpleDnDWorkbenchPanelView.class, inj2422_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchPanelView.class, SimpleDnDWorkbenchPanelView.class, inj2422_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UberView.class, SimpleDnDWorkbenchPanelView.class, inj2422_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, SimpleDnDWorkbenchPanelView.class, inj2422_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(RequiresResize.class, SimpleDnDWorkbenchPanelView.class, inj2422_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AbstractWorkbenchPanelView.class, SimpleDnDWorkbenchPanelView.class, inj2422_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ResizeComposite.class, SimpleDnDWorkbenchPanelView.class, inj2422_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Composite.class, SimpleDnDWorkbenchPanelView.class, inj2422_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, SimpleDnDWorkbenchPanelView.class, inj2422_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, SimpleDnDWorkbenchPanelView.class, inj2422_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, SimpleDnDWorkbenchPanelView.class, inj2422_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, SimpleDnDWorkbenchPanelView.class, inj2422_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, SimpleDnDWorkbenchPanelView.class, inj2422_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, SimpleDnDWorkbenchPanelView.class, inj2422_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, SimpleDnDWorkbenchPanelView.class, inj2422_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(MultiListWorkbenchPanelView.class, MultiListWorkbenchPanelView.class, inj2424_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_381280622, "MultiListWorkbenchPanelView", true);
    injContext.addBean(AbstractMultiPartWorkbenchPanelView.class, MultiListWorkbenchPanelView.class, inj2424_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_381280622, "MultiListWorkbenchPanelView", false);
    injContext.addBean(AbstractDockingWorkbenchPanelView.class, MultiListWorkbenchPanelView.class, inj2424_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_381280622, null, false);
    injContext.addBean(DockingWorkbenchPanelView.class, MultiListWorkbenchPanelView.class, inj2424_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_381280622, null, false);
    injContext.addBean(WorkbenchPanelView.class, MultiListWorkbenchPanelView.class, inj2424_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_381280622, null, false);
    injContext.addBean(UberView.class, MultiListWorkbenchPanelView.class, inj2424_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_381280622, null, false);
    injContext.addBean(IsWidget.class, MultiListWorkbenchPanelView.class, inj2424_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_381280622, null, false);
    injContext.addBean(RequiresResize.class, MultiListWorkbenchPanelView.class, inj2424_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_381280622, null, false);
    injContext.addBean(AbstractWorkbenchPanelView.class, MultiListWorkbenchPanelView.class, inj2424_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_381280622, null, false);
    injContext.addBean(ResizeComposite.class, MultiListWorkbenchPanelView.class, inj2424_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_381280622, null, false);
    injContext.addBean(Composite.class, MultiListWorkbenchPanelView.class, inj2424_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_381280622, null, false);
    injContext.addBean(IsRenderable.class, MultiListWorkbenchPanelView.class, inj2424_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_381280622, null, false);
    injContext.addBean(Widget.class, MultiListWorkbenchPanelView.class, inj2424_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_381280622, null, false);
    injContext.addBean(EventListener.class, MultiListWorkbenchPanelView.class, inj2424_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_381280622, null, false);
    injContext.addBean(HasAttachHandlers.class, MultiListWorkbenchPanelView.class, inj2424_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_381280622, null, false);
    injContext.addBean(HasHandlers.class, MultiListWorkbenchPanelView.class, inj2424_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_381280622, null, false);
    injContext.addBean(UIObject.class, MultiListWorkbenchPanelView.class, inj2424_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_381280622, null, false);
    injContext.addBean(HasVisibility.class, MultiListWorkbenchPanelView.class, inj2424_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_381280622, null, false);
    injContext.addBean(ClosableSimpleWorkbenchPanelPresenter.class, ClosableSimpleWorkbenchPanelPresenter.class, inj2426_ClosableSimpleWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(AbstractDockingWorkbenchPanelPresenter.class, ClosableSimpleWorkbenchPanelPresenter.class, inj2426_ClosableSimpleWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DockingWorkbenchPanelPresenter.class, ClosableSimpleWorkbenchPanelPresenter.class, inj2426_ClosableSimpleWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchPanelPresenter.class, ClosableSimpleWorkbenchPanelPresenter.class, inj2426_ClosableSimpleWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AbstractWorkbenchPanelPresenter.class, ClosableSimpleWorkbenchPanelPresenter.class, inj2426_ClosableSimpleWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(RoleStyleBindingProvider.class, RoleStyleBindingProvider.class, inj2428_RoleStyleBindingProvider_creational, inj2427_RoleStyleBindingProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(AnyResourceType.class, AnyResourceType.class, inj2430_AnyResourceType_creational, inj2429_AnyResourceType, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ClientResourceType.class, AnyResourceType.class, inj2430_AnyResourceType_creational, inj2429_AnyResourceType, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ResourceTypeDefinition.class, AnyResourceType.class, inj2430_AnyResourceType_creational, inj2429_AnyResourceType, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AnyResourceTypeDefinition.class, AnyResourceType.class, inj2430_AnyResourceType_creational, inj2429_AnyResourceType, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AdaptiveWorkbenchPanelPresenter.class, AdaptiveWorkbenchPanelPresenter.class, inj2432_AdaptiveWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(AbstractDockingWorkbenchPanelPresenter.class, AdaptiveWorkbenchPanelPresenter.class, inj2432_AdaptiveWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DockingWorkbenchPanelPresenter.class, AdaptiveWorkbenchPanelPresenter.class, inj2432_AdaptiveWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchPanelPresenter.class, AdaptiveWorkbenchPanelPresenter.class, inj2432_AdaptiveWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AbstractWorkbenchPanelPresenter.class, AdaptiveWorkbenchPanelPresenter.class, inj2432_AdaptiveWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SimpleWorkbenchPanelPresenter.class, SimpleWorkbenchPanelPresenter.class, inj2434_SimpleWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(AbstractDockingWorkbenchPanelPresenter.class, SimpleWorkbenchPanelPresenter.class, inj2434_SimpleWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DockingWorkbenchPanelPresenter.class, SimpleWorkbenchPanelPresenter.class, inj2434_SimpleWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchPanelPresenter.class, SimpleWorkbenchPanelPresenter.class, inj2434_SimpleWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AbstractWorkbenchPanelPresenter.class, SimpleWorkbenchPanelPresenter.class, inj2434_SimpleWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DotResourceType.class, DotResourceType.class, inj2436_DotResourceType_creational, inj2435_DotResourceType, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ClientResourceType.class, DotResourceType.class, inj2436_DotResourceType_creational, inj2435_DotResourceType, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ResourceTypeDefinition.class, DotResourceType.class, inj2436_DotResourceType_creational, inj2435_DotResourceType, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DotResourceTypeDefinition.class, DotResourceType.class, inj2436_DotResourceType_creational, inj2435_DotResourceType, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SplashScreenJSExporter.class, SplashScreenJSExporter.class, inj2438_SplashScreenJSExporter_creational, inj2437_SplashScreenJSExporter, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(UberfireJSExporter.class, SplashScreenJSExporter.class, inj2438_SplashScreenJSExporter_creational, inj2437_SplashScreenJSExporter, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(PerspectiveJSExporter.class, PerspectiveJSExporter.class, inj2440_PerspectiveJSExporter_creational, inj2439_PerspectiveJSExporter, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(UberfireJSExporter.class, PerspectiveJSExporter.class, inj2440_PerspectiveJSExporter_creational, inj2439_PerspectiveJSExporter, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ErrorPopupPresenter.class, ErrorPopupPresenter.class, inj2442_ErrorPopupPresenter_creational, inj2441_ErrorPopupPresenter, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(WorkbenchBackendEntryPoint.class, WorkbenchBackendEntryPoint.class, inj2444_WorkbenchBackendEntryPoint_creational, inj2443_WorkbenchBackendEntryPoint, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(MoodScreen.class, MoodScreen.class, inj2446_MoodScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Composite.class, MoodScreen.class, inj2446_MoodScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, MoodScreen.class, inj2446_MoodScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, MoodScreen.class, inj2446_MoodScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, MoodScreen.class, inj2446_MoodScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, MoodScreen.class, inj2446_MoodScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, MoodScreen.class, inj2446_MoodScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, MoodScreen.class, inj2446_MoodScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
  }

  private void declareBeans_2() {
    injContext.addBean(UIObject.class, MoodScreen.class, inj2446_MoodScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, MoodScreen.class, inj2446_MoodScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ShowcaseEntryPoint.class, ShowcaseEntryPoint.class, inj2448_ShowcaseEntryPoint_creational, inj2447_ShowcaseEntryPoint, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(SecurityContextHoldingSingleton.class, SecurityContextHoldingSingleton.class, inj2450_SecurityContextHoldingSingleton_creational, inj2449_SecurityContextHoldingSingleton, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(WorkbenchViewModeSwitcherPresenter.class, WorkbenchViewModeSwitcherPresenter.class, inj2452_WorkbenchViewModeSwitcherPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(IsWidget.class, WorkbenchViewModeSwitcherPresenter.class, inj2452_WorkbenchViewModeSwitcherPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SecurityEntryPoint.class, SecurityEntryPoint.class, inj2454_SecurityEntryPoint_creational, inj2453_SecurityEntryPoint, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(UtilityMenuBarPresenter.class, UtilityMenuBarPresenter.class, inj2456_UtilityMenuBarPresenter_creational, inj2455_UtilityMenuBarPresenter, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(UtilityMenuBar.class, UtilityMenuBarPresenter.class, inj2456_UtilityMenuBarPresenter_creational, inj2455_UtilityMenuBarPresenter, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMenus.class, UtilityMenuBarPresenter.class, inj2456_UtilityMenuBarPresenter_creational, inj2455_UtilityMenuBarPresenter, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(MultiTabWorkbenchPanelPresenter.class, MultiTabWorkbenchPanelPresenter.class, inj2458_MultiTabWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(AbstractMultiPartWorkbenchPanelPresenter.class, MultiTabWorkbenchPanelPresenter.class, inj2458_MultiTabWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AbstractDockingWorkbenchPanelPresenter.class, MultiTabWorkbenchPanelPresenter.class, inj2458_MultiTabWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DockingWorkbenchPanelPresenter.class, MultiTabWorkbenchPanelPresenter.class, inj2458_MultiTabWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchPanelPresenter.class, MultiTabWorkbenchPanelPresenter.class, inj2458_MultiTabWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AbstractWorkbenchPanelPresenter.class, MultiTabWorkbenchPanelPresenter.class, inj2458_MultiTabWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchPartView.class, WorkbenchPartView.class, inj2461_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(org.uberfire.client.workbench.part.WorkbenchPartPresenter.View.class, WorkbenchPartView.class, inj2461_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UberView.class, WorkbenchPartView.class, inj2461_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, WorkbenchPartView.class, inj2461_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(RequiresResize.class, WorkbenchPartView.class, inj2461_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SimpleLayoutPanel.class, WorkbenchPartView.class, inj2461_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ProvidesResize.class, WorkbenchPartView.class, inj2461_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SimplePanel.class, WorkbenchPartView.class, inj2461_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasOneWidget.class, WorkbenchPartView.class, inj2461_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AcceptsOneWidget.class, WorkbenchPartView.class, inj2461_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Panel.class, WorkbenchPartView.class, inj2461_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ForIsWidget.class, WorkbenchPartView.class, inj2461_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasWidgets.class, WorkbenchPartView.class, inj2461_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Iterable.class, WorkbenchPartView.class, inj2461_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, WorkbenchPartView.class, inj2461_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, WorkbenchPartView.class, inj2461_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, WorkbenchPartView.class, inj2461_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, WorkbenchPartView.class, inj2461_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, WorkbenchPartView.class, inj2461_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, WorkbenchPartView.class, inj2461_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchPartPresenterDefault.class, WorkbenchPartPresenterDefault.class, inj2460_WorkbenchPartPresenterDefault_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(WorkbenchPartPresenter.class, WorkbenchPartPresenterDefault.class, inj2460_WorkbenchPartPresenterDefault_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ComponentPresenterActivity.class, ComponentPresenterActivity.class, inj2463_ComponentPresenterActivity_creational, null, arrayOf_19635043Annotation_1553332319, "ComponentPresenter", true);
    injContext.addBean(AbstractWorkbenchScreenActivity.class, ComponentPresenterActivity.class, inj2463_ComponentPresenterActivity_creational, null, arrayOf_19635043Annotation_1553332319, "ComponentPresenter", false);
    injContext.addBean(WorkbenchScreenActivity.class, ComponentPresenterActivity.class, inj2463_ComponentPresenterActivity_creational, null, arrayOf_19635043Annotation_1553332319, null, false);
    injContext.addBean(WorkbenchActivity.class, ComponentPresenterActivity.class, inj2463_ComponentPresenterActivity_creational, null, arrayOf_19635043Annotation_1553332319, null, false);
    injContext.addBean(ContextSensitiveActivity.class, ComponentPresenterActivity.class, inj2463_ComponentPresenterActivity_creational, null, arrayOf_19635043Annotation_1553332319, null, false);
    injContext.addBean(Activity.class, ComponentPresenterActivity.class, inj2463_ComponentPresenterActivity_creational, null, arrayOf_19635043Annotation_1553332319, null, false);
    injContext.addBean(RuntimeFeatureResource.class, ComponentPresenterActivity.class, inj2463_ComponentPresenterActivity_creational, null, arrayOf_19635043Annotation_1553332319, null, false);
    injContext.addBean(RuntimeResource.class, ComponentPresenterActivity.class, inj2463_ComponentPresenterActivity_creational, null, arrayOf_19635043Annotation_1553332319, null, false);
    injContext.addBean(Resource.class, ComponentPresenterActivity.class, inj2463_ComponentPresenterActivity_creational, null, arrayOf_19635043Annotation_1553332319, null, false);
    injContext.addBean(AbstractWorkbenchActivity.class, ComponentPresenterActivity.class, inj2463_ComponentPresenterActivity_creational, null, arrayOf_19635043Annotation_1553332319, null, false);
    injContext.addBean(AbstractActivity.class, ComponentPresenterActivity.class, inj2463_ComponentPresenterActivity_creational, null, arrayOf_19635043Annotation_1553332319, null, false);
    injContext.addBean(PopupViewImpl.class, PopupViewImpl.class, inj2465_PopupViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(PopupView.class, PopupViewImpl.class, inj2465_PopupViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasCloseHandlers.class, PopupViewImpl.class, inj2465_PopupViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, PopupViewImpl.class, inj2465_PopupViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Composite.class, PopupViewImpl.class, inj2465_PopupViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, PopupViewImpl.class, inj2465_PopupViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, PopupViewImpl.class, inj2465_PopupViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, PopupViewImpl.class, inj2465_PopupViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, PopupViewImpl.class, inj2465_PopupViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, PopupViewImpl.class, inj2465_PopupViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, PopupViewImpl.class, inj2465_PopupViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, PopupViewImpl.class, inj2465_PopupViewImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(InitBallotProvider.class, InitBallotProvider.class, inj2466_InitBallotProvider_creational, inj2157_InitBallotProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ContextualTypeProvider.class, InitBallotProvider.class, inj2466_InitBallotProvider_creational, inj2157_InitBallotProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(JSNativeScreen.class, JSNativeScreen.class, inj2468_JSNativeScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(JSNativePlugin.class, JSNativeScreen.class, inj2468_JSNativeScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(CustomSplashHelp.class, CustomSplashHelp.class, inj2470_CustomSplashHelp_creational, inj2469_CustomSplashHelp, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(CustomMenuBuilder.class, CustomSplashHelp.class, inj2470_CustomSplashHelp_creational, inj2469_CustomSplashHelp, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(JSEntryPoint.class, JSEntryPoint.class, inj2472_JSEntryPoint_creational, inj2471_JSEntryPoint, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(JSNativeSplashScreen.class, JSNativeSplashScreen.class, inj2474_JSNativeSplashScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(JSNativePlugin.class, JSNativeSplashScreen.class, inj2474_JSNativeSplashScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(MainBrand.class, MainBrand.class, inj2151_MainBrand_creational, SimpleInjectionContext.LAZY_INIT_REF, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(IsWidget.class, MainBrand.class, inj2151_MainBrand_creational, SimpleInjectionContext.LAZY_INIT_REF, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ForceUnlockEventObserver.class, ForceUnlockEventObserver.class, inj2476_ForceUnlockEventObserver_creational, inj2475_ForceUnlockEventObserver, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(StaticWorkbenchPanelPresenter.class, StaticWorkbenchPanelPresenter.class, inj2478_StaticWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(AbstractWorkbenchPanelPresenter.class, StaticWorkbenchPanelPresenter.class, inj2478_StaticWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchPanelPresenter.class, StaticWorkbenchPanelPresenter.class, inj2478_StaticWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(MultiListWorkbenchPanelPresenter.class, MultiListWorkbenchPanelPresenter.class, inj2480_MultiListWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(AbstractMultiPartWorkbenchPanelPresenter.class, MultiListWorkbenchPanelPresenter.class, inj2480_MultiListWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AbstractDockingWorkbenchPanelPresenter.class, MultiListWorkbenchPanelPresenter.class, inj2480_MultiListWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DockingWorkbenchPanelPresenter.class, MultiListWorkbenchPanelPresenter.class, inj2480_MultiListWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchPanelPresenter.class, MultiListWorkbenchPanelPresenter.class, inj2480_MultiListWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AbstractWorkbenchPanelPresenter.class, MultiListWorkbenchPanelPresenter.class, inj2480_MultiListWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AccessImpl.class, AccessImpl.class, inj2482_AccessImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Access.class, AccessImpl.class, inj2482_AccessImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LifecycleEvent.class, AccessImpl.class, inj2482_AccessImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LifecycleEventImpl.class, AccessImpl.class, inj2482_AccessImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LifecycleEvent.class, AccessImpl.class, inj2482_AccessImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(CompassDropController.class, CompassDropController.class, inj2484_CompassDropController_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(DropController.class, CompassDropController.class, inj2484_CompassDropController_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ActivityNotFoundPresenter.class, ActivityNotFoundPresenter.class, inj2486_ActivityNotFoundPresenter_creational, inj2485_ActivityNotFoundPresenter, arrayOf_19635043Annotation_343148925, "uf.workbench.activity.notfound", true);
    injContext.addBean(AbstractPopupActivity.class, ActivityNotFoundPresenter.class, inj2486_ActivityNotFoundPresenter_creational, inj2485_ActivityNotFoundPresenter, arrayOf_19635043Annotation_343148925, "uf.workbench.activity.notfound", false);
    injContext.addBean(PopupActivity.class, ActivityNotFoundPresenter.class, inj2486_ActivityNotFoundPresenter_creational, inj2485_ActivityNotFoundPresenter, arrayOf_19635043Annotation_343148925, null, false);
    injContext.addBean(Activity.class, ActivityNotFoundPresenter.class, inj2486_ActivityNotFoundPresenter_creational, inj2485_ActivityNotFoundPresenter, arrayOf_19635043Annotation_343148925, null, false);
    injContext.addBean(RuntimeFeatureResource.class, ActivityNotFoundPresenter.class, inj2486_ActivityNotFoundPresenter_creational, inj2485_ActivityNotFoundPresenter, arrayOf_19635043Annotation_343148925, null, false);
    injContext.addBean(RuntimeResource.class, ActivityNotFoundPresenter.class, inj2486_ActivityNotFoundPresenter_creational, inj2485_ActivityNotFoundPresenter, arrayOf_19635043Annotation_343148925, null, false);
    injContext.addBean(Resource.class, ActivityNotFoundPresenter.class, inj2486_ActivityNotFoundPresenter_creational, inj2485_ActivityNotFoundPresenter, arrayOf_19635043Annotation_343148925, null, false);
    injContext.addBean(AbstractActivity.class, ActivityNotFoundPresenter.class, inj2486_ActivityNotFoundPresenter_creational, inj2485_ActivityNotFoundPresenter, arrayOf_19635043Annotation_343148925, null, false);
    injContext.addBean(MoodScreenActivity.class, MoodScreenActivity.class, inj2488_MoodScreenActivity_creational, null, arrayOf_19635043Annotation_335935540, "MoodScreen", true);
    injContext.addBean(AbstractWorkbenchScreenActivity.class, MoodScreenActivity.class, inj2488_MoodScreenActivity_creational, null, arrayOf_19635043Annotation_335935540, "MoodScreen", false);
    injContext.addBean(WorkbenchScreenActivity.class, MoodScreenActivity.class, inj2488_MoodScreenActivity_creational, null, arrayOf_19635043Annotation_335935540, null, false);
    injContext.addBean(WorkbenchActivity.class, MoodScreenActivity.class, inj2488_MoodScreenActivity_creational, null, arrayOf_19635043Annotation_335935540, null, false);
    injContext.addBean(ContextSensitiveActivity.class, MoodScreenActivity.class, inj2488_MoodScreenActivity_creational, null, arrayOf_19635043Annotation_335935540, null, false);
    injContext.addBean(Activity.class, MoodScreenActivity.class, inj2488_MoodScreenActivity_creational, null, arrayOf_19635043Annotation_335935540, null, false);
    injContext.addBean(RuntimeFeatureResource.class, MoodScreenActivity.class, inj2488_MoodScreenActivity_creational, null, arrayOf_19635043Annotation_335935540, null, false);
    injContext.addBean(RuntimeResource.class, MoodScreenActivity.class, inj2488_MoodScreenActivity_creational, null, arrayOf_19635043Annotation_335935540, null, false);
    injContext.addBean(Resource.class, MoodScreenActivity.class, inj2488_MoodScreenActivity_creational, null, arrayOf_19635043Annotation_335935540, null, false);
    injContext.addBean(AbstractWorkbenchActivity.class, MoodScreenActivity.class, inj2488_MoodScreenActivity_creational, null, arrayOf_19635043Annotation_335935540, null, false);
    injContext.addBean(AbstractActivity.class, MoodScreenActivity.class, inj2488_MoodScreenActivity_creational, null, arrayOf_19635043Annotation_335935540, null, false);
    injContext.addBean(SimpleDnDWorkbenchPanelPresenter.class, SimpleDnDWorkbenchPanelPresenter.class, inj2490_SimpleDnDWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(AbstractDockingWorkbenchPanelPresenter.class, SimpleDnDWorkbenchPanelPresenter.class, inj2490_SimpleDnDWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DockingWorkbenchPanelPresenter.class, SimpleDnDWorkbenchPanelPresenter.class, inj2490_SimpleDnDWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchPanelPresenter.class, SimpleDnDWorkbenchPanelPresenter.class, inj2490_SimpleDnDWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AbstractWorkbenchPanelPresenter.class, SimpleDnDWorkbenchPanelPresenter.class, inj2490_SimpleDnDWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DataBinderProvider.class, DataBinderProvider.class, inj2491_DataBinderProvider_creational, inj2153_DataBinderProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ContextualTypeProvider.class, DataBinderProvider.class, inj2491_DataBinderProvider_creational, inj2153_DataBinderProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(PartContextMenusView.class, PartContextMenusView.class, inj2493_PartContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(org.uberfire.client.workbench.widgets.menu.PartContextMenusPresenter.View.class, PartContextMenusView.class, inj2493_PartContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, PartContextMenusView.class, inj2493_PartContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Composite.class, PartContextMenusView.class, inj2493_PartContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, PartContextMenusView.class, inj2493_PartContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, PartContextMenusView.class, inj2493_PartContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, PartContextMenusView.class, inj2493_PartContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, PartContextMenusView.class, inj2493_PartContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, PartContextMenusView.class, inj2493_PartContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, PartContextMenusView.class, inj2493_PartContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, PartContextMenusView.class, inj2493_PartContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(PartContextMenusPresenter.class, PartContextMenusPresenter.class, inj2495_PartContextMenusPresenter_creational, inj2494_PartContextMenusPresenter, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(MultiPageEditorImpl.class, MultiPageEditorImpl.class, inj2497_MultiPageEditorImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(MultiPageEditor.class, MultiPageEditorImpl.class, inj2497_MultiPageEditorImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, MultiPageEditorImpl.class, inj2497_MultiPageEditorImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(TemplatedWorkbenchPanelPresenter.class, TemplatedWorkbenchPanelPresenter.class, inj2499_TemplatedWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(AbstractWorkbenchPanelPresenter.class, TemplatedWorkbenchPanelPresenter.class, inj2499_TemplatedWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchPanelPresenter.class, TemplatedWorkbenchPanelPresenter.class, inj2499_TemplatedWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LifecycleListenerRegistrarImpl.class, LifecycleListenerRegistrarImpl.class, inj2501_LifecycleListenerRegistrarImpl_creational, inj2500_LifecycleListenerRegistrarImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(LifecycleListenerRegistrar.class, LifecycleListenerRegistrarImpl.class, inj2501_LifecycleListenerRegistrarImpl_creational, inj2500_LifecycleListenerRegistrarImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(MoodListenerScreenActivity.class, MoodListenerScreenActivity.class, inj2503_MoodListenerScreenActivity_creational, null, arrayOf_19635043Annotation_594926657, "MoodListenerScreen", true);
    injContext.addBean(AbstractWorkbenchScreenActivity.class, MoodListenerScreenActivity.class, inj2503_MoodListenerScreenActivity_creational, null, arrayOf_19635043Annotation_594926657, "MoodListenerScreen", false);
    injContext.addBean(WorkbenchScreenActivity.class, MoodListenerScreenActivity.class, inj2503_MoodListenerScreenActivity_creational, null, arrayOf_19635043Annotation_594926657, null, false);
    injContext.addBean(WorkbenchActivity.class, MoodListenerScreenActivity.class, inj2503_MoodListenerScreenActivity_creational, null, arrayOf_19635043Annotation_594926657, null, false);
    injContext.addBean(ContextSensitiveActivity.class, MoodListenerScreenActivity.class, inj2503_MoodListenerScreenActivity_creational, null, arrayOf_19635043Annotation_594926657, null, false);
    injContext.addBean(Activity.class, MoodListenerScreenActivity.class, inj2503_MoodListenerScreenActivity_creational, null, arrayOf_19635043Annotation_594926657, null, false);
    injContext.addBean(RuntimeFeatureResource.class, MoodListenerScreenActivity.class, inj2503_MoodListenerScreenActivity_creational, null, arrayOf_19635043Annotation_594926657, null, false);
    injContext.addBean(RuntimeResource.class, MoodListenerScreenActivity.class, inj2503_MoodListenerScreenActivity_creational, null, arrayOf_19635043Annotation_594926657, null, false);
    injContext.addBean(Resource.class, MoodListenerScreenActivity.class, inj2503_MoodListenerScreenActivity_creational, null, arrayOf_19635043Annotation_594926657, null, false);
    injContext.addBean(AbstractWorkbenchActivity.class, MoodListenerScreenActivity.class, inj2503_MoodListenerScreenActivity_creational, null, arrayOf_19635043Annotation_594926657, null, false);
    injContext.addBean(AbstractActivity.class, MoodListenerScreenActivity.class, inj2503_MoodListenerScreenActivity_creational, null, arrayOf_19635043Annotation_594926657, null, false);
  }

  private native static void _$292735039__597466346_identity(WorkbenchMenuBarPresenter instance, User value) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarPresenter::identity = value;
  }-*/;

  private native static void _1095151889__960584674_realPresenter(HelloWorldScreenActivity instance, HelloWorldScreen value) /*-{
    instance.@org.uberfire.client.screens.HelloWorldScreenActivity::realPresenter = value;
  }-*/;

  private native static void _$1757102468__1047951015_placeHistoryHandler(PlaceManagerImpl instance, PlaceHistoryHandler value) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::placeHistoryHandler = value;
  }-*/;

  private native static void _2052955140__1116818801_newWorkbenchScreenEventEvent(ActivityBeansCache instance, Event<NewWorkbenchScreenEvent> value) /*-{
    instance.@org.uberfire.client.mvp.ActivityBeansCache::newWorkbenchScreenEventEvent = value;
  }-*/;

  private native static void _$292735039__$1574799830_authzManager(WorkbenchMenuBarPresenter instance, AuthorizationManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarPresenter::authzManager = value;
  }-*/;

  private native static Button _2112332982__534146328_closeButton(SplashModalFooter instance) /*-{
    return instance.@org.uberfire.client.views.pfly.splash.SplashModalFooter::closeButton;
  }-*/;

  private native static void _2112332982__534146328_closeButton(SplashModalFooter instance, Button value) /*-{
    instance.@org.uberfire.client.views.pfly.splash.SplashModalFooter::closeButton = value;
  }-*/;

  private native static void _$662927178__$2073863603_runtimePluginsService(JSEntryPoint instance, RuntimePluginsServiceProxy value) /*-{
    instance.@org.uberfire.client.JSEntryPoint::runtimePluginsService = value;
  }-*/;

  private native static void _1730935432__$1574799830_authzManager(ActivityManagerImpl instance, AuthorizationManager value) /*-{
    instance.@org.uberfire.client.mvp.ActivityManagerImpl::authzManager = value;
  }-*/;

  private native static void _$1422416569__120980481_vfsService(VFSServiceProxyBackendImpl instance, Caller<VFSService> value) /*-{
    instance.@org.uberfire.client.VFSServiceProxyBackendImpl::vfsService = value;
  }-*/;

  private native static void _$1397438695__$1825231548_layoutSelection(AbstractWorkbenchPanelView instance, LayoutSelection value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.AbstractWorkbenchPanelView::layoutSelection = value;
  }-*/;

  private native static void _618642634__153624969_dndManager(AbstractDockingWorkbenchPanelView instance, WorkbenchDragAndDropManager value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.AbstractDockingWorkbenchPanelView::dndManager = value;
  }-*/;

  private native static void _1934862923__$652658075_iocManager(WorkbenchLayoutImpl instance, SyncBeanManager value) /*-{
    instance.@org.uberfire.client.workbench.WorkbenchLayoutImpl::iocManager = value;
  }-*/;

  private native static void _31024108__910953042_lockDemandDetector(LockManagerImpl instance, LockDemandDetector value) /*-{
    instance.@org.uberfire.client.mvp.LockManagerImpl::lockDemandDetector = value;
  }-*/;

  private native static void _2052955140__$652658075_iocManager(ActivityBeansCache instance, SyncBeanManager value) /*-{
    instance.@org.uberfire.client.mvp.ActivityBeansCache::iocManager = value;
  }-*/;

  private native static void _$1316152188__$1574799830_authzManager(ListBarWidgetImpl instance, AuthorizationManager value) /*-{
    instance.@org.uberfire.client.views.pfly.listbar.ListBarWidgetImpl::authzManager = value;
  }-*/;

  private native static void _$292735039__$1335679257_perspectiveManager(WorkbenchMenuBarPresenter instance, PerspectiveManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarPresenter::perspectiveManager = value;
  }-*/;

  private native static TextBox _1025798413__$371269162_moodTextBox(MoodListenerScreen instance) /*-{
    return instance.@org.uberfire.client.screens.MoodListenerScreen::moodTextBox;
  }-*/;

  private native static void _1025798413__$371269162_moodTextBox(MoodListenerScreen instance, TextBox value) /*-{
    instance.@org.uberfire.client.screens.MoodListenerScreen::moodTextBox = value;
  }-*/;

  private native static void _$1757102468__$1934524921_lifecycleErrorHandler(PlaceManagerImpl instance, ActivityLifecycleErrorHandler value) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::lifecycleErrorHandler = value;
  }-*/;

  private native static void _$1462522111__$715182114_vfsService(Workbench instance, VFSServiceProxy value) /*-{
    instance.@org.uberfire.client.workbench.Workbench::vfsService = value;
  }-*/;

  private native static void _$662927178__$1462522111_workbench(JSEntryPoint instance, Workbench value) /*-{
    instance.@org.uberfire.client.JSEntryPoint::workbench = value;
  }-*/;

  private native static void _378913974__1388723237_logger(SecurityContextImpl instance, Logger value) /*-{
    instance.@org.jboss.errai.security.client.local.context.SecurityContextImpl::logger = value;
  }-*/;

  private native static void _1420226898__443136474_partManager(LayoutPanelView instance, PartManager value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.LayoutPanelView::partManager = value;
  }-*/;

  private native static void _$896357979__$1655162226_panel(StaticWorkbenchPanelView instance, StaticFocusedResizePanel value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.StaticWorkbenchPanelView::panel = value;
  }-*/;

  private native static void _1084732347__314455785_loginTransition(SecurityRolesConstraintPage instance, TransitionToRole<LoginPage> value) /*-{
    instance.@org.jboss.errai.security.client.local.context.SecurityContextImpl.SecurityRolesConstraintPage::loginTransition = value;
  }-*/;

  private native static void _$1462522111__1116818801_appReady(Workbench instance, Event<ApplicationReadyEvent> value) /*-{
    instance.@org.uberfire.client.workbench.Workbench::appReady = value;
  }-*/;

  private native static void _$1034438370__136504311_navigation(TransitionAnchorProvider instance, Navigation value) /*-{
    instance.@org.jboss.errai.ui.nav.client.local.TransitionAnchorProvider::navigation = value;
  }-*/;

  private native static void _$2124140384__$1574799830_authzManager(UtilityMenuBarView instance, AuthorizationManager value) /*-{
    instance.@org.uberfire.client.views.pfly.menu.UtilityMenuBarView::authzManager = value;
  }-*/;

  private native static void _1698844050__$906533316_placeManager(SplitLayoutPanelView instance, PlaceManager value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.SplitLayoutPanelView::placeManager = value;
  }-*/;

  private native static void _$14119216__597466346_identity(PartContextMenusView instance, User value) /*-{
    instance.@org.uberfire.client.views.pfly.menu.PartContextMenusView::identity = value;
  }-*/;

  private native static void _$1705636724__153624969_dndManager(CompassDropController instance, WorkbenchDragAndDropManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.dnd.CompassDropController::dndManager = value;
  }-*/;

  private native static void _683332058__153624969_dndManager(WorkbenchPickupDragController instance, WorkbenchDragAndDropManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.dnd.WorkbenchPickupDragController::dndManager = value;
  }-*/;

  private native static void _$623677011__$110318115_workbenchMenuStandardNavBarView(WorkbenchMenuBarView instance, WorkbenchMenuStandardNavBarView value) /*-{
    instance.@org.uberfire.client.views.pfly.menu.WorkbenchMenuBarView::workbenchMenuStandardNavBarView = value;
  }-*/;

  private native static void _73328378__$906533316_placeManager(ShowcaseEntryPoint instance, PlaceManager value) /*-{
    instance.@org.uberfire.client.ShowcaseEntryPoint::placeManager = value;
  }-*/;

  private native static void _1496760654__136504311_navigation(TransitionAnchorFactoryProvider instance, Navigation value) /*-{
    instance.@org.jboss.errai.ui.nav.client.local.TransitionAnchorFactoryProvider::navigation = value;
  }-*/;

  private native static void _$1462522111__$906533316_placeManager(Workbench instance, PlaceManager value) /*-{
    instance.@org.uberfire.client.workbench.Workbench::placeManager = value;
  }-*/;

  private native static void _$679243230__879292651_bus(WorkbenchBackendEntryPoint instance, ClientMessageBus value) /*-{
    instance.@org.uberfire.client.WorkbenchBackendEntryPoint::bus = value;
  }-*/;

  private native static void _$1732630359__803591648_view(ComponentPresenter instance, org.uberfire.component.client.ComponentPresenter.View value) /*-{
    instance.@org.uberfire.component.client.ComponentPresenter::view = value;
  }-*/;

  private native static void _1730935432__$652658075_iocManager(ActivityManagerImpl instance, SyncBeanManager value) /*-{
    instance.@org.uberfire.client.mvp.ActivityManagerImpl::iocManager = value;
  }-*/;

  private native static void _618642634__$1887041540_factory(AbstractDockingWorkbenchPanelView instance, BeanFactory value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.AbstractDockingWorkbenchPanelView::factory = value;
  }-*/;

  private native static void _$1034438370__515581186_htFactory(TransitionAnchorProvider instance, HistoryTokenFactory value) /*-{
    instance.@org.jboss.errai.ui.nav.client.local.TransitionAnchorProvider::htFactory = value;
  }-*/;

  private native static void _$1934524921__383150079_notificationManager(ActivityLifecycleErrorHandler instance, NotificationManager value) /*-{
    instance.@org.uberfire.client.mvp.ActivityLifecycleErrorHandler::notificationManager = value;
  }-*/;

  private native static void _684448251__$906533316_placeManager(JSNativePerspective instance, PlaceManager value) /*-{
    instance.@org.uberfire.client.perspective.JSNativePerspective::placeManager = value;
  }-*/;

  private native static void _1346204971__$924432381_listBar(AbstractSimpleWorkbenchPanelView instance, ListBarWidget value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.AbstractSimpleWorkbenchPanelView::listBar = value;
  }-*/;

  private native static void _1350680564__$1232121576_selector(LocaleListBox instance, LocaleSelector value) /*-{
    instance.@org.jboss.errai.ui.client.widget.LocaleListBox::selector = value;
  }-*/;

  private native static void _$1757102468__1116818801_selectWorkbenchPartEvent(PlaceManagerImpl instance, Event<SelectPlaceEvent> value) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::selectWorkbenchPartEvent = value;
  }-*/;

  private native static void _618642634__$634457504_topLevelWidget(AbstractDockingWorkbenchPanelView instance, SimpleLayoutPanel value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.AbstractDockingWorkbenchPanelView::topLevelWidget = value;
  }-*/;

  private native static void _1420226898__$1825231548_layoutSelection(LayoutPanelView instance, LayoutSelection value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.LayoutPanelView::layoutSelection = value;
  }-*/;

  private native static void _1150956601__1116818801_moodEvent(MoodScreen instance, Event<Mood> value) /*-{
    instance.@org.uberfire.client.screens.MoodScreen::moodEvent = value;
  }-*/;

  private native static void _40974972__$1426067475_view(WorkbenchToolBarPresenter instance, org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarPresenter.View value) /*-{
    instance.@org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarPresenter::view = value;
  }-*/;

  private native static void _$896357979__$906533316_placeManager(StaticWorkbenchPanelView instance, PlaceManager value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.StaticWorkbenchPanelView::placeManager = value;
  }-*/;

  private native static void _1135152903__879292651_bus(SecurityEntryPoint instance, ClientMessageBus value) /*-{
    instance.@org.uberfire.security.client.SecurityEntryPoint::bus = value;
  }-*/;

  private native static void _$780895853__158751832_view(MultiPageEditorImpl instance, MultiPageEditorViewImpl value) /*-{
    instance.@org.uberfire.client.views.pfly.multipage.MultiPageEditorImpl::view = value;
  }-*/;

  private native static void _$1702547732__1274864829_realPresenter(MoodPerspectiveActivity instance, MoodPerspective value) /*-{
    instance.@org.uberfire.client.perspectives.MoodPerspectiveActivity::realPresenter = value;
  }-*/;

  private native static void _$1757102468__1116818801_workbenchPartBeforeCloseEvent(PlaceManagerImpl instance, Event<BeforeClosePlaceEvent> value) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::workbenchPartBeforeCloseEvent = value;
  }-*/;

  private native static void _1653100451__$262319993_panelManager(AbstractDockingWorkbenchPanelPresenter instance, PanelManager value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.AbstractDockingWorkbenchPanelPresenter::panelManager = value;
  }-*/;

  private native static void _$1397438695__$262319993_panelManager(AbstractWorkbenchPanelView instance, PanelManager value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.AbstractWorkbenchPanelView::panelManager = value;
  }-*/;

  private native static void _$680440259__$1574799830_authzManager(UserMenu instance, AuthorizationManager value) /*-{
    instance.@org.uberfire.client.views.pfly.menu.UserMenu::authzManager = value;
  }-*/;

  private native static void _$2124140384__597466346_identity(UtilityMenuBarView instance, User value) /*-{
    instance.@org.uberfire.client.views.pfly.menu.UtilityMenuBarView::identity = value;
  }-*/;

  private native static void _1549975964__120980481_vfsLockService(VFSLockServiceProxyBackendImpl instance, Caller<VFSLockService> value) /*-{
    instance.@org.uberfire.client.VFSLockServiceProxyBackendImpl::vfsLockService = value;
  }-*/;

  private native static void _474272692__$924432381_listBar(MultiListWorkbenchPanelView instance, ListBarWidget value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.MultiListWorkbenchPanelView::listBar = value;
  }-*/;

  private native static void _$680440259__597466346_user(UserMenu instance, User value) /*-{
    instance.@org.uberfire.client.views.pfly.menu.UserMenu::user = value;
  }-*/;

  private native static void _$274999170__154256171_view(PartContextMenusPresenter instance, org.uberfire.client.workbench.widgets.menu.PartContextMenusPresenter.View value) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.PartContextMenusPresenter::view = value;
  }-*/;

  private native static void _$680440259__804064438_userMenuView(UserMenu instance, UserMenuView value) /*-{
    instance.@org.uberfire.client.views.pfly.menu.UserMenu::userMenuView = value;
  }-*/;

  private native static void _136504311__2062761173_navGraph(Navigation instance, NavigationGraph value) /*-{
    instance.@org.jboss.errai.ui.nav.client.local.Navigation::navGraph = value;
  }-*/;

  private native static void _378913974__1116818801_logoutEvent(SecurityContextImpl instance, Event<LoggedOutEvent> value) /*-{
    instance.@org.jboss.errai.security.client.local.context.SecurityContextImpl::logoutEvent = value;
  }-*/;

  private native static void _$111792914__434812091_view(UtilityMenuBarPresenter instance, org.uberfire.client.workbench.widgets.menu.UtilityMenuBarPresenter.View value) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.UtilityMenuBarPresenter::view = value;
  }-*/;

  private native static void _$1300398733__$652658075_beanManager(DisposerProvider instance, SyncBeanManager value) /*-{
    instance.@org.jboss.errai.ioc.client.api.builtin.DisposerProvider::beanManager = value;
  }-*/;

  private native static void _$163699945__$1553627672_modal(SplashViewImpl instance, Bs3Modal value) /*-{
    instance.@org.uberfire.client.views.pfly.splash.SplashViewImpl::modal = value;
  }-*/;

  private native static void _$1462522111__$652658075_iocManager(Workbench instance, SyncBeanManager value) /*-{
    instance.@org.uberfire.client.workbench.Workbench::iocManager = value;
  }-*/;

  private native static void _$348507737__$304677073_wbServices(PerspectiveManagerImpl instance, WorkbenchServicesProxy value) /*-{
    instance.@org.uberfire.client.mvp.PerspectiveManagerImpl::wbServices = value;
  }-*/;

  private native static void _663569186__1388723237_logger(BasicUserCacheImpl instance, Logger value) /*-{
    instance.@org.jboss.errai.security.client.local.context.BasicUserCacheImpl::logger = value;
  }-*/;

  private native static void _$292735039__1201173960_view(WorkbenchMenuBarPresenter instance, org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarPresenter.View value) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarPresenter::view = value;
  }-*/;

  private native static void _1174169399__$652658075_iocManager(DefaultBeanFactory instance, SyncBeanManager value) /*-{
    instance.@org.uberfire.client.workbench.DefaultBeanFactory::iocManager = value;
  }-*/;

  private native static void _$14119216__$1574799830_authzManager(PartContextMenusView instance, AuthorizationManager value) /*-{
    instance.@org.uberfire.client.views.pfly.menu.PartContextMenusView::authzManager = value;
  }-*/;

  private native static void _$623677011__$2124140384_utilityMenuBarView(WorkbenchMenuBarView instance, UtilityMenuBarView value) /*-{
    instance.@org.uberfire.client.views.pfly.menu.WorkbenchMenuBarView::utilityMenuBarView = value;
  }-*/;

  private native static void _$1304194947__291376327_sessionInfo(ObservablePathImpl instance, SessionInfo value) /*-{
    instance.@org.uberfire.backend.vfs.impl.ObservablePathImpl::sessionInfo = value;
  }-*/;

  private native static void _$1705636724__$262319993_panelManager(CompassDropController instance, PanelManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.dnd.CompassDropController::panelManager = value;
  }-*/;

  private native static void _378913974__$282317259_userCache(SecurityContextImpl instance, ActiveUserCache value) /*-{
    instance.@org.jboss.errai.security.client.local.context.SecurityContextImpl::userCache = value;
  }-*/;

  private native static void _1934862923__683332058_dragController(WorkbenchLayoutImpl instance, WorkbenchPickupDragController value) /*-{
    instance.@org.uberfire.client.workbench.WorkbenchLayoutImpl::dragController = value;
  }-*/;

  private native static void _$1786166680__1150956601_realPresenter(MoodScreenActivity instance, MoodScreen value) /*-{
    instance.@org.uberfire.client.screens.MoodScreenActivity::realPresenter = value;
  }-*/;

  private native static void _$1934524921__1116818801_lifecycleErrorEvent(ActivityLifecycleErrorHandler instance, Event<ActivityLifecycleError> value) /*-{
    instance.@org.uberfire.client.mvp.ActivityLifecycleErrorHandler::lifecycleErrorEvent = value;
  }-*/;

  private native static void _$1757102468__$262319993_panelManager(PlaceManagerImpl instance, PanelManager value) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::panelManager = value;
  }-*/;

  private native static void _$1705636724__1116818801_workbenchPartDroppedEvent(CompassDropController instance, Event<DropPlaceEvent> value) /*-{
    instance.@org.uberfire.client.workbench.widgets.dnd.CompassDropController::workbenchPartDroppedEvent = value;
  }-*/;

  private native static void _918776636__1025798413_realPresenter(MoodListenerScreenActivity instance, MoodListenerScreen value) /*-{
    instance.@org.uberfire.client.screens.MoodListenerScreenActivity::realPresenter = value;
  }-*/;

  private native static void _663569186__$1444549593_userStorageHandler(BasicUserCacheImpl instance, UserStorageHandler value) /*-{
    instance.@org.jboss.errai.security.client.local.context.BasicUserCacheImpl::userStorageHandler = value;
  }-*/;

  private native static void _1730935432__2052955140_activityBeansCache(ActivityManagerImpl instance, ActivityBeansCache value) /*-{
    instance.@org.uberfire.client.mvp.ActivityManagerImpl::activityBeansCache = value;
  }-*/;

  private native static void _$163699945__2112332982_footer(SplashViewImpl instance, SplashModalFooter value) /*-{
    instance.@org.uberfire.client.views.pfly.splash.SplashViewImpl::footer = value;
  }-*/;

  private native static void _153624969__683332058_dragController(WorkbenchDragAndDropManager instance, WorkbenchPickupDragController value) /*-{
    instance.@org.uberfire.client.workbench.widgets.dnd.WorkbenchDragAndDropManager::dragController = value;
  }-*/;

  private native static void _$292735039__$1583970232_activityManager(WorkbenchMenuBarPresenter instance, ActivityManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarPresenter::activityManager = value;
  }-*/;

  private native static void _40974972__$906533316_placeManager(WorkbenchToolBarPresenter instance, PlaceManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarPresenter::placeManager = value;
  }-*/;

  private native static void _73328378__$351881561_menubar(ShowcaseEntryPoint instance, WorkbenchMenuBar value) /*-{
    instance.@org.uberfire.client.ShowcaseEntryPoint::menubar = value;
  }-*/;

  private native static void _136504311__1388723237_logger(Navigation instance, Logger value) /*-{
    instance.@org.jboss.errai.ui.nav.client.local.Navigation::logger = value;
  }-*/;

  private native static void _$1933089096__1388723237_logger(RuntimePluginsServiceProxyClientImpl instance, Logger value) /*-{
    instance.@org.uberfire.client.plugin.RuntimePluginsServiceProxyClientImpl::logger = value;
  }-*/;

  private native static void _1698844050__$1825231548_layoutSelection(SplitLayoutPanelView instance, LayoutSelection value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.SplitLayoutPanelView::layoutSelection = value;
  }-*/;

  private native static void _$348507737__$262319993_panelManager(PerspectiveManagerImpl instance, PanelManager value) /*-{
    instance.@org.uberfire.client.mvp.PerspectiveManagerImpl::panelManager = value;
  }-*/;

  private native static void _280033959__$1825231548_layoutSelection(TemplatedWorkbenchPanelView instance, LayoutSelection value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.TemplatedWorkbenchPanelView::layoutSelection = value;
  }-*/;

  private native static void _1033421399__848807465_lockService(ForceUnlockEventObserver instance, VFSLockServiceProxy value) /*-{
    instance.@org.uberfire.client.mvp.ForceUnlockEventObserver::lockService = value;
  }-*/;

  private native static void _$623677011__$1582791603_workbenchMenuCompactNavBarView(WorkbenchMenuBarView instance, WorkbenchMenuCompactNavBarView value) /*-{
    instance.@org.uberfire.client.views.pfly.menu.WorkbenchMenuBarView::workbenchMenuCompactNavBarView = value;
  }-*/;

  private native static void _$943894__$1480971077_realPresenter(MainPerspectiveActivity instance, MainPerspective value) /*-{
    instance.@org.uberfire.client.perspectives.MainPerspectiveActivity::realPresenter = value;
  }-*/;

  private native static void _596565460__120980481_workbenchServices(WorkbenchServicesProxyBackendImpl instance, Caller<WorkbenchServices> value) /*-{
    instance.@org.uberfire.client.WorkbenchServicesProxyBackendImpl::workbenchServices = value;
  }-*/;

  private native static void _$1462522111__$1825231548_layoutSelection(Workbench instance, LayoutSelection value) /*-{
    instance.@org.uberfire.client.workbench.Workbench::layoutSelection = value;
  }-*/;

  private native static TextBox _1150956601__$371269162_moodTextBox(MoodScreen instance) /*-{
    return instance.@org.uberfire.client.screens.MoodScreen::moodTextBox;
  }-*/;

  private native static void _1150956601__$371269162_moodTextBox(MoodScreen instance, TextBox value) /*-{
    instance.@org.uberfire.client.screens.MoodScreen::moodTextBox = value;
  }-*/;

  private native static void _$1757102468__$1583970232_activityManager(PlaceManagerImpl instance, ActivityManager value) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::activityManager = value;
  }-*/;

  private native static void _$348507737__1116818801_perspectiveChangeEvent(PerspectiveManagerImpl instance, Event<PerspectiveChange> value) /*-{
    instance.@org.uberfire.client.mvp.PerspectiveManagerImpl::perspectiveChangeEvent = value;
  }-*/;

  private native static void _$1316152188__$903668163_optionalListBarPrefs(ListBarWidgetImpl instance, Instance<ListbarPreferences> value) /*-{
    instance.@org.uberfire.client.views.pfly.listbar.ListBarWidgetImpl::optionalListBarPrefs = value;
  }-*/;

  private native static void _684448251__$304677073_wbServices(JSNativePerspective instance, WorkbenchServicesProxy value) /*-{
    instance.@org.uberfire.client.perspective.JSNativePerspective::wbServices = value;
  }-*/;

  private native static void _$1757102468__$1335679257_perspectiveManager(PlaceManagerImpl instance, PerspectiveManager value) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::perspectiveManager = value;
  }-*/;

  private native static void _378913974__1116818801_loginEvent(SecurityContextImpl instance, Event<LoggedInEvent> value) /*-{
    instance.@org.jboss.errai.security.client.local.context.SecurityContextImpl::loginEvent = value;
  }-*/;

  private native static void _$1254526097__120980481_vfsServices(VFSJSExporter instance, Caller<VFSService> value) /*-{
    instance.@org.uberfire.client.exporter.VFSJSExporter::vfsServices = value;
  }-*/;

  private native static void _684448251__$1583970232_activityManager(JSNativePerspective instance, ActivityManager value) /*-{
    instance.@org.uberfire.client.perspective.JSNativePerspective::activityManager = value;
  }-*/;

  private native static void _31024108__1116818801_changeTitleEvent(LockManagerImpl instance, Event<ChangeTitleWidgetEvent> value) /*-{
    instance.@org.uberfire.client.mvp.LockManagerImpl::changeTitleEvent = value;
  }-*/;

  private native static void _1252540070__$903668163_modalFactory(ErrorPopupView instance, Instance<Bs3Modal> value) /*-{
    instance.@org.uberfire.client.views.pfly.modal.ErrorPopupView::modalFactory = value;
  }-*/;

  private native static void _$1732630359__120980481_myService(ComponentPresenter instance, Caller<MyService> value) /*-{
    instance.@org.uberfire.component.client.ComponentPresenter::myService = value;
  }-*/;

  private native static CheckBox _2112332982__563415049_show(SplashModalFooter instance) /*-{
    return instance.@org.uberfire.client.views.pfly.splash.SplashModalFooter::show;
  }-*/;

  private native static void _2112332982__563415049_show(SplashModalFooter instance, CheckBox value) /*-{
    instance.@org.uberfire.client.views.pfly.splash.SplashModalFooter::show = value;
  }-*/;

  private native static void _$1316152188__$262319993_panelManager(ListBarWidgetImpl instance, PanelManager value) /*-{
    instance.@org.uberfire.client.views.pfly.listbar.ListBarWidgetImpl::panelManager = value;
  }-*/;

  private native static void _$1757102468__$1825231548_layoutSelection(PlaceManagerImpl instance, LayoutSelection value) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::layoutSelection = value;
  }-*/;

  private native static void _$1825231548__$652658075_iocManager(LayoutSelection instance, SyncBeanManager value) /*-{
    instance.@org.uberfire.client.workbench.LayoutSelection::iocManager = value;
  }-*/;

  private native static void _1033421399__1671104094_errorPopupPresenter(ForceUnlockEventObserver instance, ErrorPopupPresenter value) /*-{
    instance.@org.uberfire.client.mvp.ForceUnlockEventObserver::errorPopupPresenter = value;
  }-*/;

  private native static void _1549975964__1388723237_logger(VFSLockServiceProxyBackendImpl instance, Logger value) /*-{
    instance.@org.uberfire.client.VFSLockServiceProxyBackendImpl::logger = value;
  }-*/;

  private native static void _$623677011__$903668163_menuBarBrand(WorkbenchMenuBarView instance, Instance<MainBrand> value) /*-{
    instance.@org.uberfire.client.views.pfly.menu.WorkbenchMenuBarView::menuBarBrand = value;
  }-*/;

  private native static void _1934862923__153624969_dndManager(WorkbenchLayoutImpl instance, WorkbenchDragAndDropManager value) /*-{
    instance.@org.uberfire.client.workbench.WorkbenchLayoutImpl::dndManager = value;
  }-*/;

  private native static void _1496760654__515581186_htFactory(TransitionAnchorFactoryProvider instance, HistoryTokenFactory value) /*-{
    instance.@org.jboss.errai.ui.nav.client.local.TransitionAnchorFactoryProvider::htFactory = value;
  }-*/;

  private native static void _1730935432__$1934524921_lifecycleErrorHandler(ActivityManagerImpl instance, ActivityLifecycleErrorHandler value) /*-{
    instance.@org.uberfire.client.mvp.ActivityManagerImpl::lifecycleErrorHandler = value;
  }-*/;

  private native static void _1584088255__$2073863603_runtimePluginsService(JSNativePlugin instance, RuntimePluginsServiceProxy value) /*-{
    instance.@org.uberfire.client.plugin.JSNativePlugin::runtimePluginsService = value;
  }-*/;

  private native static void _$1462522111__597466346_identity(Workbench instance, User value) /*-{
    instance.@org.uberfire.client.workbench.Workbench::identity = value;
  }-*/;

  private native static void _$1757102468__1116818801_workbenchPartCloseEvent(PlaceManagerImpl instance, Event<ClosePlaceEvent> value) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::workbenchPartCloseEvent = value;
  }-*/;

  private native static void _$2043532045__$1553627672_modal(PopupViewImpl instance, Bs3Modal value) /*-{
    instance.@org.uberfire.client.views.pfly.popup.PopupViewImpl::modal = value;
  }-*/;

  private native static void _2051073374__136504311_navigation(NavigationPanelProvider instance, Navigation value) /*-{
    instance.@org.jboss.errai.ui.nav.client.local.NavigationPanelProvider::navigation = value;
  }-*/;

  private native static void _1047951015__$695339145_mapper(PlaceHistoryHandler instance, PlaceRequestHistoryMapper value) /*-{
    instance.@org.uberfire.client.mvp.PlaceHistoryHandler::mapper = value;
  }-*/;

  private native static void _$1934524921__1388723237_logger(ActivityLifecycleErrorHandler instance, Logger value) /*-{
    instance.@org.uberfire.client.mvp.ActivityLifecycleErrorHandler::logger = value;
  }-*/;

  private native static void _$2073633020__120980481_runtimePluginsService(RuntimePluginsServiceProxyBackendImpl instance, Caller<RuntimePluginsService> value) /*-{
    instance.@org.uberfire.client.RuntimePluginsServiceProxyBackendImpl::runtimePluginsService = value;
  }-*/;

  private native static void _136504311__515581186_historyTokenFactory(Navigation instance, HistoryTokenFactory value) /*-{
    instance.@org.jboss.errai.ui.nav.client.local.Navigation::historyTokenFactory = value;
  }-*/;

  private native static void _378913974__120980481_userServiceCaller(SecurityContextImpl instance, Caller<NonCachingUserService> value) /*-{
    instance.@org.jboss.errai.security.client.local.context.SecurityContextImpl::userServiceCaller = value;
  }-*/;

  private native static void _$679243230__1671104094_errorPopupPresenter(WorkbenchBackendEntryPoint instance, ErrorPopupPresenter value) /*-{
    instance.@org.uberfire.client.WorkbenchBackendEntryPoint::errorPopupPresenter = value;
  }-*/;

  private native static void _1071005634__$292735039_menuBarPresenter(AppNavBar instance, WorkbenchMenuBarPresenter value) /*-{
    instance.@org.uberfire.client.navbar.AppNavBar::menuBarPresenter = value;
  }-*/;

  private native static void _$448678005__$304677073_wbServices(JSNativeSplashScreen instance, WorkbenchServicesProxy value) /*-{
    instance.@org.uberfire.client.splash.JSNativeSplashScreen::wbServices = value;
  }-*/;

  private native static void _31024108__1116818801_lockNotification(LockManagerImpl instance, Event<NotificationEvent> value) /*-{
    instance.@org.uberfire.client.mvp.LockManagerImpl::lockNotification = value;
  }-*/;

  private native static void _31024108__848807465_lockService(LockManagerImpl instance, VFSLockServiceProxy value) /*-{
    instance.@org.uberfire.client.mvp.LockManagerImpl::lockService = value;
  }-*/;

  private native static void _2052955140__1116818801_newPerspectiveEventEvent(ActivityBeansCache instance, Event<NewPerspectiveEvent> value) /*-{
    instance.@org.uberfire.client.mvp.ActivityBeansCache::newPerspectiveEventEvent = value;
  }-*/;

  private native static void _1084732347__314455785_securityErrorTransition(SecurityRolesConstraintPage instance, TransitionToRole<SecurityError> value) /*-{
    instance.@org.jboss.errai.security.client.local.context.SecurityContextImpl.SecurityRolesConstraintPage::securityErrorTransition = value;
  }-*/;

  private native static Span _$1119962330__280475719_identifier(ActivityNotFoundView instance) /*-{
    return instance.@org.uberfire.client.views.pfly.notfound.ActivityNotFoundView::identifier;
  }-*/;

  private native static void _$1119962330__280475719_identifier(ActivityNotFoundView instance, Span value) /*-{
    instance.@org.uberfire.client.views.pfly.notfound.ActivityNotFoundView::identifier = value;
  }-*/;

  private native static void _$274999170__$906533316_placeManager(PartContextMenusPresenter instance, PlaceManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.PartContextMenusPresenter::placeManager = value;
  }-*/;

  private native static void _$2051573400__$1566038911_view(ActivityNotFoundPresenter instance, org.uberfire.client.workbench.widgets.notfound.ActivityNotFoundPresenter.View value) /*-{
    instance.@org.uberfire.client.workbench.widgets.notfound.ActivityNotFoundPresenter::view = value;
  }-*/;

  private native static void _1934862923__$1393584145_root(WorkbenchLayoutImpl instance, HeaderPanel value) /*-{
    instance.@org.uberfire.client.workbench.WorkbenchLayoutImpl::root = value;
  }-*/;

  private native static void _153624969__$1887041540_factory(WorkbenchDragAndDropManager instance, BeanFactory value) /*-{
    instance.@org.uberfire.client.workbench.widgets.dnd.WorkbenchDragAndDropManager::factory = value;
  }-*/;

  private native static void _364015257__1934862923_workbenchLayout(WorkbenchLayoutInfoImpl instance, WorkbenchLayoutImpl value) /*-{
    instance.@org.uberfire.client.workbench.WorkbenchLayoutInfoImpl::workbenchLayout = value;
  }-*/;

  private native static void _1919272664__$1732630359_realPresenter(ComponentPresenterActivity instance, ComponentPresenter value) /*-{
    instance.@org.uberfire.component.client.ComponentPresenterActivity::realPresenter = value;
  }-*/;

  private native static void _$2051573400__$906533316_placeManager(ActivityNotFoundPresenter instance, PlaceManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.notfound.ActivityNotFoundPresenter::placeManager = value;
  }-*/;

  private native static void _$1462522111__879292651_bus(Workbench instance, ClientMessageBus value) /*-{
    instance.@org.uberfire.client.workbench.Workbench::bus = value;
  }-*/;

  private native static void _31024108__1116818801_updatedLockStatusEvent(LockManagerImpl instance, Event<UpdatedLockStatusEvent> value) /*-{
    instance.@org.uberfire.client.mvp.LockManagerImpl::updatedLockStatusEvent = value;
  }-*/;

  private native static void _618642634__820873068_partViewContainer(AbstractDockingWorkbenchPanelView instance, ResizeFlowPanel value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.AbstractDockingWorkbenchPanelView::partViewContainer = value;
  }-*/;

  private native static void _31024108__597466346_user(LockManagerImpl instance, User value) /*-{
    instance.@org.uberfire.client.mvp.LockManagerImpl::user = value;
  }-*/;

  private native static void _378913974__136504311_navigation(SecurityContextImpl instance, Navigation value) /*-{
    instance.@org.jboss.errai.security.client.local.context.SecurityContextImpl::navigation = value;
  }-*/;

  private native static void _136504311__$2056551207_stateChangeEvent(Navigation instance, StateChange value) /*-{
    instance.@org.jboss.errai.ui.nav.client.local.Navigation::stateChangeEvent = value;
  }-*/;

  private native static void _684448251__$262319993_panelManager(JSNativePerspective instance, PanelManager value) /*-{
    instance.@org.uberfire.client.perspective.JSNativePerspective::panelManager = value;
  }-*/;

  private native static void _$1316152188__597466346_identity(ListBarWidgetImpl instance, User value) /*-{
    instance.@org.uberfire.client.views.pfly.listbar.ListBarWidgetImpl::identity = value;
  }-*/;

  private native static void _$1757102468__1116818801_newSplashScreenActiveEvent(PlaceManagerImpl instance, Event<NewSplashScreenActiveEvent> value) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::newSplashScreenActiveEvent = value;
  }-*/;

  private native static void _1730935432__597466346_identity(ActivityManagerImpl instance, User value) /*-{
    instance.@org.uberfire.client.mvp.ActivityManagerImpl::identity = value;
  }-*/;

  private native static void _$1705636724__690997221_compass(CompassDropController instance, CompassWidget value) /*-{
    instance.@org.uberfire.client.workbench.widgets.dnd.CompassDropController::compass = value;
  }-*/;

  public native static User _663569186_produceActiveUser(BasicUserCacheImpl instance) /*-{
    return instance.@org.jboss.errai.security.client.local.context.BasicUserCacheImpl::produceActiveUser()();
  }-*/;

  public native static EventBus _$1757102468_produceEventBus(PlaceManagerImpl instance) /*-{
    return instance.@org.uberfire.client.mvp.PlaceManagerImpl::produceEventBus()();
  }-*/;

  public native static SessionInfo _$1462522111_currentSession(Workbench instance) /*-{
    return instance.@org.uberfire.client.workbench.Workbench::currentSession()();
  }-*/;

  public native static void _663569186_maybeLoadStoredCache(BasicUserCacheImpl instance) /*-{
    instance.@org.jboss.errai.security.client.local.context.BasicUserCacheImpl::maybeLoadStoredCache()();
  }-*/;

  public native static void _$389641401_onSelectPlaceEvent_SelectPlaceEvent(PanelManagerImpl instance, SelectPlaceEvent a0) /*-{
    instance.@org.uberfire.client.workbench.PanelManagerImpl::onSelectPlaceEvent(Lorg/uberfire/client/workbench/events/SelectPlaceEvent;)(a0);
  }-*/;

  public native static void _$389641401_onDropPlaceEvent_DropPlaceEvent(PanelManagerImpl instance, DropPlaceEvent a0) /*-{
    instance.@org.uberfire.client.workbench.PanelManagerImpl::onDropPlaceEvent(Lorg/uberfire/client/workbench/events/DropPlaceEvent;)(a0);
  }-*/;

  public native static void _$389641401_onChangeTitleWidgetEvent_ChangeTitleWidgetEvent(PanelManagerImpl instance, ChangeTitleWidgetEvent a0) /*-{
    instance.@org.uberfire.client.workbench.PanelManagerImpl::onChangeTitleWidgetEvent(Lorg/uberfire/client/workbench/events/ChangeTitleWidgetEvent;)(a0);
  }-*/;

  public native static void _$389641401_setup(PanelManagerImpl instance) /*-{
    instance.@org.uberfire.client.workbench.PanelManagerImpl::setup()();
  }-*/;

  public native static void _$389641401_teardown(PanelManagerImpl instance) /*-{
    instance.@org.uberfire.client.workbench.PanelManagerImpl::teardown()();
  }-*/;

  public native static void _$1316152188_postConstruct(ListBarWidgetImpl instance) /*-{
    instance.@org.uberfire.client.views.pfly.listbar.ListBarWidgetImpl::postConstruct()();
  }-*/;

  public native static void _618642634_setupDockingPanel(AbstractDockingWorkbenchPanelView instance) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.AbstractDockingWorkbenchPanelView::setupDockingPanel()();
  }-*/;

  public native static void _1346204971_setup(AbstractSimpleWorkbenchPanelView instance) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.AbstractSimpleWorkbenchPanelView::setup()();
  }-*/;

  public native static void _618642634_tearDownDockingPanel(AbstractDockingWorkbenchPanelView instance) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.AbstractDockingWorkbenchPanelView::tearDownDockingPanel()();
  }-*/;

  public native static void _136504311_init(Navigation instance) /*-{
    instance.@org.jboss.errai.ui.nav.client.local.Navigation::init()();
  }-*/;

  public native static void _378913974_setup(SecurityContextImpl instance) /*-{
    instance.@org.jboss.errai.security.client.local.context.SecurityContextImpl::setup()();
  }-*/;

  public native static void _1934862923_init(WorkbenchLayoutImpl instance) /*-{
    instance.@org.uberfire.client.workbench.WorkbenchLayoutImpl::init()();
  }-*/;

  public native static void _2052955140_init(ActivityBeansCache instance) /*-{
    instance.@org.uberfire.client.mvp.ActivityBeansCache::init()();
  }-*/;

  public native static void _$1757102468_onWorkbenchPartOnFocus_PlaceGainFocusEvent(PlaceManagerImpl instance, PlaceGainFocusEvent a0) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::onWorkbenchPartOnFocus(Lorg/uberfire/client/workbench/events/PlaceGainFocusEvent;)(a0);
  }-*/;

  public native static void _$1757102468_onWorkbenchPartLostFocus_PlaceLostFocusEvent(PlaceManagerImpl instance, PlaceLostFocusEvent a0) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::onWorkbenchPartLostFocus(Lorg/uberfire/client/workbench/events/PlaceLostFocusEvent;)(a0);
  }-*/;

  public native static void _40974972_onWorkbenchPartClose_ClosePlaceEvent(WorkbenchToolBarPresenter instance, ClosePlaceEvent a0) /*-{
    instance.@org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarPresenter::onWorkbenchPartClose(Lorg/uberfire/client/workbench/events/ClosePlaceEvent;)(a0);
  }-*/;

  public native static void _40974972_onWorkbenchPartOnFocus_PlaceGainFocusEvent(WorkbenchToolBarPresenter instance, PlaceGainFocusEvent a0) /*-{
    instance.@org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarPresenter::onWorkbenchPartOnFocus(Lorg/uberfire/client/workbench/events/PlaceGainFocusEvent;)(a0);
  }-*/;

  public native static void _$1732630359_init(ComponentPresenter instance) /*-{
    instance.@org.uberfire.component.client.ComponentPresenter::init()();
  }-*/;

  public native static void _$110318115_setup(WorkbenchMenuStandardNavBarView instance) /*-{
    instance.@org.uberfire.client.views.pfly.menu.WorkbenchMenuStandardNavBarView::setup()();
  }-*/;

  public native static void _$1582791603_setup(WorkbenchMenuCompactNavBarView instance) /*-{
    instance.@org.uberfire.client.views.pfly.menu.WorkbenchMenuCompactNavBarView::setup()();
  }-*/;

  public native static void _$623677011_setup(WorkbenchMenuBarView instance) /*-{
    instance.@org.uberfire.client.views.pfly.menu.WorkbenchMenuBarView::setup()();
  }-*/;

  public native static void _$292735039_onPerspectiveChange_PerspectiveChange(WorkbenchMenuBarPresenter instance, PerspectiveChange a0) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarPresenter::onPerspectiveChange(Lorg/uberfire/client/workbench/events/PerspectiveChange;)(a0);
  }-*/;

  public native static void _$292735039_onPlaceMinimized_PlaceMinimizedEvent(WorkbenchMenuBarPresenter instance, PlaceMinimizedEvent a0) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarPresenter::onPlaceMinimized(Lorg/uberfire/client/workbench/events/PlaceMinimizedEvent;)(a0);
  }-*/;

  public native static void _$292735039_onPlaceMaximized_PlaceMaximizedEvent(WorkbenchMenuBarPresenter instance, PlaceMaximizedEvent a0) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarPresenter::onPlaceMaximized(Lorg/uberfire/client/workbench/events/PlaceMaximizedEvent;)(a0);
  }-*/;

  public native static void _$292735039_setup(WorkbenchMenuBarPresenter instance) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarPresenter::setup()();
  }-*/;

  public native static void _2112332982_setup(SplashModalFooter instance) /*-{
    instance.@org.uberfire.client.views.pfly.splash.SplashModalFooter::setup()();
  }-*/;

  public native static void _253255348_init(AbstractWorkbenchPanelPresenter instance) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.AbstractWorkbenchPanelPresenter::init()();
  }-*/;

  public native static void _31024108_updateLockInfo_LockInfo(LockManagerImpl instance, LockInfo a0) /*-{
    instance.@org.uberfire.client.mvp.LockManagerImpl::updateLockInfo(Lorg/uberfire/backend/vfs/impl/LockInfo;)(a0);
  }-*/;

  public native static void _31024108_onResourceAdded_ResourceAddedEvent(LockManagerImpl instance, ResourceAddedEvent a0) /*-{
    instance.@org.uberfire.client.mvp.LockManagerImpl::onResourceAdded(Lorg/uberfire/workbench/events/ResourceAddedEvent;)(a0);
  }-*/;

  public native static void _31024108_onResourceUpdated_ResourceUpdatedEvent(LockManagerImpl instance, ResourceUpdatedEvent a0) /*-{
    instance.@org.uberfire.client.mvp.LockManagerImpl::onResourceUpdated(Lorg/uberfire/workbench/events/ResourceUpdatedEvent;)(a0);
  }-*/;

  public native static void _31024108_onSaveInProgress_SaveInProgressEvent(LockManagerImpl instance, SaveInProgressEvent a0) /*-{
    instance.@org.uberfire.client.mvp.LockManagerImpl::onSaveInProgress(Lorg/uberfire/client/mvp/SaveInProgressEvent;)(a0);
  }-*/;

  public native static void _31024108_onLockRequired_LockRequiredEvent(LockManagerImpl instance, LockRequiredEvent a0) /*-{
    instance.@org.uberfire.client.mvp.LockManagerImpl::onLockRequired(Lorg/uberfire/client/mvp/LockRequiredEvent;)(a0);
  }-*/;

  public native static void _$896357979_postConstruct(StaticWorkbenchPanelView instance) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.StaticWorkbenchPanelView::postConstruct()();
  }-*/;

  public native static void _$1462522111_startIfNotBlocked(Workbench instance) /*-{
    instance.@org.uberfire.client.workbench.Workbench::startIfNotBlocked()();
  }-*/;

  public native static void _$1462522111_earlyInit(Workbench instance) /*-{
    instance.@org.uberfire.client.workbench.Workbench::earlyInit()();
  }-*/;

  public native static void _$1304194947_onResourceRenamed_ResourceRenamedEvent(ObservablePathImpl instance, ResourceRenamedEvent a0) /*-{
    instance.@org.uberfire.backend.vfs.impl.ObservablePathImpl::onResourceRenamed(Lorg/uberfire/workbench/events/ResourceRenamedEvent;)(a0);
  }-*/;

  public native static void _$1304194947_onResourceDeleted_ResourceDeletedEvent(ObservablePathImpl instance, ResourceDeletedEvent a0) /*-{
    instance.@org.uberfire.backend.vfs.impl.ObservablePathImpl::onResourceDeleted(Lorg/uberfire/workbench/events/ResourceDeletedEvent;)(a0);
  }-*/;

  public native static void _$1304194947_onResourceUpdated_ResourceUpdatedEvent(ObservablePathImpl instance, ResourceUpdatedEvent a0) /*-{
    instance.@org.uberfire.backend.vfs.impl.ObservablePathImpl::onResourceUpdated(Lorg/uberfire/workbench/events/ResourceUpdatedEvent;)(a0);
  }-*/;

  public native static void _$1304194947_onResourceCopied_ResourceCopiedEvent(ObservablePathImpl instance, ResourceCopiedEvent a0) /*-{
    instance.@org.uberfire.backend.vfs.impl.ObservablePathImpl::onResourceCopied(Lorg/uberfire/workbench/events/ResourceCopiedEvent;)(a0);
  }-*/;

  public native static void _$1304194947_onResourceBatchEvent_ResourceBatchChangesEvent(ObservablePathImpl instance, ResourceBatchChangesEvent a0) /*-{
    instance.@org.uberfire.backend.vfs.impl.ObservablePathImpl::onResourceBatchEvent(Lorg/uberfire/workbench/events/ResourceBatchChangesEvent;)(a0);
  }-*/;

  public native static void _$821728441_setupMultiPartPanel(AbstractMultiPartWorkbenchPanelView instance) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.AbstractMultiPartWorkbenchPanelView::setupMultiPartPanel()();
  }-*/;

  public native static void _$680440259_setup(UserMenu instance) /*-{
    instance.@org.uberfire.client.views.pfly.menu.UserMenu::setup()();
  }-*/;

  public native static void _1723589606_init(CompassWidgetImpl instance) /*-{
    instance.@org.uberfire.client.views.pfly.dnd.CompassWidgetImpl::init()();
  }-*/;

  public native static void _348398006_onNewSplashScreen_NewSplashScreenActiveEvent(SplashScreenMenuPresenter instance, NewSplashScreenActiveEvent a0) /*-{
    instance.@org.uberfire.client.menu.SplashScreenMenuPresenter::onNewSplashScreen(Lorg/uberfire/client/workbench/events/NewSplashScreenActiveEvent;)(a0);
  }-*/;

  public native static void _1150956601_onKeyDown_KeyDownEvent(MoodScreen instance, KeyDownEvent a0) /*-{
    instance.@org.uberfire.client.screens.MoodScreen::onKeyDown(Lcom/google/gwt/event/dom/client/KeyDownEvent;)(a0);
  }-*/;

  public native static void _73328378_setupMenu_ApplicationReadyEvent(ShowcaseEntryPoint instance, ApplicationReadyEvent a0) /*-{
    instance.@org.uberfire.client.ShowcaseEntryPoint::setupMenu(Lorg/uberfire/client/workbench/events/ApplicationReadyEvent;)(a0);
  }-*/;

  public native static void _322507922_setInstance(SecurityContextHoldingSingleton instance) /*-{
    instance.@org.jboss.errai.security.client.local.nav.SecurityContextHoldingSingleton::setInstance()();
  }-*/;

  public native static void _$1098181088_onPerspectiveChange_PerspectiveChange(WorkbenchViewModeSwitcherPresenter instance, PerspectiveChange a0) /*-{
    instance.@org.uberfire.client.menu.WorkbenchViewModeSwitcherPresenter::onPerspectiveChange(Lorg/uberfire/client/workbench/events/PerspectiveChange;)(a0);
  }-*/;

  public native static void _$1098181088_onPlaceMinimized_PlaceMinimizedEvent(WorkbenchViewModeSwitcherPresenter instance, PlaceMinimizedEvent a0) /*-{
    instance.@org.uberfire.client.menu.WorkbenchViewModeSwitcherPresenter::onPlaceMinimized(Lorg/uberfire/client/workbench/events/PlaceMinimizedEvent;)(a0);
  }-*/;

  public native static void _$1098181088_onPlaceMaximized_PlaceMaximizedEvent(WorkbenchViewModeSwitcherPresenter instance, PlaceMaximizedEvent a0) /*-{
    instance.@org.uberfire.client.menu.WorkbenchViewModeSwitcherPresenter::onPlaceMaximized(Lorg/uberfire/client/workbench/events/PlaceMaximizedEvent;)(a0);
  }-*/;

  public native static void _35605411_init(WorkbenchPartPresenterDefault instance) /*-{
    instance.@org.uberfire.client.workbench.pmgr.nswe.part.WorkbenchPartPresenterDefault::init()();
  }-*/;

  public native static void _1033421399_onForceUnlock_ForceUnlockEvent(ForceUnlockEventObserver instance, ForceUnlockEvent a0) /*-{
    instance.@org.uberfire.client.mvp.ForceUnlockEventObserver::onForceUnlock(Lorg/uberfire/backend/vfs/impl/ForceUnlockEvent;)(a0);
  }-*/;

  public native static void _$274999170_onWorkbenchPartOnFocus_PlaceGainFocusEvent(PartContextMenusPresenter instance, PlaceGainFocusEvent a0) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.PartContextMenusPresenter::onWorkbenchPartOnFocus(Lorg/uberfire/client/workbench/events/PlaceGainFocusEvent;)(a0);
  }-*/;

  // The main IOC bootstrap method.
  public SimpleInjectionContext bootstrapContainer() {
    declareBeans_0();
    declareBeans_1();
    declareBeans_2();
    return injContext;
  }
}