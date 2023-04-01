package org.components

import groovy.transform.CompileStatic

/**
 * Base element class for slack block elements
 */
@CompileStatic
abstract class BaseElement {

    String type

    protected BaseElement(String type) {
        this.type = type
    }

    abstract Map toSlackElement()

}
