package org.components

import groovy.transform.CompileDynamic

import org.commons.Types

/**
 * Text element (shared element in all slack block elements)
 */
@CompileDynamic
class Text extends  BaseElement {

  String value
  String type
  boolean emoji

  Text(String type, String value, boolean emoji = true) {
      super(type)
    this.value = value
    this.type = type
    this.emoji = emoji
  }

  Map toSlackElement() {
    Map result = [
      type: this.type,
      value: this.value,

    ]

    if (this.type == Types.PLAIN_TEXT) {
      result << [emoji: this.emoji]
    }

    return result
  }

}
