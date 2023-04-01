import org.components.Divider

Divider call() {
  Divider divider = new Divider()

  echo "${divider.inspect()}"

  return divider
}
