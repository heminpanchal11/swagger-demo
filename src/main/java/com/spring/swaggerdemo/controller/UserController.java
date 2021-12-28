package com.spring.swaggerdemo.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.swaggerdemo.model.CommonApiResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(description = "Api for Users", tags = { "User Rest Api" })
public class UserController {

	@ApiOperation(value = "Fetch list of users", response = CommonApiResponse.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 401, message = "UnAuthorized"), @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "User information not found") })
	@GetMapping("/user/list")
	public CommonApiResponse<?> getAllUsers() {
		ArrayList<String> users = new ArrayList<String>();
		users.add("Bill Gates");
		users.add("Steve Jobs");
		users.add("Mark");
		return new CommonApiResponse<>(1, "succussfully fetched user list.", users);
	}

	@ApiOperation(value = "Fetch one user", response = CommonApiResponse.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 401, message = "UnAuthorized"), @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "User information not found") })
	@GetMapping("/user/{id}")
	public CommonApiResponse<?> getOneUser(@PathVariable long id) {
		ArrayList<String> users = new ArrayList<String>();
		users.add("Bill Gates");
		return new CommonApiResponse<>(1, "succussfully fetched user.", users);
	}

	@ApiOperation(value = "Delete one user", response = CommonApiResponse.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 401, message = "UnAuthorized"), @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "User information not found") })
	@DeleteMapping("/user/{id}")
	public CommonApiResponse<?> deleteOneUser(@PathVariable long id) {
		return new CommonApiResponse<>(1, "succussfully deleted user.", null);
	}
	
	@ApiOperation(value = "Update one user", response = CommonApiResponse.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 401, message = "UnAuthorized"), @ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "User information not found") })
	@PatchMapping("/user/{id}")
	public CommonApiResponse<?> updateOneUser(@PathVariable long id) {
		return new CommonApiResponse<>(1, "succussfully deleted user.", null);
	}

}
