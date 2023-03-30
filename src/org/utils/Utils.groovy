class Utils implements Serializable {

  Utils() {}

  def buildSection(String name, String value){
    return [type: "section", text: [type: "mrkdwn", text: "*${name}:* ${value}"]]
  }
}