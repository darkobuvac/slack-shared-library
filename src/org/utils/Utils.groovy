package org.utils

class Utils implements Serializable {

  Utils() {}

  def buildSection(String name, String value, String icon){
    return [type: "section", text: [type: "mrkdwn", text: ":${icon}: *${name}:* ${value}"]]
  }

  def buildDivider(){
    return [type: "divider"]
  }

  def buildHeader(String msg){
    return [
      "type": "header",
      "text": [
        "type": "plain_text",
        "text": ":construction: ${msg}",
        "emoji": true
      ]
    ]
  }
}