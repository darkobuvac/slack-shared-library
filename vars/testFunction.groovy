import org.components.Divider

Divider call() {
  Divider divider = new Divider()

  echo "${divider.toSlackElement()}"

  return divider
}
