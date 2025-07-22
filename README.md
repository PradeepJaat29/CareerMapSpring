# 🚀 Career Map Generator (Spring Boot)

A futuristic, intuitive Spring Boot web application that suggests tailored career paths based on your interests and goals, and exports a personalized roadmap. Built with a glowing Iron Man-inspired UI for an immersive experience.


---

## 🧠 Features

- 🔍 Suggests personalized career options based on user interests
- 📚 Displays curated resources and roadmaps for various tech careers
- 🧾 Downloads a clean `.txt` roadmap file for offline planning
- 🌐 Futuristic neon-grid UI with animation and smooth UX
- 🧠 Built with Java, Spring Boot, Thymeleaf, and HTML/CSS

---

## 🎯 Tech Stack

| Layer        | Technology                      |
|-------------|----------------------------------|
| Backend      | Spring Boot (Java), MVC Pattern |
| Frontend     | Thymeleaf, HTML5, CSS3          |
| Logic        | Custom CareerSuggester + ResourceLoader classes |
| File Export  | Java I/O (BufferedWriter)       |
| Build Tool   | Maven                           |

---

## 🚦 How it Works

1. User inputs name, interests, and career goal.
2. Backend logic maps interest to career roles (Software Engineer, UI/UX Designer, etc.).
3. Dynamically fetches a relevant resource roadmap.
4. Option to download the roadmap as a `.txt` file.

---

## 📁 Folder Structure

├── src<br>
│   ├── main<br>
│   │   ├── java/com/career/map<br>
│   │   │   ├── controller/CareerController.java<br>
│   │   │   ├── model/CareerInput.java<br>
│   │   │   ├── service/CareerSuggester.java<br>
│   │   │   ├── util/ResourceLoader.java<br>
│   │   │   └── utils/RoadmapExporter.java<br>
│   │   └── resources<br>
│   │       ├── templates (Thymeleaf views)<br>
│   │       ├── static/css/style.css<br>
│   │       └── application.properties<br>
├── roadmap.txt (generated)<br>
├── pom.xml

---

## ✨ Future Scope

- 🧠 AI-driven career predictions (using OpenAI or ML models)
- 📈 Admin panel for updating career resources
- 🌍 User login system for saving roadmaps

---
