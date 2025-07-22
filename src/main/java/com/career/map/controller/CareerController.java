package com.career.map.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.career.map.service.CareerSuggester;
import com.career.map.util.ResourceLoader;
import com.career.map.utils.RoadmapExporter;



@Controller
public class CareerController {

    @Autowired
    private CareerSuggester careerSuggester;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private RoadmapExporter roadmapExporter;

    @GetMapping("/")
    public String showForm() {
        return "form";
    }


    @PostMapping("/submit")
    public String processForm(
            @RequestParam("name") String name,
            @RequestParam("interest") String interest,
            @RequestParam("goal") String goal,
            Model model
    ) {
        String career = careerSuggester.suggestCareer(interest.trim());
        List<String> resources = Arrays.asList(resourceLoader.getResourcesForCareer(career));

        // Save to roadmap.txt
        roadmapExporter.exportRoadmap(name, career, goal, resources.toArray(new String[0]));


        // Pass data to Thymeleaf result page
        model.addAttribute("name", name);
        model.addAttribute("career", career);
        model.addAttribute("goal", goal);
        model.addAttribute("resources", resources);

        return "result";
    }


    @GetMapping("/download")
    public ResponseEntity<Resource> downloadRoadmap() {
        try {
            Path filePath = Paths.get("export/roadmap.txt").toAbsolutePath();
            Resource fileResource = new UrlResource(filePath.toUri());

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=career-roadmap.txt")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(fileResource);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
