package com.papaco.papacoprojectqueryservice.acceptance;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.Arrays;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class ProjectQuerySteps {
    private static final String PROJECT_ENDPOINT = "/projects";
    private static final String MATE_ENDPOINT = "/mates";

    public static ExtractableResponse<Response> 프로젝트_목록_조회_요청() {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .queryParam("page", "0")
                .queryParam("size", "10")
                .when().get(PROJECT_ENDPOINT)
                .then().log().all().extract();
    }

    public static void 프로젝트_목록_조회됨(ExtractableResponse<Response> response) {
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    public static ExtractableResponse<Response> 메이트_리뷰_목록_조회_요청(String mateId) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .queryParam("page", "0")
                .queryParam("size", "10")
                .when().get(MATE_ENDPOINT + "/" + mateId + "/reviews")
                .then().log().all().extract();
    }

    public static void 메이트_리뷰_목록_조회됨(ExtractableResponse<Response> response) {
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    public static ExtractableResponse<Response> 프로젝트_검색_요청(Long... techStackIds) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("techStackIds", Arrays.asList(techStackIds));

        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .queryParam("page", "0")
                .queryParam("size", "10")
                .body(params)
                .when().get(PROJECT_ENDPOINT + "/search")
                .then().log().all().extract();
    }
}
