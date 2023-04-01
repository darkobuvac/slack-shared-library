package org.components

import groovy.transform.CompileStatic

import org.commons.Types

/**
 * Divider element
 */
@CompileStatic
class Divider extends  BaseElement {

  Divider() {
    super(Types.DIVIDER)
  }

  // Map toSlackElement() {
  //   return [type: "${this.type}"]
  // }

}
