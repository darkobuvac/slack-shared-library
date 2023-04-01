import org.components.Divider

Divider call() {
  Divider divider = new Divider()

  Map slackBlock = divider.toSlackElement()

  echo "${slackBlock}"

  echo "${divider}"

  return divider
}
