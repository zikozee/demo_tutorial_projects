TODO
====
- set up project from start.spring.io or inteliij ultimate -- done
- build demo Spring boot Project  - done
- read pod properties in application 
- profiles (local, docker)
- placeholders for k8s to map to environment variables
- set environment variables (show how to set default)
- setup docker file
- create config map on k8s
- create deployment on k8s (3 replicas)from deployment 
- show trick to create service --> expose as NodePort
- use split terminal to show load balancing between replicas



COMMANDS USED

curl XGET http://localhost:60000/tutorial

mvn clean package -DskipTests 
docker build -t demo:1.0 .  

===============
to run in docker
================
docker run --name demo_app -p 60000:8080 -e "SPRING_PROFILE=docker" -e "SERVER_PORT=8080" -e "DEMO_NAME=EZEKIEL EROMOSEI" -e "COMPANY_NAME=INTERSWITCHER" -e "COMPANY_AWESOME=true" -e "COMPANY_URL='https://example.com'" demo:1.0

kubectl scale deployment/nginx-deployment --replicas=10


kubectl explain <OBJECT> --recursive | less
kubectl create configmap demo --from-literal SERVER_PORT=60000 --from-literal DEMO_NAME=ERNEST --from-literal COMPANY_NAME=INTERSWITCHER  --dry-run=client -o yaml
kubectl create -f deployment.yaml


--dry-run=client