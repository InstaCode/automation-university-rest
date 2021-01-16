package contracts

import org.springframework.cloud.contract.spec.Contract
Contract.make {
    description("should return an error when string is empty")
    request {
        method GET()
        url("/api/foo/"){
        }
    }
    response {
        status(500)
    }
}