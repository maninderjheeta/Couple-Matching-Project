
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object list_Scope0 {
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

class list extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[Account],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(acc : List[Account]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*4.2*/scripts/*4.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/(""" 





"""),format.raw/*10.1*/("""<link rel="stylesheet" media="screen" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.at("stylesheets/plugins/datatables/dataTables.bootstrap.css")),format.raw/*10.121*/("""">  
<link rel="stylesheet" media="screen" href=""""),_display_(/*11.46*/routes/*11.52*/.Assets.at("stylesheets/dist/css/datatable/select.dataTables.min.css")),format.raw/*11.122*/("""">  
<script src=""""),_display_(/*12.15*/routes/*12.21*/.Assets.at("stylesheets/plugins/datatables/jquery.dataTables.min.js")),format.raw/*12.90*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*13.15*/routes/*13.21*/.Assets.at("stylesheets/plugins/datatables/dataTables.bootstrap.min.js")),format.raw/*13.93*/("""" type="text/javascript"></script>

<script src=""""),_display_(/*15.15*/routes/*15.21*/.Assets.at("javascripts/datatables/page_list.js")),format.raw/*15.70*/(""""></script>   


<style>
.button """),format.raw/*19.9*/("""{"""),format.raw/*19.10*/("""
    """),format.raw/*20.5*/("""background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
"""),format.raw/*30.1*/("""}"""),format.raw/*30.2*/("""

"""),format.raw/*32.1*/(""".button2 """),format.raw/*32.10*/("""{"""),format.raw/*32.11*/("""background-color: #008CBA;"""),format.raw/*32.37*/("""}"""),format.raw/*32.38*/(""" """),format.raw/*32.39*/("""/* Blue */
.button3 """),format.raw/*33.10*/("""{"""),format.raw/*33.11*/("""background-color: #f44336;"""),format.raw/*33.37*/("""}"""),format.raw/*33.38*/(""" """),format.raw/*33.39*/("""/* Red */ 
.button4 """),format.raw/*34.10*/("""{"""),format.raw/*34.11*/("""background-color: #e7e7e7; color: black;"""),format.raw/*34.51*/("""}"""),format.raw/*34.52*/(""" """),format.raw/*34.53*/("""/* Gray */ 
.button5 """),format.raw/*35.10*/("""{"""),format.raw/*35.11*/("""background-color: #555555;"""),format.raw/*35.37*/("""}"""),format.raw/*35.38*/(""" """),format.raw/*35.39*/("""/* Black */
</style>

           """)))};
Seq[Any](format.raw/*1.23*/("""


"""),format.raw/*38.13*/("""

"""),_display_(/*40.2*/main(scripts)/*40.15*/ {_display_(Seq[Any](format.raw/*40.17*/("""

"""),format.raw/*42.1*/("""<form method="POST" action="/CustomActions">


<button class="button button2" type="submit" name="action" value="HTML Report" formtarget="_blank">HTML Report</button>
<button class="button button3" type="submit" name="action" value="PDF Report" formtarget="_blank">PDF Report</button>
<button class="button button4" type="submit" name="action" value="General Report" formtarget="_blank">Matching Report</button>


<br><br><br>
<table id="example" class="table table-bordered table-striped" cellspacing="0" width="100%">



   <thead>
      <tr>
         <th><input name="select_all" value="1" id="example-select-all" type="checkbox"></th>
         
		 <th>Account Code</th>                                 
                
      </tr>
   </thead>





   <tbody>
                             
            
            """),_display_(/*71.14*/for(x <- acc) yield /*71.27*/{_display_(Seq[Any](format.raw/*71.28*/("""
			
			"""),format.raw/*73.4*/("""<tr>
            
                <td>"""),_display_(/*75.22*/x/*75.23*/.id),format.raw/*75.26*/("""</td>
                      
                <td><a href=""""),_display_(/*77.31*/routes/*77.37*/.HomeController.edit(x.id)),format.raw/*77.63*/("""">"""),_display_(/*77.66*/x/*77.67*/.id),format.raw/*77.70*/("""</a></td>
			""")))}),format.raw/*78.5*/("""
				
                    
            """),format.raw/*81.13*/("""</tr>

            

        </tbody>



</table>
</form>

""")))}))
      }
    }
  }

  def render(acc:List[Account]): play.twirl.api.HtmlFormat.Appendable = apply(acc)

  def f:((List[Account]) => play.twirl.api.HtmlFormat.Appendable) = (acc) => apply(acc)

  def ref: this.type = this

}


}

/**/
object list extends list_Scope0.list
              /*
                  -- GENERATED --
                  DATE: Sat Feb 04 20:43:46 EST 2017
                  SOURCE: C:/Users/Waheguru/Desktop/Project Play Framework Export/app/views/list.scala.html
                  HASH: 0f3f46ad674bc9256dcf820f5ee390b985b5f18e
                  MATRIX: 750->1|849->29|863->36|943->40|983->53|1055->98|1070->104|1161->173|1239->224|1254->230|1346->300|1393->320|1408->326|1498->395|1575->445|1590->451|1683->523|1762->575|1777->581|1847->630|1911->667|1940->668|1973->674|2250->924|2278->925|2309->929|2346->938|2375->939|2429->965|2458->966|2487->967|2536->988|2565->989|2619->1015|2648->1016|2677->1017|2726->1038|2755->1039|2823->1079|2852->1080|2881->1081|2931->1103|2960->1104|3014->1130|3043->1131|3072->1132|3148->22|3182->1169|3213->1174|3235->1187|3275->1189|3306->1193|4182->2042|4211->2055|4250->2056|4287->2066|4355->2107|4365->2108|4389->2111|4477->2172|4492->2178|4539->2204|4569->2207|4579->2208|4603->2211|4648->2226|4718->2268
                  LINES: 27->1|31->4|31->4|33->4|39->10|39->10|39->10|39->10|40->11|40->11|40->11|41->12|41->12|41->12|42->13|42->13|42->13|44->15|44->15|44->15|48->19|48->19|49->20|59->30|59->30|61->32|61->32|61->32|61->32|61->32|61->32|62->33|62->33|62->33|62->33|62->33|63->34|63->34|63->34|63->34|63->34|64->35|64->35|64->35|64->35|64->35|68->1|71->38|73->40|73->40|73->40|75->42|104->71|104->71|104->71|106->73|108->75|108->75|108->75|110->77|110->77|110->77|110->77|110->77|110->77|111->78|114->81
                  -- GENERATED --
              */
          