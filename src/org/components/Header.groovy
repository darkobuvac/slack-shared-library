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
  String trailIcon
  Text text

  Header(String title, String icon, String trailIcon = "") {
      super(Types.HEADER)
    this.title = title
    this.icon = icon
    this.trailIcon = trailIcon

    String headerMsg = StringUtils.isBlank(icon) ? "${this.title}" : ":${this.icon}: ${this.title}"

    headerMsg = StringUtils.isBlank(trailIcon) ? "${headerMsg} :${this.trailIcon}:" : "${headerMsg}"

    this.text = new Text(Types.PLAIN_TEXT, headerMsg)
  }

  Map toSlackElement() {
    return [
      type: this.type,
      text: this.text.toSlackElement()
    ]
  }

}
