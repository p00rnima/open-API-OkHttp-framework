package com.openapi.fcds.test.steps.api.swapi;
import com.openapi.fcds.test.client.http.GenericHttpClient;
import com.openapi.fcds.test.message.http.HttpResponseMessage;
import com.openapi.fcds.test.pojo.openapi.response.Result;
import com.openapi.fcds.test.pojo.openapi.response.SinglePersonDetails;
import com.openapi.fcds.test.pojo.openapi.response.SwapiAllPeopleDetails;
import com.openapi.fcds.test.steps.AbstractApiBase;
import com.openapi.fcds.test.util.HttpAssertHelper;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

import static com.openapi.fcds.test.util.JsonObject.jsonToObject;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class SwapiRequestSteps extends AbstractApiBase {

    private HttpResponseMessage httpResponseMessage;
    private final static Logger LOGGER = LoggerFactory.getLogger(SwapiRequestSteps.class);

    public HttpResponseMessage getHttpResponseMessage() {
        return httpResponseMessage;
    }

    public void setHttpResponseMessage(HttpResponseMessage httpResponseMessage) {
        this.httpResponseMessage = httpResponseMessage;
    }

    @When("^a user gets single person details from swapi with id (.*)$")
    public void aUserGetsSinglePersonDetailsFromSwapi(String peopleId) {
        httpResponseMessage = swapiRequestRestClient.getSinglePersonDetails(peopleId);
        HttpAssertHelper.assertHttpStatusAsOk(httpResponseMessage);
        commonData.singlePersonDetails = jsonToObject(
                httpResponseMessage.getPayload(), SinglePersonDetails.class);
    }

    @Then("^user verifies the people details$")
    public void userVerifiesThePeopleDetails(DataTable dataTable) {
        dataTable.getPickleRows().stream().skip(1)
                .forEach(dataTableRow -> {
                    var name = dataTableRow.getCells().get(0).getValue();
                    var height = dataTableRow.getCells().get(1).getValue();
                    var mass = dataTableRow.getCells().get(2).getValue();
                    var hairColor = dataTableRow.getCells().get(3).getValue();
                    var skinColor = dataTableRow.getCells().get(4).getValue();
                    var eyeColor = dataTableRow.getCells().get(5).getValue();
                    var birthYear = dataTableRow.getCells().get(6).getValue();
                    var gender = dataTableRow.getCells().get(7).getValue();

                    assertThat(commonData.singlePersonDetails.getName())
                            .as("People name doesn't match!")
                            .isEqualTo(name);
                    assertThat(commonData.singlePersonDetails.getHeight())
                            .as("People height doesn't match!")
                            .isEqualTo(height);
                    assertThat(commonData.singlePersonDetails.getMass())
                            .as("People mass doesn't match!")
                            .isEqualTo(mass);
                    assertThat(commonData.singlePersonDetails.getHairColor())
                            .as("People hairColor doesn't match!")
                            .isEqualTo(hairColor);
                    assertThat(commonData.singlePersonDetails.getSkinColor())
                            .as("People skinColor doesn't match!")
                            .isEqualTo(skinColor);
                    assertThat(commonData.singlePersonDetails.getEyeColor())
                            .as("People eyeColor doesn't match!")
                            .isEqualTo(eyeColor);
                    assertThat(commonData.singlePersonDetails.getBirthYear())
                            .as("People birthYear doesn't match!")
                            .isEqualTo(birthYear);
                    assertThat(commonData.singlePersonDetails.getGender())
                            .as("People gender doesn't match!")
                            .isEqualTo(gender);
                });
    }

    @When("^a user gets all the people details list$")
    public void aUserGetsAllThePeopleDetailsList() {
        httpResponseMessage = swapiRequestRestClient.getAllPeopleDetails();
        HttpAssertHelper.assertHttpStatusAsOk(httpResponseMessage);
        commonData.swapiAllPeopleDetails = jsonToObject(
                httpResponseMessage.getPayload(), SwapiAllPeopleDetails.class);

    }

    @Then("^user verifies the given person details$")
    public void userVerifiesTheGivenPersonDetails(DataTable dataTable) {
        dataTable.getPickleRows().stream().skip(1)
                .forEach(dataTableRow -> {
                    var name = dataTableRow.getCells().get(0).getValue();
                    var eyeColor = dataTableRow.getCells().get(1).getValue();

                    List<Result> peopleDetailsList = commonData.swapiAllPeopleDetails.getResults();
                    assertPeopleDetails(name, eyeColor, peopleDetailsList);
                });
    }

    private void assertPeopleDetails(String name, String peopleFeature, List<Result> peopleDetailsList) {
        Optional<String> getGivenPeopleEyeColor = peopleDetailsList.stream()
                .filter(f -> f.getName().equals(name))
                .map(Result::getEyeColor)
                .findFirst();

        if (getGivenPeopleEyeColor.isEmpty()) {
            throw new RuntimeException("Value for " + peopleFeature + " not found in response");
        } else {
            getGivenPeopleEyeColor.ifPresent(
                    value -> assertThat(value).isEqualTo(peopleFeature));
        }
    }
}