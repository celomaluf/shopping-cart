package br.com.shoppingCart.framework.controller;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
/**
 * @author Marcelo Maluf Teixeira
 *
 */
public abstract class BaseController {
	
    protected static final String JSON_API_CONTENT_HEADER = "Content-type=application/json";

    @SuppressWarnings("resource")
	public String extractPostRequestBody(HttpServletRequest request) throws IOException {
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            Scanner s = new Scanner(request.getInputStream(), "UTF-8").useDelimiter("\\A");
            return s.hasNext() ? s.next() : "";
        }
        return "";
    }

    public JSONObject parseJSON(String object) {
        return new JSONObject(object);
    }
}
