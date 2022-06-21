package in.co.gorest.gorestinfo;

import in.co.gorest.constants.EndPoints;
import in.co.gorest.model.GorestPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class UsersSteps {

    @Step("Creating User with name : {0}, Gender: {1}, email: {2}, status: {3}")
    public ValidatableResponse createUser(String name, String gender, String email, String status) {
        GorestPojo gorestPojo= new GorestPojo();
        gorestPojo.setName(name);
        gorestPojo.setGender(gender);
        gorestPojo.setEmail(email);
        gorestPojo.setStatus(status);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 0f23b136e758c180b7e1e8eae923b96a7a792697594a0925c10f3c923405d9dc")
                .body(gorestPojo)
                .when()
                .post(EndPoints.CREATE_USER)
                .then();
    }

    @Step("Fetching user ID : {0}")
    public ValidatableResponse getUserByID(int userID) {

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer abc123")
                .pathParam("userID", userID)
                .when()
                .get(EndPoints.UPDATE_USER_BY_ID)
                .then();
    }

    @Step("Fetching All user")
    public ValidatableResponse getAllUsers() {

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 0f23b136e758c180b7e1e8eae923b96a7a792697594a0925c10f3c923405d9dc")
                .when()
                .get(EndPoints.GET_ALL_USER)
                .then();
    }

    @Step("Update User with ID:{0},name : {1}, Gender: {2}, email: {3}, status: {4}")
    public ValidatableResponse updateUser(int userID, String name, String gender, String email, String status) {
        GorestPojo gorestPojo = new GorestPojo();
        gorestPojo.setName(name);
        gorestPojo.setGender(gender);
        gorestPojo.setEmail(email);
        gorestPojo.setStatus(status);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 0f23b136e758c180b7e1e8eae923b96a7a792697594a0925c10f3c923405d9dc")
                .body(gorestPojo)
                .pathParam("userID",userID)
                .when()
                .patch(EndPoints.UPDATE_USER_BY_ID)
                .then();
    }

    @Step("Delete User with ID:{0}")
    public ValidatableResponse deleteUser(int userID) {
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 0f23b136e758c180b7e1e8eae923b96a7a792697594a0925c10f3c923405d9dc")
                .pathParam("userID",userID)
                .when()
                .delete(EndPoints.DELETE_USER_BY_ID)
                .then();
    }
}
