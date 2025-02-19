# Setup

build.gradle:
```
repositories {
	maven { url = "https://api.modrinth.com/maven" }
}

dependencies {
	modImplementation "maven.modrinth:trash-lib:${project.trashlib_version}"
}
```

gradle.properties:
```
trashlib_version = (Replace this with a version of trashlib... you can find versions at https://modrinth.com/mod/trash-lib/versions.)
```
