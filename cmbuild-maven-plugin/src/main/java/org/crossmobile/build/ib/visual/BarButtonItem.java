// (c) 2020 by Panayotis Katsaloulis
// SPDX-License-Identifier: AGPL-3.0-only

package org.crossmobile.build.ib.visual;

import org.crossmobile.build.ib.Elements;
import org.crossmobile.build.ib.Values;
import org.crossmobile.build.ib.helper.Action;
import org.crossmobile.build.ib.helper.Connections;
import org.crossmobile.build.ib.helper.RealElement;
import org.crossmobile.build.ib.helper.Segue;

public class BarButtonItem extends RealElement {

    @Override
    protected void addSupported() {
        super.addSupported();
        addSupportedAttribute("title", Values.LocalizedString);
        addSupportedAttribute("image", Values.String);
        addSupportedAttribute("key", Values.String);
        addSupportedAttribute("style", Values.Enum);
        addSupportedAttribute("systemItem", Values.Enum);
    }

    public String variable() {
        return super.variable();
    }

    @Override
    protected String constructor() {
        StringBuilder out = new StringBuilder();

        if (attr("image") != null) {
            out.append("new ").append(getClassName()).append("(UIImage.imageNamed(").append(attr("image")).append("), UIBarButtonItemStyle.").append(attr("style", "plain")).append(", ()->{").append(NEWLINE);
            for (Connections c : parts(Elements.Connections)) {
                for (Action o : c.parts(Elements.Action))
                    appendLambda(out, o.getAction(variable()));
                for (Segue o : c.parts(Elements.Segue))
                    appendLambda(out, o.getSegway(variable()));
            }
            out.append(I4).append("})");
        } else if (attr("title") != null) {
            out.append("new ").append(getClassName()).append("(").append(attr("title")).append(", UIBarButtonItemStyle.").append(attr("style", "plain")).append(", ()->{").append(NEWLINE);
            for (Connections c : parts(Elements.Connections)) {
                for (Action o : c.parts(Elements.Action))
                    appendLambda(out, o.getAction(variable()));
                for (Segue o : c.parts(Elements.Segue))
                    appendLambda(out, o.getSegway(variable()));
            }
            out.append(I4).append("})");
        } else if (attr("systemItem") != null) {
            out.append("new ").append(getClassName()).append("(UIBarButtonSystemItem.").append(attr("systemItem")).append(", ()->{").append(NEWLINE);
            for (Connections c : parts(Elements.Connections)) {
                for (Action o : c.parts(Elements.Action))
                    appendLambda(out, o.getAction(variable()));
                for (Segue o : c.parts(Elements.Segue))
                    appendLambda(out, o.getSegway(variable()));
            }
            out.append(I4).append("})");
        }
        return out.toString();
    }

    private void appendLambda(StringBuilder out, String value){
        out.append(I5).append(value).append(";").append(NEWLINE);
    }

    @Override
    public String toCode() {
        return super.toCode();
    }
}
