package org.messages

import groovy.transform.CompileDynamic

import org.commons.Types

import org.components.Header
import org.components.Divider
import org.components.SectionText

/**
 * Text element (shared element in all slack block elements)
 */
@CompileDynamic
class StartBuildMessage {

  Header header
  SectionText infoMsg
  Divider divider

  StartBuildMessage(Map data = [:]) {
    this.header = new Header('Pipeline started', 'construction')
    this.infoMsg = new SectionText("${data.projct} build & deploy pipeline has been launched", '', Types.PLAIN_TEXT)
    this.divider = new Divider()
  }

  Map toSlackBlock() {
    Map result = [
      header,
      infoMsg,
      divider
    ]

    return result
  }

}
