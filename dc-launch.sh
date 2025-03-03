set -e
echo "[I] Building JARs"
mvn clean package -DskipTests -f ./void-db-users/pom.xml
mvn clean package -DskipTests -f ./void-gate/pom.xml
echo "[I] Building images and starting"
docker compose up --build --force-recreate
     
    
