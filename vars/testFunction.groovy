import org.components.Divider

def call() {
  def divider = new Divider()

  echo "${divider}"

  return divider
}
