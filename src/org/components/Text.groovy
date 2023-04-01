package org.components

import groovy.transform.CompileDynamic

import org.commons.Types

/**
 * Text element (shared element in all slack block elements)
 */
@CompileDynamic
class Text extends  BaseElement {

  String text
  String type
  boolean emoji

  Text(String type, String text, boolean emoji = true) {
      super(type)
    this.text = text
    this.type = type
    this.emoji = emoji
  }

  Map toSlackElement() {
    Map result = [
      type: this.type,
      text: this.text,

    ]

    if (this.type == Types.PLAIN_TEXT) {
      result << [emoji: this.emoji]
    }

    return result
  }

}
