# springboot-microservices-learning
Understanding spring boot microservices through bookstore project youtube tutorial by sivalabs

New things:

1) Catalog service using postgres from docker compose file.

cmd: docker compose -f infra.yml up -d

2)for swagger Ui added an openapi dependency.

3)Using Flyway db 

4)Different architecture of maintaining controllers are in one package,service and repo are in one package.
i.e provided package protection for ProductEntity by removing public

5)pagination in catalog service logic.

6)Using of Record

7)Using configurationProperties annotation

8)Used testcontainers for testing and a test-data.sql script which will run before every test method
eg:@Sql("/test-data.sql")