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

  SectionText(Map data = [:]) {
      super(Types.SECTION)
    this.showIcon = StringUtils.isBlank(data.icon)
    this.text = data.text
    this.icon = data.icon
    this.textElementType = data.textElementType
    this.isBold = data.isBold
    this.textElement = new Text(this.textElementType, genearteTitle())
  }

  Map toSlackElement() {
    return [
      type: this.type,
      text: this.textElement.toSlackElement()
    ]
  }

  private String genearteTitle() {
    String title = this.isBold ? "*${this.text}*" : "${this.text}"
    return this.showIcon ? ":${this.icon}: ${title}" : "${title}"
  }

}
