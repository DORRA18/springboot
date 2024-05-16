package com.example.demo.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;
@Service
public class PredictionService {
	public String runPythonScript(String effectif, String annee, String depart, String recrutement) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("python", "C:\\Users\\dorra\\OneDrive\\Documents\\python\\test.py");
        processBuilder.command().add(effectif);
        processBuilder.command().add(annee);
        processBuilder.command().add(depart);
        processBuilder.command().add(recrutement);
        Process p = processBuilder.start();
        InputStream inputStream = p.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder output = new StringBuilder();
        String result;

        while ((result = reader.readLine()) != null) {
            output.append(result).append("\n");
        }

        int exitCode = p.waitFor();
        if (exitCode == 0) {
            return output.toString();
        } else {
            return null;
        }
    }
    
    public static String s;
    
    public static void main(String[] args) throws IOException {
        
        String pathPython = "C:\\Users\\dorra\\OneDrive\\Documents\\python\\test.py";
        String [] cmd = new String[6]; // Modifiez la taille du tableau cmd
        cmd[0] = "python";
        cmd[1] = pathPython;
        cmd[2] = "Effectif"; // Argument 1
        cmd[3] = "Année";    // Argument 2
        cmd[4] = "Départ";   // Argument 3
        cmd[5] = "Recrutement"; // Argument 4
        Runtime r = Runtime.getRuntime();
        
        Process p = r.exec(cmd);
        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while((s=in.readLine()) != null){
            System.out.println(s);
        }
    }
}




