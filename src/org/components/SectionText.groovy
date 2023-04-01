package org.components

import groovy.transform.CompileDynamic
import org.apache.commons.lang.StringUtils

import org.commons.Types

/**
 * Text element (shared element in all slack block elements)
 */
@CompileDynamic
class SectionText extends  BaseElement {

  String text
  String textElementType
  Text textElement
  boolean showIcon
  String icon
  boolean isBold

  SectionText(String text, String icon, String textElementType, boolean isBold = true) {
      super(Types.SECTION)
    this.showIcon = StringUtils.isBlank(icon)
    this.text = text
    this.icon = icon
    this.textElementType = textElementType
    this.isBold = isBold

    String title = this.isBold ? "*${text}*" : "${text}"
    this.textElement = new Text(this.textElementType, this.showIcon ? "${title}" : ":${this.icon}: ${title}")
  }

  Map toSlackElement() {
    return [
      type: this.type,
      text: this.textElement.toSlackElement()
    ]
  }

}
