package org.components

import groovy.transform.CompileDynamic

import org.commons.Types

/**
 * Divider element
 */
@CompileDynamic
class Divider extends  BaseElement {

  Divider() {
    super(Types.DIVIDER)
  }

  Map toSlackElement() {
    return [type: "${this.type}"]
  }

}
