# 1. Specify a base image with Java installed (use openjdk, which is Java’s official image)
FROM openjdk:latest

# 2. Set the working directory inside the container (Docker will use this folder inside the container)
WORKDIR /app

# 3. Copy HelloWorld.java from your local folder to the /app folder inside the Docker container
COPY HelloWorld.java /app

# 4. Compile HelloWorld.java inside the container
RUN javac HelloWorld.java

# 5. Set the command to run the Java program when the container starts
CMD ["java", "HelloWorld"]
