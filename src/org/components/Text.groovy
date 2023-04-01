package org.components

import groovy.transform.CompileStatic

import org.commons.Types

/**
 * Text element (shared element in all slack block elements)
 */
@CompileStatic
class Text extends  BaseElement {

  String text

  Text(String text) {
      super(type: Types.PLAIN_TEXT)
    this.text = text
  }

}
