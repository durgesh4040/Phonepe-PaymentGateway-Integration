package com.Phonpe.Controller;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home() {
        return "form";
    }

    @PostMapping("/process-payment")
    public String paymentsetup() {
        OkHttpClient client = new OkHttpClient();

        // Define the JSON request body
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"request\":\"ewogICJtZXJjaGFudElkIjogIk1FUkNIQU5UVUFUIiwKICAibWVyY2hhbnRUcmFuc2FjdGlvbklkIjogIk1UNzg1MDU5MDA2ODE4ODEwNCIsCiAgIm1lcmNoYW50VXNlcklkIjogIk1VSUQxMjMiLAogICJhbW91bnQiOiAxMDAwMCwKICAicmVkaXJlY3RVcmwiOiAiaHR0cHM6Ly93ZWJob29rLnNpdGUvcmVkaXJlY3QtdXJsIiwKICAicmVkaXJlY3RNb2RlIjogIlJFRElSRUNUIiwKICAiY2FsbGJhY2tVcmwiOiAiaHR0cHM6Ly93ZWJob29rLnNpdGUvY2FsbGJhY2stdXJsIiwKICAibW9iaWxlTnVtYmVyIjogIjk5OTk5OTk5OTkiLAogICJwYXltZW50SW5zdHJ1bWVudCI6IHsKICAgICJ0eXBlIjogIlBBWV9QQUdFIgogIH0KfQ==\"}");

        // Create the HTTP request
        Request request = new Request.Builder()
            .url("https://api-preprod.phonepe.com/apis/pg-sandbox/pg/v1/pay")
            .post(body)
            .addHeader("accept", "application/json")
            .addHeader("Content-Type", "application/json")
            .addHeader("X-VERIFY", "ac125a22bebab87667fae925aa3a046c45e2a7a50e9f6764b5f440d461d1f088###1")
            .build();

        try {
            // Execute the HTTP request
            Response response = client.newCall(request).execute();

            if (response.isSuccessful()) {
                // Parse the JSON response to extract the redirect URL
                String responseBody = response.body().string();
                JSONObject jsonResponse = new JSONObject(responseBody);
                String redirectUrl = jsonResponse.getJSONObject("data")
                    .getJSONObject("instrumentResponse")
                    .getJSONObject("redirectInfo")
                    .getString("url");

                // Redirect the user to the payment server
                return "redirect:" + redirectUrl;
            } else {
                // Handle error response if needed
                // You can return an error page or perform other error handling here
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Return a message or view (e.g., an error message or a success message)
        return "message";
    }
}
