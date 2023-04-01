import org.components.Divider

Map call() {
  Divider divider = new Divider()

  Map slackBlock = divider.toSlackElement()

  echo "${slackBlock}"

  echo "${divider}"

  return slackBlock
}
