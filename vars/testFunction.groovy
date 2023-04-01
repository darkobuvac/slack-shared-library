import org.components.Divider

Divider call() {
  Divider divider = new Divider()

  Map output = divider.toSlackElement()

  return output
}
