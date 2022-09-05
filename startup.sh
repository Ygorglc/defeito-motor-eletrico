echo "Clone Git"
git pull origin main

echo "Gradle Build"
./gradlew bootJar

echo "Build Image"
docker build -t defeito-motor-eletrico:0.1 .

echo "Run"
docker-compose up -d --build