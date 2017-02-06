
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object edit_Scope0 {
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

class edit extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Account,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(acc : Account):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*4.2*/scripts/*4.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.13*/(""" 





"""),format.raw/*10.1*/("""<link rel="stylesheet" media="screen" href=""""),_display_(/*10.46*/routes/*10.52*/.Assets.at("stylesheets/plugins/datatables/dataTables.bootstrap.css")),format.raw/*10.121*/("""">  
<link rel="stylesheet" media="screen" href=""""),_display_(/*11.46*/routes/*11.52*/.Assets.at("stylesheets/dist/css/datatable/select.dataTables.min.css")),format.raw/*11.122*/("""">  
<script src=""""),_display_(/*12.15*/routes/*12.21*/.Assets.at("stylesheets/plugins/datatables/jquery.dataTables.min.js")),format.raw/*12.90*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*13.15*/routes/*13.21*/.Assets.at("stylesheets/plugins/datatables/dataTables.bootstrap.min.js")),format.raw/*13.93*/("""" type="text/javascript"></script>

<script src=""""),_display_(/*15.15*/routes/*15.21*/.Assets.at("javascripts/datatables/page_list.js")),format.raw/*15.70*/(""""></script>   


           """)))};
Seq[Any](format.raw/*1.17*/("""


"""),format.raw/*18.13*/("""

"""),_display_(/*20.2*/main(scripts)/*20.15*/ {_display_(Seq[Any](format.raw/*20.17*/("""

"""),format.raw/*22.1*/("""<a href=""""),_display_(/*22.11*/routes/*22.17*/.HomeController.list()),format.raw/*22.39*/("""">Return</a>
<br><br><br>






    



<br><br>

<table id="example" class="table table-bordered table-striped" cellspacing="0" width="100%">



   <thead>
      <tr>
         <th><input name="select_all" value="1" id="example-select-all" type="checkbox"></th>
         
		 <th>Account Code</th>                                 
         <th>Date</th>                        
         <th>Vendor</th>
         <th>Amount</th>
         <th>Location</th>
                
      </tr>
   </thead>





   <tbody>
            
            """),_display_(/*59.14*/for(x <- acc.accountdetails) yield /*59.42*/ {_display_(Seq[Any](format.raw/*59.44*/("""                  
            
            """),format.raw/*61.13*/("""<tr>
                <td>"""),_display_(/*62.22*/x/*62.23*/.vendor),format.raw/*62.30*/("""</td>

                <td>"""),_display_(/*64.22*/x/*64.23*/.vendor),format.raw/*64.30*/("""</td>

				        <td>"""),_display_(/*66.18*/x/*66.19*/.transactiondate),format.raw/*66.35*/("""</td>
				
                <td>"""),_display_(/*68.22*/x/*68.23*/.vendor),format.raw/*68.30*/("""</td>
                        
                <td>"""),_display_(/*70.22*/x/*70.23*/.amount),format.raw/*70.30*/("""</td>                     
				
				        <td>"""),_display_(/*72.18*/x/*72.19*/.location),format.raw/*72.28*/("""</td>                     
            </tr>

            """)))}),format.raw/*75.14*/("""

        """),format.raw/*77.9*/("""</tbody>



</table>


""")))}))
      }
    }
  }

  def render(acc:Account): play.twirl.api.HtmlFormat.Appendable = apply(acc)

  def f:((Account) => play.twirl.api.HtmlFormat.Appendable) = (acc) => apply(acc)

  def ref: this.type = this

}


}

/**/
object edit extends edit_Scope0.edit
              /*
                  -- GENERATED --
                  DATE: Sat Feb 04 20:43:46 EST 2017
                  SOURCE: C:/Users/Waheguru/Desktop/Project Play Framework Export/app/views/edit.scala.html
                  HASH: 9823d3cb896faee79883118b1e8aa35fbe26140b
                  MATRIX: 744->1|837->23|851->30|931->34|971->47|1043->92|1058->98|1149->167|1227->218|1242->224|1334->294|1381->314|1396->320|1486->389|1563->439|1578->445|1671->517|1750->569|1765->575|1835->624|1906->16|1940->656|1971->661|1993->674|2033->676|2064->680|2101->690|2116->696|2159->718|2760->1292|2804->1320|2844->1322|2918->1368|2972->1395|2982->1396|3010->1403|3067->1433|3077->1434|3105->1441|3158->1467|3168->1468|3205->1484|3266->1518|3276->1519|3304->1526|3385->1580|3395->1581|3423->1588|3501->1639|3511->1640|3541->1649|3634->1711|3673->1723
                  LINES: 27->1|31->4|31->4|33->4|39->10|39->10|39->10|39->10|40->11|40->11|40->11|41->12|41->12|41->12|42->13|42->13|42->13|44->15|44->15|44->15|48->1|51->18|53->20|53->20|53->20|55->22|55->22|55->22|55->22|92->59|92->59|92->59|94->61|95->62|95->62|95->62|97->64|97->64|97->64|99->66|99->66|99->66|101->68|101->68|101->68|103->70|103->70|103->70|105->72|105->72|105->72|108->75|110->77
                  -- GENERATED --
              */
          