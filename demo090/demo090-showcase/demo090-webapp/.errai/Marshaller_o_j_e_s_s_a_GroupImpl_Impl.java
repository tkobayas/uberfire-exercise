package org.jboss.errai.marshalling.client.api;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;
import org.jboss.errai.security.shared.api.GroupImpl;

public class Marshaller_o_j_e_s_s_a_GroupImpl_Impl implements GeneratedMarshaller<GroupImpl> {
  private GroupImpl[] EMPTY_ARRAY = new GroupImpl[0];
  private Marshaller<String> java_lang_String = Marshalling.getMarshaller(String.class);
  public GroupImpl[] getEmptyArray() {
    return EMPTY_ARRAY;
  }

  private native static String _$2134670738__1195259493_name(GroupImpl instance) /*-{
    return instance.@org.jboss.errai.security.shared.api.GroupImpl::name;
  }-*/;

  private native static void _$2134670738__1195259493_name(GroupImpl instance, String value) /*-{
    instance.@org.jboss.errai.security.shared.api.GroupImpl::name = value;
  }-*/;

  public GroupImpl demarshall(EJValue a0, MarshallingSession a1) {
    lazyInit();
    EJObject obj = a0.isObject();
    if (obj == null) {
      return null;
    }
    String objId = obj.get("^ObjectID").isString().stringValue();
    if (a1.hasObject(objId)) {
      return a1.getObject(GroupImpl.class, objId);
    }
    final String c0 = java_lang_String.demarshall(obj.get("group"), a1);
    GroupImpl entity = new GroupImpl(c0);
    a1.recordObject(objId, entity);
    if ((obj.containsKey("name")) && (!obj.get("name").isNull())) {
      _$2134670738__1195259493_name(entity, java_lang_String.demarshall(obj.get("name"), a1));
    }
    return entity;
  }

  public String marshall(GroupImpl a0, MarshallingSession a1) {
    lazyInit();
    if (a0 == null) {
      return "null";
    }
    final boolean ref = a1.hasObject(a0);
    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"org.jboss.errai.security.shared.api.GroupImpl\",\"^ObjectID\"");
    json.append(":\"").append(a1.getObject(a0)).append("\"");
    if (ref) {
      return json.append("}").toString();
    }
    return json.append(",").append("\"name\":").append(java_lang_String.marshall(a0.getName(), a1)).append("}").toString();
  }

  private void lazyInit() {

  }
}