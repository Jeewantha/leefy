package leefy;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:**/resources/beans-spring.xml",
		"classpath:**/resources/rest-service-beans.xml", "classpath:**/resources/security-context.xml" })
public class ProductServicesImplTest {

	@Test
	public void testGetProduct() throws Exception {


		get("/leefy/services/productServices/product/123").then().body(
				"productId", equalTo("123"));
	}

}
