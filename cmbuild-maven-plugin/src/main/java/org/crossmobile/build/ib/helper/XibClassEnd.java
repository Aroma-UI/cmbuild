/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: AGPL-3.0-only
 */

package org.crossmobile.build.ib.helper;


public class XibClassEnd extends Objects {

    @Override
    protected void addSupported() {

    }

    @Override
    public String toCode() {
        StringBuilder out = new StringBuilder();
        out.append(I2).append("@Override").append(NEWLINE);
        out.append(I2).append("public UIViewController instantiateViewControllerWithIdentifier(String identifier) {").append(NEWLINE);
        out.append(I3).append("switch (identifier){").append(NEWLINE);
        for (String id : VCIDENT.keySet()) {
            out.append(I4).append("case \"").append(id).append("\":").append(NEWLINE);
            out.append(I5).append("return ").append("new ").append(VCIDENT.get(id)).append("();").append(NEWLINE);
        }
        out.append(I3).append("}").append(NEWLINE);
        out.append(I3).append("return null;").append(NEWLINE);
        out.append(I2).append("}").append(NEWLINE);
        out.append(I1).append("}").append(NEWLINE);
        VCIDENT.clear();
        return out.toString();
    }
}
