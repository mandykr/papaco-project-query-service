package com.papaco.papacoprojectqueryservice.acceptance;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.Arrays;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class ProjectQuerySteps {
    private static final String PROJECT_ENDPOINT = "/projects";
    private static final String MATE_ENDPOINT = "/mates";
    private static final String REVIEWER_ENDPOINT = "/reviewers";

    public static ExtractableResponse<Response> 프로젝트_목록_조회_요청() {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .queryParam("page", "0")
                .queryParam("size", "10")
                .when().get(PROJECT_ENDPOINT)
                .then().log().all().extract();
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

    public static ExtractableResponse<Response> 사용자의_프로젝트_조회_요청(Long ownerId) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .queryParam("page", "0")
                .queryParam("size", "10")
                .when().get(PROJECT_ENDPOINT + "/owner/" + ownerId)
                .then().log().all().extract();
    }

    public static void 프로젝트_목록_조회됨(ExtractableResponse<Response> response) {
        데이터_목록_조회_검증(response);
    }

    public static ExtractableResponse<Response> 프로젝트_상세_조회_요청(String projectId) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get(PROJECT_ENDPOINT + "/" + projectId)
                .then().log().all().extract();
    }

    public static void 프로젝트_상세_조회됨(ExtractableResponse<Response> response) {
        데이터_상세_조회_검증(response);
    }

    public static ExtractableResponse<Response> 리뷰어_검색_요청(String mateStatus, Long... techStackIds) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("mateStatus", mateStatus);
        params.put("techStackIds", Arrays.asList(techStackIds));

        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .queryParam("page", "0")
                .queryParam("size", "10")
                .body(params)
                .when().get(REVIEWER_ENDPOINT + "/search")
                .then().log().all().extract();
    }

    public static void 리뷰어_목록_조회됨(ExtractableResponse<Response> response) {
        데이터_목록_조회_검증(response);
    }

    public static ExtractableResponse<Response> 리뷰어_상세_조회_요청(long reviewerId) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get(REVIEWER_ENDPOINT + "/" + reviewerId)
                .then().log().all().extract();
    }

    public static void 리뷰어_상세_조회됨(ExtractableResponse<Response> response) {
        데이터_상세_조회_검증(response);
    }

    public static ExtractableResponse<Response> 리뷰어_메이트_이력_조회_요청(long reviewerId) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get(MATE_ENDPOINT + "/reviewers" + "/" + reviewerId + "/reviews")
                .then().log().all().extract();
    }

    public static void 리뷰어_메이트_이력_조회됨(ExtractableResponse<Response> response) {
        데이터_목록_조회_검증(response);
    }

    public static ExtractableResponse<Response> 프로젝트_리뷰_목록_조회_요청(String projectId) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .queryParam("page", "0")
                .queryParam("size", "10")
                .when().get(PROJECT_ENDPOINT + "/" + projectId + "/reviews")
                .then().log().all().extract();
    }

    public static void 프로젝트_리뷰_목록_조회됨(ExtractableResponse<Response> response) {
        데이터_목록_조회_검증(response);
    }

    private static void 데이터_목록_조회_검증(ExtractableResponse<Response> response) {
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.body()).isNotNull();
        assertThatCode(() -> response.body().jsonPath().getList("content"))
                .doesNotThrowAnyException();
        assertThat(response.body().jsonPath().getList("content")).isNotEmpty();
    }

    private static void 데이터_상세_조회_검증(ExtractableResponse<Response> response) {
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.body()).isNotNull();
    }
}
