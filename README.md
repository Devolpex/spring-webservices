# 🏨 Spring WebServices Lab - Hotel Management System

This project is a comprehensive **Spring Boot Application** that demonstrates the implementation of **four different web service technologies** for a hotel management system. It serves as a practical lab to test and compare REST, GraphQL, gRPC, and SOAP web services in a real-world scenario.

## 🎯 Project Overview

This hotel management system provides APIs for managing:
- **Clients** (Hotel guests)
- **Chambres** (Hotel rooms)
- **Reservations** (Booking management)

Each entity is exposed through all four web service technologies, allowing you to compare their implementation, performance, and usage patterns.

## 🏗️ Architecture & Technologies

### Core Technologies
- **Java 21**
- **Spring Boot 3.4.0**
- **Spring Data JPA**
- **PostgreSQL 15**
- **Maven**

### Web Services Implemented
- 🌐 **REST API** (Spring Web)
- 🔍 **GraphQL** (Spring GraphQL)
- ⚡ **gRPC** (Google RPC)
- 📡 **SOAP** (Apache CXF)

### DevOps & Monitoring
- **Docker & Docker Compose**
- **Prometheus** (Metrics)
- **Grafana** (Visualization)
- **Loki** (Logging)
- **Tempo** (Tracing)
- **Zipkin** (Distributed Tracing)
- **Jenkins** (CI/CD)

## 📋 Entities & Data Model

### 1. **Client** (Hotel Guest)
```java
@Entity
public class Client {
    private Long id;
    private String nom;        // Last name
    private String prenom;     // First name
    private String email;      // Email address
    private String telephone;  // Phone number
    private List<Reservation> reservations; // Associated reservations
}
```

### 2. **Chambre** (Hotel Room)
```java
@Entity
public class Chambre {
    private Long id;
    private String type;       // Room type (simple, double, suite)
    private Double prix;       // Price per night
    private Boolean disponible; // Availability status
    private List<Reservation> reservations; // Associated reservations
}
```

### 3. **Reservation** (Booking)
```java
@Entity
public class Reservation {
    private Long id;
    private Client client;     // Associated client
    private Chambre chambre;   // Associated room
    private LocalDate dateDebut; // Check-in date
    private LocalDate dateFin;   // Check-out date
    private String preferences;  // Special preferences
}
```

## 🚀 Quick Start

### Prerequisites
- Java 21+
- Maven 3.6+
- Docker & Docker Compose
- PostgreSQL (or use Docker)

### 1. Clone and Setup
```bash
git clone <repository-url>
cd spring-webservices
```

### 2. Run with Docker Compose (Recommended)
```bash
# Start all services (Database, Backend, Monitoring)
docker-compose up -d

# Check services status
docker-compose ps
```

### 3. Manual Setup (Alternative)
```bash
# Start PostgreSQL
docker run -d --name postgres-hotel \
  -e POSTGRES_DB=hotel_db \
  -e POSTGRES_USER=user \
  -e POSTGRES_PASSWORD=password \
  -p 5432:5432 postgres:15

# Build and run the application
cd backend
mvn clean install
mvn spring-boot:run
```

## 🌐 API Endpoints & Services

### REST API (Port 8080)
Base URL: `http://localhost:8080`

#### Client Management
```bash
# Get all clients
GET /api/clients/list

# Get client by ID
GET /api/clients/{id}

# Create new client
POST /api/clients/create
Content-Type: application/json
{
  "nom": "Doe",
  "prenom": "John",
  "email": "john.doe@email.com",
  "telephone": "+1234567890"
}

# Update client
PUT /api/clients/update/{id}
Content-Type: application/json
{
  "nom": "Updated Name",
  "prenom": "Updated First",
  "email": "updated@email.com",
  "telephone": "+0987654321"
}

# Delete client
DELETE /api/clients/delete/{id}
```

#### Room Management
```bash
# Get all rooms
GET /api/chambres/list

# Get room by ID
GET /api/chambres/{id}

# Create new room
POST /api/chambres/create
Content-Type: application/json
{
  "type": "double",
  "prix": 150.0,
  "disponible": true
}

# Update room
PUT /api/chambres/update/{id}

# Delete room
DELETE /api/chambres/delete/{id}
```

#### Reservation Management
```bash
# Get all reservations
GET /api/reservations/list

# Get reservation by ID
GET /api/reservations/{id}

# Create new reservation
POST /api/reservations/create
Content-Type: application/json
{
  "clientId": 1,
  "chambreId": 1,
  "dateDebut": "2024-01-15",
  "dateFin": "2024-01-18",
  "preferences": "Non-smoking room"
}

# Update reservation
PUT /api/reservations/update/{id}

# Delete reservation
DELETE /api/reservations/delete/{id}
```

### GraphQL API (Port 8080)
GraphQL Playground: `http://localhost:8080/graphiql`

#### Queries
```graphql
# Get all clients
query {
  fetchListClients {
    id
    nom
    prenom
    email
    telephone
    reservations {
      id
      dateDebut
      dateFin
    }
  }
}

# Get client by ID
query {
  fetchClientById(id: "1") {
    id
    nom
    prenom
    email
    telephone
  }
}

# Get paginated clients
query {
  fetchPageClients(page: 0, size: 10, sortBy: "nom", orderBy: "ASC") {
    content {
      id
      nom
      prenom
    }
    totalElements
    totalPages
  }
}

# Get reservations
query {
  getReservationsList {
    id
    dateDebut
    dateFin
    preferences
    client {
      nom
      prenom
    }
    chambre {
      type
      prix
    }
  }
}
```

#### Mutations
```graphql
# Create client
mutation {
  createClient(input: {
    nom: "Smith"
    prenom: "Jane"
    email: "jane.smith@email.com"
    telephone: "+1234567890"
  }) {
    id
    nom
    prenom
    email
  }
}

# Update client
mutation {
  updateClient(id: "1", input: {
    nom: "Updated Smith"
    prenom: "Jane"
    email: "jane.updated@email.com"
    telephone: "+1234567890"
  }) {
    id
    nom
    prenom
    email
  }
}

# Delete client
mutation {
  deleteClient(id: "1")
}

# Create reservation
mutation {
  createReservation(input: {
    clientId: 1
    chambreId: 1
    dateDebut: "2024-01-15"
    dateFin: "2024-01-18"
    preferences: "Non-smoking room"
  }) {
    id
    dateDebut
    dateFin
    preferences
  }
}
```

### gRPC API (Port 9000)
Protocol Buffers definitions in `src/main/resources/proto/`

#### Client Service
```protobuf
service ClientService {
    rpc FetchClientList (GetClientsListREQ) returns (GetClientsListRES);
    rpc FetchClientPage (GetClientPageREQ) returns (GetClientPageRES);
    rpc FetchClientById (GetClientByIdREQ) returns (GetClientByIdRES);
    rpc CreateClient (ClientREQ) returns (ClientRES);
    rpc UpdateClient (UpdateClientREQ) returns (ClientRES);
    rpc DeleteClient (DeleteClientREQ) returns (google.protobuf.Empty);
}
```

#### Reservation Service
```protobuf
service ReservationService {
    rpc FetchReservationList (GetReservationsListREQ) returns (GetReservationsListRES);
    rpc FetchReservationPage (GetReservationPageREQ) returns (GetReservationPageRES);
    rpc FetchReservationById (GetReservationByIdREQ) returns (GetReservationByIdRES);
    rpc CreateReservation (ReservationREQ) returns (ReservationRES);
    rpc UpdateReservation (UpdateReservationREQ) returns (ReservationRES);
    rpc DeleteReservation (DeleteReservationREQ) returns (google.protobuf.Empty);
}
```

### SOAP API (Port 8080)
SOAP endpoints available at:
- `http://localhost:8080/services/clientService`
- `http://localhost:8080/services/chambreService`
- `http://localhost:8080/services/reservationService`

#### Example SOAP Request (Create Client)
```xml
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
  <soap:Body>
    <ns2:createClient xmlns:ns2="http://controllers.client.backend.devolpex.org/">
      <arg0>
        <nom>Doe</nom>
        <prenom>John</prenom>
        <email>john.doe@email.com</email>
        <telephone>+1234567890</telephone>
      </arg0>
    </ns2:createClient>
  </soap:Body>
</soap:Envelope>
```

## 📊 Monitoring & Observability

### Access Points
- **Grafana Dashboard**: http://localhost:3000
- **Prometheus Metrics**: http://localhost:9090
- **Application Metrics**: http://localhost:8090/actuator/prometheus
- **Health Check**: http://localhost:8090/actuator/health
- **Application Info**: http://localhost:8090/actuator/info

### Available Metrics
- HTTP request metrics
- Database connection metrics
- JVM metrics
- Custom business metrics
- Distributed tracing with Zipkin

## 📚 API Documentation

### Swagger/OpenAPI
- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **API Docs**: http://localhost:8080/v3/api-docs

### GraphQL Schema
- **GraphiQL Playground**: http://localhost:8080/graphiql
- Schema files: `src/main/resources/graphql/`

## 🔧 Configuration

### Application Properties
Key configurations in `application.yml`:
- **Server Port**: 8080 (REST/SOAP/GraphQL)
- **gRPC Port**: 9000
- **Actuator Port**: 8090
- **Database**: PostgreSQL on localhost:5432
- **CORS**: Enabled for frontend integration

## 🏗️ Project Structure

```
spring-webservices/
├── backend/
│   ├── src/main/java/org/devolpex/backend/
│   │   ├── client/           # Client entity & services
│   │   │   ├── controllers/  # REST, GraphQL, gRPC, SOAP
│   │   │   ├── dto/         # Data Transfer Objects
│   │   │   └── ...
│   │   ├── chambre/         # Room entity & services
│   │   ├── reservation/     # Reservation entity & services
│   │   ├── config/          # Configuration classes
│   │   ├── handler/         # Exception handling
│   │   └── utils/           # Utility classes
│   ├── src/main/resources/
│   │   ├── graphql/         # GraphQL schema files
│   │   ├── proto/           # Protocol Buffer definitions
│   │   └── application.yml  # Configuration
│   └── pom.xml              # Maven dependencies
├── docker/                  # Docker configurations
├── compose.yml              # Docker Compose setup
└── README.md               # This file
```

## 🚀 Deployment

### Docker Deployment
```bash
# Build and start all services
docker-compose up -d

# View logs
docker-compose logs -f backend

# Stop services
docker-compose down
```

## 📝 Lab Objectives

This project serves as a comprehensive lab to:

1. **Compare Web Service Technologies**
   - Understand the differences between REST, GraphQL, gRPC, and SOAP
   - Analyze performance characteristics
   - Evaluate use cases for each technology

2. **Spring Boot Integration**
   - Learn Spring Boot best practices
   - Implement multiple web service types in one application
   - Understand dependency injection and configuration

3. **DevOps Practices**
   - Containerization with Docker
   - Monitoring and observability
   - CI/CD with Jenkins
   - Infrastructure as Code

4. **Database Integration**
   - JPA/Hibernate with PostgreSQL
   - Entity relationships and mapping
   - Database migrations and initialization

## 🐛 Troubleshooting

### Common Issues

1. **Port Conflicts**
   ```bash
   # Check if ports are in use
   netstat -tulpn | grep :8080
   # Kill process if needed
   sudo kill -9 <PID>
   ```

2. **Database Connection Issues**
   ```bash
   # Check PostgreSQL status
   docker-compose logs postgresql
   # Restart database
   docker-compose restart postgresql
   ```

3. **gRPC Compilation Issues**
   ```bash
   # Clean and rebuild
   mvn clean compile
   # Check proto files syntax
   ```

---

**Happy Coding! 🚀**

For questions or issues, please check the troubleshooting section or create an issue in the repository.
