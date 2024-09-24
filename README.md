# DockrMultiContainer
Docker-Multi-Container Application

# SpringBoot::
Create simple spring boot app maven archtype
required dependencys::
- lombok
- spring data jpa
- postgres DB
- spring web

# Docker::
Docker-compose
dockerFile :: configure with multi container app + db and even we can enable multi container with single DB instance

# Docker commands for build and run
docker build -t="docker-multi-container-application" .
docker run -p 8080:8080 -it --rm docker-multi-container-application
docker stop docker-multi-container-application
