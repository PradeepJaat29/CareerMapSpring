package com.career.map.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CareerSuggester {

    private final Map<String, String> careerMap;

    public CareerSuggester() {
        careerMap = new HashMap<>();
        careerMap.put("coding", "Software Engineer");
        careerMap.put("design", "UI/UX Designer");
        careerMap.put("analytics", "Data Analyst");
        careerMap.put("hardware", "Embedded Systems Engineer");
        careerMap.put("cybersecurity", "Cybersecurity Analyst");
        careerMap.put("management", "Product Manager");
        // Add more interests as needed
    }

    public String suggestCareer(String interest) {
        return careerMap.getOrDefault(interest.toLowerCase(), "Generalist");
    }
}
