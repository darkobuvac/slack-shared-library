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
  boolean showIcon
  String icon
  Text text

  Header(String title, String icon) {
      super(type: Types.HEADER)
    this.title = title
    this.showIcon = StringUtils.isBlank(icon)
    this.text = new Text(getTitle())
  }

  String getTitle() {
    return this.showIcon ? ":${this.icon}: ${this.title}" : "${this.title}"
  }

  Map toSlackElement() {
    return [
      type: this.type,
      text: this.text.toSlackElement()
    ]
  }

}
