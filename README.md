# How to setup this package 

## Requirements
- you have install maven on machine 

## Steps
```xml
<repositories>
  <repository>
    <id>github</id>
    <url>https://maven.pkg.github.com/<YOUR_GITHUB_USERNAME>/<YOUR_REPOSITORY_NAME></url>
  </repository>
</repositories>

<dependencies>
  <dependency>
    <groupId>com.example</groupId> <!-- your groupId -->
    <artifactId>your-artifact-id</artifactId> <!-- your artifactId -->
    <version>1.0.0</version> <!-- your released version -->
  </dependency>
</dependencies>
```

## provide on you .m2 settings.xml file
```xml
<settings>
  <servers>
    <server>
      <id>github</id>
      <username>THEIR_GITHUB_USERNAME</username>
      <password>THEIR_GITHUB_PAT</password>
    </server>
  </servers>
</settings>
```


## Token should be allow to read packages with this permission
Create a new PAT at: https://github.com/settings/tokens (use classic)

Include at least these permissions:

- ☑️ write:packages (this implicitly covers publish and delete)
- ☑️ read:packages
- ☑️ repo (if your repository is private or you're pushing to a repository-bound package)