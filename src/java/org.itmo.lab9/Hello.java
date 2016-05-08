/*
 * Copyright 2010 Oracle and/or its affiliates.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developer.sun.com/berkeley_license.html
 */


package org.itmo.lab9;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class Hello {
    final String world = "YAICHKI";

    public String getworld() {
        return world;
    }
}
