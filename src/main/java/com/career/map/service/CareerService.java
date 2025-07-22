package com.career.map.service;

import com.career.map.model.CareerInput;
import com.career.map.util.ResourceLoader;
import com.career.map.utils.RoadmapExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CareerService {

    private final ResourceLoader resourceLoader;
    private final RoadmapExporter roadmapExporter;

    @Autowired
    public CareerService(ResourceLoader resourceLoader, RoadmapExporter roadmapExporter) {
        this.resourceLoader = resourceLoader;
        this.roadmapExporter = roadmapExporter;
    }

    public Map<String, Object> generateRoadmap(CareerInput input) {
        String career = resourceLoader.getCareerFromInterest(input.getInterest());
        String[] resources = resourceLoader.getResourcesForCareer(career);

        Map<String, Object> roadmap = new HashMap<>();
        roadmap.put("name", input.getName());
        roadmap.put("suggestedCareer", career);
        roadmap.put("goal", input.getGoal());
        roadmap.put("resources", resources);

        // Export the roadmap (optional - depends on your use case)
        roadmapExporter.exportRoadmap(input.getName(), career, input.getGoal(), resources);

        return roadmap;
    }
}
