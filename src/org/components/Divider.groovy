package org.components

import groovy.transform.CompileStatic

import org.commons.Types

/**
 * Divider element
 */
@CompileStatic
class Divider extends  BaseElement {

  Divider() {
    super(type: Types.DIVIDER)
  }

}
