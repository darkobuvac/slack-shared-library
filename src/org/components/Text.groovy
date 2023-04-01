package org.components

import groovy.transform.CompileDynamic

import org.commons.Types

/**
 * Text element (shared element in all slack block elements)
 */
@CompileDynamic
class Text extends  BaseElement {

  String text
  boolean emoji

  Text(String text, boolean emoji = true) {
      super(Types.PLAIN_TEXT)
    this.text = text
    this.emoji = emoji
  }

  Map toSlackElement() {
    return [
      type: this.type,
      text: this.text,
      emoji: this.emoji
    ]
  }

}
