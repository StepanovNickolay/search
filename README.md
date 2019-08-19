# Search with Elasticsearch, Angular and Spring Boot

Example of usage Elasticsearch with Angular and Spring Boot.

Backend app fill ES with movies data-set after start and set-up search conditions (fuziness, slop and search fields).

Frontend shows all content and search result.

ES data is not volumed!

## How to run
using docker-compose
```
docker-compose up
```

or invidualy

es
```
docker run -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:6.8.1
```

backend
```
docker build -t search-server:dev  --build-arg JAR_FILE=search-server-1.0.0.jar server
docker run -p 7111:80 search-server
```

frontend
```
docker build -t search-client:dev client 
docker run -p 4200:80 search-client
```
