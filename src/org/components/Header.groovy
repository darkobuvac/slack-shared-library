package org.components

import groovy.transform.CompileDynamic
import org.apache.commons.lang.StringUtils

import org.commons.Types

/**
 * Header element
 */
@CompileDynamic
class Header extends  BaseElement {

  String title
  String icon
  Text text

  Header(String title, String icon) {
      super(Types.HEADER)
    this.title = title
    this.icon = icon
    this.text = new Text(Types.PLAIN_TEXT, StringUtils.isBlank(icon) ? "${this.title}" : ":${this.icon}: ${this.title}")
  }

  Map toSlackElement() {
    return [
      type: this.type,
      text: this.text.toSlackElement()
    ]
  }

}
