# XXL-JOB-R3

[![Docker Pulls](https://img.shields.io/docker/pulls/julxxy/xxl-job-r3?style=flat-square&logo=docker)](https://hub.docker.com/r/julxxy/xxl-job-r3)
[![Docker Image Version](https://img.shields.io/docker/v/julxxy/xxl-job-r3?style=flat-square&logo=docker&sort=semver)](https://hub.docker.com/r/julxxy/xxl-job-r3/tags)
[![Docker Image Size](https://img.shields.io/docker/image-size/julxxy/xxl-job-r3?style=flat-square&logo=docker)](https://hub.docker.com/r/julxxy/xxl-job-r3)
[![GitHub Release](https://img.shields.io/github/v/release/julxxy/xxl-job-r3?style=flat-square&logo=github)](https://github.com/julxxy/xxl-job-r3/releases)

This is the back-end service for [The third-party React-based web admin panel for XXL-JOB](https://github.com/julxxy/xxl-job-panel-r3), forked from [XXL-JOB](https://github.com/xuxueli/xxl-job).

## 🐳 Docker Quick Start

### Pull and Run

```bash
# Pull the latest image
docker pull julxxy/xxl-job-r3:latest

# Quick start with Docker
JAVA_OPTS="-Xmx512m -Xms512m"
SPRING_ARGS="--server.servlet.context-path=/xxl-job-admin \
--spring.datasource.url=jdbc:mysql://your-db-ip:3306/xxl_job \
--spring.datasource.username=root \
--spring.datasource.password=password"

docker run -d --name xxl-job-r3 \
  -p 8080:8080 \
  -e TZ=Asia/Shanghai \
  -e JAVA_OPTS="${JAVA_OPTS}" \
  -e SPRING_ARGS="${SPRING_ARGS}" \
  julxxy/xxl-job-r3:latest
```

### Docker Compose

```yaml
version: '3.8'
services:
  xxl-job-r3:
    image: julxxy/xxl-job-r3:latest
    container_name: xxl-job-r3
    ports:
      - "8081:8080"
    environment:
      SPRING_ARGS: >
        --spring.datasource.url=jdbc:mysql://mysql:3306/xxl_job?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&serverTimezone=Asia/Shanghai
        --spring.datasource.username=root
        --spring.datasource.password=password
        --server.servlet.context-path=/xxl-job-admin
      JAVA_OPTS: "-Xms512m -Xmx1024m"
    volumes:
      - ./logs:/data/logs/xxl-job-r3/
    depends_on:
      - mysql
    restart: unless-stopped

  mysql:
    image: mysql:8.0
    container_name: xxl-job-mysql
    environment:
      MYSQL_ROOT_PASSWORD: password
      MYSQL_DATABASE: xxl_job
    volumes:
      - mysql_data:/var/lib/mysql
      - ./sql:/docker-entrypoint-initdb.d
    ports:
      - "3306:3306"
    restart: unless-stopped

volumes:
  mysql_data:
```

For more deployment options, see [Docker Hub Repository](https://hub.docker.com/r/julxxy/xxl-job-r3).

---

## 🛠️ Development Setup

## 1. JDK

- **Required Version:** JDK 17
- **Recommended:** [AdoptOpenJDK](https://adoptium.net/) or Oracle JDK 17
- **Setup:** Make sure the `JAVA_HOME` environment variable is set correctly and `java -version` outputs 17.x

## 2. Maven Build Tool

- **Required Version:** Maven 3.6 or higher
- **Recommended:** Maven 3.8.x
- **Setup:** Ensure `mvn -v` outputs the correct Maven version information

## 3. Database

- **Type:** MySQL
- **Minimum Version:** MySQL 5.7 or higher (MySQL 8.0+ recommended)
- **JDBC Driver:** `mysql-connector-j` 9.3.0
- **Setup:** Please create the required database for XXL-JOB in advance and import the official SQL scripts

------

## Clone, Build, and Run

## 4. Clone the Repository

```bash
git clone https://github.com/julxxy/xxl-job-r3.git
cd xxl-job-r3
```

## 5. Build the Project

```bash
mvn clean package -Dmaven.test.skip=true
```

## 6. Run the Admin Console

Navigate to the `xxl-job-admin` module and start the application:

```bash
cd xxl-job-admin
mvn spring-boot:run
```

or run the packaged jar:

```bash
java -jar target/xxl-job-admin-*.jar
```

## 7. Access the Admin Panel

See also:
https://github.com/julxxy/xxl-job-panel-r3

## 8. Version Mapping

This table helps you quickly identify which front-end and back-end versions are compatible. Whenever a major update
occurs on either side, please update this table accordingly for clarity.

|                     **xxl-job-panel-r3** (Front-end)                     |                     **xxl-job-r3** (Back-end)                      |      **Docker Image**      | Description                                                                                                                 |
|:------------------------------------------------------------------------:|:------------------------------------------------------------------:|:--------------------------:|:----------------------------------------------------------------------------------------------------------------------------|
| [v1.0.2](https://github.com/julxxy/xxl-job-panel-r3/releases/tag/v1.0.2) | [v3.1.2](https://github.com/julxxy/xxl-job-r3/releases/tag/v3.1.2) | `julxxy/xxl-job-r3:v3.1.2` | LDAP login supported, menu permission fixes                                                                                 |
| [v1.0.3](https://github.com/julxxy/xxl-job-panel-r3/releases/tag/v1.0.3) | [v3.1.2](https://github.com/julxxy/xxl-job-r3/releases/tag/v3.1.2) | `julxxy/xxl-job-r3:v3.1.2` | - Added new favicon.svg and multiple SVG icons<br/>- improved LDAP login button styling, enabled logo to redirect to GitHub |

> **How to maintain:**
> Whenever the front-end or back-end receives significant updates, please record the new mapping here. Link each version
> to its corresponding release and summarize the key changes for future reference.

---

For more details, refer to the official [XXL-JOB documentation](https://github.com/xuxueli/xxl-job).
