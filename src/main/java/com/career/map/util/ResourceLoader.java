package com.career.map.util;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ResourceLoader {

    private final Map<String, List<String>> resourceMap;

    public ResourceLoader() {
        resourceMap = new HashMap<>();

        resourceMap.put("Software Engineer", Arrays.asList(
                "Learn Java or Python from freeCodeCamp",
                "Build 2–3 projects on GitHub",
                "Read 'Clean Code' by Robert C. Martin",
                "Practice DSA on LeetCode"
        ));
        resourceMap.put("UI/UX Designer", Arrays.asList(
                "Master Figma or Adobe XD",
                "Study design systems like Material UI",
                "Read 'Don't Make Me Think' by Steve Krug",
                "Build a Behance/Dribbble portfolio"
        ));
        resourceMap.put("Data Analyst", Arrays.asList(
                "Master Excel, SQL, and Power BI",
                "Take Google Data Analytics course (Coursera)",
                "Practice Kaggle datasets",
                "Build dashboards and reports"
        ));
        resourceMap.put("Cybersecurity Analyst", Arrays.asList(
                "Learn Networking & Linux basics",
                "Take TryHackMe or HackTheBox beginner paths",
                "Understand OWASP Top 10",
                "Build a mini SOC lab with Splunk"
        ));
        resourceMap.put("Embedded Systems Engineer", Arrays.asList(
                "Master C/C++ and Microcontroller Programming",
                "Study Arduino/Raspberry Pi projects",
                "Understand RTOS and IoT Basics",
                "Do a project on real-time monitoring"
        ));
        resourceMap.put("Product Manager", Arrays.asList(
                "Learn Agile, Scrum, and Product Lifecycle",
                "Understand market/user research",
                "Use tools like Jira, Notion, Trello",
                "Read 'Inspired' by Marty Cagan"
        ));
        // Fallback
        resourceMap.put("Generalist", Arrays.asList(
                "Explore multiple career paths",
                "Take personality and aptitude tests",
                "Attend webinars and workshops",
                "Talk to mentors across domains"
        ));
    }

    public String getCareerFromInterest(String interest) {
        interest = interest.toLowerCase();

        if (interest.contains("code") || interest.contains("software")) return "Software Engineer";
        if (interest.contains("design") || interest.contains("ui")) return "UI/UX Designer";
        if (interest.contains("data") || interest.contains("analytics")) return "Data Analyst";
        if (interest.contains("security") || interest.contains("hacking")) return "Cybersecurity Analyst";
        if (interest.contains("electronics") || interest.contains("hardware")) return "Embedded Systems Engineer";
        if (interest.contains("manage") || interest.contains("business")) return "Product Manager";

        return "Generalist";
    }

    public String[] getResourcesForCareer(String career) {
        return resourceMap.getOrDefault(career, List.of("No resources found."))
                .toArray(new String[0]);
    }
}
