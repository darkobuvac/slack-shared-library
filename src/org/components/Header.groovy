package org.components

import groovy.transform.CompileStatic

import org.commons.Types

/**
 * Header element
 */
@CompileStatic
class Header extends  BaseElement {

  Header() {
      super(type: Types.HEADER)
  }

}
