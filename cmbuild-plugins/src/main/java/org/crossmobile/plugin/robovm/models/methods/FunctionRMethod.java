/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
package org.crossmobile.plugin.robovm.models.methods;

import javassist.CtClass;
import javassist.Modifier;
import org.crossmobile.plugin.model.NObject;
import org.crossmobile.plugin.model.NSelector;
import org.crossmobile.plugin.robovm.models.parameters.RParam;

import java.util.List;

import static org.crossmobile.plugin.bro.JavaTransformer.BRIDGE_ANN;
import static org.crossmobile.utils.JavassistAnnParam.toParam;
import static org.crossmobile.utils.JavassistUtils.addAnnotation;

public class FunctionRMethod extends RMethod {
    public FunctionRMethod(NSelector selector, RParam returnParam, List<RParam> parameters, NObject object, CtClass cclass) {
        super(selector, returnParam, parameters, object, cclass);
    }

    @Override
    protected void setModifiers() {
        method.setModifiers(Modifier.PRIVATE | Modifier.NATIVE | Modifier.STATIC);
    }

    @Override
    protected void setMappingModifiers() {
        mapping.setModifiers(Modifier.PUBLIC);
    }

    @Override
    protected void addMethodAnnotation() {
        addAnnotation(method, BRIDGE_ANN, toParam("symbol", getSelector().getName()), toParam("optional", true));
    }
}
