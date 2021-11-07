#Scholarship Project

##Start the mysql server
mysql.server start
docker build -t scholarship .
docker run -p 3050:3000 scholarship
docker login --username=narendrakareli
docker images
docker tag d94698199328 narendrakareli/scholarship

docker push narendrakareli/scholarship

kubectl apply -f mysql-configmap.yml

kubectl apply -f mysql-admin-secrets.yml

kubectl apply -f mysql-users-secrets.yml

kubectl apply -f mysql-deployment.yml

kubectl apply -f student-deployment.yml