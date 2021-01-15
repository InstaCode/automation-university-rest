import org.springframework.cloud.contract.spec.Contract
Contract.make {
    description("should return when string is provided as a parameter")
    request {
        method GET()
        url("/api/foo"){
            queryParameters {
                parameter("name", "Jason");
            }
        }
    }
    response {
        body("Hi! This is my friend, Jason!")
        status(200)
    }
}