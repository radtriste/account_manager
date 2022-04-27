package fr.tradisson.account.manager.resources;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.tradisson.account.manager.database.internal.filesystem.TransactionStorageFS;
import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import javax.inject.Inject;

@QuarkusTest
public class TransactionResourceTest {

  @Inject
  TransactionStorageFS storage;

  @BeforeEach
  public void setUp() {
    storage.clear();
  }

  @AfterEach
  public void tearDown() {
    storage.clear();
  }

  @Test
  public void testAddTransactionEndpoint() {
    given()
          .when()
          .post("/transaction")
          .then()
             .statusCode(200);
  }
}
