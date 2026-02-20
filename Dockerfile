# Use the official Playwright Java image
FROM mcr.microsoft.com/playwright/java:v1.58.0-noble

# Set the working directory
WORKDIR /app

# Copy your project files (pom.xml and src)
COPY . /app

# Install project dependencies and pre-download browsers
# (This avoids re-downloading them every time you run a test)
RUN mvn install -DskipTests

# Run tests by default when the container starts
CMD ["mvn", "test"]