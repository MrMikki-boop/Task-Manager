# 📋Overview

Task Manager – a task management system similar to [http://www.redmine.org/](http://www.redmine.org/). It allows you to
set tasks, assign performers and change their statuses. To work with the system, registration and authentication are
required.

| Badge                | Status ♻                                               |
|----------------------|--------------------------------------------------------|
| 🎏LIVE ON RENDER.COM | [Task Manager](https://task-manager-thwe.onrender.com) |

[Or click here](https://task-manager-thwe.onrender.com/swagger-ui/index.html) if you want to explore an interactive
documentation.

## 📝Hexlet tests and linter status:

| Badge         | Status ♻                                                                                                                                                                           |
|---------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Hexlet        | [![Actions Status](https://github.com/MrMikki-boop/java-project-99/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/MrMikki-boop/java-project-99/actions)         |
| Java CI       | [![Java CI](https://github.com/MrMikki-boop/java-project-99/actions/workflows/JavaCI.yml/badge.svg)](https://github.com/MrMikki-boop/java-project-99/actions/workflows/JavaCI.yml) |
| Linter        | [![Maintainability](https://api.codeclimate.com/v1/badges/75b86ba0d1dd55d4a2bd/maintainability)](https://codeclimate.com/github/MrMikki-boop/java-project-99/maintainability)      |
| Code Coverage | [![Test Coverage](https://api.codeclimate.com/v1/badges/75b86ba0d1dd55d4a2bd/test_coverage)](https://codeclimate.com/github/MrMikki-boop/java-project-99/test_coverage)            |

# 📂How to use

## 🔑Get it

### 💾Clone

1. `git clone https://github.com/MrMikki-boop/java-project-99.git`

### 💻Download

1. Use this [link](https://github.com/MrMikki-boop/java-project-99.git/archive/refs/heads/main.zip)
1. Unpack in any folder you want

#### 💫start

If you want to start this project locally, enter this command:

```bash
make start
```

Then open http://localhost:8080 on your browser and enter admin details:

```
Username: hexlet@example.com
Password: qwerty
```

![First](https://i.postimg.cc/HLbTHF0S/2024-02-22-220651.png)
![Two](https://i.postimg.cc/tRYmxWwb/2024-02-22-220543.png)

- You will find the administration dashboard and can explore all available options such as users, tasks, task statuses
  and labels.

## 📢Stack

### ❗️Requirements

|  Name  | Version |
|:------:|:-------:|
|  Java  |  >= 21  |
| Gradle | >= 8.4  |

### 📑Stack

* Java
* Spring Boot
* Spring Boot Security
* Databases: PostgreSQL, H2
* MapStruct
* JUnit5
* GNU Make
* PaaS Render