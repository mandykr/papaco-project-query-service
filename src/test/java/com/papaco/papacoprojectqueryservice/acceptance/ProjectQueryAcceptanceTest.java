package com.papaco.papacoprojectqueryservice.acceptance;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.papaco.papacoprojectqueryservice.acceptance.ProjectQuerySteps.*;

class ProjectQueryAcceptanceTest extends AcceptanceTest {


    @DisplayName("프로젝트 목록을 조회한다")
    @Test
    void projects() {
        ExtractableResponse<Response> response = 프로젝트_목록_조회_요청();
        프로젝트_목록_조회됨(response);
    }

    @DisplayName("기술 스택으로 프로젝트를 검색한다")
    @Test
    void search_projects() {
        ExtractableResponse<Response> response = 프로젝트_검색_요청(3L, 4L);
        프로젝트_목록_조회됨(response);
    }

    @DisplayName("사용자의 프로젝트 내역을 조회한다")
    @Test
    void project_histories() {
        ExtractableResponse<Response> response = 사용자의_프로젝트_조회_요청(1L);
        프로젝트_목록_조회됨(response);
    }

    @DisplayName("프로젝트 상세 정보를 조회한다")
    @Test
    void project_details() {
        ExtractableResponse<Response> response = 프로젝트_상세_조회_요청("c387663b-eebb-41f0-88ee-ab50ca824022");
        프로젝트_상세_조회됨(response);
    }

    @DisplayName("리뷰어 목록을 조회한다")
    @Test
    void reviewers() {

    }

    @DisplayName("리뷰어 상세 정보를 조회한다")
    @Test
    void reviewer() {

    }

    @DisplayName("메이트의 리뷰 목록을 조회한다")
    @Test
    void mate_reviews() {
        ExtractableResponse<Response> response = 메이트_리뷰_목록_조회_요청("b061adb9-76a1-484b-beab-4f8cf4d7e798");
        메이트_리뷰_목록_조회됨(response);
    }

    @DisplayName("프로젝트의 리뷰 목록을 조회한다")
    @Test
    void reviews() {

    }

    @DisplayName("사용자의 리뷰 내역을 조회한다")
    @Test
    void review_histories() {

    }
}
