set -e
echo "[I] Building JAR"
mvn clean package -DskipTests -f ./void-db-controller/pom.xml
echo "[I] Building images and starting"
docker compose up --build --force-recreate
     
    
