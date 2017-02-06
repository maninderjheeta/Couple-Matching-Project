
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Waheguru/Desktop/Project Play Framework Export/conf/routes
// @DATE:Sat Feb 04 20:43:45 EST 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
