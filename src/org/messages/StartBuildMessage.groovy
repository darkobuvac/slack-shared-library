package org.messages

import groovy.transform.CompileDynamic

import org.commons.Types

import org.components.Header
import org.components.Divider
import org.components.SectionText
import org.components.SectionField

/**
 * Text element (shared element in all slack block elements)
 */
@CompileDynamic
class StartBuildMessage {

  Header header
  SectionText infoMsg
  Divider divider
  SectionField firstSection

  StartBuildMessage(Map data = [:]) {
    this.header = new Header('data.message', 'construction')
    this.infoMsg = new SectionText("${data.projct} build & deploy pipeline has been launched", '', Types.PLAIN_TEXT)
    this.divider = new Divider()
    this.firstSection = new SectionField([
      [
        value: '*Project*: CxO Customer management',
        icon: 'rocket'
      ],
      [
        value: '*Started at*: 2023-03-30 12:30 PM',
        icon: 'date'
      ]
    ])
  }

  List<Object> toSlackBlock() {
    List<Object> result = [
     this.header.toSlackElement(),
     this.infoMsg.toSlackElement(),
     this.divider.toSlackElement(),
     this.firstSection.toSlackElement()
    ]

    return result
  }

}
