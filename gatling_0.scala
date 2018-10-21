package computerdatabase

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

class BasicSimulation extends Simulation {
val httpConfNoWarmUp = http.disableWarmUp
val httpConfMax10Connections = http.maxConnectionsPerHost(10)

val httpProtocol = http
  .baseUrl("http://faroukkhelil-eval-test.apigee.net")
//  .baseUrl("http://test-receiver.herokuapp.com")
 val scn = scenario("RecordedSimulation")
   .exec(http("request_0").post("/customersservice")
//   .exec(http("request_0").post("/customers")
   .queryParam("apikey", "gZyJdIzUMWQtzlRUDwNCgx0T5kYGnEk7")
   .body(StringBody("""{"customer_id":"12345", "first_name" : "toto", "last_name" : "titi","town" : "Tunis"}"""))
   .asJson
   .check(status.is(200)))

setUp(scn.inject(constantUsersPerSec(1) during(1000))).protocols(httpProtocol)

}
