package typing

case class Text(source: String):
  lazy val words: Vector[String] =   // dela upp source i ord
    var result = source.map(c => if !c.isLetter then ' ' else c).split(' ').filterNot(_.isEmpty)

    result = result.filter(e => e.length > 3)

    result.toVector

  lazy val distinct: Vector[String] = words.distinct

  lazy val wordSet: Set[String] = words.toSet

  def ngrams(n: Int): Vector[Vector[String]] =   // använd sliding
    words.sliding(n).toVector

  lazy val bigrams: Vector[(String, String)] =
    ngrams(2).map(xs => (xs(0), xs(1)))

object Text:
  def fromFile(fileName: String, encoding: String = "UTF-8"): Text =
    val source = scala.io.Source.fromFile(fileName, encoding)
    val txt = try source.mkString finally source.close()
    Text(txt)
  
  def fromURL(url: String, encoding: String = "UTF-8"): Text =
    val source = scala.io.Source.fromURL(url, encoding)
    val txt = try source.mkString finally source.close()
    Text(txt)