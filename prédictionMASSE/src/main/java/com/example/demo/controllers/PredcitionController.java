package com.example.demo.controllers;
	
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.PredictionService;

@RestController

public class PredcitionController {

    @Autowired
    private PredictionService predictionService;

    @PostMapping("/test")
    public String runPythonPredict(@RequestBody RequestData data) throws IOException, InterruptedException {
        float e = data.getEffectif();
        int a = data.getAnnee();
        int d = data.getDepart();
        int r = data.getRecrutement();

        return predictionService.runPythonScript(String.valueOf(e), String.valueOf(a), String.valueOf(d), String.valueOf(r));
    }
}
