package edu.badpals;


import static io.restassured.RestAssured.given;

import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@QuarkusTest
public class ResourcesTest {

    @Inject
    EntityManager em;

    @Inject
    Resource resources;

}