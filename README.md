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

9)until i created the rabbitmq listeners and send controller rabbitmq connection establishment not happening.

10)Embedding a Customer in OrderEntity

In the `OrderEntity` class, we use the `@Embedded` annotation along with `@AttributeOverrides` to embed a `Customer` object within the entity. This allows us to store customer details directly within the `OrderEntity` table.

### Syntax

```java
@Embedded
@AttributeOverrides(
    value = {
        @AttributeOverride(name = "name", column = @Column(name = "customer_name")),
        @AttributeOverride(name = "email", column = @Column(name = "customer_email")),
        @AttributeOverride(name = "phone", column = @Column(name = "customer_phone"))
    }
)

//Here Customer is  a record in another file.

private Customer customer;

public record Customer(
        @NotBlank(message = "Customer Name is required") String name,
        @NotBlank(message = "Customer email is required") @Email String email,
        @NotBlank(message = "Customer Phone number is required") String phone) {}


```

11)Used Instancio

12)@ParameterizedTest in tests

13)Used resilience4j
* Retry
* circuit breakers
* But timeout from restclient only

14)Using wiremock we are mocking the service calling (eg: calling  service A to Service B )

15)Pushing events to Rabbit Mq

16)Using scheduled jobs and locking will come in picture when two or more instances of order service ran.


### Syntax

```java
@Scheduled(cron = "${orders.new-orders-job-cron}")
@SchedulerLock(name = "processNewOrders")
public void publishOrderEvents() {
        LockAssert.assertLocked();
        log.info("Publishing Order Events at {}", Instant.now());
        orderEventService.publishOrderEvents();
        }
```

17)Using MailHog docker image for test mail


18) Not only findBy...(something) this existsBy.. also supports Jpa .
### Syntax

```java
public interface OrderEventRepository extends JpaRepository<OrderEventEntity, Long> {
boolean existsByEventId(String eventId);
}
```

Api content :

post - http://localhost:8082/api/orders
```json
{
"customer" : {
"name": "jitendra",
"email": "jit@gmail.com",
"phone": "999999999"
},
"deliveryAddress" : {
"addressLine1": "test addressLine1",
"addressLine2": "bank-Straße 23",
"city": "rcpm",
"state": "APradesh",
"zipCode": "94258",
"country": "invalid"
},
"items": [
{
"code": "P101",
"name": "Product 2",
"price": 45.40,
"quantity": 1
}
]
}
 ``` 

