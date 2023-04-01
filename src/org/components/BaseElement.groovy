package org.components

/**
 * Base element class for slack block elements
 */
@CompileStatic
class BaseElement {

    String type

    BaseElement(String type) {
        this.type = type
    }

}
