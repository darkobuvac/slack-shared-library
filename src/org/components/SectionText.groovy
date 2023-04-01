package org.components

import groovy.transform.CompileDynamic
import org.apache.commons.lang.StringUtils

import org.commons.Types

/**
 * Text element (shared element in all slack block elements)
 */
@CompileDynamic
class SectionText extends  BaseElement {

  String value
  String textElementType
  Text textElement
  String icon
  boolean isBold

  SectionText(String value, String icon, String textElementType, boolean isBold = true) {
      super(Types.SECTION)
    this.value = value
    this.icon = icon
    this.textElementType = textElementType
    this.isBold = isBold

    String title = StringUtils.isBlank(icon) ? "${this.value}" : ":${this.icon}: ${this.value}"
    this.textElement = new Text(this.textElementType, title)
  }

  Map toSlackElement() {
    return [
      type: this.type,
      text: this.textElement.toSlackElement()
    ]
  }

}
