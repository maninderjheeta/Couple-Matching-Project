
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object main_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Html,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(scripts: Html = Html(""))(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.43*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html>
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  
  <title>Maninder Project</title>
  
  <link rel="shortcut icon" type="image/ico" href=""""),_display_(/*14.53*/routes/*14.59*/.Assets.at("images/favicon.ico")),format.raw/*14.91*/("""">
  
  
 <link type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.12/se-1.2.0/datatables.min.css" rel="stylesheet" />
<link type="text/css" href="https://gyrocode.github.io/jquery-datatables-checkboxes/1.0.4/css/dataTables.checkboxes.css" rel="stylesheet" />
<script type="text/javascript" src="https://gyrocode.github.io/jquery-datatables-checkboxes/1.0.4/js/dataTables.checkboxes.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script> 

"""),_display_(/*22.2*/scripts),format.raw/*22.9*/("""
"""),format.raw/*23.1*/("""</head>
<body>



"""),_display_(/*28.2*/content),format.raw/*28.9*/("""




"""),format.raw/*33.1*/("""</body>
</html>
"""))
      }
    }
  }

  def render(scripts:Html,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(scripts)(content)

  def f:((Html) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (scripts) => (content) => apply(scripts)(content)

  def ref: this.type = this

}


}

/**/
object main extends main_Scope0.main
              /*
                  -- GENERATED --
                  DATE: Sat Feb 04 20:43:46 EST 2017
                  SOURCE: C:/Users/Waheguru/Desktop/Project Play Framework Export/app/views/main.scala.html
                  HASH: d28928f15f95a9c9a266b71bd07007352af98030
                  MATRIX: 746->1|882->42|910->44|1248->355|1263->361|1316->393|1847->898|1874->905|1902->906|1947->925|1974->932|2006->937
                  LINES: 27->1|32->1|34->3|45->14|45->14|45->14|53->22|53->22|54->23|59->28|59->28|64->33
                  -- GENERATED --
              */
          