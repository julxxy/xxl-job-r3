# XXL-JOB-R3

This is the back-end service
for [The third-party React-based web admin panel for XXL-JOB](https://github.com/julxxy/xxl-job-panel-r3), forked
from [XXL-JOB](https://github.com/xuxueli/xxl-job).

## Quick Start

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

```
bash
git clone https://github.com/julxxy/xxl-job-r3.git
cd xxl-job-r3
```

## 5. Build the Project

```
bash
mvn clean package -Dmaven.test.skip=true
```

## 6. Run the Admin Console

Navigate to the `xxl-job-admin` module and start the application:

```
bash
cd xxl-job-admin
mvn spring-boot:run
```

or run the packaged jar:

```
bash
java -jar target/xxl-job-admin-*.jar
```

## 7. Access the Admin Panel

See also:
https://github.com/julxxy/xxl-job-panel-r3

## 8. Version Mapping

This table helps you quickly identify which front-end and back-end versions are compatible. Whenever a major update
occurs on either side, please update this table accordingly for clarity.

|                     **xxl-job-panel-r3** (Front-end)                     |                     **xxl-job-r3** (Back-end)                      | Description                                                                                                                 |
|:------------------------------------------------------------------------:|:------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------------------------------|
| [v1.0.2](https://github.com/julxxy/xxl-job-panel-r3/releases/tag/v1.0.2) | [v3.1.2](https://github.com/julxxy/xxl-job-r3/releases/tag/v3.1.2) | LDAP login supported, menu permission fixes                                                                                 |
| [v1.0.3](https://github.com/julxxy/xxl-job-panel-r3/releases/tag/v1.0.3) | [v3.1.2](https://github.com/julxxy/xxl-job-r3/releases/tag/v3.1.2) | - Added new favicon.svg and multiple SVG icons<br/>- improved LDAP login button styling, enabled logo to redirect to GitHub |

> **How to maintain:**
> Whenever the front-end or back-end receives significant updates, please record the new mapping here. Link each version
> to its corresponding release and summarize the key changes for future reference.

---


For more details, refer to the official [XXL-JOB documentation](https://github.com/xuxueli/xxl-job).



