package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	/*@Autowired
	private RestTemplate restTemplate;*/
	
	@Autowired
	WebClient.Builder webClientBuilder;

	HttpHeaders headers = new HttpHeaders();
	
	@RequestMapping("/{cid}")
    public Result getCompany(@PathVariable("cid") String cid) {
		/*headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("x-request-id", "COM123");
		headers.set("Authorization", "COM123");
		HttpEntity entity = new HttpEntity(headers);
		ResponseEntity<Company> response = restTemplate.exchange(
				"http://localhost:8084/company/" + cid,
		        HttpMethod.GET,
		        entity,
		        Company.class,
		        1
		);*/
		
		Company response = webClientBuilder.build()
				.get()
				.uri("http://localhost:8084/company/" + cid)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.header("x-request-id", "COM123")
				.header("Authorization", "COM123")
				.retrieve()
				.bodyToMono(Company.class)
				.block();
		
        Data data = response.getData();
        Result company = data.getResult();
        
        return new Result(company.getCompanyId(), company.getCompanyName(), company.getCompanyEmail(), company.getCompanyLogo(), company.getCompanyProfile(), company.getHiringForBranches());

    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addCompany(@RequestBody Result addCompanyDetails) {
		/*headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("x-request-id", "COM123");
		headers.set("Authorization", "COM123");
		HttpEntity entity = new HttpEntity(addCompanyDetails, headers);
		Result company = restTemplate.postForObject(
				"http://localhost:8084/company/add",
		        entity,
		        Result.class
		);*/
		Result company = webClientBuilder.build()
				.post()
				.uri("http://localhost:8084/company/add")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.header("x-request-id", "COM123")
				.header("Authorization", "COM123")
				.body(Mono.just(addCompanyDetails), Result.class)
				.retrieve()
				.bodyToMono(Result.class)
				.block();
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void updateCompanyDetails(@RequestBody Result updateCompanyDetails) {
		/*headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("x-request-id", "COM123");
		headers.set("Authorization", "COM123");
		HttpEntity entity = new HttpEntity(updateCompanyDetails, headers);
		restTemplate.put("http://localhost:8084/company/update", entity);*/
		
		Result company = webClientBuilder.build()
				.put()
				.uri("http://localhost:8084/company/update")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.header("x-request-id", "COM123")
				.header("Authorization", "COM123")
				.body(Mono.just(updateCompanyDetails), Result.class)
				.retrieve()
				.bodyToMono(Result.class)
				.block();
	}
	
	@RequestMapping(value="/delete/{cid}", method = RequestMethod.DELETE)
	public void deleteCompany(@PathVariable("cid") String cid) {
		/*headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("x-request-id", "COM123");
		headers.set("Authorization", "COM123");
		HttpEntity entity = new HttpEntity(headers);
		restTemplate.exchange(
				"http://localhost:8084/company/delete/" + cid,
		        HttpMethod.DELETE,
		        entity,
		        Void.class
		);*/
		Void company = webClientBuilder.build()
				.delete()
				.uri("http://localhost:8084/company/delete/" + cid)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.header("x-request-id", "COM123")
				.header("Authorization", "COM123")
				.retrieve()
				.bodyToMono(Void.class)
				.block();
	}
}
