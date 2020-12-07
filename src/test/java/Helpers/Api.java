package Helpers;



import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

import javax.swing.text.Document;

import static io.restassured.RestAssured.given;

public class Api {
    public final String HOST = "localhost:3000/";

    public String signIn(){
        String response= given().log().all()
                .port(3000)
                .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3")
                .contentType("application/x-www-form-urlencoded")
                .formParam("authenticity_token","s1k42RhCmMj5rqQRbbpumG1xwyhbfHum1SRgljwSloDSTsUa6aaRnqmuC/8CcqXmxqEmFxTGFn0tKtNM2IaFNA==")
                .formParam("user[email]","user01.gmail.com")
                .formParam("user[password]","123456")
                .formParam("user[remember_me]",0)
                .when()
                .post(HOST + "users/sign_in")
                .then().log().body()
                .assertThat().statusCode(302).extract().response().body().asString();
        return response;
    }

    public String signInGet(){
        String response= given().log().all()
                .port(3000)
                .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3")
                .contentType("application/x-www-form-urlencoded")
                .when()
                .get(HOST + "users/sign_in")
                .then().log().body()
                .assertThat().statusCode(200).extract().response().body().asString();
        return response;
    }


}
