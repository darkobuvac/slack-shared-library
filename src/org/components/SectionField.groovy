package org.components

import groovy.transform.CompileDynamic
import org.apache.commons.lang.StringUtils

import org.commons.Types

/**
 * Text element (shared element in all slack block elements)
 */
@CompileDynamic
class SectionField extends  BaseElement {

  List<Map> data
  List<Map> fields = []

  void populateFields() {
    for (item in data) {
      String value = StringUtils.isBlank(item.icon) ? "${item.value}" : ":${item.icon}: ${item.value}"
      Text textEl = new Text(Types.MARK_DOWN, value)

      this.fields.add(textEl.toSlackElement())
    }
  }

  SectionField(List<Map> data) {
    super(Types.SECTION)
    this.data = data

    this.populateFields()
  }

  Map toSlackElement() {
    return [
      type: this.type,
      fields: this.fields
    ]
  }

}
