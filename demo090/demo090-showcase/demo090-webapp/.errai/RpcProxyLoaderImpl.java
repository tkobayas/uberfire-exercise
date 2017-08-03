package org.jboss.errai.bus.client.framework;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jboss.errai.bus.client.api.base.MessageBuilder;
import org.jboss.errai.bus.client.api.builder.RemoteCallSendable;
import org.jboss.errai.bus.client.api.messaging.MessageBus;
import org.jboss.errai.common.client.api.ErrorCallback;
import org.jboss.errai.common.client.api.RemoteCallback;
import org.jboss.errai.common.client.api.interceptor.InterceptedCall;
import org.jboss.errai.common.client.api.interceptor.RemoteCallContext;
import org.jboss.errai.common.client.framework.CallContextStatus;
import org.jboss.errai.common.client.framework.ProxyProvider;
import org.jboss.errai.common.client.framework.RemoteServiceProxyFactory;
import org.jboss.errai.common.client.util.AsyncBeanFactory;
import org.jboss.errai.common.client.util.CreationalCallback;
import org.jboss.errai.security.client.local.interceptors.AuthenticationServiceInterceptor;
import org.jboss.errai.security.shared.api.identity.User;
import org.jboss.errai.security.shared.service.AuthenticationService;
import org.jboss.errai.security.shared.service.NonCachingUserService;
import org.uberfire.backend.plugin.RuntimePluginsService;
import org.uberfire.backend.vfs.DirectoryStream;
import org.uberfire.backend.vfs.DirectoryStream.Filter;
import org.uberfire.backend.vfs.Path;
import org.uberfire.backend.vfs.VFSLockService;
import org.uberfire.backend.vfs.VFSService;
import org.uberfire.backend.vfs.impl.LockInfo;
import org.uberfire.backend.vfs.impl.LockResult;
import org.uberfire.backend.vfs.impl.VFSCacheInterceptor;
import org.uberfire.component.model.MyModel;
import org.uberfire.component.service.MyService;
import org.uberfire.workbench.model.PerspectiveDefinition;
import org.uberfire.workbench.model.SplashScreenFilter;
import org.uberfire.workbench.services.WorkbenchServices;

public class RpcProxyLoaderImpl implements RpcProxyLoader { public void loadProxies(final MessageBus bus) {
    class org_uberfire_backend_vfs_VFSServiceImpl extends AbstractRpcProxy implements VFSService { public Path get(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("get:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("get:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public DirectoryStream newDirectoryStream(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("newDirectoryStream:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(DirectoryStream.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("newDirectoryStream:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(DirectoryStream.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public DirectoryStream newDirectoryStream(final Path a0, final Filter a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("newDirectoryStream:org.uberfire.backend.vfs.Path:org.uberfire.backend.vfs.DirectoryStream.Filter:", qualifiers, new Object[] { a0, a1 }).respondTo(DirectoryStream.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("newDirectoryStream:org.uberfire.backend.vfs.Path:org.uberfire.backend.vfs.DirectoryStream.Filter:", qualifiers, new Object[] { a0, a1 }).respondTo(DirectoryStream.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path createDirectory(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("createDirectory:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("createDirectory:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path createDirectory(final Path a0, final Map a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("createDirectory:org.uberfire.backend.vfs.Path:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("createDirectory:org.uberfire.backend.vfs.Path:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path createDirectories(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("createDirectories:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("createDirectories:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path createDirectories(final Path a0, final Map a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("createDirectories:org.uberfire.backend.vfs.Path:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("createDirectories:org.uberfire.backend.vfs.Path:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Map readAttributes(final Path a0) {
        try {
          final CallContextStatus status = new CallContextStatus(VFSCacheInterceptor.class);
          final RemoteCallContext callContext = new RemoteCallContext() {
            public String getMethodName() {
              return "readAttributes";
            }
            public Class getReturnType() {
              return Map.class;
            }
            public Annotation[] getAnnotations() {
              return new Annotation[] { new InterceptedCall() {
                  public Class annotationType() {
                    return InterceptedCall.class;
                  }
                  public String toString() {
                    return "@org.jboss.errai.common.client.api.interceptor.InterceptedCall(value=[class org.uberfire.backend.vfs.impl.VFSCacheInterceptor])";
                  }
                  public Class[] value() {
                    return new Class[] { VFSCacheInterceptor.class };
                  }
              } };
            }
            public Annotation[] getTypeAnnotations() {
              return new Annotation[] { };
            }
            public Object proceed() {
              status.proceed();
              if (status.getNextInterceptor() == null) {
                RemoteCallSendable sendable = null;
                if (errorCallback == null) {
                  sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("readAttributes:org.uberfire.backend.vfs.Path:", qualifiers, getParameters()).respondTo(Map.class, remoteCallback).defaultErrorHandling();
                } else {
                  sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("readAttributes:org.uberfire.backend.vfs.Path:", qualifiers, getParameters()).respondTo(Map.class, remoteCallback).errorsHandledBy(errorCallback);
                }
                org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
              } else if (status.getNextInterceptor() == VFSCacheInterceptor.class) {
                final RemoteCallContext ctx = this;
                final CreationalCallback icc = new CreationalCallback() {
                  public void callback(final Object beanInstance) {
                    status.setProceeding(false);
                    ((VFSCacheInterceptor) beanInstance).aroundInvoke(ctx);
                    if ((!status.isProceeding()) && (VFSCacheInterceptor.class == status.getNextInterceptor())) {
                      remoteCallback.callback(ctx.getResult());
                    }
                  }
                };
                AsyncBeanFactory.createBean(new VFSCacheInterceptor(), icc);
              }
              return null;
            }
            public void proceed(final RemoteCallback interceptorCallback) {
              final RemoteCallback providedCallback = org_uberfire_backend_vfs_VFSServiceImpl.this.remoteCallback;
              remoteCallback = new RemoteCallback() {
                public void callback(Object response) {
                  RemoteCallback intCallback = interceptorCallback;
                  setResult(response);
                  intCallback.callback(getResult());
                  providedCallback.callback(getResult());
                }
              };
              proceed();
            }
            public void proceed(RemoteCallback interceptorCallback, final ErrorCallback interceptorErrorCallback) {
              final ErrorCallback providedErrorCallback = org_uberfire_backend_vfs_VFSServiceImpl.this.errorCallback;
              errorCallback = new ErrorCallback() {
                public boolean error(Object message, Throwable throwable) {
                  interceptorErrorCallback.error(message, throwable);
                  if (getResult() != null) {
                    remoteCallback.callback(getResult());
                    return false;
                  } else if (providedErrorCallback != null) {
                    return providedErrorCallback.error(message, throwable);
                  }
                  return true;
                }
              };
              proceed(interceptorCallback);
            }
          };
          callContext.setParameters(new Object[] { a0 });
          callContext.proceed();
        } catch (Throwable throwable) {
          if (errorCallback != null) {
            errorCallback.error(null, throwable);
          } else {
            invokeDefaultErrorHandlers(throwable);
          }
        }
        return null;
      }

      public void setAttributes(final Path a0, final Map a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("setAttributes:org.uberfire.backend.vfs.Path:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("setAttributes:org.uberfire.backend.vfs.Path:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
      }

      public void delete(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("delete:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("delete:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
      }

      public boolean deleteIfExists(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("deleteIfExists:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("deleteIfExists:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public Path copy(final Path a0, final Path a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("copy:org.uberfire.backend.vfs.Path:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("copy:org.uberfire.backend.vfs.Path:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path move(final Path a0, final Path a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("move:org.uberfire.backend.vfs.Path:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("move:org.uberfire.backend.vfs.Path:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public String readAllString(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("readAllString:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("readAllString:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path write(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("write:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("write:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path write(final Path a0, final String a1, final Map a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("write:org.uberfire.backend.vfs.Path:java.lang.String:java.util.Map:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("write:org.uberfire.backend.vfs.Path:java.lang.String:java.util.Map:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public boolean isRegularFile(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("isRegularFile:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("isRegularFile:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public boolean isRegularFile(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("isRegularFile:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("isRegularFile:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public boolean isDirectory(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("isDirectory:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("isDirectory:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public boolean isDirectory(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("isDirectory:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("isDirectory:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(VFSService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_uberfire_backend_vfs_VFSServiceImpl();
      }
    });
    class org_uberfire_workbench_services_WorkbenchServicesImpl extends AbstractRpcProxy implements WorkbenchServices { public void save(final String a0, final PerspectiveDefinition a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("save:java.lang.String:org.uberfire.workbench.model.PerspectiveDefinition:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("save:java.lang.String:org.uberfire.workbench.model.PerspectiveDefinition:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_workbench_services_WorkbenchServicesImpl.this.sendRequest(bus, sendable);
      }

      public void save(final SplashScreenFilter a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("save:org.uberfire.workbench.model.SplashScreenFilter:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("save:org.uberfire.workbench.model.SplashScreenFilter:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_workbench_services_WorkbenchServicesImpl.this.sendRequest(bus, sendable);
      }

      public Set loadPerspectives() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("loadPerspectives:", qualifiers, new Object[] { }).respondTo(Set.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("loadPerspectives:", qualifiers, new Object[] { }).respondTo(Set.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_workbench_services_WorkbenchServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public PerspectiveDefinition loadPerspective(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("loadPerspective:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(PerspectiveDefinition.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("loadPerspective:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(PerspectiveDefinition.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_workbench_services_WorkbenchServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void removePerspectiveState(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("removePerspectiveState:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("removePerspectiveState:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_workbench_services_WorkbenchServicesImpl.this.sendRequest(bus, sendable);
      }

      public void removePerspectiveStates() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("removePerspectiveStates:", qualifiers, new Object[] { }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("removePerspectiveStates:", qualifiers, new Object[] { }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_workbench_services_WorkbenchServicesImpl.this.sendRequest(bus, sendable);
      }

      public SplashScreenFilter loadSplashScreenFilter(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("loadSplashScreenFilter:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(SplashScreenFilter.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("loadSplashScreenFilter:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(SplashScreenFilter.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_workbench_services_WorkbenchServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Map loadDefaultEditorsMap() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("loadDefaultEditorsMap:", qualifiers, new Object[] { }).respondTo(Map.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("loadDefaultEditorsMap:", qualifiers, new Object[] { }).respondTo(Map.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_workbench_services_WorkbenchServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void saveDefaultEditors(final Map a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("saveDefaultEditors:java.util.Map:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("saveDefaultEditors:java.util.Map:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_workbench_services_WorkbenchServicesImpl.this.sendRequest(bus, sendable);
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(WorkbenchServices.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_uberfire_workbench_services_WorkbenchServicesImpl();
      }
    });
    class org_uberfire_backend_vfs_VFSLockServiceImpl extends AbstractRpcProxy implements VFSLockService { public LockResult acquireLock(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSLockService").endpoint("acquireLock:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(LockResult.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSLockService").endpoint("acquireLock:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(LockResult.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSLockServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public LockResult releaseLock(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSLockService").endpoint("releaseLock:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(LockResult.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSLockService").endpoint("releaseLock:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(LockResult.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSLockServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public LockResult forceReleaseLock(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSLockService").endpoint("forceReleaseLock:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(LockResult.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSLockService").endpoint("forceReleaseLock:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(LockResult.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSLockServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public LockInfo retrieveLockInfo(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSLockService").endpoint("retrieveLockInfo:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(LockInfo.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSLockService").endpoint("retrieveLockInfo:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(LockInfo.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSLockServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List retrieveLockInfos(final Path a0, final boolean a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSLockService").endpoint("retrieveLockInfos:org.uberfire.backend.vfs.Path:boolean:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSLockService").endpoint("retrieveLockInfos:org.uberfire.backend.vfs.Path:boolean:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSLockServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(VFSLockService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_uberfire_backend_vfs_VFSLockServiceImpl();
      }
    });
    class org_jboss_errai_security_shared_service_AuthenticationServiceImpl extends AbstractRpcProxy implements AuthenticationService { public User login(final String a0, final String a1) {
        try {
          final CallContextStatus status = new CallContextStatus(AuthenticationServiceInterceptor.class);
          final RemoteCallContext callContext = new RemoteCallContext() {
            public String getMethodName() {
              return "login";
            }
            public Class getReturnType() {
              return User.class;
            }
            public Annotation[] getAnnotations() {
              return new Annotation[] { };
            }
            public Annotation[] getTypeAnnotations() {
              return new Annotation[] { };
            }
            public Object proceed() {
              status.proceed();
              if (status.getNextInterceptor() == null) {
                RemoteCallSendable sendable = null;
                if (errorCallback == null) {
                  sendable = MessageBuilder.createCall().call("org.jboss.errai.security.shared.service.AuthenticationService").endpoint("login:java.lang.String:java.lang.String:", qualifiers, getParameters()).respondTo(User.class, remoteCallback).defaultErrorHandling();
                } else {
                  sendable = MessageBuilder.createCall().call("org.jboss.errai.security.shared.service.AuthenticationService").endpoint("login:java.lang.String:java.lang.String:", qualifiers, getParameters()).respondTo(User.class, remoteCallback).errorsHandledBy(errorCallback);
                }
                org_jboss_errai_security_shared_service_AuthenticationServiceImpl.this.sendRequest(bus, sendable);
              } else if (status.getNextInterceptor() == AuthenticationServiceInterceptor.class) {
                final RemoteCallContext ctx = this;
                final CreationalCallback icc = new CreationalCallback() {
                  public void callback(final Object beanInstance) {
                    status.setProceeding(false);
                    ((AuthenticationServiceInterceptor) beanInstance).aroundInvoke(ctx);
                    if ((!status.isProceeding()) && (AuthenticationServiceInterceptor.class == status.getNextInterceptor())) {
                      remoteCallback.callback(ctx.getResult());
                    }
                  }
                };
                org.jboss.errai.ioc.client.container.IOC.getAsyncBeanManager().lookupBeans(AuthenticationServiceInterceptor.class).iterator().next().getInstance(icc);
              }
              return null;
            }
            public void proceed(final RemoteCallback interceptorCallback) {
              final RemoteCallback providedCallback = org_jboss_errai_security_shared_service_AuthenticationServiceImpl.this.remoteCallback;
              remoteCallback = new RemoteCallback() {
                public void callback(Object response) {
                  RemoteCallback intCallback = interceptorCallback;
                  setResult(response);
                  intCallback.callback(getResult());
                  providedCallback.callback(getResult());
                }
              };
              proceed();
            }
            public void proceed(RemoteCallback interceptorCallback, final ErrorCallback interceptorErrorCallback) {
              final ErrorCallback providedErrorCallback = org_jboss_errai_security_shared_service_AuthenticationServiceImpl.this.errorCallback;
              errorCallback = new ErrorCallback() {
                public boolean error(Object message, Throwable throwable) {
                  interceptorErrorCallback.error(message, throwable);
                  if (getResult() != null) {
                    remoteCallback.callback(getResult());
                    return false;
                  } else if (providedErrorCallback != null) {
                    return providedErrorCallback.error(message, throwable);
                  }
                  return true;
                }
              };
              proceed(interceptorCallback);
            }
          };
          callContext.setParameters(new Object[] { a0, a1 });
          callContext.proceed();
        } catch (Throwable throwable) {
          if (errorCallback != null) {
            errorCallback.error(null, throwable);
          } else {
            invokeDefaultErrorHandlers(throwable);
          }
        }
        return null;
      }

      public boolean isLoggedIn() {
        try {
          final CallContextStatus status = new CallContextStatus(AuthenticationServiceInterceptor.class);
          final RemoteCallContext callContext = new RemoteCallContext() {
            public String getMethodName() {
              return "isLoggedIn";
            }
            public Class getReturnType() {
              return boolean.class;
            }
            public Annotation[] getAnnotations() {
              return new Annotation[] { };
            }
            public Annotation[] getTypeAnnotations() {
              return new Annotation[] { };
            }
            public Object proceed() {
              status.proceed();
              if (status.getNextInterceptor() == null) {
                RemoteCallSendable sendable = null;
                if (errorCallback == null) {
                  sendable = MessageBuilder.createCall().call("org.jboss.errai.security.shared.service.AuthenticationService").endpoint("isLoggedIn:", qualifiers, getParameters()).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
                } else {
                  sendable = MessageBuilder.createCall().call("org.jboss.errai.security.shared.service.AuthenticationService").endpoint("isLoggedIn:", qualifiers, getParameters()).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
                }
                org_jboss_errai_security_shared_service_AuthenticationServiceImpl.this.sendRequest(bus, sendable);
              } else if (status.getNextInterceptor() == AuthenticationServiceInterceptor.class) {
                final RemoteCallContext ctx = this;
                final CreationalCallback icc = new CreationalCallback() {
                  public void callback(final Object beanInstance) {
                    status.setProceeding(false);
                    ((AuthenticationServiceInterceptor) beanInstance).aroundInvoke(ctx);
                    if ((!status.isProceeding()) && (AuthenticationServiceInterceptor.class == status.getNextInterceptor())) {
                      remoteCallback.callback(ctx.getResult());
                    }
                  }
                };
                org.jboss.errai.ioc.client.container.IOC.getAsyncBeanManager().lookupBeans(AuthenticationServiceInterceptor.class).iterator().next().getInstance(icc);
              }
              return null;
            }
            public void proceed(final RemoteCallback interceptorCallback) {
              final RemoteCallback providedCallback = org_jboss_errai_security_shared_service_AuthenticationServiceImpl.this.remoteCallback;
              remoteCallback = new RemoteCallback() {
                public void callback(Object response) {
                  RemoteCallback intCallback = interceptorCallback;
                  setResult(response);
                  intCallback.callback(getResult());
                  providedCallback.callback(getResult());
                }
              };
              proceed();
            }
            public void proceed(RemoteCallback interceptorCallback, final ErrorCallback interceptorErrorCallback) {
              final ErrorCallback providedErrorCallback = org_jboss_errai_security_shared_service_AuthenticationServiceImpl.this.errorCallback;
              errorCallback = new ErrorCallback() {
                public boolean error(Object message, Throwable throwable) {
                  interceptorErrorCallback.error(message, throwable);
                  if (getResult() != null) {
                    remoteCallback.callback(getResult());
                    return false;
                  } else if (providedErrorCallback != null) {
                    return providedErrorCallback.error(message, throwable);
                  }
                  return true;
                }
              };
              proceed(interceptorCallback);
            }
          };
          callContext.setParameters(new Object[] { });
          callContext.proceed();
        } catch (Throwable throwable) {
          if (errorCallback != null) {
            errorCallback.error(null, throwable);
          } else {
            invokeDefaultErrorHandlers(throwable);
          }
        }
        return false;
      }

      public void logout() {
        try {
          final CallContextStatus status = new CallContextStatus(AuthenticationServiceInterceptor.class);
          final RemoteCallContext callContext = new RemoteCallContext() {
            public String getMethodName() {
              return "logout";
            }
            public Class getReturnType() {
              return void.class;
            }
            public Annotation[] getAnnotations() {
              return new Annotation[] { };
            }
            public Annotation[] getTypeAnnotations() {
              return new Annotation[] { };
            }
            public Object proceed() {
              status.proceed();
              if (status.getNextInterceptor() == null) {
                RemoteCallSendable sendable = null;
                if (errorCallback == null) {
                  sendable = MessageBuilder.createCall().call("org.jboss.errai.security.shared.service.AuthenticationService").endpoint("logout:", qualifiers, getParameters()).respondTo(void.class, remoteCallback).defaultErrorHandling();
                } else {
                  sendable = MessageBuilder.createCall().call("org.jboss.errai.security.shared.service.AuthenticationService").endpoint("logout:", qualifiers, getParameters()).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
                }
                org_jboss_errai_security_shared_service_AuthenticationServiceImpl.this.sendRequest(bus, sendable);
              } else if (status.getNextInterceptor() == AuthenticationServiceInterceptor.class) {
                final RemoteCallContext ctx = this;
                final CreationalCallback icc = new CreationalCallback() {
                  public void callback(final Object beanInstance) {
                    status.setProceeding(false);
                    ((AuthenticationServiceInterceptor) beanInstance).aroundInvoke(ctx);
                    if ((!status.isProceeding()) && (AuthenticationServiceInterceptor.class == status.getNextInterceptor())) {
                      remoteCallback.callback(ctx.getResult());
                    }
                  }
                };
                org.jboss.errai.ioc.client.container.IOC.getAsyncBeanManager().lookupBeans(AuthenticationServiceInterceptor.class).iterator().next().getInstance(icc);
              }
              return null;
            }
            public void proceed(final RemoteCallback interceptorCallback) {
              final RemoteCallback providedCallback = org_jboss_errai_security_shared_service_AuthenticationServiceImpl.this.remoteCallback;
              remoteCallback = new RemoteCallback() {
                public void callback(Object response) {
                  RemoteCallback intCallback = interceptorCallback;
                  setResult(response);
                  intCallback.callback(getResult());
                  providedCallback.callback(getResult());
                }
              };
              proceed();
            }
            public void proceed(RemoteCallback interceptorCallback, final ErrorCallback interceptorErrorCallback) {
              final ErrorCallback providedErrorCallback = org_jboss_errai_security_shared_service_AuthenticationServiceImpl.this.errorCallback;
              errorCallback = new ErrorCallback() {
                public boolean error(Object message, Throwable throwable) {
                  interceptorErrorCallback.error(message, throwable);
                  if (getResult() != null) {
                    remoteCallback.callback(getResult());
                    return false;
                  } else if (providedErrorCallback != null) {
                    return providedErrorCallback.error(message, throwable);
                  }
                  return true;
                }
              };
              proceed(interceptorCallback);
            }
          };
          callContext.setParameters(new Object[] { });
          callContext.proceed();
        } catch (Throwable throwable) {
          if (errorCallback != null) {
            errorCallback.error(null, throwable);
          } else {
            invokeDefaultErrorHandlers(throwable);
          }
        }
      }

      public User getUser() {
        try {
          final CallContextStatus status = new CallContextStatus(AuthenticationServiceInterceptor.class);
          final RemoteCallContext callContext = new RemoteCallContext() {
            public String getMethodName() {
              return "getUser";
            }
            public Class getReturnType() {
              return User.class;
            }
            public Annotation[] getAnnotations() {
              return new Annotation[] { };
            }
            public Annotation[] getTypeAnnotations() {
              return new Annotation[] { };
            }
            public Object proceed() {
              status.proceed();
              if (status.getNextInterceptor() == null) {
                RemoteCallSendable sendable = null;
                if (errorCallback == null) {
                  sendable = MessageBuilder.createCall().call("org.jboss.errai.security.shared.service.AuthenticationService").endpoint("getUser:", qualifiers, getParameters()).respondTo(User.class, remoteCallback).defaultErrorHandling();
                } else {
                  sendable = MessageBuilder.createCall().call("org.jboss.errai.security.shared.service.AuthenticationService").endpoint("getUser:", qualifiers, getParameters()).respondTo(User.class, remoteCallback).errorsHandledBy(errorCallback);
                }
                org_jboss_errai_security_shared_service_AuthenticationServiceImpl.this.sendRequest(bus, sendable);
              } else if (status.getNextInterceptor() == AuthenticationServiceInterceptor.class) {
                final RemoteCallContext ctx = this;
                final CreationalCallback icc = new CreationalCallback() {
                  public void callback(final Object beanInstance) {
                    status.setProceeding(false);
                    ((AuthenticationServiceInterceptor) beanInstance).aroundInvoke(ctx);
                    if ((!status.isProceeding()) && (AuthenticationServiceInterceptor.class == status.getNextInterceptor())) {
                      remoteCallback.callback(ctx.getResult());
                    }
                  }
                };
                org.jboss.errai.ioc.client.container.IOC.getAsyncBeanManager().lookupBeans(AuthenticationServiceInterceptor.class).iterator().next().getInstance(icc);
              }
              return null;
            }
            public void proceed(final RemoteCallback interceptorCallback) {
              final RemoteCallback providedCallback = org_jboss_errai_security_shared_service_AuthenticationServiceImpl.this.remoteCallback;
              remoteCallback = new RemoteCallback() {
                public void callback(Object response) {
                  RemoteCallback intCallback = interceptorCallback;
                  setResult(response);
                  intCallback.callback(getResult());
                  providedCallback.callback(getResult());
                }
              };
              proceed();
            }
            public void proceed(RemoteCallback interceptorCallback, final ErrorCallback interceptorErrorCallback) {
              final ErrorCallback providedErrorCallback = org_jboss_errai_security_shared_service_AuthenticationServiceImpl.this.errorCallback;
              errorCallback = new ErrorCallback() {
                public boolean error(Object message, Throwable throwable) {
                  interceptorErrorCallback.error(message, throwable);
                  if (getResult() != null) {
                    remoteCallback.callback(getResult());
                    return false;
                  } else if (providedErrorCallback != null) {
                    return providedErrorCallback.error(message, throwable);
                  }
                  return true;
                }
              };
              proceed(interceptorCallback);
            }
          };
          callContext.setParameters(new Object[] { });
          callContext.proceed();
        } catch (Throwable throwable) {
          if (errorCallback != null) {
            errorCallback.error(null, throwable);
          } else {
            invokeDefaultErrorHandlers(throwable);
          }
        }
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(AuthenticationService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_jboss_errai_security_shared_service_AuthenticationServiceImpl();
      }
    });
    class org_uberfire_component_service_MyServiceImpl extends AbstractRpcProxy implements MyService { public MyModel execute(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.component.service.MyService").endpoint("execute:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(MyModel.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.component.service.MyService").endpoint("execute:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(MyModel.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_component_service_MyServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(MyService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_uberfire_component_service_MyServiceImpl();
      }
    });
    class org_jboss_errai_security_shared_service_NonCachingUserServiceImpl extends AbstractRpcProxy implements NonCachingUserService { public User getUser() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jboss.errai.security.shared.service.NonCachingUserService").endpoint("getUser:", qualifiers, new Object[] { }).respondTo(User.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jboss.errai.security.shared.service.NonCachingUserService").endpoint("getUser:", qualifiers, new Object[] { }).respondTo(User.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jboss_errai_security_shared_service_NonCachingUserServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(NonCachingUserService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_jboss_errai_security_shared_service_NonCachingUserServiceImpl();
      }
    });
    class org_uberfire_backend_plugin_RuntimePluginsServiceImpl extends AbstractRpcProxy implements RuntimePluginsService { public Collection listFramworksContent() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.plugin.RuntimePluginsService").endpoint("listFramworksContent:", qualifiers, new Object[] { }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.plugin.RuntimePluginsService").endpoint("listFramworksContent:", qualifiers, new Object[] { }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_plugin_RuntimePluginsServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Collection listPluginsContent() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.plugin.RuntimePluginsService").endpoint("listPluginsContent:", qualifiers, new Object[] { }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.plugin.RuntimePluginsService").endpoint("listPluginsContent:", qualifiers, new Object[] { }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_plugin_RuntimePluginsServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public String getTemplateContent(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.plugin.RuntimePluginsService").endpoint("getTemplateContent:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.plugin.RuntimePluginsService").endpoint("getTemplateContent:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_plugin_RuntimePluginsServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(RuntimePluginsService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_uberfire_backend_plugin_RuntimePluginsServiceImpl();
      }
    });
  }
}