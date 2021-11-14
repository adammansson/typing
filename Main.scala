package typing

import javax.swing.*
import java.awt.*
import scala.util.Random.*

object Main:
  def main(args: Array[String]): Unit =
    val frame = new JFrame("typing")
    frame.setSize(400,300)
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)

    val panel = new JPanel(new BorderLayout())
    val textField = new JTextField()

    val textObj = Text.fromFile("inferno.txt")
    var words = textObj.words

    var ind = nextInt(words.length)
    val label = new JLabel(words(ind))
    label.setFont(label.getFont().deriveFont(28F))
    label.setBounds(100, 200, 100, 300)

    frame.getContentPane()add(BorderLayout.CENTER, label)
    frame.getContentPane().add(BorderLayout.SOUTH, textField)

    frame.setVisible(true)

    while true do
      if textField.getText == "quit" then
        System.exit(0)
      else if
       textField.getText == label.getText then
        textField.setText("")

        ind = nextInt(words.length)
        label.setText(words(ind))
        
