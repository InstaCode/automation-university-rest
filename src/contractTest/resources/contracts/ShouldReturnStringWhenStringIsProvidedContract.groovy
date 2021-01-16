package contracts

import org.springframework.cloud.contract.spec.Contract
Contract.make {
    description("should return when string is provided as a parameter")
    request {
        method GET()
        url("/api/foo/Jason"){
        }
    }
    response {
        body("Hi! This is my friend, Jason!")
        status(200)
    }
}